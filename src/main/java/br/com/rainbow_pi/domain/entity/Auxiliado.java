package br.com.rainbow_pi.domain.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_auxiliados")
@Data
@NoArgsConstructor

public class Auxiliado implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_auxiliado")
	private Long id;
	
	@NotBlank
	@Size(max=60)
	@Column(name="nome_auxiliado")
	private String nome;
	
	@NotBlank
	@Size(max=60)
	@Email
	@Column(name="email_auxiliado")
	private String email;
	
	@NotBlank
	@Size(max=15)
	@Column(name="cpf_auxiliado")
	private String cpf;
	
	@NotBlank
	@Size(max=100)
	@Column(name="endereco_auxiliado")
	private String endereco;
		
	@NotBlank
	@Size(max=15)
	@Column(name="telefone_auxiliado")
	private int telefone;
	
	@NotBlank
	@Size(max=20)
	@Column(name="tipodeajuda_auxiliado")
	private String tipoDeAjuda;
	
	@NotBlank
	@Size(max=10) 
	@Column(name="datanasc_auxiliado")
	private Date dataNasc;
	
	
}
