package com.pharmaweb.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TYPE_DE_REMBOURSEMENT database table.
 * 
 */
@Entity
@Table(name="TYPE_DE_REMBOURSEMENT")
@NamedQuery(name="TypeDeRemboursement.findAll", query="SELECT t FROM TypeDeRemboursement t")
public class TypeDeRemboursement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_TYPE_DE_REMBOURSEMENT")
	private long idTypeDeRemboursement;

	@Lob
	@Column(name="LIBELLE_TYPE_DE_REMBOURSEMENT")
	private String libelleTypeDeRemboursement;

	//bi-directional many-to-one association to Produit
	@OneToMany(mappedBy="typeDeRemboursement")
	private List<Produit> produits;

	//bi-directional many-to-one association to TauxRemboursementMutuelle
	@OneToMany(mappedBy="typeDeRemboursement")
	private List<TauxRemboursementMutuelle> tauxRemboursementMutuelles;

	//bi-directional many-to-one association to TauxRemboursementSecu
	@OneToMany(mappedBy="typeDeRemboursement")
	private List<TauxRemboursementSecu> tauxRemboursementSecus;

	public TypeDeRemboursement() {
	}

	public long getIdTypeDeRemboursement() {
		return this.idTypeDeRemboursement;
	}

	public void setIdTypeDeRemboursement(long idTypeDeRemboursement) {
		this.idTypeDeRemboursement = idTypeDeRemboursement;
	}

	public String getLibelleTypeDeRemboursement() {
		return this.libelleTypeDeRemboursement;
	}

	public void setLibelleTypeDeRemboursement(String libelleTypeDeRemboursement) {
		this.libelleTypeDeRemboursement = libelleTypeDeRemboursement;
	}

	public List<Produit> getProduits() {
		return this.produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	public Produit addProduit(Produit produit) {
		getProduits().add(produit);
		produit.setTypeDeRemboursement(this);

		return produit;
	}

	public Produit removeProduit(Produit produit) {
		getProduits().remove(produit);
		produit.setTypeDeRemboursement(null);

		return produit;
	}

	public List<TauxRemboursementMutuelle> getTauxRemboursementMutuelles() {
		return this.tauxRemboursementMutuelles;
	}

	public void setTauxRemboursementMutuelles(List<TauxRemboursementMutuelle> tauxRemboursementMutuelles) {
		this.tauxRemboursementMutuelles = tauxRemboursementMutuelles;
	}

	public TauxRemboursementMutuelle addTauxRemboursementMutuelle(TauxRemboursementMutuelle tauxRemboursementMutuelle) {
		getTauxRemboursementMutuelles().add(tauxRemboursementMutuelle);
		tauxRemboursementMutuelle.setTypeDeRemboursement(this);

		return tauxRemboursementMutuelle;
	}

	public TauxRemboursementMutuelle removeTauxRemboursementMutuelle(TauxRemboursementMutuelle tauxRemboursementMutuelle) {
		getTauxRemboursementMutuelles().remove(tauxRemboursementMutuelle);
		tauxRemboursementMutuelle.setTypeDeRemboursement(null);

		return tauxRemboursementMutuelle;
	}

	public List<TauxRemboursementSecu> getTauxRemboursementSecus() {
		return this.tauxRemboursementSecus;
	}

	public void setTauxRemboursementSecus(List<TauxRemboursementSecu> tauxRemboursementSecus) {
		this.tauxRemboursementSecus = tauxRemboursementSecus;
	}

	public TauxRemboursementSecu addTauxRemboursementSecus(TauxRemboursementSecu tauxRemboursementSecus) {
		getTauxRemboursementSecus().add(tauxRemboursementSecus);
		tauxRemboursementSecus.setTypeDeRemboursement(this);

		return tauxRemboursementSecus;
	}

	public TauxRemboursementSecu removeTauxRemboursementSecus(TauxRemboursementSecu tauxRemboursementSecus) {
		getTauxRemboursementSecus().remove(tauxRemboursementSecus);
		tauxRemboursementSecus.setTypeDeRemboursement(null);

		return tauxRemboursementSecus;
	}

}