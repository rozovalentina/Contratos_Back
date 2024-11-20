package com.example.parcial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.parcial.entity.Contrato;

@Repository
public interface ContratoRepository extends JpaRepository<Contrato, Long> {
}
