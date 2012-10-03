package logic;

public class Heure implements Comparable{
	
	private int nbHeure;
	private int nbMinutes;
	
	/**
	 * constructeur de la classe
	 */
	public Heure() {
		
	}
	
	/**
	 * constructeur de la classe paramtr
	 * @param nbHeure
	 * @param nbMinutes
	 */
	public Heure(int nbHeure, int nbMinutes) {
		
		this.nbHeure = nbHeure;
		this.nbMinutes = nbMinutes;
	}

	/**
	 * 
	 * @param heure
	 * @return true si l'heure en paramtre est gale ˆ l'heure de l'instance
	 */
	public boolean estEgal(Heure heure) {
		
		return ((this.nbHeure == heure.nbHeure) && (this.nbMinutes == heure.nbMinutes));
	}

	/**
	 * 
	 * @return le nombre d'heure
	 */
	public int getNbHeure() {
		return nbHeure;
	}

	/**
	 * 
	 * @return le nombre de minute
	 */
	public int getNbMinutes() {
		return nbMinutes;
	}

	@Override
	/**
	 * @return 1 si l'heure de l'instance est plus grande que l'heure en paramtre, -1 pour le contraire et 0 si elles sont gales
	 */
	public int compareTo(Object o) {
		
		if(this.nbHeure > ((Heure)o).getNbHeure()) {
			return 1;
		}
		else if(this.nbHeure == ((Heure)o).getNbHeure()) {
			
			if(this.nbMinutes > ((Heure)o).getNbMinutes()) {
				return 1;
			}
			else if(this.nbMinutes == ((Heure)o).getNbMinutes()) {
				System.out.println(this + " egal " + (Heure)o);
				return 0;
			}
			else {
				return -1;
			}
		}
		else {
			return -1;
		}
	}
	
	/**
	 * @return affichage de l'objet
	 */
	public String toString() {
		if (nbMinutes==0) {
		return(nbHeure + "h00");
		}
		else if (nbMinutes<10) {
			return(nbHeure + "h0" + nbMinutes);
			}
		else {
		return(nbHeure + "h" + nbMinutes);
		}
	}
}
