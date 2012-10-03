DROP TABLE UE CASCADE CONSTRAINTS;
DROP TABLE MATIERE CASCADE CONSTRAINTS;
DROP TABLE GROUPE CASCADE CONSTRAINTS;
DROP TABLE CRENAUX CASCADE CONSTRAINTS;
DROP TABLE ENSEIGNEMENT CASCADE CONSTRAINTS;
DROP TABLE CARACTERISTIQUE CASCADE CONSTRAINTS;
DROP TABLE BATIMENT CASCADE CONSTRAINTS;
DROP TABLE RESERVATION CASCADE CONSTRAINTS;
DROP TABLE SALLE CASCADE CONSTRAINTS;
DROP TABLE TYPECOURS CASCADE CONSTRAINTS;
DROP TABLE ENSEIGNANT CASCADE CONSTRAINTS;
DROP TABLE COURS CASCADE CONSTRAINTS;
DROP TABLE CARACTERISTIQUE_SALLE CASCADE CONSTRAINTS;
DROP TABLE RESERVATION_CARACTERISTIQUE CASCADE CONSTRAINTS;
-- ----------------------------------------------------------------------------- -- CREATION DE LA BASE -- -----------------------------------------------------------------------------
CREATE DATABASE MLR1;
-- ----------------------------------------------------------------------------- -- TABLE : UE -- -----------------------------------------------------------------------------
CREATE TABLE UE
  (
   ID_UE NUMBER(10)  NOT NULL,
   ID_ENSEIGNANT NUMBER(10)  NULL,
   LIBELLE_UE CHAR(255)  NULL
, CONSTRAINT PK_UE PRIMARY KEY (ID_UE)
  ) ;
-- ----------------------------------------------------------------------------- -- INDEX DE LA TABLE UE -- -----------------------------------------------------------------------------
CREATE INDEX I_FK_UE_ENSEIGNANT
    ON UE (ID_ENSEIGNANT ASC)
   ;
-- ----------------------------------------------------------------------------- -- TABLE : MATIERE -- -----------------------------------------------------------------------------
CREATE TABLE MATIERE
  (
   ID_MATIERE NUMBER(10)  NOT NULL,
   ID_UE NUMBER(10)  NULL,
   ID_ENSEIGNANT NUMBER(10)  NULL,
   LIBELLE_MATIERE CHAR(255)  NULL
, CONSTRAINT PK_MATIERE PRIMARY KEY (ID_MATIERE)
  ) ;
-- ----------------------------------------------------------------------------- -- INDEX DE LA TABLE MATIERE -- -----------------------------------------------------------------------------
CREATE INDEX I_FK_MATIERE_UE
    ON MATIERE (ID_UE ASC)
   ;
CREATE INDEX I_FK_MATIERE_ENSEIGNANT
    ON MATIERE (ID_ENSEIGNANT ASC)
   ;
-- ----------------------------------------------------------------------------- -- TABLE : GROUPE -- -----------------------------------------------------------------------------
CREATE TABLE GROUPE
  (
   ID_GROUPE NUMBER(10)  NOT NULL,
   ID_GROUPE_A_POUR_PERE NUMBER(10)  NULL,
   LIBELLE_GROUPE CHAR(255)  NULL
, CONSTRAINT PK_GROUPE PRIMARY KEY (ID_GROUPE)
  ) ;
-- ----------------------------------------------------------------------------- -- INDEX DE LA TABLE GROUPE -- -----------------------------------------------------------------------------
CREATE INDEX I_FK_GROUPE_GROUPE
    ON GROUPE (ID_GROUPE_A_POUR_PERE ASC)
   ;
-- ----------------------------------------------------------------------------- -- TABLE : CRENAUX -- -----------------------------------------------------------------------------
CREATE TABLE CRENAUX
  (
   ID_CRENEAU NUMBER(10)  NOT NULL,
   HEURE_DEBUT CHAR(255)  NULL,
   HEURE_FIN CHAR(255)  NULL
, CONSTRAINT PK_CRENAUX PRIMARY KEY (ID_CRENEAU)
  ) ;
-- ----------------------------------------------------------------------------- -- TABLE : ENSEIGNEMENT -- -----------------------------------------------------------------------------
CREATE TABLE ENSEIGNEMENT
  (
   ID_ENSEIGNEMENT NUMBER(10)  NOT NULL,
   ID_COURS NUMBER(10)  NULL,
   ID_ENSEIGNANT NUMBER(10)  NULL,
   ID_GROUPE NUMBER(10)  NULL,
   NB_HEURE_PREVUE NUMBER(4)  NULL
, CONSTRAINT PK_ENSEIGNEMENT PRIMARY KEY (ID_ENSEIGNEMENT)
  ) ;
-- ----------------------------------------------------------------------------- -- INDEX DE LA TABLE ENSEIGNEMENT -- -----------------------------------------------------------------------------
CREATE INDEX I_FK_ENSEIGNEMENT_COURS
    ON ENSEIGNEMENT (ID_COURS ASC)
   ;
CREATE INDEX I_FK_ENSEIGNEMENT_ENSEIGNANT
    ON ENSEIGNEMENT (ID_ENSEIGNANT ASC)
   ;
CREATE INDEX I_FK_ENSEIGNEMENT_GROUPE
    ON ENSEIGNEMENT (ID_GROUPE ASC)
   ;
-- ----------------------------------------------------------------------------- -- TABLE : CARACTERISTIQUE -- -----------------------------------------------------------------------------
CREATE TABLE CARACTERISTIQUE
  (
   ID_CARACTERISTIQUE NUMBER(10)  NOT NULL,
   LIBELLE_CARACTERISTIQUE CHAR(255)  NULL
, CONSTRAINT PK_CARACTERISTIQUE PRIMARY KEY (ID_CARACTERISTIQUE)
  ) ;
-- ----------------------------------------------------------------------------- -- TABLE : BATIMENT -- -----------------------------------------------------------------------------
CREATE TABLE BATIMENT
  (
   ID_BATIMENT NUMBER(10)  NOT NULL,
   LIBELLE_BATIMENT CHAR(255)  NULL
, CONSTRAINT PK_BATIMENT PRIMARY KEY (ID_BATIMENT)
  ) ;
-- ----------------------------------------------------------------------------- -- TABLE : RESERVATION -- -----------------------------------------------------------------------------
CREATE TABLE RESERVATION
  (
   ID_RESERVATION NUMBER(10)  NOT NULL,
   ID_SALLE NUMBER(10)  NULL,
   ID_CRENEAU NUMBER(10)  NULL,
   ID_ENSEIGNEMENT NUMBER(10)  NULL,
   DATE_RESERVATION DATE  NULL
, CONSTRAINT PK_RESERVATION PRIMARY KEY (ID_RESERVATION)
  ) ;
-- ----------------------------------------------------------------------------- -- INDEX DE LA TABLE RESERVATION -- -----------------------------------------------------------------------------
CREATE INDEX I_FK_RESERVATION_SALLE
    ON RESERVATION (ID_SALLE ASC)
   ;
CREATE INDEX I_FK_RESERVATION_CRENAUX
    ON RESERVATION (ID_CRENEAU ASC)
   ;
CREATE INDEX I_FK_RESERVATION_ENSEIGNEMENT
    ON RESERVATION (ID_ENSEIGNEMENT ASC)
   ;
-- ----------------------------------------------------------------------------- -- TABLE : SALLE -- -----------------------------------------------------------------------------
CREATE TABLE SALLE
  (
   ID_SALLE NUMBER(10)  NOT NULL,
   ID_BATIMENT NUMBER(10)  NULL,
   NUMERO_SALLE CHAR(255)  NULL
, CONSTRAINT PK_SALLE PRIMARY KEY (ID_SALLE)
  ) ;
-- ----------------------------------------------------------------------------- -- INDEX DE LA TABLE SALLE -- -----------------------------------------------------------------------------
CREATE INDEX I_FK_SALLE_BATIMENT
    ON SALLE (ID_BATIMENT ASC)
   ;
-- ----------------------------------------------------------------------------- -- TABLE : TYPECOURS -- -----------------------------------------------------------------------------
CREATE TABLE TYPECOURS
  (
   ID_TYPE_DE_COURS NUMBER(10)  NOT NULL,
   LIBELLE_TYPE_DE_COURS CHAR(255)  NULL
, CONSTRAINT PK_TYPECOURS PRIMARY KEY (ID_TYPE_DE_COURS)
  ) ;
-- ----------------------------------------------------------------------------- -- TABLE : ENSEIGNANT -- -----------------------------------------------------------------------------
CREATE TABLE ENSEIGNANT
  (
   ID_ENSEIGNANT NUMBER(10)  NOT NULL,
   NOM CHAR(255)  NULL,
   PRENOM CHAR(255)  NULL,
   MDP CHAR(255)  NULL,
   SUPER_USER NUMBER(1)  NULL
, CONSTRAINT PK_ENSEIGNANT PRIMARY KEY (ID_ENSEIGNANT)
  ) ;
-- ----------------------------------------------------------------------------- -- TABLE : COURS -- -----------------------------------------------------------------------------
CREATE TABLE COURS
  (
   ID_COURS NUMBER(10)  NOT NULL,
   ID_MATIERE NUMBER(10)  NULL,
   ID_TYPE_DE_COURS NUMBER(10)  NULL,
   LIBELLE_COURS CHAR(255)  NULL
, CONSTRAINT PK_COURS PRIMARY KEY (ID_COURS)
  ) ;
-- ----------------------------------------------------------------------------- -- INDEX DE LA TABLE COURS -- -----------------------------------------------------------------------------
CREATE INDEX I_FK_COURS_MATIERE
    ON COURS (ID_MATIERE ASC)
   ;
CREATE INDEX I_FK_COURS_TYPECOURS
    ON COURS (ID_TYPE_DE_COURS ASC)
   ;
-- ----------------------------------------------------------------------------- -- TABLE : CARACTERISTIQUE_SALLE -- -----------------------------------------------------------------------------
CREATE TABLE CARACTERISTIQUE_SALLE
  (
   ID_SALLE NUMBER(10)  NOT NULL,
   ID_CARACTERISTIQUE NUMBER(10)  NOT NULL
, CONSTRAINT PK_CARACTERISTIQUE_SALLE PRIMARY KEY (ID_SALLE, ID_CARACTERISTIQUE)
  ) ;
-- ----------------------------------------------------------------------------- -- INDEX DE LA TABLE CARACTERISTIQUE_SALLE -- -----------------------------------------------------------------------------
CREATE INDEX I_FK_CARACTERISTIQUE_SALLE_SAL
    ON CARACTERISTIQUE_SALLE (ID_SALLE ASC)
   ;
CREATE INDEX I_FK_CARACTERISTIQUE_SALLE_CAR
    ON CARACTERISTIQUE_SALLE (ID_CARACTERISTIQUE ASC)
   ;
-- ----------------------------------------------------------------------------- -- TABLE : RESERVATION_CARACTERISTIQUE -- -----------------------------------------------------------------------------
CREATE TABLE RESERVATION_CARACTERISTIQUE
  (
   ID_CARACTERISTIQUE NUMBER(10)  NOT NULL,
   ID_RESERVATION NUMBER(10)  NOT NULL
, CONSTRAINT PK_RESERVATION_CARACTERISTIQUE PRIMARY KEY (ID_CARACTERISTIQUE, ID_RESERVATION)
  ) ;
-- ----------------------------------------------------------------------------- -- INDEX DE LA TABLE RESERVATION_CARACTERISTIQUE -- -----------------------------------------------------------------------------
CREATE INDEX I_FK_RESERVATION_CARACTERISTIQ
    ON RESERVATION_CARACTERISTIQUE (ID_CARACTERISTIQUE ASC)
   ;
CREATE INDEX I_FK_RESERVATION_CARACTERISTI1
    ON RESERVATION_CARACTERISTIQUE (ID_RESERVATION ASC)
   ;

-- ----------------------------------------------------------------------------- -- CREATION DES REFERENCES DE TABLE -- -----------------------------------------------------------------------------

ALTER TABLE UE ADD (
    CONSTRAINT FK_UE_ENSEIGNANT
         FOREIGN KEY (ID_ENSEIGNANT)
              REFERENCES ENSEIGNANT (ID_ENSEIGNANT))   ;
ALTER TABLE MATIERE ADD (
    CONSTRAINT FK_MATIERE_UE
         FOREIGN KEY (ID_UE)
              REFERENCES UE (ID_UE))   ;
ALTER TABLE MATIERE ADD (
    CONSTRAINT FK_MATIERE_ENSEIGNANT
         FOREIGN KEY (ID_ENSEIGNANT)
              REFERENCES ENSEIGNANT (ID_ENSEIGNANT))   ;
ALTER TABLE GROUPE ADD (
    CONSTRAINT FK_GROUPE_GROUPE
         FOREIGN KEY (ID_GROUPE_A_POUR_PERE)
              REFERENCES GROUPE (ID_GROUPE))   ;
ALTER TABLE ENSEIGNEMENT ADD (
    CONSTRAINT FK_ENSEIGNEMENT_COURS
         FOREIGN KEY (ID_COURS)
              REFERENCES COURS (ID_COURS))   ;
ALTER TABLE ENSEIGNEMENT ADD (
    CONSTRAINT FK_ENSEIGNEMENT_ENSEIGNANT
         FOREIGN KEY (ID_ENSEIGNANT)
              REFERENCES ENSEIGNANT (ID_ENSEIGNANT))   ;
ALTER TABLE ENSEIGNEMENT ADD (
    CONSTRAINT FK_ENSEIGNEMENT_GROUPE
         FOREIGN KEY (ID_GROUPE)
              REFERENCES GROUPE (ID_GROUPE))   ;
ALTER TABLE RESERVATION ADD (
    CONSTRAINT FK_RESERVATION_SALLE
         FOREIGN KEY (ID_SALLE)
              REFERENCES SALLE (ID_SALLE))   ;
ALTER TABLE RESERVATION ADD (
    CONSTRAINT FK_RESERVATION_CRENAUX
         FOREIGN KEY (ID_CRENEAU)
              REFERENCES CRENAUX (ID_CRENEAU))   ;
ALTER TABLE RESERVATION ADD (
    CONSTRAINT FK_RESERVATION_ENSEIGNEMENT
         FOREIGN KEY (ID_ENSEIGNEMENT)
              REFERENCES ENSEIGNEMENT (ID_ENSEIGNEMENT))   ;
ALTER TABLE SALLE ADD (
    CONSTRAINT FK_SALLE_BATIMENT
         FOREIGN KEY (ID_BATIMENT)
              REFERENCES BATIMENT (ID_BATIMENT))   ;
ALTER TABLE COURS ADD (
    CONSTRAINT FK_COURS_MATIERE
         FOREIGN KEY (ID_MATIERE)
              REFERENCES MATIERE (ID_MATIERE))   ;
ALTER TABLE COURS ADD (
    CONSTRAINT FK_COURS_TYPECOURS
         FOREIGN KEY (ID_TYPE_DE_COURS)
              REFERENCES TYPECOURS (ID_TYPE_DE_COURS))   ;
ALTER TABLE CARACTERISTIQUE_SALLE ADD (
    CONSTRAINT FK_CARACTERISTIQUE_SALLE_SALLE
         FOREIGN KEY (ID_SALLE)
              REFERENCES SALLE (ID_SALLE))   ;
ALTER TABLE CARACTERISTIQUE_SALLE ADD (
    CONSTRAINT FK_CARACTERISTIQUE_SALLE_CARAC
         FOREIGN KEY (ID_CARACTERISTIQUE)
              REFERENCES CARACTERISTIQUE (ID_CARACTERISTIQUE))   ;
ALTER TABLE RESERVATION_CARACTERISTIQUE ADD (
    CONSTRAINT FK_RESERVATION_CARACTERISTIQUE
         FOREIGN KEY (ID_CARACTERISTIQUE)
              REFERENCES CARACTERISTIQUE (ID_CARACTERISTIQUE))   ;
ALTER TABLE RESERVATION_CARACTERISTIQUE ADD (
    CONSTRAINT FK_RESERVATION_CARACTERISTIQU1
         FOREIGN KEY (ID_RESERVATION)
              REFERENCES RESERVATION (ID_RESERVATION))   ;