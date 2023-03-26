package jfc.isis.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import jfc.isis.entity.Categorie;
public interface CategorieRepository extends JpaRepository <Categorie, Integer> {

}