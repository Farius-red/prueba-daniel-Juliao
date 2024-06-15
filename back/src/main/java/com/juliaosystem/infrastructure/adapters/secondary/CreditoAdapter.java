package com.juliaosystem.infrastructure.adapters.secondary;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.juliaosystem.api.dtos.request.ClientRequest;
import com.juliaosystem.api.dtos.response.CreditoResponse;
import com.juliaosystem.api.mappers.CreditoMapper;
import com.juliaosystem.infrastructure.repository.CreditoRepository;
import com.juliaosystem.infrastructure.services.secondary.CreditoServiceInter;
import com.juliaosystem.utils.AbtractError;
import com.juliaosystem.utils.PlantillaResponse;
import com.juliaosystem.utils.UserResponses;
import com.juliaosystem.utils.enums.MensajesRespuesta;
import com.juliaosystem.utils.enums.ResponseType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreditoAdapter implements CreditoServiceInter {

    private final CreditoRepository creditoRepository;
    private final CreditoMapper creditoMapper;
    private final UserResponses<CreditoResponse> userResponses;
    private static final ObjectMapper OBJECT_MAPPER =
            new ObjectMapper().registerModule(new JavaTimeModule());

    private  final AbtractError abtractError;

    @Override
    public PlantillaResponse<CreditoResponse> add(ClientRequest request) {
        try {
           var credito = creditoMapper.mapToEntity(request);
           var response = creditoMapper.mapToResponse(creditoRepository.save(credito));
            abtractError.logInfo("CreditoAdapter.add():" +  MensajesRespuesta.CREADO +  OBJECT_MAPPER.writeValueAsString(response));
            return   userResponses.buildResponse(ResponseType.CREATED.getCode(),response);
        }catch (Exception e){
            abtractError.logError(e);
            return   userResponses.buildResponse(ResponseType.FALLO.getCode(), CreditoResponse.builder().build());
        }
    }

    @Override
    public PlantillaResponse<CreditoResponse> all() {
        try {
            var response = creditoMapper.mapToResponse(creditoRepository.findAll());
            abtractError.logInfo("CreditoAdapter.all():" +  MensajesRespuesta.GET +  OBJECT_MAPPER.writeValueAsString(response));
            return   userResponses.buildResponse(ResponseType.GET.getCode(),CreditoResponse.builder().build(),response);

        }catch (Exception e){
            abtractError.logError(e);
            return   userResponses.buildResponse(ResponseType.FALLO.getCode(), CreditoResponse.builder().build());
        }
    }

    @Override
    public Boolean byId(Long id) {
            return creditoRepository.findById(id).isPresent();
    }


}
