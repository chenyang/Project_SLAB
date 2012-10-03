package logic;

import java.util.ArrayList;
import java.util.Date;

import exceptionsEDT.CaracteristiqueIntrouvableException;
import exceptionsEDT.CreneauIntrouvableException;
import exceptionsEDT.DateIncorrecteException;
import exceptionsEDT.EnseignementIntrouvableException;
import exceptionsEDT.SalleIntrouvableException;

/**
 * Cette classe sert de point d'entrée pour une une interface utilisateur. 
 * @author Anthony
 *
 */

public class Facade {
	
	/**
	 * Le superGestionnaire en charge de tous les gestionnaires.
	 */
	private SuperGestionnaire mySuperGestionnaire;


    /**
     * Constructeur par défaut.
     */
    public Facade() {
    	
    	this.mySuperGestionnaire = new SuperGestionnaire();
    	
    }
    
    /**
     * Demande la connexion d'un enseignant au système.
     * @param login le login de l'enseignant souhaitant se connecter
     * @param mdp le mot de passe de connection
     * @return 0 en cas d'echec, 1 si l'enseignant est aussi responsable et 2 sinon.
     */
    public int connexion(String login,String  mdp) {
    	
    	return this.mySuperGestionnaire.connexion(login, mdp);
    	
	}
    
    /**
     * Demande une réservation de séance au système.
     * @return renvoie 1 en cas de succçŒ«s sinon 0.
     * @throws CaracteristiqueIntrouvableException Les caractéristiques fournit n'existent pas dans les données persistantes.
     * @throws CreneauIntrouvableException Le créneau donné n'existe pas dans les données persistantes.
     * @throws EnseignementIntrouvableException  L'enseignement donné n'existe pas dans les données persistantes.
     * @throws DateIncorrecteException La date donnée n'est pas correcte.
     */
    
    public int demanderSeance(Creneau creneau, Date date, Enseignement enseignement, ArrayList<Caracteristique> caracteristiques ) throws CaracteristiqueIntrouvableException, EnseignementIntrouvableException, CreneauIntrouvableException, DateIncorrecteException {
    	
    	return this.mySuperGestionnaire.demanderSeance(creneau, date, enseignement, caracteristiques);
    }
   
    /**
     * Donne les caractéristiques des salles stockées en mémoire persistante.
     * @return les caractéristiques des salles stockées en mémoire persistante
     */
    public ArrayList<Caracteristique> getCaracteristiques() {
    	
    	return this.mySuperGestionnaire.getCaracteristiques();
    }
    
    /**
     * Donne les créneaux stockés en mémoire persistante
     * @return les créneaux stockés en mémoire persistante
     */
    public ArrayList<Creneau> getCreneaux() {
    	
    	return this.mySuperGestionnaire.getCreneaux();
    }
    
    /**
     * Donne toutes les salles disponibles pour la réservation donnée.
     * @param reservation La réservation.
     * @return Une liste des salles disponibles.
     */
    public ArrayList<Salle> getSallesDisponibles(Seance reservation)
    {
    	return this.mySuperGestionnaire.getSallesDisponibles(reservation);
    }
    
    /**
     * Donne les enseignements correspondant à l'enseignant enregistré dans la session
     * @return les enseignements correspondant à l'enseignant enregistré dans la session
     */
    public ArrayList<Enseignement> getEnseignements()
    {
    	return this.mySuperGestionnaire.getEnseignements();
    }
    
    /**
     * Renvoie les demandes en cours de l'enseignant logué
     * @return les demandes en cours de l'enseignant logué
     */
    public ArrayList<Reservation> getDemandes() {
    	
    	return this.mySuperGestionnaire.getDemandes();
    }
    
    /**
     * Renvoie toutes les demandes stockées en mémoire persistance.
     * @return toutes les demandes stockées en mémoire persistance.
     */
    public ArrayList<Reservation> getAllDemandes() {
    	
    	return this.mySuperGestionnaire.getAllDemandes();
    }
    
    
    /**
     * Renvoie le planning de l'enseignant logué.
     * @return le planning de l'enseignant logué.
     */
     public ArrayList<Reservation> getPlanning() {
    	 return this.mySuperGestionnaire.getPlanning();
     }
     
     /**
      * @param c
      * @param d
      * @return les rŽservations pour un crŽneau et une date donnŽe
      * @throws CreneauIntrouvableException
      */
     public Reservation getPlanning(Creneau c, Date d) throws CreneauIntrouvableException {
    	 
    	 return this.mySuperGestionnaire.getPlanning(c,d);
     }

     /**
      * Renvoie le planning du groupe donné.
      * @param groupe Le groupe.
      * @return La liste des réservations associées au groupe.
      */
     public ArrayList<Reservation> getPlanning(Groupe groupe) {
    	 
    	 return this.mySuperGestionnaire.getPlanning(groupe);
     }
     
     /**
      * Charge les réservations associées à l'enseignement, au créneau et à la date donnée.
      * @param enseignement L'enseignement.
      * @param creneau Le créneau.
      * @param date La date.
      * @return Renvoie la liste des réservations correspondantes.
      */
     public ArrayList<Reservation> chargerReservations(Enseignement enseignement,Creneau creneau, Date date)
     {
    	 return this.mySuperGestionnaire.chargerReservations(enseignement, creneau, date);
     }
     
     /**
      * Attribue une salle à la reservation donnée.
      * @param reservation La réservation à laquelle on souhaite attribuer une salle.
      * @param salle La salle à attribuer.
      * @return Renvoie 1 en cas de succès, 2 si la salle n'est pas disponible, 3 si la reservation n'existe pas, 0 si l'ecriture ne fonctionne pas.
     * @throws SalleIntrouvableException SalleIntrouvableException levée si la salle donnée n'existe pas dans les données persistantes
      */
     public int attribuerSalle(Reservation reservation, Salle salle) throws SalleIntrouvableException {
    	 
    	 return this.mySuperGestionnaire.attribuerSalle(reservation, salle);
     }
     
     /**
      * Donne le nombre d'heures programmées pour l'enseignement donné.
      * @param e L'enseignement.
      * @return Le nombre d'heures programmées pour l'enseignement.
      * @throws EnseignementIntrouvableException Si l'enseignement n'existe pas dans les données persistantes.
      */
     public Heure getNbHeureProgramme(Enseignement e) throws EnseignementIntrouvableException{
    	 return this.mySuperGestionnaire.getNbHeureProgramme(e);
     }
     
     /**
      * Donne le nombre d'heures effectuées par l'enseignant pour l'enseignement donné.
      * @param e L'enseignement.
      * @return Le nombre d'heures effectuées.
      * @throws EnseignementIntrouvableException Si l'enseignement n'existe pas dans les données persistantes.
      */
     public Heure getNbHeureFait(Enseignement e) throws EnseignementIntrouvableException{
    	 return this.mySuperGestionnaire.getNbHeureFait(e);
     }
     
     /**
      * Donne la liste des groupes stockée en mémoire persistante.
      * @return La liste des groupes.
      */
     public ArrayList<Groupe> getGroupes() {
    	 
    	 return this.mySuperGestionnaire.getGroupes();
     }
     
     /**
      * Supprime la réservation donnée.
      * @param reservation La réservation à supprimer.
      */
     public void supprimerReservation(Reservation reservation)
     {
    	 this.mySuperGestionnaire.supprimerReservation(reservation);
     }
     
     /**
      * Donne les notifications de l'enseignant logué.
      * @return La liste des notifications de l'enseignant.
      */
     public ArrayList<Notification> getNotifications() {
    	 
    	 return this.mySuperGestionnaire.getNotifications();
     }
     
     public void supprimerNotifications() {
    	 
    	 this.mySuperGestionnaire.supprimerNotifications();
     }

}