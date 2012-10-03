package gestionnaireFile;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import logic.Enseignant;
import logic.GestionnaireSession;

public class GestionnaireSessionFile extends GestionnaireSession{

	@Override
	public Enseignant authentifier(String login, String mdp) {
		
		Enseignant res = null;
		//On crée une instance de SAXBuilder
	    SAXBuilder sxb = new SAXBuilder();
	    Document doc = null;
	    Element racine;
	    
	    try {
			doc = sxb.build(new File("files/enseignants.xml"));
		} catch (JDOMException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	    
	    if(doc != null) {
		    racine = doc.getRootElement();
		    List listEnseignants = racine.getChildren("enseignant");
		    Iterator i = listEnseignants.iterator();
		    
		    while(i.hasNext()) {
		    	
		    	Element courant = (Element)i.next();
		    	
		    	if(courant.getChild("nom").getTextTrim().equals(login) && courant.getChild("pass").getTextTrim().equals(mdp)) {
		    		
		    		String nom = courant.getChild("nom").getTextTrim();
		    		String prenom = courant.getChild("prenom").getTextTrim();
		    		boolean supUser = courant.getChild("super").getTextTrim().equals("1") ? true : false;
		    		
		    		res = new Enseignant(nom, prenom, supUser);
		    	}
		    }
	    }

	    
		return res;
	}

}
