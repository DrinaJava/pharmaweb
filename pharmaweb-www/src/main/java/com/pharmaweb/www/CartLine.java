package com.pharmaweb.www;

import com.pharmaweb.model.entities.Produit;

/**
 * 
 * @author Anthony DENAUD
 *
 */
public class CartLine {
	private Produit produit;
	private int quantite;

	public CartLine() {
		super();
	}

	public CartLine(Produit produit, int quantite) {
		super();
		this.produit = produit;
		this.quantite = quantite;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

}
