package com.colegio.msgestionacademica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colegio.msgestionacademica.model.SalaClase;
import com.colegio.msgestionacademica.repository.SalaClaseRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
@SuppressWarnings("null")
public class SalaClaseService {
    @Autowired
    private SalaClaseRepository salaClaseRepository;

    public List<SalaClase> getAllSalasClase() {
        return salaClaseRepository.findAll();
    }

    public SalaClase getSalaClaseById(Long id) {
        SalaClase salaClase = salaClaseRepository.findById(id).orElse(null);
        return salaClase;
    }

    public SalaClase createSalaClase(SalaClase salaClase) {
        return salaClaseRepository.save(salaClase);
    }

    public SalaClase updateSalaClase(SalaClase salaClase) {
        SalaClase existingSalaClase = salaClaseRepository.findById(salaClase.getId()).orElse(null);
        if (existingSalaClase != null) {
            if (salaClase.getNumSala() != null) {
                existingSalaClase.setNumSala(salaClase.getNumSala());
            }
            if (salaClase.getHorario() != null) {
                existingSalaClase.setHorario(salaClase.getHorario());
            }
            return salaClaseRepository.save(existingSalaClase);
        }
        return null;
    }

    public void deleteSalaClase(Long id) {
        salaClaseRepository.deleteById(id);
    }
}