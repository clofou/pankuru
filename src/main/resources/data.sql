
-- Insertion des pays
INSERT INTO Pays (nom) VALUES ('France');
INSERT INTO Pays (nom) VALUES ('United Kingdom');
INSERT INTO Pays (nom) VALUES ('Italy');

-- Insertion des villes
INSERT INTO Ville (nom, pays_id)
VALUES ('Paris', (SELECT id FROM Pays WHERE nom = 'France'));
INSERT INTO Ville (nom, pays_id)
VALUES ('London', (SELECT id FROM Pays WHERE nom = 'United Kingdom'));
INSERT INTO Ville (nom, pays_id)
VALUES ('Rome', (SELECT id FROM Pays WHERE nom = 'Italy'));

-- Insertion des adresses
INSERT INTO Adresse (rue, ville, code_postal, pays, etat)
VALUES ('1 Avenue des Champs-Élysées', 'Paris', '75008', 'France', '');
INSERT INTO Adresse (rue, ville, code_postal, pays, etat)
VALUES ('2 Heathrow Road', 'London', 'LHR 9BA', 'United KingDom', '');
INSERT INTO Adresse (rue, ville, code_postal, pays, etat)
VALUES ('Via Leonardo da Vinci', 'Rome', '00100', 'Italy', '');
INSERT INTO Adresse (rue, ville, code_postal, pays, etat)
VALUES ('Bamako Lafiabougou', 'Bamako', '75008', 'Mali', '');
INSERT INTO Adresse (rue, ville, code_postal, pays, etat)
VALUES ('Hamdallaye ACI', 'Bamako', 'LHR 9BA', 'Mali', '');
INSERT INTO Adresse (rue, ville, code_postal, pays, etat)
VALUES ('Banconi', 'Bamako', '00100', 'Mali', '');
INSERT INTO Adresse (rue, ville, code_postal, pays, etat)
VALUES ('Banconi1', 'Bamako', '00100', 'Mali', '');

INSERT INTO Adresse (rue, ville, code_postal, pays, etat)
VALUES ('Hamdallaye ACI1', 'Bamako', '00100', 'Mali', '');


-- Insertion des aéroports
INSERT INTO Aeroport (nom, codeiata, longitude, latitude, altitude, capacite_parking, nombre_de_pistes, ville_id)
VALUES ('Charles de Gaulle', 'CDG', 2.55, 49.01, 120, 5000, 4, (SELECT id FROM Ville WHERE nom = 'Paris'));

INSERT INTO Aeroport (nom, codeiata, longitude, latitude, altitude, capacite_parking, nombre_de_pistes, ville_id)
VALUES ('Heathrow', 'LHR', -0.45, 51.47, 25, 6000, 2, (SELECT id FROM Ville WHERE nom = 'London'));

INSERT INTO Aeroport (nom, codeiata, longitude, latitude, altitude, capacite_parking, nombre_de_pistes, ville_id)
VALUES ('Fiumicino', 'FCO', 12.25, 41.80, 3, 4000, 3, (SELECT id FROM Ville WHERE nom = 'Rome'));

-- Insertion des rôles
INSERT INTO Role (nom) VALUES ('ADMIN');
INSERT INTO Role (nom) VALUES ('USER');
INSERT INTO Role (nom) VALUES ('ADMINCOMPAGNIE');
INSERT INTO Role (nom) VALUES ('PERSONNEL');
INSERT INTO Role (nom) VALUES ('PASSAGER');

-- Insertion des sieges
INSERT INTO classe_siege(nom) VALUES ('ECONOMIQUE');
INSERT INTO classe_siege(nom) VALUES ('AFFAIRE');
INSERT INTO classe_siege(nom) VALUES ('BUISSNESS');

INSERT INTO position_siege(nom, tarif, classe_siege_id) VALUES ('25E', 2000, (select id from classe_siege where nom='ECONOMIQUE'));
INSERT INTO position_siege(nom, tarif, classe_siege_id) VALUES ('24E', 5000, (select id from classe_siege where nom='AFFAIRE'));
INSERT INTO position_siege(nom, tarif, classe_siege_id) VALUES ('23B', 2000, (select id from classe_siege where nom='ECONOMIQUE'));

INSERT INTO siege(numero, position_siege_id) VALUES (25, (select id from position_siege where nom='25E'));
INSERT INTO siege(numero, position_siege_id) VALUES (26, (select id from position_siege where nom='23B'));

-- Insertion des vols
INSERT INTO vol(aeroportdarrivee, aeroport_depart, date_et_heure_arrivee, date_et_heure_depart, numero_de_vol, satut) VALUES ('SKY MALI AIRPORT', 'AIR FRANCE AIRPORT', '2024-11-12', '2024-11-11', 'b500', 'EN_COURS');
INSERT INTO vol(aeroportdarrivee, aeroport_depart, date_et_heure_arrivee, date_et_heure_depart, numero_de_vol, satut) VALUES ('SKY MALI AIRPORT1', 'AIR FRANCE AIRPORT2', '2024-11-12', '2024-11-11', 'b500', 'EN_COURS');


-- Insertion des personnes
INSERT INTO Personne (nom, prenom, email, password, numero_de_telephone, adresse_id, role_id)
VALUES ('Dupont', 'Jean', 'jean.dupont@example.com', 'password123', '0123456789', (SELECT id FROM Adresse WHERE rue = '1 Avenue des Champs-Élysées'), (SELECT nom FROM Role WHERE nom = 'ADMIN'));

INSERT INTO Personne (nom, prenom, email, password, numero_de_telephone, adresse_id, role_id)
VALUES ('Traore', 'Issa', 'issa1.dupont@example.com', 'password123', '0123456789', (SELECT id FROM Adresse WHERE rue = 'Hamdallaye ACI1'), (SELECT nom FROM Role WHERE nom = 'PASSAGER'));

INSERT INTO Personne (nom, prenom, email, password, numero_de_telephone, adresse_id, role_id)
VALUES ('Smith', 'John', 'john.smith@example.com', 'password456', '0987654321', (SELECT id FROM Adresse WHERE rue = '2 Heathrow Road'), (SELECT nom FROM Role WHERE nom = 'USER'));
INSERT INTO Personne (nom, prenom, email, password, numero_de_telephone, adresse_id, role_id)
VALUES ('Issa', 'Liam', 'lol@example.com', 'password45r', '0987654321', (SELECT id FROM Adresse WHERE rue = 'Bamako Lafiabougou'), (SELECT nom FROM Role WHERE nom = 'USER'));
INSERT INTO Personne (nom, prenom, email, password, numero_de_telephone, adresse_id, role_id)
VALUES ('Mamadou', 'Thiam', 'lol1@example.com', 'password456v', '0987654321', (SELECT id FROM Adresse WHERE rue = 'Hamdallaye ACI'), (SELECT nom FROM Role WHERE nom = 'USER'));
INSERT INTO Personne (nom, prenom, email, password, numero_de_telephone, adresse_id, role_id)
VALUES ('Tienou', 'Ali', 'lol2@example.com', 'password456c', '0987654321', (SELECT id FROM Adresse WHERE rue = 'Banconi'), (SELECT nom FROM Role WHERE nom = 'PERSONNEL'));
INSERT INTO Personne (nom, prenom, email, password, numero_de_telephone, adresse_id, role_id)
VALUES ('Lead', 'Lo', 'lol67@example.com', 'password456l', '0987654321', (SELECT id FROM Adresse WHERE rue = 'Banconi1'), (SELECT nom FROM Role WHERE nom = 'ADMINCOMPAGNIE'));

-- Insertion des super administrateurs
INSERT INTO super_admin (id,pseudo) VALUES ((SELECT id FROM personne WHERE email = 'jean.dupont@example.com'),'superadmin1');

-- Insertion des compagnies
INSERT INTO Compagnie (matricule, nom, logo, codeiata, codeicao, numero_telephone, email, site_web, numero_licence, super_admin_id)
VALUES ('AF123', 'Air France', 'airfrance_logo.png', 123, 'AFR', '014567890', 'contact@airfrance.com', 'www.airfrance.com', 'AF123456', (SELECT id FROM super_admin WHERE pseudo = 'superadmin1'));

INSERT INTO Compagnie (matricule, nom, logo, codeiata, codeicao, numero_telephone, email, site_web, numero_licence, super_admin_id)
VALUES ('BA456', 'British Airways', 'britishairways_logo.png', 456, 'BAW', '098765432', 'contact@britishairways.com', 'www.britishairways.com', 'BA456789', (SELECT id FROM super_admin WHERE pseudo = 'superadmin1'));

-- Insertion des avions
INSERT INTO Avion (matricule, capacite_totale, nom, statut, compagnie_id)
VALUES ('AF001', 200, 'Boeing 777', 'DISPONIBLE', (SELECT id FROM Compagnie WHERE matricule = 'AF123'));

INSERT INTO Avion (matricule, capacite_totale, nom, statut, compagnie_id)
VALUES ('BA002', 150, 'Airbus A320', 'MAINTENANCE', (SELECT id FROM Compagnie WHERE matricule = 'BA456'));

-- Insertion des contrats
INSERT INTO Contrat (type, description, date_debut, date_fin, statut, cgu, commentaires, compagnie_id)
VALUES ('Location', 'Location de matériel', '2024-01-01', '2024-12-31', 'EN_ATTENTE', 'Conditions générales', 'Aucun commentaire', (SELECT id FROM Compagnie WHERE matricule = 'AF123'));

INSERT INTO Contrat (type, description, date_debut, date_fin, statut, cgu, commentaires, compagnie_id)
VALUES ('Maintenance', 'Maintenance des avions', '2024-02-01', '2024-11-30', 'CONFIRMER', 'Conditions générales', 'Vérifier les détails', (SELECT id FROM Compagnie WHERE matricule = 'BA456'));




-- Insertion des utilisateurs
INSERT INTO Utilisateur (id, point_de_fideliter, date_de_naissance, numero_de_passport, numero_de_visa)
VALUES ((SELECT id FROM personne WHERE nom = 'Issa'), 100, '1990-01-01', 'P9876543', 'V9876543');

INSERT INTO Utilisateur (id, point_de_fideliter, date_de_naissance, numero_de_passport, numero_de_visa)
VALUES ((SELECT id FROM personne WHERE nom = 'Mamadou'), 50, '1985-05-05', 'P1234567', 'V1234567');

-- Insertion de reservation
INSERT INTO reservation(date_reservation, nombre_depassager, statut, utilisateur_id, vol_id) VALUES ('2024-11-1', 1, 'EN_ATTENTE',(select id from utilisateur where numero_de_passport='P9876543'), (select id from vol where aeroportdarrivee='SKY MALI AIRPORT'));


-- Insertion des administrateurs de compagnies
INSERT INTO admin_compagnie (id, pseudo, compagnie_id) VALUES ((SELECT id FROM personne WHERE nom = 'Lead'),'admin1', (SELECT id FROM Compagnie WHERE matricule = 'AF123'));

-- Insertion des Passagers
INSERT INTO passager (nom, numero_de_pass_port, numero_de_visa, prenom, reservation_id, siege_id) VALUES ('TRAORE', 'TRGGE65', 'ERR33', 'FAKORO', 1, (select id from siege where numero=25));

-- Insertion des personnels
INSERT INTO Personnel (id, date_embauche, poste, en_service, compagnie_id)
VALUES ((SELECT id FROM personne WHERE nom = 'Issa'),'2024-01-15', 'Pilot', TRUE, (SELECT id FROM Compagnie WHERE matricule = 'AF123'));

-- Affectation d'un vol à un avion
INSERT INTO vol_avion(vol_id, avion_id) VALUES ((select id from vol where aeroportdarrivee='SKY MALI AIRPORT'),(select id from avion where matricule='AF001'))