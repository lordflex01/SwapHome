package controleur;

public class Logement {
	private int idlogement,codelocalite,codetypelogement,idproprietaire;
	private String libelle,description, caracteristique;
	private float superficie;
	private String animaux, enfants;
	private String adresse,cplogement,villelogment,atouts;
	private String disponibilite,photo;
	public Logement(int idlogement, int codelocalite, int codetypelogement, int idproprietaire, String libelle,
			String description, String caracteristique, float superficie, String animaux, String enfants,
			String adresse, String cplogement, String villelogment, String atouts, String disponibilite, String photo) {
		super();
		this.idlogement = idlogement;
		this.codelocalite = codelocalite;
		this.codetypelogement = codetypelogement;
		this.idproprietaire = idproprietaire;
		this.libelle = libelle;
		this.description = description;
		this.caracteristique = caracteristique;
		this.superficie = superficie;
		this.animaux = animaux;
		this.enfants = enfants;
		this.adresse = adresse;
		this.cplogement = cplogement;
		this.villelogment = villelogment;
		this.atouts = atouts;
		this.disponibilite = disponibilite;
		this.photo = photo;
	}
	public Logement(int codelocalite, int codetypelogement, int idproprietaire, String libelle,
			String description, String caracteristique, float superficie, String animaux, String enfants,
			String adresse, String cplogement, String villelogment, String atouts, String disponibilite, String photo) {
		super();
		this.idlogement = 0;
		this.codelocalite = codelocalite;
		this.codetypelogement = codetypelogement;
		this.idproprietaire = idproprietaire;
		this.libelle = libelle;
		this.description = description;
		this.caracteristique = caracteristique;
		this.superficie = superficie;
		this.animaux = animaux;
		this.enfants = enfants;
		this.adresse = adresse;
		this.cplogement = cplogement;
		this.villelogment = villelogment;
		this.atouts = atouts;
		this.disponibilite = disponibilite;
		this.photo = photo;
	}
	public int getIdlogement() {
		return idlogement;
	}
	public void setIdlogement(int idlogement) {
		this.idlogement = idlogement;
	}
	public int getCodelocalite() {
		return codelocalite;
	}
	public void setCodelocalite(int codelocalite) {
		this.codelocalite = codelocalite;
	}
	public int getCodetypelogement() {
		return codetypelogement;
	}
	public void setCodetypelogement(int codetypelogement) {
		this.codetypelogement = codetypelogement;
	}
	public int getIdproprietaire() {
		return idproprietaire;
	}
	public void setIdproprietaire(int idproprietaire) {
		this.idproprietaire = idproprietaire;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCaracteristique() {
		return caracteristique;
	}
	public void setCaracteristique(String caracteristique) {
		this.caracteristique = caracteristique;
	}
	public float getSuperficie() {
		return superficie;
	}
	public void setSuperficie(float superficie) {
		this.superficie = superficie;
	}
	public String getAnimaux() {
		return animaux;
	}
	public void setAnimaux(String animaux) {
		this.animaux = animaux;
	}
	public String getEnfants() {
		return enfants;
	}
	public void setEnfants(String enfants) {
		this.enfants = enfants;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getCplogement() {
		return cplogement;
	}
	public void setCplogement(String cplogement) {
		this.cplogement = cplogement;
	}
	public String getVillelogment() {
		return villelogment;
	}
	public void setVillelogment(String villelogment) {
		this.villelogment = villelogment;
	}
	public String getAtouts() {
		return atouts;
	}
	public void setAtouts(String atouts) {
		this.atouts = atouts;
	}
	public String getDisponibilite() {
		return disponibilite;
	}
	public void setDisponibilite(String disponibilite) {
		this.disponibilite = disponibilite;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	

	
	
	

}
