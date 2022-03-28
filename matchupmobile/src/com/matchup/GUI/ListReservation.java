/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matchup.GUI;

import com.codename1.components.SpanLabel;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.util.Resources;
import com.matchup.Services.ServiceReservation;

/**
 *
 * @author yousra
 */

public class ListReservation extends BaseForm{
 @Override
    protected boolean isCurrentAfficherReservation() {
        return true;
    }
    public ListReservation(Resources res) {
        setTitle("List Reservation");
        
        SpanLabel sp = new SpanLabel();
        sp.setText(ServiceReservation.getInstance().getAllReservations().toString());
        add(sp);
         installSidemenu(res);
       // getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
    }
    
    
}