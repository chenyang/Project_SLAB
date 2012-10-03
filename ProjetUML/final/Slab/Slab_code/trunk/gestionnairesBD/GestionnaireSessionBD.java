package gestionnairesBD;

import java.sql.ResultSet;
import java.sql.SQLException;

import logic.Enseignant;
import logic.GestionnaireSession;

/**
 * classe qui permet la gestion des sessions avec une base de donnée Oracle
 * @author 
 *
 */
public class GestionnaireSessionBD extends GestionnaireSession {

	/**
	 * constructeur de la classe
	 */
	public GestionnaireSessionBD() {
		
	}
	
	
	/**
	 * Authentifie un enseignant depuis la base de données
	 * @param login le login
	 * @param mdp le mot de passe
	 * @return Renvoie l'enseignant cr√©e ou null en cas d'echec.
	 */
	public Enseignant authentifier(String login,String  mdp) {
		
		Enseignant res = null;
		ResultSet resRequete;
		String nom = null, prenom = null, supUser = null;
		//mdp=encode(mdp);
		
		resRequete = GestionnaireBD.getInstance().executeRequete("select * from enseignant where nom = '" + login + "'" + " AND mdp = '" + mdp + "'");
		
		if(resRequete != null) {
			try {
				while(resRequete.next()) {
					nom = resRequete.getString("NOM").trim();
					prenom = resRequete.getString("PRENOM").trim();
					supUser = resRequete.getString("SUPER_USER").trim();
				
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(nom != null && prenom != null && supUser != null) {
			boolean sup = supUser.equals("1") ? true : false;
			res = new Enseignant(nom, prenom, sup);
			this.setEnseignant(res);
		}
		GestionnaireBD.getInstance().closeStatement();
		return res;
		
	}

}