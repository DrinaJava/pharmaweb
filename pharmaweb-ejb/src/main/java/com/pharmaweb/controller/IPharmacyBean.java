package com.pharmaweb.controller;

import java.util.List;

import javax.ejb.Remote;

import com.pharmaweb.model.entities.CommandeClient;
import com.pharmaweb.model.entities.CommandeFournisseur;
import com.pharmaweb.model.entities.Employe;
import com.pharmaweb.model.entities.Pharmacie;
import com.pharmaweb.model.entities.PharmacieStock;
/**
 * @author Mnky
 *
 */
@Remote
public interface IPharmacyBean {

	public List<Pharmacie> getAll();
	public Pharmacie getPharmacyById(int id);
	public List<PharmacieStock> getStockLines(int idPharmacy);
	public List<CommandeClient> getCustomerOrders(int idPharmacy);
	public List<CommandeFournisseur> getSupplierOrders(int idPharmacy);
	public List<Employe> getEmployes(int idPharmacy);

}
