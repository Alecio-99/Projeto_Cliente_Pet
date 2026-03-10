package com.principal.clitente.controllercliente;


import com.principal.clitente.DTO.ServiceSubscriptionEventDTO;
import com.principal.clitente.servicesCliente.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/subscription")
public class SubscriptionController {

    @Autowired
    private SubscriptionService service;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ServiceSubscriptionEventDTO dto){
        service.subscribe(dto);
        return ResponseEntity.ok().build();
    }
}
