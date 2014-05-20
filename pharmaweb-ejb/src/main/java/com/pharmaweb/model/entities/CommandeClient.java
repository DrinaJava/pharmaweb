package com.pharmaweb.model.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the COMMANDE_CLIENT database table.
 * 
 */
@Entity
@Table(name="COMMANDE_CLIENT")
@NamedQuery(name="CommandeClient.findAll", query="SELECT c FROM CommandeClient c")
public class CommandeClient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_COMMANDE_CLIENT")
	@SequenceGenerator(name="IncCommandeClient",sequenceName="SEQ_COMMANDE_CLIENT", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="IncCommandeClient")
	private long idCommandeClient;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_COMMANDE_CLIENT")
	private Date dateCommandeClient;

	@Lob
	@Column(name="NUM_COMMANDE_CLIENT")
	private String numCommandeClient;

	//bi-directional many-to-one association to Adresse
	@ManyToOne
	@JoinColumn(name="ID_ADRESSE")
	private Adresse adresse;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="ID_CLIENT")
	private Client client;

	//bi-directional many-to-many association to Ordonnance
	@ManyToMany
	@JoinTable(
		name="EST_POUR"
		, joinColumns={
			@JoinColumn(name="ID_COMMANDE_CLIENT")
			}
		, inverseJoinColumns={
			@JoinColumn(name="ID_ORDONNANCE")
			}
		)
	private List<Ordonnance> ordonnances;

	//bi-directional many-to-one association to Pharmacie
	@ManyToOne
	@JoinColumn(name="ID_PHARMACIE")
	private Pharmacie pharmacie;

	//bi-directional many-to-one association to Discussion
	@OneToMany(mappedBy="commandeClient")
	private List<Discussion> discussions;

	//bi-directional many-to-one association to CommandeLotProduit
	@OneToMany(mappedBy="commandeClient", cascade=CascadeType.PERSIST)
	private List<CommandeLotProduit> estDansLaCommandeClients;

	public CommandeClient() {
	}

	public long getIdCommandeClient() {
		return this.idCommandeClient;
	}

	public void setIdCommandeClient(long idCommandeClient) {
		this.idCommandeClient = idCommandeClient;
	}

	public Date getDateCommandeClient() {
		return this.dateCommandeClient;
	}

	public void setDateCommandeClient(Date dateCommandeClient) {
		this.dateCommandeClient = dateCommandeClient;
	}

	public String getNumCommandeClient() {
		return this.numCommandeClient;
	}

	public void setNumCommandeClient(String numCommandeClient) {
		this.numCommandeClient = numCommandeClient;
	}

	public Adresse getAdresse() {
		return this.adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Ordonnance> getOrdonnances() {
		return this.ordonnances;
	}

	public void setOrdonnances(List<Ordonnance> ordonnances) {
		this.ordonnances = ordonnances;
	}

	public Pharmacie getPharmacie() {
		return this.pharmacie;
	}

	public void setPharmacie(Pharmacie pharmacie) {
		this.pharmacie = pharmacie;
	}

	public List<Discussion> getDiscussions() {
		return this.discussions;
	}

	public void setDiscussions(List<Discussion> discussions) {
		this.discussions = discussions;
	}

	public Discussion addDiscussion(Discussion discussion) {
		getDiscussions().add(discussion);
		discussion.setCommandeClient(this);

		return discussion;
	}

	public Discussion removeDiscussion(Discussion discussion) {
		getDiscussions().remove(discussion);
		discussion.setCommandeClient(null);

		return discussion;
	}

	public List<CommandeLotProduit> getEstDansLaCommandeClients() {
		return this.estDansLaCommandeClients;
	}

	public void setEstDansLaCommandeClients(List<CommandeLotProduit> estDansLaCommandeClients) {
		this.estDansLaCommandeClients = estDansLaCommandeClients;
	}

	public CommandeLotProduit addEstDansLaCommandeClient(CommandeLotProduit estDansLaCommandeClient) {
		getEstDansLaCommandeClients().add(estDansLaCommandeClient);
		estDansLaCommandeClient.setCommandeClient(this);

		return estDansLaCommandeClient;
	}

	public CommandeLotProduit removeEstDansLaCommandeClient(CommandeLotProduit estDansLaCommandeClient) {
		getEstDansLaCommandeClients().remove(estDansLaCommandeClient);
		estDansLaCommandeClient.setCommandeClient(null);

		return estDansLaCommandeClient;
	}

}