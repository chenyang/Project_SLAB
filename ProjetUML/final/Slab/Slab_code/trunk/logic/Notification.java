package logic;

/**
 * classe pour la gestion des notifications
 * @author 
 *
 */
public class Notification {
	
	//fields
	
	private String message;
    private Enseignant enseignant;
    
    /**
     * 
     * @return le message
     */
	public String getMessage() {
		return message;
	}
	
	/**
	 * modifie le message avec le message en paramtre
	 * @param message
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	/**
	 * 
	 * @return l'enseignant
	 */
	public Enseignant getEnseignant() {
		return enseignant;
	}
	
	/**
	 * modifie l'enseignant avec l'enseignant en paramtre
	 * @param enseignant
	 */
	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}
	
	/**
	 * constructeur de la classe
	 */
	public Notification(String message, Enseignant enseignant) {
		super();
		this.message = message;
		this.enseignant = enseignant;
	}
	
	/**
	 * @return affichage des notifications
	 */
	public String toString() {
		
		return this.message;
	}
    
	
    

}
