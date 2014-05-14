package com.pharmaweb.model;

import java.util.List;

import javax.persistence.EntityManager;

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
		entityManager.persist(client);
		entityManager.flush();
	
		return (int) client.getIdClient();
	}

	public void update(Client client) {
		entityManager.merge(client);
	}

}
