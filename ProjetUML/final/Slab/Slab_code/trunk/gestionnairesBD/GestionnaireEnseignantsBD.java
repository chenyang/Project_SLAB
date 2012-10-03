package gestionnairesBD;

import java.sql.ResultSet;
import java.sql.SQLException;

import logic.Enseignant;
import logic.GestionnaireEnseignants;

/**
 * classe de gestion pour la gestion des enseignants avec une base de données Oracle
 * @author 
 *
 */
public class GestionnaireEnseignantsBD extends GestionnaireEnseignants {


	/**
	 * constructeur de la classe
	 */
	public GestionnaireEnseignantsBD() {
		super();
		
	}
	
	/**
	 * Charge les enseignants de la base de donnée dans la liste des enseignants qui ne correspondent pas à l'enssignant donné en paramètre
	 * @param e l'enseignant qui utilise l'application
	 */
	public void chargerEnseignants(Enseignant e) {
		
		ResultSet resRequete;
		String nom = null, prenom = null, supUser = null;
		boolean typeUtilisateur = false;
		
		resRequete = GestionnaireBD.getInstance().executeRequete("select * from enseignant where nom <> '" + e.getNom() + "' and prenom <> '" + e.getPrenom() + "'");
		
		if(resRequete != null) {
			try {
				while(resRequete.next()) {
					nom = resRequete.getString("NOM").trim();
					prenom = resRequete.getString("PRENOM").trim();
					supUser = resRequete.getString("SUPER_USER").trim();
					
					if(supUser.equals("1")) {
						typeUtilisateur = true;
					}
					else {
						typeUtilisateur = false;
					}
					
					System.out.println("ajout d'un enseignant");
					this.ajouterEnseignant(new Enseignant(nom, prenom, typeUtilisateur));
					System.out.println("nb d'enseignant : " + this.getEnseignants().size());
				
					System.out.println("nouvel enseignant ajoute");
				}
			} catch (SQLException exc) {

				exc.printStackTrace();
			}
		}
		
		GestionnaireBD.getInstance().closeStatement();
	}

}