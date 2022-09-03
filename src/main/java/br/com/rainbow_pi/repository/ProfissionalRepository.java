package br.com.rainbow_pi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import br.com.rainbow_pi.domain.entity.Profissional;

public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {
	Page<Profissional> findByNome(String nome, Pageable pageable);

}
