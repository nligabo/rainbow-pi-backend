package br.com.rainbow_pi.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tb_ajuda")
@Data
@NoArgsConstructor
public class Ajuda implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_ajuda")
	private Long id;
	
	@NotBlank
	@Size(max=20)
	@Column(name="tipo_ajuda")
	private String tipoDeAjuda;
	
	@NotBlank
	@Size(max=200)
	@Column(name="descricao_ajuda")	
	private String descricao;
	
	@Column(name="conteudo_link")
	private String conteudo;
	
	@Column(name="url_link")
	private String url;

}
