package jfc.isis.ptutBesanconIsis.dao;

import jfc.isis.ptutBesanconIsis.entity.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository <Categorie, Integer> {

}