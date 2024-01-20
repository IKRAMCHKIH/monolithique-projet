package com.example.architecturemono.controllers;


import com.example.architecturemono.Models.Etudiant;
import com.example.architecturemono.services.EtudiantService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GraphQlController implements GraphQLQueryResolver, GraphQLMutationResolver {
    private final EtudiantService etudiantService;

    public List<Etudiant> etudiants() {
        return etudiantService.getAllEtudiants();
    }

    public Etudiant etudiant(int id) {
        return etudiantService.getEtudiantById(id);
    }

    public Etudiant ajouterEtudiant(String nom, String prenom) {
        Etudiant nouvelEtudiant = new Etudiant();
        nouvelEtudiant.setNom(nom);
        nouvelEtudiant.setPrenom(prenom);
        return etudiantService.ajouterEtudiant(nouvelEtudiant);
    }

    public Etudiant modifierEtudiant(int id, String nom, String prenom) {
        Etudiant etudiant = etudiantService.getEtudiantById(id);
        if (etudiant != null) {
            etudiant.setNom(nom);
            etudiant.setPrenom(prenom);
            return etudiantService.modifierEtudiant(id, etudiant);
        } else {
            return null;
        }
    }

    public void supprimerEtudiant(int id) {
        etudiantService.supprimerEtudiant(id);
    }
}
