package logic;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import exceptionsEDT.SalleIntrouvableException;




public abstract class GestionnaireReservations {
  
	/**
  	 * enregistre dans la base de donne la sance 
  	 * @param s la sance ˆ enregistrer
  	 * @return 1 si ca a fonctionn, 0 sinon
  	 */
  public abstract int enregistrerSeance(Seance s);
  
  /**
	 * @return Donne les demandes en cours de l'enseignant donne en parametre.
	 * @param e l'enseignant correspondant ˆ la sance
	 */
  public abstract ArrayList<Reservation> getDemandes(Enseignant e);
  
  /**
	 * @param e un enseignant
	 * @return la liste des rservations de l'enseignant
	 */
  public abstract ArrayList<Reservation> getPlanning(Enseignant e);
  
  /**
   * 
   * @param e L'enseignant
   * @param creneau Le creneau souhaité.
   * @param date La date souhaitée.
   * @return Donne le planning d'un enseignant pour un créneau et une date donnée
   */
  public abstract Reservation getPlanning(Enseignant e, Creneau creneau, Date date);

 
  /**
	 * retourne le planning d'un groupe donne en paramtre sous forme de liste de rservations
	 * @param groupe un groupe
	 * @return la liste des rservations pour un groupe
	 */
  public abstract ArrayList<Reservation> getPlanning(Groupe groupe);

  /**
	 * charge les rservations en fonction des paramtres donnes
	 * @param enseignement
	 * @param creneau
	 * @param date
	 * @return la liste des sances 
	 */
  public abstract ArrayList<Reservation> chargerReservations(Enseignement enseignement,Creneau creneau, Date date, Enseignant enseignant);

  /**
	 * attribu une salle donne ˆ une rservation
	 * @param reservation une rservation
	 * @param salle une salle
	 */
  public abstract int attribuerSalle(Reservation reservation, Salle salle) throws SalleIntrouvableException;
  
  /** 
	 * Renvoie le nombre d'heure programmes dans l'emploi du temps pour un enseignement donne
	 * @param e un enseignant
	 * @return le nombre d'heure ˆ faire
	 */
  public abstract Heure getNbHeureProgramme(Enseignement e);
  
  /** 
	 * Renvoie le nombre d'heures djˆ faites pour un enseignement donne
	 * @param e un enseignement
	 * @return le nombre d'heure ralise
	 */
  public abstract Heure getNbHeureFait(Enseignement e);
  
  /**
	 * supprime la rservation passe en paramtre
	 * @param reservation une reservation
	 */
  public abstract void supprimerReservation(Reservation reservation);

  /**
	 * retourne l'id d'une rservation donne en paramtre
	 * @param listeEnseignants
	 * @return l'id d'une rservation 
	 */
  public abstract ArrayList<Reservation> getAllDemandes(ArrayList<Enseignant> listeEnseignants);

}