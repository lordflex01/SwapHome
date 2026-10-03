# SwapHome

Application web d'échange de logements (type "home swap") permettant à des utilisateurs de s'inscrire comme propriétaires, de publier des logements disponibles à l'échange, et d'envoyer/recevoir des demandes d'échange avec d'autres propriétaires.

> ## Projet réalisé en 2022-2023 dans le cadre d'un exercice/projet d'apprentissage Java EE, en cours de modernisation.

## Fonctionnalités

- Inscription et connexion utilisateur (`inscription.jsp`, `connexion.jsp`)
- Gestion des logements : type de logement, pays, localité (CRUD)
- Publication d'un logement par un propriétaire (`logement.jsp`)
- Liste des logements disponibles à l'échange (`indexswap.jsp`)
- Envoi et réception de demandes d'échange entre propriétaires (`Echanger`, `DemandeRecu`)
- Espace administrateur (`homeadmin.jsp`)

## Stack technique

- **Langage** : Java 17 et Maven
- **Vue** : JSP avec scriptlets Java (pas de Servlet dédié, pas de JSTL/EL)
- **Accès données** : Spring JDBC (`JdbcTemplate`) avec requêtes paramétrées et pool de connexions Spring Boot
- **Base de données** : MySQL (schéma dans `src/main/sql/swaphome.sql`)
- **Driver JDBC** : MySQL Connector/J (`com.mysql.cj.jdbc.Driver`)

## Architecture

```
src/main/java/
├── controleur/          # Classes "métier" (façade statique) + classes modèle (User, Logement, Pays, Localite,
│                         # TypeLogement, Proprietaire, Echanger, DemandeRecu)
│   └── Controleur.java   # Point d'entrée appelé depuis les JSP, délègue tout à Modele
└── modele/
    └── Modele.java       # Requêtes SQL paramétrées via JdbcTemplate

src/main/webapp/
├── vue/                  # JSP avec scriptlets Java (accès direct à Controleur.*)
├── images/
└── WEB-INF/lib/          # Dépendances (driver JDBC, etc.)

src/main/sql/
└── swaphome.sql          # Script de création du schéma MySQL + données de test
```

**Flux d'une requête** : JSP (scriptlet) → `Controleur` (façade statique conservée) → `Modele` → `JdbcTemplate` et le pool de connexions Spring Boot.

Il n'y a pas de vrai Servlet-Controller ni de séparation MVC stricte : les JSP contiennent directement la logique de contrôle (lecture des paramètres de requête, redirection, gestion de session).

## Modèle de données

Tables principales (voir `swaphome.sql`) :

- `userglobal` — utilisateurs (nom, prénom, adresse, login, mot de passe)
- `proprietaire` — extension de `userglobal` pour les propriétaires (profil voyageur, photo, dates)
- `pays`, `localite` — référentiel géographique
- `typelogement` — types de logement
- `logement` — logements publiés (rattachés à un propriétaire, une localité, un type)
- `echanger` / `demande_recu` — demandes d'échange entre propriétaires

## Lancer le projet en local

Prérequis : JDK 17, Maven et MySQL.

1. Créer la base de données à partir de `src/main/sql/swaphome.sql`.
2. Définir `DATABASE_URL` (par exemple `jdbc:mysql://localhost:3306/swapehome`), `DATABASE_USERNAME` et `DATABASE_PASSWORD` dans l'environnement.
3. Lancer avec `mvn spring-boot:run` ou construire le WAR avec `mvn package`.
4. Accéder à `/connexion.jsp` pour se connecter, ou `/inscription.jsp` pour créer un compte.

## Points à traiter ensuite

Cette section liste les problèmes identifiés dans le code existant, à traiter en priorité lors de la refonte :

- **Mots de passe en clair** : stockés et comparés sans hachage.
- **Schéma fourni incomplet ou divergent** : `swaphome.sql` n'inclut pas `echanger`, `demande_recu` ni la vue `VueLogement`. Il définit aussi `logement.iduser`, alors que les requêtes historiques utilisent `idproprietaire`. Le schéma utilisé en déploiement doit être aligné avant exécution de ces fonctions.
- **Architecture de présentation ancienne** : les JSP/scriptlets et la façade `Controleur` statique restent à migrer.
- **Gestion d'erreurs minimale** : prévoir un traitement applicatif et une journalisation structurés.

## Roadmap de modernisation (proposée)

- [x] Migration vers Maven/Gradle pour la gestion des dépendances et le build
- [x] Migration vers Spring Boot + Spring JDBC pour éliminer le SQL concaténé
- [ ] Hachage des mots de passe (BCrypt) + migration des comptes existants
- [x] Externalisation des identifiants de connexion via variables d'environnement
- [ ] Ajout de tests unitaires et d'intégration
- [ ] Remplacement des JSP/scriptlets par une couche de présentation moderne (Thymeleaf ou API REST + frontend séparé)

## Licence

Copyright 2026 **DIGI&DO** - Tous droits réservés.
