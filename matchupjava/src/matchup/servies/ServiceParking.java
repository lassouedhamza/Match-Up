
package matchup.servies;

import matchup.entities.Parking;
//import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import static java.awt.Event.INSERT;
import services.IServiceParking;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import static jdk.nashorn.internal.runtime.Debug.id;
import javax.mail.Session;
import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Transport;
import javax.mail.MessagingException;
import java.security.Security;
import connection.myconnection;

/**
 *
 * @author yousra
 */
public class ServiceParking  implements IServiceParking{
    private Connection cnx;
    private PreparedStatement ste;
    
     public ServiceParking() {
       cnx = myconnection.getInstance().getConnection();
    }
     
     ObservableList<Parking> ParkingList = FXCollections.observableArrayList();
     

    public ObservableList<Parking> getParkingList(){
   
         
    
        String query="select * from parking ";
        PreparedStatement pre;
        try {
            pre = cnx.prepareStatement(query);
             ResultSet rst =pre.executeQuery();
    
             while(rst.next())
            {   
                System.out.println(rst.getRow());
                int id_parking = rst.getInt("id_parking");
            int id = rst.getInt("id");
            String adresse = rst.getString("adresse");
            //String nom = rst.getString("nompark"); 
            int nbdeplace = rst.getInt("nbdeplace");
                
            
            Parking p = new Parking (id_parking, id, nbdeplace, adresse);
            ParkingList.add(p);
            }   } catch (SQLException ex) {
            Logger.getLogger(ServiceParking.class.getName()).log(Level.SEVERE, null, ex);
        } 
     
     return ParkingList;
    }
    
            

    @Override
    public void AddParking(Parking p) {
       String req ="INSERT INTO parking( `adresse`, `nbdeplace`)"+"values (?,?)";
        try {
            ste = cnx.prepareStatement(req);
            
           // ste.setInt(1, 1);
          
            ste.setString(1, p.getAdresse());
            ste.setInt(2, p.getNbdeplace());
            ste.executeUpdate();
            System.out.println("Parking ajoutée");
               } catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());
            
        }
        
    }
  
    @Override 
    public void ModifierParking(Parking p){

            String req = "UPDATE parking SET `nbdeplace`=? , `adresse`=?    where `id_parking`=?";
          
        try {
            ste = cnx.prepareStatement(req);
            ste.setInt(1,p.getNbdeplace());
            ste.setString(2,p.getAdresse());
           // ste.setString(3,p.getNom());
            ste.setInt(3,p.getId_parking());
            ste.executeUpdate();
            System.out.println("Maison de Retraite Updated !!!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 

    }



    @Override
    public List<Parking> AfficherParking() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    @Override
//    public void SupprimerParking(Parking p) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//    }


      public void SupprimerParking(Parking p){ 

        String req="DELETE FROM `parking` WHERE `id_parking`="+ p.getId_parking() ;
         try {
             ste = cnx.prepareStatement(req);
             ste.executeUpdate();
             System.out.println("parking bien supprimé");
             
             
             
         }catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());
        
    }
}

   
}



   
