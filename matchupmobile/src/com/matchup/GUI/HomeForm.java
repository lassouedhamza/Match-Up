/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matchup.GUI;

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


public class HomeForm extends BaseForm {

    public HomeForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }

    @Override
    protected boolean isCurrentCalendar() {
        return true;
    }
        Form current;
    public HomeForm(com.codename1.ui.util.Resources resourceObjectInstance) {
        
       current = this;
        setTitle("Home");
        setLayout(BoxLayout.y());

        add(new Label("Choose an option"));
        Button btnAddTask = new Button("Add Task");
        Button btnListTasks = new Button("List Tasks");
btnAddTask.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                       
                        
                        Form bdf = new HomeForm();
                        bdf.show();
                    }
                });
        
        btnListTasks.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                       
                        
                        Form bdf = new HomeForm();
                        bdf.show();
                    }
                });
        addAll(btnAddTask, btnListTasks);
 installSidemenu(resourceObjectInstance);
        
        getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("toolbar-profile-pic.png"), e -> {});
    }

}
