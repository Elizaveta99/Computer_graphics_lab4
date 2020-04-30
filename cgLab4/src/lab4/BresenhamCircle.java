package lab4;

import java.awt.Graphics;
import java.util.ArrayList;

public class BresenhamCircle implements Algorithm {
    
    private int x0;
    private int y0;
    private int r;
    
    public BresenhamCircle(int x0, int y0, int r) 
    {
        this.x0 = x0 + r;
        this.y0 = y0 + r;
        this.r = r;
    }

    public void rasterize(Graphics g)
    {
        int x = 0;
        int y = r;
        ArrayList<Point2D> points = new ArrayList<>();
        
        points.add(new Point2D(x0, y + y0));
        if (r > 0) {
            points.add(new Point2D(-y + x0, y0));
            System.out.println((points.get(points.size() - 1).getX() - r) + " " + (points.get(points.size() - 1).getY() - r));
            points.add(new Point2D(y + x0, y0));
            System.out.println((points.get(points.size() - 1).getX() - r) + " " + (points.get(points.size() - 1).getY() - r));
            points.add(new Point2D(x0, -y + y0));
            System.out.println((points.get(points.size() - 1).getX() - r) + " " + (points.get(points.size() - 1).getY() - r));
            
            g.drawLine(-y + x0, y0, -y + x0, y0);
            g.drawLine(y + x0, y0, y + x0, y0);
            g.drawLine(x0, -y + y0, x0, -y + y0);
        }
        int E = 3 - 2 * r;
        while (x < y) {
            if (E >= 0) {
                E += 4 * (x - y) + 10;
                y--;
            } 
            else {
                E += 4 * x + 6;
            }
            x++;
            if (x > y) {
                break;
            }
            points.add(new Point2D(x + x0, y + y0));
            System.out.println((points.get(points.size() - 1).getX() - r) + " " + (points.get(points.size() - 1).getY() - r));
            points.add(new Point2D(-x + x0, y + y0));
            System.out.println((points.get(points.size() - 1).getX() - r) + " " + (points.get(points.size() - 1).getY() - r));
            points.add(new Point2D(x + x0, -y + y0));
            System.out.println((points.get(points.size() - 1).getX() - r) + " " + (points.get(points.size() - 1).getY() - r));
            points.add(new Point2D(-x + x0, -y + y0));
            System.out.println((points.get(points.size() - 1).getX() - r) + " " + (points.get(points.size() - 1).getY() - r));
            
            g.drawLine(x + x0, y + y0, x + x0, y + y0);
            g.drawLine(-x + x0, y + y0, -x + x0, y + y0);
            g.drawLine(x + x0, -y + y0, x + x0, -y + y0);
            g.drawLine(-x + x0, -y + y0, -x + x0, -y + y0);
            if (x != y) {
                points.add(new Point2D(y + x0, x + y0));
                System.out.println((points.get(points.size() - 1).getX() - r) + " " + (points.get(points.size() - 1).getY() - r));
                points.add(new Point2D(-y + x0, x + y0));
                System.out.println((points.get(points.size() - 1).getX() - r) + " " + (points.get(points.size() - 1).getY() - r));
                points.add(new Point2D(y + x0, -x + y0));
                System.out.println((points.get(points.size() - 1).getX() - r) + " " + (points.get(points.size() - 1).getY() - r));
                points.add(new Point2D(-y + x0, -x + y0));
                System.out.println((points.get(points.size() - 1).getX() - r) + " " + (points.get(points.size() - 1).getY() - r));
                
                g.drawLine(y + x0, x + y0, y + x0, x + y0);
                g.drawLine(-y + x0, x + y0, -y + x0, x + y0);
                g.drawLine(y + x0, -x + y0, y + x0, -x + y0);
                g.drawLine(-y + x0, -x + y0, -y + x0, -x + y0);
            }
        }
        //return points;
    }
    
    
}
