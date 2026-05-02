package com.colegio.msgestionacademica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.colegio.msgestionacademica.model.UsuarioCurso;
import com.colegio.msgestionacademica.service.UsuarioCursoService;

@RestController
@RequestMapping("/api/usuariosCurso")
public class UsuarioCursoController {
    @Autowired
    private UsuarioCursoService usuarioCursoService;

    @GetMapping
    public ResponseEntity<List<UsuarioCurso>> getAllUsuariosCurso() {
        List<UsuarioCurso> usuariosCurso = usuarioCursoService.getAllUsuarioCursos();
        if (usuariosCurso.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(usuariosCurso);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioCurso> getUsuarioCursoById(@PathVariable Long id) {
        UsuarioCurso usuarioCurso = usuarioCursoService.getUsuarioCursoById(id);
        if (usuarioCurso == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuarioCurso);
    }

    @PostMapping
    public ResponseEntity<UsuarioCurso> createUsuarioCurso(@RequestBody UsuarioCurso usuarioCurso) {
        UsuarioCurso createdUsuarioCurso = usuarioCursoService.createUsuarioCurso(usuarioCurso);
        return ResponseEntity.status(201).body(createdUsuarioCurso);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioCurso> updateUsuarioCurso(@PathVariable Long id, @RequestBody UsuarioCurso usuarioCurso) {
        usuarioCurso.setId(id);
        UsuarioCurso updatedUsuarioCurso = usuarioCursoService.createUsuarioCurso(usuarioCurso);
        if (updatedUsuarioCurso == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedUsuarioCurso);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuarioCurso(@PathVariable Long id) {
        usuarioCursoService.deleteUsuarioCurso(id);
        return ResponseEntity.noContent().build();
    }
}