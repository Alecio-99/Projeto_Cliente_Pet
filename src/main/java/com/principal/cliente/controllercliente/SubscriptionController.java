package com.principal.cliente.controllercliente;


import com.principal.cliente.DTO.ServiceSubscriptionEventDTO;
import com.principal.cliente.servicesCliente.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subscription")
public class SubscriptionController {

    @Autowired
    private SubscriptionService service;

    @PutMapping("/{id}")
    public ResponseEntity<?> create(@PathVariable Long id, @RequestBody ServiceSubscriptionEventDTO dto){
        service.subscribe(id, dto);
        return ResponseEntity.ok().build();
    }
}
