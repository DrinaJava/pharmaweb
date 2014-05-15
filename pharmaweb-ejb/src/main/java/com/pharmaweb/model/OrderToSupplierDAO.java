/**
 * 
 */
package com.pharmaweb.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.pharmaweb.model.entities.CommandeFournisseur;
import com.pharmaweb.model.entities.CommandeFournisseurProduit;
/**
 * @author Mnky
 *
 */
@SuppressWarnings("unchecked")
public class OrderToSupplierDAO extends DAO{


	public OrderToSupplierDAO(final EntityManager entityManager) {
		super(entityManager);
	}


	public List<CommandeFournisseur> getAll(){
		return this.entityManager.createNamedQuery("CommandeFournisseur.findAll").getResultList();
	}

	public CommandeFournisseur getOrderById(final int id) {

		final String sql = "SELECT c FROM CommandeFournisseur c WHERE c.idCommandeFournisseur = "+id+"";
		final Query query = this.entityManager.createQuery(sql);
		return (CommandeFournisseur) query.getSingleResult();
	}

	public List<CommandeFournisseurProduit> getOrderLines(final int idOrderToSupplier) {

		final String sql = "SELECT c.estDansLaCommandeFous FROM CommandeFournisseur c WHERE c.idCommandeFournisseur = "+idOrderToSupplier+"";
		final Query query = this.entityManager.createQuery(sql);
		return query.getResultList();
	}


}
