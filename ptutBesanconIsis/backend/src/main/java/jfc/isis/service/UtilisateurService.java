package jfc.isis.service;

import jakarta.transaction.Transactional;
import jfc.isis.dao.UtilisateurRepository;
import jfc.isis.entity.Categorie;
import jfc.isis.entity.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UtilisateurService {

    //@Autowired
    private final UtilisateurRepository utilisateurDAO;
//@Autowired
    public UtilisateurService(UtilisateurRepository utilisateurDAO) {
        this.utilisateurDAO = utilisateurDAO;
    }

    /**
     * Service métier : Enregistre un utilisateur
     * Règles métier :
     * - le client doit exister
     * - On initialise l'adresse de livraison avec l'adresse du client
     * - Si le client a déjà commandé plus de 100 articles, on lui offre une remise de 15%
     * @param clientCode la clé du client
     * @return la commande créée

    @Transactional
    public Utilisateur creerUtilisateur(String login) {
        // On vérifie que le client existe
        var utilisateur = utilisateurDAO.findByLogin(login);
        // On crée une commande pour ce client
        Utilisateur nouvelUtilisateur = new Utilisateur(utilisateur);
        // On initialise l'adresse de livraison avec l'adresse du client
        nouvelUtilisateur.setMdp(utilisateur.getMdp());
        // Si le client a déjà commandé plus de 100 articles, on lui offre une remise de 15%
        // La requête SQL nécessaire est définie dans l'interface ClientRepository
        var nbArticles = clientDao.nombreArticlesCommandesPar(clientCode);
        if (nbArticles > 100) {
            nouvelleCommande.setRemise(new BigDecimal("0.15"));
        }
        // On enregistre la commande (génère la clé)
        commandeDao.save(nouvelleCommande);
        return nouvelleCommande;
    }*/

    /**
     * Service métier : Permet l'authentification si le login et le mot de passe sont corrects
     * @param login l'identifiant à tester
     * @param mdp le mot de passe à tester
     * @return vrai ou faux selon si l'authentification a réussi
     */
    @Transactional
    public Boolean log(String login,String mdp) throws Exception {
        boolean estOk = false;
        //Utilisateur musee = utilisateurDAO.findByLogin("musee");
        Utilisateur musee = new Utilisateur("musee", "besancon", true);
        if(login==musee.getLogin() && mdp==musee.getMdp()){
            estOk=true;
        } else if (login!=musee.getLogin()) {
            throw new Exception("Identifiant incorrect!");
        } else {
            throw new Exception("Mot de passe incorrect!");
        }
        return estOk;
    }

}
