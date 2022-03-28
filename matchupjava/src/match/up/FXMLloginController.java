/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package match.up;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import connection.myconnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Properties;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import matchup.entities.user;
import matchup.entities.utilisateur;
import matchup.servies.Data;

import matchup.servies.utilisateurCRUD;

/**
 * FXML Controller class
 *
 * @author tpc
 */
public class FXMLloginController implements Initializable {
private Connection cnx;
    private PreparedStatement ste;
    @FXML
    private Pane pane1;
    @FXML
    private Pane pane2;
    @FXML
    private Pane pane3;
    @FXML
    private Pane pane4;
    @FXML
    private JFXTextField email;
    @FXML
    private JFXPasswordField mdp;
public String x;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
        pane1.setStyle("-fx-background-image: url(\"/images/44.jpg\")");
        pane2.setStyle("-fx-background-image: url(\"/images/11.jpg\")");
        pane3.setStyle("-fx-background-image: url(\"/images/99.jpg\")");
        pane4.setStyle("-fx-background-image: url(\"/images/44.jpg\")");



        backgroundAnimation();

    }

    private void backgroundAnimation() {

        FadeTransition fadeTransition=new FadeTransition(Duration.seconds(3),pane4);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.play();

        fadeTransition.setOnFinished(event -> {

            FadeTransition fadeTransition1=new FadeTransition(Duration.seconds(3),pane3);
            fadeTransition1.setFromValue(1);
            fadeTransition1.setToValue(0);
            fadeTransition1.play();

            fadeTransition1.setOnFinished(event1 -> {
                FadeTransition fadeTransition2=new FadeTransition(Duration.seconds(3),pane2);
                fadeTransition2.setFromValue(1);
                fadeTransition2.setToValue(0);
                fadeTransition2.play();

                fadeTransition2.setOnFinished(event2 -> {

                   FadeTransition fadeTransition0 =new FadeTransition(Duration.seconds(3),pane2);
                    fadeTransition0.setToValue(1);
                    fadeTransition0.setFromValue(0);
                    fadeTransition0.play();

                    fadeTransition0.setOnFinished(event3 -> {

                        FadeTransition fadeTransition11 =new FadeTransition(Duration.seconds(3),pane3);
                        fadeTransition11.setToValue(1);
                        fadeTransition11.setFromValue(0);
                        fadeTransition11.play();

                        fadeTransition11.setOnFinished(event4 -> {

                            FadeTransition fadeTransition22 =new FadeTransition(Duration.seconds(3),pane4);
                            fadeTransition22.setToValue(1);
                            fadeTransition22.setFromValue(0);
                            fadeTransition22.play();

                            fadeTransition22.setOnFinished(event5 -> {
                                backgroundAnimation();
                            });

                        });

                    });

                });
            });

        });

    }


//    @FXML
//    private void login(ActionEvent event) {
//        cnx = myconnection.getInstance().getConnection();
//    	Parent root;
//        PreparedStatement pre;
//        	try {
//        	String req =  "select * from user where email = '"+email.getText()+"' and mdp = '"+ mdp.getText()+"'" ;
//	      
//          pre = cnx.prepareStatement(req);
//             ResultSet rs =pre.executeQuery();
//            
//	        int i = 0;
//	        while (rs.next()) {
//	        	i++;	 
//	        }
//	         if (i==1) {
//	        	
//		       try{
//                           utilisateur cu= new utilisateur();
////            UserSession.getInstance2();
////            UserSession.getInstace(cu.getEmail(email.getText()),cu.getMdp(mdp.getText()));
//		            FXMLLoader loader = new FXMLLoader();
//                            loader.setLocation(getClass().getResource("FXMLprofileuser.fxml"));
//                            root = loader.load();
////                            FXMLprofileuserController ICC = loader.getController();
////              ICC.setemail(email.getText());
//                            Scene scene = new Scene(root);        
//                            ((Stage)((Node)event.getTarget()).getScene().getWindow()).setScene(scene);
//		            }
//		            catch (IOException e) {
//		                e.printStackTrace();
//		            }
//	         }else {
//	            Alert alert = new Alert(Alert.AlertType.ERROR);
//                    alert.setHeaderText(null);
//                    alert.setContentText("Veuillez vérifier votre Identifiant et votre Mot de passe !");
//                    alert.showAndWait();
//	         }
//        }catch(Exception e) {
//        	System.out.println(e);
//        }
//    }
    public String generate(int id) {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = id;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        System.out.println(generatedString);

        return generatedString;
    }

// private void user_redirection(){
//        try {
//            CrudUser cu= new CrudUser();
//            UserSession.getInstance2();
//            UserSession.getInstace(cu.idUser(TextField_login.getText()), TextField_login.getText(), TextField_password.getText(), cu.typeUser(TextField_login.getText()));
//            if(cu.connectionUser(TextField_login.getText(), TextField_password.getText()) && cu.typeUser(TextField_login.getText()).equals("client")  )
//            {
//                try {
//                    FXMLLoader loader= new FXMLLoader(getClass().getResource("/Views/InterfaceClient.fxml"));
//                    Parent root= loader.load();
//                    InterfaceClientController ICC = loader.getController();
//                    ICC.setLogin(TextField_login.getText());
//                    ICC.setNom(TextField_login.getText());
//                    ICC.setPrenom(TextField_login.getText());
//                    //ICC.setId(TextField_login.getText());
//                    Button_Singin.getScene().setRoot(root);
//                } catch (IOException ex) {
//                    Logger.getLogger(InterfaceSingInController.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//            else if(cu.connectionUser(TextField_login.getText(), TextField_password.getText()) && cu.typeUser(TextField_login.getText()).equals("conducteur")  )
//            {
//                try {
//                    FXMLLoader loader= new FXMLLoader(getClass().getResource("/Views/InterfaceClient.fxml"));
//                    Parent root= loader.load();
//                    InterfaceClientController ICC = loader.getController();
//                    ICC.setLogin(TextField_login.getText());
//                    ICC.setNom(TextField_login.getText());
//                    ICC.setPrenom(TextField_login.getText());
//                    //ICC.setId(TextField_login.getText());
//                    Button_Singin.getScene().setRoot(root);
//                } catch (IOException ex) {
//                    Logger.getLogger(InterfaceSingInController.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//     
//            
//            
//     
//            else if(cu.connectionUser(TextField_login.getText(), TextField_password.getText()) && cu.typeUser(TextField_login.getText()).equals("admin"))
//            {
//                try {
//                    FXMLLoader loader= new FXMLLoader(getClass().getResource("/Views/InterfaceAdminAcceuil.fxml"));
//                    Parent root= loader.load();
//                    InterfaceAdminAcceuilController IMAC  = loader.getController();
////                    IAC.setId(TextField_login.getText());
////                    IAC.setLogin(TextField_login.getText());
//                    Button_Singin.getScene().setRoot(root);
//                } catch (IOException ex) {
//                    Logger.getLogger(InterfaceSingInController.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//            else{
//        Alert alert = new Alert(Alert.AlertType.ERROR);
//        alert.setTitle("Connecxion Echoué");
//        alert.setHeaderText("Vérifier votre  login et votre mot de passe");
//        //alert.setContentText("Are you ok with this?");
//
//        Optional<ButtonType> result = alert.showAndWait();
//            }
//        } catch (Exception ex) {
//            Logger.getLogger(InterfaceSingInController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
   @FXML
    private void passForgotten(ActionEvent event) throws IOException, SQLException, InterruptedException {
        String login = email.getText();
        String res = "";
        TextInputDialog dialog = new TextInputDialog(login);
        dialog.setTitle("mot de passe oublie");
        dialog.setHeaderText("votre mot de passe sera changer, confirmer");
        dialog.setContentText(" entrer votre email");
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            res = result.get();
////            String rand = generate(7);
////            SendingMail sm = new SendingMail("Ceci est le code de votre compte " + rand, res, "");
////            SendingMail.sendMail();

String aemail=res;
        String fromemail="upmatch4@gmail.com";
        System.out.println(res);
         String Subject=" mot de passe";
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
            utilisateurCRUD us = new utilisateurCRUD();
        user u = us.login(email.getText().toString(), mdp.getText().toString());
       u.setEmail(email.getText().toString());
                            cnx = myconnection.getInstance().getConnection();
//    	Parent root;
        PreparedStatement pre;
     
            MimeMessage message=new MimeMessage(session);
            message.setFrom(new InternetAddress(fromemail));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(aemail));
            message.setSubject(Subject);
            String req =  "select * from user where email = '"+res+"'" ;
	      
          pre = cnx.prepareStatement(req);
             ResultSet rs =pre.executeQuery();
             int i = 0;
	        while (rs.next()) {
	        	i++;	 
	        }
	         if (i==1) {
	        	Data.user = u;
                       
                        System.out.println( u.getMdp());
                 }
            message.setText("votre mot de passe est "+u.getMdp());
            Transport.send(message);
                    System.out.println(fromemail);
            
        
        
    }catch(MessagingException ex){
            System.out.println(""+ex);
        
    }
                
        }



    }

    @FXML
    private void login(ActionEvent event) throws SQLException {
        utilisateurCRUD us = new utilisateurCRUD();
        user u = us.login(email.getText().toString(), mdp.getText().toString());
       u.setEmail(email.getText().toString());
         cnx = myconnection.getInstance().getConnection();
    	Parent root;
//        PreparedStatement pre;
                cnx = myconnection.getInstance().getConnection();
//    	Parent root;
        PreparedStatement pre;
        	try {
        	String req =  "select * from user where email = '"+email.getText()+"' and mdp = '"+ mdp.getText()+"'" ;
	      
          pre = cnx.prepareStatement(req);
             ResultSet rs =pre.executeQuery();
            
	        int i = 0;
	        while (rs.next()) {
	        	i++;	 
	        }
	         if (i==1) {
	        	Data.user = u;
                        System.out.println(u.getIs_verified());
                        System.out.println(u.getRoles());
		       try{
                           
                          if (u.getRoles().equals("["+'"'+"ROLE_UTI"+'"'+"]")) {
                              
                               FXMLLoader loader = new FXMLLoader();
                            loader.setLocation(getClass().getResource("FXMLprofileuser.fxml"));
                            root = loader.load();

                            Scene scene = new Scene(root);        
                            ((Stage)((Node)event.getTarget()).getScene().getWindow()).setScene(scene);
		            
                              
//                              FXMLLoader loader = new FXMLLoader();
//                Parent fxml = FXMLLoader.load(getClass().getResource("FXMLprofileuser.fxml"));
//                 root = loader.load();
//                 Scene scene = new Scene(root);        
//                            ((Stage)((Node)event.getTarget()).getScene().getWindow()).setScene(scene);
            //Parent fxml = FXMLLoader.load(getClass().getResource("UI.fxml"));
           
            } else if (u.getRoles().equals("["+'"'+"ROLE_PRO"+'"'+"]")) {
                              
                               FXMLLoader loader = new FXMLLoader();
                            loader.setLocation(getClass().getResource("FXMLprofileprop.fxml"));
                            root = loader.load();

                            Scene scene = new Scene(root);        
                            ((Stage)((Node)event.getTarget()).getScene().getWindow()).setScene(scene);
            
            } else if (u.getRoles().equals("["+'"'+"ROLE_ADMIN"+'"'+"]")) {
                              
                               FXMLLoader loader = new FXMLLoader();
                            loader.setLocation(getClass().getResource("FXMLAdminuser.fxml"));
                            root = loader.load();

                            Scene scene = new Scene(root);        
                            ((Stage)((Node)event.getTarget()).getScene().getWindow()).setScene(scene);
           
            }
		            }
		            catch (IOException e) {
		                e.printStackTrace();
		            }
	         }else {
	            Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setContentText("Veuillez vérifier votre Identifiant et votre Mot de passe !");
                    alert.showAndWait();
	         }
        }catch(Exception e) {
        	System.out.println(e);
        }
    }
    
}
