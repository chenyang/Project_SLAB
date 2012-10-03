package logic;

import java.util.ArrayList;


public abstract class GestionnaireGroupes {

    private ArrayList<Groupe>  myGroupes;
    
    /**
     * constructeur de la salle
     */
    public GestionnaireGroupes() {
    	
    	this.myGroupes = new ArrayList<Groupe>();
    }

    /**
     * Charge les groupes correspondant à l'enseignant stockées dans la données persistantes.
     * @param e L'enseignant concerné.
     */
    public abstract void chargerGroupes(Enseignant e);

	public Groupe getGroupe(String groupe) {
		
		int i;
		Groupe res = null;
		
		for(i = 0; i < this.myGroupes.size(); i++) {
			
			if(this.myGroupes.get(i).estEgal(groupe)) {
				
				res = this.myGroupes.get(i);
			}
		}
		return res;
	}
	
	/**
	 * ajoute un groupe ˆ la liste des groupes
	 * @param g
	 */
	public void ajouterGroupe(Groupe g) {
		
		this.myGroupes.add(g);
	}
	
	/**
	 * 
	 * @return la liste des groupes
	 */
	public ArrayList<Groupe> getGroupes() {
	
		return this.myGroupes;
	}
}