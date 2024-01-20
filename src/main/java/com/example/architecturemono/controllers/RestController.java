package com.example.architecturemono.controllers;


import com.example.architecturemono.Models.Etudiant;
import com.example.architecturemono.services.EtudiantService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/etudiants")
@RequiredArgsConstructor
public class RestController {
    private final EtudiantService etudiantService;

    @GetMapping
    public List<Etudiant> getEtudiants() {
        return etudiantService.getAllEtudiants();
    }

    @GetMapping("/{id}")
    public Etudiant getEtudiant(@PathVariable int id) {
        return etudiantService.getEtudiantById(id);
    }

    @PostMapping
    public Etudiant ajouterEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.ajouterEtudiant(etudiant);
    }

    @PutMapping("/{id}")
    public Etudiant modifierEtudiant(@PathVariable int id, @RequestBody Etudiant etudiant) {
        return etudiantService.modifierEtudiant(id, etudiant);
    }

    @DeleteMapping("/{id}")
    public void supprimerEtudiant(@PathVariable int id) {
        etudiantService.supprimerEtudiant(id);
    }
}
