package br.com.alura.comex.service;

import br.com.alura.comex.model.ProdutoDto;
import br.com.alura.comex.model.ProdutoForm;
import br.com.alura.comex.model.Produto;
import br.com.alura.comex.repository.ProdutoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    private final CategoriaService categoriaService;

    public ProdutoService(ProdutoRepository produtoRepository, CategoriaService categoriaService) {
        this.produtoRepository = produtoRepository;
        this.categoriaService = categoriaService;
    }

    public ResponseEntity<Produto> create(ProdutoForm produtoForm) {
        if (!categoriaService.categoriaExists(produtoForm.getIdCategoria()))
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST);

        Produto produto = produtoRepository.save(produtoForm.converter());
        return new ResponseEntity<>(produto, HttpStatus.CREATED);
    }

    public ResponseEntity<List<ProdutoDto>> listAll(int offset) {
        Pageable sortByName = PageRequest.of(offset,5, Sort.by("nome"));
        List<Produto> responseList = produtoRepository.findAll(sortByName).getContent();

        return new ResponseEntity<>(responseList.stream().map(ProdutoDto::new).collect(Collectors.toList()), HttpStatus.OK);
    }

    public Optional<Produto> getById(Long id) {
        return produtoRepository.findById(id);
    }

    public void removeQuantity(Produto produto, int quantityToRemove) {
        produto.removeQuantidadeEstoque(quantityToRemove);
        produtoRepository.save(produto);
    }
}
