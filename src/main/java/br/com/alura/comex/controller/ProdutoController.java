package br.com.alura.comex.controller;

import br.com.alura.comex.model.Produto;
import br.com.alura.comex.model.ProdutoDto;
import br.com.alura.comex.model.ProdutoForm;
import br.com.alura.comex.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity<Produto> create(@RequestBody ProdutoForm produtoForm) {
        return produtoService.create(produtoForm);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoDto>> listAll(@RequestParam int offset) {
        return produtoService.listAll(offset);
    }

}
