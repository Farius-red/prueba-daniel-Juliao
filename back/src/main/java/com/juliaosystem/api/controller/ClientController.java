package com.juliaosystem.api.controller;

import com.juliaosystem.api.dtos.ClienteDTO;
import com.juliaosystem.api.dtos.response.ClientResponse;
import com.juliaosystem.infrastructure.services.primary.ClientService;
import com.juliaosystem.utils.PlantillaResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
@Tag(name = "cliente", description = "Endpoints relacionados con el manejo de clientes")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ClientController {

    private final ClientService clientService;

    @Operation(summary = "add", description = "Permite agregar un credito")
    @PostMapping("/add")
    public ResponseEntity<PlantillaResponse<ClientResponse>> add(
            @RequestBody ClienteDTO request) {
        var response = clientService.add(request);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }
}
