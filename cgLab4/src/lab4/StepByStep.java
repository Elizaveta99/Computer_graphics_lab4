package lab4;

import java.awt.Graphics;
import static java.lang.Math.abs;
import static java.lang.Math.round;
import java.util.ArrayList;

public class StepByStep implements Algorithm
{
    private int x0;
    private int y0;
    private int x1;
    private int y1;
    
    public StepByStep(int x0, int y0, int x1, int y1) 
    {
        this.x0 = x0;
        this.y0 = y0;
        this.x1 = x1;
        this.y1 = y1;
    }
    
    public void rasterize(Graphics g)
    {        
        boolean step = abs(y1 - y0) > abs(x1 - x0);    
        if(step)
        {
            y0 = swap(x0, x0 = y0);
            y1 = swap(x1, x1 = y1);
        }        
        if(x0 > x1){
           x1 = swap(x0, x0 = x1);
           y1 = swap(y0, y0 = y1); 
        }
        
        double dx = x1 - x0;
        double dy = y1 - y0;
        double k = dy / dx;
        double y;
        
        ArrayList<Point2D> points = new ArrayList<>();      
        for (double x = x0; x <= x1; x++) {
              y = y0 + k * (x - x0);
              points.add(new Point2D(round(step ? y : x ), round(step ? x: y)));
              System.out.println(points.get(points.size() - 1).getX() + " " + points.get(points.size() - 1).getY());
              g.drawLine((int)round(step ? y : x ), (int)round(step ? x: y), (int)round(step ? y : x ), (int)round(step ? x: y));
        }
        //return points;
    }

    private int swap(int x0, int y0) {
        return x0;
    }
}
