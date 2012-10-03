package logic;

/**
 * Cette classe repr�sente une factory abstraite.
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
	 * Cr�e un nouveau gestionnaire de session.
	 * @return Le Gestionnaire de session cr�e.
	 */
	public abstract GestionnaireSession creerGestionnaireSession();
	
	
	/**
	 * Cr�e un nouveau gestionnaire de r�servations.
	 * @return Le Gestionnaire de r�servations cr�e.
	 */
	public abstract GestionnaireReservations creerGestionnaireReservations();

	/**
	 * Cr�e un nouveau gestionnaire de caracteristiques.
	 * @return Le Gestionnaire de caracteristiques cr�e.
	 */
	public abstract GestionnaireCaracteristiques creerGestionnaireCaracteristiques();

	/**
	 * Cr�e un nouveau gestionnaire de groupes.
	 * @return Le Gestionnaire de groupe cr�e.
	 */
	public abstract GestionnaireGroupes creerGestionnaireGroupes();

	/**
	 * Cr�e un nouveau gestionnaire d'enseignants.
	 * @return Le Gestionnaire d'enseignants cr�e.
	 */
	public abstract GestionnaireEnseignants creerGestionnaireEnseignants();

	/**
	 * Cr�e un nouveau gestionnaire d'enseignements.
	 * @return Le Gestionnaire d'enseignements cr�e.
	 */
	public abstract GestionnaireEnseignements creerGestionnaireEnseignements();
	
	/**
	 * Cr�e un nouveau gestionnaire de creneaux.
	 * @return Le Gestionnaire de creneaux cr�e.
	 */
	public abstract GestionnaireCreneaux creerGestionnaireCreneaux();
	
	/**
	 * Cr�e un nouveau gestionnaire de salles.
	 * @return Le Gestionnaire de salles cr�e.
	 */
	public abstract GestionnaireSalle creerGestionnaireSalle();
	
	/**
	 * Cr�e un nouveau gestionnaire de notifications.
	 * @return Le gestionnaire de notifications cr�e.
	 */
	
	public abstract GestionnaireNotifications creerGestionnaireNotifications();
}