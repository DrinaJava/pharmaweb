package com.pharmaweb.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the MUTUELLE database table.
 * 
 */
@Entity
@NamedQuery(name="Mutuelle.findAll", query="SELECT m FROM Mutuelle m")
public class Mutuelle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_MUTUELLE")
	private long idMutuelle;

	@Lob
	@Column(name="NOM_MUTUELLE")
	private String nomMutuelle;

	//bi-directional many-to-one association to CentreMutuelle
	@OneToMany(mappedBy="mutuelle")
	private List<CentreMutuelle> centreMutuelles;

	//bi-directional many-to-one association to Cotisation
	@OneToMany(mappedBy="mutuelle")
	private List<Cotisation> cotisations;

	public Mutuelle() {
	}

	public long getIdMutuelle() {
		return this.idMutuelle;
	}

	public void setIdMutuelle(long idMutuelle) {
		this.idMutuelle = idMutuelle;
	}

	public String getNomMutuelle() {
		return this.nomMutuelle;
	}

	public void setNomMutuelle(String nomMutuelle) {
		this.nomMutuelle = nomMutuelle;
	}

	public List<CentreMutuelle> getCentreMutuelles() {
		return this.centreMutuelles;
	}

	public void setCentreMutuelles(List<CentreMutuelle> centreMutuelles) {
		this.centreMutuelles = centreMutuelles;
	}

	public CentreMutuelle addCentreMutuelle(CentreMutuelle centreMutuelle) {
		getCentreMutuelles().add(centreMutuelle);
		centreMutuelle.setMutuelle(this);

		return centreMutuelle;
	}

	public CentreMutuelle removeCentreMutuelle(CentreMutuelle centreMutuelle) {
		getCentreMutuelles().remove(centreMutuelle);
		centreMutuelle.setMutuelle(null);

		return centreMutuelle;
	}

	public List<Cotisation> getCotisations() {
		return this.cotisations;
	}

	public void setCotisations(List<Cotisation> cotisations) {
		this.cotisations = cotisations;
	}

	public Cotisation addCotisation(Cotisation cotisation) {
		getCotisations().add(cotisation);
		cotisation.setMutuelle(this);

		return cotisation;
	}

	public Cotisation removeCotisation(Cotisation cotisation) {
		getCotisations().remove(cotisation);
		cotisation.setMutuelle(null);

		return cotisation;
	}

}