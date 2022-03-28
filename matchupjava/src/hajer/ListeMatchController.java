/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hajer;

import matchup.entities.Matchs;
import matchup.servies.ServiceMatch;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hajer
 */
public class ListeMatchController implements Initializable {
@FXML
    private TableColumn<Matchs,String> coltype;
    @FXML
    private TableColumn<Matchs,String> coldate;
    @FXML
    private TableColumn<Matchs,Integer> colnbjoueurs;
    @FXML
    private TableView<Matchs> tableview;
    @FXML
    private TextField tfrechercher;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         Matchs m = tableview.getSelectionModel().getSelectedItem();
            ShowMatch();
        // TODO
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

    @FXML
    private void RetourOnClick(ActionEvent event) {
                      try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Match.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);        
            ((Stage)((Node)event.getTarget()).getScene().getWindow()).setScene(scene);
        }catch(Exception e){
            System.out.println(e);
        }
    }



}
