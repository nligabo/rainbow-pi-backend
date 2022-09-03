package br.com.rainbow_pi.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tb_atendimento")
@Data
@NoArgsConstructor
public class Atendimento implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_auxiliado")
	private String idAuxiliado;

	@Column(name="id_profissional")
	private String idProfissional;
	
	
}
