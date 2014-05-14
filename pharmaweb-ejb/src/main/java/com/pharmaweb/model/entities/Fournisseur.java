package com.pharmaweb.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the FOURNISSEUR database table.
 * 
 */
@Entity
@NamedQuery(name="Fournisseur.findAll", query="SELECT f FROM Fournisseur f")
public class Fournisseur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_FOURNISSEUR")
	private long idFournisseur;

	@Lob
	@Column(name="LOGIN_FOURNISSEUR")
	private String loginFournisseur;

	@Lob
	@Column(name="MDP_FOURNISSEUR")
	private String mdpFournisseur;

	@Lob
	@Column(name="NOM_FOURNISSEUR")
	private String nomFournisseur;

	//bi-directional many-to-one association to Adresse
	@ManyToOne
	@JoinColumn(name="ID_ADRESSE")
	private Adresse adresse;

	//bi-directional many-to-one association to FournisseurProduit
	@OneToMany(mappedBy="fournisseur")
	private List<FournisseurProduit> fournits;

	//bi-directional many-to-one association to LotProduit
	@OneToMany(mappedBy="fournisseur")
	private List<LotProduit> lotProduits;

	//bi-directional many-to-many association to Produit
	@ManyToMany(mappedBy="fournisseurs")
	private List<Produit> produits;

	public Fournisseur() {
	}

	public long getIdFournisseur() {
		return this.idFournisseur;
	}

	public void setIdFournisseur(long idFournisseur) {
		this.idFournisseur = idFournisseur;
	}

	public String getLoginFournisseur() {
		return this.loginFournisseur;
	}

	public void setLoginFournisseur(String loginFournisseur) {
		this.loginFournisseur = loginFournisseur;
	}

	public String getMdpFournisseur() {
		return this.mdpFournisseur;
	}

	public void setMdpFournisseur(String mdpFournisseur) {
		this.mdpFournisseur = mdpFournisseur;
	}

	public String getNomFournisseur() {
		return this.nomFournisseur;
	}

	public void setNomFournisseur(String nomFournisseur) {
		this.nomFournisseur = nomFournisseur;
	}

	public Adresse getAdresse() {
		return this.adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public List<FournisseurProduit> getFournits() {
		return this.fournits;
	}

	public void setFournits(List<FournisseurProduit> fournits) {
		this.fournits = fournits;
	}

	public FournisseurProduit addFournit(FournisseurProduit fournit) {
		getFournits().add(fournit);
		fournit.setFournisseur(this);

		return fournit;
	}

	public FournisseurProduit removeFournit(FournisseurProduit fournit) {
		getFournits().remove(fournit);
		fournit.setFournisseur(null);

		return fournit;
	}

	public List<LotProduit> getLotProduits() {
		return this.lotProduits;
	}

	public void setLotProduits(List<LotProduit> lotProduits) {
		this.lotProduits = lotProduits;
	}

	public LotProduit addLotProduit(LotProduit lotProduit) {
		getLotProduits().add(lotProduit);
		lotProduit.setFournisseur(this);

		return lotProduit;
	}

	public LotProduit removeLotProduit(LotProduit lotProduit) {
		getLotProduits().remove(lotProduit);
		lotProduit.setFournisseur(null);

		return lotProduit;
	}

	public List<Produit> getProduits() {
		return this.produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

}