/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hajer;

import matchup.entities.Matchs;
import matchup.servies.ServiceMatch;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import matchup.entities.proprietaire;
import matchup.servies.Data;
import matchup.servies.proprietaireCRUD;

/**
 * FXML Controller class
 *
 * @author Hajer
 */
public class MatchtournoiController implements Initializable {

    ObservableList<String> tftypeList = FXCollections.observableArrayList("Football", "Handball", "Volleyball", "Tennis");

    @FXML
    private Button ajouter;
    @FXML
    private TextField tfnbjoueurs;
    @FXML
    private TextField tfdate;
    @FXML
    private ChoiceBox<String> tftype;
    @FXML
    private TextField tfnomtournoi;
     @FXML
    private TableView<Matchs> tableview;
    @FXML
    private TableColumn<Matchs,String> coltype;
    @FXML
    private TableColumn<Matchs,String> coldate;
    @FXML
    private TableColumn<Matchs,Integer> colnbjoueurs;
    @FXML
    private TextField tfrechercher;
    @FXML
    private Button liste;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
        
         Matchs m = tableview.getSelectionModel().getSelectedItem();
// ServiceMatch ser = new ServiceMatch();
//        try {
//            ser.AfficherMatchTournoi();
//        } catch (SQLException ex) {
//            Logger.getLogger(MatchtournoiController.class.getName()).log(Level.SEVERE, null, ex);
//        }
          ShowMatch();
        tfnomtournoi.setText(TournoiController.selectedname);
        tftype.setItems(tftypeList);
    }

    @FXML
    private void AjouterOnClick(ActionEvent event) {
         proprietaireCRUD cs = new proprietaireCRUD();
        try {
            proprietaire c = cs.findByUserIdPopulated(Data.user.getId());

            
        } catch (SQLException ex) {
           
        }
        if (!tftype.getValue().isEmpty() && !tfdate.getText().isEmpty() && !tfnbjoueurs.getText().isEmpty()) {
            try {

                ServiceMatch ser = new ServiceMatch();
                Matchs m = new Matchs(); 

                m.setType(tftype.getValue());

                m.setNom_tournoi(tfnomtournoi.getText());
                m.setDate(tfdate.getText());
                m.setNbjoueurs(parseInt(tfnbjoueurs.getText()));

                ser.AddMatch(m);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Succès");
                alert.setHeaderText(null);
                alert.setContentText("Ajout terminé");
                alert.showAndWait();
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Un de vos champs est vide");
            alert.setContentText("Veuillez remplir tous les champs!");
            alert.showAndWait();

        }

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("ListeMatchTournoi.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            ((Stage) ((Node) event.getTarget()).getScene().getWindow()).setScene(scene);
        } catch (Exception e) {
            System.out.println(e);
        }
        ShowMatch();
    }
    public void ShowMatch(){
      
            ServiceMatch ser = new ServiceMatch();
       ObservableList<Matchs> list  = ser.getterList();
        coltype.setCellValueFactory(new PropertyValueFactory<Matchs,String>("type"));
       
        coldate.setCellValueFactory(new PropertyValueFactory<Matchs,String>("date"));
        colnbjoueurs.setCellValueFactory(new PropertyValueFactory<Matchs,Integer>("nbjoueurs"));
        tableview.setItems(list);
        FilteredList<Matchs> filteredData = new FilteredList<>(list, b -> true);
       
        tfrechercher.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            filteredData.setPredicate((Matchs cattype ) -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (cattype.getType().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches username
                }
               
                else {
                    return false; 
                }
            });
        });
        SortedList<Matchs> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableview.comparatorProperty());
        tableview.setItems(sortedData);
        
        
   }    
        private void search(ActionEvent event) {
          Matchs m = new Matchs();
         coltype.setCellValueFactory(new PropertyValueFactory<Matchs,String>("type"));
         coldate.setCellValueFactory(new PropertyValueFactory<Matchs,String>("date"));
         colnbjoueurs.setCellValueFactory(new PropertyValueFactory<Matchs,Integer>("nbjoueurs"));
 
        ObservableList<Matchs> dataList;
   ServiceMatch ser = new ServiceMatch();
        dataList = ser.getterList();
       
        tableview.setItems(dataList);
       
        
        
    }
                      public void reload() throws IOException{
       FXMLLoader fxmlloader = new FXMLLoader(getClass().getClassLoader().getResource("ListeMatchTournoi.fxml"));
       Parent root = fxmlloader.load();
       Stage stage = (Stage) tableview.getScene().getWindow(); 
       stage.getScene().setRoot(root); 
//       ShowTournoi();
   }



//    private void selectedl(MouseEvent event) {
//       Matchs m = tableview.getSelectionModel().getSelectedItem();
//        tftype.setValue(m.getType());
////         java.sql.Date h = java.sql.Date.valueOf(datePicker.setValue());
////         m.getDate(h);
//        datePicker.setValue(m.getDate());
//       tfnbjoueurs.setText( m.getNbjoueurs1());
//          
//       
//       
//    }

    @FXML
    private void ListeOnClick(ActionEvent event) {
        
            try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("ListeTournoi.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);        
            ((Stage)((Node)event.getTarget()).getScene().getWindow()).setScene(scene);
        }catch(Exception e){
            System.out.println(e);
        }
        
        
        
    }

    
    


}
