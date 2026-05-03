package com.colegio.msgestionacademica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.colegio.msgestionacademica.model.SalaClase;
import com.colegio.msgestionacademica.service.SalaClaseService;

@RestController
@RequestMapping("/api/salasClase")
public class SalaClaseController {
    @Autowired
    private SalaClaseService salaClaseService;

    @GetMapping
    public ResponseEntity<List<SalaClase>> getAllSalasClase() {
        List<SalaClase> salasClase = salaClaseService.getAllSalasClase();
        if (salasClase.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(salasClase);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalaClase> getSalaClaseById(@PathVariable Long id) {
        SalaClase salaClase = salaClaseService.getSalaClaseById(id);
        if (salaClase == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(salaClase);
    }

    @PostMapping
    public ResponseEntity<SalaClase> createSalaClase(@RequestBody SalaClase salaClase) {
        SalaClase createdSalaClase = salaClaseService.createSalaClase(salaClase);
        return ResponseEntity.status(201).body(createdSalaClase);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SalaClase> updateSalaClase(@PathVariable Long id, @RequestBody SalaClase salaClase) {
        salaClase.setId(id);
        SalaClase updatedSalaClase = salaClaseService.createSalaClase(salaClase);
        if (updatedSalaClase == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedSalaClase);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<SalaClase> patchSalaClase(@PathVariable Long id, @RequestBody SalaClase salaClase) {
        salaClase.setId(id);
        SalaClase patchedSalaClase = salaClaseService.updateSalaClase(salaClase);
        if (patchedSalaClase == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(patchedSalaClase);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSalaClase(@PathVariable Long id) {
        salaClaseService.deleteSalaClase(id);
        return ResponseEntity.noContent().build();
    }
}