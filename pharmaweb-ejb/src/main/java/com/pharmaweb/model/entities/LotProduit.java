package com.pharmaweb.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the LOT_PRODUIT database table.
 * 
 */
@Entity
@Table(name="LOT_PRODUIT")
@NamedQuery(name="LotProduit.findAll", query="SELECT l FROM LotProduit l")
public class LotProduit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_LOT_PRODUIT")
	private long idLotProduit;

	@Column(name="DATE_EXPIRATION_LOT_PRODUIT")
	private String dateExpirationLotProduit;

	@Lob
	@Column(name="NUM_LOT_PRODUIT")
	private String numLotProduit;

	@Column(name="PRIX_D_ACHAT_LOT_PRODUIT")
	private BigDecimal prixDAchatLotProduit;

	@Column(name="QUANTITE_LOT_PRODUIT")
	private BigDecimal quantiteLotProduit;

	//bi-directional many-to-one association to PharmacieStock
	@OneToMany(mappedBy="lotProduit")
	private List<PharmacieStock> AEnStocks;

	//bi-directional many-to-one association to CommandeLotProduit
	@OneToMany(mappedBy="lotProduit")
	private List<CommandeLotProduit> estDansLaCommandeClients;

	//bi-directional many-to-one association to CommandeFournisseurProduit
	@OneToMany(mappedBy="lotProduit")
	private List<CommandeFournisseurProduit> estDansLaCommandeFous;

	//bi-directional many-to-one association to Fournisseur
	@ManyToOne
	@JoinColumn(name="ID_FOURNISSEUR")
	private Fournisseur fournisseur;

	//bi-directional many-to-one association to Produit
	@ManyToOne
	@JoinColumn(name="ID_PRODUIT")
	private Produit produit;

	public LotProduit() {
	}

	public long getIdLotProduit() {
		return this.idLotProduit;
	}

	public void setIdLotProduit(long idLotProduit) {
		this.idLotProduit = idLotProduit;
	}

	public String getDateExpirationLotProduit() {
		return this.dateExpirationLotProduit;
	}

	public void setDateExpirationLotProduit(String dateExpirationLotProduit) {
		this.dateExpirationLotProduit = dateExpirationLotProduit;
	}

	public String getNumLotProduit() {
		return this.numLotProduit;
	}

	public void setNumLotProduit(String numLotProduit) {
		this.numLotProduit = numLotProduit;
	}

	public BigDecimal getPrixDAchatLotProduit() {
		return this.prixDAchatLotProduit;
	}

	public void setPrixDAchatLotProduit(BigDecimal prixDAchatLotProduit) {
		this.prixDAchatLotProduit = prixDAchatLotProduit;
	}

	public BigDecimal getQuantiteLotProduit() {
		return this.quantiteLotProduit;
	}

	public void setQuantiteLotProduit(BigDecimal quantiteLotProduit) {
		this.quantiteLotProduit = quantiteLotProduit;
	}

	public List<PharmacieStock> getAEnStocks() {
		return this.AEnStocks;
	}

	public void setAEnStocks(List<PharmacieStock> AEnStocks) {
		this.AEnStocks = AEnStocks;
	}

	public PharmacieStock addAEnStock(PharmacieStock AEnStock) {
		getAEnStocks().add(AEnStock);
		AEnStock.setLotProduit(this);

		return AEnStock;
	}

	public PharmacieStock removeAEnStock(PharmacieStock AEnStock) {
		getAEnStocks().remove(AEnStock);
		AEnStock.setLotProduit(null);

		return AEnStock;
	}

	public List<CommandeLotProduit> getEstDansLaCommandeClients() {
		return this.estDansLaCommandeClients;
	}

	public void setEstDansLaCommandeClients(List<CommandeLotProduit> estDansLaCommandeClients) {
		this.estDansLaCommandeClients = estDansLaCommandeClients;
	}

	public CommandeLotProduit addEstDansLaCommandeClient(CommandeLotProduit estDansLaCommandeClient) {
		getEstDansLaCommandeClients().add(estDansLaCommandeClient);
		estDansLaCommandeClient.setLotProduit(this);

		return estDansLaCommandeClient;
	}

	public CommandeLotProduit removeEstDansLaCommandeClient(CommandeLotProduit estDansLaCommandeClient) {
		getEstDansLaCommandeClients().remove(estDansLaCommandeClient);
		estDansLaCommandeClient.setLotProduit(null);

		return estDansLaCommandeClient;
	}

	public List<CommandeFournisseurProduit> getEstDansLaCommandeFous() {
		return this.estDansLaCommandeFous;
	}

	public void setEstDansLaCommandeFous(List<CommandeFournisseurProduit> estDansLaCommandeFous) {
		this.estDansLaCommandeFous = estDansLaCommandeFous;
	}

	public CommandeFournisseurProduit addEstDansLaCommandeFous(CommandeFournisseurProduit estDansLaCommandeFous) {
		getEstDansLaCommandeFous().add(estDansLaCommandeFous);
		estDansLaCommandeFous.setLotProduit(this);

		return estDansLaCommandeFous;
	}

	public CommandeFournisseurProduit removeEstDansLaCommandeFous(CommandeFournisseurProduit estDansLaCommandeFous) {
		getEstDansLaCommandeFous().remove(estDansLaCommandeFous);
		estDansLaCommandeFous.setLotProduit(null);

		return estDansLaCommandeFous;
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