package com.pharmaweb.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the STATUT database table.
 * 
 */
@Entity
@NamedQuery(name="Statut.findAll", query="SELECT s FROM Statut s")
public class Statut implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_STATUT")
	private long idStatut;

	@Lob
	@Column(name="LIBELLE_STATUT")
	private String libelleStatut;

	//bi-directional many-to-one association to Client
	@OneToMany(mappedBy="statut")
	private List<Client> clients;

	//bi-directional many-to-one association to TauxRemboursementSecu
	@OneToMany(mappedBy="statut")
	private List<TauxRemboursementSecu> tauxRemboursementSecus;

	public Statut() {
	}

	public long getIdStatut() {
		return this.idStatut;
	}

	public void setIdStatut(long idStatut) {
		this.idStatut = idStatut;
	}

	public String getLibelleStatut() {
		return this.libelleStatut;
	}

	public void setLibelleStatut(String libelleStatut) {
		this.libelleStatut = libelleStatut;
	}

	public List<Client> getClients() {
		return this.clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public Client addClient(Client client) {
		getClients().add(client);
		client.setStatut(this);

		return client;
	}

	public Client removeClient(Client client) {
		getClients().remove(client);
		client.setStatut(null);

		return client;
	}

	public List<TauxRemboursementSecu> getTauxRemboursementSecus() {
		return this.tauxRemboursementSecus;
	}

	public void setTauxRemboursementSecus(List<TauxRemboursementSecu> tauxRemboursementSecus) {
		this.tauxRemboursementSecus = tauxRemboursementSecus;
	}

	public TauxRemboursementSecu addTauxRemboursementSecus(TauxRemboursementSecu tauxRemboursementSecus) {
		getTauxRemboursementSecus().add(tauxRemboursementSecus);
		tauxRemboursementSecus.setStatut(this);

		return tauxRemboursementSecus;
	}

	public TauxRemboursementSecu removeTauxRemboursementSecus(TauxRemboursementSecu tauxRemboursementSecus) {
		getTauxRemboursementSecus().remove(tauxRemboursementSecus);
		tauxRemboursementSecus.setStatut(null);

		return tauxRemboursementSecus;
	}

}