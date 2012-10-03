package logic;

/**
 * Cette classe représente une caractéristique pour une salle.
 * @author Anthony
 *
 */

public class Caracteristique {

	/**
	 * Le libellé associé ˆ la caractéristique.
	 */
    private String libelle;
    
    /**
     * Constructeur par défaut.
     */
    public Caracteristique() {
    	
    }
    
    /**
     * Constructeur paramétré.
     * @param lib Le libellé associé à la caractéristique.
     */
    public Caracteristique(String lib) {
    	
    	this.libelle = lib;
    }
    
    /**
     * Accesseur du libellé de la caractéristique.
     * @return Le libellé associé à la caractéristique.
     */

	public String getLibelle() {
		return libelle;
	}

	/**
	 * Modifieur du libellé.
	 * @param libelle Le libellé à attribuer à la caractéristique.
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * Vérifie que le libellé donné est égal à celui de la caractéritique.
	 * @param lib Le libellé à comparer.
	 * @return Vrai si le libellé est égal, faux sinon.
	 */
	public boolean estEgal(String lib) {
		
		return (this.libelle.equals(lib));
	}

	/**
	 * Compare deux caractéristiques.
	 * @param caracteristique La caractéristique à comparer.
	 * @return Vrai si les deux caractéristiques sont égales, faux sinon.
	 */
	public boolean estEgal(Caracteristique caracteristique) {
		
		return (this.libelle.equals(caracteristique.libelle));
	}
	
	/**
	 * Renvoie la caractéritique sous forme de chaine de caractères.
	 */
	public String toString() {
		
		return this.libelle;
	}
    
}