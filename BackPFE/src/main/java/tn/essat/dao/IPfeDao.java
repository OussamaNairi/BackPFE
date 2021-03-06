package tn.essat.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.essat.model.Pfe;
@Repository
public interface IPfeDao extends JpaRepository<Pfe, Integer>{

	@Query("select p from Pfe p where p.cat.id=?1")
	public List<Pfe> getAllPfeByCategorie(int id);
}
