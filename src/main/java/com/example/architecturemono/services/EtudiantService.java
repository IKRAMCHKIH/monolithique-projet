package com.example.architecturemono.services;

import com.example.architecturemono.Models.Etudiant;
import com.example.architecturemono.Repo.EtudiantRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EtudiantService {

    private final EtudiantRepository etudiantRepository;

    public EtudiantService(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }

    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }

    public Etudiant getEtudiantById(int id) {
        return etudiantRepository.findById(id).orElse(null);
    }

    public Etudiant ajouterEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    public Etudiant modifierEtudiant(int id, Etudiant etudiant) {
        if (etudiantRepository.existsById(id)) {
            etudiant.setId(id);
            return etudiantRepository.save(etudiant);
        } else {
            return null;
        }
    }

    public void supprimerEtudiant(int id) {
        etudiantRepository.deleteById(id);
    }
}
