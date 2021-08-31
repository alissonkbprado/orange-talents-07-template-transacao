package br.com.zup_academy.alisson_prado.transacao.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class EventoDeTransacaoDto {

    private String id;
    private BigDecimal valor;
    private LocalDateTime efetivadaEm;

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }
}
