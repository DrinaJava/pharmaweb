package com.pharmaweb.controller.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
/**
 * @author Mnky
 *
 */
/**
 * Session Bean implementation class PharmacyBean
 */

import com.pharmaweb.controller.IPharmacyBean;
import com.pharmaweb.model.PharmacyDAO;
import com.pharmaweb.model.entities.CommandeClient;
import com.pharmaweb.model.entities.CommandeFournisseur;
import com.pharmaweb.model.entities.Employe;
import com.pharmaweb.model.entities.Pharmacie;
import com.pharmaweb.model.entities.PharmacieStock;
/**
 * Session Bean implementation class PharmacyBean
 */
@Stateless
public class PharmacyBean extends Bean implements IPharmacyBean {

	private PharmacyDAO pharmacyDAO;

	@PostConstruct
	protected void init(){
		this.pharmacyDAO = new PharmacyDAO(this.em);
	}


	@Override
	public List<Pharmacie> getAll() {
		return this.pharmacyDAO.getAll();
	}


	@Override
	public Pharmacie getPharmacyById(final int id) {
		return this.pharmacyDAO.getPharmacyById(id);
	}


	@Override
	public List<PharmacieStock> getStockLines(final int idPharmacy) {
		return this.pharmacyDAO.getStockLines(idPharmacy);
	}


	@Override
	public List<CommandeClient> getCustomerOrders(final int idPharmacy) {
		return this.pharmacyDAO.getCustomerOrders(idPharmacy);
	}


	@Override
	public List<CommandeFournisseur> getSupplierOrders(final int idPharmacy) {
		return this.pharmacyDAO.getSupplierOrders(idPharmacy);
	}

	@Override
	public List<Employe> getEmployes(final int idPharmacy) {
		return this.pharmacyDAO.getEmployes(idPharmacy);
	}



}
