package com.colegio.msgestionacademica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colegio.msgestionacademica.model.Curso;
import com.colegio.msgestionacademica.repository.CursoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
@SuppressWarnings("null")
public class CursoService {
    @Autowired
    private CursoRepository cursoRepository;

    public List<Curso> getAllCursos() {
        return cursoRepository.findAll();
    }

    public Curso getCursoById(Long id) {
        Curso curso = cursoRepository.findById(id).orElse(null);
        return curso;
    }

    public Curso createCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    public Curso updateCurso(Curso curso) {
        Curso existingCurso = cursoRepository.findById(curso.getId()).orElse(null);
        if (existingCurso != null) {
            if (curso.getNombre() != null) {
                existingCurso.setNombre(curso.getNombre());
            }
            return cursoRepository.save(existingCurso);
        }
        return null;
    }

    public void deleteCurso(Long id) {
        cursoRepository.deleteById(id);
    }
}