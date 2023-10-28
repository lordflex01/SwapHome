package controleur;

public class VueLogement {
	private int idlogement,idproprietaire;
	private String nom_proprietaire, prenom_proprietaire, email, typelogement, libelle, description, caracteristique;
	private float superficie;
	private String animaux, enfants, adresse, CP, ville, atouts, dispo, photo;
	public VueLogement(int idlogement, int idproprietaire, String nom_proprietaire, String prenom_proprietaire,
			String email, String typelogement, String libelle, String description, String caracteristique,
			float superficie, String animaux, String enfants, String adresse, String cP, String ville, String atouts,
			String dispo, String photo) {
		super();
		this.idlogement = idlogement;
		this.idproprietaire = idproprietaire;
		this.nom_proprietaire = nom_proprietaire;
		this.prenom_proprietaire = prenom_proprietaire;
		this.email = email;
		this.typelogement = typelogement;
		this.libelle = libelle;
		this.description = description;
		this.caracteristique = caracteristique;
		this.superficie = superficie;
		this.animaux = animaux;
		this.enfants = enfants;
		this.adresse = adresse;
		CP = cP;
		this.ville = ville;
		this.atouts = atouts;
		this.dispo = dispo;
		this.photo = photo;
	}
	public int getIdlogement() {
		return idlogement;
	}
	public void setIdlogement(int idlogement) {
		this.idlogement = idlogement;
	}
	public int getIdproprietaire() {
		return idproprietaire;
	}
	public void setIdproprietaire(int idproprietaire) {
		this.idproprietaire = idproprietaire;
	}
	public String getNom_proprietaire() {
		return nom_proprietaire;
	}
	public void setNom_proprietaire(String nom_proprietaire) {
		this.nom_proprietaire = nom_proprietaire;
	}
	public String getPrenom_proprietaire() {
		return prenom_proprietaire;
	}
	public void setPrenom_proprietaire(String prenom_proprietaire) {
		this.prenom_proprietaire = prenom_proprietaire;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTypelogement() {
		return typelogement;
	}
	public void setTypelogement(String typelogement) {
		this.typelogement = typelogement;
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
	public String getCP() {
		return CP;
	}
	public void setCP(String cP) {
		CP = cP;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getAtouts() {
		return atouts;
	}
	public void setAtouts(String atouts) {
		this.atouts = atouts;
	}
	public String getDispo() {
		return dispo;
	}
	public void setDispo(String dispo) {
		this.dispo = dispo;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	
	
	

}
