package gestionnairesBD;

import logic.AbstractFactory;
import logic.GestionnaireCaracteristiques;
import logic.GestionnaireCreneaux;
import logic.GestionnaireEnseignants;
import logic.GestionnaireEnseignements;
import logic.GestionnaireGroupes;
import logic.GestionnaireNotifications;
import logic.GestionnaireReservations;
import logic.GestionnaireSalle;
import logic.GestionnaireSession;


/**
 * classe qui redéfini les méthodes de la classe Factory
 * elle construit les objets dont on a besoin
 * @author 
 *
 */
public class FactoryBD extends AbstractFactory {

	
	@Override
	/**
	 * créer un nouveau gestionnaire des sessions BD
	 * @return une instance du gestionnaire des sessions
	 */
	public GestionnaireSession creerGestionnaireSession() {
		
		return new GestionnaireSessionBD();
	}
	
	@Override
	/**
	 * crée un nouveau gestionnaire des reservations BD
	 * @return une instance du gestionnaire des réservations
	 */
	public GestionnaireReservations creerGestionnaireReservations() {
	
		return new GestionnaireReservationsBD();
	}
	
	@Override
	/**
	 * crée un nouveau gestionnaire de caractéristiques BD
	 * @return une instance du gestionnaire des caractéristiques
	 */
	public GestionnaireCaracteristiques creerGestionnaireCaracteristiques() {
		
		return new GestionnaireCaracteristiquesBD();
	}
	
	@Override
	/**
	 * crée un nouveau gestionnaire des groupes BD
	 * @return une instance du gestionnaire des groupes
	 */
	public GestionnaireGroupes creerGestionnaireGroupes() {
		
		return new GestionnaireGroupesBD();
	}
	
	@Override
	/**
	 * crée un nouveau gestionnaire des enseignants BD
	 * @return une instance du gestionnaire des enseignants
	 */
	public GestionnaireEnseignants creerGestionnaireEnseignants() {
		
		return new GestionnaireEnseignantsBD();
	}
	
	@Override
	/**
	 * crée un nouveau gestionnaire des enseignements BD
	 * @return une instance du gestionnaire des enseignements
	 */
	public GestionnaireEnseignements creerGestionnaireEnseignements() {
		
		return new GestionnaireEnseignementsBD() ;
	}
	
	@Override
	/**
	 * crée un nouveau gestionnaire des créneaux BD
	 * @return une instance du gestionnaire des créneaux
	 */
	public GestionnaireCreneaux creerGestionnaireCreneaux() {
		
		return new GestionnaireCreneauxBD();
	}
	
	@Override
	/**
	 * crée un nouveau gestionnaire des salles BD
	 * @return une instance du gestionnaire des salles
	 */
	public GestionnaireSalle creerGestionnaireSalle() {
		
		return new GestionnaireSalleBD();
	}
	
	/**
	 * crée un nouveau gestionnaire de notifications BD
	 * @return une instance du gestionnaire des notifications
	 */
	public GestionnaireNotifications creerGestionnaireNotifications() {
		
		return new GestionnaireNotificationsBD();
	}

}