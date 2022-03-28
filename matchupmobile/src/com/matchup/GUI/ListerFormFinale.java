/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matchup.GUI;

import com.codename1.ui.Form;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.matchup.Services.ServiceTerrain;
import com.matchup.entities.Terrain;
import java.util.ArrayList;

/**
 *
 * @author Bedis
 */
public class ListerFormFinale extends BaseForm {
    private Resources theme;
     ArrayList<Terrain> terrains;
    
    Form current;
    public ListerFormFinale(Resources res){
//         super("CareerKey Entreprise", BoxLayout.y());
        Toolbar tb =new Toolbar(true);
        current = this;
        setToolBar(tb);
        getTitle();
        getTitleArea().setUIID("Container");
        setTitle("Ajout terrain");
        getContentPane().setScrollVisible(false);


       // terrains = ServiceTerrain.getInstance().getAllTerrains();
        //System.out.println(terrains);
           /* TextField username = new TextField(Sessionuser.getUsername(), "username",20, TextField.ANY);
            username.setUIID("TextFieldBlack");
            addStringValue("Username", username);
          lanseha lanseha  
            TextField password = new TextField(Sessionuser.getPassword(), "Password", 20, TextField.PASSWORD);
            password.setUIID("TextFieldBlack");
            addStringValue("Password", password);

*/
}}
