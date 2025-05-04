package it.lessons.pizzeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.lessons.pizzeria.model.Offerte;

public interface OfferteRepository extends JpaRepository<Offerte, Integer>{

}
