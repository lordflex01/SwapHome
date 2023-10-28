package controleur;
import java.util.ArrayList;
import modele.Modele;

public class Controleur {
	//PAYS
	public static void insertPays (Pays unPays)
	{
		
		Modele.insertPays(unPays);
	}
	
	public static ArrayList<Pays> selectAllPays()
	{
		return Modele.selectAllPays(); 
	}

	public static void deletePays(int codepays)
	{
		Modele.deletePays(codepays);
	}
		
	public static Pays selectWherePays(int codepays)
	{
		return Modele.selectWherePays(codepays);
	}
	public static void updatePays(Pays unPays)
	{
		Modele.updatePays(unPays);
	}
	
	//TYPE LOGEMENT
	
	public static ArrayList<TypeLogement> selectAllTypeLogements()
	{
		return Modele.selectAllTypeLogements(); 
	}
	public static void insertTypeLogement (TypeLogement unTypeLogement)
	{
		
		Modele.insertTypeLogement(unTypeLogement);
	}
	
	public static void deleteTypeLogement(int codetypelogement)
	{
		Modele.deleteTypeLogement(codetypelogement);
	}
		
	public static TypeLogement selectWhereTypeLogement(int codetypelogement)
	{
		return Modele.selectWhereTypeLogement(codetypelogement);
	}
	public static void updateTypeLogement(TypeLogement unTypeLogement)
	{
		Modele.updateTypeLogement(unTypeLogement);
	}
	//LOCALITE
	
	public static ArrayList<Localite> selectAllLocalites()
	{
		return Modele.selectAllLocalites(); 
	}
	public static void insertLocalite (Localite uneLocalite)
	{
		
		Modele.insertLocalite(uneLocalite);
	}
	
	public static void deleteLocalite(int codelocalite)
	{
		Modele.deleteLocalite(codelocalite);
	}
		
	public static Localite selectWhereLocalite(int codelocalite)
	{
		return Modele.selectWhereLocalite(codelocalite);
	}
	public static void updateLocalite(Localite uneLocalite)
	{
		Modele.updateLocalite(uneLocalite);
	}
	
	//USER
	public static void insertUser (User unUser)
	{
		
		Modele.insertUser(unUser);
	}
	public static void insertProprietaire (Proprietaire unProprietaire)
	{
		
		Modele.insertProprietaire(unProprietaire);
	}
	public static User selectWhereIdUser(String login, String mdp)
	{
		return Modele.selectWhereIdUser(login, mdp);
	}
	
	public static User selectWhereLoginUser(String login, String mdp)
	{
		return Modele.selectWhereLoginUser(login, mdp);
	}
	
	//LISTE DES LOGEMENTS DISPO
	public static ArrayList<Logement> selectAllLogements()
	{
		return Modele.selectAllLogements(); 
	}
	
	//LISTE DE MES MAISONS
	
	public static ArrayList<Logement> selectAllMesMaisons(int idproprietaire)
	{
		return Modele.selectAllMesMaisons(idproprietaire); 
	}
	//CHECK USER IS PROPRIETAIRE
	
	public static Proprietaire selectWhereLoginUserProprietaire(int idpropri)
	{
		return Modele.selectWhereLoginUserProprietaire(idpropri);
	}
	
	//INSERT LOGEMENT
	
	public static void insertLogement (Logement unLogement)
	{
		
		Modele.insertLogement(unLogement);
	}
	//logement proprietaire
	
	public static void deleteLogement(int idlogement)
	{
		Modele.deleteLogement(idlogement);
	}
		
	public static Logement selectWhereLogement(int idlogement)
	{
		return Modele.selectWhereLogement(idlogement);
	}
	public static void updateLogement(Logement unLogement)
	{
		Modele.updateLogement(unLogement);
	}
	
	//insert un echanger
	
	public static void insertEchanger(Echanger unEchanger)
	{
		
		Modele.insertEchanger(unEchanger);
	}
	
	//Demande recu
	
	public static ArrayList<DemandeRecu> selectAllDemandeRecus(int idproprietaire)
	{
		return Modele.selectAllDemandeRecus(idproprietaire); 
	}
	
	public static ArrayList<Logement> selectAllMaisonsDispo(int idproprietaire)
	{
		return Modele.selectAllMaisonsDispo(idproprietaire); 
	}
	
	public static void updateEchanger(int idechanger,int idlog1,String daterepondre, String status)
	{
		Modele.updateEchanger(idechanger,idlog1,daterepondre, status);
	}
	
	public static ArrayList<Echanger> selectAllDemandesPlusStatus(int idproprietaire)
	{
		return Modele.selectAllDemandesPlusStatus(idproprietaire); 
	}
	
	//update photo logement
	
	public static void updatePhoto(String photo, int idlogement)
	{
		Modele.updatePhoto(photo, idlogement);
	}
	
	//VueLogement
	public static ArrayList<VueLogement> selectAllOffres()
	{
		return Modele.selectAllOffres(); 
	}
	//update dernier connexion
	public static void updateDernierConnxeion(int idproprietaire)
	{
		Modele.updateDernierConnxeion(idproprietaire);
	}
}
