package com.petShot.clitente.repository;

import com.petShot.clitente.entity.EntityCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<EntityCliente, Long> {

    Optional<EntityCliente> findByCpf (String cpf);
    UserDetails findByEmail (String email);
}
