package View;

import Controller.*;
import Model.*;

import java.awt.Color;
import java.awt.Graphics2D;

public class CompositionDecoration extends JustLineDecorator {

    public CompositionDecoration(Arrow arrow) {
        super(arrow);
    }

    public void drawLine(int x1, int y1, int x2, int y2) {
        Graphics2D g2d = (Graphics2D) RightPanel.rightPanel.getGraphics();
        super.drawLine(x1, y1, x2, y2);
        double x3, y3, x4, y4, xTemp, yTemp, x5, y5;
        float polyheight = 15;
        double dist = Math.sqrt((Math.pow((x2 - x1),2) + Math.pow((y2 - y1) , 2)));
        float val = polyheight / (float)dist;
        double valtemp = 2 * polyheight / (float)dist;

        xTemp = x2 * val  + x1 * (1 - val) ;
        yTemp = y2 * val  + y1 * (1 - val) ;
        double s = 0.0;

        try {
            s = (x1 - x2) / (y2 - y1);
        }
        catch (ArithmeticException e){
            System.out.println("Compostiiton");
        }

        float polywidth = 20;
        double root = Math.sqrt(polywidth * polywidth / (s * s + 1));
        y3 = s * root + yTemp;
        x3 = xTemp + root;

        y4 = yTemp - s * root;
        x4 = xTemp - root;

        x5 = (1 - valtemp) * x1 + valtemp * x2;
        y5 = (1 - valtemp) * y1 + valtemp * y2;

        int[] xPoints = { x1, (int) x3, (int) x5, (int) x4 };
        int[] yPoints = { y1, (int) y3, (int) y5, (int) y4 };

        g2d.setColor(Color.BLACK);
        g2d.fillPolygon(xPoints, yPoints, 4);
    }
    
}
