package br.com.rainbow_pi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rainbow_pi.domain.entity.Atendimento;

public interface AtendimentoRepository extends JpaRepository<Atendimento, Long>{

}
