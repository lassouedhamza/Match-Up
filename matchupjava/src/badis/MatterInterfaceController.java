/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package badis;

import java.net.URL;
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
import matchup.entities.materiel;

import matchup.servies.materielCRUD;

/**
 * FXML Controller class
 *
 * @author Bedis
 */
public class MatterInterfaceController implements Initializable {

    @FXML
    private TextField nomm;
    @FXML
    private Button inserer;
    @FXML
    private TextField typem;
    @FXML
    private TextField emp;
    @FXML
    private TextField idte;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        emp.setText(TerrainInterfaceController.selectedname);
        String a = Integer.toString(TerrainInterfaceController.selectedid);
        idte.setText(a);
        
        
    }    

    @FXML
    private void InsererOnAction(ActionEvent event) {
       if ( !typem.getText().isEmpty()&& !nomm.getText().isEmpty()) {
           try{
          
       
        materielCRUD mc = new materielCRUD();
            materiel m = new materiel();
            
            
            m.setType_mat(typem.getText());
            int qu = Integer.parseInt(nomm.getText());
            int idter = Integer.parseInt(idte.getText());
            m.setNom_terrain(emp.getText());
            m.setId_terrain(idter);
            m.setQuant_mat(qu);
            
            mc.Addmateriel(m);
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Succès");
		alert.setHeaderText(null);
		alert.setContentText("Modification terminée");
		alert.showAndWait();
	        }catch(Exception e) {
	    	    System.out.println(e);
	    	    }
	    }
       else {
	    	Alert alert = new Alert(Alert.AlertType.ERROR);
	        alert.setTitle("Erreur");
	        alert.setHeaderText("Un de vos champs est vide");
	    	alert.setContentText("Veuillez remplir tous les champs!");
                alert.showAndWait();

	    }
    try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("MaterielInterface.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);        
            ((Stage)((Node)event.getTarget()).getScene().getWindow()).setScene(scene);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}
