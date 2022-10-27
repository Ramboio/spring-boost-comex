package br.com.alura.comex.model;

public class ClienteDto {
    private String nome;
    private String cpf;
    private String telefone;
    private String local;

    public ClienteDto(Cliente cliente) {
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.telefone = cliente.getTelefone();
        this.local = cliente.getCidade() + '/' + cliente.getEstado();
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getLocal() {
        return local;
    }
}
