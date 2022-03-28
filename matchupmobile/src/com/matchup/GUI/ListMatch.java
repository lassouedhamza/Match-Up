/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matchup.GUI;


import com.codename1.ui.FontImage;
import static com.codename1.ui.FontImage.MATERIAL_ARROW_BACK;
import com.matchup.Services.ServiceMatch;
import com.codename1.components.SpanLabel;

import com.codename1.ui.Form;


/**
 *
 * @author Hajer
 */
public class ListMatch extends Form{
    public ListMatch(Form previous)
    { 
        setTitle("Liste des Matchs");
            SpanLabel sp = new SpanLabel();
        sp.setText(ServiceMatch.getInstance().getAllMatchs().toString());
        add(sp);
    getToolbar().addMaterialCommandToLeftBar("",FontImage.MATERIAL_ARROW_BACK,e->previous.showBack());
    
    
    
    }
    
}
