package logic;

import java.util.ArrayList;
import java.util.Date;



public abstract class Reservation implements Comparable{

  private ArrayList<Caracteristique> caracteristiques;
  private Salle salle;
  private Creneau creneau;
  private Date date;
  
  /**
   * constructeur de la classe
   */
  public Reservation() {
  }

  /**
   * constructeur paramétré
   * @param creneau
   * @param date
   * @param caracteristiques
   * @param salle
   */
  public Reservation(Creneau creneau, Date date,
		ArrayList<Caracteristique> caracteristiques, Salle salle) {
	
	  this.caracteristiques = caracteristiques;
	  this.date = date;
	  this.creneau = creneau;
	  this.salle = salle;
	
  }
  
  /**
   * 
   * @return la salle de la réservation
   */
  public Salle getSalle() {
	  
	  return this.salle;
  }
  
  /**
   * 
   * @return l'affichage de l'objet
   */
  public String stringPlanning() {
		
		return this.toString();
	}
  
  /**
   * @return l'affichage de l'objet
   */
  public String toString() {
	  
	  String creneauS = this.creneau.toString();
	  String caracS = "";
	  String dateS = this.date.toString();
	  String salle ="";	  
	  if(caracteristiques != null ) {
		  
		  for(Caracteristique car : caracteristiques) {
			  caracS = caracS + " " + car.toString();
		  }
	  }
	  
	  if(this.salle != null) {
		  salle = this.salle.toString();
		  
	  }
	  
	  return dateS + " " + creneauS + " " + caracS + " " + salle + " " + this.getEnseignant().getNom() + " " + this.getEnseignant().getPrenom();
	  
  }
  
  /**
   * 
   * @return la date
   */
  public Date getDate() {
	  
	  return this.date;
  }
  
  /**
   * 
   * @return le créneau
   */
  public Creneau getCreneau() {
	  
	  return this.creneau;
  }
  
  /**
   * @param comp
   * @return 1 si la réservation de l'instance est antèrieure à la réservation en paramètre, -1 pour le contraire et 0 si c'est à la meme date et meme créneau
   */
  public int compareTo(Object comp) {
	  
	  if(this.date.compareTo(((Reservation) comp).getDate()) > 0) {
		  return 1;
		  
		  
	  }
	  else if(this.date.compareTo(((Reservation) comp).getDate()) == 0) {
		  
		  return this.creneau.compareTo( (Creneau)(((Reservation)comp).getCreneau()));
	  }
	  else {
		  
		  return -1;
	  }
	  
  }
  
  /**
   * 
   * @return l'enseignant
   */
  public abstract Enseignant getEnseignant();

  /**
   * modifie la salle avec la salle en paramètre
   * @param salle2
   */
public void setSalle(Salle salle2) {
	
	this.salle = salle2;
	
}

}