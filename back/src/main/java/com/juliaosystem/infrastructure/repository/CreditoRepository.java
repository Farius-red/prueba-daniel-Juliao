package com.juliaosystem.infrastructure.repository;

import com.juliaosystem.infrastructure.entitis.Credito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditoRepository extends JpaRepository<Credito,Long> {
}
