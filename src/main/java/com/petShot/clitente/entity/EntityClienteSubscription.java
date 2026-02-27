package com.petShot.clitente.entity;

import com.petShot.clitente.enums.SubscriptionStatus;
import com.petShot.clitente.enums.TypeService;
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
public class EntityClienteSubscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UUID tenantId;

    @Enumerated(EnumType.STRING)
    private TypeService typeService;

    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private SubscriptionStatus status;

    private LocalDateTime createdAt;

}