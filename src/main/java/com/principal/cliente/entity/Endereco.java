package com.principal.cliente.entity;


import com.principal.cliente.DTO.DadosEnderecoDTO;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;

@Embeddable
@AllArgsConstructor
@Data
public class Endereco {

    private String rua;
    private String numero;
    private String bairro;
    private String uf;
    private String cidade;
    private String cep;

    public Endereco(){

    }
    public Endereco(DadosEnderecoDTO dadosEnderecoDTO){
        this.rua = dadosEnderecoDTO.rua();
        this.numero = dadosEnderecoDTO.rua();
        this.bairro = dadosEnderecoDTO.bairro();
        this.uf = dadosEnderecoDTO.uf();
        this.cidade = dadosEnderecoDTO.cidade();
        this.cep = dadosEnderecoDTO.cep();
    }
}
