package jfc.isis.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import jfc.isis.entity.Categorie;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategorieRepository extends JpaRepository<Categorie, Integer> {

    Categorie findByNom(String nom);

}