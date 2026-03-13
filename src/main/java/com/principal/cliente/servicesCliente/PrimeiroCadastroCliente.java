package com.principal.cliente.servicesCliente;

import com.principal.cliente.DTO.ClientDTO;
import com.principal.cliente.entity.Cliente;

public interface PrimeiroCadastroCliente {

    Cliente primeiroCadastro(ClientDTO clientDTO);
}
