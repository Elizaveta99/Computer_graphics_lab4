package lab4;


import java.awt.Graphics;
import static java.lang.Math.abs;
import static java.lang.Math.max;
import static java.lang.Math.round;
import java.util.ArrayList;

public class DigitalDifferentialAnalyzer implements Algorithm
{
    private int x0;
    private int y0;
    private int x1;
    private int y1;
    
    public DigitalDifferentialAnalyzer(int x0, int y0, int x1, int y1) 
    {
        this.x0 = x0;
        this.y0 = y0;
        this.x1 = x1;
        this.y1 = y1;
    }
    
    public void rasterize(Graphics g)
    {
        double dx = x1 - x0;
        double dy = y1 - y0;
        double L = max(abs(dx), abs(dy));
        ArrayList<Point2D> points = new ArrayList<>();
       
        dx /= L;
        dy /= L;
        double x = x0;
        double y = y0;   
        for (int i = 0; i <= L; i++) {    
            points.add(new Point2D(round(x), round(y)));
            System.out.println(points.get(points.size() - 1).getX() + " " + points.get(points.size() - 1).getY());
            g.drawLine((int)round(x), (int)round(y), (int)round(x), (int)round(y));
            x += dx;           
            y += dy;      
           
        }
        //return points;
    }
}
