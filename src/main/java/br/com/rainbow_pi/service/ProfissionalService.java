package br.com.rainbow_pi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rainbow_pi.adapter.DozerConverter;
import br.com.rainbow_pi.domain.entity.Profissional;
import br.com.rainbow_pi.domain.vo.v1.ProfissionalVO;
import br.com.rainbow_pi.exception.ResourceNotFoundException;
import br.com.rainbow_pi.repository.ProfissionalRepository;


@Service
public class ProfissionalService {

	@Autowired
	ProfissionalRepository repository;
	
	public ProfissionalVO inserir(ProfissionalVO profissional) {
		var entity = DozerConverter.parseObject(profissional, Profissional.class);
		var vo = DozerConverter.parseObject(repository.save(entity), ProfissionalVO.class);
		return vo;
	}
	
	public List<ProfissionalVO> buscarTodos(){
		return DozerConverter.parseListObject(repository.findAll(), ProfissionalVO.class);
	}
	
	public ProfissionalVO buscarPorId(Long id) {
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado registro com esse ID"));
		return DozerConverter.parseObject(entity, ProfissionalVO.class);
	}
	
	public ProfissionalVO atualizar(ProfissionalVO profissional) {
		var entity = repository.findById(profissional.getKey())
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado registro com esse Id"));
		entity.setNome(profissional.getNome());
		entity.setCpf(profissional.getCpf());
		entity.setProfissao(profissional.getProfissao());
		entity.setEmail(profissional.getEmail());
		entity.setRegistroProfissional(profissional.getRegistroProfissional());
		
		var vo = DozerConverter.parseObject(repository.save(entity), ProfissionalVO.class);
		return vo;
	}
	
	public void delete(Long id) {
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado registro com esse Id"));
		repository.delete(entity);
	}
	

}
