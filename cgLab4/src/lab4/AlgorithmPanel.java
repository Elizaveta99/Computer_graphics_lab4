/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author User
 */
public class AlgorithmPanel extends JPanel 
{
    List<Algorithm> figures;
    int scale;
    
    public AlgorithmPanel()
    {
        this.scale = 1;
        setScale(scale);
        figures = new ArrayList<>();
    }
    
    public void setScale(int scale) {
        this.scale = scale;
        this.repaint();
    }
    
    public void addFigure(Algorithm figure)
    {
        figures.add(figure);
        this.repaint();
    }
    
    @Override
    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        AffineTransform atrans = null;
        Graphics2D g2d = (Graphics2D) g;
        atrans = AffineTransform.getScaleInstance(scale, scale);
        if (atrans != null) {
            g2d.setTransform(atrans);
        }
        for(Algorithm f: figures)
        {
            f.rasterize(g);
        }
    }
    
}
