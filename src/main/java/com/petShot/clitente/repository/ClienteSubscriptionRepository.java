package com.petShot.clitente.repository;

import com.petShot.clitente.entity.EntityClienteSubscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ClienteSubscriptionRepository extends JpaRepository<EntityClienteSubscription, Long> {

    List<EntityClienteSubscription> findByTenantId(UUID tenantId);
}
