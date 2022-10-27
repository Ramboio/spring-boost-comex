package br.com.alura.comex.model;

public class CategoriaForm {
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria converter() {
        Categoria categoria = new Categoria();
        categoria.setNome(getNome());
        return categoria;
    }
}
