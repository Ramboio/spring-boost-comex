package br.com.alura.comex.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate data = LocalDate.now();

    @ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Cliente cliente;

    private BigDecimal desconto = BigDecimal.ZERO;

    @Enumerated(EnumType.STRING)
    private TipoDesconto tipoDesconto = TipoDesconto.NENHUM;

    @OneToMany(mappedBy = "pedido")
    private List<ItemDePedido> itensPedido;

    public Pedido() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public TipoDesconto getTipoDesconto() {
        return tipoDesconto;
    }

    public void setTipoDesconto(TipoDesconto tipoDesconto) {
        this.tipoDesconto = tipoDesconto;
    }

    public List<ItemDePedido> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(List<ItemDePedido> itensPedido) {
        this.itensPedido = itensPedido;
    }

    public BigDecimal getDiscountPercentage() {
        if (this.tipoDesconto == TipoDesconto.NENHUM)
            return new BigDecimal("0");
        if (this.tipoDesconto == TipoDesconto.FIDELIDADE)
            return new BigDecimal("0.05");

        return new BigDecimal("0");
    }

    public void calculateDiscount() {
        BigDecimal totalValue = itensPedido.stream()
                .map(o->o.getPrecoUnitario().multiply(BigDecimal.valueOf(o.getQuantidade())).subtract(o.getDesconto()))
                .reduce(BigDecimal::add)
                .get();

        this.desconto = totalValue.multiply(getDiscountPercentage());
    }
}