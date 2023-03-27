-- Initialisation des tables
INSERT INTO Categorie(id, nom, description, url_photo) VALUES
    (1,'Appareils d anesthésie', NULL,'https://photos.google.com/photo/AF1QipNpiGCTV_NsLZr6LX6TBP0xmsoKYVVcr-UM3Au8'), -- Les clés sont auto-générées
    (2,'Ventilateur d anesthésie', NULL,'https://photos.google.com/photo/AF1QipOi2cm-3IxlCJ4DjdonRC2jGf95-FwJl16kyZBk'),
    (3,'Ventilateur de réanimation', 'je suis une description','https://photos.google.com/photo/AF1QipOaUupqUsDpyTBMaZMIJ6TZBrnlj-QqV2hyaQ40');
ALTER TABLE Categorie ALTER COLUMN id RESTART WITH 4;

INSERT INTO Salle (id,nom) VALUES
    (1,'Salle A'),
    (2,'Salle B'),
    (3,'Salle C');
ALTER TABLE Salle ALTER COLUMN id RESTART WITH 4;

INSERT INTO Objet(id,nom, annee, createur, pays, description,url_photo, nb_Possession, categorie_id, salle_id) VALUES
    (1,'Heidbrink', '1945', 'US Army', 'USA', 'Surplus de l US Army', 'https://photos.google.com/photo/AF1QipMY4jS6OtFEj7M7VeaK44wgNo75fTK3gD4AZmAn', '1', (select id from categorie where nom='Appareils d anesthésie'), (select id from salle where nom='Salle A') );
ALTER TABLE Objet ALTER COLUMN id RESTART WITH 2;

INSERT INTO MultimediaCat(id,description, URL_photoCat, URL_audioCat, URL_videoCat, categorie_id ) VALUES
    (1,'je suis une description d une categorie multimedia', NULL, NULL, NULL, (select id from categorie where nom ='Ventilateur de réanimation'));
ALTER TABLE MultimediaCat ALTER COLUMN id RESTART WITH 2;

INSERT INTO MultimediaObj(id,description, URL_photoObj, URL_audioObj, URL_videoObj, objet_id ) VALUES
    (1,'je suis une description d un objet multimedia', NULL, NULL, NULL, (select id from objet where nom ='Heidbrink'));
ALTER TABLE MultimediaObj ALTER COLUMN id RESTART WITH 2;


    