package com.juliaosystem.api.controller;

import com.juliaosystem.api.dtos.request.ClientRequest;
import com.juliaosystem.api.dtos.response.CreditoResponse;
import com.juliaosystem.infrastructure.services.primary.CreditoService;
import com.juliaosystem.utils.PlantillaResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/creditos")
@Tag(name = "creditos", description = "Endpoints relacionados con el manejo de creditos")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class CreditoController {

   private final CreditoService creditoService;

    @Operation(summary = "add", description = "Permite agregar un credito")
    @PostMapping("/add")
    public ResponseEntity<PlantillaResponse<CreditoResponse>>add(
            @RequestBody ClientRequest request) {
        var response = creditoService.add(request);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }

    @Operation(summary = "all creditos", description = "permite obtener lista de creditos ")
    @GetMapping("/all")
    public ResponseEntity<PlantillaResponse<CreditoResponse>> all() {
        var response = creditoService.all();
        return new ResponseEntity<>(response, response.getHttpStatus());
    }




}
