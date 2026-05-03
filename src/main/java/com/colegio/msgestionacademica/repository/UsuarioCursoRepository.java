package com.colegio.msgestionacademica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.colegio.msgestionacademica.model.UsuarioCurso;

@Repository
public interface UsuarioCursoRepository extends JpaRepository<UsuarioCurso, Long> {
}