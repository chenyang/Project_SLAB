package logic;

import java.util.ArrayList;



public abstract class GestionnaireEnseignants {

    private  ArrayList<Enseignant> myEnseignants;
    
    /**
     * constructeur de la classe
     */
    public GestionnaireEnseignants() {
    	
    	this.myEnseignants = new ArrayList<Enseignant>();
    }

    /**
	 * permet de charger tous les enseignements de la base de donnes dans la liste des enseignements correspondant ˆ l'enseignant en paramtre
	 * @param e l'enseignant qui utilise le logiciel
	 */
  public abstract void chargerEnseignants(Enseignant e);
  
  /**
   * ajoute l'enseignant en paramtre ˆ la liste des enseignants
   * @param e
   */
  protected void ajouterEnseignant(Enseignant e) {
	  this.myEnseignants.add(e);
  }
  
  /**
   * 
   * @return la liste des enseignants
   */
  public ArrayList<Enseignant> getEnseignants() {
	  
	  System.out.println("!!"+myEnseignants.size());
	  return this.myEnseignants;
  }

}