package com.pharmaweb.contoller;

import java.util.List;

import javax.ejb.Remote;

import com.pharmaweb.model.entities.ClassePharmaceutique;
import com.pharmaweb.model.entities.Produit;

@Remote
public interface IMedicineBean {
	public List<Produit> getAll();
	public List<ClassePharmaceutique> getFamilies();
	public int add(Produit produit);
}
