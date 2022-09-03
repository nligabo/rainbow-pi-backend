package br.com.rainbow_pi.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="tb_profissionais")
@NoArgsConstructor
@Getter
@Setter
public class Profissional implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_profissional")
	private Long id;
	
	@NotBlank
	@Size(max=60)
	@Column(name="nome_profissional")
	private String nome;
	
	@NotBlank
	@Size(max=60)
	@Email
	@Column(name="email_profissional")
	private String email;
	
	@NotBlank
	@Size(max=15)
	@Column(name="cpf_profissional")
	private String cpf;
	
	@NotBlank
	@Size(max=30)
	@Column(name="profissao_profissional")
	private String profissao;
	
	@NotBlank
	@Size(max=10)
	@Column(name="registro_profissional")
	private String registroProfissional;

}
