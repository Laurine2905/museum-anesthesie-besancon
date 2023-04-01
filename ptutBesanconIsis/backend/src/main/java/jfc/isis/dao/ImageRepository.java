package jfc.isis.dao;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class ImageRepository {
    private static final String PERSISTENCE_UNIT_NAME = "persistence-config";
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    private static EntityManager em = emf.createEntityManager();
    /**
     * Enregistre une collection d'objets mappés via des annotations JPA
     */
    public static void persist(Collection collection){
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        for (Object serializable : collection) {
            em.persist(serializable);
        }
        tx.commit();
    }
    /**
     * Enregistre un objet mappé via des annotations JPA
     * @param data
     */
    public static void persist(Serializable data){
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(data);
        tx.commit();
    }
    /**
     * Retourne toutes les instances d'une classe donnée
     * @param className : le nom d'une classe annotée par JPA
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static List load(String className){
        Query q = em.createQuery("from " + className);
        return q.getResultList();
    }

}
