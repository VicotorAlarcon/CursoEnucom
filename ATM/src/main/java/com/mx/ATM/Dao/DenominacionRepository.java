package com.mx.ATM.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.ATM.Entity.Cajero;

public interface DenominacionRepository extends JpaRepository<Cajero, Long> {
    List<Cajero> findAllByOrderByDenominaionDesc();
} 


