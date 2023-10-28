package controleur;

public class TypeLogement {
	private int codetypelogement;
	private String libelle;
	public TypeLogement(int codetypelogement, String libelle) {
		
		this.codetypelogement = codetypelogement;
		this.libelle = libelle;
	}
	
	public TypeLogement(String libelle) 
	{
	
		this.codetypelogement = 0;
		this.libelle = libelle;
	}

	public int getCodetypelogement() {
		return codetypelogement;
	}

	public void setCodetypelogement(int codetypelogement) {
		this.codetypelogement = codetypelogement;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	
	

}
