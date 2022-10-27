package br.com.alura.comex.repository;

import br.com.alura.comex.model.Categoria;
import br.com.alura.comex.model.CategoriaProdutoProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    @Query(nativeQuery = true, value = "select c.nome, count(p.id), sum(ip.quantidade)  from categorias c \n" +
            "join produtos p on p.categoria_id = c.id \n" +
            "join itens_pedido ip on ip.produto_id = p.id \n" +
            "join pedidos on pedidos.id = ip.pedido_id\n" +
            "group by c.nome\n")
    public List<CategoriaProdutoProjection> listCategoriaProduto();
}
