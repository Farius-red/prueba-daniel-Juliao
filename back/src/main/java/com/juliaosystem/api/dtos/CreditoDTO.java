package com.juliaosystem.api.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CreditoDTO {


    @JsonProperty("valor")
    @Min(value = 100000, message = "El valor mínimo debe ser 100,000")
    @Max(value = 5000000, message = "El valor máximo debe ser 5,000,000")
    private Double valor;

    @JsonProperty("plazo")
    private Integer plazo;

    @JsonProperty("descripcionDestino")
    private String descripcionDestino;

    @JsonProperty("aprobado")
    private Boolean aprobado;

    @JsonProperty("lineaCredito")
    private LineaCreditoDTO lineaCredito;



}
