package com.pharmaweb.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.pharmaweb.model.entities.ClassePharmaceutique;
import com.pharmaweb.model.entities.LotProduit;
import com.pharmaweb.model.entities.PharmacieStock;
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

	public MedicineDAO(final EntityManager entityManager) {
		super(entityManager);
	}


	public List<Produit> getAll(){
		return this.entityManager.createNamedQuery("Produit.findAll").getResultList();
	}

	public List<ClassePharmaceutique> getFamilies(){
		return this.entityManager.createNamedQuery("ClassePharmaceutique.findAll").getResultList();
	}
	public List<ClassePharmaceutique> getSubFamilies(final int idClasse) {
		final String sql ="SELECT c.classePharmaceutiques FROM ClassePharmaceutique c WHERE c.idClassePharmaceutique = " + String.valueOf(idClasse);
		return this.entityManager.createQuery(sql).getResultList();
	}

	public ClassePharmaceutique getFamilyById(final int id){
		final String sql = "SELECT c FROM ClassePharmaceutique c WHERE c.idClassePharmaceutique = " + String.valueOf(id);
		return (ClassePharmaceutique) this.entityManager.createQuery(sql).getSingleResult();
	}

	public int add(final Produit produit) {
		this.entityManager.persist(produit);
		this.entityManager.flush();
		return (int) produit.getIdProduit();
	}


	public List<Tva> getAllTva() {
		return this.entityManager.createNamedQuery("Tva.findAll").getResultList();
	}


	public Tva getTvaById(final int idTva) {
		final String sql = "SELECT t FROM Tva t WHERE t.idTva = " + String.valueOf(idTva);
		return (Tva) this.entityManager.createQuery(sql).getSingleResult();
	}


	public List<TypeDeRemboursement> getTypesRemboursement() {
		return this.entityManager.createNamedQuery("TypeDeRemboursement.findAll").getResultList();
	}


	public TypeDeRemboursement getTypeRemboursementById(final int idTypeRemboursement) {
		final String sql = "SELECT tr FROM TypeDeRemboursement tr WHERE tr.idTypeDeRemboursement = " + String.valueOf(idTypeRemboursement);
		return (TypeDeRemboursement) this.entityManager.createQuery(sql).getSingleResult();
	}


	public Produit getByID(final int idProduit) {
		final String sql = "SELECT p FROM Produit p WHERE p.idProduit = " + String.valueOf(idProduit);
		return (Produit) this.entityManager.createQuery(sql).getSingleResult();
	}


	public void update(final Produit produit) {
		this.entityManager.merge(produit);
	}



	public List<Produit> search(final String pattern) {
		final Query query = this.entityManager.createQuery("SELECT p FROM Produit p WHERE lower(p.nomProduit) LIKE lower(:name) OR lower(p.decriptionProduit) LIKE lower(:desc)");
		query.setParameter("name", "%"+pattern+"%");
		query.setParameter("desc", "%"+pattern+"%");

		return query.getResultList();
	}


	public LotProduit getLotById(int idLot) {
		final String sql = "SELECT l FROM LotProduit l WHERE l.idLotProduit = " + String.valueOf(idLot);
		return (LotProduit) this.entityManager.createQuery(sql).getSingleResult();
	}


	public PharmacieStock getPharmacieStockByLot(int idLot) {
		final String sql = "SELECT l FROM PharmacieStock l WHERE l.id.idLotProduit = " + String.valueOf(idLot);
		return (PharmacieStock) this.entityManager.createQuery(sql).getSingleResult();
	}


	public List<Produit> getPharmacieStockByPharmacie(int idPharmacie) {
		
		List<Produit> produits = new ArrayList<Produit>();
		
		Query query = entityManager.createNativeQuery("SELECT DISTINCT(PRODUIT.ID_PRODUIT)  FROM PRODUIT "+
	      "INNER JOIN LOT_PRODUIT ON PRODUIT.ID_PRODUIT = LOT_PRODUIT.ID_PRODUIT "+
	      "INNER JOIN A_EN_STOCK ON LOT_PRODUIT.ID_LOT_PRODUIT = A_EN_STOCK.ID_LOT_PRODUIT "+
	      "WHERE A_EN_STOCK.ID_PHARMACIE=1 AND PRODUIT.VISIBLE_PRODUIT=1 ");
		
		query.setParameter(1, idPharmacie);
		
		List<BigDecimal> results = query.getResultList();
		
		
		for (BigDecimal idProduit : results) {
			Produit produit = this.getByID(idProduit.intValue());
			produits.add(produit);
		}

		return produits;
	}


	public LotProduit getLotFromProduct(long idProduit, long idPharmacie,
			int quantite) {
		String sql = "SELECT LOT_PRODUIT.ID_LOT_PRODUIT FROM LOT_PRODUIT "+
				"INNER JOIN A_EN_STOCK "+
				"ON LOT_PRODUIT.ID_LOT_PRODUIT = A_EN_STOCK.ID_LOT_PRODUIT "+
				"WHERE LOT_PRODUIT.ID_PRODUIT=? AND A_EN_STOCK.ID_PHARMACIE=?";
		
		Query query = entityManager.createNativeQuery(sql);
		query.setParameter(1, idProduit);
		query.setParameter(2, 1);
		
		List<Object> results = query.getResultList();
		
		int idLot = ((BigDecimal) results.get(0)).intValue();
		
		return this.getLotById(idLot);
	}
}

