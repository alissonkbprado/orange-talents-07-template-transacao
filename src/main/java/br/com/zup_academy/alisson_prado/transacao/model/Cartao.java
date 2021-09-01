package br.com.zup_academy.alisson_prado.transacao.model;

import br.com.zup_academy.alisson_prado.transacao.converter.CryptoConverter;
import br.com.zup_academy.alisson_prado.transacao.validation.Uuid;
import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Entity
public class Cartao {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank @Uuid
    @Column(nullable = false, unique = true)
    private String idCartao;

    @NotBlank
    @Convert(converter = CryptoConverter.class)
    @Column(nullable = false, unique = true)
    private String numero;

    @NotBlank @Email
    @Convert(converter = CryptoConverter.class)
    @Column(nullable = false)
    private String email;

    private Cartao() {
    }

    /**
     *
     * @param numero @NotBlank
     * @param email @NotBlank
     */
    public Cartao(@NotBlank String numero,@NotBlank String email) {

        Assert.hasText(numero, "Campo obrigatório");
        Assert.hasText(email, "Campo obrigatório");

        this.numero = numero;
        this.email = email;
        this.idCartao = UUID.randomUUID().toString();
    }
}
