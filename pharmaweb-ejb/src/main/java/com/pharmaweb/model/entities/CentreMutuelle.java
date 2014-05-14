package com.pharmaweb.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the CENTRE_MUTUELLE database table.
 * 
 */
@Entity
@Table(name="CENTRE_MUTUELLE")
@NamedQuery(name="CentreMutuelle.findAll", query="SELECT c FROM CentreMutuelle c")
public class CentreMutuelle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_CENTRE_MUTUELLE")
	private long idCentreMutuelle;

	@Lob
	@Column(name="MAIL_CENTRE_MUTUELLE")
	private String mailCentreMutuelle;

	@Lob
	@Column(name="NOM_CENTRE_MUTUELLE")
	private String nomCentreMutuelle;

	@Column(name="TELEPHONE_CENTRE_MUTUELLE")
	private BigDecimal telephoneCentreMutuelle;

	//bi-directional many-to-one association to Adresse
	@ManyToOne
	@JoinColumn(name="ID_ADRESSE")
	private Adresse adresse;

	//bi-directional many-to-one association to Mutuelle
	@ManyToOne
	@JoinColumn(name="ID_MUTUELLE")
	private Mutuelle mutuelle;

	//bi-directional many-to-one association to Client
	@OneToMany(mappedBy="centreMutuelle")
	private List<Client> clients;

	public CentreMutuelle() {
	}

	public long getIdCentreMutuelle() {
		return this.idCentreMutuelle;
	}

	public void setIdCentreMutuelle(long idCentreMutuelle) {
		this.idCentreMutuelle = idCentreMutuelle;
	}

	public String getMailCentreMutuelle() {
		return this.mailCentreMutuelle;
	}

	public void setMailCentreMutuelle(String mailCentreMutuelle) {
		this.mailCentreMutuelle = mailCentreMutuelle;
	}

	public String getNomCentreMutuelle() {
		return this.nomCentreMutuelle;
	}

	public void setNomCentreMutuelle(String nomCentreMutuelle) {
		this.nomCentreMutuelle = nomCentreMutuelle;
	}

	public BigDecimal getTelephoneCentreMutuelle() {
		return this.telephoneCentreMutuelle;
	}

	public void setTelephoneCentreMutuelle(BigDecimal telephoneCentreMutuelle) {
		this.telephoneCentreMutuelle = telephoneCentreMutuelle;
	}

	public Adresse getAdresse() {
		return this.adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Mutuelle getMutuelle() {
		return this.mutuelle;
	}

	public void setMutuelle(Mutuelle mutuelle) {
		this.mutuelle = mutuelle;
	}

	public List<Client> getClients() {
		return this.clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public Client addClient(Client client) {
		getClients().add(client);
		client.setCentreMutuelle(this);

		return client;
	}

	public Client removeClient(Client client) {
		getClients().remove(client);
		client.setCentreMutuelle(null);

		return client;
	}

}