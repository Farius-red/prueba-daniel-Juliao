package com.juliaosystem.infrastructure.entitis;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Entity
@Builder
@Data
public class ReferenciaFamiliar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String direccion;
    private String telefono;
    private String ciudad;
    private String email;
    private String parentesco;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}
