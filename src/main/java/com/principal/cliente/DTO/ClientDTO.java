package com.principal.cliente.DTO;

import com.principal.cliente.enums.SubscriptionStatus;

import java.time.LocalDateTime;
import java.util.UUID;


public record ClientDTO(
       UUID tenantId,
        String name,
        String nomeEscritorio,
        String email,
        String password,
        String cnpj,
        String phone,
        DadosEnderecoDTO dadosEnderecoDTO,
         LocalDateTime createdAt
) {
}
