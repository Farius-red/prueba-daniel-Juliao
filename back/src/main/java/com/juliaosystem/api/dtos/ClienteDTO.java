package com.juliaosystem.api.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ClienteDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("tipoDocumento")
    private String tipoDocumento;

    @JsonProperty("numeroDocumento")
    private String numeroDocumento;

    @JsonProperty("apellidos")
    private String apellidos;

    @JsonProperty("residencia")
    private String residencia;

    @JsonProperty("ciudad")
    private String ciudad;

    @JsonProperty("telefono")
    private String telefono;

    @JsonProperty("informacionLaboral")
    private InformacionLaboralDTO informacionLaboral;

    @JsonProperty("referenciasFamiliares")
    private List<ReferenciaFamiliarDTO> referenciasFamiliares;

    @JsonProperty("referenciasPersonales")
    private List<ReferenciaPersonalDTO> referenciasPersonales;

}
