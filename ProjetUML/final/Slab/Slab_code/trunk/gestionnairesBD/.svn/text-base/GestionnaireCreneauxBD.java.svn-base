package gestionnairesBD;

import java.sql.ResultSet;
import java.sql.SQLException;

import logic.Creneau;
import logic.GestionnaireCreneaux;
import logic.Heure;

public class GestionnaireCreneauxBD extends GestionnaireCreneaux {


	public GestionnaireCreneauxBD() {
		super();
	}

	/**
	 * Méthode qui charge tous les créneaux disponible dans la base de données
	 */
  public void chargerCreneaux() {
	  
	  ResultSet resRequete = GestionnaireBD.getInstance().executeRequete("select * from crenaux");
	  
	  try {
		while(resRequete.next()) {
			  
			String heureDeb = resRequete.getString("HEURE_DEBUT");
			String heureF = resRequete.getString("HEURE_FIN");
			
			System.out.println(heureDeb);
			System.out.println(heureF);
			String hdeb[] = heureDeb.split("h");
			String hfin[] = heureF.split("h");
			
			/* suppresion des espaces */
			hdeb[0] = hdeb[0].trim();
			hdeb[1] = hdeb[1].trim();
			hfin[0] = hfin[0].trim();
			hfin[1] = hfin[1].trim();
			
			if(hdeb[1].equals("00")) {
				hdeb[1] = "0";
			}
			
			if(hfin[1].equals("00")) {
				hfin[1] = "0";
			}
			
			
			Heure heureDebut = new Heure(Integer.parseInt(hdeb[0]), Integer.parseInt(hdeb[1]));
			Heure heureFin = new Heure(Integer.parseInt(hfin[0]), Integer.parseInt(hfin[1]));
			
			this.ajouterCreneau(new Creneau(heureDebut, heureFin));
			
			
		  }
	} catch (SQLException e) {
		e.printStackTrace();
	}
	  
		GestionnaireBD.getInstance().closeStatement();
  }

}