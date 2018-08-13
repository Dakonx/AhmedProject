package model;
//
import java.util.Date;
import java.util.List;

public class User {

	private int id;
	private String login;
	private String pass;
	private String nom;
	private String prenom;
	private String societe;
	private String telephone;
	private List<Parcour> parcours;
	private Date dateCréation;
	private Boolean statut;

	public User(int id, String login, String pass, String nom, String prenom, String societe, String telephone,
			Date dateCréation, Boolean statut) {
		super();
		this.id = id;
		this.login = login;
		this.pass = pass;
		this.nom = nom;
		this.prenom = prenom;
		this.societe = societe;
		this.telephone = telephone;
		this.dateCréation = dateCréation;
		this.statut=statut;
	}

	public User(int id, String login, String pass, String nom, String prenom, String societe, String telephone,
			List<Parcour> parcours, Date dateCréation,Boolean statut) {
		super();
		this.id = id;
		this.login = login;
		this.pass = pass;
		this.nom = nom;
		this.prenom = prenom;
		this.societe = societe;
		this.telephone = telephone;
		this.parcours = parcours;
		this.dateCréation = dateCréation;
		this.statut=statut;
	}

	public User() {
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Parcour> getParcour() {
		return parcours;
	}

	public void setParcour(List<Parcour> parcours) {
		this.parcours = parcours;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getSociete() {
		return societe;
	}

	public void setSociete(String societe) {
		this.societe = societe;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Date getDateCréation() {
		return dateCréation;
	}

	public void setDateCréation(Date dateCréation) {
		this.dateCréation = dateCréation;
	}

	public List<Parcour> getParcours() {
		return parcours;
	}

	public void setParcours(List<Parcour> parcours) {
		this.parcours = parcours;
	}

	public Boolean getStatut() {
		return statut;
	}

	public void setStatut(Boolean statut) {
		this.statut = statut;
	}
	

}
