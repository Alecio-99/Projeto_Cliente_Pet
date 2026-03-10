package com.principal.clitente.DTO;

import com.principal.clitente.entity.Product;
import com.principal.clitente.enums.TypeService;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data

public class ServiceSubscriptionEventDTO implements Serializable {

    private UUID tenentId;
    private String tenantName;
    private Long productId;
    private String adminEmail;


    public ServiceSubscriptionEventDTO(){}

    public ServiceSubscriptionEventDTO(
            UUID tenentId,
            String tenantName,
            Long productId,
            String adminEmail
    ){
        this.tenentId = tenentId;
        this.tenantName = tenantName;
        this.productId = productId;
        this.adminEmail = adminEmail;
    }
}
