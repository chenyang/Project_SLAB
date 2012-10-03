select count (deref(Res.RefR.creneau).heure_debut) from table(select E.liste_Reservations from VEnseignant E 
where nom = 'Dulas' AND prenom = 'Marc') Res 
where deref(deref(deref(Res.RefR.enseignement).cours).matiere).libelle_matiere = 'Communication' 
AND deref(deref(deref(Res.RefR.enseignement).cours).type_cours).libelle_type_cours = 'TP' 
AND deref(deref(Res.RefR.enseignement).groupe).libelle_groupe = 'IG4 anglais G3'
AND Res.RefR.DATERES < to_date(current_date(),'dd-mm-yyyy');

ResultSet resRequete = GestionnaireBD.getInstance().executeRequete("select count (deref(Res.RefR.creneau).heure_debut) from table(select E.liste_Reservations from VEnseignant E where nom = '" + (e.getEnseignant()).getNom() + "' AND prenom = '" + (e.getEnseignant()).getPrenom() + "') Res where Res.RefR.Salle is not NULL AND deref(deref(deref(Res.RefR.enseignement).cours).matiere).libelle_matiere = '" + e.getMatiere() + "' AND deref(deref(deref(Res.RefR.enseignement).cours).type_cours).libelle_type_cours = '" + e.getTypeCours() + "' AND deref(deref(Res.RefR.enseignement).groupe).libelle_groupe = '"+ (e.getGroupe()).getLibelleGroupe() +"' AND Res.RefR.DATERES < to_date('" + new java.sql.Date((new Date()).getTime()).toString() + "','yy-mm-dd') ");


2. présenter les résultats
	étudier les tendances des liseuses
	être générale dans le marché de la liseuse revue tel que la tribune
	
étudier les avis de revue de amazone sur le marché professionnel