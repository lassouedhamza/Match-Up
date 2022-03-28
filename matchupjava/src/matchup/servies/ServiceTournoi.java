/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matchup.servies;

import Entites.Tournoi;
import connection.myconnection;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import services.IServiceTournoi;


/**
 *
 * @author Hajer
 */
public class ServiceTournoi implements IServiceTournoi{
     private Connection cnx;
    private PreparedStatement ste;
        public ServiceTournoi() {
         cnx = myconnection.getInstance().getConnection();
    }
    ObservableList<Tournoi> TournoiList = FXCollections.observableArrayList();
    
    public ObservableList<Tournoi> getTournoiList(){

        String query="select * from tournoi ";
        PreparedStatement pre;
        try {
            pre = cnx.prepareStatement(query);
             ResultSet rs =pre.executeQuery();
            while(rs.next())
            {    
             int id_tournoi = rs.getInt("id_tournoi");
            String nom_tournoi = rs.getString("nom_tournoi");
            String type = rs.getString("type");
   
            Tournoi t = new Tournoi (id_tournoi, nom_tournoi, type);
            TournoiList.add(t);
            }   } catch (SQLException ex) {
            Logger.getLogger(ServiceMatch.class.getName()).log(Level.SEVERE, null, ex);
        } 
     
     return TournoiList;
    }

    @Override
    public void AddTournoi(Tournoi t,int id) {
        String req ="INSERT INTO `tournoi`(`id`,`nom_tournoi`,`type`)"+" VALUES(?,?,?)";
        try {
            ste = cnx.prepareStatement(req);
            ste.setInt(1,id);
            ste.setString(2,t.getNom_tournoi());
            ste.setString(3,t.getType());
            ste.executeUpdate();
            System.out.println("Tournoi ajoutée");
        } catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());
        }
        
    } 
    @Override
    public List<Tournoi> affichertournoi() throws SQLException {
        Statement stm =cnx.createStatement();
        
         String query="select * from `tournoi` " ;
            
         ResultSet rst =stm.executeQuery(query);
         List<Tournoi> tournois ;
         tournois = new ArrayList<>();
         
         
         while(rst.next())
         { Tournoi t =new Tournoi();
                t.setNom_tournoi(rst.getString("nom_tournoi"));
                t.setType(rst.getString("type"));
               
      
                tournois.add(t);
         
         }
        
        return tournois;
    }
        

@Override
     public void modifierTournoi(Tournoi t) {
       

            
        String req = "UPDATE tournoi SET `nom_tournoi`=?,`type`=? WHERE `id_tournoi`='"+t.getId_tournoi()+"'";
           
        try {
            ste = cnx.prepareStatement(req);

            ste.setString(1, t.getNom_tournoi());
            ste.setString(2, t.getType());
            
            ste.executeUpdate();
            System.out.println("Tournoi modifié !!!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

     }
     @Override
    public void SupprimerOnClick(Tournoi t) {
        
         try {
             Statement stm = cnx.createStatement();
             String req="DELETE FROM `tournoi` WHERE `id_tournoi`='"+t.getId_tournoi()+"'";
            
//             ste = cnx.prepareStatement(req);
             stm.executeUpdate(req);
             System.out.println("Tournoi bien supprimé");
         }catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage()); 
    }
    }


    @Override
    public ObservableList<Tournoi> getterList() {
 ObservableList<Tournoi> tournoiList = FXCollections.observableArrayList();
       String query = "SELECT * from `tournoi`";
       Statement stm ;
       ResultSet rst;
       try{
           stm = cnx.createStatement();
           rst = stm.executeQuery(query);
           
           
       
           while (rst.next())
            {
                Tournoi t = new Tournoi();
                t.setId_tournoi(rst.getInt("id_tournoi"));
                t.setNom_tournoi(rst.getString("nom_tournoi"));
                t.setType(rst.getString("type"));
             
             
                tournoiList.add(t);
            
       }
       }catch(Exception ex)
       {
           ex.printStackTrace();
       }
        return tournoiList;
       
   }
    }
    
        
    



    
    

