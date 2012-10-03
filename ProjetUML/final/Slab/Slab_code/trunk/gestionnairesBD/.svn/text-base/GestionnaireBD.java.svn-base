package gestionnairesBD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * classe pour la gestion de la liaison avec la base de donnée Oracle
 * @author 
 */
public class GestionnaireBD {
	
	private static GestionnaireBD instance;
	private Connection connectionBD;
	private Statement requete;
	
	/**
	 * constructeur du gestionnaireBD qui garantie qu'une seule instance de ce gestionnaire existe
	 */
	private GestionnaireBD() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			this.connectionBD = DriverManager.getConnection("jdbc:oracle:thin:@v240.ig.polytech.univ-montp2.fr:1521:ORA10","irvin.genieys","oracle");
		} 
		catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
	}
	
	/**
	 * retourne l'instance du gestionnaireBD
	 * @return l'instance du gestionnaireBD
	 */
	public static GestionnaireBD getInstance() {
		
		if(instance == null) {
			
			instance = new GestionnaireBD();
		}
		
			return instance;
	}
	
	/**
	 * permet l'exécution d'une requète sql d'insertion et de sélection
	 * @param s la requète à exécuter
	 * @return le resultat de la requète sous la forme d'un ResultSet
	 */
	public ResultSet executeRequete(String s){
	       
        ResultSet resultQuery = null;
        try {
            this.requete = this.connectionBD.createStatement();
            resultQuery=requete.executeQuery(s);

        } catch (SQLException e) {e.printStackTrace();    }

       

        return resultQuery;
    }
	
	/**
	 * permet l'exécution d'une requète sql de modification
	 * @param s la requète à exécuter
	 * @return un entier équivalent à 0 si la requète n'a pas réussi ou un autre chiffre si elle a échouée
	 */
	public int executeUpdate(String s) {
		int res = 0;
		
		try {
			this.requete = this.connectionBD.createStatement();
			res = this.requete.executeUpdate(s);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return res;
		
	}
	
	
	/**
	 * permet de fermer la liaison avec la base de donnée Oracle
	 */
	public void closeStatement() {
		
		try {
			this.requete.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
