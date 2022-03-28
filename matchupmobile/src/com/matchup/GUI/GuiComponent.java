package com.matchup.GUI;

import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Dialog;
import com.codename1.ui.util.Resources;


public class GuiComponent extends Form  {
    public GuiComponent(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
    }

//-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Button gui_Button = new com.codename1.ui.Button();
    protected com.codename1.ui.Container gui_Container = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(true);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("GuiComponent");
        setName("GuiComponent");
        gui_Button.setText("Button");
                gui_Button.setInlineStylesTheme(resourceObjectInstance);
        gui_Button.setName("Button");
                gui_Container.setInlineStylesTheme(resourceObjectInstance);
        gui_Container.setName("Container");
        addComponent(gui_Button);
        addComponent(gui_Container);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Button.getParent().getLayout()).setInsets(gui_Button, "auto auto 18.233082% 40.083797%").setReferenceComponents(gui_Button, "-1 -1 -1 -1").setReferencePositions(gui_Button, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getParent().getLayout()).setInsets(gui_Container, "15.601503% 28.212292% 34.3985% 21.787708%").setReferenceComponents(gui_Container, "-1 -1 -1 -1").setReferencePositions(gui_Container, "0.0 0.0 0.0 0.0");
    }// </editor-fold>
//-- DON'T EDIT ABOVE THIS LINE!!!
}
