package Controller;

import Model.*;
import View.*;

/**
 * This class takes part in the Chain of Responsibility Pattern. It generates the composition
 * filled-diamond arrowhead.
 */

public class CompositionChain implements Chain {

    private Chain nextInChain;

    @Override
    public void setChainNext(Chain nextInChain) {
        this.nextInChain = nextInChain;
    }

    @Override
    public void createArrow(int response, Box b1, Box b2) {
        if (response == 1) {
            System.out.println("Generating Composition Arrow");
            Arrow arrow = new CompositionDecoration(new JustLine());
            RightPanel.relationShips.add(
                    new RelationShip()
                    .setBox1(b1).setBox2(b2)
                    .setType("Composition")
                    .setArrow(arrow));
        } else {
            nextInChain.createArrow(response, b1, b2);
        }
    }

}
