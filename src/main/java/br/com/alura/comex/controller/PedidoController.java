package br.com.alura.comex.controller;

import br.com.alura.comex.model.Pedido;
import br.com.alura.comex.model.PedidoForm;
import br.com.alura.comex.service.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public ResponseEntity<Pedido> create(@RequestBody PedidoForm pedidoForm) {
        return new ResponseEntity<>(pedidoService.create(pedidoForm), HttpStatus.OK);
    }
}
