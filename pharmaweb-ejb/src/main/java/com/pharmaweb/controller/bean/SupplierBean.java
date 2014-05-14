package com.pharmaweb.controller.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

import com.pharmaweb.controller.ISupplierBean;
import com.pharmaweb.model.SupplierDAO;
import com.pharmaweb.model.entities.Fournisseur;

/**
 * Session Bean implementation class SupplierBean
 * @author Anthony DENAUD
 */
@Stateless
public class SupplierBean extends Bean implements ISupplierBean {

	private SupplierDAO supplierDAO;
	
	@PostConstruct
	protected void init(){
		this.supplierDAO = new SupplierDAO(em);
	}

	@Override
	public List<Fournisseur> getAll() {
		return this.supplierDAO.getAll();
	}

	@Override
	public Fournisseur getById(int idSupplier) {
		return this.supplierDAO.getById(idSupplier) ;
	}

}
