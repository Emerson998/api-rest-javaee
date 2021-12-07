package br.com.magna.pea2.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.magna.pea2.model.LocadoraModel;

@Stateless
public class LocadoraDao {

	@PersistenceContext(unitName = "PostgresqlDS")
	private EntityManager em;
	
	public LocadoraModel save(LocadoraModel locadora) {
		em.persist(locadora);
		return locadora;
	}
	
//	public void post(LocadoraModel model) {
//		em.persist(model);
//	}
	
}
