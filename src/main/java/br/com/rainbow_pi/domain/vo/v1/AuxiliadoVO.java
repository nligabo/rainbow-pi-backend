package br.com.rainbow_pi.domain.vo.v1;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Embedded;

import org.springframework.hateoas.RepresentationModel;

import com.github.dozermapper.core.Mapping;


public class AuxiliadoVO extends RepresentationModel<AuxiliadoVO> implements Serializable{

	private static final long serialVersionUID = 1L;

	@Mapping("id")
	private Long key;
	private String nome;
	private String email;
	private String cpf;
	private Embedded endereco;
	private int telefone;
	private String tipoDeAjuda;
	private Date dataNasc;
	
	
	
	public Long getKey() {
		return key;
	}
	public void setKey(Long key) {
		this.key = key;
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
	
	public Embedded getEndereco() {
		return endereco;
	}
	public void setEndereco(Embedded endereco) {
		this.endereco = endereco;
	}
	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(email, key, nome, cpf, endereco, telefone, tipoDeAjuda, dataNasc);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		AuxiliadoVO other = (AuxiliadoVO) obj;
		return Objects.equals(email, other.email) 
				&& Objects.equals(key, other.key) 
				&& Objects.equals(nome, other.nome) 
				&& Objects.equals(cpf, other.cpf)
				&& Objects.equals(endereco, other.endereco) 
				&& Objects.equals(telefone, other.telefone) 
				&& Objects.equals(tipoDeAjuda, other.tipoDeAjuda)
				&& Objects.equals(dataNasc, other.dataNasc);
		
	}

	
}
