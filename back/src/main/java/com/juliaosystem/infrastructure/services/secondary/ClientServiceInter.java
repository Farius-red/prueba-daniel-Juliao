package com.juliaosystem.infrastructure.services.secondary;

import com.juliaosystem.api.dtos.ClienteDTO;
import com.juliaosystem.api.dtos.response.ClientResponse;

import com.juliaosystem.utils.PlantillaResponse;

public interface ClientServiceInter {
    boolean byId(Long id);
    PlantillaResponse<ClientResponse> add(ClienteDTO request);
}
