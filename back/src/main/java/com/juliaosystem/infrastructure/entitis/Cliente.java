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
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipoDocumento;
    private String numeroDocumento;
    private String apellidos;
    private String residencia;
    private String ciudad;
    private String telefono;

    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL)
    private InformacionLaboral informacionLaboral;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<ReferenciaPersonal> referenciasPersonales;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<ReferenciaFamiliar> referenciasFamiliares;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Credito> creditos;

}
