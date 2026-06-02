package com.colegio.msgestionacademica.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "evaluaciones")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Evaluacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 60)
    private String nombre;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(nullable = false)
    private Double ponderacion;

    @ManyToOne
    @JoinColumn(name = "cargaAcademica_id", nullable = false)
    private CargaAcademica cargaAcademica;
}