/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_parking;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author tpc
 */
public class ReservationController implements Initializable {

    @FXML
    private Button btnajouter;
    @FXML
    private Button btnmodifier;
    @FXML
    private Button btnsupprimer;
    @FXML
    private TableView<?> tablersv;
    @FXML
    private TableColumn<?, ?> colidrsv;
    @FXML
    private TableColumn<?, ?> colid;
    @FXML
    private TableColumn<?, ?> colidprk;
    @FXML
    private TableColumn<?, ?> coldated;
    @FXML
    private TableColumn<?, ?> coldatef;
    @FXML
    private TableColumn<?, ?> coldated1;
    @FXML
    private Label tfdate;
    @FXML
    private Label tfdateff;
    @FXML
    private Button btnretour;
    @FXML
    private Button tfemail;
    @FXML
    private TextField tfdated;
    @FXML
    private TextField tfdatef;
    @FXML
    private TextField tfrecherche;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AjouterReservation(ActionEvent event) {
    }

    @FXML
    private void ModifierReservation(ActionEvent event) {
    }

    @FXML
    private void SupprimerReservation(ActionEvent event) {
    }

    @FXML
    private void handleMouseAction(MouseEvent event) {
    }

    @FXML
    private void RetourReservation(ActionEvent event) {
    }

    @FXML
    private void EmailReservation(ActionEvent event) {
    }
    
}
