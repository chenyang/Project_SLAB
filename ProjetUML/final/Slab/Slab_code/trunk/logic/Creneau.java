package logic;

/**
 * Cette classe représente un créneau avec une heure de début et une heure de fin.
 * @author Anthony
 *
 */

public class Creneau implements Comparable {

	/**
	 * L'heure de début du créneau.
	*/
	private Heure heureDebut;
	
	/**
	 * L'heure de fin du créneau
	 */
	private Heure heureFin;

	
	/**
	 * Constructeur par défaut.
	 */
	  public Creneau() {
		  
	  }
	  
	  /**
	   * Constructeur paramétré.
	   * @param heureDebut L'heure de début du créneau.
	   * @param heureFin L'heure de fin du créneau.
	   */
	  public Creneau(Heure heureDebut, Heure heureFin) {
		  
		  this.heureDebut = heureDebut;
		  this.heureFin = heureFin;
	  }
	
	  /**
	   * Accesseur pour l'heure de début du créneau.
	   * @return L'heure de début du créneau.
	   */
		public Heure getHeureDebut() {
			return heureDebut;
		}
		
		/**
		 * Modifieur de l'heure de début du créneau.
		 * @param heureDebut L'heure de début à assigner au créneau.
		 */
		public void setHeureDebut(Heure heureDebut) {
			this.heureDebut = heureDebut;
		}
		
		/**
		   * Accesseur pour l'heure de fin du créneau.
		   * @return L'heure de fin du créneau.
		   */
		public Heure getHeureFin() {
			return heureFin;
		}
		
		/**
		 * Modifieur de l'heure de fin du créneau.
		 * @param heureFin L'heure de fin à assigner au créneau.
		 */
		public void setHeureFin(Heure heureFin) {
			this.heureFin = heureFin;
		}
	
		public boolean estEgal(Heure heureDebut, Heure heureFin) {
			
			return (this.heureDebut.estEgal(heureDebut) && this.heureFin.estEgal(heureFin));
		}
	
		/**
		 * Teste l'égalité de deux créneaux.
		 * @param creneau Le créneau à tester.
		 * @return Vrai si les deux créneaux sont égaux, faux sinon.
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
		 * Redéfinition de la méthode compareTo pour comparer deux créneaux.
		 */
		@Override
		public int compareTo(Object o) {
			
			return this.heureDebut.compareTo(((Creneau)o).getHeureDebut());
		}

}