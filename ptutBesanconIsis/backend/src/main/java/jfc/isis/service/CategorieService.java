package jfc.isis.service;

import jakarta.transaction.Transactional;
import jfc.isis.dao.CategorieRepository;
import jfc.isis.dao.UtilisateurRepository;
import jfc.isis.entity.Categorie;
import org.springframework.stereotype.Service;

import java.util.TreeSet;

@Service
public class CategorieService {

    private final CategorieRepository categorieDAO;

    public CategorieService(CategorieRepository categorieDAO) {
        this.categorieDAO = categorieDAO;
    }

    @Transactional
    public TreeSet listeDesCategoriesService() {
        return categorieDAO.listeDesCategories();
    }

}
