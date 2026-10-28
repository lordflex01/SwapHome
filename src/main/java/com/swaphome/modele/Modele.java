package com.swaphome.modele;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.swaphome.controleur.DemandeRecu;
import com.swaphome.controleur.Echanger;
import com.swaphome.controleur.Localite;
import com.swaphome.controleur.Logement;
import com.swaphome.controleur.Pays;
import com.swaphome.controleur.Proprietaire;
import com.swaphome.controleur.TypeLogement;
import com.swaphome.controleur.UserController;
import com.swaphome.controleur.VueLogement;

/**
 * Couche d'accès aux données utilisée par l'ancienne façade statique Controleur.
 * JdbcTemplate utilise des PreparedStatement et laisse Spring gérer les connexions.
 */
@Component
public class Modele implements ApplicationContextAware {
    private static JdbcTemplate jdbc;

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        jdbc = context.getBean(JdbcTemplate.class);
    }

    private static JdbcTemplate db() {
        if (jdbc == null) {
            throw new IllegalStateException("Le contexte Spring n'a pas encore initialisé l'accès aux données.");
        }
        return jdbc;
    }

    private static <T> T one(String sql, RowMapper<T> mapper, Object... args) {
        List<T> rows = db().query(sql, mapper, args);
        return rows.isEmpty() ? null : rows.get(0);
    }

    private static Logement logement(Map<String, Object> r) {
        return new Logement(number(r, "idlogement"), number(r, "codelocalite"),
                number(r, "codetypelogement"), number(r, "idproprietaire"), text(r, "libelle"),
                text(r, "description"), text(r, "caracteristique"), decimal(r, "superficie"),
                text(r, "animaux"), text(r, "enfants"), text(r, "adresse"), text(r, "cplogement"),
                text(r, "villelogment"), text(r, "atouts"), text(r, "disponibilite"), text(r, "photo"));
    }

    private static int number(Map<String, Object> row, String column) {
        Object value = row.get(column);
        return value == null ? 0 : ((Number) value).intValue();
    }

    private static float decimal(Map<String, Object> row, String column) {
        Object value = row.get(column);
        return value == null ? 0 : ((Number) value).floatValue();
    }

    private static String text(Map<String, Object> row, String column) {
        Object value = row.get(column);
        return value == null ? null : value.toString();
    }

    public static ArrayList<Pays> selectAllPays() {
        return new ArrayList<>(db().query("select codepays, nompays from pays",
                (r, n) -> new Pays(r.getInt("codepays"), r.getString("nompays"))));
    }

    public static void updatePays(Pays p) {
        db().update("update pays set nompays = ? where codepays = ?", p.getNompays(), p.getCodepays());
    }

    public static void deletePays(int id) { db().update("delete from pays where codepays = ?", id); }
    public static void insertPays(Pays p) { db().update("insert into pays (nompays) values (?)", p.getNompays()); }
    public static Pays selectWherePays(int id) {
        return one("select codepays, nompays from pays where codepays = ?",
                (r, n) -> new Pays(r.getInt("codepays"), r.getString("nompays")), id);
    }

    public static ArrayList<TypeLogement> selectAllTypeLogements() {
        return new ArrayList<>(db().query("select codetypelogement, libelle from typelogement",
                (r, n) -> new TypeLogement(r.getInt("codetypelogement"), r.getString("libelle"))));
    }
    public static void updateTypeLogement(TypeLogement t) {
        db().update("update typelogement set libelle = ? where codetypelogement = ?", t.getLibelle(), t.getCodetypelogement());
    }
    public static void deleteTypeLogement(int id) { db().update("delete from typelogement where codetypelogement = ?", id); }
    public static void insertTypeLogement(TypeLogement t) { db().update("insert into typelogement (libelle) values (?)", t.getLibelle()); }
    public static TypeLogement selectWhereTypeLogement(int id) {
        return one("select codetypelogement, libelle from typelogement where codetypelogement = ?",
                (r, n) -> new TypeLogement(r.getInt("codetypelogement"), r.getString("libelle")), id);
    }

    public static ArrayList<Localite> selectAllLocalites() {
        return new ArrayList<>(db().query("select codelocalite, libelle, codepays from localite",
                (r, n) -> new Localite(r.getInt("codelocalite"), r.getString("libelle"), r.getInt("codepays"))));
    }
    public static void updateLocalite(Localite l) {
        db().update("update localite set libelle = ?, codepays = ? where codelocalite = ?",
                l.getLibelle(), l.getCodepays(), l.getCodelocalite());
    }
    public static void deleteLocalite(int id) { db().update("delete from localite where codelocalite = ?", id); }
    public static void insertLocalite(Localite l) {
        db().update("insert into localite (libelle, codepays) values (?, ?)", l.getLibelle(), l.getCodepays());
    }
    public static Localite selectWhereLocalite(int id) {
        return one("select codelocalite, libelle, codepays from localite where codelocalite = ?",
                (r, n) -> new Localite(r.getInt("codelocalite"), r.getString("libelle"), r.getInt("codepays")), id);
    }

    public static void insertUser(UserController u) {
        db().update("insert into userglobal (nom, prenom, adresse, cp, ville, login, mdp) values (?, ?, ?, ?, ?, ?, ?)",
                u.getNom(), u.getPrenom(), u.getAdresse(), u.getCp(), u.getVille(), u.getLogin(), u.getMdp());
    }
    public static void insertProprietaire(Proprietaire p) {
        db().update("insert into proprietaire (iduser, dateinscription, profilvoyageur, datedernierconnexion) values (?, ?, ?, ?)",
                p.getIduser(), p.getDateinscription(), p.getProfilvoyageur(), p.getDatedernierconnexion());
    }
    private static final RowMapper<UserController> USER = (r, n) -> new UserController(
            r.getInt("iduser"), r.getString("nom"), r.getString("prenom"), r.getString("adresse"),
            null, null, r.getString("cp"), r.getString("ville"), r.getString("login"), r.getString("mdp"));
    public static UserController selectWhereIdUser(String login, String mdp) { return selectWhereLoginUser(login, mdp); }
    public static UserController selectWhereLoginUser(String login, String mdp) {
        return one("select iduser, nom, prenom, adresse, cp, ville, login, mdp from userglobal where login = ? and mdp = ?", USER, login, mdp);
    }

    public static ArrayList<Logement> selectAllLogements() {
        return new ArrayList<>(db().query("select * from logement", (r, n) -> logement(columnMap(r))));
    }
    public static ArrayList<Logement> selectAllMesMaisons(int id) {
        return new ArrayList<>(db().query("select * from logement where idproprietaire = ?", (r, n) -> logement(columnMap(r)), id));
    }
    public static Proprietaire selectWhereLoginUserProprietaire(int id) {
        return one("select iduser, dateinscription, profilvoyageur, datedernierconnexion from proprietaire where iduser = ?",
                (r, n) -> new Proprietaire(r.getInt("iduser"), r.getString("dateinscription"), r.getString("profilvoyageur"),
                        r.getString("datedernierconnexion"), r.getInt("iduser")), id);
    }
    public static void insertLogement(Logement l) {
        db().update("insert into logement (codelocalite, codetypelogement, idproprietaire, libelle, description, caracteristique, superficie, animaux, enfants, adresse, cplogement, villelogment, atouts, disponibilite, photo) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                l.getCodelocalite(), l.getCodetypelogement(), l.getIdproprietaire(), l.getLibelle(), l.getDescription(),
                l.getCaracteristique(), l.getSuperficie(), l.getAnimaux(), l.getEnfants(), l.getAdresse(), l.getCplogement(),
                l.getVillelogment(), l.getAtouts(), l.getDisponibilite(), l.getPhoto());
    }
    public static void deleteLogement(int id) { db().update("delete from logement where idlogement = ?", id); }
    public static Logement selectWhereLogement(int id) {
        return one("select * from logement where idlogement = ?", (r, n) -> logement(columnMap(r)), id);
    }
    public static void updateLogement(Logement l) {
        db().update("update logement set codelocalite=?, codetypelogement=?, idproprietaire=?, libelle=?, description=?, caracteristique=?, superficie=?, animaux=?, enfants=?, adresse=?, cplogement=?, villelogment=?, atouts=?, disponibilite=?, photo=? where idlogement=?",
                l.getCodelocalite(), l.getCodetypelogement(), l.getIdproprietaire(), l.getLibelle(), l.getDescription(),
                l.getCaracteristique(), l.getSuperficie(), l.getAnimaux(), l.getEnfants(), l.getAdresse(), l.getCplogement(),
                l.getVillelogment(), l.getAtouts(), l.getDisponibilite(), l.getPhoto(), l.getIdlogement());
    }
    public static void insertEchanger(Echanger e) {
        db().update("insert into echanger (idpro1, idpro2, idlog1, idlog2, datedemande, daterepondre, dateentre, datesortie, status) values (?, ?, ?, ?, ?, null, ?, ?, ?)",
                e.getIdpro1(), e.getIdpro2(), nullableId(e.getIdlog1()), nullableId(e.getIdlog2()), e.getDatedemande(), e.getDateentre(), e.getDatesortie(), e.getStatus());
    }
    private static Object nullableId(int id) { return id == 0 ? null : id; }
    public static ArrayList<DemandeRecu> selectAllDemandeRecus(int id) {
        return new ArrayList<>(db().query("select * from demande_recu where id_proprietaire_envoyer = ?",
                (r, n) -> new DemandeRecu(r.getInt("id_echanger"), r.getString("date_demande"), r.getInt("id_proprietaire_envoyer"),
                        r.getString("nom"), r.getString("prenom"), r.getString("libelle")), id));
    }
    public static ArrayList<Logement> selectAllMaisonsDispo(int id) {
        return new ArrayList<>(db().query("select * from logement where idproprietaire = ? and disponibilite = ?",
                (r, n) -> logement(columnMap(r)), id, "oui"));
    }
    public static void updateEchanger(int id, int idlog, String date, String status) {
        db().update("update echanger set idlog1 = ?, daterepondre = ?, status = ? where idechanger = ?", nullableId(idlog), date, status, id);
    }
    public static ArrayList<Echanger> selectAllDemandesPlusStatus(int id) {
        return new ArrayList<>(db().query("select * from echanger where idpro1 = ? or idpro2 = ?",
                (r, n) -> new Echanger(r.getInt("idechanger"), r.getInt("idpro1"), r.getInt("idpro2"), r.getInt("idlog1"),
                        r.getInt("idlog2"), r.getString("datedemande"), r.getString("daterepondre"), r.getString("dateentre"),
                        r.getString("datesortie"), r.getString("status")), id, id));
    }
    public static void updatePhoto(String photo, int id) { db().update("update logement set photo = ? where idlogement = ?", photo, id); }
    public static ArrayList<VueLogement> selectAllOffres() {
        return new ArrayList<>(db().query("select * from VueLogement", (r, n) -> new VueLogement(r.getInt("idlogement"),
                r.getInt("idproprietaire"), r.getString("nom_proprietaire"), r.getString("prenom_proprietaire"),
                r.getString("email"), r.getString("typelogement"), r.getString("libelle"), r.getString("description"),
                r.getString("caracteristique"), r.getFloat("superficie"), r.getString("animaux"), r.getString("enfants"),
                r.getString("adresse"), r.getString("CP"), r.getString("ville"), r.getString("atouts"), r.getString("dispo"), r.getString("photo"))));
    }
    public static void updateDernierConnxeion(int id) {
        db().update("update proprietaire set datedernierconnexion = CURRENT_TIMESTAMP where iduser = ?", id);
    }

    private static Map<String, Object> columnMap(java.sql.ResultSet rs) throws java.sql.SQLException {
        java.sql.ResultSetMetaData md = rs.getMetaData();
        java.util.LinkedHashMap<String, Object> values = new java.util.LinkedHashMap<>();
        for (int i = 1; i <= md.getColumnCount(); i++) values.put(md.getColumnLabel(i).toLowerCase(), rs.getObject(i));
        return values;
    }
}
