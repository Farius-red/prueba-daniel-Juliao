package com.juliaosystem.infrastructure.services.primary;

import com.juliaosystem.api.dtos.request.ClientRequest;
import com.juliaosystem.api.dtos.response.CreditoResponse;
import com.juliaosystem.infrastructure.adapters.primary.CreditoImpl;
import com.juliaosystem.utils.PlantillaResponse;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CreditoService {


    private final CreditoImpl creditoImpl;


    public PlantillaResponse<CreditoResponse> add(ClientRequest clientRequest) {
        return creditoImpl.add(clientRequest);
    }


    public PlantillaResponse<CreditoResponse> all() {
        return  creditoImpl.all();
    }
}