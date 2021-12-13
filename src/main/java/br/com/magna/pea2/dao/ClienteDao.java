package br.com.magna.pea2.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import br.com.magna.pea2.model.ClienteModel;

@Stateless
public class ClienteDao {

	@PersistenceContext(unitName = "PostgresqlDS")
	private EntityManager em;

	public ClienteModel getByCpf(String cpf) {
		String jpql = "SELECT e FROM ClienteModel e WHERE e.cpf = :cpf";
		return em.createQuery(jpql, ClienteModel.class).setParameter("cpf", cpf).getSingleResult();

	}

	public List<ClienteModel> getAll() {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<ClienteModel> search = criteriaBuilder.createQuery(ClienteModel.class);
		search.from(ClienteModel.class);
		TypedQuery<ClienteModel> typeSearch = em.createQuery(search);
		return typeSearch.getResultList();

	}

	public ClienteModel save(ClienteModel cliente) {
		em.persist(cliente);
		return cliente;
	}

	public ClienteModel atualizar(ClienteModel cliente) {
		cliente = em.find(ClienteModel.class, cliente.getId());
		ClienteModel clienteAtualizado = em.merge(cliente);
		return clienteAtualizado;
	}

	public void delete(ClienteModel cliente) {
		cliente = em.find(ClienteModel.class, cliente.getId());
		em.remove(cliente);
	}

}
