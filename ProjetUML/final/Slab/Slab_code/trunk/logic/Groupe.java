package logic;

/**
 * classe de gestion des groupes
 * @author 
 *
 */
public class Groupe {

    private String libelleGroupe;
    private Groupe pere;
    
    /**
	 * constructeur de la classe
	 */
    public Groupe() {
    	
    }
    
    /**
     * constructeur paramétré
     * @param libelleGroupe
     */
    public Groupe(String libelleGroupe) {
    	
    	super();
    	this.libelleGroupe = libelleGroupe;
    	this.pere = null;
    }
    
    /**
     * constructeur paramétré
     * @param libelleGroupe
     * @param pere
     */
	public Groupe(String libelleGroupe, Groupe pere) {
		super();
		this.libelleGroupe = libelleGroupe;
		this.pere = pere;
	}

	/**
	 * 
	 * @return le libellé du groupe
	 */
	public String getLibelleGroupe() {
		return libelleGroupe;
	}
	
	/**
	 * modifie le libellé du groupe
	 * @param libelleGroupe
	 */
	public void setLibelleGroupe(String libelleGroupe) {
		this.libelleGroupe = libelleGroupe;
	}

	/**
	 * 
	 * @return le groupe pere
	 */
	public Groupe getPere() {
		return pere;
	}

	/**
	 * 
	 * @param groupe
	 * @return true si le groupe en paramètre correspond au groupe instancié, false sinon
	 */
	public boolean estEgal(String groupe) {

		return this.libelleGroupe.equals(groupe);
	}
	
	
	/**
	 * 
	 * @param groupe
	 * @return true si le groupe en paramètre correspond au groupe instancié, false sinon
	 */
	public boolean estEgal(Groupe groupe) {
		
		return this.libelleGroupe.equals(groupe.libelleGroupe);
	}
	
	/**
	 * affichage console du groupe
	 */
	public String toString() {
		
		return this.libelleGroupe;
	}
    
    

}