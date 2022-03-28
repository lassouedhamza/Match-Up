/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matchup.GUI;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.matchup.Services.ServiceReservation;
import com.matchup.entities.Reservation;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.concurrent.Task;

/**
 *
 * @author yousra
 */
public class AddReservation  extends BaseForm {
     @Override
    protected boolean isCurrentReserver() {
        return true;
    }
    
    public AddReservation(Resources res) {
        
        setTitle("Add a new Reservation");
        setLayout(BoxLayout.y());
        
        TextField tfdated = new TextField("","Date Début");
        TextField tfdatef= new TextField("", "Date Fin");
        Button btnValider = new Button("Add Reservation");
        
        btnValider.addActionListener(new ActionListener() {
            String date_d, date_f;
            Date date_debut, date_fin;
            DateFormat df = new SimpleDateFormat("dd-MM-yyyy"); 
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfdated.getText().length()==0)||(tfdatef.getText().length()==0))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                    try {
                        date_debut = df.parse(tfdated.getText());
                        date_d = df.format(date_debut);                       
                        System.out.print(date_d);                      
                        date_fin = df.parse(tfdatef.getText());
                        date_d = df.format(date_fin);
                      Reservation R = new Reservation(date_debut,date_fin);
//                    ReservationPark R = new ReservationPark();
//                        if( ServiceReservation.getInstance().AddReservation(R))
                        if( ServiceReservation.getInstance().addReservation(R))
                            Dialog.show("Success","Connection accepted",new Command("OK"));
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (Exception e) {
                        System.out.print("***");
                        System.out.print(e);
                        Dialog.show("ERROR", "Date must be a Date", new Command("OK"));
                    }
                    
                }
                
                
            }
        });
        installSidemenu(res);
        addAll(tfdated,tfdatef,btnValider);
       // getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK
              //  , e-> previous.showBack()); // Revenir vers l'interface précédente
    }
}
