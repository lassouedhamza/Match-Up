/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matchup.GUI;

import com.codename1.capture.Capture;
import com.codename1.components.InfiniteProgress;
import com.codename1.components.FloatingActionButton;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.animations.CommonTransitions;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Rectangle;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.RoundBorder;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import java.util.List;

import com.codename1.ui.util.Effects;
import com.codename1.ui.util.UITimer;
import java.io.IOException;
import static java.util.concurrent.ThreadLocalRandom.current;


public class Matchs extends BaseForm {

    @Override
    protected boolean isCurrentMatch() {
        return true;
    }

        Form current;
    public Matchs(Resources res) {
        
   
        System.out.println("----------");
       current = this;
        setTitle("Match");
        setLayout(BoxLayout.y());

        add(new Label("Choose an option"));
        Button btnaddmatch = new Button("Ajouter Match");
        Button btnListMatch = new Button("Afficher la liste des matchs");
//        Button btncapture= new Button("Ajouter image");
//         Label limage = new Label();
        btnaddmatch.addActionListener(e -> new AddMatch(current).show());
        btnListMatch.addActionListener(e -> new ListMatch(current).show());
        
        addAll(btnaddmatch, btnListMatch);
       
//btncapture.addActionListener((e)->{
//       String path= Capture.capturePhoto(Display.getInstance().getDisplayWidth(), -1);
//      
//       if(path != null){
//           try {
//               Image img=Image.createImage(path);
//               limage.setIcon(img);
//               revalidate();
//           } catch (IOException ex) {
//             ex.printStackTrace();
//           }
//       }
//        
//    });
 installSidemenu(res);
        
//        getToolbar().addCommandToRightBar("", res.getImage("toolbar-profile-pic.png"), e -> {});
    }
    

}
