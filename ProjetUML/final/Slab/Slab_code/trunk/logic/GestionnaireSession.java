package logic;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/**
 * classe qui permet la gestion des sessions
 * @author 
 *
 */
public abstract class GestionnaireSession {

    private Enseignant  myEnseignant;

    /**
	 * Authentifie un enseignant depuis la base de données
	 * @param login le login
	 * @param mdp le mot de passe
	 * @return Renvoie l'enseignant cr√©e ou null en cas d'echec.
	 */
  public abstract Enseignant authentifier(String login, String  mdp);

  /**
   * 
   * @return l'enseignant connecté
   */
  public Enseignant getEnseignant() {
	
	return this.myEnseignant;
  }
  
  /**
   * modifie l'enseignant connecté
   * @param e
   */
  public void setEnseignant(Enseignant e) {
	  
	  this.myEnseignant = e;
  }

  /**
   * @param password
   * @return une string correspondant au password encoder en md5
   */
  public String encode(String password)
  {
      byte[] uniqueKey = password.getBytes();
      byte[] hash      = null;

      try
      {
          hash = MessageDigest.getInstance("MD5").digest(uniqueKey);
      }
      catch (NoSuchAlgorithmException e)
      {
          throw new Error("No MD5 support in this VM.");
      }

      StringBuilder hashString = new StringBuilder();
      for (int i = 0; i < hash.length; i++)
      {
          String hex = Integer.toHexString(hash[i]);
          if (hex.length() == 1)
          {
              hashString.append('0');
              hashString.append(hex.charAt(hex.length() - 1));
          }
          else
              hashString.append(hex.substring(hex.length() - 2));
      }
      return hashString.toString();
  }


}