package com.pharmaweb.controller;

import java.util.List;

import javax.ejb.Remote;

import com.pharmaweb.model.entities.ClassePharmaceutique;
import com.pharmaweb.model.entities.LotProduit;
import com.pharmaweb.model.entities.PharmacieStock;
import com.pharmaweb.model.entities.Produit;
import com.pharmaweb.model.entities.Tva;
import com.pharmaweb.model.entities.TypeDeRemboursement;

/**
 * 
 * @author Anthony DENAUD
 *
 */
@Remote
public interface IMedicineBean {
	List<Produit> getAll();
	Produit getByID(int idProduit);
	void update(Produit produit);
	int add(Produit produit);


	List<ClassePharmaceutique> getFamilies();
	List<ClassePharmaceutique> getSubFamilies(int idClasse);
	ClassePharmaceutique getFamilyById(int idFamily);

	List<Tva> getAllTva();
	Tva getTvaById(int idTva);

	List<TypeDeRemboursement> getTypesRemboursement();
	TypeDeRemboursement getTypeRemboursementById(int idTypeRemboursement);

	List<Produit> search(String pattern);

	LotProduit getLotById(int idLot);

	PharmacieStock getPharmacieStockByLot(int idLot);
	List<Produit> getPharmacieStockByPharmacie(int idPharmacie);
	List<Produit> getPharmacieStockByPharmacie(int idPharmacie, int idClasse);
	LotProduit getLotFromProduct(long idProduit,long idPharmacie, int quantite);

}
