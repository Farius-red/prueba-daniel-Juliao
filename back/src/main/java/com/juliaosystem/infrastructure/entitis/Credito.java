package com.juliaosystem.infrastructure.entitis;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Entity
@Builder
@Data
public class Credito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double valor;
    private Integer plazo;
    private String descripcionDestino;
    private Boolean aprobado;

    @ManyToOne
    @JoinColumn(name = "linea_credito_id")
    private LineaCredito lineaCredito;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}
