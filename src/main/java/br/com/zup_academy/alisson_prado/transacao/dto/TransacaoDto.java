package br.com.zup_academy.alisson_prado.transacao.dto;

import br.com.zup_academy.alisson_prado.transacao.model.Cartao;
import br.com.zup_academy.alisson_prado.transacao.model.Transacao;
import br.com.zup_academy.alisson_prado.transacao.repository.CartaoRepository;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoDto {

    @NotBlank
    private String id;
    @PositiveOrZero
    private BigDecimal valor;
    @NotNull
    private LocalDateTime efetivadaEm;
    private EstabelecimentoDto estabelecimentoDto;
    private CartaoDto cartaoDto;

    public TransacaoDto() {
    }

    @JsonCreator
    public TransacaoDto(@JsonProperty("id") String id,
                        @JsonProperty("valor") BigDecimal valor,
                        @JsonProperty("efetivadaEm") LocalDateTime efetivadaEm,
                        @JsonProperty("estabelecimentoDto") EstabelecimentoDto estabelecimentoDto,
                        @JsonProperty("cartaoDto") CartaoDto cartaoDto) {
        this.id = id;
        this.valor = valor;
        this.efetivadaEm = efetivadaEm;
        this.estabelecimentoDto = estabelecimentoDto;
        this.cartaoDto = cartaoDto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public void setEfetivadaEm(LocalDateTime efetivadaEm) {
        this.efetivadaEm = efetivadaEm;
    }

    public EstabelecimentoDto getEstabelecimentoDto() {
        return estabelecimentoDto;
    }

    public void setEstabelecimentoDto(EstabelecimentoDto estabelecimentoDto) {
        this.estabelecimentoDto = estabelecimentoDto;
    }

    public CartaoDto getCartaoDto() {
        return cartaoDto;
    }

    public void setCartaoDto(CartaoDto cartaoDto) {
        this.cartaoDto = cartaoDto;
    }

    public Transacao toModel(CartaoRepository cartaoRepository){
        Cartao cartao = cartaoRepository.findByNumero(cartaoDto.getId());

        if (cartao == null)
            cartao = this.cartaoDto.toModel();

        return new Transacao(this.id, this.valor, this.efetivadaEm, this.estabelecimentoDto.toModel(), cartao);
    }
}
