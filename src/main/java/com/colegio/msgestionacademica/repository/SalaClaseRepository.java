package com.colegio.msgestionacademica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.colegio.msgestionacademica.model.SalaClase;

@Repository
public interface SalaClaseRepository extends JpaRepository<SalaClase, Long> {
}