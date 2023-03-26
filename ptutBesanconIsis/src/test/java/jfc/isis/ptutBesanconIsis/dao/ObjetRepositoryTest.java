package jfc.isis.ptutBesanconIsis.dao;

import jfc.isis.ptutBesanconIsis.entity.Categorie;
import jfc.isis.ptutBesanconIsis.entity.Objet;
import org.junit.jupiter.api.Test;
//import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.TreeSet;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.hibernate.validator.internal.util.Contracts.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

//@Log4j2
@DataJpaTest
public class ObjetRepositoryTest {

    @Autowired
    private ObjetRepository objetDAO;

    @Test
    public void testFindByObjetNom() {
        Objet found = objetDAO.findByObjetNom("Heidbrink");
        assertEquals(found.getObjetNom(), "Heidbrink");
    }

    @Test
    void renvoieListeVideSiPasdObjet() {
        TreeSet<Objet> vide = new TreeSet<>();
        assertEquals(objetDAO.getObjetsParCategorie(2),vide,
                "La requête renvoie une liste vide si la catégorie n'a pas d'objet");
    }

    @Test
    public void testTailleGetObjetsParCategorie() {
        TreeSet<Objet> objets = objetDAO.getObjetsParCategorie(1);
        assertEquals(objets.size(),1,"La requête renvoie une liste contenant 1 objet pour la catégorie 1");
    }

    @Test
    void testContenuGetObjetsParCategorie() {
        TreeSet<Objet> objets = objetDAO.getObjetsParCategorie(1);
        Objet objet1 = objetDAO.findByObjetNom("Heidbrink");
        assertTrue(objets.contains(objet1), "La liste des objets de la catégorie 1 (Appareils d anesthésie) contient l'objet 1 (Heidbrink)");
    }

}
