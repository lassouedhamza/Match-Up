/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matchup.servies;

/**
 *
 * @author tpc
 */

import connection.myconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import matchup.entities.proprietaire;
import matchup.entities.user;
import services.Iservies;


public class proprietaireCRUD implements Iservies {
    private Connection cnx;
    private PreparedStatement ste;

    public proprietaireCRUD() {
        cnx = myconnection.getInstance().getConnection();
    }
         ObservableList<proprietaire> ParkingList = FXCollections.observableArrayList();
     

    public ObservableList<proprietaire> getParkingList(){
   
         
    
        String query="select * from user where Roles ='["+'"'+"ROLE_PRO"+'"'+"]' ";
        PreparedStatement pre;
        try {
            pre = cnx.prepareStatement(query);
             ResultSet rst =pre.executeQuery();
        
     
      
    
        
            while(rst.next())
            {
            int id = rst.getInt("id");
            String nom =rst.getString("nom"); 
            String prenom =rst.getString("prenom"); 
            String email =rst.getString("email"); 
            String mdp =rst.getString("mdp"); 
            String adresse = rst.getString("adresse");
            int age = rst.getInt("age");
            String genre =rst.getString("genre");
//            String role =rst.getString("role");
            int nb_terrain = rst.getInt("nb_terrain");
            
            proprietaire p = new proprietaire(id, nom,  prenom ,  email ,  mdp ,   adresse ,   age ,   genre ,   nb_terrain);
            ParkingList.add(p);
            }   } catch (SQLException ex) {
            Logger.getLogger(proprietaireCRUD.class.getName()).log(Level.SEVERE, null, ex);
        } 
     
     return ParkingList;
    }
    public void ajouterPersonne(proprietaire p){
        String req ="INSERT INTO user ( nom,  prenom ,  email ,  mdp ,  adresse ,   age ,   genre ,  nb_terrain ,Roles)"+"values (?,?,?,?,?,?,?,?,?)";
        try {
            ste = cnx.prepareStatement(req);
            ste.setString(1, p.getNom());
            ste.setString(2, p.getPrenom());
            ste.setString(3, p.getEmail());
            ste.setString(4, p.getMdp());
            ste.setString(5, p.getAdresse());
            ste.setInt(6, p.getAge());
            ste.setString(7, p.getGenre());
            ste.setInt(8, p.getNb_terrain());
            ste.setString(9,"["+'"'+"ROLE_PRO"+'"'+"]");
            ste.executeUpdate();
            System.out.println("Personne ajoutée");
            
        } catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());
            
        }
        
    }


    @Override
    public List<proprietaire> Afficherproprietaire() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Supprimerproprietaire(proprietaire p) {
             
        try {
            Statement stm = cnx.createStatement();
            String query = "DELETE FROM `user` WHERE id='"+p.getId()+"'";
            stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(proprietaireCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 

    @Override
    public void Modifierproprietaire(proprietaire p) {
       

            
        String req = "UPDATE `user` SET `nom`=?,`prenom`=?,`email`=?,`mdp`=?,`adresse`=?,`age`=?,`genre`=?,`nb_terrain`=? where `id`=?";
          
        try {
            ste = cnx.prepareStatement(req);

            ste.setString(1, p.getNom());
            ste.setString(2, p.getPrenom());
            ste.setString(3, p.getEmail());
            ste.setString(4, p.getMdp());
            ste.setString(5, p.getAdresse());
            ste.setInt(6, p.getAge());
            ste.setString(7, p.getGenre());
            ste.setInt(8, p.getNb_terrain());
            ste.setInt(9, p.getId());
            ste.executeUpdate();
;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
            public proprietaire findByUserIdPopulated(int id) throws SQLException {
        try {
            PreparedStatement pre = cnx.prepareStatement("SELECT * FROM `user`  WHERE user.id = ?");
            pre.setString(1, String.valueOf(id));

            ResultSet rs = pre.executeQuery();
            proprietaire c = new proprietaire();
            if (rs.next()) {
            c.setId(rs.getInt("id"));
            c.setEmail(rs.getString("email"));
            c.setAdresse(rs.getString("adresse"));
            c.setNom(rs.getString("nom"));
            c.setGenre(rs.getString("genre"));
            c.setAge(rs.getInt("age"));
            c.setMdp(rs.getString("mdp"));
            c.setPrenom(rs.getString("prenom"));
            c.setNb_terrain(rs.getInt("nb_terrain"));

            }
        return c;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;

    }
            
    }


    


