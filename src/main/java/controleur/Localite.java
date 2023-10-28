package controleur;

public class Localite {
	private int codelocalite;
	private String libelle;
	private int codepays;
	public Localite(int codelocalite, String libelle, int codepays) 
	{
		super();
		this.codelocalite = codelocalite;
		this.libelle = libelle;
		this.codepays = codepays;
	}
	
	public Localite(String libelle, int codepays) 
	{
		
		this.codelocalite = 0;
		this.libelle = libelle;
		this.codepays = codepays;
	}

	public int getCodelocalite() {
		return codelocalite;
	}

	public void setCodelocalite(int codelocalite) {
		this.codelocalite = codelocalite;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public int getCodepays() {
		return codepays;
	}

	public void setCodepays(int codepays) {
		this.codepays = codepays;
	}
	
	
	

}
