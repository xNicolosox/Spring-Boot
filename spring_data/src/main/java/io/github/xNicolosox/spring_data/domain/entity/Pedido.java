package io.github.xNicolosox.spring_data.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Pedido {
    private Integer id;
    private Cliente cliente;
    private LocalDate dataPedido;
    private BigDecimal total;
}
