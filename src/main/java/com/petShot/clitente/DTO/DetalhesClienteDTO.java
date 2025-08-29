package com.petShot.clitente.DTO;

import com.petShot.clitente.entity.EntityCliente;

public record DetalhesClienteDTO(Long id, String nome, String email, String cpf, String telefone, String cep, String endereco) {
    public DetalhesClienteDTO(EntityCliente entityCliente){
        this(entityCliente.getId(), entityCliente.getNome(), entityCliente.getEmail(), entityCliente.getCpf(), entityCliente.getTelefone(), entityCliente.getCep(), entityCliente.getEndereco());
    }
}
