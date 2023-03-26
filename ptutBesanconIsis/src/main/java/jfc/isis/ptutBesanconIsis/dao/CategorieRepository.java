package jfc.isis.ptutBesanconIsis.dao;

import jakarta.persistence.Tuple;
import jfc.isis.ptutBesanconIsis.entity.Categorie;
import jfc.isis.ptutBesanconIsis.entity.Objet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.TreeSet;

public interface CategorieRepository extends JpaRepository<Categorie, Integer> {

    Categorie findByCategorieNom(String categorieNom);

    // SQL : formulée sur le modèle logique de données, il faut connaître la clé étrangère
    @Query(value="SELECT * FROM Categorie", nativeQuery = true)
    TreeSet<Categorie> listeDesCategories();

}