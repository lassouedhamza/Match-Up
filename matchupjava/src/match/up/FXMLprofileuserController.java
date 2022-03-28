/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package match.up;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import matchup.entities.proprietaire;
import matchup.entities.user;
import matchup.entities.utilisateur;
import matchup.servies.Data;
import matchup.servies.UserSession;
import matchup.servies.utilisateurCRUD;

/**
 * FXML Controller class
 *
 * @author tpc
 */
public class FXMLprofileuserController implements Initializable {
 ObservableList <String> tftypeList =FXCollections.observableArrayList("Femme","Homme");
    @FXML
    private JFXTextField iNom;
    @FXML
    private JFXTextField IPrenom;
    @FXML
    private JFXTextField IEamail;
    @FXML
    private JFXTextField IMdp;
    @FXML
    private JFXTextField IAdresse;
    @FXML
    private JFXTextField Iage;
    @FXML
    private HBox parent;
    @FXML
    private Label name;
    @FXML
    private ChoiceBox<String> tftype;



    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    tftype.setItems(tftypeList);
       
 utilisateurCRUD cs = new utilisateurCRUD();
        try {
            user c = cs.findByUserIdPopulated(Data.user.getId());
            this.IEamail.setText(c.getEmail());
//            this.role.setText(c.getRole());
            this.iNom.setText(c.getNom());
            this.IPrenom.setText(c.getPrenom());
            this.IMdp.setText(c.getMdp());
            this.IAdresse.setText(c.getAdresse());
            this.Iage.setText(String.valueOf((c.getAge())));
//            this.Igenre.setText(c.getGenre());
            this.tftype.setValue(c.getGenre());
            this.name.setText(c.getPrenom());
        } catch (SQLException ex) {
           
        }
     
   

    }    

    


    @FXML
    private void modifier(ActionEvent event) throws SQLException {
        if(((iNom.getText().isEmpty() || IPrenom.getText()== null|| IEamail.getText()== null|| IMdp.getText()== null)) || IAdresse.getText()== null|| Iage.getText()== null|| tftype.getValue()== null)
         { 
             Alert alert = new Alert(Alert.AlertType.WARNING);
             alert.setTitle("data invalide");
             alert.setHeaderText("Erreur de saisie");
             alert.setContentText("Verifier les champs vides");
             
             alert.showAndWait();
         }else{
        utilisateurCRUD sc = new utilisateurCRUD();
        utilisateur c = new utilisateur();
         c.setId(Data.user.getId());
         c.setNom(iNom.getText());
        c.setPrenom(IPrenom.getText());
        c.setEmail(IEamail.getText());
        c.setMdp(IMdp.getText());
        c.setAdresse(IAdresse.getText());
        c.setAge(parseInt(Iage.getText()));
        c.setGenre(tftype.getValue());
        sc.Modifierutilisateur(c);
        }
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
