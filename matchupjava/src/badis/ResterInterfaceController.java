/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package badis;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import matchup.servies.terrainCRUD;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import java.net.URL;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import matchup.servies.materielCRUD;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collector;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Callback;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import matchup.entities.rester;
import matchup.entities.terrain;
import matchup.entities.user;
import matchup.servies.Data;

import matchup.servies.resterCRUD;
import matchup.servies.utilisateurCRUD;

/**
 * FXML Controller class
 *
 * @author Bedis
 */
public class ResterInterfaceController implements Initializable {
    ObservableList<ObservableList> data = FXCollections.observableArrayList();
     public static String selectedname="";
     public static Integer selectedid;
     //song
     String path = "C:\\Users\\tpc\\Documents\\NetBeansProjects\\match-up\\src\\badis\\yes.mp3";
     String path2 = "C:\\Users\\tpc\\Documents\\NetBeansProjects\\match-up\\src\\badis\\no.mp3";
                Media media = new Media(new File(path).toURI().toString() );
                MediaPlayer mediaPlayer = new MediaPlayer(media);
                Media media2 = new Media (new File(path2).toURI().toString());
                MediaPlayer mediaPlayer2 = new MediaPlayer (media2);
     public static String recepient="";
     
     

    @FXML
    private ImageView homeImg;
    @FXML
    private Button homeBtn;
    @FXML
    private Button ret4;
    @FXML
    private Button ajouter;
    @FXML
    private TextField nomt;
    @FXML
    private TextField etat;
    @FXML
    private TableView<terrain> tableGestionDesTerrains;
    @FXML
    private Button modifier;
    @FXML
    private Button supprimer;
    @FXML
    private Button rechercher;
    @FXML
    private TextField rech;
    @FXML
    private TextField typt;
    @FXML
    private TextField empt;
    @FXML
    private TableColumn<terrain,Integer> colid;
    @FXML
    private TableColumn<terrain,String> colnom;
    @FXML
    private TableColumn<terrain,String> coleml;
    @FXML
    private TableColumn<terrain,String> coltyp;
    @FXML
    private TableColumn<terrain,String> coleta;
    @FXML
    private TextField idt;
    @FXML
    private DatePicker seldate;
    @FXML
    private HBox parent;
    @FXML
    private Label name;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       afficherter();
    }    

    @FXML
    private void LoginActionReturn(ActionEvent event) {
        
    }

    @FXML
    private void HomeActionReturn4(ActionEvent event) {
         try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Menu.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);        
            ((Stage)((Node)event.getTarget()).getScene().getWindow()).setScene(scene);
        }catch(Exception e){
            System.out.println(e);
        }
    }

    @FXML
    private void AjouterOnAction(ActionEvent event) {
        
       resterCRUD rc = new resterCRUD();
            rester r = new rester();
           
            
            r.setNom_ter(nomt.getText());
            int qu = Integer.parseInt(idt.getText());
           
            String date = seldate.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            r.setDate_res(date);
            r.setId_terrain(qu);
             String nom = nomt.getText();
             rester rx = new rester(nom,date);
            if(rc.verif(rx) == false){
                mediaPlayer.play();
            rc.Addrester(r,Data.user.getId());
            afficherter();Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Succès");
		alert.setHeaderText(null);
		alert.setContentText("Reservation effectuée");
		alert.showAndWait(); 
                
                //mailing
               
        
         String Subject="Nouvelle reservation effectuer!";
        
        Properties properties=new Properties();
        
        properties.put("mail.smtp.auth","true" );
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.ssl.trust","*");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        String myAccountEmail= ("mohamedbedis.denden@esprit.tn");
        String password =("smecta<31236");
        Session session = Session.getInstance(properties,new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(myAccountEmail,password);
                    }
        
        });
        
        
        
        
        
        String abc = r.getDate_res();
        String def = r.getNom_ter();
            try {
                PreparedStatement pre;
            Message message= new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(myAccountEmail));
            message.setSubject(Subject);
            message.setText("Votre terrain est reserver pour la date %s"+abc);
            Transport.send(message);
        } catch (Exception ex) {
            Logger.getLogger(ResterInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        
        
                //end mailing
	    	    
            
            else {
                mediaPlayer2.play();    
            Alert alert = new Alert(Alert.AlertType.ERROR);
	        alert.setTitle("Erreur");
	        alert.setHeaderText("Cette date est deja utilise");
	    	alert.setContentText("Veuillez choisir un autre date");
                alert.showAndWait();}
    }
        
        
    

    @FXML
    private void ModifierOnAction(ActionEvent event) {
        terrainCRUD tc = new terrainCRUD();
        terrain t = new terrain();
        int id = Integer.parseInt(idt.getText());
        t.setId_terrain(id);
        t.setEmplacement(empt.getText());
        t.setEtat(etat.getText());
        t.setNom_terrain(nomt.getText());
        t.setType(typt.getText());
        tc.modifierterrain(t);
        afficherter();
    }

    @FXML
    private void SupprimerOnAction(ActionEvent event) {
        terrainCRUD tc = new terrainCRUD();
        terrain t = new terrain();
        int id = Integer.parseInt(idt.getText());
        t.setId_terrain(id);
        tc.supprimerterrain(t);
        afficherter();
    }

    @FXML
    private void RechercherOnAction(ActionEvent event) {
        try {
             terrain t = new terrain();
            selectedid = Integer.parseInt(idt.getText());
            selectedname = (nomt.getText());
            Stage logp = new Stage();
            Parent root;
            root = FXMLLoader.load(getClass().getResource("MatterInterface.fxml"));
            Scene scene = new Scene(root);
            logp.setScene(scene);
            logp.show();
            logp.setResizable(false);
        }catch(Exception e) {
            System.out.println(e);
        }
    }
        
         
       
    
public void afficherter(){
       terrainCRUD tc = new terrainCRUD();
       ObservableList<terrain> list  = tc.getterList();
        colid.setCellValueFactory(new PropertyValueFactory<terrain,Integer>("id_terrain"));
       
        colnom.setCellValueFactory(new PropertyValueFactory<terrain,String>("nom_terrain"));
        coltyp.setCellValueFactory(new PropertyValueFactory<terrain,String>("type"));
        coleta.setCellValueFactory(new PropertyValueFactory<terrain,String>("etat"));
        coleml.setCellValueFactory(new PropertyValueFactory<terrain,String>("emplacement"));
        tableGestionDesTerrains.setItems(list);
   }    

    @FXML
    private void selectedl(MouseEvent event) {
        terrain evt = tableGestionDesTerrains.getSelectionModel().getSelectedItem();
        nomt.setText(evt.getNom_terrain());
       empt.setText(evt.getEmplacement());
        etat.setText(evt.getEtat());
        typt.setText(evt.getType());
        String a = Integer.toString(evt.getId_terrain());
        idt.setText(a);
       
    }

    @FXML
    private void search(KeyEvent event) {
         terrain l = new terrain();
         colnom.setCellValueFactory(new PropertyValueFactory<terrain,String>("nom_terrain"));
        coltyp.setCellValueFactory(new PropertyValueFactory<terrain,String>("type"));
        coleta.setCellValueFactory(new PropertyValueFactory<terrain,String>("etat"));
        coleml.setCellValueFactory(new PropertyValueFactory<terrain,String>("emplacement"));
        ObservableList<terrain> dataList;
        terrainCRUD se = new terrainCRUD();
        dataList = se.getterList();
       
        tableGestionDesTerrains.setItems(dataList);
       
        FilteredList<terrain> filteredData = new FilteredList<>(dataList, b -> true);
       
        rech.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate((terrain person) -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (person.getEmplacement().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches username
               
                } else if (person.getType().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                        }else if (person.getEtat().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                        }else if (person.getNom_terrain().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                        }
               
                else {
                    return false; 
                }
            });
        });
        SortedList<terrain> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableGestionDesTerrains.comparatorProperty());
        tableGestionDesTerrains.setItems(sortedData);
        
        
        
        
        
        
    }

    @FXML
    private void xprofile(MouseEvent event) throws IOException {
         Parent d_page = FXMLLoader.load(getClass().getResource("/match/up/FXMLprofileuser.fxml"));
        Scene s = new Scene(d_page);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
 
                app_stage.hide(); //optional
                app_stage.setScene(s);
                app_stage.show(); 
    }

    @FXML
    private void xmatch(MouseEvent event) throws IOException {
             Parent d_page = FXMLLoader.load(getClass().getResource("/hajer/Matchprop.fxml"));
        Scene s = new Scene(d_page);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
 
                app_stage.hide(); //optional
                app_stage.setScene(s);
                app_stage.show(); 
    }

    @FXML
    private void xterrain(MouseEvent event) throws IOException {
        Parent d_page = FXMLLoader.load(getClass().getResource("/badis/ResterInterface.fxml"));
        Scene s = new Scene(d_page);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
 
                app_stage.hide(); //optional
                app_stage.setScene(s);
                app_stage.show(); 
    }

    @FXML
    private void xparking(MouseEvent event) throws IOException {
             Parent d_page = FXMLLoader.load(getClass().getResource("/yossra/Reservation.fxml"));
        Scene s = new Scene(d_page);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
 
                app_stage.hide(); //optional
                app_stage.setScene(s);
                app_stage.show(); 
        
        
    }

    @FXML
    private void xtournoi(MouseEvent event) throws IOException {
         Parent d_page = FXMLLoader.load(getClass().getResource("/hajer/ListeTournoi.fxml"));
        Scene s = new Scene(d_page);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
 
                app_stage.hide(); //optional
                app_stage.setScene(s);
                app_stage.show(); 
        
    }

    @FXML
    private void xproduit(MouseEvent event) throws IOException {
        
        Parent d_page = FXMLLoader.load(getClass().getResource("/rania/market.fxml"));
        Scene s = new Scene(d_page);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
 
                app_stage.hide(); //optional
                app_stage.setScene(s);
                app_stage.show(); 
    }

    @FXML
    private void xpanier(MouseEvent event) throws IOException {
       
         Parent d_page = FXMLLoader.load(getClass().getResource("/match/up/FXMLpanier.fxml"));
        Scene s = new Scene(d_page);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
 
                app_stage.hide(); //optional
                app_stage.setScene(s);
                app_stage.show(); 
    }

    @FXML
    private void xlog(MouseEvent event) throws IOException {
         Parent d_page = FXMLLoader.load(getClass().getResource("/match/up/FXMLlogin.fxml"));
        Scene s = new Scene(d_page);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
 
                app_stage.hide(); //optional
                app_stage.setScene(s);
                app_stage.show(); 
    }

    @FXML
    private void xe(MouseEvent event) {
        System.exit(0);
    }
}

    

   

