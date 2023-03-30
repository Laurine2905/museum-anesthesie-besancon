-- Initialisation des tables
INSERT INTO Categorie(id, nom, description, url_photo) VALUES
    (1,'Appareils d anesthésie', NULL,'https://photos.google.com/photo/AF1QipNpiGCTV_NsLZr6LX6TBP0xmsoKYVVcr-UM3Au8'), -- Les clés sont auto-générées
    (2,'Ventilateur d anesthésie', NULL,'https://drive.google.com/file/d/1MryecjMZ7mESgG5Hi7MtIO1DKOVK5RBb/view?usp=share_link'),
    (3,'Ventilateur de réanimation', 'je suis une description','https://scontent-cdg4-2.xx.fbcdn.net/v/t39.30808-6/337358627_6186424044729699_4915273017743968142_n.jpg?_nc_cat=1&ccb=1-7&_nc_sid=9267fe&_nc_ohc=p15QuXjnOwAAX_MuKB8&_nc_ht=scontent-cdg4-2.xx&oh=00_AfAyMDcP-_mhcvful4HwTAE6NNNfm3MV7Rgj2LHPNz7-Pw&oe=64265126');
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

INSERT INTO Utilisateur(login,mdp,admin) VALUES
    ('musee','besancon', true);
    