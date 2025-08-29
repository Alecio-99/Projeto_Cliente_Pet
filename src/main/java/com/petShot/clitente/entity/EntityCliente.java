package com.petShot.clitente.entity;

import com.petShot.clitente.DTO.ClienteDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "cliente")
public class EntityCliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private String telefone;
    private String cep;
    private String endereco;
    private String password;

    public EntityCliente(ClienteDTO clienteDTO){
        this.nome = clienteDTO.nome();
        this.email = clienteDTO.email();
        this.cpf = clienteDTO.cpf();
        this.telefone = clienteDTO.telefone();
        this.cep = clienteDTO.cep();
        this.endereco = clienteDTO.endereco();
        this.password = clienteDTO.password();
    }

}