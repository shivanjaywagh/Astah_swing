package View;

import Controller.*;
import Model.*;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * This class is the right panel which allows the user to click on the screen and
 * create class boxes, and link them based on the relationship they choose. It is an observable
 * as the LeftPanel observes it and changes the code accordingly.
 */

public class RightPanel extends JPanel implements Observable {

    public static RightPanel rightPanel;
    public static ArrayList<Box> boxes;
    public static ArrayList<Box> mouseTracker;
    public static ArrayList<RelationShip> relationShips;
    static Blackboard b = Blackboard.getInstance();

    public static ArrayList<Box> getBoxes() {
        return boxes;
    }

    public static ArrayList<RelationShip> getRelationShips() {
        return relationShips;
    }

    private RightPanel() {
    }

    JPanel jPanel;

    public static void getRightPanel() {
        if (rightPanel == null) {
            rightPanel = new RightPanel();
            boxes = new ArrayList<>();
            mouseTracker = new ArrayList<>();
            relationShips = new ArrayList<>();
        }
        rightPanel.setLayout(null);
        rightPanel.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                b.boxcoord(x, y);
                rightPanel.addNewBox(x, y);
            }
        });
    }

    public void addNewBox(int x, int y) {
        Box newBox = new Box(x, y);
        if (newBox.getBoxCreated()) {
            boxes.add(newBox);
            updateRightPanel();
            b.boxData(boxes);
        }
    }

    public void listRenderedBoxes() {
        for (Box x : boxes)
            System.out.print(x + ",");
        System.out.println();
    }

    // Tracks the number of clicks on classes.

    public void boxClickTracker(Box box) {
        mouseTracker.add(box);
        if (mouseTracker.size() == 2) {
            handleRelations();
            mouseTracker.clear();
        }
    }

    /** Asks users to choose between the three given relationships by means of a popup.
     * It stores the response and sends it to the Chain of Responsibility pattern.
     */

    public void handleRelations() {
        Box b1 = mouseTracker.get(0);
        Box b2 = mouseTracker.get(1);
        int response = 0;

        JOptionPane popup = new JOptionPane();
        JRadioButton rel = new JRadioButton("What is the relationship");
        JRadioButton button1 = new JRadioButton("Inheritance");
        JRadioButton button2 = new JRadioButton("Composition");
        JRadioButton button3 = new JRadioButton("Association");
        popup.add(rel);
        popup.add(button1);
        popup.add(button2);
        popup.add(button3);

        String[] options = new String[] { "Inheritance", 
                                            "Composition", 
                                            "Association"
                                        };
        response = JOptionPane.showOptionDialog(null, "Select Relation", "Relation",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options, options[0]);

        Chain iChain = new InheritanceChain();
        Chain aChain = new AssociationChain();
        Chain cChain = new CompositionChain();
        iChain.setChainNext(cChain);
        cChain.setChainNext(aChain);

        iChain.createArrow(response, b1, b2);
        updateRightPanel();
    }

    public void createRelations(int i, int j, int response) {
        Box b1 = boxes.get(i);
        Box b2 = boxes.get(j);
        Chain iChain = new InheritanceChain();
        Chain aChain = new AssociationChain();
        Chain cChain = new CompositionChain();
        iChain.setChainNext(cChain);
        cChain.setChainNext(aChain);
        iChain.createArrow(response, b1, b2);
    }

    public void updateRightPanel() {
        rightPanel.removeAll();
        for (int i = 0; i < boxes.size(); ++i) {
            rightPanel.add(boxes.get(i));
        }

        for (int i = 0; i < relationShips.size(); ++i) {
            Box b1 = relationShips.get(i).getBox1();
            Box b2 = relationShips.get(i).getBox2();
            Arrow arrow = relationShips.get(i).arrow;
            arrow.drawLine(b1.getX(), b1.getY(), b2.getX(), b2.getY());
        }

        rightPanel.sendUpdate();
    }

    public String encode() {
        String encodedBoxes = "";
        ArrayList<Box> boxes = RightPanel.getBoxes();
        for (int i = 0; i < boxes.size(); ++i) {
            encodedBoxes += System.identityHashCode(boxes.get(i)) 
                            + "," + boxes.get(i).toString();
        }

        String encodedRelations = "RELATIONSHIPS:\n";
        for (int i = 0; i < relationShips.size(); ++i) {
            encodedRelations += relationShips.get(i);
        }
        return encodedBoxes + encodedRelations;
    }

    @Override
    public void addSubscriber(Observer o) {
        observerArrayList.add(o);
    }

    @Override
    public void removeSubscriber(Observer o) {
        int observerIndex = observerArrayList.indexOf(o);
        observerArrayList.remove(observerIndex);
    }

    @Override
    public void sendUpdate() {
        for (Observer observer : observerArrayList) {
            observer.update(RightPanel.boxes, RightPanel.relationShips);
        }
    }

}
