package controleur;

public class DemandeRecu {
	private int idechanger;
	private String datedemande;
	private int idproprietaire_envoyer;
	private String nom, prenom;	
	private String libelle;
	public DemandeRecu(int idechanger, String datedemande, int idproprietaire_envoyer, String nom, String prenom,
			String libelle) {
		super();
		this.idechanger = idechanger;
		this.datedemande = datedemande;
		this.idproprietaire_envoyer = idproprietaire_envoyer;
		this.nom = nom;
		this.prenom = prenom;
		this.libelle = libelle;
	}
	public int getIdechanger() {
		return idechanger;
	}
	public void setIdechanger(int idechanger) {
		this.idechanger = idechanger;
	}
	public String getDatedemande() {
		return datedemande;
	}
	public void setDatedemande(String datedemande) {
		this.datedemande = datedemande;
	}
	public int getIdproprietaire_envoyer() {
		return idproprietaire_envoyer;
	}
	public void setIdproprietaire_envoyer(int idproprietaire_envoyer) {
		this.idproprietaire_envoyer = idproprietaire_envoyer;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	
	
}
