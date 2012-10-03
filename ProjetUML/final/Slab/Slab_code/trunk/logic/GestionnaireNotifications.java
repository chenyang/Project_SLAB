package logic;

import java.util.ArrayList;

public abstract class GestionnaireNotifications {
	
	//field
		private ArrayList<Notification>  myNotifications;
		
	//Construct
	
	public GestionnaireNotifications() {
		  
		  this.myNotifications = new ArrayList<Notification>();
	  }
	
	

	/** charge dans la BD les notifications d'un enseignant  */
	  public abstract void chargerNotifications(Enseignant e);
	  
	  
	  /**
	    enregistre une notification de demande pour les responsables */
	  public abstract void enregistrerNotificationDemande(Reservation r);
	  
	  /** enregistre une notification de réponse pour les enseignants */
	  public abstract void enregistrerNotificationReponse(Reservation r);
	  
	  /** enregistre une notification devsuppression d'une reservation pour les responsables */
	  public abstract void enregistrerNotificationAnnulation(Reservation r);
	  
	  /** supprime toutes les notifications en cours pour un enseignant */
	  public abstract void supprimerNotifications(Enseignant e);

     //access
	  /**
	   * 
	   * @return la liste des notifications
	   */
	  public ArrayList<Notification> getNotifications() {
		  
		  return this.myNotifications;
	  }
	  
	  /**
	   * ajoute une notification ˆ la liste des notifications
	   * @param n une notification
	   */
	  public void ajouterNotification(Notification n) {
		  
		  this.myNotifications.add(n);
	  }
	  
	  /**
	   * vide la liste des notifications
	   */
	  public void viderNotifications() {
		  this.myNotifications.clear();
	  }
	  
	  

}
