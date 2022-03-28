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
import java.util.logging.Level;
import java.util.logging.Logger;
import matchup.entities.utilisateur;

/**
 *
 * @author tpc
 */
public class panier {
    private Connection cnx;
    private PreparedStatement ste;
//    Connection connexion;
//    PreparedStatement ps;

    public panier() {
//        connexion = MyDB.getinstance().getConnexion();
cnx = myconnection.getInstance().getConnection();
    }
    public int getsum(int d) {
         String sql = "SELECT SUM(prix) FROM produit,panier where produit.id_produit = panier.id_produit and panier.id="+d+"";
        int i = 0;
        try {
            Statement statement = cnx.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                i = result.getInt("SUM(prix)");
            }

        } catch (SQLException ex) {
            Logger.getLogger(utilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (i);
    }
    public void delete(int d) throws SQLException{
         Statement stm = cnx.createStatement();
            String query = "DELETE FROM `panier` WHERE id="+d+"";
            stm.executeUpdate(query);
    }
    
}
