package com.principal.clitente.servicesCliente;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.principal.clitente.DTO.ServiceSubscriptionEventDTO;
import com.principal.clitente.entity.Cliente;
import com.principal.clitente.entity.Price;
import com.principal.clitente.entity.Product;
import com.principal.clitente.enums.SubscriptionStatus;
import com.principal.clitente.repository.ClienteRepository;
import com.principal.clitente.repository.PriceRepository;
import com.principal.clitente.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SubscriptionService {


    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private PriceRepository priceRepository;


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
                        dto.getTenantName(),
                        dto.getProductId(),
                        dto.getAdminEmail()
                )
        );
    }

}
