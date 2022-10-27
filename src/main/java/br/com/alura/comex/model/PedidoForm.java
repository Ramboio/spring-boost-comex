package br.com.alura.comex.model;

import java.util.List;

public class PedidoForm {
    private Long idCliente;
    private List<ItensPedidoForm> itensPedidoForm;

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public List<ItensPedidoForm> getItensPedidoForm() {
        return itensPedidoForm;
    }

    public void setItensPedidoForm(List<ItensPedidoForm> itensPedidoForm) {
        this.itensPedidoForm = itensPedidoForm;
    }
}

