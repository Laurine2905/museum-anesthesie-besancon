package jfc.isis.dao;

import jfc.isis.entity.Objet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObjetRepository extends JpaRepository<Objet, Integer> {

    Objet findByNom(String nom);

}