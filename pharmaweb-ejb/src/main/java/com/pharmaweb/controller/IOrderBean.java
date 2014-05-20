package com.pharmaweb.controller;

import java.util.List;

import javax.ejb.Remote;

import com.pharmaweb.model.entities.CommandeClient;
import com.pharmaweb.model.entities.CommandeLotProduit;
/**
 * @author Mnky
 *
 */
@Remote
public interface IOrderBean {

	List<CommandeClient> getAll();
	CommandeClient getOrderById(int id);
	List<CommandeLotProduit> getOrderLines(int idOrder);
	int create(CommandeClient commandeClient);
	void update(CommandeClient commandeClient);
}

