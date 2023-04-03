-- Initialisation des tables
INSERT INTO Categorie(id, nom, description) VALUES
    ( 1,'Appareils d anesthésie', NULL), -- Les clés sont auto-générées
    ( 17,'Ventilateur d anesthésie', NULL),
    ( 3,'Ventilateur de réanimation', 'je suis une description');
ALTER TABLE Categorie ALTER COLUMN id RESTART WITH 4;

INSERT INTO Salle (id,nom) VALUES
    (1,'Salle A'),
    (2,'Salle B'),
    (3,'Salle C');
ALTER TABLE Salle ALTER COLUMN id RESTART WITH 4;

INSERT INTO Objet(id,nom, annee, createur, pays, description, nb_Possession, categorie_id, salle_id) VALUES
    (1,'Heidbrink', '1945', 'US Army', 'USA', 'Surplus de l US Army', '1', (select id from categorie where nom='Appareils d anesthésie'), (select id from salle where nom='Salle A') );
ALTER TABLE Objet ALTER COLUMN id RESTART WITH 2;

INSERT INTO Multimedia(id,description, URL_audioCat, URL_videoCat, categorie_id, objet_id ) VALUES
    (1,'je suis une description d une categorie multimedia',  NULL, NULL, (select id from categorie where nom ='Ventilateur de réanimation'), NULL),
    (2,'je suis une description d un objet multimedia', NULL, NULL, NULL, (select id from objet where nom ='Heidbrink'));
ALTER TABLE Multimedia ALTER COLUMN id RESTART WITH 3;

INSERT INTO Utilisateur(login,mdp,admin) VALUES
    ('musee','besancon', true);
    