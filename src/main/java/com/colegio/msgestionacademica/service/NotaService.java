package com.colegio.msgestionacademica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colegio.msgestionacademica.model.Nota;
import com.colegio.msgestionacademica.repository.NotaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
@SuppressWarnings("null")
public class NotaService {
    @Autowired
    private NotaRepository notaRepository;

    public List<Nota> getAllNotas() {
        return notaRepository.findAll();
    }

    public Nota getNotaById(Long id) {
        Nota nota = notaRepository.findById(id).orElse(null);
        return nota;
    }

    public Nota createNota(Nota nota) {
        return notaRepository.save(nota);
    }

    public Nota updateNota(Nota nota) {
        Nota existingNota = notaRepository.findById(nota.getId()).orElse(null);
        if (existingNota != null) {
            if (nota.getValor() != null) {
                existingNota.setValor(nota.getValor());
            }
            return notaRepository.save(existingNota);
        }
        return null;
    }

    public void deleteNota(Long id) {
        notaRepository.deleteById(id);
    }
}