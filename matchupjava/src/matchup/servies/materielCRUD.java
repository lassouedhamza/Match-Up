/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matchup.servies;

/**
 *
 * @author Bedis
 */
import connection.myconnection;
import java.sql.Connection;
import java.util.List;
import services.iservicemateriel;

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
import matchup.entities.materiel;
import services.iservicemateriel;

/**
 *
 * @author Bedis
 */
public class materielCRUD  implements iservicemateriel {
    
    Connection cnx;

    public materielCRUD() {
       cnx =myconnection.getInstance().getConnection();
    }

    @Override
    public void Addmateriel(materiel t) {
        try {
            Statement stm =cnx.createStatement();
      
       
       String query="INSERT INTO `materiel`(`id_materiel`, `nom_terrain`, `type_mat`, `quant_mat`, `id_terrain`) VALUES ("+t.getId_materiel()+",'"+t.getNom_terrain()+"','"+t.getType_mat()+"',"+t.getQuant_mat()+","+t.getId_terrain()+")";
        
       stm.executeUpdate(query);
       
       } catch (SQLException ex) {
            Logger.getLogger(materielCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
ObservableList<materiel> materielx = FXCollections.observableArrayList();
    @Override
    public List<materiel> affichermateriel() throws SQLException {
          Statement stm =cnx.createStatement();
        
         String query="select * from `materiel` " ;
            
         ResultSet rst =stm.executeQuery(query);
         List<materiel> materielx ;
         materielx = new ArrayList<>();
         
         
         while(rst.next())
         {
          materiel m =new materiel();
                m.setId_materiel(rst.getInt("id_materiel"));
                m.setNom_terrain(rst.getString("nom_terrain"));
                m.setType_mat(rst.getString("type_mat"));
                m.setQuant_mat(rst.getInt("quant_mat"));
                m.setId_terrain(rst.getInt("id_terrain"));
                
               
                materielx.add(m);
         
         }
        
        return materielx;
    }

    @Override
    public void modifiermateriel(materiel t) {
         try {
            Statement stm = cnx.createStatement();
              String query = "UPDATE  materiel  set type_mat = '"+t.getType_mat()+"', quant_mat = "+t.getQuant_mat()+" WHERE id_materiel= "+t.getId_materiel()+" ;";
            
           
            stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(materielCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void supprimermateriel(materiel m) {
        try {
            Statement stm = cnx.createStatement();
            String query = "DELETE FROM `materiel` WHERE id_materiel='"+m.getId_materiel()+"'";
            stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(materielCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ObservableList<materiel> getmatList() 
    {
        
        ObservableList<materiel> matList = FXCollections.observableArrayList();
       String query = "SELECT * from materiel";
       Statement stm ;
       ResultSet rst;
       try{
           stm = cnx.createStatement();
           rst = stm.executeQuery(query);
           
           
       
           while (rst.next())
            {
                materiel m = new materiel();
                m.setId_materiel(rst.getInt("id_materiel"));
                m.setType_mat(rst.getString("type_mat"));
                m.setQuant_mat(rst.getInt("quant_mat"));
                m.setNom_terrain(rst.getString("nom_terrain"));
                m.setId_terrain(rst.getInt("id_terrain"));
                matList.add(m);
            
       }
       }catch(Exception ex)
       {
           ex.printStackTrace();
       }
        return matList;
       
    }}

   