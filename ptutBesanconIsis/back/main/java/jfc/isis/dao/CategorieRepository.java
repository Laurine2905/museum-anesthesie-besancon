package jfc.isis.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import back.main.java.jfc.isis.entity.Categorie;
public interface CategorieRepository extends JpaRepository <Categorie, Integer> {

}