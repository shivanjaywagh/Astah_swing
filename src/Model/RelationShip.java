package Model;

import View.*;

/**
 * This class figures out which boxes were clicked on to connect them based on their
 * relationsip.
 */

public class RelationShip {

    String type;
    Box box1;
    Box box2;
    public Arrow arrow;

    public String getType() {
        return type;
    }

    public RelationShip setType(String type) {
        this.type = type;
        return this;
    }

    public Box getBox1() {
        return box1;
    }

    public RelationShip setBox1(Box box1) {
        this.box1 = box1;
        return this;
    }

    public Box getBox2() {
        return box2;
    }

    @Override
    public String toString() {
        return type + "," + System.identityHashCode(box1) + "," + System.identityHashCode(box2)
                + "\n";
    }

    public RelationShip setBox2(Box box2) {
        this.box2 = box2;
        return this;
    }

    public Arrow getArrow() {
        return arrow;
    }

    public RelationShip setArrow(Arrow arrow) {
        this.arrow = arrow;
        return this;
    }

    public RelationShip() {
    }

}
