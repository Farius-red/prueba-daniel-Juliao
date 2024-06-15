package com.juliaosystem.infrastructure.adapters.secondary;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.juliaosystem.api.dtos.ClienteDTO;
import com.juliaosystem.api.dtos.response.ClientResponse;
import com.juliaosystem.api.mappers.ClientMapper;
import com.juliaosystem.infrastructure.repository.ClientRepository;
import com.juliaosystem.infrastructure.services.secondary.ClientServiceInter;
import com.juliaosystem.utils.AbtractError;
import com.juliaosystem.utils.PlantillaResponse;
import com.juliaosystem.utils.UserResponses;
import com.juliaosystem.utils.enums.MensajesRespuesta;
import com.juliaosystem.utils.enums.ResponseType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientAdapter  implements ClientServiceInter {

    private final ClientRepository clientRepository;
    private final UserResponses<ClientResponse> clientResponseUserResponses;
    private static final ObjectMapper OBJECT_MAPPER =
            new ObjectMapper().registerModule(new JavaTimeModule());

    private  final AbtractError abtractError;

    private  final ClientMapper clientMapper;


    @Override
    public boolean byId(Long id) {
        return clientRepository.findById(id).isPresent();
    }

    @Override
    public PlantillaResponse<ClientResponse> add(ClienteDTO request) {
        try {
            var cliente = clientMapper.mapToEntity(request);
            var response = clientMapper.mapToResponse(clientRepository.save(cliente));
            abtractError.logInfo("ClientAdapter.add():" +  MensajesRespuesta.CREADO +  OBJECT_MAPPER.writeValueAsString(response));
            return   clientResponseUserResponses.buildResponse(ResponseType.CREATED.getCode(),response);
        }catch (Exception e){
            abtractError.logError(e);
            return   clientResponseUserResponses.buildResponse(ResponseType.FALLO.getCode(), ClientResponse.builder().build());
        }
    }
}
