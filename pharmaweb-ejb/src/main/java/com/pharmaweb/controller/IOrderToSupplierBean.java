package com.pharmaweb.controller;


import java.util.List;

import javax.ejb.Remote;

import com.pharmaweb.model.entities.CommandeFournisseur;
import com.pharmaweb.model.entities.CommandeFournisseurProduit;
/**
 * @author Mnky
 *
 */
@Remote
public interface IOrderToSupplierBean {

	public List<CommandeFournisseur> getAll();
	public CommandeFournisseur getOrderById(int id);
	public List<CommandeFournisseurProduit> getOrderLines(int idOrderToSupplier);

}
