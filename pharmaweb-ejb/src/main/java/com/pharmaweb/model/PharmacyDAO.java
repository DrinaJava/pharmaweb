/**
 * 
 */
package com.pharmaweb.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.pharmaweb.model.entities.CommandeClient;
import com.pharmaweb.model.entities.CommandeFournisseur;
import com.pharmaweb.model.entities.Employe;
import com.pharmaweb.model.entities.Pharmacie;
import com.pharmaweb.model.entities.PharmacieStock;
/**
 * @author Mnky
 *
 */
@SuppressWarnings("unchecked")
public class PharmacyDAO extends DAO{


	public PharmacyDAO(final EntityManager entityManager) {
		super(entityManager);
	}


	public List<Pharmacie> getAll(){
		return this.entityManager.createNamedQuery("Pharmacie.findAll").getResultList();
	}

	public Pharmacie getPharmacyById(final int id) {

		final String sql = "SELECT c FROM Pharmacie c WHERE c.idPharmacie = "+id+"";
		final Query query = this.entityManager.createQuery(sql);
		return (Pharmacie) query.getSingleResult();
	}

	public List<PharmacieStock> getStockLines (final int idPharmacy) {

		final String sql = "SELECT c.AEnStocks FROM Pharmacie c WHERE c.idPharmacie = "+idPharmacy+"";
		final Query query = this.entityManager.createQuery(sql);
		return query.getResultList();
	}

	public List<CommandeClient> getCustomerOrders (final int idPharmacy) {

		final String sql = "SELECT c.commandeClients FROM Pharmacie c WHERE c.idPharmacie = "+idPharmacy+"";
		final Query query = this.entityManager.createQuery(sql);
		return query.getResultList();
	}

	public List<CommandeFournisseur> getSupplierOrders (final int idPharmacy) {

		final String sql = "SELECT c.commandeFournisseurs FROM Pharmacie c WHERE c.idPharmacie = "+idPharmacy+"";
		final Query query = this.entityManager.createQuery(sql);
		return query.getResultList();
	}

	public List<Employe> getEmployes (final int idPharmacy) {

		final String sql = "SELECT c.employes FROM Pharmacie c WHERE c.idPharmacie = "+idPharmacy+"";
		final Query query = this.entityManager.createQuery(sql);
		return query.getResultList();
	}


}
