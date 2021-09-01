package br.com.zup_academy.alisson_prado.transacao.repository;

import br.com.zup_academy.alisson_prado.transacao.model.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartaoRepository extends JpaRepository<Cartao, Long> {
    Cartao findByNumero(String id);
}
