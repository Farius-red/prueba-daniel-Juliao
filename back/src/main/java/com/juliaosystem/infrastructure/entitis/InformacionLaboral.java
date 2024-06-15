package com.juliaosystem.infrastructure.entitis;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class InformacionLaboral {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nitEmpresa;
    private String nombreEmpresa;
    private String direccion;
    private String telefono;
    private String cargo;


    @NotNull(message = "La fecha de vinculación no puede ser nula")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @Column(name = "fecha_vinculacion")
    private LocalDateTime fechaVinculacion;

    @OneToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public void setFechaVinculacion(String fechaVinculacion) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        this.fechaVinculacion = LocalDateTime.parse(fechaVinculacion, formatter);
    }

    public String getFechaVinculacionString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return this.fechaVinculacion.format(formatter);
    }
}
