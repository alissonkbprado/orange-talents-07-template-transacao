package br.com.zup_academy.alisson_prado.transacao.dto;

import br.com.zup_academy.alisson_prado.transacao.model.Cartao;

public class CartaoDto {
    private String id;
    private String email;

    public CartaoDto() {
    }

    public CartaoDto(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Cartao toModel(){
        return new Cartao(this.id, this.email);
    }
}
