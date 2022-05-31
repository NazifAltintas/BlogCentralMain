package be.intecbrussel.repository;

import be.intecbrussel.data.Auteur;

import org.springframework.data.jpa.repository.JpaRepository;


public interface AuteurRepository extends JpaRepository<Auteur,Integer> {
}


