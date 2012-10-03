package test;

import static org.junit.Assert.assertTrue;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import gestionnairesBD.FactoryBD;
import gestionnairesBD.GestionnaireBD;
import logic.AbstractFactory;
import logic.Creneau;
import logic.Facade;

public class TestCreneaux {
	
public void testChargementCreneaux() {
		
		AbstractFactory.setInstance(new FactoryBD());
		
		Facade f = new Facade();

		int res = f.connexion("Sala", "michel");
		
		ArrayList<Creneau> creneaux = f.getCreneaux();
		int nbCreneaux = -1;
		ResultSet resRequete;
		
		resRequete = GestionnaireBD.getInstance().executeRequete("select count(*) from crenau");
		
		try {
			while(resRequete.next()) {
				nbCreneaux = Integer.parseInt(resRequete.getString(1));
				
			}
		} catch (NumberFormatException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		assertTrue(nbCreneaux == creneaux.size());
	}

}
