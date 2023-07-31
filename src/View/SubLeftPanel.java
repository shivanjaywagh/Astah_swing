package View;

import Model.Box;

import Controller.*;
import Model.*;

import java.util.ArrayList;
import javax.swing.JTextArea;

/**
 * This class creates the LeftPanel code as a String.
 */

public class SubLeftPanel extends JTextArea {

    String classNameText;
    ArrayList<String> association;
    Box box;
    ArrayList<String> inheritance;
    ArrayList<String> composition;

    public SubLeftPanel(int rows, int cols) {
        super(rows, cols);
        setLineWrap(true);
        association = new ArrayList<>();
        inheritance = new ArrayList<>();
        composition = new ArrayList<>();
    }

    public String getAssociationText() {
        String relations = "";
        for (String s : association) {
            relations = relations + "\n" + s + "\n";
        }
        return relations;
    }

    public String getInheritanceText() {
    	if(inheritance.size() == 0) return "";
        String relations = " extends ";
        for (String s : inheritance) {
            relations = relations + s ;
        }
        return relations;
    }

    public String getCompositionText() {
        String relations = "";
        for (String s : composition) {
            relations = relations + s + "\n";
        }
        return relations;
    }

    public void setCodeText() {
        String generatedString = "class " + classNameText + getInheritanceText() + 
                                " { \n" + getCompositionText() 
                                + getAssociationText() + "\n}";
        setText(generatedString);
    }
    

    public String getClassNameText() {
        return classNameText;
    }

    public void setClassNameText(String classNameText) {
        this.classNameText = classNameText;
    }

    public void setAssociationText(String relationsText) {
        String assocaitonString = "\t method() {\n \t\t" + relationsText + "\n \t}";
        this.association.add(assocaitonString);
    }
    
    public void setInheritanceText(String relationsText) {
        String inheritanceString = relationsText;
        this.inheritance.add(inheritanceString);
    }
    
    public void setCompositionText(String relationsText) {
        String compositionString = relationsText;
        this.composition.add(compositionString);
    }

    public Box getBox() {
        return box;
    }

    public void setBox(Box box) {
        this.box = box;
    }

}
