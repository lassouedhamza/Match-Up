/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rania;


import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import matchup.entities.Produit;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class FXMLBarchartController implements Initializable {

    @FXML
    private Button bntcharger;
    private Connection connection;
    @FXML
    private BarChart<String,Integer> barchart;
    @FXML
    private Button bntretour;
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
         Produit ss = new Produit();
        ObservableList<PieChart.Data> pieChartDataProduits = FXCollections.observableArrayList(
                new PieChart.Data("Nombre total de produits : " + ss.getNom_produit(),ss.getQuantite_total()),
                new PieChart.Data("Nombre de produits Vendus : " + ss.getQuantite_total(), ss.getQuantite_total())
        );
        pieChartProd1.setData(pieChartDataProduits);
        pieChartProd1.setLegendSide(Side.RIGHT);
        double x = ss.getQuantite_total();
        double m = ss.getQuantite_total();
        nbTot.setText("Nombre Total : " + ((Double)x).toString()+ "%");
        double prc = (m/x)*100;
        float k = (float) Math.round(prc * 100) / 100;
        pourcentage.setText((String.valueOf(k)) + "% Vendus");
       progress.setProgress(k/100);
        // TODO
    }    

    @FXML
    private void Chager(ActionEvent event) {
        Connection conn = null;
        Statement stmt = null ;
        ResultSet rs=null;
        String SQL= "Select nom_produit,quantite_total FROM  produit ORDER BY quantite_total";  
        XYChart.Series<String,Integer> series = new XYChart.Series<>();
        series.setName("Quantité Total par Nom");   
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/match-up","root","");
            stmt=conn.createStatement();                   
            try{
                 rs = conn.createStatement().executeQuery(SQL);
                 while(rs.next()){
                     series.getData().add(new XYChart.Data<>(rs.getString(1), rs.getInt(2)));
                 }
                 barchart.getData().add(series);
                 
                       } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Probleme ");}                     
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    private Connection connectdb(){
        String url ="jdbc:mysql://localhost:3306/match-up";
        String login="root";
        String pwd ="";
         try {
            Connection cnx = DriverManager.getConnection(url, login, pwd);
            System.out.println("Cnx etablie");
        } catch (SQLException ex) {
            System.out.println("Problème de cnx");
            System.out.println(ex.getMessage());
        }
         return null;
        
    }

    @FXML
    private void back(ActionEvent event) {
         try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("FXMLProduit.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);        
            ((Stage)((Node)event.getTarget()).getScene().getWindow()).setScene(scene);
        }catch(Exception e){
            System.out.println(e);
        }
    }

    
}
