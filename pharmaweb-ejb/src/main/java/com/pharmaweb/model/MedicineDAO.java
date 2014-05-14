package com.pharmaweb.model;

import java.util.List;

import javax.persistence.EntityManager;

import com.pharmaweb.model.entities.ClassePharmaceutique;
import com.pharmaweb.model.entities.Produit;

/**
 * 
 * @author Anthony DENAUD
 *
 */
@SuppressWarnings("unchecked")
public class MedicineDAO extends DAO {

	public MedicineDAO(EntityManager entityManager) {
		super(entityManager);
	}
	
	
	public List<Produit> getAll(){
		return entityManager.createQuery("SELECT p FROM Produit p").getResultList();
	}

	public List<ClassePharmaceutique> getFamilies(){
		return entityManager.createNamedQuery("ClassePharmaceutique.findAll").getResultList();
	}

	public int add(Produit produit) {
		entityManager.persist(produit);
		entityManager.flush();
		entityManager.refresh(produit);
		return (int) produit.getIdProduit();
	}
}
