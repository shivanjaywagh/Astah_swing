package View;

import Controller.*;
import Model.*;

import java.awt.Graphics2D;
import java.awt.Color;

/**
 * This class implements the Decorator Pattern. It adds the arrowhead for inheritance
 * over the basic line.
 */

public class InheritanceDecoration extends JustLineDecorator {

    int[] ix = new int[3];
    int[] iy = new int[3];

    public InheritanceDecoration(Arrow arrow) {
        super(arrow);
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        Graphics2D g2d = (Graphics2D) RightPanel.rightPanel.getGraphics();
        super.drawLine(x1, y1, x2, y2);
        double polyheight = 15;
        double x3, y3, x4, y4, xTemp, yTemp;
        double dist = Math.sqrt((Math.pow((x2 - x1),2) + Math.pow((y2 - y1) , 2)));
        double val = polyheight / dist;

        xTemp =  x2 * (1 - val) +  x1 * val ;
        yTemp =  y2 * (1 - val)  + y1 * val;
        double slope = 0.0;

        try {
            slope = (x1 - x2) / (y2 - y1);
        }
        catch (ArithmeticException e){
            System.out.println("Inheritance");
        }

        double polysize = 10;
        double root = Math.sqrt(polysize * polysize / (slope * slope + 1));
        y3 = slope * root + yTemp;
        x3 = xTemp + root;

        y4 = yTemp - slope * root;
        x4 = xTemp - root;

        int[] xPoints = { x2, (int) x3, (int) x4 };
        int[] yPoints = { y2, (int) y3, (int) y4 };

        g2d.setColor(Color.getHSBColor(184, 172, 232));
        g2d.fillPolygon(xPoints, yPoints, 3);
        g2d.setColor(Color.BLUE);
        g2d.drawPolygon(xPoints, yPoints, 3);
    }

}
