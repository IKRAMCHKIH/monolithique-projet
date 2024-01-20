package com.example.architecturemono.Repo;

import com.example.architecturemono.Models.Etudiant;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EtudiantRepository extends JpaRepository<Etudiant, Integer> {
}
