package com.pharmaweb.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the COTISATION database table.
 * 
 */
@Entity
@NamedQuery(name="Cotisation.findAll", query="SELECT c FROM Cotisation c")
public class Cotisation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_COTISATION")
	private long idCotisation;

	@Lob
	@Column(name="TYPE_COTISATION")
	private String typeCotisation;

	//bi-directional many-to-one association to Client
	@OneToMany(mappedBy="cotisation")
	private List<Client> clients;

	//bi-directional many-to-one association to Mutuelle
	@ManyToOne
	@JoinColumn(name="ID_MUTUELLE")
	private Mutuelle mutuelle;

	//bi-directional many-to-one association to TauxRemboursementMutuelle
	@OneToMany(mappedBy="cotisation")
	private List<TauxRemboursementMutuelle> tauxRemboursementMutuelles;

	public Cotisation() {
	}

	public long getIdCotisation() {
		return this.idCotisation;
	}

	public void setIdCotisation(long idCotisation) {
		this.idCotisation = idCotisation;
	}

	public String getTypeCotisation() {
		return this.typeCotisation;
	}

	public void setTypeCotisation(String typeCotisation) {
		this.typeCotisation = typeCotisation;
	}

	public List<Client> getClients() {
		return this.clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public Client addClient(Client client) {
		getClients().add(client);
		client.setCotisation(this);

		return client;
	}

	public Client removeClient(Client client) {
		getClients().remove(client);
		client.setCotisation(null);

		return client;
	}

	public Mutuelle getMutuelle() {
		return this.mutuelle;
	}

	public void setMutuelle(Mutuelle mutuelle) {
		this.mutuelle = mutuelle;
	}

	public List<TauxRemboursementMutuelle> getTauxRemboursementMutuelles() {
		return this.tauxRemboursementMutuelles;
	}

	public void setTauxRemboursementMutuelles(List<TauxRemboursementMutuelle> tauxRemboursementMutuelles) {
		this.tauxRemboursementMutuelles = tauxRemboursementMutuelles;
	}

	public TauxRemboursementMutuelle addTauxRemboursementMutuelle(TauxRemboursementMutuelle tauxRemboursementMutuelle) {
		getTauxRemboursementMutuelles().add(tauxRemboursementMutuelle);
		tauxRemboursementMutuelle.setCotisation(this);

		return tauxRemboursementMutuelle;
	}

	public TauxRemboursementMutuelle removeTauxRemboursementMutuelle(TauxRemboursementMutuelle tauxRemboursementMutuelle) {
		getTauxRemboursementMutuelles().remove(tauxRemboursementMutuelle);
		tauxRemboursementMutuelle.setCotisation(null);

		return tauxRemboursementMutuelle;
	}

}