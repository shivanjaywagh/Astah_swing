package View;

import Controller.*;
import Model.*;
import Model.Box;

import javax.swing.*;
import java.util.ArrayList;
import java.awt.FlowLayout;

/**
 * This class creates a left panel which holds all the code. It acts as an observer, 
 * and observes the RightPanel for any changes in the UML diagram, and updates the
 * code on the left accordingly.
 */

public class LeftPanel extends JPanel implements Observer {
    
    String text_output = "";
    int len = 0;
    private ArrayList<SubLeftPanel> subLeftPanels;
    ArrayList<Model.Box> boxes;
    ArrayList<RelationShip> relationShips;

    public LeftPanel() {
        boxes = new ArrayList<>();
        subLeftPanels = new ArrayList<>();
        setLayout(new FlowLayout(FlowLayout.LEADING, 10, 10));

    }

    @Override
    public void update(ArrayList<Model.Box> boxes, ArrayList<RelationShip> relationShips) {
        this.boxes = boxes;
        this.relationShips = relationShips;
        writeString();
    }

    // Creates the code to be displayed based on the diagram.
    
    public void writeString() {
        removeAll();
        subLeftPanels.clear();

        for (Model.Box each_box : boxes) {
            SubLeftPanel codePanel = new SubLeftPanel(6, 45);
            codePanel.setClassNameText(each_box.className);
            codePanel.setBox(each_box);
            codePanel.setCodeText();
            subLeftPanels.add(codePanel);
        }

        for (RelationShip relationShip : relationShips) {
            SubLeftPanel foundPanel = findSubLeftPanel(relationShip.getBox1());
            if (foundPanel != null) {
                if (relationShip.getType() == "Association") {
                    foundPanel.setAssociationText(relationShip.getBox2().getClassName());
                    foundPanel.setCodeText();
                } else if (relationShip.getType() == "Inheritance") {
                    foundPanel.setInheritanceText(relationShip.getBox2().getClassName());
                    foundPanel.setCodeText();
                } else if (relationShip.getType() == "Composition") {
                    foundPanel.setCompositionText(relationShip.getBox2().getClassName());
                    foundPanel.setCodeText();
                }
            }

        }

        for (SubLeftPanel subLeftPanel : subLeftPanels) {
            add(subLeftPanel);
        }
    }

    public SubLeftPanel findSubLeftPanel(Box box) {
        for (SubLeftPanel subLeftPanel : subLeftPanels) {
            if (box == subLeftPanel.box) {
                return subLeftPanel;
            }
        }
        return null;
    }

}
