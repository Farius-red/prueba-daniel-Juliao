package com.juliaosystem.api.mappers;

import com.juliaosystem.api.dtos.ClienteDTO;
import com.juliaosystem.api.dtos.response.ClientResponse;
import com.juliaosystem.infrastructure.entitis.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.NullValueCheckStrategy;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ClientMapper {

    DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    @Mapping(target = "informacionLaboral.fechaVinculacion", source = "informacionLaboral.fechaVinculacion", qualifiedByName = "stringToLocalDateTime")
    Cliente mapToEntity(ClienteDTO source);

    ClientResponse mapToResponse(Cliente save);

    @Named("stringToLocalDateTime")
    default LocalDateTime stringToLocalDateTime(String dateStr) {
        return dateStr != null ? LocalDateTime.parse(dateStr, FORMATTER) : null;
    }
}
