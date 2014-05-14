package com.pharmaweb.controller;

import java.util.List;

import javax.ejb.Remote;

import com.pharmaweb.model.entities.Client;

@Remote
public interface IClientBean {
	List<Client> getAll();
	Client getById(int idClient);
	int add(Client client);
	void update(Client client);
}
