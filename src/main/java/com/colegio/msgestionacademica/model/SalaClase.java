package com.colegio.msgestionacademica.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "salasClase")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SalaClase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer numSala; // saco esta wea? o creo otra tabla aparte?

    @Column // no se si dejar el lenght
    private String horario; // NI PUTA IDEA DE QUE TIPO DE DATO USAR PARA LA FECHA, ASI QUE LO DEJO COMO STRING POR AHORA
}