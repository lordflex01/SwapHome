package controleur;

public class Echanger {
	private int idechanger,idpro1,idpro2,idlog1,idlog2;
	private String datedemande,daterepondre,dateentre,datesortie,status;
	public Echanger(int idechanger, int idpro1, int idpro2, int idlog1, int idlog2, String datedemande,
			String daterepondre, String dateentre, String datesortie, String status) {
		
		this.idechanger = idechanger;
		this.idpro1 = idpro1;
		this.idpro2 = idpro2;
		this.idlog1 = idlog1;
		this.idlog2 = idlog2;
		this.datedemande = datedemande;
		this.daterepondre = daterepondre;
		this.dateentre = dateentre;
		this.datesortie = datesortie;
		this.status = status;
	}
	
	public Echanger(int idpro1, int idpro2, int idlog1, int idlog2, String datedemande,
			String daterepondre, String dateentre, String datesortie, String status) {
		
		this.idechanger = 0;
		this.idpro1 = idpro1;
		this.idpro2 = idpro2;
		this.idlog1 = idlog1;
		this.idlog2 = idlog2;
		this.datedemande = datedemande;
		this.daterepondre = daterepondre;
		this.dateentre = dateentre;
		this.datesortie = datesortie;
		this.status = status;
	}

	public int getIdechanger() {
		return idechanger;
	}

	public void setIdechanger(int idechanger) {
		this.idechanger = idechanger;
	}

	public int getIdpro1() {
		return idpro1;
	}

	public void setIdpro1(int idpro1) {
		this.idpro1 = idpro1;
	}

	public int getIdpro2() {
		return idpro2;
	}

	public void setIdpro2(int idpro2) {
		this.idpro2 = idpro2;
	}

	public int getIdlog1() {
		return idlog1;
	}

	public void setIdlog1(int idlog1) {
		this.idlog1 = idlog1;
	}

	public int getIdlog2() {
		return idlog2;
	}

	public void setIdlog2(int idlog2) {
		this.idlog2 = idlog2;
	}

	public String getDatedemande() {
		return datedemande;
	}

	public void setDatedemande(String datedemande) {
		this.datedemande = datedemande;
	}

	public String getDaterepondre() {
		return daterepondre;
	}

	public void setDaterepondre(String daterepondre) {
		this.daterepondre = daterepondre;
	}

	public String getDateentre() {
		return dateentre;
	}

	public void setDateentre(String dateentre) {
		this.dateentre = dateentre;
	}

	public String getDatesortie() {
		return datesortie;
	}

	public void setDatesortie(String datesortie) {
		this.datesortie = datesortie;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
