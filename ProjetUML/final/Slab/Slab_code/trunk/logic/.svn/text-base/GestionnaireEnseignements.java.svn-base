package logic;

import java.util.ArrayList;


public abstract class GestionnaireEnseignements {

    private ArrayList<Enseignement> myEnseignement;
    
    /**
     * constructeur de la classe
     */
    public GestionnaireEnseignements() {
    	
    	this.myEnseignement = new ArrayList<Enseignement>();
    }


    /**
	 * permet de charger tous les enseignements de la base de donnes dans la liste des enseignements correspondant ˆ l'enseignant en paramtre
	 * @param e l'enseignant qui utilise le logiciel
	 */
    public abstract void chargerEnseignements(Enseignant e);


    public Enseignement getEnseignement(String matiere, String g, Enseignant e, String typeCours) {

    	int i;
    	Enseignement res = null;
	
    	for(i = 0; i < this.myEnseignement.size(); i++) {
    		if(this.myEnseignement.get(i).estEgal(matiere, g, e, typeCours)) {
    			res = this.myEnseignement.get(i);
    		}
    	}
	
    	return res;
    }	

    /**
     * 
     * @param enseignement
     * @return true si l'enseignement existe dans la liste des enseignements, false sinon
     */
    public boolean existeEnseignement(Enseignement enseignement) {
	
    	boolean res = false;
	
    	for(Enseignement e : this.myEnseignement) {
		
    		if(e.estEgal(enseignement)) {
			
    			res = true;
    		}
	}
	
    	return res;
    }
    
    /**
     * ajoute un enseignement ˆ la liste des enseignements
     * @param e
     */
    protected void ajouterEnseignement(Enseignement e) {
    	
    	this.myEnseignement.add(e);
    	System.out.println(e.toString());
    }

    /**
     * 
     * @return la liste des enseignements
     */
	public ArrayList<Enseignement> getEnseignements() {

    	return this.myEnseignement;
    }

}