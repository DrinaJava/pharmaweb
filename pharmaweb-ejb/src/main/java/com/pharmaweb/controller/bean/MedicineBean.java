package com.pharmaweb.controller.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

import com.pharmaweb.contoller.IMedicineBean;
import com.pharmaweb.model.MedicineDAO;
import com.pharmaweb.model.entities.ClassePharmaceutique;
import com.pharmaweb.model.entities.Produit;
import com.pharmaweb.model.entities.Tva;
import com.pharmaweb.model.entities.TypeDeRemboursement;

/**
 * Session Bean implementation class MedicineBean
 * @author Anthony DENAUD
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

	@Override
	public ClassePharmaceutique getFamilyById(int id) {
		return this.medicineDAO.getFamilyById(id);
	}

	@Override
	public List<Tva> getAllTva() {
		return this.medicineDAO.getAllTva() ;
	}

	@Override
	public Tva getTvaById(int idTva) {
		return this.medicineDAO.getTvaById(idTva);
	}

	@Override
	public List<TypeDeRemboursement> getTypesRemboursement() {
		return this.medicineDAO.getTypesRemboursement();
	}

	@Override
	public TypeDeRemboursement getTypeRemboursementById(int idTypeRemboursement) {
		return this.medicineDAO.getTypeRemboursementById(idTypeRemboursement) ;
	}

	@Override
	public Produit getByID(int idProduit) {
		return this.medicineDAO.getByID(idProduit);
	}

}
