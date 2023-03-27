package jfc.isis.dao;

import jfc.isis.entity.Objet;
import org.springframework.data.jpa.repository.JpaRepository;
import jfc.isis.entity.Categorie;
import org.springframework.data.jpa.repository.Query;

import java.util.TreeSet;

public interface CategorieRepository extends JpaRepository <Categorie, Integer> {

    Categorie findByNom(String nom);

    // requête SQL retournant la liste des catégories triées par ordre alphabétique
    @Query(value="SELECT * FROM Categorie", nativeQuery = true)
    TreeSet<Categorie> listeDesCategories();

}