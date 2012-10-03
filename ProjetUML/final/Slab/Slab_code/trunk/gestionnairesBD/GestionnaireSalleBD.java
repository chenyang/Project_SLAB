package gestionnairesBD;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import logic.Caracteristique;
import logic.Creneau;
import logic.Disponible;
import logic.GestionnaireSalle;
import logic.Groupe;
import logic.Heure;
import logic.Salle;
import logic.Seance;

/**
 * permet la gestion des salles avec une base de donnée Oracle
 * @author 
 *
 */
public class GestionnaireSalleBD extends GestionnaireSalle{

	/**
	 * constructeur de la classe
	 */
	GestionnaireSalleBD()
	{
		super();
	}

	@Override
	/**
	 * retourne une liste de salles disponibles pour une réservation donnée
	 * @param reservation
	 * @return la listes des salles disponibles
	 */
	public ArrayList<Salle> getSallesDisponible(Seance reservation) 
	{
		int id_groupe = 0, id_enseignement = 0, id_creneau = 0, id_enseignant = 0, id_cours = 0, id_matiere = 0, id_typeCours = 0, id_reservation = 0, id_salle = 0;
  		String libSalle = null;
		String heure_debut = reservation.getCreneau().getHeureDebut().getNbHeure() + "h" + reservation.getCreneau().getHeureDebut().getNbMinutes();
  		String heure_fin = reservation.getCreneau().getHeureFin().getNbHeure() + "h" + reservation.getCreneau().getHeureFin().getNbMinutes();
  		ResultSet resRequete;
  		ArrayList<Salle> res = new ArrayList<Salle>();
  		
  		/* verification du creneau */
  		
  		if(reservation.getCreneau().getHeureDebut().getNbMinutes() == 0) {
  			
  			heure_debut = heure_debut + "0";
  		}
  		
  		if(reservation.getCreneau().getHeureFin().getNbMinutes() == 0) {
  			
  			heure_fin = heure_fin + "0";
  		}
  		
  		/* Recuperation de l'id du groupe */
  		resRequete = GestionnaireBD.getInstance().executeRequete("select id_groupe from groupe where libelle_groupe = '" + reservation.getEnseignement().getGroupe().getLibelleGroupe() + "'");

  		try {
  			resRequete.next();
			id_groupe = Integer.parseInt(resRequete.getString("ID_GROUPE"));
		} catch (NumberFormatException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
  		
		GestionnaireBD.getInstance().closeStatement();
  		
  		/* recuperation de l'id de l'enseignant */
  		resRequete = GestionnaireBD.getInstance().executeRequete("select id_enseignant from enseignant where nom = '" + reservation.getEnseignement().getEnseignant().getNom() +"' and prenom ='" + reservation.getEnseignement().getEnseignant().getPrenom() + "'");
  		try {
  			resRequete.next();
			id_enseignant = Integer.parseInt(resRequete.getString("ID_ENSEIGNANT"));
		} catch (NumberFormatException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
  		
		GestionnaireBD.getInstance().closeStatement();
  		
  		/*recuperation de l'id du type de cours */
  		
  		resRequete = GestionnaireBD.getInstance().executeRequete("select id_type_de_cours from typecours where libelle_type_de_cours = '" + reservation.getEnseignement().getTypeCours() + "'");
  		try {
  			resRequete.next();
			id_typeCours = Integer.parseInt(resRequete.getString("ID_TYPE_DE_COURS"));
		} catch (NumberFormatException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		GestionnaireBD.getInstance().closeStatement();
  		
  		/* recuperation id_matiere */
  		resRequete = GestionnaireBD.getInstance().executeRequete("select id_matiere from matiere where libelle_matiere = '" + reservation.getEnseignement().getMatiere() +"'");
  		try {
  			resRequete.next();
			id_matiere = Integer.parseInt(resRequete.getString("ID_MATIERE"));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		GestionnaireBD.getInstance().closeStatement();
  		
  		/* recuperation de l'id du cours */
  		
  		resRequete = GestionnaireBD.getInstance().executeRequete("select id_cours from cours where id_matiere = " + id_matiere + "and id_type_de_cours = " + id_typeCours);
		try {
			resRequete.next();
			id_cours = Integer.parseInt(resRequete.getString("ID_COURS"));
		} catch (NumberFormatException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		GestionnaireBD.getInstance().closeStatement();
		
		/* recuperation de l'id de l'enseignement */
		resRequete = GestionnaireBD.getInstance().executeRequete("select id_enseignement from enseignement where id_cours = " + id_cours + "and id_enseignant = " + id_enseignant + "and id_groupe = " + id_groupe);
  		try {
  			resRequete.next();
			id_enseignement = Integer.parseInt(resRequete.getString("ID_ENSEIGNEMENT"));
		} catch (NumberFormatException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		GestionnaireBD.getInstance().closeStatement();
  		
  		/* recuperation de l'id du creneau */
  		
  		System.out.println("Creneau recherchÔøΩ: " + heure_debut + "-" + heure_fin);
  		resRequete = GestionnaireBD.getInstance().executeRequete("select id_creneau from crenaux where heure_debut = '" + heure_debut + "' and heure_fin = '" + heure_fin +"'");
  		try {
  			resRequete.next();
			id_creneau = Integer.parseInt(resRequete.getString("ID_CRENEAU"));
		} catch (NumberFormatException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		GestionnaireBD.getInstance().closeStatement();
		
		/* recuperation de l'id reservation */
		
		resRequete = GestionnaireBD.getInstance().executeRequete("select id_reservation from reservation where id_creneau = " + id_creneau + " and id_enseignement = " + id_enseignement + " and date_reservation = to_date('" +  new java.sql.Date(reservation.getDate().getTime()).toString() + "', 'yy-mm-dd')");
		try {
  			resRequete.next();
			id_reservation = Integer.parseInt(resRequete.getString("id_reservation"));
		} catch (NumberFormatException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		GestionnaireBD.getInstance().closeStatement();
		
		/* Recuperation des salles correspondant aux caracteristiques */
		System.out.println("Reservation trouve : " + id_reservation);
		resRequete = GestionnaireBD.getInstance().executeRequete("Select s.ID_SALLE, s.numero_salle from salle s, reservation r where r.ID_RESERVATION = " + id_reservation + " and s.ID_SALLE in (select ID_SALLE from salle sa where (select count(ID_CARACTERISTIQUE) from caracteristique where ID_CARACTERISTIQUE in (( SELECT ID_CARACTERISTIQUE from reservation_caracteristique where ID_RESERVATION = r.ID_RESERVATION) MINUS(  SELECT ID_CARACTERISTIQUE from CARACTERISTIQUE_SALLE where ID_SALLE = sa.ID_SALLE))) = 0) and s.ID_SALLE not in (select sa.ID_SALLE from salle sa, reservation re WHERE sa.ID_SALLE = re.ID_SALLE and re.DATE_RESERVATION = r.DATE_RESERVATION and re.ID_CRENEAU = r.ID_CRENEAU)");
		
		
		try {
			while(resRequete.next()) {
				id_salle = Integer.parseInt(resRequete.getString("ID_SALLE"));
				libSalle = resRequete.getString("numero_salle").trim();
				res.add(new Salle(libSalle));
				System.out.println("Salles dispo : " + id_salle + " " + libSalle);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}
}

