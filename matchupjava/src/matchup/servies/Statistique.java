/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matchup.servies;

import connection.myconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import matchup.entities.proprietaire;
import matchup.entities.user;
import matchup.entities.utilisateur;
import services.IStatistique;
public class Statistique implements IStatistique {
 
private Connection cnx;
    private PreparedStatement ste;
//    Connection connexion;
//    PreparedStatement ps;

    public Statistique() {
//        connexion = MyDB.getinstance().getConnexion();
cnx = myconnection.getInstance().getConnection();
    }

    @Override
    public int getNombreutilisateur() {
        String sql = "SELECT count(*) FROM user WHERE Roles = '["+'"'+"ROLE_UTI"+'"'+"]'";
        int i = 0;
        try {
            Statement statement = cnx.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                i = result.getInt("COUNT(*)");
            }

        } catch (SQLException ex) {
            Logger.getLogger(utilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (i);
    }

    @Override
    public int getNombreproprietaire() {
        String sql = "SELECT count(*) FROM user WHERE Roles = '["+'"'+"ROLE_PRO"+'"'+"]'";
        int i = 0;
        try {
            Statement statement = cnx.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                i = result.getInt("COUNT(*)");
            }

        } catch (SQLException ex) {
            Logger.getLogger(proprietaire.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (i);
    }

    @Override
    public int getNombreAdministrateurs() {
        String sql = "SELECT count(*) FROM user WHERE Roles = '["+'"'+"ROLE_ADMIN"+'"'+"]'";
        int i = 0;
        try {
            Statement statement = cnx.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                i = result.getInt("COUNT(*)");
            }

        } catch (SQLException ex) {
            Logger.getLogger(user.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (i);
    }

    @Override
    public int getNombreProduits() {
        String sql = "SELECT count(*) FROM produit ";
        int i = 0;
        try {
            Statement statement = cnx.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                i = result.getInt("COUNT(*)");
            }

        } catch (SQLException ex) {
            Logger.getLogger(user.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (i);
    }

    @Override
    public int getNombreProduitsVendus() {
        String sql = "SELECT count(*) FROM panier , produit where panier.id_produit = produit.id_produit ";
//                + " p, produit_panier pp, panier pa where pp.id_panier = pa.id and pp.id_produit = p.id and pa.statut = 'Valide'  ";
        int i = 0;
        try {
            Statement statement = cnx.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                i = result.getInt("COUNT(*)");
            }

        } catch (SQLException ex) {
            Logger.getLogger(user.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (i);
    }


  

}


