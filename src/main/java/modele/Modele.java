package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Localite;
import controleur.Logement;
import controleur.Pays;
import controleur.Proprietaire;
import controleur.TypeLogement;
import controleur.User;
import controleur.Echanger;
import controleur.DemandeRecu;
import controleur.VueLogement;

public class Modele {
	private static Bdd uneBdd = new Bdd("localhost", "swapehome_chi", "root", "root");
	
	public static ArrayList<Pays> selectAllPays()
	{
		String requete ="select * from pays;";
		ArrayList<Pays> lesPays = new ArrayList<Pays>();
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet lesResultats = unStat.executeQuery(requete);
			while (lesResultats.next())
			{
				Pays unPays = new Pays(
						lesResultats.getInt("codepays"),
						lesResultats.getString("nompays")
						);			
			
				lesPays.add(unPays);						
						
			}
			unStat.execute(requete);
            unStat.close();
           
			
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Impossible d'executer la requete : " + requete);
		}
		return lesPays;
	}
	
	public static void updatePays(Pays unPays)
	{
		String requete ="update pays set nompays = '"+unPays.getNompays()
		+"' where codepays = "+unPays.getCodepays()+";";
		
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			unStat.execute(requete); 
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur d'exécution de la requete:"+requete);
		}
	}
	
	
	public static void deletePays(int codepays) 
	{
		String requete =" delete from pays where codepays = " + codepays+";" ; 	
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			unStat.execute(requete); 
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur d'exécution de la requete:"+requete);
		}
		
	}
	
	public static void insertPays(Pays unPays)
	{
		String requete ="insert into pays values (null, '" + unPays.getNompays() + "');";		
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			unStat.execute(requete); 
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur d'exécution de la requete:"+requete);
		}
	}

	public static Pays selectWherePays(int codepays) {
		String requete = "select * from pays  where codepays = " + codepays+";" ; 	
		Pays unPays = null; 
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			
			ResultSet unResultat = unStat.executeQuery(requete); 
			if (unResultat.next()) {
				unPays = new Pays(unResultat.getInt("codepays"), 
						 unResultat.getString("nompays"));
			}
			System.out.println(unPays.getNompays());
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur d'exécution de la requete:"+requete);
		}
		return unPays;
	}
	
	//CODE TYPE LOGEMENT
	
	public static ArrayList<TypeLogement> selectAllTypeLogements()
	{
		String requete ="select * from typelogement;";
		ArrayList<TypeLogement> lesTypeLogements = new ArrayList<TypeLogement>();
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet lesResultats = unStat.executeQuery(requete);
			while (lesResultats.next())
			{
				TypeLogement unTypeLogement = new TypeLogement(
						lesResultats.getInt("codetypelogement"),
						lesResultats.getString("libelle")
						);			
			
				lesTypeLogements.add(unTypeLogement);						
						
			}
			unStat.execute(requete);
            unStat.close();
           
			
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Impossible d'executer la requete : " + requete);
		}
		return lesTypeLogements;
	}
	
	public static void updateTypeLogement(TypeLogement unTypeLogement)
	{
		String requete ="update typelogement set libelle = '"+unTypeLogement.getLibelle()
		+"' where codetypelogement = "+unTypeLogement.getCodetypelogement()+";";
		
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			unStat.execute(requete); 
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur d'exécution de la requete:"+requete);
		}
	}
	
	public static void deleteTypeLogement(int codetypelogement) 
	{
		String requete =" delete from typelogement where codetypelogement = " + codetypelogement+" ;" ; 	
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			unStat.execute(requete); 
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur d'exécution de la requete:"+requete);
		}
		
	}
	
	public static void insertTypeLogement(TypeLogement unTypeLogement)
	{
		String requete ="insert into typelogement values (null, '" + unTypeLogement.getLibelle() + "');";		
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			unStat.execute(requete); 
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur d'exécution de la requete:"+requete);
		}
	}

	public static TypeLogement selectWhereTypeLogement(int codetypelogement) {
		String requete = "select * from typelogement  where codetypelogement = " + codetypelogement+";" ; 	
		TypeLogement unTypeLogement = null; 
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			
			ResultSet unResultat = unStat.executeQuery(requete); 
			if (unResultat.next()) {
				unTypeLogement = new TypeLogement(unResultat.getInt("codetypelogement"), 
						 unResultat.getString("libelle"));
			}
			System.out.println(unTypeLogement.getLibelle());
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur d'exécution de la requete:"+requete);
		}
		return unTypeLogement;
	}
	
	// LOCALITE
		
	public static ArrayList<Localite> selectAllLocalites()
		{
			String requete ="select * from localite;";
			ArrayList<Localite> lesLocalites = new ArrayList<Localite>();
			try {
				uneBdd.seConnecter();
				Statement unStat = uneBdd.getMaConnexion().createStatement();
				ResultSet lesResultats = unStat.executeQuery(requete);
				while (lesResultats.next())
				{
					Localite uneLocalite = new Localite(
							lesResultats.getInt("codelocalite"),
							lesResultats.getString("libelle"),
							lesResultats.getInt("codepays")
							);			
				
					lesLocalites.add(uneLocalite);						
							
				}
				unStat.execute(requete);
	            unStat.close();			
				uneBdd.seDeconnecter();
			}
			catch (SQLException exp) {
				System.out.println("Impossible d'executer la requete : " + requete);
			}
			return lesLocalites;
		}
		
		public static void updateLocalite(Localite uneLocalite)
		{
			String requete ="update localite set libelle = '"+uneLocalite.getLibelle() +"',codepays= " + uneLocalite.getCodepays()
			+" where codelocalite = "+uneLocalite.getCodelocalite()+";";
			
			try
			{
				uneBdd.seConnecter();
				Statement unStat = uneBdd.getMaConnexion().createStatement(); 
				unStat.execute(requete); 
				unStat.close();
				uneBdd.seDeconnecter();
			}
			catch (SQLException exp) {
				System.out.println("Erreur d'exécution de la requete:"+requete);
			}
		}
		
		public static void deleteLocalite(int codelocalite) 
		{
			String requete =" delete from localite where codelocalite = " + codelocalite+" ;" ; 	
			try
			{
				uneBdd.seConnecter();
				Statement unStat = uneBdd.getMaConnexion().createStatement(); 
				unStat.execute(requete); 
				unStat.close();
				uneBdd.seDeconnecter();
			}
			catch (SQLException exp) {
				System.out.println("Erreur d'exécution de la requete:"+requete);
			}
			
		}
		
		public static void insertLocalite(Localite unecodelocalite)
		{
			String requete ="insert into localite values (null, '" + unecodelocalite.getLibelle() + "'," + unecodelocalite.getCodepays() +");";		
			try
			{
				uneBdd.seConnecter();
				Statement unStat = uneBdd.getMaConnexion().createStatement(); 
				unStat.execute(requete); 
				unStat.close();
				uneBdd.seDeconnecter();
			}
			catch (SQLException exp) {
				System.out.println("Erreur d'exécution de la requete:"+requete);
			}
		}

		public static Localite selectWhereLocalite(int codelocalite) {
			String requete = "select * from localite  where codelocalite = " + codelocalite+";" ; 	
			Localite uneLocalite = null; 
			try
			{
				uneBdd.seConnecter();
				Statement unStat = uneBdd.getMaConnexion().createStatement(); 
				
				ResultSet unResultat = unStat.executeQuery(requete); 
				if (unResultat.next()) {
					uneLocalite = new Localite(
							unResultat.getInt("codelocalite"), 
							 unResultat.getString("libelle"),
							 unResultat.getInt("codepays"));
				}
				//System.out.println(uneLocalite.getLibelle());
				unStat.close();
				uneBdd.seDeconnecter();
			}
			catch (SQLException exp) {
				System.out.println("Erreur d'exécution de la requete:"+requete);
			}
			return uneLocalite;
		}
	
	
	
	//USER
		
		public static void insertUser(User unUser)
		{
			String requete ="insert into userglobal values (null, '" 
			+  unUser.getNom() 
			+ "','"+ unUser.getPrenom()
			+ "','"+ unUser.getAdresse()
			+ "','"+ unUser.getEmail()
			+ "','"+ unUser.getTel()
			+ "','"+ unUser.getCp()
			+ "','"+ unUser.getVille()
			+ "','"+ unUser.getLogin()
			+ "','"+ unUser.getMdp()
			+ "');";		
			try
			{
				uneBdd.seConnecter();
				Statement unStat = uneBdd.getMaConnexion().createStatement(); 
				unStat.execute(requete); 
				unStat.close();
				uneBdd.seDeconnecter();
			}
			catch (SQLException exp) {
				System.out.println("Erreur d'exécution de la requete:"+requete);
			}
		}
	
	
	
	//PROPRIETAIRE
	
		public static void insertProprietaire(Proprietaire unProprietaire)
		{
			String requete ="insert into proprietaire values (null, '" 
			+  unProprietaire.getDateinscription() 
			+ "','"+ unProprietaire.getProfilvoyageur()
			
			+ "','"+ unProprietaire.getDatedernierconnexion()
			+ "','"+ unProprietaire.getIduser()		
			+ "');";		
			try
			{
				uneBdd.seConnecter();
				Statement unStat = uneBdd.getMaConnexion().createStatement(); 
				unStat.execute(requete); 
				unStat.close();
				uneBdd.seDeconnecter();
			}
			catch (SQLException exp) {
				System.out.println("Erreur d'exécution de la requete:"+requete);
			}
		}

		public static User selectWhereIdUser(String login, String mdp) {
			String requete = "select * from userglobal  where login = '" + login +"' and mdp='" + mdp + "';" ; 	
			User unUser = null; 
			try
			{
				uneBdd.seConnecter();
				Statement unStat = uneBdd.getMaConnexion().createStatement(); 
				
				ResultSet unResultat = unStat.executeQuery(requete); 
				if (unResultat.next()) {
					unUser = new User(
							unResultat.getInt("iduser"), 
							 unResultat.getString("nom"),
							 unResultat.getString("prenom"),
							 unResultat.getString("adresse"),
							 unResultat.getString("email"),
							 unResultat.getString("tel"),							 
							 unResultat.getString("cp"),
							 unResultat.getString("ville"),
							 unResultat.getString("login"),
							 unResultat.getString("mdp"));
				}
				//System.out.println(uneLocalite.getLibelle());
				unStat.close();
				uneBdd.seDeconnecter();
			}
			catch (SQLException exp) {
				System.out.println("Erreur d'exécution de la requete:"+requete);
			}
			return unUser;
		}
	
		public static User selectWhereLoginUser(String login, String mdp) {
			String requete = "select * from userglobal  where login = '" + login +"' and mdp='" + mdp + "';" ; 	
			User unUser = null; 
			try
			{
				uneBdd.seConnecter();
				Statement unStat = uneBdd.getMaConnexion().createStatement(); 
				
				ResultSet unResultat = unStat.executeQuery(requete); 
				if (unResultat.next()) {
					unUser = new User(
							unResultat.getInt("iduser"), 
							 unResultat.getString("nom"),
							 unResultat.getString("prenom"),
							 unResultat.getString("adresse"),
							 unResultat.getString("email"),
							 unResultat.getString("tel"),
							 unResultat.getString("cp"),
							 unResultat.getString("ville"),
							 unResultat.getString("login"),
							 unResultat.getString("mdp"));
				}
				//System.out.println(uneLocalite.getLibelle());
				unStat.close();
				uneBdd.seDeconnecter();
			}
			catch (SQLException exp) {
				System.out.println("Erreur d'exécution de la requete:"+requete);
			}
			return unUser;
		}
		
		//LISTE DES OFFRES DISPO

		public static ArrayList<Logement> selectAllLogements() 
		{
			String requete ="select * from logement;";
			ArrayList<Logement> lesLogements = new ArrayList<Logement>();
			try {
				uneBdd.seConnecter();
				Statement unStat = uneBdd.getMaConnexion().createStatement();
				ResultSet lesResultats = unStat.executeQuery(requete);
				while (lesResultats.next())
				{
					Logement unLogement = new Logement(
							lesResultats.getInt("idlogement"),
							lesResultats.getInt("codelocalite"),
							lesResultats.getInt("codetypelogement"),
							lesResultats.getInt("idproprietaire"),
							lesResultats.getString("libelle"),
							lesResultats.getString("description"),
							lesResultats.getString("caracteristique"),
							lesResultats.getFloat("superficie"),
							lesResultats.getString("animaux"),
							lesResultats.getString("enfants"),
							lesResultats.getString("adresse"),
							lesResultats.getString("cplogement"),
							lesResultats.getString("villelogment"),
							lesResultats.getString("atouts"),
							lesResultats.getString("disponibilite"),
							lesResultats.getString("photo")
							);			
				
					lesLogements.add(unLogement);						
							
				}
				unStat.execute(requete);
	            unStat.close();	           				
				uneBdd.seDeconnecter();
			}
			catch (SQLException exp) {
				System.out.println("Impossible d'executer la requete : " + requete);
			}
			return lesLogements;
		}
	
		//LISTE DES MES MAISONS

		public static ArrayList<Logement> selectAllMesMaisons(int idproprietaire) 
		{
			String requete ="select * from logement where idproprietaire=" + idproprietaire +";";
			ArrayList<Logement> lesLogements = new ArrayList<Logement>();
			try {
				uneBdd.seConnecter();
				Statement unStat = uneBdd.getMaConnexion().createStatement();
				ResultSet lesResultats = unStat.executeQuery(requete);
				while (lesResultats.next())
				{
					Logement unLogement = new Logement(
							lesResultats.getInt("idlogement"),
							lesResultats.getInt("codelocalite"),
							lesResultats.getInt("codetypelogement"),
							lesResultats.getInt("idproprietaire"),
							lesResultats.getString("libelle"),
							lesResultats.getString("description"),
							lesResultats.getString("caracteristique"),
							lesResultats.getFloat("superficie"),
							lesResultats.getString("animaux"),
							lesResultats.getString("enfants"),
							lesResultats.getString("adresse"),
							lesResultats.getString("cplogement"),
							lesResultats.getString("villelogment"),
							lesResultats.getString("atouts"),
							lesResultats.getString("disponibilite"),
							lesResultats.getString("photo")
							);			
				
					lesLogements.add(unLogement);						
							
				}
				unStat.execute(requete);
	            unStat.close();	           				
				uneBdd.seDeconnecter();
			}
			catch (SQLException exp) {
				System.out.println("Impossible d'executer la requete : " + exp.getMessage());
			}
			return lesLogements;
		}

		//CHECK USER IS PROPRIETAIRE	
		public static Proprietaire selectWhereLoginUserProprietaire(int idpropri) {
			String requete = "select * from proprietaire  where iduser = " + idpropri + ";" ; 	
			Proprietaire unPropri = null; 
			try
			{
				uneBdd.seConnecter();
				Statement unStat = uneBdd.getMaConnexion().createStatement(); 
				
				ResultSet unResultat = unStat.executeQuery(requete); 
				if (unResultat.next()) {
					unPropri = new Proprietaire(
							unResultat.getInt("idproprietaire"), 
							 unResultat.getString("dateinscription"),							
							 unResultat.getString("profilvoyageur"),
							 unResultat.getString("datedernierconnexion"),
							 unResultat.getInt("iduser"));							
				}
				//System.out.println(uneLocalite.getLibelle());
				unStat.close();
				uneBdd.seDeconnecter();
			}
			catch (SQLException exp) {
				System.out.println("Erreur d'exécution de la requete:"+requete);
			}
			return unPropri;
		}
	
	
	// INSERT UN LOGEMENT
	
		public static void insertLogement(Logement unLogement)
		{
			String requete ="insert into logement values (null, " 
					+ unLogement.getCodelocalite() + ","
					+ unLogement.getCodetypelogement() + ","
					+ unLogement.getIdproprietaire() + ",'"
					+ unLogement.getLibelle() + "','"
					+ unLogement.getDescription() + "','"
					+ unLogement.getCaracteristique() + "',"
					+ unLogement.getSuperficie() + ",'"
					+ unLogement.getAnimaux() + "','"
					+ unLogement.getEnfants() + "','"
					+ unLogement.getAdresse() + "','"
					+ unLogement.getCplogement() + "','"
					+ unLogement.getVillelogment() + "','"
					+ unLogement.getAtouts() + "','"
					+ unLogement.getDisponibilite()+ "','"
					+ unLogement.getPhoto() 
					+ "');";		
			try
			{
				uneBdd.seConnecter();
				Statement unStat = uneBdd.getMaConnexion().createStatement(); 
				unStat.execute(requete); 
				unStat.close();
				uneBdd.seDeconnecter();
			}
			catch (SQLException exp) {
				System.out.println("Erreur d'exécution de la requete:"+requete);
			}
		}
	
	
	
	// Supprimer and modifier un logement
		public static void deleteLogement(int idlogement) 
		{
			String requete =" delete from logement where idlogement = " + idlogement+";" ; 	
			try
			{
				uneBdd.seConnecter();
				Statement unStat = uneBdd.getMaConnexion().createStatement(); 
				unStat.execute(requete); 
				unStat.close();
				uneBdd.seDeconnecter();
			}
			catch (SQLException exp) {
				System.out.println("Erreur d'exécution de la requete:"+requete);
			}
			
		}
	
		public static Logement selectWhereLogement(int idlogement) {
			String requete = "select * from logement  where idlogement = " + idlogement+";" ; 	
			Logement unLogement = null; 
			try
			{
				uneBdd.seConnecter();
				Statement unStat = uneBdd.getMaConnexion().createStatement(); 
				
				ResultSet unResultat = unStat.executeQuery(requete); 
				if (unResultat.next()) {
					unLogement = new Logement(
							unResultat.getInt("idlogement"),
							unResultat.getInt("codelocalite"),
							unResultat.getInt("codetypelogement"),
							unResultat.getInt("idproprietaire"),
							unResultat.getString("libelle"),
							unResultat.getString("description"),
							unResultat.getString("caracteristique"),
							unResultat.getFloat("superficie"),
							unResultat.getString("animaux"),
							unResultat.getString("enfants"),
							unResultat.getString("adresse"),
							unResultat.getString("cplogement"),
							unResultat.getString("villelogment"),
							unResultat.getString("atouts"),
							unResultat.getString("disponibilite"),
							unResultat.getString("photo"));
				}
				//System.out.println(uneLocalite.getLibelle());
				unStat.close();
				uneBdd.seDeconnecter();
			}
			catch (SQLException exp) {
				System.out.println("Erreur d'exécution de la requete:"+requete);
			}
			return unLogement;
		}
	
		public static void updateLogement(Logement unLogement)
		{
			String requete ="update logement set codelocalite = "
					+unLogement.getCodelocalite()
					+", codetypelogement =" + unLogement.getCodetypelogement() 
					+", idproprietaire =" + unLogement.getIdproprietaire() 
					+", libelle ='" + unLogement.getLibelle() 
					+"', description ='" + unLogement.getDescription() 
					+"', caracteristique ='" + unLogement.getCaracteristique() 
					+"', superficie =" + unLogement.getSuperficie() 
					+", animaux ='" + unLogement.getAnimaux() 
					+"', enfants ='" + unLogement.getEnfants() 					
					+"', adresse ='" + unLogement.getAdresse() 
					+"', cplogement ='" + unLogement.getCplogement() 
					+"', villelogment ='" + unLogement.getVillelogment() 
					+"', atouts ='" + unLogement.getAtouts() 
					+"', disponibilite ='" + unLogement.getDisponibilite() 	
					+"', photo ='" + unLogement.getPhoto() 	
					+"' where idlogement = "+unLogement.getIdlogement()+";";
			
			try
			{
				uneBdd.seConnecter();
				Statement unStat = uneBdd.getMaConnexion().createStatement(); 
				unStat.execute(requete); 
				unStat.close();
				uneBdd.seDeconnecter();
				
				//System.out.println(requete);
			}
			catch (SQLException exp) {
				System.out.println("Erreur d'exécution de la requete:"+requete);
			}
		}
	
	//INSERT UN ECHANGER
		public static void insertEchanger(Echanger unEchange)
		{
			String requete ="insert into echanger values (null, " + unEchange.getIdpro1()
			+ ", "+unEchange.getIdpro2() + "," + (unEchange.getIdlog1() == 0 ? "null" : unEchange.getIdlog1()) + "," +(unEchange.getIdlog2() == 0 ? "null" : unEchange.getIdlog2()) + ",'" + unEchange.getDatedemande() +"',null,'"	+unEchange.getDateentre() + "','" +unEchange.getDatesortie()
			+ "','" +unEchange.getStatus() + "');";		
			try
			{
				
				uneBdd.seConnecter();
				Statement unStat = uneBdd.getMaConnexion().createStatement(); 
				unStat.execute(requete); 
				unStat.close();
				uneBdd.seDeconnecter();
				
				
			}
			catch (SQLException exp) {
				System.out.println("Erreur d'exécution de la requete:"+requete);
			}
		}
		
		//select where demande reçu
		
		public static ArrayList<DemandeRecu> selectAllDemandeRecus(int idproprietaire) 
		{
			String requete ="select * from demande_recu where id_proprietaire_envoyer =" + idproprietaire +";";
			ArrayList<DemandeRecu> lesDemandesRecus = new ArrayList<DemandeRecu>();
			try {
				uneBdd.seConnecter();
				Statement unStat = uneBdd.getMaConnexion().createStatement();
				ResultSet lesResultats = unStat.executeQuery(requete);
				while (lesResultats.next())
				{
					DemandeRecu uneDemandeRecu = new DemandeRecu(
							lesResultats.getInt("id_echanger"),
							lesResultats.getString("date_demande"),
							lesResultats.getInt("id_proprietaire_envoyer"),
							lesResultats.getString("nom"),
							lesResultats.getString("prenom"),
							lesResultats.getString("libelle")
							);			
				
					lesDemandesRecus.add(uneDemandeRecu);						
							
				}
				unStat.execute(requete);
	            unStat.close();
	           
				
				uneBdd.seDeconnecter();
			}
			catch (SQLException exp) {
				System.out.println("Impossible d'executer la requete : " + requete);
			}
			return lesDemandesRecus;
		}
		
		public static ArrayList<Logement> selectAllMaisonsDispo(int idproprietaire) 
		{
			String requete ="select * from logement where idproprietaire=" + idproprietaire +" and disponibilite= \"oui\";";
			ArrayList<Logement> lesLogements = new ArrayList<Logement>();
			try {
				uneBdd.seConnecter();
				Statement unStat = uneBdd.getMaConnexion().createStatement();
				ResultSet lesResultats = unStat.executeQuery(requete);
				while (lesResultats.next())
				{
					Logement unLogement = new Logement(
							lesResultats.getInt("idlogement"),
							lesResultats.getInt("codelocalite"),
							lesResultats.getInt("codetypelogement"),
							lesResultats.getInt("idproprietaire"),
							lesResultats.getString("libelle"),
							lesResultats.getString("description"),
							lesResultats.getString("caracteristique"),
							lesResultats.getFloat("superficie"),
							lesResultats.getString("animaux"),
							lesResultats.getString("enfants"),
							lesResultats.getString("adresse"),
							lesResultats.getString("cplogement"),
							lesResultats.getString("villelogment"),
							lesResultats.getString("atouts"),
							lesResultats.getString("disponibilite"),
							lesResultats.getString("photo")
							
							);			
				
					lesLogements.add(unLogement);						
							
				}
				unStat.execute(requete);
	            unStat.close();	           				
				uneBdd.seDeconnecter();
			}
			catch (SQLException exp) {
				System.out.println("Impossible d'executer la requete : " + exp.getMessage());
			}
			return lesLogements;
		}
		
		
		public static void updateEchanger(int idechanger,int idlog1,String daterepondre, String status)
		{
			String requete ="update echanger set idlog1=" + idlog1 + " ,daterepondre='"+daterepondre +"',status='" + status + "' where idechanger=" +idechanger + ";";
			
			try
			{
				uneBdd.seConnecter();
				Statement unStat = uneBdd.getMaConnexion().createStatement(); 
				unStat.execute(requete); 
				unStat.close();
				uneBdd.seDeconnecter();
			}
			catch (SQLException exp) {
				System.out.println("Erreur d'exécution de la requete:"+requete);
			}
		}
		
		public static ArrayList<Echanger> selectAllDemandesPlusStatus(int idproprietaire) 
		{
			String requete ="select * from echanger where idpro1 =" + idproprietaire +" or idpro2 = "+idproprietaire +";";
			ArrayList<Echanger> lesEchanges = new ArrayList<Echanger>();
			try {
				uneBdd.seConnecter();
				Statement unStat = uneBdd.getMaConnexion().createStatement();
				ResultSet lesResultats = unStat.executeQuery(requete);
				while (lesResultats.next())
				{
					Echanger unEchange = new Echanger(
							lesResultats.getInt("idechanger"),
							lesResultats.getInt("idpro1"),
							lesResultats.getInt("idpro2"),
							lesResultats.getInt("idlog1"),
							lesResultats.getInt("idlog2"),
							lesResultats.getString("datedemande"),
							lesResultats.getString("daterepondre"),
							lesResultats.getString("dateentre"),
							lesResultats.getString("datesortie"),
							lesResultats.getString("status")
							);			
				
					lesEchanges.add(unEchange);						
							
				}
				unStat.execute(requete);
	            unStat.close();	           				
				uneBdd.seDeconnecter();
			}
			catch (SQLException exp) {
				System.out.println("Impossible d'executer la requete : " + exp.getMessage());
			}
			return lesEchanges;
		}
		
		//UPDATE PHOTO LOGEMENT

		public static void updatePhoto(String photo, int idlogement) 
		{
			String requete ="update logement set photo = '"+ photo
			+"' where idlogement = "+ idlogement +";";
			
			try
			{
				uneBdd.seConnecter();
				Statement unStat = uneBdd.getMaConnexion().createStatement(); 
				unStat.execute(requete); 
				unStat.close();
				uneBdd.seDeconnecter();
			}
			catch (SQLException exp) {
				System.out.println("Erreur d'exécution de la requete:"+requete);
			}
			
		}
		
		//VUE LOGEMENT
		public static ArrayList<VueLogement> selectAllOffres() 
		{
			String requete ="select * from VueLogement; ";
			ArrayList<VueLogement> lesOffres = new ArrayList<VueLogement>();
			try {
				uneBdd.seConnecter();
				Statement unStat = uneBdd.getMaConnexion().createStatement();
				ResultSet lesResultats = unStat.executeQuery(requete);
				while (lesResultats.next())
				{
					VueLogement unOffre = new VueLogement(
							lesResultats.getInt("idlogement"),
							lesResultats.getInt("idproprietaire"),
							lesResultats.getString("nom_proprietaire"),
							lesResultats.getString("prenom_proprietaire"),
							lesResultats.getString("email"),
							lesResultats.getString("typelogement"),
							lesResultats.getString("libelle"),
							lesResultats.getString("description"),
							lesResultats.getString("caracteristique"),
							lesResultats.getFloat("superficie"),
							lesResultats.getString("animaux"),
							lesResultats.getString("enfants"),
							lesResultats.getString("adresse"),
							lesResultats.getString("CP"),
							lesResultats.getString("ville"),
							lesResultats.getString("atouts"),
							lesResultats.getString("dispo"),
							lesResultats.getString("photo")
							);			
				
					lesOffres.add(unOffre);						
							
				}
				unStat.execute(requete);
	            unStat.close();	           				
				uneBdd.seDeconnecter();
			}
			catch (SQLException exp) {
				System.out.println("Impossible d'executer la requete : " + exp.getMessage());
			}
			return lesOffres;
		}
		
		//UPDATE DERNIERE CONNEXION
		
		public static void updateDernierConnxeion(int idproprietaire)
		{
			String requete ="update proprietaire set datedernierconnexion=CURRENT_TIMESTAMP() where idproprietaire = " + idproprietaire +"; ";
			
			try
			{
				uneBdd.seConnecter();
				Statement unStat = uneBdd.getMaConnexion().createStatement(); 
				unStat.execute(requete); 
				unStat.close();
				uneBdd.seDeconnecter();
				
				//System.out.println(requete);
			}
			catch (SQLException exp) {
				System.out.println("Erreur d'exécution de la requete:"+requete);
			}
		}
		
}
