package com.pharmaweb.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the PRODUIT database table.
 * 
 */
@Entity
@NamedQuery(name="Produit.findAll", query="SELECT p FROM Produit p")
public class Produit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_PRODUIT")
	private long idProduit;

	@Lob
	@Column(name="DECRIPTION_PRODUIT")
	private String decriptionProduit;

	@Lob
	@Column(name="IMAGE_PRODUIT")
	private String imageProduit;

	@Lob
	@Column(name="NOM_FABRIQUANT_PRODUIT")
	private String nomFabriquantProduit;

	@Lob
	@Column(name="NOM_PRODUIT")
	private String nomProduit;

	@Lob
	@Column(name="NOTICE_PRODUIT")
	private String noticeProduit;

	@Column(name="REQUIERE_ORDONNANCE_PRODUIT")
	private BigDecimal requiereOrdonnanceProduit;

	@Column(name="VISIBLE_PRODUIT")
	private BigDecimal visibleProduit;

	//bi-directional many-to-one association to ContientOrdonnance
	@OneToMany(mappedBy="produit")
	private List<ContientOrdonnance> contientOrdonnances;

	//bi-directional many-to-many association to Fournisseur
	@ManyToMany
	@JoinTable(
		name="FOURNIT"
		, joinColumns={
			@JoinColumn(name="ID_PRODUIT")
			}
		, inverseJoinColumns={
			@JoinColumn(name="ID_FOURNISSEUR")
			}
		)
	private List<Fournisseur> fournisseurs;

	//bi-directional many-to-one association to LotProduit
	@OneToMany(mappedBy="produit")
	private List<LotProduit> lotProduits;

	//bi-directional many-to-one association to ClassePharmaceutique
	@ManyToOne
	@JoinColumn(name="ID_CLASSE_PHARMACEUTIQUE")
	private ClassePharmaceutique classePharmaceutique;

	//bi-directional many-to-one association to Tva
	@ManyToOne
	@JoinColumn(name="ID_TVA")
	private Tva tva;

	//bi-directional many-to-one association to TypeDeRemboursement
	@ManyToOne
	@JoinColumn(name="ID_TYPE_DE_REMBOURSEMENT")
	private TypeDeRemboursement typeDeRemboursement;

	public Produit() {
	}

	public long getIdProduit() {
		return this.idProduit;
	}

	public void setIdProduit(long idProduit) {
		this.idProduit = idProduit;
	}

	public String getDecriptionProduit() {
		return this.decriptionProduit;
	}

	public void setDecriptionProduit(String decriptionProduit) {
		this.decriptionProduit = decriptionProduit;
	}

	public String getImageProduit() {
		return this.imageProduit;
	}

	public void setImageProduit(String imageProduit) {
		this.imageProduit = imageProduit;
	}

	public String getNomFabriquantProduit() {
		return this.nomFabriquantProduit;
	}

	public void setNomFabriquantProduit(String nomFabriquantProduit) {
		this.nomFabriquantProduit = nomFabriquantProduit;
	}

	public String getNomProduit() {
		return this.nomProduit;
	}

	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}

	public String getNoticeProduit() {
		return this.noticeProduit;
	}

	public void setNoticeProduit(String noticeProduit) {
		this.noticeProduit = noticeProduit;
	}

	public BigDecimal getRequiereOrdonnanceProduit() {
		return this.requiereOrdonnanceProduit;
	}

	public void setRequiereOrdonnanceProduit(BigDecimal requiereOrdonnanceProduit) {
		this.requiereOrdonnanceProduit = requiereOrdonnanceProduit;
	}

	public BigDecimal getVisibleProduit() {
		return this.visibleProduit;
	}

	public void setVisibleProduit(BigDecimal visibleProduit) {
		this.visibleProduit = visibleProduit;
	}

	public List<ContientOrdonnance> getContientOrdonnances() {
		return this.contientOrdonnances;
	}

	public void setContientOrdonnances(List<ContientOrdonnance> contientOrdonnances) {
		this.contientOrdonnances = contientOrdonnances;
	}

	public ContientOrdonnance addContientOrdonnance(ContientOrdonnance contientOrdonnance) {
		getContientOrdonnances().add(contientOrdonnance);
		contientOrdonnance.setProduit(this);

		return contientOrdonnance;
	}

	public ContientOrdonnance removeContientOrdonnance(ContientOrdonnance contientOrdonnance) {
		getContientOrdonnances().remove(contientOrdonnance);
		contientOrdonnance.setProduit(null);

		return contientOrdonnance;
	}

	public List<Fournisseur> getFournisseurs() {
		return this.fournisseurs;
	}

	public void setFournisseurs(List<Fournisseur> fournisseurs) {
		this.fournisseurs = fournisseurs;
	}

	public List<LotProduit> getLotProduits() {
		return this.lotProduits;
	}

	public void setLotProduits(List<LotProduit> lotProduits) {
		this.lotProduits = lotProduits;
	}

	public LotProduit addLotProduit(LotProduit lotProduit) {
		getLotProduits().add(lotProduit);
		lotProduit.setProduit(this);

		return lotProduit;
	}

	public LotProduit removeLotProduit(LotProduit lotProduit) {
		getLotProduits().remove(lotProduit);
		lotProduit.setProduit(null);

		return lotProduit;
	}

	public ClassePharmaceutique getClassePharmaceutique() {
		return this.classePharmaceutique;
	}

	public void setClassePharmaceutique(ClassePharmaceutique classePharmaceutique) {
		this.classePharmaceutique = classePharmaceutique;
	}

	public Tva getTva() {
		return this.tva;
	}

	public void setTva(Tva tva) {
		this.tva = tva;
	}

	public TypeDeRemboursement getTypeDeRemboursement() {
		return this.typeDeRemboursement;
	}

	public void setTypeDeRemboursement(TypeDeRemboursement typeDeRemboursement) {
		this.typeDeRemboursement = typeDeRemboursement;
	}

}