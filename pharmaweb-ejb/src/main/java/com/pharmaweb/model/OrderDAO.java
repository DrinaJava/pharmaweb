/**
 * 
 */
package com.pharmaweb.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.pharmaweb.model.entities.CommandeClient;
import com.pharmaweb.model.entities.CommandeLotProduit;
/**
 * @author Mnky
 *
 */
@SuppressWarnings("unchecked")
public class OrderDAO extends DAO{


	public OrderDAO(final EntityManager entityManager) {
		super(entityManager);
	}


	public List<CommandeClient> getAll(){
		return this.entityManager.createNamedQuery("CommandeClient.findAll").getResultList();
	}

	public CommandeClient getOrderById(final int id) {

		final String sql = "SELECT c FROM CommandeClient c WHERE c.idCommandeClient = "+id+"";
		final Query query = this.entityManager.createQuery(sql);
		return (CommandeClient) query.getSingleResult();
	}

	public List<CommandeLotProduit> getOrderLines(final int idOrder) {

		final String sql = "SELECT c.estDansLaCommandeClients FROM CommandeClient c WHERE c.idCommandeClient = "+idOrder+"";
		final Query query = this.entityManager.createQuery(sql);
		return query.getResultList();
	}


	public int create(CommandeClient commandeClient) {
		this.entityManager.persist(commandeClient);
		this.entityManager.flush();
		
		return (int) commandeClient.getIdCommandeClient()-1;
	}
}
