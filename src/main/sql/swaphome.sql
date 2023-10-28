DROP DATABASE IF EXISTS swapehome;
CREATE DATABASE swapehome;
use swapehome;

DROP TABLE IF EXISTS userglobal;
CREATE TABLE userglobal (
    iduser int NOT NULL AUTO_INCREMENT,
    nom char(50) NOT NULL,
    prenom varchar(50) NOT NULL,
    adresse varchar(100),
    cp char(5),
    ville varchar(50),
    login varchar(50) NOT NULL,
    mdp varchar(50) NOT NULL,
    PRIMARY KEY (iduser)
);




DROP TABLE IF EXISTS typelogement;
create table typelogement
(
	codetypelogement int(5) not null auto_increment,
	libelle varchar(50) not null,
	PRIMARY KEY (codetypelogement)	
)engine=innodb;



DROP TABLE IF EXISTS pays;
create table pays
(
	codepays int(5) not null auto_increment,
	nompays varchar(50) not null,
	PRIMARY KEY (codepays)	
)engine=innodb;


DROP TABLE IF EXISTS localite;
create table localite
(
	codelocalite int(5) not null auto_increment,
	libelle varchar(50) not null,
	codepays int(5) not null,
	PRIMARY KEY (codelocalite),
	FOREIGN KEY (codepays) references pays(codepays)
)engine=innodb;


DROP TABLE IF EXISTS logement;
create table logement(
idlogement int(5) not null auto_increment,
codelocalite int(5) not null, 
codetypelogement int(5) not null,
iduser int(5) not null,
libelle varchar(50) not null,
description varchar(255) not null,
caracteristique varchar(255),
superficie float(10,2) not null,
animaux enum("oui","non") not null,
enfants enum("oui","non") not null,
adresse varchar(255) not null,
cplogement char(5) not null,
villelogment varchar(50) not null,
atouts varchar(50),
disponiblitile enum("oui","non") not null,
PRIMARY KEY (idlogement),
FOREIGN KEY(codelocalite) references localite(codelocalite),
FOREIGN KEY (codetypelogement) references typelogement(codetypelogement),
FOREIGN KEY (iduser) references userglobal(iduser)
)engine=innodb;




insert into userglobal (nom,prenom,adresse,cp,ville,login,mdp) values ("Tom","Henry","route de Chartres","94110","Orsay","tomhenry","123");
insert into typelogement(libelle) values("double-chambre");
insert into pays(nompays) values("France");
insert into localite(libelle,codepays) values("Paris",1);
insert into logement(codelocalite,codetypelogement,iduser,libelle,description,caracteristique,superficie,animaux,enfants,adresse,cplogement,villelogment,atouts,disponiblitile) 
values(1,1,1,"maison de reve","grande et comfortable","sentir comme chez vous",50,"non","oui","Avenue de Paris","75000","Paris","pres de centreville","oui");

DROP TABLE IF EXISTS proprietaire;
CREATE TABLE proprietaire
 (
   iduser int(5) not null auto_increment,
   dateinscription timestamp not null default CURRENT_TIMESTAMP,
   profilvoyageur enum('Solo', 'En couple'),
   photoprofil  varchar(200) null,
   datedernierconnexion  timestamp not null default CURRENT_TIMESTAMP ,
   nom varchar(50) not null,
   PRENOM varchar(50) not null,
   ADRESSE varchar(100) null,
   CP CHAR(5) null,
   VILLE varchar(50) null,
   LOGIN varchar(50) not null,  
   MDP varchar(255) not null,
   PRIMARY KEY (iduser),
   FOREIGN KEY (iduser) REFERENCES userglobal (iduser) ON delete cascade on update cascade
 ) engine=innodb;






 