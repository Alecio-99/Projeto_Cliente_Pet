package com.principal.cliente.controllercliente;

import com.principal.cliente.DTO.ClientDTO;
import com.principal.cliente.servicesCliente.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cadastro")
public class PrimeiroCadastroController {

    @Autowired
    private SubscriptionService service;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ClientDTO dto){
        service.primeiroCadastro(dto);
        return ResponseEntity.ok().build();
    }
}
