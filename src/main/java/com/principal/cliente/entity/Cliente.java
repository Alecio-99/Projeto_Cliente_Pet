package com.principal.cliente.entity;

import com.principal.cliente.enums.SubscriptionStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "subscription")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UUID tenantId;

    private String name;

    private String nomeEscritorio;

    private String email;

    private String password;

    private String cnpj;

    private String phone;

    @Embedded
    private Endereco endereco;

    @ManyToOne
    @JoinColumn(name = "price_id")
    private Price price;

    private BigDecimal priceValue;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private SubscriptionStatus status;

    private LocalDateTime createdAt;

}