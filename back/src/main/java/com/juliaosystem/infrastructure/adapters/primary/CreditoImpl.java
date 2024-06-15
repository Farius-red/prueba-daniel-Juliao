package com.juliaosystem.infrastructure.adapters.primary;

import com.juliaosystem.api.dtos.request.ClientRequest;
import com.juliaosystem.api.dtos.response.CreditoResponse;
import com.juliaosystem.infrastructure.services.secondary.CreditoServiceInter;
import com.juliaosystem.utils.PlantillaResponse;
import com.juliaosystem.utils.UserResponses;
import com.juliaosystem.utils.enums.ResponseType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreditoImpl {

    private final CreditoServiceInter creditoServiceInter;
    private final UserResponses<CreditoResponse> userResponses;

    public PlantillaResponse<CreditoResponse> add(ClientRequest clientRequest) {
        if(clientRequest.getCliente().getId() == null){
            return creditoServiceInter.add(clientRequest);
        }else {
            if(!creditoServiceInter.byId(clientRequest.getCliente().getId()))
                return creditoServiceInter.add(clientRequest);
            else return userResponses.buildResponse(ResponseType.USER_ISFOUND.getCode(), CreditoResponse.builder().id(clientRequest.getCliente().getId()).build());
        }
    }

    public PlantillaResponse<CreditoResponse> all() {
        return creditoServiceInter.all();
    }
}
