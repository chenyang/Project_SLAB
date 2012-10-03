package gestionnairesBD;

import java.sql.ResultSet;
import java.sql.SQLException;

import logic.Enseignant;
import logic.Enseignement;
import logic.GestionnaireEnseignements;
import logic.Groupe;


/**
 * classe de gestion des enseignements avec une base de données Oracle
 * @author 
 *
 */
public class GestionnaireEnseignementsBD extends GestionnaireEnseignements {


	/**
	 * constructeur de la classe
	 */
	public GestionnaireEnseignementsBD() {
		super();
	}
	
	/**
	 * permet de charger tous les enseignements de la base de données dans la liste des enseignements correspondant à l'enseignant en paramètre
	 * @param e l'enseignant qui utilise le logiciel
	 */
	public void chargerEnseignements(Enseignant e) {
		
		String typeCours, libMatiere, libGroupe;
		int nbHeures;
		
		ResultSet resRequete = GestionnaireBD.getInstance().executeRequete("select Ens.RefE.nb_heure_prevue, deref(deref(Ens.RefE.cours).type_cours).libelle_type_cours, deref(deref(Ens.RefE.cours).matiere).libelle_matiere, deref(Ens.RefE.groupe).libelle_groupe from table( select E.liste_enseignement from VEnseignant E where E.nom = '" + e.getNom() + "' AND E.prenom = '" + e.getPrenom() +"') Ens");
;
		
		
		if(resRequete != null) {
		try {
			while(resRequete.next()) {
				
				nbHeures = Integer.parseInt(resRequete.getString(1).trim());
				typeCours = resRequete.getString(2).trim();
				libMatiere = resRequete.getString(3).trim();
				libGroupe = resRequete.getString(4).trim();
				
				this.ajouterEnseignement(new Enseignement(nbHeures, typeCours, libMatiere, new Groupe(libGroupe), e));
				
			}
		} catch (NumberFormatException e1) {
			
			e1.printStackTrace();
		} catch (SQLException e1) {
		
			e1.printStackTrace();
		}
		GestionnaireBD.getInstance().closeStatement();
		}
		else {
			
			System.out.println("aucun enseignement");
		}
	}

}