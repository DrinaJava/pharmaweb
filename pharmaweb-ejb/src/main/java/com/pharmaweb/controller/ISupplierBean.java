package com.pharmaweb.controller;

import javax.ejb.Remote;

import com.pharmaweb.model.entities.Fournisseur;

import java.util.List;

@Remote
public interface ISupplierBean {
	List<Fournisseur> getAll();
	Fournisseur getById(int idSupplier);
}
