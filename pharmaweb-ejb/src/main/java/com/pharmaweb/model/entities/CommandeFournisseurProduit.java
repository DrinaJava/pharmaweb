package com.pharmaweb.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the EST_DANS_LA_COMMANDE_FOU database table.
 * 
 */
@Entity
@Table(name="EST_DANS_LA_COMMANDE_FOU")
@NamedQuery(name="CommandeFournisseurProduit.findAll", query="SELECT c FROM CommandeFournisseurProduit c")
public class CommandeFournisseurProduit implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CommandeFournisseurProduitPK id;

	private BigDecimal quantite;

	@Column(name="TVA_FOURNISSEUR")
	private BigDecimal tvaFournisseur;

	//bi-directional many-to-one association to CommandeFournisseur
	@ManyToOne
	@JoinColumn(name="ID_COMMANDE_FOURNISSEUR")
	private CommandeFournisseur commandeFournisseur;

	//bi-directional many-to-one association to LotProduit
	@ManyToOne
	@JoinColumn(name="ID_LOT_PRODUIT")
	private LotProduit lotProduit;

	public CommandeFournisseurProduit() {
	}

	public CommandeFournisseurProduitPK getId() {
		return this.id;
	}

	public void setId(CommandeFournisseurProduitPK id) {
		this.id = id;
	}

	public BigDecimal getQuantite() {
		return this.quantite;
	}

	public void setQuantite(BigDecimal quantite) {
		this.quantite = quantite;
	}

	public BigDecimal getTvaFournisseur() {
		return this.tvaFournisseur;
	}

	public void setTvaFournisseur(BigDecimal tvaFournisseur) {
		this.tvaFournisseur = tvaFournisseur;
	}

	public CommandeFournisseur getCommandeFournisseur() {
		return this.commandeFournisseur;
	}

	public void setCommandeFournisseur(CommandeFournisseur commandeFournisseur) {
		this.commandeFournisseur = commandeFournisseur;
	}

	public LotProduit getLotProduit() {
		return this.lotProduit;
	}

	public void setLotProduit(LotProduit lotProduit) {
		this.lotProduit = lotProduit;
	}

}