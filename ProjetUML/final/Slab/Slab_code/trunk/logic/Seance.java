package logic;

import java.util.ArrayList;
import java.util.Date;

public class Seance extends Reservation{

    private Enseignement enseignement;

    /**
     * constructeur
     */
    public Seance() {
    	
    }

    /**
     * constructeur paramtr
     * @param creneau
     * @param date
     * @param enseignement
     * @param caracteristiques
     * @param salle
     */
	public Seance(Creneau creneau, Date date,
			Enseignement enseignement, ArrayList<Caracteristique> caracteristiques, Salle salle) {
		super(creneau, date, caracteristiques, salle);
		this.enseignement = enseignement;
	}
	
	/**
	 * 
	 * @return l'enseignement
	 */
	public Enseignement getEnseignement() {
		
		return this.enseignement;
	}
	
	/**
	 * @return l'affichage de la sance
	 */
	public String toString() {
		
		return super.toString() + " " + this.enseignement.toString();
	}
	
	/**
	 * @return affichage pour le planning
	 */
	public String stringPlanning() {
		String res = " ";
		res = res + this.getEnseignement().getMatiere().toString() + "\n" + this.getEnseignement().getTypeCours().toString() + "\n" + this.getEnseignement().getGroupe().toString() + "\n" + this.getSalle().toString();
		
		return res;
	}
	
	/**
	 * @return l'enseignant
	 */
	public Enseignant getEnseignant() {
		
		return this.enseignement.getEnseignant();
	}
    
    

}