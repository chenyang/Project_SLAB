drop type ty_caracteristique ;
drop type ty_ref_caracteristique ;
drop type nt_caracteristique ;

drop type ty_Salle ;
drop type ty_ref_salle;

drop type ty_creneau ;
drop type ty_ref_creneau ;

drop type ty_matiere;
drop type ty_ref_matiere ;

drop type ty_type_cours ;
drop type ty_ref_type_cours;


drop type ty_cours;
drop type ty_ref_cours ;

drop type ty_Enseignement ; 
drop type ty_ref_ENseignement;
drop type nt_enseignement ;

drop type ty_Reservation ;
drop type nt_reservation;


drop type ty_Enseignant;




create or replace type ty_caracteristique as object (ID_Caracteristique number (10), libelle_caracteristique char (255))/
create or replace type ty_ref_caracteristique as object (RefS ref ty_caracteristique)/
create or replace type nt_caracteristique as table of ty_ref_caracteristique/

create or replace type ty_Salle as object (ID_SALLE NUMBER(10), num_salle CHAR(255), carac nt_caracteristiques)/
create or replace type ty_ref_salle as object (RefS ref ty_SAlle)/

create or replace type ty_creneau as object (ID_creneau NUMBER(10), heure_debut CHAR(255), heure_fin CHAR(255))/
create or replace type ty_ref_creneau as object (RefC ref ty_creneau)/

create or replace type ty_matiere as object (ID_matiere NUMBER(10), libelle_matiere char(255))/
create or replace type ty_ref_matiere as object (RefM ref ty_matiere)/

create or replace type ty_type_cours as object (ID_type_cours NUMBER(10), libelle_type_cours char (255))/
create or replace type ty_ref_type_cours as object (Reftc ref ty_type_cours)/


create or replace type ty_cours as object(ID_COURS number(10), matiere ty_ref_matiere, type_cours ty_ref_type_cours)/
create or replace type ty_ref_cours as object (RefCo ref ty_cours)/

create or replace type ty_Enseignement as object(ID_ENSEIGNEMENT NUMBER(10), cours ty_ref_cours, groupe ty_ref_groupe)/ 
create or replace type ty_ref_ENseignement as object (RefE ref ty_enseignement)/
create or replace type nt_enseignement as table of ty_ref_enseignement/

create or replace type ty_Reservation as object (ID_RESERVATION NUMBER(10), salle ty_ref_salle, creneau ty_ref_creneau, 
enseignement ty_ref_enseignement, dateRes date)/
create or replace type ty_ref_reservation as object (RefR ref ty_reservation)/
create or replace type nt_reservation as table of ty_ref_reservation/


create or replace type ty_Enseignant as object (ID_ENSEIGNANT NUMBER(10), nom CHAR(255), prenom CHAR(255) 
liste_Enseignement nt_enseignement, liste_Reservations nt_reservation)/



