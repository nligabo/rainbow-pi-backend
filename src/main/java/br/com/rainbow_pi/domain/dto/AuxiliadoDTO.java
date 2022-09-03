package br.com.rainbow_pi.domain.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import br.com.rainbow_pi.domain.entity.Auxiliado;


public class AuxiliadoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private String email;
	private String cpf;
	private String tipoDeAjuda;
	private Date dataNasc;
	
	public AuxiliadoDTO(Auxiliado auxiliado) {
		this.id = auxiliado.getId();
		this.nome = auxiliado.getNome();
		this.email = auxiliado.getEmail();
		this.cpf = auxiliado.getCpf();
		this.tipoDeAjuda = auxiliado.getTipoDeAjuda();
		this.dataNasc = auxiliado.getDataNasc();
	}
	
	public static List<AuxiliadoDTO> converterLista(java.util.List<Auxiliado> auxiliados){
		return auxiliados.stream().map(AuxiliadoDTO::new).collect(Collectors.toList());
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

	public String getTipoDeAjuda() {
		return tipoDeAjuda;
	}

	public void setTipoDeAjuda(String tipoDeAjuda) {
		this.tipoDeAjuda = tipoDeAjuda;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf, dataNasc, email, id, nome, tipoDeAjuda);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AuxiliadoDTO other = (AuxiliadoDTO) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(dataNasc, other.dataNasc)
				&& Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome) && Objects.equals(tipoDeAjuda, other.tipoDeAjuda);
	}
	
	
}
