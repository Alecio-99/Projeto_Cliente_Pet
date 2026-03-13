package com.principal.cliente.DTO;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data

public class ServiceSubscriptionEventDTO implements Serializable {

    private UUID tenentId;
    private String nomeEscritorio;
    private Long productId;
    private String email;


    public ServiceSubscriptionEventDTO(){}

    public ServiceSubscriptionEventDTO(
            UUID tenentId,
            String nomeEscritorio,
            Long productId,
            String email
    ){
        this.tenentId = tenentId;
        this.nomeEscritorio = nomeEscritorio;
        this.productId = productId;
        this.email = email;
    }
}
