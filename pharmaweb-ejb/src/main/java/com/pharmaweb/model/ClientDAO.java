package com.pharmaweb.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.pharmaweb.model.entities.Client;

/**
 * 
 * @author Anthony DENAUD
 *
 */
@SuppressWarnings("unchecked")
public class ClientDAO extends DAO {

	public ClientDAO(EntityManager entityManager) {
		super(entityManager);
	}

	
	public List<Client> getAll() {
		return entityManager.createNamedQuery("Client.findAll").getResultList();
	}

	public Client getById(int idClient) {
		String sql = "SELECT c FROM Client c WHERE c.idClient = " + String.valueOf(idClient);
		return (Client) entityManager.createQuery(sql).getSingleResult();
	}

	public int add(Client client) {			
		
		Query query = entityManager.createNativeQuery(
			"BEGIN package_client.insertion_client(?,null,null,null,?, "+
			"?,null,null , ?, ?, ?, null, null, ?, 1, ?, ?, ?, ? ); END;");
		
		query.setParameter(1, client.getStatut().getIdStatut());
		query.setParameter(2, client.getNomClient());
		query.setParameter(3, client.getPrenomClient());
		query.setParameter(4, client.getNumeroTelClient());
		query.setParameter(5, client.getMailClient());
		query.setParameter(6, null); //Date de naissance
		query.setParameter(7, client.getMdpClient());
		query.setParameter(8, client.getAdresse().getAdresseAdresse());
		query.setParameter(9, null);
		query.setParameter(10, client.getAdresse().getCodePostalAdresse());
		query.setParameter(11, client.getAdresse().getVilleAdresse());
	
		query.executeUpdate();
		
		return 0;
	}

	public void update(Client client) {
		entityManager.merge(client);
	}
	
	public int getChiffre(){
		return 0;
	}
}
