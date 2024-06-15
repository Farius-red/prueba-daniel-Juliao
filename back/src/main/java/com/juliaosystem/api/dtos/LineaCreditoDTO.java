package com.juliaosystem.api.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public class LineaCreditoDTO {

    @JsonProperty("nombre")
    private String nombre;

    @JsonProperty("valorMinimo")
    @Min(value = 100000, message = "El valor mínimo debe ser 100,000")
    private double valorMinimo;

    @JsonProperty("valorMaximo")
    @Max(value = 5000000, message = "El valor máximo debe ser 5,000,000")
    private double valorMaximo;

    @JsonProperty("plazoMaximo")
    private int plazoMaximo;
}
