package logic;

/**
 * Cette classe repr�sente un enseignant.
 * @author Anthony
 *
 */

public class Enseignant {

	/**
	 * Le nom de l'enseignant
	 */
  private String nom;
  
  /**
   * Le pr�nom de l'enseignant.
   */
  private String prenom;
  
  /**
   * Le statut de l'enseignant.
   */
  private boolean estResponsable;


  /**
   * Constructeur par d�faut.
   */
  public Enseignant() {
	  
  }
  
  /**
   * Constructeur param�tr�.
   * @param nom Le nom de l'enseignant.
   * @param prenom Le pr�nom de l'enseignant.
   * @param estResponsable Le statut de l'enseignant.
   */
  public Enseignant(String nom, String prenom,  boolean estResponsable) {
	  
	  this.nom = nom;
	  this.prenom = prenom;
	  this.estResponsable = estResponsable;
  }
	
  /**
   * Accesseur pour le nom de l'enseignant.
   * @return Le nom de l'enseignant.
   */
	public String getNom() {
		return nom;
	}
	
	/**
	 * Modifieur pour le nom de l'enseignant.
	 * @param nom Le nom que l'on souhaite attribuer.
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * Accesseur pour le pr�nom de l'enseignant.
	 * @return Le pr�nom de l'enseignant.
	 */
	public String getPrenom() {
		return prenom;
	}
	
	/**
	 * Modifieur pour le pr�nom de l'enseignant.
	 * @param prenom Le pr�nom que l'on souhaite attribuer.
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	/**
	 * Indique si l'enseignant est un responsable.
	 * @return Vrai si l'enseignant est aussi un responsable, faux sinon.
	 */
	public boolean estResponsable() {
		return estResponsable;
	}

	/**
	 * Teste l'�galit� de deux enseignants.
	 * @param e L'enseignant � comparer.
	 * @return Vrai si les deux enseignant sont identiques, faux sinon.
	 */
	public boolean estEgal(Enseignant e) {

		return (this.nom.equals(e.nom) && this.prenom.equals(e.prenom));
	}

}