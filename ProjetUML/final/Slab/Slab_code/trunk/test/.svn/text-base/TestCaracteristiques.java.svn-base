package test;

import static org.junit.Assert.assertTrue;
import gestionnairesBD.FactoryBD;
import gestionnairesBD.GestionnaireBD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import logic.AbstractFactory;
import logic.Caracteristique;
import logic.Facade;

public class TestCaracteristiques {

public void testChargementCaracteristiques() {
		
		AbstractFactory.setInstance(new FactoryBD());
		
		Facade f = new Facade();

		int res = f.connexion("Sala", "michel");
		
		ArrayList<Caracteristique> caracteristiques = f.getCaracteristiques();
		int nbCaracteristiques = -1;
		ResultSet resRequete;
		
		resRequete = GestionnaireBD.getInstance().executeRequete("select count(*) from caracteristique");
		
		try {
			while(resRequete.next()) {
				nbCaracteristiques = Integer.parseInt(resRequete.getString(1));
				
			}
		} catch (NumberFormatException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		assertTrue(nbCaracteristiques == caracteristiques.size());
	}
}
