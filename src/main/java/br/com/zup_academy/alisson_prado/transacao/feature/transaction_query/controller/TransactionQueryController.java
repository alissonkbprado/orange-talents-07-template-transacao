package br.com.zup_academy.alisson_prado.transacao.feature.transaction_query.controller;

import br.com.zup_academy.alisson_prado.transacao.feature.transaction_query.response.TransactionQueryResponse;
import br.com.zup_academy.alisson_prado.transacao.model.Transacao;
import br.com.zup_academy.alisson_prado.transacao.repository.TransacaoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionQueryController {

    private TransacaoRepository repository;

    public TransactionQueryController(TransacaoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/api/v1/cartoes/{idCartao}/transacoes")
    public ResponseEntity<?> findLast10(@PathVariable String idCartao, @PageableDefault(sort = "efetivadaEm",
            direction = Sort.Direction.DESC,
            page = 0,
            size = 10) Pageable pagination,@AuthenticationPrincipal Jwt jwt){

        System.out.println(jwt.getClaimAsString("email"));

        Page<Transacao> transacaoList = repository.findAll(pagination);

        if (transacaoList.isEmpty())
            return ResponseEntity.status(404).build();

        return ResponseEntity.ok().body(TransactionQueryResponse.converter(transacaoList));
    }
}
