package com.pharmaweb.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the EST_DANS_LA_COMMANDE_CLIENT database table.
 * 
 */
@Entity
@Table(name="EST_DANS_LA_COMMANDE_CLIENT")
@NamedQuery(name="CommandeLotProduit.findAll", query="SELECT c FROM CommandeLotProduit c")
public class CommandeLotProduit implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CommandeLotProduitPK id;

	@Column(name="EST_DANS_ORDONNANCE")
	private BigDecimal estDansOrdonnance;

	@Column(name="PRIX_UNITAIRE_PRODUIT_COMMANDE")
	private BigDecimal prixUnitaireProduitCommande;

	@Column(name="QUANTITE_COMMANDE")
	private BigDecimal quantiteCommande;

	@Column(name="TAUX_REMB_MUTUELLE_COMMANDE")
	private BigDecimal tauxRembMutuelleCommande;

	@Column(name="TAUX_REMB_SECU_COMMANDE")
	private BigDecimal tauxRembSecuCommande;

	@Column(name="TVA_COMMANDE")
	private BigDecimal tvaCommande;

	//bi-directional many-to-one association to CommandeClient
	@ManyToOne
	@JoinColumn(name="ID_COMMANDE_CLIENT")
	private CommandeClient commandeClient;

	//bi-directional many-to-one association to LotProduit
	@ManyToOne
	@JoinColumn(name="ID_LOT_PRODUIT")
	private LotProduit lotProduit;

	public CommandeLotProduit() {
	}

	public CommandeLotProduitPK getId() {
		return this.id;
	}

	public void setId(CommandeLotProduitPK id) {
		this.id = id;
	}

	public BigDecimal getEstDansOrdonnance() {
		return this.estDansOrdonnance;
	}

	public void setEstDansOrdonnance(BigDecimal estDansOrdonnance) {
		this.estDansOrdonnance = estDansOrdonnance;
	}

	public BigDecimal getPrixUnitaireProduitCommande() {
		return this.prixUnitaireProduitCommande;
	}

	public void setPrixUnitaireProduitCommande(BigDecimal prixUnitaireProduitCommande) {
		this.prixUnitaireProduitCommande = prixUnitaireProduitCommande;
	}

	public BigDecimal getQuantiteCommande() {
		return this.quantiteCommande;
	}

	public void setQuantiteCommande(BigDecimal quantiteCommande) {
		this.quantiteCommande = quantiteCommande;
	}

	public BigDecimal getTauxRembMutuelleCommande() {
		return this.tauxRembMutuelleCommande;
	}

	public void setTauxRembMutuelleCommande(BigDecimal tauxRembMutuelleCommande) {
		this.tauxRembMutuelleCommande = tauxRembMutuelleCommande;
	}

	public BigDecimal getTauxRembSecuCommande() {
		return this.tauxRembSecuCommande;
	}

	public void setTauxRembSecuCommande(BigDecimal tauxRembSecuCommande) {
		this.tauxRembSecuCommande = tauxRembSecuCommande;
	}

	public BigDecimal getTvaCommande() {
		return this.tvaCommande;
	}

	public void setTvaCommande(BigDecimal tvaCommande) {
		this.tvaCommande = tvaCommande;
	}

	public CommandeClient getCommandeClient() {
		return this.commandeClient;
	}

	public void setCommandeClient(CommandeClient commandeClient) {
		this.commandeClient = commandeClient;
	}

	public LotProduit getLotProduit() {
		return this.lotProduit;
	}

	public void setLotProduit(LotProduit lotProduit) {
		this.lotProduit = lotProduit;
	}

}