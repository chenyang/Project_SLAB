package logic;

/**
 * Cette classe repr�sente un cr�neau avec une heure de d�but et une heure de fin.
 * @author Anthony
 *
 */

public class Creneau implements Comparable {

	/**
	 * L'heure de d�but du cr�neau.
	*/
	private Heure heureDebut;
	
	/**
	 * L'heure de fin du cr�neau
	 */
	private Heure heureFin;

	
	/**
	 * Constructeur par d�faut.
	 */
	  public Creneau() {
		  
	  }
	  
	  /**
	   * Constructeur param�tr�.
	   * @param heureDebut L'heure de d�but du cr�neau.
	   * @param heureFin L'heure de fin du cr�neau.
	   */
	  public Creneau(Heure heureDebut, Heure heureFin) {
		  
		  this.heureDebut = heureDebut;
		  this.heureFin = heureFin;
	  }
	
	  /**
	   * Accesseur pour l'heure de d�but du cr�neau.
	   * @return L'heure de d�but du cr�neau.
	   */
		public Heure getHeureDebut() {
			return heureDebut;
		}
		
		/**
		 * Modifieur de l'heure de d�but du cr�neau.
		 * @param heureDebut L'heure de d�but � assigner au cr�neau.
		 */
		public void setHeureDebut(Heure heureDebut) {
			this.heureDebut = heureDebut;
		}
		
		/**
		   * Accesseur pour l'heure de fin du cr�neau.
		   * @return L'heure de fin du cr�neau.
		   */
		public Heure getHeureFin() {
			return heureFin;
		}
		
		/**
		 * Modifieur de l'heure de fin du cr�neau.
		 * @param heureFin L'heure de fin � assigner au cr�neau.
		 */
		public void setHeureFin(Heure heureFin) {
			this.heureFin = heureFin;
		}
	
		public boolean estEgal(Heure heureDebut, Heure heureFin) {
			
			return (this.heureDebut.estEgal(heureDebut) && this.heureFin.estEgal(heureFin));
		}
	
		/**
		 * Teste l'�galit� de deux cr�neaux.
		 * @param creneau Le cr�neau � tester.
		 * @return Vrai si les deux cr�neaux sont �gaux, faux sinon.
		 */
		public boolean estEgal(Creneau creneau) {
			
			return (this.heureDebut.estEgal(creneau.heureDebut) && this.heureFin.estEgal(creneau.heureFin));
		}
		
		public String toString() {
			
			String res;
			
			res = "" + this.heureDebut.toString() + "-" + this.heureFin.toString();
			
			return res;
		}
	
	
		/**
		 * Red�finition de la m�thode compareTo pour comparer deux cr�neaux.
		 */
		@Override
		public int compareTo(Object o) {
			
			return this.heureDebut.compareTo(((Creneau)o).getHeureDebut());
		}

}