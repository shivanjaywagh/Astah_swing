package Model;

import java.util.ArrayList;

public class Blackboard {

    private static Blackboard blackboard;
    private static ArrayList<Box> box;
    private static ArrayList<Integer> xCoord = new ArrayList<>();
    private static ArrayList<Integer> yCoord = new ArrayList<>();

    private Blackboard(){

    }

    public static Blackboard getInstance() {
        if(blackboard == null){
            blackboard = new Blackboard();
        }
        return blackboard;
    }

    public void boxData(ArrayList<Box> boxes){
        box = boxes;
    }

    public void boxcoord(int x, int y){
        xCoord.add(x);
        yCoord.add(y);
        for(Integer i: xCoord) {
            System.out.println(i);
        }
    }

}
