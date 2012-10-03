package gestionnairesBD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import exceptionsEDT.SalleIntrouvableException;

import logic.Creneau;
import logic.Enseignant;
import logic.Enseignement;
import logic.GestionnaireReservations;
import logic.Groupe;
import logic.Heure;
import logic.Reservation;
import logic.Salle;
import logic.Seance;

/**
 * classe pour la gestion des r�servations avec une base de donn�es Oracle
 * @author 
 *
 */
public class GestionnaireReservationsBD extends GestionnaireReservations {

	/**
	 * contructeur de la classe
	 */
	public GestionnaireReservationsBD() {
		
	}

  	@Override
  	/**
  	 * enregistre dans la base de donn�e la s�ance 
  	 * @param s la s�ance � enregistrer
  	 * @return 1 si ca a fonctionn�, 0 sinon
  	 */
  	public int enregistrerSeance(Seance s) {
  		
  		int id_groupe = 0, id_enseignement = 0, id_creneau = 0, id_enseignant = 0, id_cours = 0, id_matiere = 0, id_typeCours = 0, id_reservation = 0;
  		String heure_debut = s.getCreneau().getHeureDebut().getNbHeure() + "h" + s.getCreneau().getHeureDebut().getNbMinutes();
  		String heure_fin = s.getCreneau().getHeureFin().getNbHeure() + "h" + s.getCreneau().getHeureFin().getNbMinutes();
  		ResultSet resRequete;
  		int res = 0;
  		
  		/* verification du creneau */
  		
  		if(s.getCreneau().getHeureDebut().getNbMinutes() == 0) {
  			
  			heure_debut = heure_debut + "0";
  		}
  		
  		if(s.getCreneau().getHeureFin().getNbMinutes() == 0) {
  			
  			heure_fin = heure_fin + "0";
  		}
  		
  		/* Recuperation de l'id du groupe */
  		resRequete = GestionnaireBD.getInstance().executeRequete("select id_groupe from groupe where libelle_groupe = '" + s.getEnseignement().getGroupe().getLibelleGroupe() + "'");

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
  		resRequete = GestionnaireBD.getInstance().executeRequete("select id_enseignant from enseignant where nom = '" + s.getEnseignement().getEnseignant().getNom() +"' and prenom ='" + s.getEnseignement().getEnseignant().getPrenom() + "'");
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
  		
  		resRequete = GestionnaireBD.getInstance().executeRequete("select id_type_de_cours from typecours where libelle_type_de_cours = '" + s.getEnseignement().getTypeCours() + "'");
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
  		resRequete = GestionnaireBD.getInstance().executeRequete("select id_matiere from matiere where libelle_matiere = '" + s.getEnseignement().getMatiere() +"'");
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
  		
  		System.out.println("Creneau recherché : " + heure_debut + "-" + heure_fin);
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
		
  		/* calcul de l'id reservation */
  		resRequete = GestionnaireBD.getInstance().executeRequete("select max(id_reservation) from reservation");
  		try {
  			resRequete.next();
			id_reservation = Integer.parseInt(resRequete.getString(1)) + 1;
			System.out.println("id_reservation : " + id_reservation);
		} catch (NumberFormatException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		GestionnaireBD.getInstance().closeStatement();
  		
  		/* verification disponibilité groupe */
  		
  		String requeteGroupe = "select id_reservation from VReservation r where deref(r.creneau).id_creneau = "+ id_creneau + " and deref(deref(r.enseignement).groupe).id_groupe =  " + id_groupe  +"  and deref(r.salle).id_salle is not null AND r.dateRes = to_date('" +  new java.sql.Date(s.getDate().getTime()).toString() + "', 'yy-mm-dd')";
  		ResultSet resTrouve = null;
  		resTrouve = GestionnaireBD.getInstance().executeRequete(requeteGroupe);
  		
  		try {
			if(resTrouve.next()) {
				System.out.println("le groupe est occupé");
				res = 2;
				return res;
				
			}
			else {
			// verification des disponibilités groupe pere;
				int id_groupe_tmp = id_groupe;
				ResultSet groupePere = GestionnaireBD.getInstance().executeRequete("select id_groupe_a_pour_pere from groupe where id_groupe = " + id_groupe +"AND id_groupe_a_pour_pere is not null");
				
				while(groupePere.next()) {
					
					try {
						id_groupe_tmp = Integer.parseInt(groupePere.getString("id_groupe_a_pour_pere"));
						System.out.println("groupe pere : " + id_groupe_tmp);
					} catch (NumberFormatException e) {

						e.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					requeteGroupe = "select id_reservation from VReservation r where deref(r.creneau).id_creneau = "+ id_creneau + " and deref(deref(r.enseignement).groupe).id_groupe =  " + id_groupe_tmp  +"  and deref(r.salle).id_salle is not null AND r.dateRes = to_date('" +  new java.sql.Date(s.getDate().getTime()).toString() + "', 'yy-mm-dd')";
					resTrouve = GestionnaireBD.getInstance().executeRequete(requeteGroupe);
			  		
			  		if(resTrouve.next()) {
			  			System.out.println("le groupe pere est occupé");
			  			res = 2;
			  			return res;
			  			
			  		}
			  		else {
			  			
			  			groupePere = GestionnaireBD.getInstance().executeRequete("select id_groupe_a_pour_pere from groupe where id_groupe = " + id_groupe_tmp + " and id_groupe_a_pour_pere is not null");
			  		}
				}
				
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GestionnaireBD.getInstance().closeStatement();
  		
  		/* Vérification disponibilité de l'enseignant */
  		resRequete = GestionnaireBD.getInstance().executeRequete("select Res.RefR.id_reservation from table(select E.liste_Reservations from VEnseignant E where nom = '" + s.getEnseignement().getEnseignant().getNom() + "' AND prenom = '" + s.getEnseignement().getEnseignant().getPrenom() + "') Res where Res.RefR.salle is NOT NULL AND deref(Res.RefR.creneau).id_creneau = " + id_creneau + "AND Res.RefR.dateRes = to_date('" +  new java.sql.Date(s.getDate().getTime()).toString() + "', 'yy-mm-dd')");
  		try {
			if(resRequete.next()) {
				
				res = 3;
				return res;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		GestionnaireBD.getInstance().closeStatement();
  		
  		/* realisation de la requete d'insertion */
  		String requete = "insert into reservation values("+ id_reservation +", null, " + id_creneau + "," + id_enseignement +", " + "to_date('" +  new java.sql.Date(s.getDate().getTime()).toString() + "', 'yy-mm-dd'))";
  		System.out.println(requete);
  		res = GestionnaireBD.getInstance().executeUpdate( requete );
  		
  		if(res > 0) {
  			
  			res = 1;
  		}
  		else{
  			
  			res = 0;
  		}
  		
		GestionnaireBD.getInstance().closeStatement();
		return res;
	}

	/**
	 * @return Donne les demandes en cours de l'enseignant donn�e en parametre.
	 * @param e l'enseignant correspondant � la s�ance
	 */
	public ArrayList<Reservation> getDemandes(Enseignant e) {
		
		ArrayList<Reservation> res = new ArrayList<Reservation>();
		ResultSet resRequete = GestionnaireBD.getInstance().executeRequete("select Res.RefR.id_reservation, deref(Res.RefR.creneau).heure_debut, deref(Res.RefR.creneau).heure_fin, deref(Res.RefR.enseignement).nb_heure_prevue, deref(deref(deref(Res.RefR.enseignement).cours).matiere).libelle_matiere,deref(deref(deref(Res.RefR.enseignement).cours).type_cours).libelle_type_cours, deref(deref(Res.RefR.enseignement).groupe).libelle_groupe,Res.RefR.dateRes from table(select E.liste_Reservations from VEnseignant E where nom = '" + e.getNom() + "' AND prenom = '" + e.getPrenom() + "') Res where Res.RefR.salle is NULL");
		int nbHeures;
		String typeCours, libMatiere, libGroupe;
		
		if(resRequete != null) {
			
			try {
				while(resRequete.next()) {
					
					/* Enseignement lié a la seance */
					Enseignement ens;
					nbHeures = Integer.parseInt(resRequete.getString(4).trim());
					libMatiere = resRequete.getString(5).trim();
					typeCours = resRequete.getString(6).trim();
					libGroupe = resRequete.getString(7).trim();
					ens = new Enseignement(nbHeures, typeCours, libMatiere, new Groupe(libGroupe), e);
					
					
					/* Creneau */
					Creneau c;
					String heureDeb = resRequete.getString(2);
					String heureF = resRequete.getString(3);

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
					
					c = new Creneau(heureDebut, heureFin);
					
					/* Date */
					
					Date date = resRequete.getDate(8);
					
					res.add(new Seance(c, date, ens, null, null));
					
					
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		GestionnaireBD.getInstance().closeStatement();
		return res;
	}

	@Override
	/**
	 * 
	 * @param un enseignant
	 * @return la liste des r�servations de l'enseignant
	 */
	public ArrayList<Reservation> getPlanning(Enseignant e) {
		
		ArrayList<Reservation> res = new ArrayList<Reservation>();
		ResultSet resRequete = GestionnaireBD.getInstance().executeRequete("select Res.RefR.id_reservation, deref(Res.RefR.creneau).heure_debut, deref(Res.RefR.creneau).heure_fin, deref(Res.RefR.enseignement).nb_heure_prevue, deref(deref(deref(Res.RefR.enseignement).cours).matiere).libelle_matiere,deref(deref(deref(Res.RefR.enseignement).cours).type_cours).libelle_type_cours, deref(deref(Res.RefR.enseignement).groupe).libelle_groupe,Res.RefR.dateRes, deref(Res.Refr.salle).numero_salle from table(select E.liste_Reservations from VEnseignant E where nom = '" + e.getNom() + "' AND prenom = '" + e.getPrenom() + "') Res where Res.RefR.salle is NOT NULL" + " and deref(Res.RefR.salle).numero_salle <> 'REFUS'");
		int nbHeures;
		String typeCours, libMatiere, libGroupe, salle;
		
		if(resRequete != null) {
			
			try {
				while(resRequete.next()) {
					
					/* Enseignement lié a la seance */
					Enseignement ens;
					nbHeures = Integer.parseInt(resRequete.getString(4).trim());
					libMatiere = resRequete.getString(5).trim();
					typeCours = resRequete.getString(6).trim();
					libGroupe = resRequete.getString(7).trim();
					ens = new Enseignement(nbHeures, typeCours, libMatiere, new Groupe(libGroupe), e);
					
					
					/* Creneau */
					Creneau c;
					String heureDeb = resRequete.getString(2);
					String heureF = resRequete.getString(3);

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
					
					c = new Creneau(heureDebut, heureFin);
					
					/* Date */
					
					Date date = resRequete.getDate(8);
					
					/* Salle */
					
					salle = resRequete.getString(9).trim();
					res.add(new Seance(c, date, ens, null, new Salle(salle)));
					
					
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		Collections.sort(res);
		GestionnaireBD.getInstance().closeStatement();
		return res;
		
	}
	
	
	public Reservation getPlanning(Enseignant e, Creneau creneau, Date date) {
		Reservation res = null;
		ResultSet resRequete;
		String heure_debut = creneau.getHeureDebut().getNbHeure() + "h" + creneau.getHeureDebut().getNbMinutes();
  		String heure_fin = creneau.getHeureFin().getNbHeure() + "h" + creneau.getHeureFin().getNbMinutes();
  		int id_creneau = 0;
		
  		/* verification du creneau */
  		
  		if(creneau.getHeureDebut().getNbMinutes() == 0) {
  			
  			heure_debut = heure_debut + "0";
  		}
  		
  		if(creneau.getHeureFin().getNbMinutes() == 0) {
  			
  			heure_fin = heure_fin + "0";
  		}
  		
  		/* recuperation de l'id du creneau */
  		
  		resRequete = GestionnaireBD.getInstance().executeRequete("select id_creneau from crenaux where heure_debut = '" + heure_debut + "' and heure_fin = '" + heure_fin +"'");
  		try {
  			resRequete.next();
			id_creneau = Integer.parseInt(resRequete.getString("ID_CRENEAU"));
		} catch (NumberFormatException exc) {

			exc.printStackTrace();
		} catch (SQLException exc) {

			exc.printStackTrace();
		}
		GestionnaireBD.getInstance().closeStatement();
		
		resRequete = GestionnaireBD.getInstance().executeRequete("select Res.RefR.id_reservation, deref(Res.RefR.creneau).heure_debut, deref(Res.RefR.creneau).heure_fin, deref(Res.RefR.enseignement).nb_heure_prevue, deref(deref(deref(Res.RefR.enseignement).cours).matiere).libelle_matiere,deref(deref(deref(Res.RefR.enseignement).cours).type_cours).libelle_type_cours, deref(deref(Res.RefR.enseignement).groupe).libelle_groupe,Res.RefR.dateRes, deref(Res.Refr.salle).numero_salle from table(select E.liste_Reservations from VEnseignant E where nom = '" + e.getNom() + "' AND prenom = '" + e.getPrenom() + "') Res where Res.RefR.salle is NOT NULL AND deref(Res.RefR.creneau).id_creneau = " + id_creneau + "AND Res.RefR.dateRes = to_date('" +  new java.sql.Date(date.getTime()).toString() + "', 'yy-mm-dd')");
		int nbHeures;
		String typeCours, libMatiere, libGroupe, salle;
		
		if(resRequete != null) {
			
			try {
				while(resRequete.next()) {
					
					/* Enseignement lié a la seance */
					Enseignement ens;
					nbHeures = Integer.parseInt(resRequete.getString(4).trim());
					libMatiere = resRequete.getString(5).trim();
					typeCours = resRequete.getString(6).trim();
					libGroupe = resRequete.getString(7).trim();
					ens = new Enseignement(nbHeures, typeCours, libMatiere, new Groupe(libGroupe), e);
					
					
					/* Salle */
					salle = resRequete.getString(9).trim();
					res = (new Seance(creneau, date, ens, null, new Salle(salle)));
					
					
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		GestionnaireBD.getInstance().closeStatement();
		return res;
	}
	
	/**
	 * retourne le planning d'un groupe donn�e en param�tre sous forme de liste de r�servations
	 * @param groupe un groupe
	 * @return la liste des r�servations pour un groupe
	 */
	public ArrayList<Reservation> getPlanning(Groupe groupe) {
		
		ArrayList<Reservation> res = new ArrayList<Reservation>();
		ResultSet resRequete;
		ResultSet resRequete2;
		resRequete = GestionnaireBD.getInstance().executeRequete("select Res.id_reservation, deref(Res.creneau).heure_debut, deref(Res.creneau).heure_fin, deref(Res.enseignement).nb_heure_prevue, deref(deref(deref(Res.enseignement).cours).matiere).libelle_matiere,deref(deref(deref(Res.enseignement).cours).type_cours).libelle_type_cours, deref(deref(Res.enseignement).groupe).libelle_groupe,Res.dateRes, deref(Res.salle).numero_salle from VReservation Res where Res.salle is NOT NULL AND  deref(Res.RefR.salle).numero_salle <> 'REFUS' and deref(deref(Res.enseignement).groupe).libelle_groupe = '" + groupe.getLibelleGroupe() +"'");
		int nbHeures, id_reservation;
		String typeCours, libMatiere, libGroupe, salle, nomEns, prenomEns;
		boolean supUser;
		
		if(resRequete != null) {
			
			try {
				while(resRequete.next()) {
					
					/* id reservation */
					id_reservation = Integer.parseInt(resRequete.getString(1));
					/* Enseignement lié a la seance */
					Enseignement ens = null;
					nbHeures = Integer.parseInt(resRequete.getString(4).trim());
					libMatiere = resRequete.getString(5).trim();
					typeCours = resRequete.getString(6).trim();
					libGroupe = resRequete.getString(7).trim();
					
					/* Enseignant de l'enseignement */
					resRequete2 = GestionnaireBD.getInstance().executeRequete("select e.nom, e.prenom, e.super_user from enseignant e, reservation r, enseignement ens where r.id_reservation = " + id_reservation + " and r.id_enseignement = ens.id_enseignement and ens.id_enseignant = e.id_enseignant" );
					if(resRequete2.next()) {
						nomEns = resRequete2.getString(1);
						prenomEns = resRequete2.getString(2);
					
						if(resRequete2.getString(3).equals("1")) {
						
							supUser = true;
						}
						else {
						
							supUser = false;
						}
						
						ens = new Enseignement(nbHeures, typeCours, libMatiere, new Groupe(libGroupe), new Enseignant(nomEns, prenomEns, supUser));
					}
					
					
					
					/* Creneau */
					Creneau c;
					String heureDeb = resRequete.getString(2);
					String heureF = resRequete.getString(3);

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
					
					c = new Creneau(heureDebut, heureFin);
					
					/* Date */
					
					Date date = resRequete.getDate(8);
					
					/* Salle */
					
					salle = resRequete.getString(9).trim();
					if(ens != null) {
						res.add(new Seance(c, date, ens, null, new Salle(salle)));
					}
					
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		Collections.sort(res);
		GestionnaireBD.getInstance().closeStatement();
		return res;
	}

	@Override
	/**
	 * charge les r�servations en fonction des param�tres donn�es
	 * @param enseignement
	 * @param creneau
	 * @param date
	 * @return la liste des s�ances 
	 */
	public ArrayList<Reservation> chargerReservations(Enseignement enseignement,Creneau creneau, Date date,Enseignant enseignant) {
		ArrayList<Reservation> Listereservations=new ArrayList<Reservation>();
		ResultSet resRequete;
		int cpt=0;
		
		String requete="" +
				"SELECT deref(Res.RefR.creneau).heure_debut," +
				"deref(Res.RefR.creneau).heure_fin, " +
				"deref(Res.RefR.enseignement).nb_heure_prevue," +
				"deref(deref(deref(Res.RefR.enseignement).cours).matiere).libelle_matiere," +
				"deref(deref(deref(Res.RefR.enseignement).cours).type_cours).libelle_type_cours," +
				"deref(deref(Res.RefR.enseignement).groupe).libelle_groupe," +
				"Res.RefR.dateRes," +
				"deref(Res.RefR.salle).numero_salle"+
				" FROM table(" +
					"select E.liste_Reservations from VEnseignant E " +
					"where nom = '"+enseignant.getNom()+"' AND prenom = '"+enseignant.getPrenom()+"'" +
					") Res" +
				" WHERE ";
				
		if (enseignement!=null)
		{
				requete+="deref(deref(deref(Res.RefR.enseignement).cours).type_cours).libelle_type_cours='"+enseignement.getTypeCours()+"' " +
						"AND (deref(deref(Res.RefR.enseignement).cours).matiere).libelle_matiere='"+enseignement.getMatiere()+"' " +
						"AND deref(deref(Res.RefR.enseignement).groupe).libelle_groupe='"+enseignement.getGroupe()+"' ";// +
						//"AND deref(Res.enseignement).enseignant="+enseignement.getEnseignant()+" ";
		}
		if(creneau!=null)
		{
				requete+="AND deref(Res.RefR.creneau).heure_fin='"+creneau.getHeureFin()+"' " +
						"AND deref(Res.RefR.creneau).heure_debut='"+creneau.getHeureDebut()+"' ";
		}
		if(date!=null)
		{
				requete+="AND Res.RefR.dateRes=to_date('" + new java.sql.Date(date.getTime()).toString() + "','yy-mm-dd')";//+date.getYear()+"-"+date.getMonth()+"-"+date.getDay()+"' ";
		}
		System.out.println(requete);
		resRequete = GestionnaireBD.getInstance().executeRequete(requete);
		
		try {
			
			while(resRequete.next())
			{
				cpt++;
				
				/* Creneau */
				Creneau c;
				String heureDeb = resRequete.getString(1);
				String heureF = resRequete.getString(2);

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
				
				c = new Creneau(heureDebut, heureFin);
				
				
				/* nombre d'heure prŽvue*/
				
				int nbHeure=Integer.parseInt(resRequete.getString(3).trim());
				
				/* libellŽ mati�re */
				
				String libelleMatiere=resRequete.getString(4).trim();
				
				/* libellŽ type cours */
				
				String libelleTypeCours=resRequete.getString(5).trim();
				
				/* libelle Groupe */
				
				String libelleGroupe=resRequete.getString(6).trim();
				
				/* Date */
				
				Date dateRequete = resRequete.getDate(7);
				
				/* numero de salle */
				String numeroSalle=resRequete.getString(8);
				
				if (numeroSalle!=null)
				{
					numeroSalle=numeroSalle.trim();
				}
				
				Listereservations.add(
						new Seance(
								c,
								dateRequete,
								new Enseignement(
										nbHeure,
										libelleTypeCours,
										libelleMatiere,
										new Groupe(libelleGroupe),
										enseignement.getEnseignant()
										),
								null,
								new Salle(
										numeroSalle
										)
								)
						);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//recupŽration des donnŽes
		if (cpt==0)
		{
			Listereservations=null;
		}
		//recup�ration des donn�es
		
		GestionnaireBD.getInstance().closeStatement();
		return Listereservations;
	}
	
	/**
	 * supprime la r�servation pass�e en param�tre
	 * @param reservation une reservation
	 */
	public void supprimerReservation(Reservation reservation)
	{
		int idReservation=getIdReservation((Seance)reservation);
		if (idReservation!=0)
		{
			String requete ="" +
					"DELETE FROM Reservation " +
					"WHERE id_reservation="+idReservation;
			GestionnaireBD.getInstance().executeRequete(requete);
			GestionnaireBD.getInstance().closeStatement();
		}
	}

	@Override
	/**
	 * attribu une salle donn�e � une r�servation
	 * @param reservation une r�servation
	 * @param salle une salle
	 */
	public int attribuerSalle(Reservation reservation, Salle salle) throws SalleIntrouvableException {
		
		int id_salle = -1, id_creneau = 0, id_reservation = 0;
		ResultSet resRequete;
		int res = 0;
		String heure_debut = reservation.getCreneau().getHeureDebut().getNbHeure() + "h" + reservation.getCreneau().getHeureDebut().getNbMinutes();
  		String heure_fin = reservation.getCreneau().getHeureFin().getNbHeure() + "h" + reservation.getCreneau().getHeureFin().getNbMinutes();
		/* recuperation id_salle */
		
		resRequete = GestionnaireBD.getInstance().executeRequete("select id_salle from salle where numero_salle = '" + salle.getNumSalle() + "'");
		
		try {
			if(resRequete.next()) {
				
				id_salle = Integer.parseInt(resRequete.getString("ID_SALLE"));
			}
		} catch (NumberFormatException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		GestionnaireBD.getInstance().closeStatement();
		
		if(id_salle == -1) {
			
			throw new SalleIntrouvableException();
		}
		
		/* verification du creneau */
  		
  		if(reservation.getCreneau().getHeureDebut().getNbMinutes() == 0) {
  			
  			heure_debut = heure_debut + "0";
  		}
  		
  		if(reservation.getCreneau().getHeureFin().getNbMinutes() == 0) {
  			
  			heure_fin = heure_fin + "0";
  		}
  		
  		/* recuperation de l'id du creneau */
  		
  		resRequete = GestionnaireBD.getInstance().executeRequete("select id_creneau from crenaux where heure_debut = '" + heure_debut + "' and heure_fin = '" + heure_fin +"'");
  		try {
  			resRequete.next();
			id_creneau = Integer.parseInt(resRequete.getString("ID_CRENEAU"));
		} catch (NumberFormatException exc) {

			exc.printStackTrace();
		} catch (SQLException exc) {

			exc.printStackTrace();
		}
		GestionnaireBD.getInstance().closeStatement();
		
		
		
		/* verification disponibilité de la salle */
		
		resRequete = GestionnaireBD.getInstance().executeRequete("select id_reservation from reservation r where id_salle = " + id_salle + " and id_creneau = " + id_creneau + " and date_reservation = to_date('" +  new java.sql.Date(reservation.getDate().getTime()).toString() + "', 'yy-mm-dd')");
		
		try {
			if(resRequete.next()) {
				res = 2;
				return res;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		/* recuperation id_reservation */
		
		id_reservation = this.getIdReservation((Seance)reservation);
		
		if(id_reservation == 0) {
			
			res = 3;
			return res;
		}
		else {
			
			String requete = "update reservation set id_salle = " + id_salle + " where id_reservation = " + id_reservation;
	  		System.out.println(requete);
	  		res = GestionnaireBD.getInstance().executeUpdate( requete );
	  		
	  		
	  		if(res > 0) {
	  			
	  			res = 1;
	  			reservation.setSalle(salle);
	  		}
	  		else{
	  			
	  			res = 0;
	  		}
	  		
			GestionnaireBD.getInstance().closeStatement();
			return res;
		}
	
	}
	
	/** 
	 * Renvoie le nombre d'heure programm�es dans l'emploi du temps pour un enseignement donn�e
	 * @param e un enseignant
	 * @return le nombre d'heure � faire
	 */
	public Heure getNbHeureProgramme(Enseignement e) {
		
		
		ResultSet resRequete = GestionnaireBD.getInstance().executeRequete("select count (deref(Res.RefR.creneau).heure_debut) from table(select E.liste_Reservations from VEnseignant E where nom = '" + (e.getEnseignant()).getNom() + "' AND prenom = '" + (e.getEnseignant()).getPrenom() + "') Res where Res.RefR.Salle is not NULL AND deref(deref(deref(Res.RefR.enseignement).cours).matiere).libelle_matiere = '" + e.getMatiere() + "' AND deref(deref(deref(Res.RefR.enseignement).cours).type_cours).libelle_type_cours = '" + e.getTypeCours() + "' AND deref(deref(Res.RefR.enseignement).groupe).libelle_groupe = '"+ (e.getGroupe()).getLibelleGroupe() +"'");
		int nbCreneaux = 0;
		Heure res;
		int h,m;
		
		
		if(resRequete != null) {
			
			try {
				    resRequete.next();
					nbCreneaux=resRequete.getInt(1);
				}
							
					
				
			catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		GestionnaireBD.getInstance().closeStatement();
		nbCreneaux=nbCreneaux*90;
		h=nbCreneaux/60;
		m=nbCreneaux%60;
		res= new Heure(h,m);
		return res;
		
	}

	
	/** 
	 * Renvoie le nombre d'heures d�j� faites pour un enseignement donn�e
	 * @param e un enseignement
	 * @return le nombre d'heure r�alis�e
	 */
	public Heure getNbHeureFait(Enseignement e) {
		
		
		ResultSet resRequete = GestionnaireBD.getInstance().executeRequete("select count (deref(Res.RefR.creneau).heure_debut) from table(select E.liste_Reservations from VEnseignant E where nom = '" + (e.getEnseignant()).getNom() + "' AND prenom = '" + (e.getEnseignant()).getPrenom() + "') Res where Res.RefR.Salle is not NULL AND deref(deref(deref(Res.RefR.enseignement).cours).matiere).libelle_matiere = '" + e.getMatiere() + "' AND deref(deref(deref(Res.RefR.enseignement).cours).type_cours).libelle_type_cours = '" + e.getTypeCours() + "' AND deref(deref(Res.RefR.enseignement).groupe).libelle_groupe = '"+ (e.getGroupe()).getLibelleGroupe() +"' AND Res.RefR.DATERES < to_date('" + new java.sql.Date((new Date()).getTime()).toString() + "','yy-mm-dd') ");
		int nbCreneaux = 0;
		Heure res;
		int h,m;
		
		
		if(resRequete != null) {
			
			try {
				    resRequete.next();
					nbCreneaux=resRequete.getInt(1);
				}
							
					
				
			catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		GestionnaireBD.getInstance().closeStatement();
		nbCreneaux=nbCreneaux*90;
		h=nbCreneaux/60;
		m=nbCreneaux%60;
		res= new Heure(h,m);
		return res;
		
	}

	/**
	 * retourne l'id d'une r�servation donn�e en param�tre
	 * @param reservation
	 * @return l'id d'une r�servation 
	 */
	private int getIdReservation(Seance reservation) {
		
		int id_groupe = 0, id_enseignement = 0, id_creneau = 0, id_enseignant = 0, id_cours = 0, id_matiere = 0, id_typeCours = 0, id_reservation = 0;
  		String heure_debut = reservation.getCreneau().getHeureDebut().getNbHeure() + "h" + reservation.getCreneau().getHeureDebut().getNbMinutes();
  		String heure_fin = reservation.getCreneau().getHeureFin().getNbHeure() + "h" + reservation.getCreneau().getHeureFin().getNbMinutes();
  		ResultSet resRequete;
  		
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
  		
  		System.out.println("Creneau recherché : " + heure_debut + "-" + heure_fin);
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
		
		/* recuperation id_reservation */
		
		resRequete = GestionnaireBD.getInstance().executeRequete("select id_reservation from reservation where id_creneau = " + id_creneau + " and id_enseignement = " + id_enseignement + " and date_reservation = to_date('" +  new java.sql.Date(reservation.getDate().getTime()).toString() + "', 'yy-mm-dd')");
		
		try {
			if(resRequete.next()) {
				
				id_reservation = Integer.parseInt(resRequete.getString("id_reservation"));
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		GestionnaireBD.getInstance().closeStatement();
		return id_reservation;
	}

	@Override
	/**
	 * retourne la liste des r�servations demand�es par les enseignants donn�es
	 * @param liste des enseignants
	 * @return liste des r�servations
	 */
	public ArrayList<Reservation> getAllDemandes(ArrayList<Enseignant> listeEnseignants) {
		
		ArrayList<Reservation> res = new ArrayList<Reservation>();
		ResultSet resRequete;
		
		System.out.println("getalldemandes"+listeEnseignants.size());
		for(Enseignant e : listeEnseignants) {
			System.out.println("chargement des demandes de " + e.getNom());
			resRequete = GestionnaireBD.getInstance().executeRequete("select Res.RefR.id_reservation, deref(Res.RefR.creneau).heure_debut, deref(Res.RefR.creneau).heure_fin, deref(Res.RefR.enseignement).nb_heure_prevue, deref(deref(deref(Res.RefR.enseignement).cours).matiere).libelle_matiere,deref(deref(deref(Res.RefR.enseignement).cours).type_cours).libelle_type_cours, deref(deref(Res.RefR.enseignement).groupe).libelle_groupe,Res.RefR.dateRes from table(select E.liste_Reservations from VEnseignant E where nom = '" + e.getNom() + "' AND prenom = '" + e.getPrenom() + "') Res where Res.RefR.salle is NULL");
			int nbHeures;
			String typeCours, libMatiere, libGroupe;
			
			if(resRequete != null) {
				
				try {
					while(resRequete.next()) {
						
						/* Enseignement lié a la seance */
						Enseignement ens;
						nbHeures = Integer.parseInt(resRequete.getString(4).trim());
						libMatiere = resRequete.getString(5).trim();
						typeCours = resRequete.getString(6).trim();
						libGroupe = resRequete.getString(7).trim();
						ens = new Enseignement(nbHeures, typeCours, libMatiere, new Groupe(libGroupe), e);
						
						
						/* Creneau */
						Creneau c;
						String heureDeb = resRequete.getString(2);
						String heureF = resRequete.getString(3);
	
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
						
						c = new Creneau(heureDebut, heureFin);
						
						/* Date */
						
						Date date = resRequete.getDate(8);
						
						res.add(new Seance(c, date, ens, null, null));
						
						
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			GestionnaireBD.getInstance().closeStatement();
		}
		
		return res;
	}
}
