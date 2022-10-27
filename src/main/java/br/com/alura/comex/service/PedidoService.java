package br.com.alura.comex.service;

import br.com.alura.comex.model.*;
import br.com.alura.comex.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PedidoService {
    private final ClienteService clienteService;

    private final ProdutoService produtoService;

    private final PedidoRepository pedidoRepository;

    public PedidoService(ClienteService clienteService, ProdutoService produtoService, PedidoRepository pedidoRepository) {
        this.clienteService = clienteService;
        this.produtoService = produtoService;
        this.pedidoRepository = pedidoRepository;
    }

    @Transactional
    public Pedido create(PedidoForm pedidoForm) {
        Pedido newPedido = new Pedido();

        Cliente cliente = clienteService.getById(pedidoForm.getIdCliente()).orElseThrow(RuntimeException::new);

        for (ItensPedidoForm itemPedidoForm : pedidoForm.getItensPedidoForm()) {
            Produto produto = produtoService.getById(itemPedidoForm.getIdPedido()).orElseThrow(RuntimeException::new);

            ItemDePedido itemDePedido = new ItemDePedido(itemPedidoForm.getQuantidade(), produto);
            if (itemPedidoForm.getQuantidade() > 10) {
                itemDePedido.setTipoDesconto(TipoDescontoItem.QUANTIDADE);
            }
            itemDePedido.calculateDiscount();

            newPedido.getItensPedido().add(itemDePedido);
        }

        if (pedidoRepository.countByCliente(cliente) > 5) {
            newPedido.setTipoDesconto(TipoDesconto.FIDELIDADE);
        }

        newPedido.calculateDiscount();
        pedidoRepository.save(newPedido);

        return newPedido;
    }

}
