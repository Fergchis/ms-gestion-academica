package com.colegio.msgestionacademica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colegio.msgestionacademica.model.UsuarioCurso;
import com.colegio.msgestionacademica.repository.UsuarioCursoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
@SuppressWarnings("null")
public class UsuarioCursoService {
    @Autowired
    private UsuarioCursoRepository usuarioCursoRepository;

    public List<UsuarioCurso> getAllUsuarioCursos() {
        return usuarioCursoRepository.findAll();
    }

    public UsuarioCurso getUsuarioCursoById(Long id) {
        UsuarioCurso usuarioCurso = usuarioCursoRepository.findById(id).orElse(null);
        return usuarioCurso;
    }

    public UsuarioCurso createUsuarioCurso(UsuarioCurso usuarioCurso) {
        return usuarioCursoRepository.save(usuarioCurso);
    }

    public void deleteUsuarioCurso(Long id) {
        usuarioCursoRepository.deleteById(id);
    }
}