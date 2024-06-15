package com.juliaosystem.infrastructure.services.secondary;


import com.juliaosystem.api.dtos.request.ClientRequest;
import com.juliaosystem.api.dtos.response.CreditoResponse;
import com.juliaosystem.utils.PlantillaResponse;

public interface CreditoServiceInter {

     PlantillaResponse<CreditoResponse> add(ClientRequest request);

     PlantillaResponse<CreditoResponse> all();

     boolean byId(Long id);
}
