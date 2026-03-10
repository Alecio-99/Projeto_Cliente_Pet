package com.principal.clitente.repository;

import com.principal.clitente.entity.Price;
import com.principal.clitente.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {

    Optional<Price> findByProduct(Product product);
}
