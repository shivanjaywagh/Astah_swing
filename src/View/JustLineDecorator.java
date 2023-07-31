package View;

import Controller.*;
import Model.*;

import javax.swing.JPanel;

/**
 * This class implements the Decorator Pattern. It is the basic case.
 */

public abstract class JustLineDecorator extends JPanel implements Arrow {

    protected Arrow arrow;

    public JustLineDecorator(Arrow arrow) {
        this.arrow = arrow;
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        this.arrow.drawLine(x1, y1, x2, y2);
    }

}
