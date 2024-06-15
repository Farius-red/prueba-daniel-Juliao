package com.juliaosystem.api.dtos.request;

import com.juliaosystem.api.dtos.ClienteDTO;
import com.juliaosystem.api.dtos.CreditoDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ClientRequest {


        private ClienteDTO cliente;
        private CreditoDTO credito;
}
