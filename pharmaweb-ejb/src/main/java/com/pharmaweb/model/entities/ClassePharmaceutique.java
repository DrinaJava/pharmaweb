package com.pharmaweb.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CLASSE_PHARMACEUTIQUE database table.
 * 
 */
@Entity
@Table(name="CLASSE_PHARMACEUTIQUE")
@NamedQuery(name="ClassePharmaceutique.findAll", query="SELECT c FROM ClassePharmaceutique c")
public class ClassePharmaceutique implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_CLASSE_PHARMACEUTIQUE")
	private long idClassePharmaceutique;

	@Lob
	@Column(name="LIBELLE_CLASSE_PHARMACEUTIQUE")
	private String libelleClassePharmaceutique;

	//bi-directional many-to-one association to ClassePharmaceutique
	@ManyToOne
	@JoinColumn(name="CLA_ID_CLASSE_PHARMACEUTIQUE")
	private ClassePharmaceutique classePharmaceutique;

	//bi-directional many-to-one association to ClassePharmaceutique
	@OneToMany(mappedBy="classePharmaceutique")
	private List<ClassePharmaceutique> classePharmaceutiques;

	//bi-directional many-to-one association to Produit
	@OneToMany(mappedBy="classePharmaceutique")
	private List<Produit> produits;

	public ClassePharmaceutique() {
	}

	public long getIdClassePharmaceutique() {
		return this.idClassePharmaceutique;
	}

	public void setIdClassePharmaceutique(long idClassePharmaceutique) {
		this.idClassePharmaceutique = idClassePharmaceutique;
	}

	public String getLibelleClassePharmaceutique() {
		return this.libelleClassePharmaceutique;
	}

	public void setLibelleClassePharmaceutique(String libelleClassePharmaceutique) {
		this.libelleClassePharmaceutique = libelleClassePharmaceutique;
	}

	public ClassePharmaceutique getClassePharmaceutique() {
		return this.classePharmaceutique;
	}

	public void setClassePharmaceutique(ClassePharmaceutique classePharmaceutique) {
		this.classePharmaceutique = classePharmaceutique;
	}

	public List<ClassePharmaceutique> getClassePharmaceutiques() {
		return this.classePharmaceutiques;
	}

	public void setClassePharmaceutiques(List<ClassePharmaceutique> classePharmaceutiques) {
		this.classePharmaceutiques = classePharmaceutiques;
	}

	public ClassePharmaceutique addClassePharmaceutique(ClassePharmaceutique classePharmaceutique) {
		getClassePharmaceutiques().add(classePharmaceutique);
		classePharmaceutique.setClassePharmaceutique(this);

		return classePharmaceutique;
	}

	public ClassePharmaceutique removeClassePharmaceutique(ClassePharmaceutique classePharmaceutique) {
		getClassePharmaceutiques().remove(classePharmaceutique);
		classePharmaceutique.setClassePharmaceutique(null);

		return classePharmaceutique;
	}

	public List<Produit> getProduits() {
		return this.produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	public Produit addProduit(Produit produit) {
		getProduits().add(produit);
		produit.setClassePharmaceutique(this);

		return produit;
	}

	public Produit removeProduit(Produit produit) {
		getProduits().remove(produit);
		produit.setClassePharmaceutique(null);

		return produit;
	}

}