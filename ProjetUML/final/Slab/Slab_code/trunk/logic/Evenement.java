package logic;

/**
 * Cette classe repr�sente une r�servation pour un �venement.
 * @author Anthony
 *
 */
public class Evenement extends Reservation{
	
	/**
	 * L'enseignant demandant la r�servation de l'�venement.
	 */
	private Enseignant demandeur;

	@Override
	/**
	 * @return l'enseignant de l'instance
	 */
	public Enseignant getEnseignant() {

		return this.demandeur;
	}

}
