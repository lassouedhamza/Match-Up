/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package match.up;



import com.jfoenix.controls.JFXProgressBar;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import matchup.servies.Statistique;

/**
 * FXML Controller class
 *
 * @author tpc
 */
public class FXMLStatistiqueController implements Initializable {

   

    @FXML
    private PieChart pieChartProd;
    @FXML
    private PieChart pieChartU;
    private ScrollPane scrollStat;
    @FXML
    private Label nbTot;
    @FXML
    private ProgressBar progress;
    @FXML
    private Label pourcentage;
    @FXML
    private HBox parent;
    @FXML
    private Label name;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       
//        scrollStat.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        Statistique ss = new Statistique();
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Nombre d'Administrateurs : " + ss.getNombreAdministrateurs(), ss.getNombreAdministrateurs()),
                new PieChart.Data("Nombre d' utilisateurs : " + ss.getNombreutilisateur(), ss.getNombreutilisateur()),
                new PieChart.Data("Nombre de proprietaires : " + ss.getNombreproprietaire(), ss.getNombreproprietaire())
        );
        pieChartU.setData(pieChartData);
        pieChartU.setLegendSide(Side.LEFT);
        ObservableList<PieChart.Data> pieChartDataProduits = FXCollections.observableArrayList(
                new PieChart.Data("Nombre total de produits : " + ss.getNombreProduits(), ss.getNombreProduits()),
                new PieChart.Data("Nombre de produits Vendus : " + ss.getNombreProduitsVendus(), ss.getNombreProduitsVendus())
        );
        pieChartProd.setData(pieChartDataProduits);
        pieChartProd.setLegendSide(Side.RIGHT);


//        EvaluationService es = new EvaluationService();
//        List<Produit> topTenProduits = ss.getTopTenProduits();
//        System.out.println(topTenProduits);
//        XYChart.Series setP = new XYChart.Series<>();
//        for (Produit p : topTenProduits) {
//            if (es.produitHasNote(p)) {
//                setP.getData().add(new XYChart.Data(/*p.getId() + ":"+*/p.getReference(), es.getNoteProduit(p)));
//            }
//        }
//        barChartp.getData().addAll(setP);
//
//        List<Boutique> topTenBoutiques = ss.getTopTenBoutiques();
//        System.out.println(topTenBoutiques);
//        XYChart.Series setB = new XYChart.Series<>();
//        for (Boutique b : topTenBoutiques) {
//            if (es.boutiqueHasNote(b)) {
//                setB.getData().add(new XYChart.Data(b.getId() +":" + b.getNom(), es.getNoteBoutique(b)));
//            }
//        }
//        barChartb.getData().addAll(setB);

//        XYChart.Series seriesP = new XYChart.Series();
//        seriesP.getData().add(new XYChart.Data("Jan", ss.getQuantiteProduitsVendusParMois("-01-")));
//        seriesP.getData().add(new XYChart.Data("Fév", ss.getQuantiteProduitsVendusParMois("-02-")));
//        seriesP.getData().add(new XYChart.Data("Mar", ss.getQuantiteProduitsVendusParMois("-03-")));
//        seriesP.getData().add(new XYChart.Data("Avr", ss.getQuantiteProduitsVendusParMois("-04-")));
//        seriesP.getData().add(new XYChart.Data("Mai", ss.getQuantiteProduitsVendusParMois("-05-")));
//        seriesP.getData().add(new XYChart.Data("Jun", ss.getQuantiteProduitsVendusParMois("-06-")));
//        seriesP.getData().add(new XYChart.Data("Jui", ss.getQuantiteProduitsVendusParMois("-07-")));
//        seriesP.getData().add(new XYChart.Data("Aoû", ss.getQuantiteProduitsVendusParMois("-08-")));
//        seriesP.getData().add(new XYChart.Data("Sep", ss.getQuantiteProduitsVendusParMois("-09-")));
//        seriesP.getData().add(new XYChart.Data("Oct", ss.getQuantiteProduitsVendusParMois("-10-")));
//        seriesP.getData().add(new XYChart.Data("Nov", ss.getQuantiteProduitsVendusParMois("-11-")));
//        seriesP.getData().add(new XYChart.Data("Déc", ss.getQuantiteProduitsVendusParMois("-12-")));
//        
//        lineChart.getData().addAll(seriesP);
        double x = ss.getNombreProduits();
        double m = ss.getNombreProduitsVendus();
        nbTot.setText("Nombre Total : " + ((Double)x).toString()+ "%");
        double prc = (m/x)*100;
        float k = (float) Math.round(prc * 100) / 100;
        pourcentage.setText((String.valueOf(k)) + "% Vendus");
        progress.setProgress(k/100);
    }

    @FXML
    private void u(MouseEvent event) throws IOException {
         Parent d_page = FXMLLoader.load(getClass().getResource("FXMLAdminuser.fxml"));
        Scene s = new Scene(d_page);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
 
                app_stage.hide(); //optional
                app_stage.setScene(s);
                app_stage.show(); 
    }

    @FXML
    private void p(MouseEvent event) throws IOException {
         Parent d_page = FXMLLoader.load(getClass().getResource("FXMLadminProp.fxml"));
        Scene s = new Scene(d_page);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
 
                app_stage.hide(); //optional
                app_stage.setScene(s);
                app_stage.show(); 
    }

    @FXML
    private void s(MouseEvent event) throws IOException {
         Parent d_page = FXMLLoader.load(getClass().getResource("FXMLStatistique.fxml"));
        Scene s = new Scene(d_page);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
 
                app_stage.hide(); //optional
                app_stage.setScene(s);
                app_stage.show(); 
    }

    @FXML
    private void l(MouseEvent event) throws IOException {
           Parent d_page = FXMLLoader.load(getClass().getResource("FXMLlogin.fxml"));
        Scene s = new Scene(d_page);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
 
                app_stage.hide(); //optional
                app_stage.setScene(s);
                app_stage.show(); 
    }

    @FXML
    private void e(MouseEvent event) {
         System.exit(0);
    }

    

}


