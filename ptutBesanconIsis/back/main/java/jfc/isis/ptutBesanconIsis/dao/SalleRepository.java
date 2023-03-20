package jfc.isis.ptutBesanconIsis.dao;

import jakarta.persistence.Tuple;
import jfc.isis.ptutBesanconIsis.entity.Salle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SalleRepository extends JpaRepository<Salle, Integer> {

}