package br.com.rainbow_pi.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.rainbow_pi.domain.vo.v1.ProfissionalVO;
import br.com.rainbow_pi.service.ProfissionalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="Profissional Endpoint")
@RestController
@RequestMapping("api/profissional/v1")
@CrossOrigin("http://localhost:4200")
public class ProfissionalController {

	@Autowired
	ProfissionalService service;

	@CrossOrigin("localhost:8080")
	@RequestMapping(method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	@Operation(summary="Listar todos os profissionais")
	@ResponseStatus(value = HttpStatus.OK)
	public List<ProfissionalVO> findAll() {
		List<ProfissionalVO> profissionalVO = service.buscarTodos();
		profissionalVO.stream().forEach(p -> p.add(linkTo(methodOn(ProfissionalController.class).findById(p.getKey())).withSelfRel()));
		return profissionalVO;
	}

	@CrossOrigin({"localhost:8080",  }) 
	@GetMapping(value = "/{id}", produces = { "application/json", "application/xml" })
	@ResponseStatus(value = HttpStatus.OK)
	public ProfissionalVO findById(@PathVariable("id") Long id) {
		ProfissionalVO profissionalVO = service.buscarPorId(id);
		profissionalVO.add(linkTo(methodOn(ProfissionalController.class).findById(id)).withSelfRel());
		return profissionalVO;
	}

	@PostMapping(consumes = { "application/json", "application/xml" }, produces = { "application/json",
			"application/xml" })
	@ResponseStatus(value = HttpStatus.CREATED)
	public ProfissionalVO create(@Valid @RequestBody ProfissionalVO profissional) {
		ProfissionalVO profissionalVO = service.inserir(profissional);
		profissionalVO.add(linkTo(methodOn(ProfissionalController.class).findById(profissionalVO.getKey())).withSelfRel());
		return profissionalVO;
	}

	@PutMapping(consumes = { "application/json", "application/xml" }, produces = { "application/json",
			"application/xml" })
	@ResponseStatus(value = HttpStatus.OK)
	public ProfissionalVO update(@Valid @RequestBody ProfissionalVO profissional) {
		ProfissionalVO profissionalVO = service.atualizar(profissional);
		profissionalVO.add(linkTo(methodOn(ProfissionalController.class).findById(profissionalVO.getKey())).withSelfRel());
		return profissionalVO;
	}

	@DeleteMapping(value = "/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}

}
