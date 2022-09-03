package br.com.rainbow_pi.domain.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import br.com.rainbow_pi.domain.entity.Profissional;


public class ProfissionalDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private String email;
	private String cpf;
	private String profissao;
	private String registroProfissional;
	
	public ProfissionalDTO(Profissional profissional) {
		this.id = profissional.getId();
		this.nome = profissional.getNome();
		this.email = profissional.getEmail();
		this.cpf = profissional.getCpf();
		this.profissao = profissional.getProfissao();
		this.registroProfissional = profissional.getRegistroProfissional();
	}
	
	public static List<ProfissionalDTO> converterLista(java.util.List<Profissional> profissionais){
		return profissionais.stream().map(ProfissionalDTO::new).collect(Collectors.toList());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public String getRegistroProfissional() {
		return registroProfissional;
	}

	public void setRegistroProfissional(String registroProfissional) {
		this.registroProfissional = registroProfissional;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf, email, id, nome, profissao, registroProfissional);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProfissionalDTO other = (ProfissionalDTO) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome) && Objects.equals(profissao, other.profissao)
				&& Objects.equals(registroProfissional, other.registroProfissional);
	}
	
	
}
