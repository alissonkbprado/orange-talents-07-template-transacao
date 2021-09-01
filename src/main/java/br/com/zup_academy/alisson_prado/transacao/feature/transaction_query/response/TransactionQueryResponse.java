package br.com.zup_academy.alisson_prado.transacao.feature.transaction_query.response;

import br.com.zup_academy.alisson_prado.transacao.model.Transacao;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionQueryResponse {

    private String id;
    private BigDecimal valor;
    private LocalDateTime efetivadaEm;
    private EstabelecimentoResponse estabelecimento;

    public TransactionQueryResponse(Transacao transacao) {
        this.id = transacao.getIdTransacao();
        this.valor = transacao.getValor();
        this.efetivadaEm = transacao.getEfetivadaEm();
        this.estabelecimento = new EstabelecimentoResponse(transacao.getEstabelecimento());
    }

    public static Page<TransactionQueryResponse> converter(Page<Transacao> transacaoList) {
        return transacaoList.map(TransactionQueryResponse::new);
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public EstabelecimentoResponse getEstabelecimento() {
        return estabelecimento;
    }
}
