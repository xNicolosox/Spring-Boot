package io.github.xNicolosox.spring_data.domain.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    // mapeamento de uma coluna que é fk da tabela cliente
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @Column(name = "data_pedido")
    private LocalDate dataPedido;

    @Column(name = "total", precision = 20, scale = 2)//precesion é a config para casa decimal ex:10.00
    private BigDecimal total;

    @OneToMany(mappedBy = "pedido")
    //set nao aceita valores repetidos, mas didaticamente coloquei list para
    //mostrar que funciona também
    private List<ItemPedido> items;

    public List<ItemPedido> getItems() {
        return items;
    }

    public void setItems(List<ItemPedido> items) {
        this.items = items;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", dataPedido=" + dataPedido +
                ", total=" + total +
                '}';
    }
}
