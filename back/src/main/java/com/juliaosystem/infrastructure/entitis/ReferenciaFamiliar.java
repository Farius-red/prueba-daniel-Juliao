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
