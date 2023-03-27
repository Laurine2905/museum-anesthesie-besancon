package jfc.isis.dao;

import jfc.isis.entity.Objet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.TreeSet;

public interface ObjetRepository extends JpaRepository<Objet, Integer> {

    Objet findByNom(String nom);

    // requête SQL retournant la liste des objets d'une catégorie triés par ordre alphabétique
    @Query(value="SELECT * FROM Objet WHERE categorie_id = :idDeLaCategorie", nativeQuery = true)
    TreeSet<Objet> getObjetsParCategorie(int idDeLaCategorie);

}