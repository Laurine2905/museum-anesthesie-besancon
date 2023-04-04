package jfc.isis.service;

import jfc.isis.dao.UtilisateurRepository;
import jfc.isis.entity.Objet;
import jfc.isis.entity.Utilisateur;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
//@SpringBootTest
@DataJpaTest
class UtilisateurServiceTest {

    static final String LOGIN_ADMIN = "musee";
    static final String MDP_ADMIN = "besancon";


    @Autowired
    private UtilisateurRepository utilisateurDAO;


    UtilisateurService utilisateurService = new UtilisateurService(utilisateurDAO);

    @Test
    void testLogOk() throws Exception {
        //Utilisateur musee = new Utilisateur("musee","besancon",true);
        ////Utilisateur musee = utilisateurDAO.findByLogin("musee");
        //Utilisateur musee = new Utilisateur(admin.getLogin(), admin.getMdp(), true);
        //Utilisateur admin1 = new Utilisateur();
        //admin1.setLogin("musee");
        //admin1.setMdp("besancon");
        //Utilisateur admin = utilisateurDAO.findByLogin("musee");
        ////var auth = utilisateurService.log(musee.getLogin(), musee.getMdp());
        var auth = utilisateurService.log("musee", "besancon");
        assertTrue(auth, "L'authentification doit être réussie");
    }
/**
    @Test
    void testLogNotOk() throws Exception {
        Utilisateur musee = new Utilisateur("musee","mauvaisMdp",true);
        //Utilisateur admin1 = new Utilisateur();
        //admin1.setLogin("musee");
        //admin1.setMdp("besancon");
        //Utilisateur admin = utilisateurDAO.findByLogin("musee");
        var auth = utilisateurService.log(musee.getLogin(), musee.getMdp());
        assertFalse(auth, "L'authentification doit échouée");
    }
    */

}
