/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package match.up;

import com.jfoenix.controls.JFXButton;
import connection.myconnection;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import matchup.entities.user;
import matchup.entities.utilisateur;
import matchup.servies.Data;
import matchup.servies.panier;
import matchup.servies.utilisateurCRUD;
              import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

/**
 * FXML Controller class
 *
 * @author tpc
 */
public class FXMLpanierController implements Initializable {
 private Connection cnx;
    private PreparedStatement ste;
    @FXML
    private Label prixArticles;
    @FXML
    private Label prixLivraison;
    @FXML
    private Label totalTTC;
    @FXML
    private JFXButton commander;
    @FXML
    private HBox parent;
    @FXML
    private Label name;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         utilisateurCRUD cs = new utilisateurCRUD();
        try {
            user c = cs.findByUserIdPopulated(Data.user.getId());
            this.name.setText(c.getPrenom());
System.out.println(Data.user.getId());
        } catch (SQLException ex) {
            
        }
        panier p= new panier();
        System.out.println(p.getsum(Data.user.getId()));
        prixArticles.setText(String.valueOf(p.getsum(Data.user.getId())));
        if (parseInt(prixArticles.getText())!=0){
        prixLivraison.setText("10");
        totalTTC.setText(String.valueOf(parseInt(prixArticles.getText())+10));
        }else{
        prixLivraison.setText("0");}
        
//      prixArticles.setText(String.valueOf(getsum()));
    }    
     public void panier() {
//        connexion = MyDB.getinstance().getConnexion();
cnx = myconnection.getInstance().getConnection();
    }
   

  

    @FXML
    private void commander(ActionEvent event) {
        prixArticles.setText("0");
        prixLivraison.setText("0");
        totalTTC.setText("0");
        try {
            utilisateurCRUD cs = new utilisateurCRUD();
            user c = cs.findByUserIdPopulated(Data.user.getId());
panier p = new panier();
p.delete(Data.user.getId());
           
        } catch (SQLException ex) {
            
        }
        
    }

    @FXML
    private void payerPanier(MouseEvent event) {
    }


    @FXML
    private void imprimerfacture(MouseEvent event) throws IOException, COSVisitorException, SQLException {
         
    
               try{
         utilisateurCRUD cs = new utilisateurCRUD();
       
            user c = cs.findByUserIdPopulated(Data.user.getId());
        System.out.println(" PDF ");
        String fileName = "Panier.pdf"; // name of our file
        
        PDDocument doc = new PDDocument();
        PDPage page = new PDPage();

        doc.addPage(page);

        PDPageContentStream content = new PDPageContentStream(doc, page);
        
        content.beginText();
        content.setFont(PDType1Font.HELVETICA, 26);
        content.moveTextPositionByAmount(220, 750);
        content.drawString("Facture");
        content.endText();
        
        
        content.beginText();
        content.setFont(PDType1Font.HELVETICA, 16);
        content.moveTextPositionByAmount(80, 700);
        content.drawString("Nom et Prenom : "+c.getNom()+" "+c.getPrenom());
        
        content.endText();
        
        
        content.beginText();
        content.setFont(PDType1Font.HELVETICA, 16);
        content.moveTextPositionByAmount(80,650);
        content.drawString("Prix articles : "+prixArticles.getText());
        content.endText();
        
         content.beginText();
        content.setFont(PDType1Font.HELVETICA, 16);
        content.moveTextPositionByAmount(80,600);
        content.drawString("Prix livraison : "+prixLivraison.getText());
        content.endText();
        
        content.beginText();
        content.moveTextPositionByAmount(80,500);
        content.drawString("TotalTTC : "+totalTTC.getText());
        content.endText();
        
        
        content.close();
        doc.save(fileName);
        doc.close();
        
        System.out.println("your file created in : "+ System.getProperty("user.dir"));

        }
        catch(IOException | COSVisitorException e){
        
        System.out.println(e.getMessage());
        
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


