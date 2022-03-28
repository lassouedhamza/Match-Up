/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author tpc
 */
public class FXMLBarchartController implements Initializable {

    @FXML
    private HBox parent;
    @FXML
    private Label name;
    @FXML
    private BarChart<?, ?> barchart;
    @FXML
    private Button bntcharger;
    @FXML
    private PieChart pieChartProd1;
    @FXML
    private Label nbTot;
    @FXML
    private Label pourcentage;
    @FXML
    private ProgressBar progress;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Chager(ActionEvent event) {
    }
    
}
