package com.pharmaweb.controller.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

import com.pharmaweb.controller.IClientBean;
import com.pharmaweb.model.ClientDAO;
import com.pharmaweb.model.entities.Client;

/**
 * Session Bean implementation class ClientBean
 * @author Anthony DENAUD
 */
@Stateless
public class ClientBean extends Bean implements IClientBean {

	private ClientDAO clientDAO;
	
	@PostConstruct
	protected void init(){
		this.clientDAO = new ClientDAO(em);
	}

	@Override
	public List<Client> getAll() {
		return clientDAO.getAll();
	}

	@Override
	public Client getById(int idClient) {
		return clientDAO.getById(idClient);
	}

	@Override
	public int add(Client client) {
		return clientDAO.add(client);
	}

	@Override
	public void update(Client client) {
		clientDAO.update(client);
	}

}
