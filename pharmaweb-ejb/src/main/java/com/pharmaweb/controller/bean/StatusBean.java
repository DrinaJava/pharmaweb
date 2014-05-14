package com.pharmaweb.controller.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

import com.pharmaweb.controller.IStatusBean;
import com.pharmaweb.model.entities.Statut;

/**
 * Session Bean implementation class StatusBean
 * @author Anthony DENAUD
 */
@Stateless
public class StatusBean extends Bean implements IStatusBean {

	private StatusDAO statusDAO;
	
	@PostConstruct
	protected void init(){
		this.statusDAO = new StatusDAO(em);
	}

	@Override
	public List<Statut> getAll() {
		return statusDAO.getAll();
	}

	@Override
	public Statut getById(int idStatut) {
		return statusDAO.getById(idStatut);
	}
}
