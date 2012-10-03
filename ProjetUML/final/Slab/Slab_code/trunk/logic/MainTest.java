package logic;

import exceptionsEDT.SalleIntrouvableException;
import gestionnaireFile.FactoryFile;
import gestionnairesBD.FactoryBD;
import gestionnairesBD.GestionnaireBD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractFactory.setInstance(new FactoryBD());
		Facade facade = new Facade();
		/*GestionnaireBD gbd = GestionnaireBD.getInstance();
		ResultSet res = gbd.executeRequete("select * from enseignant");
		String id, nom, prenom, mdp, su;
		ArrayList<Caracteristique> c;
		
		try {
			while(res.next()) {
				id = res.getString(1);
				nom = res.getString(2);
				prenom = res.getString(3);
				mdp = res.getString(4);
				su = res.getString(5);
				System.out.println("id : " + id + " nom : " + nom.trim() + " prenom : " + prenom.trim() + " mdp : " + mdp.trim() + " super : " + su.trim() );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		int resConnect = facade.connexion("Buisson", "lysianne");
		
		if(resConnect == 0) {
			
			System.out.println("echec authentification");
		}
		else if(resConnect == 1) {
			
			System.out.println("connexion d'un responsable");
		}
		else if(resConnect == 2) {
			System.out.println("connexion d'un enseignant");
		}
		else {
			System.out.println("indetermine");
		}
		
		/*c = facade.getCaracteristiques();
		
		for(Caracteristique car : c ) {
			
			System.out.println(car);
		}
		
		ArrayList<Reservation> r = facade.getDemandes();
		
		System.out.println("Demandes");
		if(r != null) {
			for(Reservation reserv : r) {
			
				System.out.println(reserv);
				try {
					facade.attribuerSalle(reserv, new Salle("SC201"));
				} catch (SalleIntrouvableException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		System.out.println("Planning");
		
		r = facade.getPlanning();
		ArrayList<Salle> sallesDispo = new ArrayList<Salle>();
		if(r != null) {
			for(Reservation reserv : r) {
			
				System.out.println(reserv);
				sallesDispo = facade.getSallesDisponibles((Seance) reserv);
				System.out.println("Salles disponibles");
				for(Salle s : sallesDispo) {
					System.out.println(s.toString());
				}
			}
		}
		/*int ret = 0;
		try {
		 ret = facade.demanderSeance(new Creneau(new Heure(8, 0), new Heure(9,30)), new Date(), new Enseignement(1,"TP", "Communication", new Groupe("IG4 anglais G3"),new Enseignant("Dulas", "Marc", false)), new ArrayList<Caracteristique>());
		} catch (CaracteristiqueIntrouvableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EnseignementIntrouvableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CreneauIntrouvableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DateIncorrecteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 System.out.println("ret : " + ret);
		
		Reservation reservation = new Seance();
		try {
			reservation = facade.getPlanning(new Creneau(new Heure(15, 0), new Heure(16, 30)),new Date(112, 2, 10) );
		} catch (CreneauIntrouvableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Reservation planning : " + new Date(112, 2, 10) + reservation); 

		
		try {
			System.out.println(facade.getNbHeureProgramme(new Enseignement(1,"TP", "Communication", new Groupe("IG4 anglais G3"),new Enseignant("Dulas", "Marc", false))));
		} catch (EnseignementIntrouvableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	*/	
	
		
		
	}
	
		
	

}
