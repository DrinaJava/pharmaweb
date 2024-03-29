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

	public BigDecimal getVisibleProduit(final int idProduit) {
		final String sql= "SELECT v.visibleProduit FROM Produit v WHERE v.idProduit = "+String.valueOf(idProduit);
		return (BigDecimal) this.entityManager.createQuery(sql).getSingleResult();
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


	public LotProduit getLotById(final int idLot) {
		final String sql = "SELECT l FROM LotProduit l WHERE l.idLotProduit = " + String.valueOf(idLot);
		return (LotProduit) this.entityManager.createQuery(sql).getSingleResult();
	}


	public PharmacieStock getPharmacieStockByLot(final int idLot) {
		final String sql = "SELECT l FROM PharmacieStock l WHERE l.id.idLotProduit = " + String.valueOf(idLot);
		return (PharmacieStock) this.entityManager.createQuery(sql).getSingleResult();
	}



	public List<Produit> getPharmacieStockByPharmacie(final int idPharmacie) {

		final List<Produit> produits = new ArrayList<Produit>();

		final Query query = this.entityManager.createNativeQuery("SELECT DISTINCT(PRODUIT.ID_PRODUIT)  FROM PRODUIT "+
				"INNER JOIN LOT_PRODUIT ON PRODUIT.ID_PRODUIT = LOT_PRODUIT.ID_PRODUIT "+
				"INNER JOIN A_EN_STOCK ON LOT_PRODUIT.ID_LOT_PRODUIT = A_EN_STOCK.ID_LOT_PRODUIT "+
				"WHERE A_EN_STOCK.ID_PHARMACIE="+String.valueOf(idPharmacie)+" AND PRODUIT.VISIBLE_PRODUIT=1 ");


		query.setParameter(1, idPharmacie);

		final List<BigDecimal> results = query.getResultList();


		for (final BigDecimal idProduit : results) {
			final Produit produit = this.getByID(idProduit.intValue());
			produits.add(produit);
		}

		return produits;
	}


	public LotProduit getLotFromProduct(final long idProduit, final long idPharmacie,
			final int quantite) {
		final String sql = "SELECT LOT_PRODUIT.ID_LOT_PRODUIT FROM LOT_PRODUIT "+
				"INNER JOIN A_EN_STOCK "+
				"ON LOT_PRODUIT.ID_LOT_PRODUIT = A_EN_STOCK.ID_LOT_PRODUIT "+
				"WHERE LOT_PRODUIT.ID_PRODUIT=? AND A_EN_STOCK.ID_PHARMACIE=?";

		final Query query = this.entityManager.createNativeQuery(sql);
		query.setParameter(1, idProduit);
		query.setParameter(2, 1);

		final List<Object> results = query.getResultList();

		final int idLot = ((BigDecimal) results.get(0)).intValue();

		return this.getLotById(idLot);
	}


	public List<Produit> getPharmacieStockByPharmacie(final int idPharmacie,
			final int idClasse) {
		final List<Produit> produits = new ArrayList<Produit>();

		//TODO utiliser la requete a nico

		final Query query = this.entityManager.createNativeQuery("SELECT DISTINCT(PRODUIT.ID_PRODUIT)  FROM PRODUIT "+
				"INNER JOIN LOT_PRODUIT ON PRODUIT.ID_PRODUIT = LOT_PRODUIT.ID_PRODUIT "+
				"INNER JOIN A_EN_STOCK ON LOT_PRODUIT.ID_LOT_PRODUIT = A_EN_STOCK.ID_LOT_PRODUIT "+
				"INNER JOIN CLASSE_PHARMACEUTIQUE ON CLASSE_PHARMACEUTIQUE.ID_CLASSE_PHARMACEUTIQUE = PRODUIT.ID_CLASSE_PHARMACEUTIQUE "+
				"WHERE A_EN_STOCK.ID_PHARMACIE="+String.valueOf(idPharmacie)+" AND PRODUIT.VISIBLE_PRODUIT=1 AND CLASSE_PHARMACEUTIQUE.ID_CLASSE_PHARMACEUTIQUE IN  "+
				"(WITH id_classe (id) "+
				"AS (SELECT ID_CLASSE_PHARMACEUTIQUE FROM CLASSE_PHARMACEUTIQUE "+
				"WHERE  ID_CLASSE_PHARMACEUTIQUE = "+idClasse+" OR CLA_ID_CLASSE_PHARMACEUTIQUE="+idClasse+
				" UNION ALL "+
				"SELECT ID_CLASSE_PHARMACEUTIQUE FROM CLASSE_PHARMACEUTIQUE C "+
				"INNER JOIN id_classe t "+
				"ON t.id = C.CLA_ID_CLASSE_PHARMACEUTIQUE)"+
				"SELECT id "+
				"FROM   id_classe "+
				"GROUP BY id)");

		query.setParameter(1, idPharmacie);

		final List<BigDecimal> results = query.getResultList();


		for (final BigDecimal idProduit : results) {
			final Produit produit = this.getByID(idProduit.intValue());
			produits.add(produit);
		}

		return produits;
	}


	public List<PharmacieStock> getLotsFromProduct(long idProduit, long idPharmacie) {
		String sql = "SELECT s FROM PharmacieStock s WHERE s.lotProduit.produit.idProduit = "+String.valueOf(idProduit)+" AND s.pharmacie.idPharmacie = "+String.valueOf(idPharmacie);
		Query query = entityManager.createQuery(sql);
		
	
		return query.getResultList();
	}


	public int addLot(LotProduit lot) {
		this.entityManager.persist(lot);
		this.entityManager.flush();
		
		return (int) (lot.getIdLotProduit() + 1);
	}


	public void addPharmacieStock(PharmacieStock stock) {
		this.entityManager.persist(stock);
	}
	
	public void updateLot(LotProduit lot) {
		this.entityManager.merge(lot);
	}


	public void updatePharmacieStock(PharmacieStock stock) {
		this.entityManager.merge(stock);
	}	
}

