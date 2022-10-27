package br.com.alura.comex.service;

import br.com.alura.comex.model.Categoria;
import br.com.alura.comex.model.CategoriaForm;
import br.com.alura.comex.model.CategoriaProdutoProjection;
import br.com.alura.comex.repository.CategoriaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public ResponseEntity<Categoria> create(CategoriaForm categoriaForm) {
        Categoria categoria = categoriaRepository.save(categoriaForm.converter());
        return new ResponseEntity<>(categoria, HttpStatus.CREATED);
    }

    public ResponseEntity<List<CategoriaProdutoProjection>> listCategoriaProdutoProjection() {
        return new ResponseEntity<>(categoriaRepository.listCategoriaProduto(), HttpStatus.OK);
    }

    public Boolean categoriaExists(Long id) {
        return categoriaRepository.existsById(id);
    }


}
