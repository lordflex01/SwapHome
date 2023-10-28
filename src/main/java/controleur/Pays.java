package controleur;

public class Pays {
	private int codepays;
	private String nompays;
	public Pays(int codepays, String nompays) {
		
		this.codepays = codepays;
		this.nompays = nompays;
	}
	
	public Pays(String nompays) 
	{
		
		this.codepays = 0;
		this.nompays = nompays;
	}

	public int getCodepays() {
		return codepays;
	}

	public void setCodepays(int codepays) {
		this.codepays = codepays;
	}

	public String getNompays() {
		return nompays;
	}

	public void setNompays(String nompays) {
		this.nompays = nompays;
	}
	
	
	
	
	
	
	
}
