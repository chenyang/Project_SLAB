package test;
import static org.junit.Assert.*;

import org.junit.Test;
import logic.AbstractFactory;
import gestionnairesBD.FactoryBD;
import logic.Facade;

public class TestLogin {

	public void testLoginEnseignant() {
		
		AbstractFactory.setInstance(new FactoryBD());
		
		Facade f = new Facade();

		int res = f.connexion("Sala", "michel");
		
		assertTrue(res == 1);
	}

public void testLoginResponsable() {
		
		AbstractFactory.setInstance(new FactoryBD());
		
		Facade f = new Facade();

		int res = f.connexion("Stratulat", "tiberiu");
		
		assertTrue(res == 2);
	}

}
