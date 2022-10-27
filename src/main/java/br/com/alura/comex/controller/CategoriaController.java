package br.com.alura.comex.controller;

import br.com.alura.comex.model.Categoria;
import br.com.alura.comex.model.CategoriaForm;
import br.com.alura.comex.model.CategoriaProdutoProjection;
import br.com.alura.comex.service.CategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping
    public ResponseEntity<Categoria> create(@RequestBody CategoriaForm categoriaForm)
    {
        return categoriaService.create(categoriaForm);
    }

    @GetMapping("/pedidos")
    public ResponseEntity<List<CategoriaProdutoProjection>> listPedidos() {
        return categoriaService.listCategoriaProdutoProjection();
    }
}
