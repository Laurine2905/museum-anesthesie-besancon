-- Initialisation des tables
INSERT INTO Categorie(nom, description, url_photo) VALUES
    ('Appareils d anesthésie', NULL,'https://photos.google.com/photo/AF1QipNpiGCTV_NsLZr6LX6TBP0xmsoKYVVcr-UM3Au8'), -- Les clés sont auto-générées
    ('Ventilateur d anesthésie', NULL,'https://photos.google.com/photo/AF1QipOi2cm-3IxlCJ4DjdonRC2jGf95-FwJl16kyZBk'),
    ('Ventilateur de réanimation', 'je suis une description','https://photos.google.com/photo/AF1QipOaUupqUsDpyTBMaZMIJ6TZBrnlj-QqV2hyaQ40');

INSERT INTO Salle (nom) VALUES
    ('Salle A'),
    ('Salle B'),
    ('Salle C');

INSERT INTO Objet(nom, annee, createur, pays, description,url_photo, nb_Possession, categorie_id, salle_id) VALUES
    ('Heidbrink', '1945', 'US Army', 'USA', 'Surplus de l US Army', 'https://photos.google.com/photo/AF1QipMY4jS6OtFEj7M7VeaK44wgNo75fTK3gD4AZmAn', '1', (select id from categorie where nom='Appareils d anesthésie'), (select id from salle where nom='Salle A') );

INSERT INTO MultimediaCat(description, URL_photoCat, URL_audioCat, URL_videoCat, categorie_id ) VALUES
    ('je suis une description d une categorie multimedia', NULL, NULL, NULL, (select id from categorie where nom ='Ventilateur de réanimation'));

INSERT INTO MultimediaObj(description, URL_photoObj, URL_audioObj, URL_videoObj, objet_id ) VALUES
    ('je suis une description d un objet multimedia', NULL, NULL, NULL, (select id from objet where nom ='Heidbrink'));

INSERT INTO Utilisateur(login,mdp,admin) VALUES
    ('musee','besancon', true);
    