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
import javafx.stage.Stage;
import matchup.entities.utilisateur;
import matchup.servies.utilisateurCRUD;

/**
 * FXML Controller class
 *
 * @author tpc
 */
public class FXMLsingupController implements Initializable {
    ObservableList <String> tftypeList =FXCollections.observableArrayList("Femme","Homme");

    @FXML
    private JFXTextField iNom;
    @FXML
    private JFXTextField IPrenom;
    @FXML
    private JFXTextField IEamail;
    @FXML
    private JFXPasswordField IMdp;
    @FXML
    private JFXTextField IAdresse;
    @FXML
    private JFXTextField Iage;
    private JFXTextField Igenre;
    @FXML
    private ChoiceBox<String> tftype;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tftype.setItems(tftypeList);
        
        // TODO
    }    

     @FXML
    private void ajouterPersonne(ActionEvent event) throws IOException {
        if(((iNom.getText().isEmpty() || IPrenom.getText()== null|| IEamail.getText()== null|| IMdp.getText()== null)) || IAdresse.getText()== null|| Iage.getText()== null|| tftype.getValue()== null)
         { 
             Alert alert = new Alert(Alert.AlertType.WARNING);
             alert.setTitle("data invalide");
             alert.setHeaderText("Erreur de saisie");
             alert.setContentText("Verifier les champs vides");
             
             alert.showAndWait();
         }else{

        utilisateurCRUD sp = new utilisateurCRUD();
        utilisateur p = new utilisateur();
        p.setNom(iNom.getText());
        p.setPrenom(IPrenom.getText());
        p.setEmail(IEamail.getText());
        p.setMdp(IMdp.getText());
        p.setAdresse(IAdresse.getText());
        p.setAge(parseInt(Iage.getText()));
        p.setGenre(tftype.getValue());
       
        sp.ajouterPersonne(p);
         Parent d_page = FXMLLoader.load(getClass().getResource("FXMLlogin.fxml"));
        Scene s = new Scene(d_page);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
 
                app_stage.hide(); //optional
                app_stage.setScene(s);
                app_stage.show(); 
        }
    }

    @FXML
    private void connecter(ActionEvent event) throws IOException {
        Parent d_page = FXMLLoader.load(getClass().getResource("FXMLlogin.fxml"));
        Scene s = new Scene(d_page);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
 
                app_stage.hide(); //optional
                app_stage.setScene(s);
                app_stage.show(); 
    }
    
}
    

