package com.juliaosystem.api.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class InformacionLaboralDTO {

    @JsonProperty("nitEmpresa")
    private String nitEmpresa;

    @JsonProperty("nombreEmpresa")
    private String nombreEmpresa;

    @JsonProperty("direccion")
    private String direccion;

    @JsonProperty("telefono")
    private String telefono;

    @JsonProperty("cargo")
    private String cargo;


    @NotNull(message = "La fecha de vinculación no puede ser nula")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @Schema(description = "Formato esperado: yyyy-MM-dd HH:mm", example = "2024-06-15 14:30")
    @JsonProperty("fechaVinculacion")
    private String fechaVinculacion;
}
