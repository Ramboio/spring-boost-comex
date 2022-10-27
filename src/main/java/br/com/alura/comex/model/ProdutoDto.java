package br.com.alura.comex.model;

import java.math.BigDecimal;

public class ProdutoDto {
    private String nome;
    private BigDecimal preco;
    private String descricao;
    private int quantidadeEstoque;
    private Long idCategoria;
    private String nomeCategoria;

    public ProdutoDto(Produto produto) {
        this.nome = produto.getNome();
        this.preco = produto.getPrecoUnitario();
        this.descricao = produto.getDescricao();
        this.quantidadeEstoque = produto.getQuantidadeEstoque();
        this.idCategoria = produto.getCategoria().getId();
        this.nomeCategoria = produto.getCategoria().getNome();
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }
}
