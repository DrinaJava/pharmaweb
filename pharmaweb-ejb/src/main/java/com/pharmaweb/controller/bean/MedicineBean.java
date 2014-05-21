package com.pharmaweb.controller.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

import com.pharmaweb.controller.IMedicineBean;
import com.pharmaweb.model.MedicineDAO;
import com.pharmaweb.model.entities.ClassePharmaceutique;
import com.pharmaweb.model.entities.LotProduit;
import com.pharmaweb.model.entities.PharmacieStock;
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
		this.medicineDAO = new MedicineDAO(this.em);
	}

	@Override
	public List<Produit> getAll() {
		return this.medicineDAO.getAll();
	}

	@Override
	public int add(final Produit produit) {
		return this.medicineDAO.add(produit);
	}

	@Override
	public List<ClassePharmaceutique> getFamilies() {
		return this.medicineDAO.getFamilies();
	}

	@Override
	public ClassePharmaceutique getFamilyById(final int id) {
		return this.medicineDAO.getFamilyById(id);
	}

	@Override
	public List<Tva> getAllTva() {
		return this.medicineDAO.getAllTva() ;
	}

	@Override
	public Tva getTvaById(final int idTva) {
		return this.medicineDAO.getTvaById(idTva);
	}

	@Override
	public List<TypeDeRemboursement> getTypesRemboursement() {
		return this.medicineDAO.getTypesRemboursement();
	}

	@Override
	public TypeDeRemboursement getTypeRemboursementById(final int idTypeRemboursement) {
		return this.medicineDAO.getTypeRemboursementById(idTypeRemboursement) ;
	}

	@Override
	public Produit getByID(final int idProduit) {
		return this.medicineDAO.getByID(idProduit);
	}

	@Override
	public void update(final Produit produit) {
		this.medicineDAO.update(produit);
	}


	/* (non-Javadoc)
	 * @see com.pharmaweb.controller.IMedicineBean#getSubFamilies()
	 */
	@Override
	public List<ClassePharmaceutique> getSubFamilies(final int idClasse) {
		return this.medicineDAO.getSubFamilies(idClasse);
	}
	@Override
	public List<Produit> search(final String pattern) {
		return this.medicineDAO.search(pattern);
	}

	@Override
	public LotProduit getLotById(int idLot) {
		return this.medicineDAO.getLotById(idLot);
	}

	@Override
	public PharmacieStock getPharmacieStockByLot(int idLot) {
		return this.medicineDAO.getPharmacieStockByLot(idLot);
	}
	
	@Override
	public List<Produit> getPharmacieStockByPharmacie(int idPharmacie){
		return this.medicineDAO.getPharmacieStockByPharmacie(idPharmacie);
	}

	@Override
	public LotProduit getLotFromProduct(long idProduit, long idPharmacie,
			int quantite) {
		return this.medicineDAO.getLotFromProduct(idProduit, idPharmacie,
			quantite);
	}

	@Override
	public List<Produit> getPharmacieStockByPharmacie(int idPharmacie,
			int idClasse) {
		return this.medicineDAO.getPharmacieStockByPharmacie(idPharmacie, idClasse);
	}

}
