package jfc.isis.ptutBesanconIsis.dao;

import jfc.isis.ptutBesanconIsis.entity.Objet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObjetRepository extends JpaRepository<Objet, Integer> {
}