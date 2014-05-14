package com.pharmaweb.controller.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

import com.pharmaweb.contoller.IMedicineBean;
import com.pharmaweb.model.MedicineDAO;
import com.pharmaweb.model.entities.ClassePharmaceutique;
import com.pharmaweb.model.entities.Produit;

/**
 * Session Bean implementation class MedicineBean
 */
@Stateless
public class MedicineBean extends Bean implements IMedicineBean {

	private MedicineDAO medicineDAO;
	
	@PostConstruct
	protected void init(){
		this.medicineDAO = new MedicineDAO(em);
	}

	@Override
	public List<Produit> getAll() {
		return this.medicineDAO.getAll();
	}

	@Override
	public int add(Produit produit) {
		return this.medicineDAO.add(produit);
	}

	@Override
	public List<ClassePharmaceutique> getFamilies() {
		return this.medicineDAO.getFamilies();
	}

}
