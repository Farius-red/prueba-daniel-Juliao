package com.juliaosystem.infrastructure.services.primary;

import com.juliaosystem.api.dtos.ClienteDTO;
import com.juliaosystem.api.dtos.request.ClientRequest;
import com.juliaosystem.api.dtos.response.ClientResponse;
import com.juliaosystem.infrastructure.adapters.primary.ClientImpl;
import com.juliaosystem.utils.PlantillaResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService {

    private  final ClientImpl clientImpl;

    public PlantillaResponse<ClientResponse> add(ClienteDTO request) {
        return  clientImpl.add(request);
    }

    public boolean byId(Long id) {
        return  clientImpl.byId(id);
    }
}
