drop type ty_Enseignant;

drop type nt_reservation;
drop type ty_ref_reservation;
drop type ty_Reservation ;

drop type ty_Salle ;

drop type ty_creneau ;

drop type nt_caracteristique ;
drop type ty_ref_caracteristique ;
drop type ty_caracteristique ;

drop type nt_enseignement ;
drop type ty_ref_ENseignement;
drop type ty_Enseignement ;

drop type ty_cours; 

drop type ty_type_cours ;

drop type ty_matiere;

drop type ty_groupe;

drop view VEnseignant;

drop view VReservation;

drop view VCreneau;

drop view VGroupe;

drop view VCours;

drop view VType_cours;

drop view VMatiere;

drop view VSalle;
drop view VCaracteristique;

drop view VEnseignement;



---------------------TYPES OBJETS-----------------------------




create or replace type ty_caracteristique as object (ID_Caracteristique number (10), libelle_caracteristique char (255))
/
create or replace type ty_ref_caracteristique as object (RefCa ref ty_caracteristique)
/
create or replace type nt_caracteristique as table of ty_ref_caracteristique
/

create or replace type ty_salle as object (ID_SALLE NUMBER(10), numero_salle CHAR(255), carac nt_caracteristique)
/

create or replace type ty_groupe as object (ID_GROUPE number(10), libelle_groupe char(255), ID_GROUPE_PERE number(10))
/

create or replace type ty_creneau as object (ID_CRENEAU NUMBER(10),heure_debut char(255), heure_fin CHAR(255))
/

create or replace type ty_matiere as object (ID_matiere NUMBER(10), libelle_matiere char(255))
/

create or replace type ty_type_cours as object (ID_type_cours NUMBER(10), libelle_type_cours Char (255))
/


create or replace type ty_cours as object(ID_COURS number(10), matiere ref ty_matiere, type_cours ref ty_type_cours)
/

create or replace type ty_enseignement as object(ID_ENSEIGNEMENT NUMBER(10), cours ref ty_cours, groupe ref ty_groupe, nb_heure_prevue NUMBER(4))
/
create or replace type ty_ref_enseignement as object (RefE ref ty_enseignement)
/
create or replace type nt_enseignement as table of ty_ref_enseignement
/

create or replace type ty_Reservation as object (ID_RESERVATION NUMBER(10), salle ref ty_salle, creneau ref ty_creneau, 
enseignement ref ty_enseignement, dateRes date, caracteristiques nt_caracteristique)
/
create or replace type ty_ref_reservation as object (RefR ref ty_reservation)
/
create or replace type nt_reservation as table of ty_ref_reservation
/


create or replace type ty_enseignant as object (ID_ENSEIGNANT NUMBER(10), nom CHAR(255), prenom CHAR(255), 
liste_Enseignement nt_enseignement, liste_Reservations nt_reservation)
/

---------------------------VUES----------------------------

create or replace view VCreneau of ty_creneau
with object identifier(ID_CRENEAU)
as select C.ID_CRENEAU,C.HEURE_DEBUT, C.HEURE_FIN from crenaux C;

create or replace view VGroupe of ty_groupe
with object identifier(ID_GROUPE)
as select G.ID_GROUPE, G.libelle_groupe, G.ID_GROUPE_A_POUR_PERE from groupe G;

create or replace view VMatiere of ty_matiere
with object identifier(ID_MATIERE)
as select M.ID_MATIERE, M.LIBELLE_MATIERE from matiere M;	

create or replace view VType_cours of ty_type_cours
with object identifier(id_type_cours)
as select T.id_type_de_cours, T.libelle_type_de_cours from typecours T;

create or replace view VCours of ty_cours
with object identifier(id_cours)
as select C.id_cours, make_ref(VMatiere, C.id_matiere), make_ref(VType_cours, C.id_type_de_cours) from cours C;

create or replace view VCaracteristique of ty_caracteristique
with object identifier(ID_CARACTERISTIQUE)
as select C.ID_CARACTERISTIQUE, C.LIBELLE_CARACTERISTIQUE from caracteristique C;

create or replace view VSalle of ty_salle
with object identifier(ID_SALLE)
as select S.ID_SALLE, S.NUMERO_SALLE, 
cast(
	multiset(
		select make_ref(VCaracteristique, C.ID_CARACTERISTIQUE) from caracteristique_salle C where S.ID_SALLE = C.ID_SALLE) as nt_caracteristique) from salle S;

create or replace view VEnseignement of ty_enseignement
with object identifier(id_enseignement)
as select E.id_enseignement, make_ref(VCours, E.id_cours), make_ref(VGroupe, E.id_groupe), E.nb_heure_prevue from enseignement E; 

create or replace view VReservation of ty_reservation
with object identifier(id_reservation)
as select R.id_reservation, make_ref(VSalle, R.id_salle), make_ref(VCreneau, R.id_creneau), make_ref(VEnseignement, R.id_enseignement), R.date_reservation,
cast (
	multiset(
		select make_ref(VCaracteristique, RC.ID_CARACTERISTIQUE) from reservation_caracteristique RC where RC.ID_RESERVATION = R.ID_RESERVATION) as nt_caracteristique)
 from reservation R;
 

create or replace view VEnseignant of ty_enseignant
with object identifier(ID_ENSEIGNANT)
as select ens.ID_ENSEIGNANT, ens.NOM, ens.PRENOM,
cast(
	multiset(
		select make_ref(VEnseignement, E.id_enseignement) from enseignement E where ens.id_enseignant = E.id_enseignant) as nt_enseignement),
cast(
	multiset(
		select make_ref(VReservation, R.id_reservation) from reservation R where ens.id_enseignant = (select Ebis.id_enseignant from enseignement Ebis where R.id_enseignement = Ebis.id_enseignement)) as nt_reservation)  from enseignant ens;

------------------------REQUETES-----------------------------

-- Enseignements d'un professeur donnÅÈ

select Ens.RefE.nb_heure_prevue, deref(deref(Ens.RefE.cours).type_cours).libelle_type_cours, deref(deref(Ens.RefE.cours).matiere).libelle_matiere, deref(Ens.RefE.groupe).libelle_groupe from table( select E.liste_enseignement from VEnseignant E where nom = 'Stratulat') Ens;

-- Demandes en cours d'un enseignant 

select Res.RefR.id_reservation, deref(Res.RefR.creneau).heure_debut, deref(Res.RefR.creneau).heure_fin,deref(Res.RefR.enseignement).nb_heure_prevue, deref(deref(deref(Res.RefR.enseignement).cours).matiere).libelle_matiere,
deref(deref(deref(Res.RefR.enseignement).cours).type_cours).libelle_type_cours, deref(deref(Res.RefR.enseignement).groupe).libelle_groupe,
Res.RefR.dateRes from table(select E.liste_Reservations from VEnseignant E where nom = 'Stratulat') Res where Res.RefR.salle is null;

select Res.RefR.id_reservation, deref(Res.RefR.creneau).heure_debut, deref(Res.RefR.creneau).heure_fin,deref(Res.RefR.enseignement).nb_heure_prevue, deref(deref(deref(Res.RefR.enseignement).cours).matiere).libelle_matiere,deref(deref(deref(Res.RefR.enseignement).cours).type_cours).libelle_type_cours, deref(deref(Res.RefR.enseignement).groupe).libelle_groupe,Res.RefR.dateRes from table(select E.liste_Reservations from VEnseignant E where nom = 'Stratulat') Res where Res.RefR.salle is null;




