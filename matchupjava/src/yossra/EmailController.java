

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yossra;

import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * FXML Controller class
 *
 * @author yousra
 */
public class EmailController implements Initializable {

    @FXML
    private Button tfsend;
    @FXML
    private Button tfretour;
    @FXML
    private TextField tfto;
    @FXML
    private TextField tfsub;
    @FXML
    private TextArea tfmesg;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }    
     
    @FXML
    private void sendemail(ActionEvent event) throws AddressException, MessagingException{
      String aemail=tfto.getText();
        String fromemail="upmatch4@gmail.com";

         String Subject=tfsub.getText();
        String emailpassword="matchup2021@";//your email password
        Properties properties=new Properties();
        properties.put("mail.smtp.auth","true" );
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.ssl.trust","*");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        Session session=Session.getDefaultInstance(properties,new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
               
                return new PasswordAuthentication(fromemail,emailpassword);
                
            }
});
        
        
        try{
            
            MimeMessage message=new MimeMessage(session);
            message.setFrom(new InternetAddress(fromemail));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(aemail));
            message.setSubject(Subject);
            
	      
          
     
            message.setText(tfmesg.getText());
            Transport.send(message);
                    System.out.println(fromemail);
        
         }catch(MessagingException ex){
            
        
    }  
    }
      @FXML
    private void retour(ActionEvent event) {
           try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Reservation.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);        
            ((Stage)((Node)event.getTarget()).getScene().getWindow()).setScene(scene);
        }catch(Exception e){
            System.out.println(e);
        }
    }

 
    
}

