package com.juliaosystem.infrastructure.entitis;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Entity
@Builder
@Data
public class LineaCredito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private double valorMinimo;
    private double valorMaximo;
    private int plazoMaximo;

    @OneToMany(mappedBy = "lineaCredito", cascade = CascadeType.ALL)
    private List<Credito> creditos;
}
