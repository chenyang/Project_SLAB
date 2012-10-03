package logic;

import java.util.ArrayList;

/**
 * classe pour la gestion des caratéristiques
 * @author 
 *
 */
public abstract class GestionnaireCaracteristiques {

    private ArrayList<Caracteristique>  myCaracteristiques;
    
    /**
     * constructeur de classe
     */
    public GestionnaireCaracteristiques() {
    	
    	this.myCaracteristiques = new ArrayList<Caracteristique>();
    }


    /* Methodes abstraites */
    
    /**
     * charge les caractéristiques de la base de donnée
     */
	public abstract void chargerCaracteristiques();


	/* Methodes concrêtes */
	/**
	 * accésseur sur la liste des caractéristiques
	 * @return la liste des caractéristiques
	 */
	public ArrayList<Caracteristique> getCaracteristiques() {
		
		return this.myCaracteristiques;
	}

	/**
	 * retourne true si la liste des caractéristiques donnée en entrée de la méthode existe, false sinon
	 * @param caracteristiques
	 * @return	un booleen
	 */
	public boolean existeCaracterisques(
			ArrayList<Caracteristique> caracteristiques) {
		
		int nbIdentiques = 0;
		
		for(Caracteristique cParam : caracteristiques) {
			
			for(Caracteristique cGestionnaire : this.myCaracteristiques) {
				
				if(cParam.estEgal(cGestionnaire)) {
					nbIdentiques += 1;
				}
			}
		}
		
		return (nbIdentiques == caracteristiques.size());
	}
	
	/**
	 * ajoute une caractéristique à la liste des caractéristiques
	 * @param caracteristique à ajouter
	 */
	protected void ajouterCaracteristique(Caracteristique caracteristique) {
		
		this.myCaracteristiques.add(caracteristique);
	}
	
}