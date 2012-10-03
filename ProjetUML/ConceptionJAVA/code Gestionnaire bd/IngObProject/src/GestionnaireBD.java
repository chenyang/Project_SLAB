import java.sql.*;
import java.util.ArrayList;


public class GestionnaireBD {

	private Connection connexion;
	private Statement requete;
	private ResultSet resultQuery;
	private ResultSetMetaData metadata;
	
	/**
	 * initialise le gestionnaire
	 */
	GestionnaireBD(){
		
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			this.connexion = DriverManager.getConnection("jdbc:oracle:thin:@v240.ig.polytech.univ-montp2.fr:1521:ORA10","irvin.genieys","oracle");
			this.requete=connexion.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * permet de lancer une requête de sélection
	 * @param req
	 * @return un arraylist contenant les lignes de la requête dont les colonnes sont séparées par |
	 */
	ArrayList<String> RequeteSelect(String req)
	{
		int i=1;
		String row="";
		ArrayList<String> resultat=new ArrayList();  
		try {
			this.resultQuery=this.requete.executeQuery(req);
			this.metadata=this.resultQuery.getMetaData();
			while(this.resultQuery.next())
			{
				while(metadata.getColumnCount()>=i)
				{
					row+=this.resultQuery.getString(i)+"|";
					i++;
				}
				resultat.add(row.substring(0, row.length()-1));
				i=1;
				row="";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultat;
	}
	
	/**
	 * permet de lancer une requte d'insertion ou de mise à jour
	 * @param req
	 */
	void RequeteInsertOrUpdate(String req)
	{
		try {
			this.resultQuery=this.requete.executeQuery(req);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
