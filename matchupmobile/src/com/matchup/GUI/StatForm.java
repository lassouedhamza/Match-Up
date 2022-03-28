/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matchup.GUI;

import com.codename1.charts.ChartComponent;
import com.codename1.charts.models.CategorySeries;
import com.codename1.charts.renderers.DefaultRenderer;
import com.codename1.charts.renderers.SimpleSeriesRenderer;
import com.codename1.charts.util.ColorUtil;
import com.codename1.charts.views.PieChart;
import com.codename1.ui.util.Resources;
import com.matchup.Services.ServiceProduit;
import com.matchup.entities.Produit;
import java.util.ArrayList;

/**
 *
 * @author Asus
 */
public class StatForm  extends BaseForm{
    
    @Override
    protected boolean isCurrentTrending() {
        return true;
    }
    
      ArrayList<Produit> data = new ArrayList<>();
    /**
 * Creates a renderer for the specified colors.
 */
private DefaultRenderer buildCategoryRenderer(int[] colors) {
    DefaultRenderer renderer = new DefaultRenderer();
    renderer.setLabelsTextSize(60);
    renderer.setLegendTextSize(60);
    renderer.setMargins(new int[]{20, 30, 15, 0});
    for (int color : colors) {
        SimpleSeriesRenderer r = new SimpleSeriesRenderer();
        r.setColor(color);
        renderer.addSeriesRenderer(r);
    }
    return renderer;
}

/**
 * Builds a category series using the provided values.
 *
 * @param titles the series titles
 * @param values the values
 * @return the category series
 */
    protected CategorySeries buildCategoryDataset(String title, ArrayList<Produit> data) {
    CategorySeries series = new CategorySeries(title);
    data = ServiceProduit.getInstance().getAllProduits();
    int pt=0;
    int pc=0;
    
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getNom_produit().equals("corde"))
                pt=pt+1;
            if (data.get(i).getNom_produit().equals("t-shirt rouge"))
                pc=pc+1;
            
        }
        
        series.add("corde", pt);
        series.add("t-shirt rouge", pc);
        
    return series;
}

    public StatForm(Resources res) {
    // Set up the renderer
     installSidemenu(res);
        
    getToolbar().addCommandToRightBar("", res.getImage(""), e -> {});
    int[] colors = new int[]{ColorUtil.BLUE, ColorUtil.YELLOW};
    DefaultRenderer renderer = buildCategoryRenderer(colors);
    renderer.setChartTitleTextSize(20);
    renderer.setDisplayValues(true);
    renderer.setShowLabels(true);
    SimpleSeriesRenderer r = renderer.getSeriesRendererAt(0);
    

    // Create the chart ... pass the values and renderer to the chart object.
    PieChart chart = new PieChart(buildCategoryDataset("Nombre de Produit", data), renderer);

    // Wrap the chart in a Component so we can add it to a form
    ChartComponent c = new ChartComponent(chart);

    // Create a form and show it.
 
    add(c);
     
}
    
}
