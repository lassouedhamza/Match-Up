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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import matchup.entities.Categorie;
import services.IservicesCategorie;

/**
 *
 * @author Asus
 */
public class ServiceCategorie  implements IservicesCategorie {
    public Connection cnx;
    public PreparedStatement ste;

    public ServiceCategorie() {
        cnx = myconnection.getInstance().getConnection();
    }
    ObservableList<Categorie> CategorieList = FXCollections.observableArrayList();
    
    public ObservableList<Categorie> getCategorieList(){

        String query="select * from categorie ";
        PreparedStatement pre;
        try {
            pre = cnx.prepareStatement(query);
             ResultSet rst =pre.executeQuery();
            while(rst.next())
            {    
            int id_categorie = rst.getInt("id_categorie");
            String nom_categorie = rst.getString("nom_categorie");
            Categorie c = new Categorie (id_categorie,nom_categorie);
             CategorieList.add(c);
            }   } catch (SQLException ex) {
            Logger.getLogger(ServiceCategorie.class.getName()).log(Level.SEVERE, null, ex);
        } 
     
     return  CategorieList;
    }
       public List<Categorie> trier() {
        List<Categorie> list = new ArrayList<>();

        try {
            String requete = "SELECT * FROM categorie order by nom_categorie ASC ";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new Categorie(rs.getInt(1), rs.getString("nom_categorie")));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;
    }
    
@Override
    public void AddCategorie(Categorie c) {
       String req ="INSERT INTO categorie (nom_categorie)"+"values (?)";
       
        try {
            ste = cnx.prepareStatement(req);
            //ste.setInt(1, c.getId_categorie());
            ste.setString(1, c.getNom_categorie());
            ste.executeUpdate();
            System.out.println("Categorie ajoutée");
               } catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());
            
        }
        
    }
  
    @Override
    public List<Categorie> AfficherCategorie() throws SQLException {
         Statement stm =cnx.createStatement();
        
         String query="select * from `categorie` " ;
            
         ResultSet rst =stm.executeQuery(query);
         List<Categorie> categories ;
         categories = new ArrayList<>();
         
         
         while(rst.next())
         {
          Categorie c =new Categorie();
                c.setId_categorie(rst.getInt("id_categorie"));
                c.setNom_categorie(rst.getString("nom_categorie"));
               
               
                categories.add(c);
         
         }
        
        return categories;
    }

    @Override
    public void ModifierCategorie(Categorie c) {
     String req = "UPDATE categorie SET `nom_categorie`=? where `id_categorie`=?";
          
        try {
            ste = cnx.prepareStatement(req);

            ste.setString(1,c.getNom_categorie());
            ste.setInt(2,c.getId_categorie());
            ste.executeUpdate();
            System.out.println("Maison de Retraite Updated !!!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }      
    }
    @Override
    public void SupprimerCategorie(Categorie c) {
        String req="DELETE FROM `categorie` WHERE `id_categorie`="+ c.getId_categorie() ;
         try {
             ste = cnx.prepareStatement(req);
             ste.executeUpdate();
             System.out.println("Categorie bien supprimé");
             
             
             
         }catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());
        
    }
        
    }
    
}

