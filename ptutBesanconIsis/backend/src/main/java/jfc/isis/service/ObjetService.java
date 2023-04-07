package jfc.isis.service;

import jakarta.transaction.Transactional;
import jfc.isis.dao.CategorieRepository;
import jfc.isis.dao.ObjetRepository;

import java.util.TreeSet;

public class ObjetService {

    private final ObjetRepository objetDAO;

    public ObjetService(ObjetRepository objetDAO) {
        this.objetDAO = objetDAO;
    }

    @Transactional
    public TreeSet getObjetsParCategorie(int idDeLaCategorie) {
        return objetDAO.getObjetsParCategorie(idDeLaCategorie);
    }


}
