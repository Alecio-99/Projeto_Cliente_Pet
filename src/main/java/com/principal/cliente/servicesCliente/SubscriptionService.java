package com.principal.cliente.servicesCliente;

import com.principal.cliente.DTO.ClientDTO;
import com.principal.cliente.DTO.ServiceSubscriptionEventDTO;
import com.principal.cliente.entity.Cliente;
import com.principal.cliente.entity.Price;
import com.principal.cliente.entity.Product;
import com.principal.cliente.enums.SubscriptionStatus;
import com.principal.cliente.repository.ClienteRepository;
import com.principal.cliente.repository.PriceRepository;
import com.principal.cliente.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SubscriptionService {


    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private PriceRepository priceRepository;

    @Autowired
    private PrimeiroCadastroCliente primeiroCadastroCliente;


    private final ClienteRepository repository;
    private final SubscriptionProducer producer;

    public SubscriptionService(
            ClienteRepository repository,
            SubscriptionProducer producer
    ){
        this.repository = repository;
        this.producer = producer;
    }

    public void subscribe(ServiceSubscriptionEventDTO dto){

        Product product = productRepository.findById(dto.getProductId())
                .orElseThrow(() -> new RuntimeException("Produto nao encontrado"));

        Price price = priceRepository.findByProduct(product)
                .orElseThrow(() -> new RuntimeException("Preco nao encontrado"));

        Cliente entity = new Cliente();

        entity.setTenantId(dto.getTenentId());
        entity.setPrice(price);
        entity.setPriceValue(price.getPrice());
        entity.setStatus(SubscriptionStatus.ACTIVE);
        entity.setCreatedAt(LocalDateTime.now());

        repository.save(entity);

        producer.sendSubscriptionEvent(
                new ServiceSubscriptionEventDTO(
                        dto.getTenentId(),
                        dto.getNomeEscritorio(),
                        dto.getProductId(),
                        dto.getEmail()
                )
        );
    }

    public void primeiroCadastro(ClientDTO clientDTO){
        primeiroCadastroCliente.primeiroCadastro(clientDTO);

    }

}
