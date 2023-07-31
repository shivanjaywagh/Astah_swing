package View;

import Controller.*;
import Model.*;

import java.util.ArrayList;
import javax.swing.JTextArea;
import java.awt.*;

/**
 * This class implements the status panel feature. It displays what activity is 
 * happening on the screen.
 */

public class StatusPanel extends JTextArea implements Observer {

    int prevBoxLength = 0;
    int prevRelationLength = 0;

    public StatusPanel() {
        Font font = new Font("Regular", Font.BOLD, 12);
        setFont(font);
        setForeground(Color.BLUE);
    }

    @Override
    public void update(ArrayList<Box> boxes, ArrayList<RelationShip> relationShip) {
        String update = "";
        if (boxes.size() != prevBoxLength) {
            update += "Added new Class " + boxes.get(prevBoxLength).getClassName();
            prevBoxLength = boxes.size();
        }
        if (relationShip.size() != prevRelationLength) {
            RelationShip x = relationShip.get(prevRelationLength);
            update += " Added new " + x.getType() + " from " + x.getBox1().getClassName() + " to "
                    + x.getBox2().getClassName();
            prevRelationLength = relationShip.size();
        }
        setText(update);
    }

}
