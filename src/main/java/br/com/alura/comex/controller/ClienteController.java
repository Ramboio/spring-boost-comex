package br.com.alura.comex.controller;

import br.com.alura.comex.model.Cliente;
import br.com.alura.comex.model.ClienteForm;
import br.com.alura.comex.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<Cliente> create(@RequestBody ClienteForm clienteForm) {
        return clienteService.create(clienteForm);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listAll (@RequestParam int offset) {
        return clienteService.listAll(offset);
    }
}
