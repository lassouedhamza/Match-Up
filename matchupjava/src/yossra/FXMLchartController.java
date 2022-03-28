/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yossra;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;

import javafx.scene.control.Button;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author yousra
 */
public class FXMLchartController implements Initializable {
  
@FXML
    private BarChart<?, ?> prk;

    @FXML
    private CategoryAxis group;

    @FXML
    private NumberAxis score;
    @FXML
    private Button tfretour;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         XYChart.Series series =new XYChart.Series();
         series.getData().add(new XYChart.Data("1",23));
         series.getData().add(new XYChart.Data("2",45));
         series.getData().add(new XYChart.Data("3",50));

         series.getData().add(new XYChart.Data("5",23));
         series.getData().add(new XYChart.Data("6",23));
         series.getData().add(new XYChart.Data("7",23));
        prk.getData().addAll(series);
    //   
        
        
       
    }    

    @FXML
    private void retourp(ActionEvent event) {
             try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("FXMLDocument.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);        
            ((Stage)((Node)event.getTarget()).getScene().getWindow()).setScene(scene);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    }
    
    
   

