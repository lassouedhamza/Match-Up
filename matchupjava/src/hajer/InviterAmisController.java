/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hajer;

import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.mail.Session;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 * FXML Controller class
 *
 * @author Hajer
 */
public class InviterAmisController implements Initializable {

    @FXML
    private TextField tfto;
    @FXML
    private TextArea tfmsg;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void envoyer(ActionEvent event) {

String aemail=tfto.getText();
        String fromemail="upmatch4@gmail.com";

         String Subject=" Invitation";
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
            
	      
          
     
            message.setText(tfmsg.getText());
            Transport.send(message);
                    System.out.println(fromemail);
        
         }catch(MessagingException ex){
            
        
    }
    
}
}
