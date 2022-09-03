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

import br.com.rainbow_pi.domain.vo.v1.AuxiliadoVO;
import br.com.rainbow_pi.service.AuxiliadoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="Auxiliado Endpoint")
@RestController
@RequestMapping("rainbow_pi/auxiliado")
@CrossOrigin("http://localhost:4200")
public class AuxiliadoController {

	@Autowired
	AuxiliadoService service;

	@CrossOrigin("localhost:8080")
	@RequestMapping(method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	@Operation(summary="Listar todos os auxiliados")
	@ResponseStatus(value = HttpStatus.OK)
	public List<AuxiliadoVO> findAll() {
		List<AuxiliadoVO> auxiliadoVO = service.buscarTodos();
		auxiliadoVO.stream().forEach(p -> p.add(linkTo(methodOn(AuxiliadoController.class).findById(p.getKey())).withSelfRel()));
		return auxiliadoVO;
	}

	@CrossOrigin({"localhost:8080",  }) 
	@GetMapping(value = "/{id}", produces = { "application/json", "application/xml" })
	@ResponseStatus(value = HttpStatus.OK)
	public AuxiliadoVO findById(@PathVariable("id") Long id) {
		AuxiliadoVO auxiliadoVO = service.buscarPorId(id);
		auxiliadoVO.add(linkTo(methodOn(AuxiliadoController.class).findById(id)).withSelfRel());
		return auxiliadoVO;
	}

	@PostMapping(consumes = { "application/json", "application/xml" }, produces = { "application/json",
			"application/xml" })
	@ResponseStatus(value = HttpStatus.CREATED)
	public AuxiliadoVO create(@Valid @RequestBody AuxiliadoVO auxiliado) {
		AuxiliadoVO auxiliadoVO = service.inserir(auxiliado);
		auxiliadoVO.add(linkTo(methodOn(AuxiliadoController.class).findById(auxiliadoVO.getKey())).withSelfRel());
		return auxiliadoVO;
	}

	@PutMapping(consumes = { "application/json", "application/xml" }, produces = { "application/json",
			"application/xml" })
	@ResponseStatus(value = HttpStatus.OK)
	public AuxiliadoVO update(@Valid @RequestBody AuxiliadoVO auxiliado) {
		AuxiliadoVO auxiliadoVO = service.atualizar(auxiliado);
		auxiliadoVO.add(linkTo(methodOn(AuxiliadoController.class).findById(auxiliadoVO.getKey())).withSelfRel());
		return auxiliadoVO;
	}

	@DeleteMapping(value = "/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}

}
