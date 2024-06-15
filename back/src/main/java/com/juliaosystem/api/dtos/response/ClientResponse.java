package com.juliaosystem.api.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.juliaosystem.api.dtos.ClienteDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ClientResponse {


    @JsonProperty("cliente")
    private ClienteDTO cliente;
}
