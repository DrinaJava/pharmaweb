package com.pharmaweb.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.pharmaweb.model.entities.ClassePharmaceutique;
import com.pharmaweb.model.entities.Produit;
import com.pharmaweb.model.entities.Tva;
import com.pharmaweb.model.entities.TypeDeRemboursement;

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
		return entityManager.createNamedQuery("Produit.findAll").getResultList();
	}

	public List<ClassePharmaceutique> getFamilies(){
		return entityManager.createNamedQuery("ClassePharmaceutique.findAll").getResultList();
	}
	
	public ClassePharmaceutique getFamilyById(int id){
		String sql = "SELECT c FROM ClassePharmaceutique c WHERE c.idClassePharmaceutique = " + String.valueOf(id);
		return (ClassePharmaceutique) entityManager.createQuery(sql).getSingleResult();
	}
	
	public int add(Produit produit) {
		entityManager.persist(produit);
		entityManager.flush();
		return (int) produit.getIdProduit();
	}


	public List<Tva> getAllTva() {
		return entityManager.createNamedQuery("Tva.findAll").getResultList();
	}


	public Tva getTvaById(int idTva) {
		String sql = "SELECT t FROM Tva t WHERE t.idTva = " + String.valueOf(idTva);
		return (Tva) entityManager.createQuery(sql).getSingleResult();
	}


	public List<TypeDeRemboursement> getTypesRemboursement() {
		return entityManager.createNamedQuery("TypeDeRemboursement.findAll").getResultList();
	}


	public TypeDeRemboursement getTypeRemboursementById(int idTypeRemboursement) {
		String sql = "SELECT tr FROM TypeDeRemboursement tr WHERE tr.idTypeDeRemboursement = " + String.valueOf(idTypeRemboursement);
		return (TypeDeRemboursement) entityManager.createQuery(sql).getSingleResult();
	}


	public Produit getByID(int idProduit) {
		String sql = "SELECT p FROM Produit p WHERE p.idProduit = " + String.valueOf(idProduit);
		return (Produit) entityManager.createQuery(sql).getSingleResult();
	}


	public void update(Produit produit) {
		entityManager.merge(produit);
	}


	public List<Produit> search(String pattern) {
		Query query = entityManager.createQuery("SELECT p FROM Produit p WHERE lower(p.nomProduit) LIKE lower(:name) OR lower(p.decriptionProduit) LIKE lower(:desc)");
		query.setParameter("name", "%"+pattern+"%");
		query.setParameter("desc", "%"+pattern+"%");
		
		return query.getResultList();
	}
}
