package jfc.isis.dao;

import jfc.isis.dao.ObjetRepository;
import jfc.isis.entity.Objet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.TreeSet;

import static org.hibernate.validator.internal.util.Contracts.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class ObjetRepositoryTest {

    @Autowired
    private ObjetRepository objetDAO;

    @Test
    public void testFindByObjetNom() {
        Objet found = objetDAO.findByNom("Heidbrink");
        assertEquals(found.getNom(), "Heidbrink");
    }

}
