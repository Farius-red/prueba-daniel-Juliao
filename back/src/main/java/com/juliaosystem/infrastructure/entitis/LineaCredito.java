package com.juliaosystem.infrastructure.entitis;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
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
