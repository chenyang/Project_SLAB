package logic;

import java.util.ArrayList;
import java.util.Date;

import exceptionsEDT.CaracteristiqueIntrouvableException;
import exceptionsEDT.CreneauIntrouvableException;
import exceptionsEDT.DateIncorrecteException;
import exceptionsEDT.EnseignementIntrouvableException;
import exceptionsEDT.SalleIntrouvableException;

/**
 * Cette classe repr閟ente le superviseur des gestionnaire de la bussiness logic,
 * elle seule connait tous les gestionnaires et supervise leurs taches
 * @author Anthony
 *
 */

public class SuperGestionnaire {
	
	private GestionnaireReservations  myGestionnaireReservations;
    private GestionnaireSession  myGestionnaireSession;
    private GestionnaireGroupes  myGestionnaireGroupes;
    private GestionnaireCaracteristiques  myGestionnaireCaracteristiques;
    private GestionnaireEnseignements  myGestionnaireEnseignements;
    private GestionnaireCreneaux  myGestionnaireCreneaux;
    private GestionnaireEnseignants myGestionnaireEnseignants;
    private GestionnaireSalle myGestionnaireSalle;
    private GestionnaireNotifications myGestionnaireNotifications;
    
    /**
     * constructeur de la classe
     */
    public SuperGestionnaire() {
    	
    	try {
        	
    		myGestionnaireReservations = AbstractFactory.getInstance().creerGestionnaireReservations();
    		myGestionnaireSession = AbstractFactory.getInstance().creerGestionnaireSession();
    		myGestionnaireGroupes = AbstractFactory.getInstance().creerGestionnaireGroupes();
    		myGestionnaireCaracteristiques = AbstractFactory.getInstance().creerGestionnaireCaracteristiques();
    		myGestionnaireEnseignements = AbstractFactory.getInstance().creerGestionnaireEnseignements();
    		myGestionnaireCreneaux = AbstractFactory.getInstance().creerGestionnaireCreneaux();
    		myGestionnaireEnseignants = AbstractFactory.getInstance().creerGestionnaireEnseignants();
    		myGestionnaireSalle = AbstractFactory.getInstance().creerGestionnaireSalle();
    		myGestionnaireNotifications = AbstractFactory.getInstance().creerGestionnaireNotifications();
    	
    	}
    	catch(java.lang.NullPointerException e) {
    		
    		System.out.println("Problème interne");
    		e.printStackTrace();
    	}
    }

    /**
     * Demande la connexion d'une personne au gestionnaire de session.
     * @param login login de la personne �authentifier.
     * @param mdp Mot de passe de la personne.
     * @return Renvoie un entier indiquant le type de la personne connect閑 : 1 responsable, 2 enseignant, 0 erreur.
     */
	public int connexion(String login, String mdp) {
		
		int res;
    	Enseignant ens = myGestionnaireSession.authentifier(login, mdp);
    	
    	if(ens != null) {
    		// Chargements des informations permanentes
    		System.out.println("charger carac");
    		this.myGestionnaireCaracteristiques.chargerCaracteristiques();
    		System.out.println("charger creneaux");
    		this.myGestionnaireCreneaux.chargerCreneaux();
    		System.out.println("charger enseignements");
    		this.myGestionnaireEnseignements.chargerEnseignements(ens);
    		System.out.println("charger groupes");
    		this.myGestionnaireGroupes.chargerGroupes(ens);
    		System.out.println("charger notifd");
    		this.myGestionnaireNotifications.chargerNotifications(ens);
    	
    		if(ens.estResponsable()) {
    			
    			res = 1;
    			System.out.println("charger enseignant");
    			this.myGestionnaireEnseignants.chargerEnseignants(ens);
    			System.out.println("Je suis responable");
    		}
    		else {
    			
    			res = 2;
    		}
    	}
    	else {
    		
    		res = 0;
    	}
    	
    	return res;
	}
	
	/**
	 * Demande au gestionnaire de r�servation d'enrigistrer une s閍nce.
	 * @param creneau Le cr閚eau souhait�
	 * @param date La date souhait閑
	 * @param enseignement L'enseignement correspondant �la demande
	 * @param caracteristiques Les caract閞istiques souhait閑s
	 * @return Un code de retour indiquant si la r閟ervation s'est bien d閞oul閑 : 0 probl鑝e d'enregistrement, 1 pas de salle disponible, 2 groupe d'閠udiant indisponible, 3 nombre d'heures d閜ass閑s, 4 succ鑣
	 * @throws CaracteristiqueIntrouvableException Exception renvoy閑 si les caract閞istiques n'existent pas
	 * @throws EnseignementIntrouvableException Exception renvoy閑 si l'enseignement n'existe pas
	 * @throws CreneauIntrouvableException Exception renvoy閑 si le cr閚eau n'existe pas
	 * @throws DateIncorrecteException 
	 */

	public int demanderSeance(Creneau creneau, Date date,
			Enseignement enseignement,
			ArrayList<Caracteristique> caracteristiques) throws CaracteristiqueIntrouvableException, EnseignementIntrouvableException, CreneauIntrouvableException, DateIncorrecteException {
		
		int res = 0;
		
		if(!this.myGestionnaireCreneaux.existeCreneau(creneau)) {
			
			throw new CreneauIntrouvableException();
		}
		else if(!this.myGestionnaireEnseignements.existeEnseignement(enseignement)) {
			
			throw new EnseignementIntrouvableException();
		}
		else if (!this.myGestionnaireCaracteristiques.existeCaracterisques(caracteristiques)) {
			
			throw new CaracteristiqueIntrouvableException();
		}
		// Si la date est anterieure à la date d'aujourd'hui ou si c'est un dimanche ou un samedi
		else if (date.compareTo(new Date()) < 0 || date.getDay() == 6 || date.getDay() == 0) {
			
			throw new DateIncorrecteException();
		}
		else {
			Seance seance = new Seance(creneau, date, enseignement, caracteristiques, null);
			res = this.myGestionnaireReservations.enregistrerSeance(seance);
			
			if(res == 4) {
				this.myGestionnaireNotifications.enregistrerNotificationDemande(seance);
			}
		}
		
		return res;
	}

	/**
	 * 
	 * @return toutes les caract�ristiques
	 */
	public ArrayList<Caracteristique> getCaracteristiques() {
		
		return this.myGestionnaireCaracteristiques.getCaracteristiques();
	}

	/**
	 * 
	 * @return tous les cr�neaux
	 */
	public ArrayList<Creneau> getCreneaux() {
		return this.myGestionnaireCreneaux.getCreneaux();
	}

	/**
	 * 
	 * @param reservation
	 * @return les salles disponibles pour une r�servation
	 */
	public ArrayList<Salle> getSallesDisponibles(Seance reservation) {
		return this.myGestionnaireSalle.getSallesDisponible(reservation);
	}

	/**
	 * 
	 * @return les enseignements d'un enseignant
	 */
	public ArrayList<Enseignement> getEnseignements() {
		
		return this.myGestionnaireEnseignements.getEnseignements();
	}

	/**
	 * 
	 * @return les demandes de r�servation d'un enseignant
	 */
	public ArrayList<Reservation> getDemandes() {
		
		Enseignant e = this.myGestionnaireSession.getEnseignant();
		ArrayList<Reservation> res = null;
		
		if(e != null) {
			
			res = this.myGestionnaireReservations.getDemandes(e);
		}
		
		return res;
	}

	/**
	 * 
	 * @return toutes les reservations
	 */
	public ArrayList<Reservation> getPlanning() {

		Enseignant e = this.myGestionnaireSession.getEnseignant();
		ArrayList<Reservation> res = null;
		
		if(e != null) {
			
			res = this.myGestionnaireReservations.getPlanning(e);
		}
		
		return res;
	}

	/**
	 * 
	 * @param creneau
	 * @param date
	 * @return les reservations pour un creneau et une date
	 * @throws CreneauIntrouvableException
	 */
	public Reservation getPlanning(Creneau creneau, Date date) throws CreneauIntrouvableException {
		
		if(!this.myGestionnaireCreneaux.existeCreneau(creneau)) {
			
			throw new CreneauIntrouvableException();
		}
		
		return this.myGestionnaireReservations.getPlanning(this.myGestionnaireSession.getEnseignant(), creneau, date);
	}

	/**
	 * 
	 * @param groupe
	 * @return les reservations pour un groupe
	 */
	public ArrayList<Reservation> getPlanning(Groupe groupe) {
		return this.myGestionnaireReservations.getPlanning(groupe);
	}
	/**
     * Attribue une salle à la reservation donnée
     * @param reservation
     * @param salle
     * @return Renvoie 1 en cas de succès, 2 si la salle n'est pas disponible.
	 * @throws SalleIntrouvableException 
     */
	public int attribuerSalle(Reservation reservation, Salle salle) throws SalleIntrouvableException {
		
		int res = this.myGestionnaireReservations.attribuerSalle(reservation, salle);
		
		if(res == 1) {
			
			this.myGestionnaireNotifications.enregistrerNotificationReponse(reservation);
		}
		
		return res;
	}

	/**
	 * 
	 * @param e
	 * @return le nombre d'heure programm�e pour l'enseignant
	 * @throws EnseignementIntrouvableException
	 */
	public Heure getNbHeureProgramme(Enseignement e) throws EnseignementIntrouvableException {
		
		if (!myGestionnaireEnseignements.existeEnseignement(e))
		{
			throw new EnseignementIntrouvableException();
		}
		return this.myGestionnaireReservations.getNbHeureProgramme(e);
	}

	/**
	 * 
	 * @param enseignement
	 * @param creneau
	 * @param date
	 * @return les reservations pour un enseignement, un cr�neau et/ou une date
	 */
	public ArrayList<Reservation> chargerReservations(Enseignement enseignement,Creneau creneau, Date date) {
	
		return this.myGestionnaireReservations.chargerReservations(enseignement,creneau, date,myGestionnaireSession.getEnseignant());
	}

	/**
	 * 
	 * @param e
	 * @return le nombre d'heure faite par l'enseignant
	 * @throws EnseignementIntrouvableException
	 */
	public Heure getNbHeureFait(Enseignement e) throws EnseignementIntrouvableException {
		if (!myGestionnaireEnseignements.existeEnseignement(e))
		{
			throw new EnseignementIntrouvableException();
		}
		return this.myGestionnaireReservations.getNbHeureFait(e);
	}

	/**
	 * 
	 * @return la liste des groupes
	 */
	public ArrayList<Groupe> getGroupes() {
		
		return this.myGestionnaireGroupes.getGroupes();
	}
	
	/**
	 * supprime une r�servation donn�e
	 * @param reservation
	 */
	 public void supprimerReservation(Reservation reservation)
	 {
		 this.myGestionnaireReservations.supprimerReservation(reservation);
	 }
	 
	 /**
	  * 
	  * @return toutes les notifications
	  */
	 public ArrayList<Notification> getNotifications() {
		 return this.myGestionnaireNotifications.getNotifications();
	 }

	 /**
	  * 
	  * @return toutes les demandes de r�servation
	  */
	public ArrayList<Reservation> getAllDemandes() {
		
		System.out.println("nb denseignants " + this.myGestionnaireEnseignants.getEnseignants().size());
		return this.myGestionnaireReservations.getAllDemandes(this.myGestionnaireEnseignants.getEnseignants());
	}

	/**
	 * supprimer les notifications
	 */
	public void supprimerNotifications() {
		
		this.myGestionnaireNotifications.supprimerNotifications(this.myGestionnaireSession.getEnseignant());
	}
}
