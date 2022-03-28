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
import matchup.entities.user;

import matchup.entities.utilisateur;
import services.IserviceU;



public class utilisateurCRUD implements IserviceU {
    private Connection cnx;
    private PreparedStatement ste;

    public utilisateurCRUD() {
        cnx = myconnection.getInstance().getConnection();
    }
         ObservableList<utilisateur> ParkingList = FXCollections.observableArrayList();
     

    public ObservableList<utilisateur> getParkingList(){
   
         
    
        String query="select * from user where roles ='["+'"'+"ROLE_UTI"+'"'+"]'";
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
            String roles =rst.getString("roles");
            
            
            utilisateur p = new utilisateur(id, nom,  prenom ,  email ,  mdp ,   adresse ,   age ,   genre ,roles );
            ParkingList.add(p);
            }   } catch (SQLException ex) {
            Logger.getLogger(utilisateurCRUD.class.getName()).log(Level.SEVERE, null, ex);
        } 
     
     return ParkingList;
    }
    public void ajouterPersonne(utilisateur p){
        String req ="INSERT INTO user ( nom,  prenom ,  email ,  mdp ,  adresse ,   age ,   genre , nb_terrain ,Roles)"+"values (?,?,?,?,?,?,?,?,?)";
        try {
            ste = cnx.prepareStatement(req);
            ste.setString(1, p.getNom());
            ste.setString(2, p.getPrenom());
            ste.setString(3, p.getEmail());
            ste.setString(4, p.getMdp());
            ste.setString(5, p.getAdresse());
            ste.setInt(6, p.getAge());
            ste.setString(7, p.getGenre());
            ste.setInt(8,0);
            ste.setString(9,"["+'"'+"ROLE_UTI"+'"'+"]" );
            ste.executeUpdate();
            System.out.println("Personne ajoutée");
            
        } catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());
            
        }
        
    }


   

    @Override
    public List<utilisateur> Afficherutilisateur() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Supprimerutilisateur(utilisateur p) {
        try {
            Statement stm = cnx.createStatement();
            String query = "DELETE FROM `user` WHERE id='"+p.getId()+"'";
            stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(proprietaireCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void Modifierutilisateur(utilisateur p) {
        String req = "UPDATE `user` SET `nom`=?,`prenom`=?,`email`=?,`mdp`=?,`adresse`=?,`age`=?,`genre`=? where `id`=?";
          
        try {
            ste = cnx.prepareStatement(req);

            ste.setString(1, p.getNom());
            ste.setString(2, p.getPrenom());
            ste.setString(3, p.getEmail());
            ste.setString(4, p.getMdp());
            ste.setString(5, p.getAdresse());
            ste.setInt(6, p.getAge());
            ste.setString(7, p.getGenre());
//            ste.setInt(8, p.getNb_terrain());
            ste.setInt(8, p.getId());
            ste.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
    
        public user login(String email,String password) throws SQLException {
        try {
            PreparedStatement pre = cnx.prepareStatement("select * from user where email = ? ");
            pre.setString(1, email);

            ResultSet rs = pre.executeQuery();
            user u = new user();
            if (rs.next()) {
            u.setId(rs.getInt("id"));
            u.setEmail(rs.getString("email"));
            u.setMdp(rs.getString("mdp"));
            u.setRoles(rs.getString("Roles"));
            }
        return u;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;

    }
        
        public user findByUserIdPopulated(int id) throws SQLException {
        try {
            PreparedStatement pre = cnx.prepareStatement("SELECT * FROM `user`  WHERE user.id = ?");
            pre.setString(1, String.valueOf(id));

            ResultSet rs = pre.executeQuery();
            user c = new user();
            if (rs.next()) {
            c.setId(rs.getInt("id"));
            c.setEmail(rs.getString("email"));
            c.setAdresse(rs.getString("adresse"));
            c.setNom(rs.getString("nom"));
            c.setGenre(rs.getString("genre"));
            c.setAge(rs.getInt("age"));
            c.setMdp(rs.getString("mdp"));
            c.setPrenom(rs.getString("prenom"));

            }
        return c;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;

    }
        
        
    }

    


    



