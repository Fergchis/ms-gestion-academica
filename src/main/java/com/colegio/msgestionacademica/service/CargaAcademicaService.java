package com.colegio.msgestionacademica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colegio.msgestionacademica.model.CargaAcademica;
import com.colegio.msgestionacademica.repository.CargaAcademicaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
@SuppressWarnings("null")
public class CargaAcademicaService {
    @Autowired
    private CargaAcademicaRepository cargaAcademicaRepository;

    public List<CargaAcademica> getAllCargasAcademicas() {
        return cargaAcademicaRepository.findAll();
    }

    public CargaAcademica getCargaAcademicaById(Long id) {
        CargaAcademica cargaAcademica = cargaAcademicaRepository.findById(id).orElse(null);
        return cargaAcademica;
    }

    public CargaAcademica createCargaAcademica(CargaAcademica cargaAcademica) {
        return cargaAcademicaRepository.save(cargaAcademica);
    }

    public CargaAcademica updateCargaAcademica(CargaAcademica cargaAcademica) {
        CargaAcademica existingCargaAcademica = cargaAcademicaRepository.findById(cargaAcademica.getId()).orElse(null);
        if (existingCargaAcademica != null) {
            if (cargaAcademica.getDiaSemana() != null) {
                existingCargaAcademica.setDiaSemana(cargaAcademica.getDiaSemana());
            }
            return cargaAcademicaRepository.save(existingCargaAcademica);
        }
        return null;
    }

    public void deleteCargaAcademica(Long id) {
        cargaAcademicaRepository.deleteById(id);
    }
}