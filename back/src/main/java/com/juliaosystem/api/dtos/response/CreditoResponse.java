package com.juliaosystem.api.dtos.response;

import com.juliaosystem.api.dtos.LineaCreditoDTO;
import com.juliaosystem.infrastructure.entitis.LineaCredito;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CreditoResponse {

    private Long id;
    private Boolean aprobado;
}
