package br.gov.mt.sesp.sespprojetopraticospring.repository;

import br.gov.mt.sesp.sespprojetopraticospring.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}