package com.pharmaweb.model;

import java.util.List;

import javax.persistence.EntityManager;

import com.pharmaweb.model.entities.Fournisseur;

/**
 * 
 * @author Anthony DENAUD
 *
 */
@SuppressWarnings("unchecked")
public class SupplierDAO extends DAO {

	public SupplierDAO(EntityManager entityManager) {
		super(entityManager);
	}


	public List<Fournisseur> getAll() {
		return entityManager.createNamedQuery("Fournisseur.findAll").getResultList();
	}

	public Fournisseur getById(int idSupplier) {
		String sql = "SELECT f FROM Fournisseur f WHERE f.idFournisseur = " + String.valueOf(idSupplier);
		return (Fournisseur) entityManager.createQuery(sql).getSingleResult();
	}
}
