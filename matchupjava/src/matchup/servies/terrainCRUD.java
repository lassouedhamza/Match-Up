/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matchup.servies;
import connection.myconnection;
import java.sql.Connection;
import java.util.List;
import services.iserviceterrain;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import matchup.entities.terrain;
/**
 *
 * @author Bedis
 */
public class terrainCRUD implements iserviceterrain {
    
    Connection cnx;

    public terrainCRUD() {
       cnx =myconnection.getInstance().getConnection();
    }
    
            
    @Override
    public void Addterrain(terrain t, int id) {
        try {
            Statement stm =cnx.createStatement();
      
       
       String query="INSERT INTO `terrain`(`id`,`nom_terrain`, `emplacement`, `type`, `etat`) VALUES ("+id+",'"+t.getNom_terrain()+"','"+t.getEmplacement()+"','"+t.getType()+"','"+t.getEtat()+"')";
        
       stm.executeUpdate(query);
       
       } catch (SQLException ex) {
            Logger.getLogger(terrainCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
ObservableList<terrain> terrainx = FXCollections.observableArrayList();

    @Override
    public List<terrain> afficherterrain() throws SQLException{
        
            Statement stm =cnx.createStatement();
        
         String query="select * from `terrain` " ;
            
         ResultSet rst =stm.executeQuery(query);
         List<terrain> terrainx ;
         terrainx = new ArrayList<>();
         
         
         while(rst.next())
         {
          terrain t =new terrain();
                t.setId_terrain(rst.getInt("id_terrain"));
                t.setNom_terrain(rst.getString("nom_terrain"));
                t.setEmplacement(rst.getString("emplacement"));
                t.setType(rst.getString("type"));
                t.setEtat(rst.getString("etat"));
               
                terrainx.add(t);
         
         }
        
        return terrainx;
        
    }

    @Override
    public void modifierterrain(terrain t) {
        try {
            Statement stm = cnx.createStatement();
              String query = "UPDATE  terrain  set nom_terrain = '"+t.getNom_terrain()+"', type = '"+t.getType()+"', emplacement = '"+t.getEmplacement()+"', etat ='"+t.getEtat()+"' WHERE id_terrain = "+t.getId_terrain()+" ;";
            
           
            stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(terrainCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
        @Override
    public void supprimerterrain(terrain t) {
        try {
            Statement stm = cnx.createStatement();
            String query = "DELETE FROM `terrain` WHERE id_terrain='"+t.getId_terrain()+"'";
            stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(terrainCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    public ObservableList<terrain> getterList()

   {
       ObservableList<terrain> terList = FXCollections.observableArrayList();
       String query = "SELECT * from terrain";
       Statement stm ;
       ResultSet rst;
       try{
           stm = cnx.createStatement();
           rst = stm.executeQuery(query);
           
           
       
           while (rst.next())
            {
                terrain t = new terrain();
                t.setId_terrain(rst.getInt("id_terrain"));
                t.setEmplacement(rst.getString("emplacement"));
                t.setEtat(rst.getString("etat"));
                t.setType(rst.getString("type"));
                
                t.setNom_terrain(rst.getString("nom_terrain"));
                terList.add(t);
            
       }
       }catch(Exception ex)
       {
           ex.printStackTrace();
       }
        return terList;
       
   }
}



