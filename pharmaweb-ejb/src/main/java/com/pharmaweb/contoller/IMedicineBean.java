package com.pharmaweb.contoller;

import java.util.List;

import javax.ejb.Remote;

import com.pharmaweb.model.entities.ClassePharmaceutique;
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
	List<ClassePharmaceutique> getFamilies();
	ClassePharmaceutique getFamilyById(int idFamily);
	int add(Produit produit);
	List<Tva> getAllTva();
	Tva getTvaById(int idTva);
	List<TypeDeRemboursement> getTypesRemboursement();
	TypeDeRemboursement getTypeRemboursementById(int idTypeRemboursement);
}
