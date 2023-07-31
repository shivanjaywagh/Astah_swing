package View;

import Controller.*;
import Model.*;

import java.awt.Graphics;

/**
 * This class implements the Decorator Pattern. It is the basic line over which
 * the other lines can add their features.
 */

public class JustLine implements Arrow {

    int x1;
    int y1;
    int x2;
    int y2;

    public JustLine() {
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        Graphics g = RightPanel.rightPanel.getGraphics();
        g.drawLine(x1, y1, x2, y2);
        g.dispose();
    }

}
