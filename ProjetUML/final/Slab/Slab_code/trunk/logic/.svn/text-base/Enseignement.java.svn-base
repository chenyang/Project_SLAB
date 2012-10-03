package logic;

/**
 * Cette classe représente un enseignement.
 * @author Anthony
 *
 */

public class Enseignement {

	/**
	 * Le nombre d'heures prévues pour cet enseignement.
	 */
  private int nbHeure;
  
  /**
   * Le type de cours associé à cet enseignement. (TD, Cours, TP)
   */
  private String typeCours;
  
  /**
   * La matière associée à l'enseignement.
   */
  private String matiere;
  
  /**
   * Le groupe d'étudiants associé à l'enseignement.
   */
  private Groupe groupe;
  
  /**
   * L'enseignant qui dispense l'enseignement.
   */
  private Enseignant enseignant;
  
  
  /**
   * Constructeur par défaut.
   */
  public Enseignement() {
	
  }
  
  /**
   * constructeur paramtr
   * @param nbHeure
   * @param typeCours
   * @param matiere
   * @param g
   * @param e
   */
	public Enseignement(int nbHeure, String typeCours, String matiere,Groupe g, Enseignant e) {
		
		this.nbHeure = nbHeure;
		this.typeCours = typeCours;
		this.matiere = matiere;
		this.groupe = g;
		this.enseignant = e;
	}
	
	/**
	 * accesseur du nombre d'heure
	 * @return le nombre d'heure
	 */
	public int getNbHeure() {
		return nbHeure;
	}
	
	/**
	 * @return un affichage console de l'objet
	 */
	public String toString() {
		
		return (/*this.enseignant.getNom() + " " + this.enseignant.getPrenom() + " " +*/this.typeCours + " " + this.matiere + " " + this.groupe.toString());
	}
	
	/**
	 * modificateur de l'attribut nbheure
	 * @param nbHeure
	 */
	public void setNbHeure(int nbHeure) {
		this.nbHeure = nbHeure;
	}
	
	/**
	 * accesseur sur le type de cours
	 * @return le type de cours
	 */
	public String getTypeCours() {
		return typeCours;
	}
	
	/**
	 * accesseur sur le groupe
	 * @return le groupe
	 */
	public Groupe getGroupe() {
		
		return this.groupe;
	}
	
	/**
	 * accesseur sur l'enseignant
	 * @return l'enseignant
	 */
	public Enseignant getEnseignant() {
		
		return this.enseignant;
	}
	
	/**
	 * modifie l'attribu typeCours
	 * @param typeCours
	 */
	public void setTypeCours(String typeCours) {
		this.typeCours = typeCours;
	}
	
	/**
	 * accesseur sur la matire
	 * @return la matire
	 */
	public String getMatiere() {
		return matiere;
	}
	
	/**
	 * modifie l'attribut matire
	 * @param matiere
	 */
	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}

	/**
	 * retourne true si un enseignement dcouper en paramtres est gal ˆ l'enseignement de l'instance, false sinon
	 * @param matiere2
	 * @param g
	 * @param e
	 * @param typeCours
	 * @return true si un enseignement en paramtre est gal ˆ l'enseignement de l'instance, false sinon
	 */
	public boolean estEgal(String matiere2, String g, Enseignant e, String typeCours) {
		
		return (this.matiere.equals(matiere) && this.groupe.estEgal(g) && this.enseignant.estEgal(e) && this.typeCours.equals(typeCours));
	}

	/**
	 * retourne true si un enseignement est gal ˆ l'enseignement de l'instance, false sinon
	 * @param enseignement
	 * @return true si un enseignement est gal ˆ l'enseignement de l'instance, false sinon
	 */
	public boolean estEgal(Enseignement enseignement) {
		
		return (this.matiere.equals(enseignement.matiere) && this.groupe.estEgal(enseignement.groupe) && this.enseignant.estEgal(enseignement.enseignant) && this.typeCours.equals(enseignement.typeCours));
	}




}