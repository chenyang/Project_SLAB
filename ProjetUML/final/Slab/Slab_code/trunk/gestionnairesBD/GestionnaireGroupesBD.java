package gestionnairesBD;

import java.sql.ResultSet;
import java.sql.SQLException;

import logic.Enseignant;
import logic.GestionnaireGroupes;
import logic.Groupe;


/**
 * classe de gestion des groupes avec une base de donnée Oracle
 * @author 
 *
 */
public class GestionnaireGroupesBD extends GestionnaireGroupes {

	/**
	 * constructeur de la classe
	 */
	public GestionnaireGroupesBD() {
		super();
	}
	
	/**
	 * permet de charger les groupes correspondant à l'enseignant en paramètre de la base de donnée dans la liste des groupes 
	 * @param e l'enseignant qui utilise l'application 
	 */
	public void chargerGroupes(Enseignant e) {
		
		int id_enseignant = 0;
		ResultSet resRequete;
		String groupe;
		
		resRequete = GestionnaireBD.getInstance().executeRequete("select id_enseignant from enseignant where nom = '" + e.getNom() + "' and prenom = '" + e.getPrenom() + "'");
		
		try {
			if(resRequete.next()) {
				
				id_enseignant = Integer.parseInt(resRequete.getString("id_enseignant"));
			}
		} catch (NumberFormatException e1) {
			
			e1.printStackTrace();
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		
		resRequete = GestionnaireBD.getInstance().executeRequete("select distinct(libelle_groupe) from groupe g, enseignement e where  e.id_groupe = g.id_groupe and e.id_enseignant =" + id_enseignant);
		
		try {
			while(resRequete.next()) {
				
				groupe = resRequete.getString(1);
				this.ajouterGroupe(new Groupe(groupe));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	}

}