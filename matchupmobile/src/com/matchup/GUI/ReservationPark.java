/*
 * Copyright (c) 2016, Codename One
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated 
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation 
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, 
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions 
 * of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A 
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE 
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. 
 */

package com.matchup.GUI;

import com.codename1.components.InfiniteProgress;
import com.codename1.io.Log;
import com.codename1.ui.Button;
import com.codename1.ui.Calendar;
import com.codename1.ui.Command;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Effects;
import com.codename1.ui.util.Resources;
import com.codename1.ui.util.UITimer;
import java.util.Date;
import static java.util.concurrent.ThreadLocalRandom.current;

/**
 * GUI builder created Form
 *
 * @author shai
 */
 
  public class ReservationPark extends BaseForm{
 private Resources theme;

    Form current;
    /*Garder traçe de la Form en cours pour la passer en paramètres 
    aux interfaces suivantes pour pouvoir y revenir plus tard en utilisant
    la méthode showBack*/
       @Override
    protected boolean isCurrentCalendar() {
        return true;
    }
    public ReservationPark(Resources res) {
        Style s = UIManager.getInstance().getComponentStyle("Title");
        
        FontImage exitVideo = FontImage.createMaterial(FontImage.MATERIAL_ARROW_BACK, s);
        System.out.println("----------");
        current = this; //Récupération de l'interface(Form) en cours
        setTitle("Reservation");
        setLayout(BoxLayout.y());
//        add(new Label("Choose an option"));
//        Button btnAddReservation = new Button("Add Reservation");
//        Button btnListReservations = new Button("List Reservation");
        Button btnAjoutReservations = new Button(" Calander ");
//        btnAddReservation.addActionListener(e -> new AddReservation(res).show());
//        btnListReservations.addActionListener(e -> new ListReservation(res).show());
        btnAjoutReservations.addActionListener(e ->
        {
        Form hi = new Form("Calendar", new BorderLayout());
        Calendar cld = new Calendar();
        cld.addActionListener((ee) -> Log.p("You picked: " + new Date(cld.getSelectedDay())));
        hi.add(BorderLayout.CENTER, cld);
        hi.show();
        hi.getToolbar().addCommandToLeftBar(new Command("", exitVideo) {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                       System.out.println("tay...");
                       theme = UIManager.initFirstTheme("/theme");
                     //  media.pause();
                       new ReservationPark(theme).show();
                    }
                
                });
        });
        addAll(btnAjoutReservations );
         installSidemenu(res);
    }
   
}