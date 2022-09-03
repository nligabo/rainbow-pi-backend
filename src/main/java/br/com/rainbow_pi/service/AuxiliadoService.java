package br.com.rainbow_pi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rainbow_pi.adapter.DozerConverter;
import br.com.rainbow_pi.domain.entity.Auxiliado;
import br.com.rainbow_pi.domain.vo.v1.AuxiliadoVO;
import br.com.rainbow_pi.exception.ResourceNotFoundException;
import br.com.rainbow_pi.repository.AuxiliadoRepository;

@Service
public class AuxiliadoService {

	@Autowired
	AuxiliadoRepository repository;
	
	public AuxiliadoVO inserir(AuxiliadoVO auxiliado) {
		var entity = DozerConverter.parseObject(auxiliado, Auxiliado.class);
		var vo = DozerConverter.parseObject(repository.save(entity), AuxiliadoVO.class);
		return vo;
	}
	
	public List<AuxiliadoVO> buscarTodos(){
		return DozerConverter.parseListObject(repository.findAll(), AuxiliadoVO.class);
	}
	
	public AuxiliadoVO buscarPorId(Long id) {
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado registro com esse ID"));
		return DozerConverter.parseObject(entity, AuxiliadoVO.class);
	}
	
	public AuxiliadoVO atualizar(AuxiliadoVO auxiliado) {
		var entity = repository.findById(auxiliado.getKey())
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado registro com esse Id"));
		entity.setNome(auxiliado.getNome());
		entity.setCpf(auxiliado.getCpf());
		entity.setTipoDeAjuda(auxiliado.getTipoDeAjuda());
		entity.setEmail(auxiliado.getEmail());
		entity.setDataNasc(auxiliado.getDataNasc());
		
		var vo = DozerConverter.parseObject(repository.save(entity), AuxiliadoVO.class);
		return vo;
	}
	
	public void delete(Long id) {
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado registro com esse Id"));
		repository.delete(entity);
	}
}
