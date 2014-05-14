package com.pharmaweb.controller.bean;

import java.util.List;

import javax.persistence.EntityManager;

import com.pharmaweb.model.DAO;
import com.pharmaweb.model.entities.Statut;

/**
 * 
 * @author Anthony DENAUD
 *
 */
@SuppressWarnings("unchecked")
public class StatusDAO extends DAO {

	public StatusDAO(EntityManager entityManager) {
		super(entityManager);
	}

	public List<Statut> getAll(){
		return entityManager.createNamedQuery("Statut.findAll").getResultList();
	}
	
	public Statut getById(int idStatut){
		String sql = "SELECT s FROM Statut s WHERE s.idStatut = "+idStatut;
		return (Statut) entityManager.createQuery(sql).getSingleResult();
	}
	
}
