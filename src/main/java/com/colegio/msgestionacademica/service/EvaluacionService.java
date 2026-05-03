package com.colegio.msgestionacademica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colegio.msgestionacademica.model.Evaluacion;
import com.colegio.msgestionacademica.repository.EvaluacionRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
@SuppressWarnings("null")
public class EvaluacionService {
    @Autowired
    private EvaluacionRepository evaluacionRepository;

    public List<Evaluacion> getAllEvaluaciones() {
        return evaluacionRepository.findAll();
    }

    public Evaluacion getEvaluacionById(Long id) {
        Evaluacion evaluacion = evaluacionRepository.findById(id).orElse(null);
        return evaluacion;
    }

    public Evaluacion createEvaluacion(Evaluacion evaluacion) {
        return evaluacionRepository.save(evaluacion);
    }

    public Evaluacion updateEvaluacion(Evaluacion evaluacion) {
        Evaluacion existingEvaluacion = evaluacionRepository.findById(evaluacion.getId()).orElse(null);
        if (existingEvaluacion != null) {
            if (evaluacion.getUnidad() != null) {
                existingEvaluacion.setUnidad(evaluacion.getUnidad());
            }
            return evaluacionRepository.save(existingEvaluacion);
        }
        return null;
    }

    public void deleteEvaluacion(Long id) {
        evaluacionRepository.deleteById(id);
    }
}