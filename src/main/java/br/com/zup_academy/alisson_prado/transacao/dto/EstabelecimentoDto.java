package br.com.zup_academy.alisson_prado.transacao.dto;

import br.com.zup_academy.alisson_prado.transacao.model.Estabelecimento;

public class EstabelecimentoDto {

    private String nome;
    private String cidade;
    private String endereco;

    public EstabelecimentoDto() {
    }

    public EstabelecimentoDto(String nome, String cidade, String endereco) {
        this.nome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Estabelecimento toModel(){
        return new Estabelecimento(this.nome, this.cidade, this.endereco);
    }
}
