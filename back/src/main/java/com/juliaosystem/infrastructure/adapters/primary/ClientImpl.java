package com.juliaosystem.infrastructure.adapters.primary;

import com.juliaosystem.api.dtos.ClienteDTO;
import com.juliaosystem.api.dtos.request.ClientRequest;
import com.juliaosystem.api.dtos.response.ClientResponse;
import com.juliaosystem.infrastructure.services.secondary.ClientServiceInter;
import com.juliaosystem.utils.PlantillaResponse;
import com.juliaosystem.utils.UserResponses;
import com.juliaosystem.utils.enums.ResponseType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientImpl {

    private  final ClientServiceInter clientService;
    private final UserResponses<ClientResponse> userResponses;

    public PlantillaResponse<ClientResponse> add(ClienteDTO clientRequest){
        if (!clientService.byId(clientRequest.getId())) {
            return clientService.add(clientRequest);
        } else {
            return userResponses.buildResponse(ResponseType.USER_ISFOUND.getCode(), ClientResponse.builder().build());
        }
    }

    public boolean byId(Long id) {
        return clientService.byId(id);
    }
}
