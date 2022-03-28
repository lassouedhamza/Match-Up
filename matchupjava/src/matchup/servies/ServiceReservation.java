/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matchup.servies;

import matchup.entities.Reservation;
import java.sql.Connection;
import java.sql.Date;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import services.IServiceReservation;
import connection.myconnection;

/**
 *
 * @author yousra
 */
public class ServiceReservation implements IServiceReservation{
        public Connection conn;
        public PreparedStatement st;

    public ServiceReservation() {
       conn = myconnection.getInstance().getConnection();
    }
    ObservableList<Reservation> ReservationList = FXCollections.observableArrayList();
    
    public ObservableList<Reservation> getReservationList(){

        String query="SELECT * FROM reservationparking ";
        PreparedStatement pre;
        try {
            pre = conn.prepareStatement(query);      
             ResultSet rst =pre.executeQuery();
            while(rst.next())
            {    
            int idrsvparking = rst.getInt("idrsvparking");
            int id = rst.getInt("id");
            int id_parking = rst.getInt("id_parking");
            
            Date date_d  = new Date(rst.getDate("date_d").getTime());
            Date date_f  = new Date(rst.getDate("date_f").getTime());
          //  Date date_f = rst.getTimestamp("date_time");
           // Date date_d = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(rst.getText("tfdated"));
            //rst.get
            System.out.println("------------");
            //System.out.println(rst.getString("tfdated"));
           Reservation r = new Reservation ( idrsvparking , id , id_parking , date_d , date_f);
             ReservationList.add(r);
            }   } catch (SQLException ex) {
            Logger.getLogger(ServiceReservation.class.getName()).log(Level.SEVERE, null, ex);
        } 
     
     return  ReservationList;
    }


    

//    @Override
    
    public void AjouterReservation(Reservation r){
        System.out.println("from 76" + r);
       String req ="INSERT INTO `reservationparking` (date_d, date_f)"+"values (?,?)";
       
        try {
            st = conn.prepareStatement(req);
            //ste.setInt(1, c.getId_categorie());
            st.setDate(1, r.getDate_d());
            st.setDate(2, r.getDate_f());
            st.executeUpdate();
            System.out.println("Reservation ajoutée");
               } 

              catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());
            
        }
        
    }
   @Override
    public void ModifierReservation(Reservation r) {

     String req = "UPDATE `reservationparking` SET `date_d`=?,`date_f`=?  where `idrsvparking`=?";
          
        try {
            st= conn.prepareStatement(req);
            System.out.print("r is " + r);
            st.setDate(1, r.getDate_d());
            st.setDate(2, r.getDate_f());
            st.setInt(3,r.getIdrsvparking());
            System.out.print(st);
            st.executeUpdate();
            System.out.println("Reservation est Modifiée!!!");
        } catch (SQLException ex) {
            System.out.print("++++" + ex);
            System.out.println(ex.getMessage());
        }      
    }
   @Override
    public void SupprimerReservation(Reservation r) {
        String req="DELETE FROM `reservationparking` WHERE `idrsvparking`="+ r.getIdrsvparking() ;
         try {
             st = conn.prepareStatement(req);
             st.executeUpdate();
             System.out.println("Reservation bien supprimé");
             
             
             
         }catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());
        
    }
        
    }

//    @Override
    public void AddReservation(Reservation r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
//    
//    public void sendEmail(int id) throws SQLException {
//        System.out.println("aaaaaaaa");
//        Sender's email ID needs to be mentioned
//      String from = "yosra.benarfa@esprit.tn";
//      final String username = "yosra.benarfa@esprit.tn";//change accordingly
//      final String password = "203JFT1066";//change accordingly
//       
//       String query = "select email from reservationparking";
//      
//       ResultSet rst;
//       System.out.println("bbbbbb"); // Create a default MimeMessage object.
//             Set From: header field of the header.
//             Set To: header field of the header.
//             Set Subject: header field
//             Now set the actual message
//             Send message
//            st = conn.prepareStatement(query);
//            rst = st.executeQuery(query);
//            while (rst.next())
//            {   System.out.println("ccccc");
//             Recipient's email ID needs to be mentioned.
//            String to = rst.getString("email");
//              String to = "arij.mazigh92@gmail.com";
//             Assuming you are sending email through relay.jangosmtp.net
//            String host = "smtavaxp.gmail.com";
//            Properties props = new Properties();
//            props.put("mail.smtp.auth", "true");
//            props.put("mail.smtp.starttls.enable", "true");
//            props.put("mail.smtp.host", host);
//            props.put("mail.smtp.port", "587");
////            
//////       Get the Session object.
//////Session session = Session.getInstance(props,
//////        new javax.mail.Authenticator() {
//////            
//////            protected PasswordAuthentication getPasswordAuthentication() {
//////                return new PasswordAuthentication(username, password);
//////            }
//////        } );}
////    }
//}



        

       
        
        
        
       
    }


