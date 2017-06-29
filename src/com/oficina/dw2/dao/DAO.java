package com.oficina.dw2.dao;

import java.util.List;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

@TransactionManagement(TransactionManagementType.CONTAINER)
public abstract class DAO<T> {

	private final Class<T> classe;
	
	@PersistenceContext
	protected EntityManager em;
	
	public DAO(Class<T> classe) {
		this.classe = classe;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void adiciona(T t) {
		em.persist(t);
	}

	public void remove(T t) {

		em.remove(em.merge(t));

	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void atualiza(T t) {

		em.merge(t);

	}

	public List<T> listaTodos() {
		CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(classe);
		query.select(query.from(classe));

		List<T> lista = em.createQuery(query).getResultList();

		return lista;
	}

	public T buscaPorId(Integer id) {
		T instancia = em.find(classe, id);
		return instancia;
	}
	
	public T buscaPorId(String id) {
		T instancia = em.find(classe, id);
		return instancia;
	}

	public int contaTodos() {
		long result = (Long) em.createQuery("select count(n) from livro n")
				.getSingleResult();

		return (int) result;
	}

	public List<T> listaTodosPaginada(int firstResult, int maxResults) {
		CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(classe);
		query.select(query.from(classe));

		List<T> lista = em.createQuery(query).setFirstResult(firstResult)
				.setMaxResults(maxResults).getResultList();

		return lista;
	}

}
