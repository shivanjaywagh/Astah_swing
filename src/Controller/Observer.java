package Controller;

import Model.*;
import View.*;;

import java.util.ArrayList;

public interface Observer {

    public void update(ArrayList<Box> boxes, ArrayList<RelationShip> relationShip);

}
