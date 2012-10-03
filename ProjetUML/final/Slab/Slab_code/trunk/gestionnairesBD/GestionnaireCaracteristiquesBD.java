package gestionnairesBD;

import java.sql.ResultSet;
import java.sql.SQLException;

import logic.Caracteristique;
import logic.GestionnaireCaracteristiques;

/**
 * classe pour la gestion des caractéristiques avec une base de donnée Oracle
 * @author 
 *
 */
public class GestionnaireCaracteristiquesBD extends GestionnaireCaracteristiques {

  
	/**
	 * constructeur de la classe
	 */
	public GestionnaireCaracteristiquesBD() {
		super();
		
	}

	/**
	 * charge les caractéristiques de la base de données dans la liste des caractéristiques
	 */
  public void chargerCaracteristiques() {
	  System.out.println("charger caracteristique!!");
	  ResultSet resRequete;
	  resRequete = GestionnaireBD.getInstance().executeRequete("select * from caracteristique");
	  
	  try {
		while (resRequete.next()) {
			  String carac = resRequete.getString("LIBELLE_CARACTERISTIQUE");
			  System.out.println(carac);
			  this.ajouterCaracteristique(new Caracteristique(carac.trim()));
		  }
	} catch (SQLException e) {
		e.printStackTrace();
	}
	  
		GestionnaireBD.getInstance().closeStatement();
  }

}