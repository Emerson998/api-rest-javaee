package br.com.magna.pea2.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import br.com.magna.pea2.model.FornecedorModel;

@Stateless
public class FornecedorDao {

	@PersistenceContext(unitName = "PostgresqlDS")
	private EntityManager em;

	public FornecedorModel getByCnpj(String cnpj) {
		String jpql = "SELECT e FROM FornecedorModel e WHERE e.cnpj = :cnpj";
		return em.createQuery(jpql, FornecedorModel.class).setParameter("cnpj", cnpj).getSingleResult();

	}

	public List<FornecedorModel> getAll() {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<FornecedorModel> search = criteriaBuilder.createQuery(FornecedorModel.class);
		search.from(FornecedorModel.class);
		TypedQuery<FornecedorModel> typeSearch = em.createQuery(search);
		return typeSearch.getResultList();

	}

	public FornecedorModel save(FornecedorModel fornecedor) {
		em.persist(fornecedor);
		return fornecedor;
	}

	public FornecedorModel atualizar(FornecedorModel fornecedor) {
		fornecedor = em.find(FornecedorModel.class, fornecedor.getId());
		FornecedorModel fornecedorAtualizado = em.merge(fornecedor);
		return fornecedorAtualizado;
	}

	public void delete(FornecedorModel fornecedor) {
		fornecedor = em.find(FornecedorModel.class, fornecedor.getId());
		em.remove(fornecedor);
	}

}
