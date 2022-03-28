/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matchup.servies;
import connection.myconnection;
import java.sql.Connection;
import java.util.List;
import services.iservicerester;

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
import matchup.entities.rester;

/**
 *
 * @author Bedis
 */
public class resterCRUD implements iservicerester {
    
    Connection cnx;

    public resterCRUD() {
       cnx =myconnection.getInstance().getConnection();
    }
    
            
    @Override
    public void Addrester(rester r ,int id) {
        try {
            Statement stm =cnx.createStatement();
      
       
       String query="INSERT INTO `resterrain`(`id`,`date_res`, `nom_terrain`, `id_terrain`) VALUES ("+id+",'"+r.getDate_res()+"','"+r.getNom_ter()+"',"+r.getId_terrain()+")";
        
       stm.executeUpdate(query);
       
       } catch (SQLException ex) {
            Logger.getLogger(terrainCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
ObservableList<rester> resterx = FXCollections.observableArrayList();

    @Override
    public List<rester> afficherrester() throws SQLException{
        
            Statement stm =cnx.createStatement();
        
         String query="select * from `resterrain` " ;
            
         ResultSet rst =stm.executeQuery(query);
         List<rester> resterx ;
         resterx = new ArrayList<>();
         
         
         while(rst.next())
         {
          rester r =new rester();
                
                r.setDate_res(rst.getString("date_res"));
                r.setNom_ter(rst.getString("nom_terrain"));
                
                
                resterx.add(r);
         
         }
        
        return resterx;
        
    }

    @Override
    public void modifierrester(rester r) {
        try {
            Statement stm = cnx.createStatement();
              String query = "UPDATE  resterrain  set date_res = '"+r.getDate_res()+"', nom_terrain = '"+r.getNom_ter()+"' WHERE id_rester = "+r.getId_rester()+" ;";
            
           
            stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(terrainCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
        @Override
    public void supprimerrester(rester r) {
        try {
            Statement stm = cnx.createStatement();
            String query = "DELETE FROM `resterrain` WHERE id_rester='"+r.getId_rester()+"'";
            stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(terrainCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    public ObservableList<rester> getresList()

   {
       ObservableList<rester> resList = FXCollections.observableArrayList();
       String query = "SELECT * from resterrain";
       Statement stm ;
       ResultSet rst;
       try{
           stm = cnx.createStatement();
           rst = stm.executeQuery(query);
           
           
       
           while (rst.next())
            {
                rester r = new rester();
                r.setId_rester(rst.getInt("id_rester"));
                r.setDate_res(rst.getString("date_res"));
                r.setNom_ter(rst.getString("nom_terrain"));
                r.setId_terrain(rst.getInt("id_terrain"));
                
                
                resList.add(r);
            
       }
       }catch(Exception ex)
       {
           ex.printStackTrace();
       }
        return resList;
       
   }

    @Override
    public boolean verif(rester r) {
        
        try {

               Statement stm = cnx.createStatement();
               String query="select * from resterrain where nom_terrain = '"+r.getNom_ter()+"' and date_res = '"+r.getDate_res()+"'"; 
               ResultSet rs;
    rs=stm.executeQuery(query);
    rester rester ;
    try {
                   while(rs.next())
                   {
                       rester = new rester(rs.getString("nom_terrain"),rs.getString("date_res"));
                       
                       return true;

                   }          } catch (SQLException ex) {
                   Logger.getLogger(resterCRUD.class.getName()).log(Level.SEVERE, null, ex);
               }
}          catch (SQLException ex) {
               Logger.getLogger(resterCRUD.class.getName()).log(Level.SEVERE, null, ex);
           }
return false;
    }

    public ObservableList<rester> getterList() {
         ObservableList<rester> resList = FXCollections.observableArrayList();
       String query = "SELECT * from resterrain";
       Statement stm ;
       ResultSet rst;
       try{
           stm = cnx.createStatement();
           rst = stm.executeQuery(query);
           
           
       
           while (rst.next())
            {
                rester r = new rester();
                r.setNom_ter(rst.getString("nom_terrain"));
                r.setDate_res(rst.getString("date_res"));
                
               
                resList.add(r);
            
       }
       }catch(Exception ex)
       {
           ex.printStackTrace();
       }
        return resList;
    }

}



