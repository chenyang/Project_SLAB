package logic;

/**
 * Cette classe représente une factory abstraite.
 * @author Anthony
 *
 */


public abstract class AbstractFactory {

	/**
	 * Instance statique du singleton
	 */
	private static AbstractFactory instanceFact; 

	/**
	 * Renvoie l'instance du singleton.
	 * @return L'instance statique de la factory.
	 */
	public static AbstractFactory getInstance() {
		  
		 return instanceFact;
	 }


	/**
	 * Initialise l'instance statique de la factory.
	 * @param fact La factory a affecter au singleton.
	 */
	public static void setInstance(AbstractFactory fact) {
	  
		instanceFact = fact;
	}
  

	/**
	 * Crée un nouveau gestionnaire de session.
	 * @return Le Gestionnaire de session crée.
	 */
	public abstract GestionnaireSession creerGestionnaireSession();
	
	
	/**
	 * Crée un nouveau gestionnaire de réservations.
	 * @return Le Gestionnaire de réservations crée.
	 */
	public abstract GestionnaireReservations creerGestionnaireReservations();

	/**
	 * Crée un nouveau gestionnaire de caracteristiques.
	 * @return Le Gestionnaire de caracteristiques crée.
	 */
	public abstract GestionnaireCaracteristiques creerGestionnaireCaracteristiques();

	/**
	 * Crée un nouveau gestionnaire de groupes.
	 * @return Le Gestionnaire de groupe crée.
	 */
	public abstract GestionnaireGroupes creerGestionnaireGroupes();

	/**
	 * Crée un nouveau gestionnaire d'enseignants.
	 * @return Le Gestionnaire d'enseignants crée.
	 */
	public abstract GestionnaireEnseignants creerGestionnaireEnseignants();

	/**
	 * Crée un nouveau gestionnaire d'enseignements.
	 * @return Le Gestionnaire d'enseignements crée.
	 */
	public abstract GestionnaireEnseignements creerGestionnaireEnseignements();
	
	/**
	 * Crée un nouveau gestionnaire de creneaux.
	 * @return Le Gestionnaire de creneaux crée.
	 */
	public abstract GestionnaireCreneaux creerGestionnaireCreneaux();
	
	/**
	 * Crée un nouveau gestionnaire de salles.
	 * @return Le Gestionnaire de salles crée.
	 */
	public abstract GestionnaireSalle creerGestionnaireSalle();
	
	/**
	 * Crée un nouveau gestionnaire de notifications.
	 * @return Le gestionnaire de notifications crée.
	 */
	
	public abstract GestionnaireNotifications creerGestionnaireNotifications();
}