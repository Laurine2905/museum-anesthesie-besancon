package jfc.isis.dao;

import jfc.isis.dao.CategorieRepository;
import jfc.isis.entity.Categorie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.hibernate.validator.internal.util.Contracts.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class CategorieRepositoryTest {

    @Autowired
    private CategorieRepository categorieDAO;

    @Test
    public void testFindByCategorieNom() {
        Categorie found = categorieDAO.findByNom("Appareils d anesthésie");
        assertEquals(found.getNom(), "Appareils d anesthésie");
    }

    @Test
    void testTailleListeDesCategories() {
        assertEquals(categorieDAO.findAll().size(), 3, "La liste contient 3 catégories");
    }

    @Test
    void testContenuListeDesCategories() {
        Categorie categorie1 = categorieDAO.findByNom("Appareils d anesthésie");
        assertTrue(categorieDAO.findAll().contains(categorie1),
                "La liste contient la catégorie 1 (Appareils d anesthésie)");
    }

}
