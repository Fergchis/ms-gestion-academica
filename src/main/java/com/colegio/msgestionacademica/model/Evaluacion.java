package com.colegio.msgestionacademica.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
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

    @Column
    private String unidad; // esta wea no se si va aqui o en asignatura
    // no se que poner aqui, se que esto esta conectado con asignatura, nota y alumno, necesita algo mas? maybe fecha?
    // donde mierda incluyo puntaje total y puntaje obtenido?

    @OneToOne
    private CargaAcademica cargaAcademica;
}