package com.juliaosystem.api.mappers;

import com.juliaosystem.api.dtos.request.ClientRequest;
import com.juliaosystem.api.dtos.response.CreditoResponse;
import com.juliaosystem.infrastructure.entitis.Credito;
import org.mapstruct.*;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface CreditoMapper {

       DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

       @Mapping(target = "cliente.informacionLaboral.fechaVinculacion", source = "cliente.informacionLaboral.fechaVinculacion", qualifiedByName = "stringToLocalDateTime")
       Credito mapToEntity(ClientRequest source);

       @Mapping(target = "informacionLaboral.fechaVinculacion", source = "informacionLaboral.fechaVinculacion", qualifiedByName = "localDateTimeToString")
       CreditoResponse mapToResponse(Credito source);

       List<CreditoResponse> mapToResponse(List<Credito> source);

       @Named("stringToLocalDateTime")
       default LocalDateTime stringToLocalDateTime(String dateStr) {
              return dateStr != null ? LocalDateTime.parse(dateStr, FORMATTER) : null;
       }

       @Named("localDateTimeToString")
       default String localDateTimeToString(LocalDateTime date) {
              return date != null ? date.format(FORMATTER) : null;
       }
}
