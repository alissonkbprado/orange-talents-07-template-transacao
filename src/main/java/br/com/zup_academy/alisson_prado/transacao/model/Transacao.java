package br.com.zup_academy.alisson_prado.transacao.model;

import br.com.zup_academy.alisson_prado.transacao.validation.Uuid;
import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transacao {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty @Uuid
    private String idTransacao;

    @PositiveOrZero
    private BigDecimal valor;

    @NotNull
    private LocalDateTime efetivadaEm;

    @Embedded
    private Estabelecimento estabelecimento;

    @NotNull
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Cartao cartao;

    private Transacao() {
    }

    /**
     *
     * @param idTransacao @NotEmpty @Uuid
     * @param valor @PositiveOrZero
     * @param efetivadaEm @NotNull
     * @param estabelecimento @NotNull
     * @param cartao @NotNull
     */
    public Transacao(@NotEmpty String idTransacao,
                     @PositiveOrZero BigDecimal valor,
                     @NotNull LocalDateTime efetivadaEm,
                     @NotNull Estabelecimento estabelecimento,
                     @NotNull Cartao cartao) {
        Assert.hasText(idTransacao, "Campo obrigatório.");
        Assert.notNull(valor, "Campo não pode ser nulo.");
        Assert.notNull(efetivadaEm, "Campo não pode ser nulo.");
        Assert.notNull(estabelecimento, "Campo não pode ser nulo.");
        Assert.notNull(cartao, "Campo não pode ser nulo.");

        this.idTransacao = idTransacao;
        this.valor = valor;
        this.efetivadaEm = efetivadaEm;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
    }

    public Long getId() {
        return id;
    }

    public String getIdTransacao() {
        return idTransacao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public Cartao getCartao() {
        return cartao;
    }
}
