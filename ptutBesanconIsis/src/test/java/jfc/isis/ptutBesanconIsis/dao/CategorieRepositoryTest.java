package jfc.isis.ptutBesanconIsis.dao;

import jfc.isis.ptutBesanconIsis.entity.Categorie;
import jfc.isis.ptutBesanconIsis.entity.Objet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import static org.hibernate.validator.internal.util.Contracts.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class CategorieRepositoryTest {

    @Autowired
    private CategorieRepository categorieDAO;

    @Test
    public void testFindByCategorieNom() {
        Categorie found = categorieDAO.findByCategorieNom("Appareils d anesthésie");
        assertEquals(found.getCategorieNom(), "Appareils d anesthésie");
    }

    @Test
    void testTailleListeDesCategories() {
        assertEquals(categorieDAO.listeDesCategories().size(),3, "La liste contient 3 catégories");
    }

    @Test
    void testContenuListeDesCategories() {
        Categorie categorie1 = categorieDAO.findByCategorieNom("Appareils d anesthésie");
        assertTrue(categorieDAO.listeDesCategories().contains(categorie1), "La liste contient la catégorie 1 (Appareils d anesthésie)");
    }

}
