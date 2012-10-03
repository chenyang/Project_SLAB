package logic;

import java.util.ArrayList;

/**
 * classe pour la gestion des carat�ristiques
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
     * charge les caract�ristiques de la base de donn�e
     */
	public abstract void chargerCaracteristiques();


	/* Methodes concr�tes */
	/**
	 * acc�sseur sur la liste des caract�ristiques
	 * @return la liste des caract�ristiques
	 */
	public ArrayList<Caracteristique> getCaracteristiques() {
		
		return this.myCaracteristiques;
	}

	/**
	 * retourne true si la liste des caract�ristiques donn�e en entr�e de la m�thode existe, false sinon
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
	 * ajoute une caract�ristique � la liste des caract�ristiques
	 * @param caracteristique � ajouter
	 */
	protected void ajouterCaracteristique(Caracteristique caracteristique) {
		
		this.myCaracteristiques.add(caracteristique);
	}
	
}