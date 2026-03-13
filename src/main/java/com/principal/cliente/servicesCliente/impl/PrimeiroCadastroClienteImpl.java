package com.principal.cliente.servicesCliente.impl;

import com.principal.cliente.DTO.ClientDTO;
import com.principal.cliente.DTO.DadosEnderecoDTO;
import com.principal.cliente.entity.Cliente;
import com.principal.cliente.entity.Endereco;
import com.principal.cliente.enums.SubscriptionStatus;
import com.principal.cliente.repository.ClienteRepository;
import com.principal.cliente.servicesCliente.PrimeiroCadastroCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class PrimeiroCadastroClienteImpl implements PrimeiroCadastroCliente {

    @Autowired
    private ClienteRepository clienteRepository;


    @Override
    public Cliente primeiroCadastro(ClientDTO clientDTO) {

            Cliente entity = new Cliente();

            entity.setTenantId(clientDTO.tenantId());
            entity.setName(clientDTO.name());
            entity.setNomeEscritorio(clientDTO.nomeEscritorio());
            entity.setEmail(clientDTO.email());
            entity.setPassword(clientDTO.password());
            entity.setCnpj(clientDTO.cnpj());
            entity.setPhone(clientDTO.phone());
            entity.setEndereco( new Endereco(clientDTO.dadosEnderecoDTO()));
            entity.setStatus(SubscriptionStatus.PASSIVE);
            entity.setCreatedAt(LocalDateTime.now());

           return clienteRepository.save(entity);
    }

}
