package com.principal.clitente.entity;

import com.principal.clitente.enums.SubscriptionStatus;
import com.principal.clitente.enums.TypeService;
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

    @Enumerated(EnumType.STRING)
    private TypeService typeService;

    @ManyToOne
    @JoinColumn(name = "price_id")
    private Price price;

    private BigDecimal priceValue;

    @Enumerated(EnumType.STRING)
    private SubscriptionStatus status;

    private LocalDateTime createdAt;

}