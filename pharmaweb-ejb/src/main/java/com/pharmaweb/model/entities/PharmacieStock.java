package com.pharmaweb.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the A_EN_STOCK database table.
 * 
 */
@Entity
@Table(name="A_EN_STOCK")
@NamedQuery(name="PharmacieStock.findAll", query="SELECT p FROM PharmacieStock p")
public class PharmacieStock implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PharmacieStockPK id;

	@Column(name="PRIX_UNITAIRE_PRODUIT")
	private BigDecimal prixUnitaireProduit;

	@Column(name="QUANTITE_STOCK_PRODUIT")
	private BigDecimal quantiteStockProduit;

	//bi-directional many-to-one association to LotProduit
	@ManyToOne
	@JoinColumn(name="ID_LOT_PRODUIT")
	private LotProduit lotProduit;

	//bi-directional many-to-one association to Pharmacie
	@ManyToOne
	@JoinColumn(name="ID_PHARMACIE")
	private Pharmacie pharmacie;

	public PharmacieStock() {
	}

	public PharmacieStockPK getId() {
		return this.id;
	}

	public void setId(PharmacieStockPK id) {
		this.id = id;
	}

	public BigDecimal getPrixUnitaireProduit() {
		return this.prixUnitaireProduit;
	}

	public void setPrixUnitaireProduit(BigDecimal prixUnitaireProduit) {
		this.prixUnitaireProduit = prixUnitaireProduit;
	}

	public BigDecimal getQuantiteStockProduit() {
		return this.quantiteStockProduit;
	}

	public void setQuantiteStockProduit(BigDecimal quantiteStockProduit) {
		this.quantiteStockProduit = quantiteStockProduit;
	}

	public LotProduit getLotProduit() {
		return this.lotProduit;
	}

	public void setLotProduit(LotProduit lotProduit) {
		this.lotProduit = lotProduit;
	}

	public Pharmacie getPharmacie() {
		return this.pharmacie;
	}

	public void setPharmacie(Pharmacie pharmacie) {
		this.pharmacie = pharmacie;
	}

}