package logic;

import java.util.ArrayList;



public abstract class GestionnaireCreneaux {

    private ArrayList<Creneau>  myCreneaux;

    /**
     * 
     */
  public abstract void chargerCreneaux();
  
  /**
   * constructeur de la classe
   */
  public GestionnaireCreneaux() {
	  
	  this.myCreneaux = new ArrayList<Creneau>();
  }

  /**
   * 
   * @return la liste des crneaux
   */
  public ArrayList<Creneau> getCreneaux() {
	  
	  return this.myCreneaux;
  }
  
  /**
   * 
   * @param creneau
   * @return true si le creneau existe dans la liste des crneau, false sinon
   */
  public boolean existeCreneau(Creneau creneau) {
	boolean res = false;
	
	for(Creneau c : this.myCreneaux) {
		if(c.estEgal(creneau)) {
			
			res = true;
		}
	}
	
	return res;
}
  /**
   * ajoute un crneau ˆ la liste des crneaux
   * @param c
   */
  protected void ajouterCreneau(Creneau c) {
	  
	  this.myCreneaux.add(c);
  }

}