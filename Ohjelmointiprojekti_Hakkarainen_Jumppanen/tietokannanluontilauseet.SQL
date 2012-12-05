DROP TABLE pelitaulu;
DROP TABLE julkaisijataulu;
DROP TABLE alustataulu;
DROP TABLE genretaulu;


CREATE TABLE julkaisijataulu (
julkaisijatauluid INTEGER NOT NULL AUTO_INCREMENT, 
julkaisija_nimi VARCHAR(40) NOT NULL, 
PRIMARY KEY (julkaisijatauluid)
);

CREATE TABLE genretaulu (
genretauluid INTEGER NOT NULL AUTO_INCREMENT,
genre_nimi VARCHAR(30) NOT NULL,
PRIMARY KEY (genretauluid)
);

CREATE TABLE alustataulu (
alustatauluid INTEGER NOT NULL AUTO_INCREMENT, 
alusta_nimi VARCHAR(45) NOT NULL,
PRIMARY KEY (alustatauluid)
);

CREATE TABLE pelitaulu (
 peli_id INTEGER NOT NULL AUTO_INCREMENT,
 pelin_nimi VARCHAR(45),
 genre_id INTEGER NOT NULL,
 julkaisija_id INTEGER NOT NULL,
 alusta_id INTEGER NOT NULL,
 julkaisuvuosi INTEGER NOT NULL,
 arvosana INT,
 kuvaus VARCHAR(200),
 lisaysaika DATE DEFAULT 'now()' not null,
PRIMARY KEY (peli_id),
foreign key (genre_id) references genretaulu (genretauluid),
foreign key (alusta_id) references alustataulu (alustatauluid),
foreign key (julkaisija_id) references julkaisijataulu (julkaisijatauluid)	
);
INSERT INTO ALUSTATAULU (alusta_nimi) VALUES ('PC');
INSERT INTO GENRETAULU (genre_nimi) VALUES ('RPG');
INSERT INTO JULKAISIJATAULU  (julkaisija_nimi) VALUES ('Activision');
INSERT INTO ALUSTATAULU (alusta_nimi) VALUES ('XBOX');
INSERT INTO GENRETAULU (genre_nimi) VALUES ('MMO');
INSERT INTO JULKAISIJATAULU  (julkaisija_nimi) VALUES ('Valve');
INSERT INTO PELITAULU (pelin_nimi, genre_id, julkaisija_id, alusta_id, julkaisuvuosi, arvosana, kuvaus) VALUES ('Pelle seikkailee taas 2', 2, 2, 1, 1871, 5, 'Pelle pelisarjan paras osa, pelintekijät ovat onnistuneet luomaan loistavan pelin');

INSERT INTO PELITAULU (pelin_nimi, genre_id, julkaisija_id, alusta_id, julkaisuvuosi, arvosana, kuvaus) VALUES ('Pelle seikkailee taas 2', 2, 2, 1, 1871, 5, 'Pelle pelisarjan paras osa, pelintekijät ovat onnistuneet luomaan loistavan pelin');
INSERT INTO PELITAULU (pelin_nimi, genre_id, julkaisija_id, alusta_id, julkaisuvuosi, arvosana, kuvaus) VALUES ('Pelle seikkailee taas 3', 1, 2, 2, 1871, 5, 'Pelle pelisarjan paras osa, pelintekijät ovat onnistuneet luomaan loistavan pelin');
INSERT INTO PELITAULU (pelin_nimi, genre_id, julkaisija_id, alusta_id, julkaisuvuosi, arvosana, kuvaus) VALUES ('Apinan seikkailut', 1,1,1, 1986, 5, 'Apina');
SELECT APP.PELITAULU.PELI_ID, APP.GENRETAULU.GENRE_NIMI, APP.JULKAISIJATAULU.JULKAISIJA_NIMI,APP.ALUSTATAULU.ALUSTA_NIMI, APP.PELITAULU.JULKAISUVUOSI, APP.PELITAULU.ARVOSANA, APP.PELITAULU.KUVAUS, APP.PELITAULU.LISAYSAIKA  FROM PELITAULU, GENRETAULU, ALUSTATAULU, JULKAISIJATAULU
;
