package com.pharmaweb.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the FOURNIT database table.
 * 
 */
@Entity
@Table(name="FOURNIT")
@NamedQuery(name="FournisseurProduit.findAll", query="SELECT f FROM FournisseurProduit f")
public class FournisseurProduit implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private FournisseurProduitPK id;

	@Column(name="PRIX_DU_LOT")
	private BigDecimal prixDuLot;

	@Column(name="QUANTITE_PAR_LOT")
	private BigDecimal quantiteParLot;

	//bi-directional many-to-one association to Fournisseur
	@ManyToOne
	@JoinColumn(name="ID_FOURNISSEUR")
	private Fournisseur fournisseur;

	//bi-directional many-to-one association to Produit
	@ManyToOne
	@JoinColumn(name="ID_PRODUIT")
	private Produit produit;

	public FournisseurProduit() {
	}

	public FournisseurProduitPK getId() {
		return this.id;
	}

	public void setId(FournisseurProduitPK id) {
		this.id = id;
	}

	public BigDecimal getPrixDuLot() {
		return this.prixDuLot;
	}

	public void setPrixDuLot(BigDecimal prixDuLot) {
		this.prixDuLot = prixDuLot;
	}

	public BigDecimal getQuantiteParLot() {
		return this.quantiteParLot;
	}

	public void setQuantiteParLot(BigDecimal quantiteParLot) {
		this.quantiteParLot = quantiteParLot;
	}

	public Fournisseur getFournisseur() {
		return this.fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	public Produit getProduit() {
		return this.produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

}