package com.pharmaweb.contoller;

import java.util.List;

import javax.ejb.Remote;

import com.pharmaweb.model.entities.CommandeClient;
import com.pharmaweb.model.entities.CommandeLotProduit;

@Remote
public interface IOrderBean {

	public List<CommandeClient> getAll();
	public CommandeClient getOrderById(int id);
	public List<CommandeLotProduit> getOrderLines(int idOrder);

}

