/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matchup.servies;



import connection.myconnection;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import matchup.entities.Produit;
import services.IServicesProduit;


/**
 *
 * @author Asus
 */
public class ServiceProduit implements IServicesProduit {
     private Connection cnx;
    private PreparedStatement ste;

    public ServiceProduit() {
      cnx = myconnection.getInstance().getConnection();
    }
    ObservableList<Produit> ProduitList = FXCollections.observableArrayList();
   
    public ObservableList<Produit> getProduitList(){

        String query="select * from produit ";
        PreparedStatement pre;
        try {
            pre = cnx.prepareStatement(query);
             ResultSet rst =pre.executeQuery();
            while(rst.next())
            {    
            int id_produit = rst.getInt("id_produit");
            int id = rst.getInt("id");
            int id_categorie = rst.getInt("id_categorie");
            String nom_produit = rst.getString("nom_produit");
            int prix = rst.getInt("prix");
            int quantite_total = rst.getInt("quantite_total");
            int quantite_restant = rst.getInt("quantite_restant"); 
            String description = rst.getString("description");
            String photo = rst.getString("path");
            Produit p = new Produit (id_produit,id,prix,quantite_total,quantite_restant,id_categorie,nom_produit,description,photo );
            ProduitList.add(p);
            }   } catch (SQLException ex) {
            Logger.getLogger(ServiceCategorie.class.getName()).log(Level.SEVERE, null, ex);
        } 
     
     return  ProduitList;
    }
    @Override
    public void AddProduit(Produit p,int id) {
       
      String req="INSERT INTO produit(id,id_categorie,nom_produit,prix,quantite_total,quantite_restant,description,path)"+" VALUES (?,?,?,?,?,?,?,?)";
         try {
            ste = cnx.prepareStatement(req);
            //ste.setInt(1, p.getId_produit());
            ste.setInt(1,id);
            ste.setInt(2,1);
            ste.setString(3,p.getNom_produit());
            ste.setInt(4,p.getPrix());
            ste.setInt(5,p.getQuantite_total());
            ste.setInt(6,p.getQuantite_restant());
            ste.setString(7,p.getDescription());
            ste.setString(8,p.getPhoto());
            
            ste.executeUpdate();
            System.out.println("Produit ajoutée");
               } catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());
            
        }
        
    }

    
    

    @Override
    public void ModifierProduit(Produit p) {
            String req = "UPDATE produit SET `nom_produit`=? , `prix`=? , `quantite_total`=? , `quantite_restant`=? , `description`=?  where `id_produit`=?";
          
        try {
            ste = cnx.prepareStatement(req);

            ste.setString(1,p.getNom_produit());
            ste.setInt(2,p.getPrix());
            ste.setInt(3,p.getQuantite_total());
            ste.setInt(4,p.getQuantite_restant());
            ste.setString(5,p.getDescription());
            ste.setInt(6,p.getId_produit());
            
            
            ste.executeUpdate();
            System.out.println("Maison de Retraite Updated !!!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
    }

    @Override
    public void SupprimerProduit(Produit p) {
        String req="DELETE FROM `produit` WHERE `id_produit`="+ p.getId_produit() ;
         try {
             ste = cnx.prepareStatement(req);
             ste.executeUpdate();
             System.out.println("Produit bien supprimé");
             
             
             
         }catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());
        
         }
        
    
        
    }
//      public float TotalPrise(int id) throws SQLException{
//               float total =0.0f;
//               PreparedStatement pst;
//               String requete = "SELECT (prix * (quantite_total - quantite_restant)) FROM produit WHERE id_produit = '" + id + "'";
//               pst = cnx.prepareStatement(requete);
//               ResultSet rs = pst.executeQuery(requete);
//               while (rs.next()) {
//                 total = rs.getFloat(1);}
//               System.out.println("😃😈 calculated total 😍 succeeds 😈😃");
//                    return total;
//           //ça est y
//             }
       public float TotalProduct() throws SQLException{
                float totalproduct=0.0f;
                PreparedStatement pst;
                String requete = "SELECT COUNT(quantite_total) FROM produit ";
                pst = cnx.prepareStatement(requete);
                ResultSet rs = pst.executeQuery(requete);
                while (rs.next()) {
                   totalproduct = rs.getFloat(1);}
                System.out.println("😃😈 total product😍 succeeds 😈😃");
                return totalproduct;
                
       }
           public float SalesRate(int id) throws SQLException{
                 float SalesRate = 0.0f;
                 PreparedStatement pst;
                 String requete = "SELECT (((quantite_total-quantite_restant) /quantite_total)*100) FROM produit WHERE id_produit = '" + id + "'";
                 pst = cnx.prepareStatement(requete);
                 ResultSet rs = pst.executeQuery(requete);
                 while (rs.next()) {
                    SalesRate = rs.getFloat(1);}
                 System.out.println("😃😈 calculated SalesRate 😍 succeeds 😈😃");
                 return SalesRate;
                    
     
   
               }

    @Override
    public List<Produit> AfficherProduit() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public InputStream getPhotoProduit(int idP){
        InputStream photo = null;
        PreparedStatement pst;
        try {
            String req = "SELECT path FROM `produit` WHERE id = '" + idP + "'";
            pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            if (rs.first()) {

                photo = rs.getBinaryStream("photo");
//                System.out.println("photo retrieved");
            }

        } catch (SQLException ex) {
            Logger.getLogger(ServiceProduit.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Echec get photo");

        }
        return photo;
    }

    @Override
    public Image getPhoto(int idP) {
        PreparedStatement pst;
         InputStream photo = null;
        try {
            photo = new FileInputStream("src/Images/produit_icon.png");
            String req = "SELECT path FROM `produit` WHERE id_produit = '" + idP + "'";
            pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            if (rs.first()) {
                photo = rs.getBinaryStream("path");
            }
            return new Image(photo);

        } catch (SQLException | FileNotFoundException ex) {
            Logger.getLogger(ServiceProduit.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Echec get photo");

        }
        return new Image(photo);
    }
        
   

  
    
    
    
}
