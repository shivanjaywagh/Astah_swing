package Controller;

import Model.*;
import View.*;

/**
 * This class takes part in the Chain of Responsibility Pattern. It generates the association
 * regular arrowhead.
 */

public class AssociationChain implements Chain {

    private Chain nextInChain;

    @Override
    public void setChainNext(Chain nextInChain) {
        this.nextInChain = nextInChain;
    }

    @Override
    public void createArrow(int response, Box b1, Box b2) {
        System.out.println("Generating Association Arrow");
        if (response == 2) {
            Arrow arrow = new AssociationDecoration(new JustLine());
            RightPanel.relationShips.add(
                    new RelationShip()
                    .setBox1(b1).setBox2(b2)
                    .setType("Association")
                    .setArrow(arrow));
        } else {
            System.out.println("No relationship selected.");
        }
    }

}
