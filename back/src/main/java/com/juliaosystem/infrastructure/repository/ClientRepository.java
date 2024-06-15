package com.juliaosystem.infrastructure.repository;

import com.juliaosystem.infrastructure.entitis.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Cliente, Long> {
}
