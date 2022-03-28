/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matchup.servies;

import connection.myconnection;
import matchup.entities.Matchs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import static javax.management.Query.match;
import javax.swing.Action;

/**
 *
 * @author Hajer
 */
public class ServiceMatch {
    
 private Connection cnx;
    private PreparedStatement ste;

    public ServiceMatch() {
      cnx = myconnection.getInstance().getConnection();
    }
    ObservableList<Matchs> MatchList = FXCollections.observableArrayList();
    
    public ObservableList<Matchs> getMatchList(){

        String query="select * from matchs ";
        PreparedStatement pre;
        try {
            pre = cnx.prepareStatement(query);
             ResultSet rs =pre.executeQuery();
            while(rs.next())
            {    
             int id_match = rs.getInt("id_match");
            String type = rs.getString("type");
            String date = rs.getString("date");
            int nbjoueur = rs.getInt("nbjoueurs");
                        Matchs m = new Matchs (id_match, type,date, nbjoueur);
            MatchList.add(m);
            }   } catch (SQLException ex) {
            Logger.getLogger(ServiceMatch.class.getName()).log(Level.SEVERE, null, ex);
        } 
     
     return MatchList;
    }
   public void AddMatch(Matchs m) {
      
            String req ="INSERT INTO `matchs`(`id_tournoi` , `id_terrain`,`type`, `date`, `nbjoueurs` )"+" VALUES(?,?,?,?,?)";
        try {
            ste = cnx.prepareStatement(req);
             ste.setInt(1,13);
            ste.setInt(2,m.getId_terrain());
            ste.setString(3,m.getType());
//              ste.setDate(3, new java.sql.Date(m.getDate().getTime()));
               ste.setString(4,m.getDate());
            ste.setInt(5,m.getNbjoueurs());
          
            
            ste.executeUpdate();
            System.out.println("Match ajoutée");
        } catch (SQLException ex) {
            System.out.println("Problème");
            System.out.println(ex.getMessage());
            
        } 
    }
  
    public List<Matchs> AfficherMatch() throws SQLException {
         Statement stm =cnx.createStatement();
        
         String query="select * from `matchs` " ;
            
         ResultSet rst =stm.executeQuery(query);
         List<Matchs> matchs ;
         matchs = new ArrayList<>();
         
         
         while(rst.next())
         { Matchs m =new Matchs();
                m.setType(rst.getString("type"));
                m.setDate(rst.getString("date"));
                m.setNbjoueurs(rst.getInt("nbjoueurs"));
      
                matchs.add(m);
         
         }
        
        return matchs;
    }

public ObservableList<Matchs> getterList()

   {
       ObservableList<Matchs> matchList = FXCollections.observableArrayList();
       String query = "SELECT * from `matchs`";
       Statement stm ;
       ResultSet rst;
       try{
           stm = cnx.createStatement();
           rst = stm.executeQuery(query);
           
           
       
           while (rst.next())
            {
                Matchs m = new Matchs();
                m.setType(rst.getString("type"));
                m.setDate(rst.getString("date"));
                m.setNbjoueurs(rst.getInt("nbjoueurs"));
                matchList.add(m);  
       }
       }catch(Exception ex)
       {
           ex.printStackTrace();
       }
        return matchList;
       
   }
}





