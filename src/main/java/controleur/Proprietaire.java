package controleur;

public class Proprietaire{
	private int idproprietaire;
	private String dateinscription,profilvoyageur,datedernierconnexion;
	private int iduser;
	public Proprietaire(int idproprietaire, String dateinscription, String profilvoyageur, String datedernierconnexion,
			int iduser) {
		
		this.idproprietaire = idproprietaire;
		this.dateinscription = dateinscription;
		this.profilvoyageur = profilvoyageur;
		this.datedernierconnexion = datedernierconnexion;
		this.iduser = iduser;
	}
	
	public Proprietaire(String dateinscription, String profilvoyageur, String datedernierconnexion,
			int iduser) {
		
		this.idproprietaire = idproprietaire;
		this.dateinscription = dateinscription;
		this.profilvoyageur = profilvoyageur;
		this.datedernierconnexion = datedernierconnexion;
		this.iduser = iduser;
	}

	public int getIdproprietaire() {
		return idproprietaire;
	}

	public void setIdproprietaire(int idproprietaire) {
		this.idproprietaire = idproprietaire;
	}

	public String getDateinscription() {
		return dateinscription;
	}

	public void setDateinscription(String dateinscription) {
		this.dateinscription = dateinscription;
	}

	public String getProfilvoyageur() {
		return profilvoyageur;
	}

	public void setProfilvoyageur(String profilvoyageur) {
		this.profilvoyageur = profilvoyageur;
	}

	public String getDatedernierconnexion() {
		return datedernierconnexion;
	}

	public void setDatedernierconnexion(String datedernierconnexion) {
		this.datedernierconnexion = datedernierconnexion;
	}

	public int getIduser() {
		return iduser;
	}

	public void setIduser(int iduser) {
		this.iduser = iduser;
	}
	
	

}
