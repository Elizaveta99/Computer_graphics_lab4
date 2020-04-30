package lab4;


import java.awt.Graphics;
import static java.lang.Math.abs;
import java.util.ArrayList;

public class BresenhamLine implements Algorithm
{
    private int x0;
    private int y0;
    private int x1;
    private int y1;
    
    public BresenhamLine(int x0, int y0, int x1, int y1) 
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
        if(x0 > x1)
        {
           x1 = swap(x0, x0 = x1);
           y1 = swap(y0, y0 = y1); 
        }
        
        int dx = x1 - x0;
        int dy = abs(y1 - y0);
        int error = dx/2;
        int yInc = y0 < y1 ? 1: -1;
        int y = y0;
        ArrayList<Point2D> points = new ArrayList<>();
        
        for (int x = x0; x <= x1; x++){
            points.add(new Point2D(step ? y : x, step ? x: y));
            System.out.println(points.get(points.size() - 1).getX() + " " + points.get(points.size() - 1).getY());
            g.drawLine(step ? y : x, step ? x: y, step ? y : x, step ? x: y);
            error -= dy;
            if(error < 0){
                y += yInc;
                error += dx;
            }
        }
        //return points;
    }
    
    private int swap(int x0, int y0) {
        return x0;
    }
}
