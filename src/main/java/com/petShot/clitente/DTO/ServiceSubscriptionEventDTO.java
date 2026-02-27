package com.petShot.clitente.DTO;

import com.petShot.clitente.enums.TypeService;
import lombok.Data;

import java.util.UUID;

@Data
public class ServiceSubscriptionEventDTO {

    private UUID tenentId;
    private String tenantName;
    private TypeService typeService;
    private String adminEmail;


    public ServiceSubscriptionEventDTO(){}

    public ServiceSubscriptionEventDTO(
            UUID tenentId,
            String tenantName,
            TypeService typeService,
            String adminEmail
    ){
       this.tenentId = tenentId;
       this.tenantName = tenantName;
       this.typeService = typeService;
       this.adminEmail = adminEmail;
    }
}
