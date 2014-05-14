package com.pharmaweb.controller;

import java.util.List;

import javax.ejb.Remote;

import com.pharmaweb.model.entities.Statut;

/**
 * 
 * @author Anthony DENAUD
 *
 */
@Remote
public interface IStatusBean {
	List<Statut> getAll();
	Statut getById(int idStatut);

}
