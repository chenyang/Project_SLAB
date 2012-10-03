package gestionnairesBD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import logic.Enseignant;
import logic.GestionnaireNotifications;
import logic.Notification;
import logic.Reservation;

/**
 * classe pour la gestion des notifications avec une base de donnée Oracle
 * @author 
 *
 */
public class GestionnaireNotificationsBD extends GestionnaireNotifications{
	
	/**
	 * constructeur de la classe
	 */
	GestionnaireNotificationsBD()
	{
		super();
	}

	/**
	 * permet d'ajouter les notifications d'un enseignant donné de la base de donnée à la liste des notifications
	 * @param e l'enseignant qui utilise le logiciel
	 */
	@Override
	public void chargerNotifications(Enseignant e) {
		
		ResultSet resRequete;
		int id_enseignant = 0;
		String message;
		
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
		
		GestionnaireBD.getInstance().closeStatement();
		
		if(id_enseignant != 0) {
		
			resRequete = GestionnaireBD.getInstance().executeRequete("select * from notification where id_enseignant = " + id_enseignant);
			
			try {
				while(resRequete.next()) {
					
					message = resRequete.getString("message");
					this.ajouterNotification(new Notification( message, e));
					
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		GestionnaireBD.getInstance().closeStatement();
		
		
		
	}
	
	/**
	 * permet d'enregistrer une notification correspondant à une demande d'une réservation dans la base de donnée
	 * @param r la réservation demandée
	 */
	  public void enregistrerNotificationDemande(Reservation r) {
		  
		  String message;
		  int id_notification = 0;
		  ArrayList<Integer> id_enseignant = new ArrayList<Integer>();
		  ResultSet resRequete;
		  
		  // rÈñèuperation de l'id de l'enseignant
		  resRequete = GestionnaireBD.getInstance().executeRequete("select id_enseignant from enseignant where sup_user = 1");
		  
		  try {
				while( resRequete.next()) {
					
					id_enseignant.add( new Integer(resRequete.getString("id_enseignant")));
				}
			} catch (NumberFormatException e1) {
				
				e1.printStackTrace();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
		  
		  GestionnaireBD.getInstance().closeStatement();
		  
		  // calcul id_notif
		  
		  resRequete = GestionnaireBD.getInstance().executeRequete("select max(id_notif) from notification");
		  
		  try {
			if(resRequete.next() && resRequete.getString(1) != null) {
				  
				  id_notification = Integer.parseInt(resRequete.getString(1)) + 1;
			  }
			else {
				
				id_notification = 1;
			}
		} catch (NumberFormatException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		  
		  GestionnaireBD.getInstance().closeStatement();
		  
		  // enregistrement de la notif
		  for(Integer i : id_enseignant) {
			  
		  GestionnaireBD.getInstance().executeUpdate("insert into notification values ( " + id_notification + ", " + i.intValue() + ", 'Vous avez une Nouvelle demande de " + r.getEnseignant().getNom() + " " + r.getEnseignant().getPrenom() + " : " + r.toString().trim() + "')");
	  
		  }
	  }
		  
	  /**
	   * permet d'enregistrer une notification correspondant à une reponse pour la demande d'une réservation dans la base de donnée
	   * @param r la réservation correspondant à la réponse
	   */
	  public void enregistrerNotificationReponse(Reservation r)
	  {
		  
		  String message;
		  int id_enseignant = 0, id_notification = 0;
		  ResultSet resRequete;
		  
		  // rÈñèuperation de l'id de l'enseignant
		  resRequete = GestionnaireBD.getInstance().executeRequete("select id_enseignant from enseignant where nom = '" + r.getEnseignant().getNom() + "' and prenom = '" + r.getEnseignant().getPrenom() + "'");
		  
		  try {
				if(resRequete.next()) {
					
					id_enseignant = Integer.parseInt(resRequete.getString("id_enseignant"));
				}
			} catch (NumberFormatException e1) {
				
				e1.printStackTrace();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
		  
		  GestionnaireBD.getInstance().closeStatement();
		  
		  // calcul id_notif
		  
		  resRequete = GestionnaireBD.getInstance().executeRequete("select max(id_notif) from notification");
		  
		  try {
				if(resRequete.next() && resRequete.getString(1) != null) {
					System.out.println(resRequete.getString(1)+ " " + resRequete);
					  id_notification = Integer.parseInt(resRequete.getString(1)) + 1;
				  }
				else {
					
					id_notification = 1;
				}
			} catch (NumberFormatException e) {
	
				e.printStackTrace();
			} catch (SQLException e) {
	
				e.printStackTrace();
			}
		  
		  GestionnaireBD.getInstance().closeStatement();
		  
		  // enregistrement de la notif
		  
		  if (r.getSalle().getNumSalle().equals("REFUS"))
		  {
			  GestionnaireBD.getInstance().executeUpdate("insert into notification values ( " + id_notification + ", " + id_enseignant + ", 'Votre demande" +  " : " + r.toString().trim() + " a ÔøΩtÔøΩ refusÔøΩe " +"')");
		  }
		  
		  else {
			  GestionnaireBD.getInstance().executeUpdate("insert into notification values ( " + id_notification + ", " + id_enseignant + ", 'Votre demande" +  " : " + r.toString().trim() + " a ÔøΩtÔøΩ acceptÔøΩ " +"')");
		  }
			  
}
	  
	  
	  
	  /**
	   * enregistre les notifications d'annulation de réservation
	   * @param r la réservation correspondant à la réponse
	   */
	  public void enregistrerNotificationAnnulation(Reservation r) 
	  	{
		  
		  String message;
		  int id_notification = 0;
		  ArrayList<Integer> id_enseignant = new ArrayList<Integer>();
		  ResultSet resRequete;
		  
		  // rÈñèuperation de l'id de l'enseignant
		  resRequete = GestionnaireBD.getInstance().executeRequete("select id_enseignant from enseignant where sup_user = 1");
		  
		  try {
				while(resRequete.next()) {
					
					id_enseignant.add( new Integer(resRequete.getString("id_enseignant")));
				}
			} catch (NumberFormatException e1) {
				
				e1.printStackTrace();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
		  
		  GestionnaireBD.getInstance().closeStatement();
		  
		  // calcul id_notif
		  
		  resRequete = GestionnaireBD.getInstance().executeRequete("select max(id_notif) from notification");
		  
		  try {
			if(resRequete.next()) {
				  
				  id_notification = Integer.parseInt(resRequete.getString(1)) + 1;
			  }
			else {
				
				id_notification = 1;
			}
		} catch (NumberFormatException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		  
		  GestionnaireBD.getInstance().closeStatement();
		  
		  // enregistrement de la notif
		  for(Integer i : id_enseignant) {
			  
		  GestionnaireBD.getInstance().executeUpdate("insert into notification values ( " + id_notification + ", " + i.intValue() + ", '" + r.getEnseignant().getNom() + " " + r.getEnseignant().getPrenom() + " a annulÔøΩla rÈñüervation : " + r.toString() + "')");
		  GestionnaireBD.getInstance().closeStatement();
		  }
	  }
	  
	  /**
	   * supprime toutes les notifications d'un enseignant
	   * @param e l'enseignant qui utilise l'application
	   */
	  public void supprimerNotifications(Enseignant e)
	  {
		  int id_enseignant = 0;
		  ResultSet resRequete;
		  
		  // rÈñèuperation de l'id de l'enseignant
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
		  
		  GestionnaireBD.getInstance().closeStatement();
		  
		  GestionnaireBD.getInstance().executeUpdate("delete from notification where id_enseignant = " + id_enseignant);
		  GestionnaireBD.getInstance().closeStatement();
		  this.viderNotifications();
	  }
	  

	
	
	
	
	
	
}
