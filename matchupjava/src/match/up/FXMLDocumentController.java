/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package match.up;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

/**
 *
 * @author tpc
 */
public class FXMLDocumentController implements Initializable {
    
       @FXML
    private HBox parent;

    private double xOffset = 0;
    private double yOffset = 0;
    @FXML
    private Label name;
    @FXML
    private JFXTextField iNom;
    @FXML
    private JFXTextField IPrenom;
    @FXML
    private JFXTextField IEamail;
    @FXML
    private JFXTextField IMdp;
    @FXML
    private JFXTextField Igenre;
    @FXML
    private JFXTextField IAdresse;
    @FXML
    private JFXTextField Iage;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        make_window_drageable();
    }

    private void make_window_drageable() {
        parent.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
//        parent.setOnMouseDragged(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                MatchUp.stage.setX(event.getScreenX() - xOffset);
//                MatchUp.stage.setY(event.getScreenY() - yOffset);
//                MatchUp.stage.setOpacity(0.7f);
//            }
//        });
//        parent.setOnDragDone((e) -> {
//            MatchUp.stage.setOpacity(1.0f);
//        });
//        parent.setOnMouseReleased((e) -> {
//            MatchUp.stage.setOpacity(1.0f);
//        });

    }

    @FXML
    private void modifier(ActionEvent event) {
    }
    
}
