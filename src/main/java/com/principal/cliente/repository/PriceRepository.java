package com.principal.cliente.repository;

import com.principal.cliente.entity.Price;
import com.principal.cliente.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {

    Optional<Price> findByProduct(Product product);
}
