package br.com.alura.comex.model;

import java.math.BigDecimal;

public class ProdutoForm {
    private String nome;
    private String descricao;
    private BigDecimal precoUnitario;
    private int quantidadeEstoque;
    private Long idCategoria;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Produto converter() {
        Produto produto = new Produto();
        Categoria categoria = new Categoria();
        categoria.setId(getIdCategoria());
        produto.setCategoria(categoria);
        produto.setNome(getNome());
        produto.setDescricao(getDescricao());
        produto.setPrecoUnitario(getPrecoUnitario());
        produto.setQuantidadeEstoque(getQuantidadeEstoque());

        return produto;
    }
}
