package br.com.magna.pea2.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import br.com.magna.pea2.model.LocadoraModel;

@Stateless
public class LocadoraDao {

	@PersistenceContext(unitName = "PostgresqlDS")
	private EntityManager em;

	public LocadoraModel getByCnpj(String cnpj) {
		String jpql = "SELECT e FROM LocadoraModel e WHERE e.cnpj = :cnpj";
		return em.createQuery(jpql, LocadoraModel.class).setParameter("cnpj", cnpj).getSingleResult();

	}

	public List<LocadoraModel> getAll() {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<LocadoraModel> search = criteriaBuilder.createQuery(LocadoraModel.class);
		search.from(LocadoraModel.class);
		TypedQuery<LocadoraModel> typeSearch = em.createQuery(search);
		return typeSearch.getResultList();

	}

	public LocadoraModel save(LocadoraModel locadora) {
		em.persist(locadora);
		return locadora;
	}

	public LocadoraModel atualizar(LocadoraModel locadora) {
		locadora = em.find(LocadoraModel.class, locadora.getId());
		LocadoraModel locadoraAtualizada = em.merge(locadora);
		return locadoraAtualizada;
	}

	public void delete(LocadoraModel locadora) {
		locadora = em.find(LocadoraModel.class, locadora.getId());
		em.remove(locadora);
	}

}
