package gestionnaireFile;

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



public class FactoryFile extends AbstractFactory {

	
	@Override
	public GestionnaireSession creerGestionnaireSession() {
		
		return new GestionnaireSessionFile();
	}
	
	@Override
	public GestionnaireReservations creerGestionnaireReservations() {
	
		return new GestionnaireReservationsFile();
	}
	
	@Override
	public GestionnaireCaracteristiques creerGestionnaireCaracteristiques() {
		
		return new GestionnaireCaracteristiquesFile();
	}
	
	@Override
	public GestionnaireGroupes creerGestionnaireGroupes() {
		
		return new GestionnaireGroupesFile();
	}
	
	@Override
	public GestionnaireEnseignants creerGestionnaireEnseignants() {
		
		return new GestionnaireEnseignantsFile();
	}
	
	@Override
	public GestionnaireEnseignements creerGestionnaireEnseignements() {
		
		return new GestionnaireEnseignementsFile() ;
	}
	
	@Override
	public GestionnaireCreneaux creerGestionnaireCreneaux() {
		
		return new GestionnaireCreneauxFile();
	}
	
	@Override
	public GestionnaireSalle creerGestionnaireSalle() {
		
		return new GestionnaireSalleFile();
	}
	
	public GestionnaireNotifications creerGestionnaireNotifications() {
		
		return new GestionnaireNotificationsFile();
	}

}

