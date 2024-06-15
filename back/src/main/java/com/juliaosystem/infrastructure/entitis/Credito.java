package com.juliaosystem.infrastructure.entitis;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Credito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double valor;
    private Integer plazo;
    private String descripcionDestino;
    private Boolean aprobado;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "linea_credito_id")
    private LineaCredito lineaCredito;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}
