package br.com.zup_academy.alisson_prado.transacao.repository;

import br.com.zup_academy.alisson_prado.transacao.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
}
