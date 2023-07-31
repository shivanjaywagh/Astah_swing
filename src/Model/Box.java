package Model;

import Controller.*;
import View.*;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.event.MouseInputListener;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * This class takes care of creating boxes or classes. It gets the coordinates of where the 
 * user clicked on the right panel, and draws a box at that location.
 */

public class Box extends JPanel implements MouseInputListener, MouseMotionListener {

   private int x, y;
   boolean boxCreated = false;
   public String className;
   /* This constructor gets the x and y coordinates of the mouse click.
    * It sets the classname based on the users input.
    */
   public Box(int x, int y, String className) {
      this.className = className;
      addMouseMotionListener(this);
      addMouseListener(this);
      this.setLayout(new GridBagLayout());
      this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
      this.x = x;
      this.y = y;
      this.setLocation(x, y);
      JTextArea ta = new JTextArea();
      this.setSize(200, 40);
      ta.setSize(100, 30);
      ta.setBackground(Color.YELLOW);
      ta.setText(className);
      this.add(ta);
      boxCreated = true;
      this.setBackground(Color.RED);
   }

   /* This constructor displays a popup box requesting the user to input 
    * a classname.
    */

   public Box(int x, int y) {
      className = JOptionPane.showInputDialog("Class Name");
      if ((className != null)) {
         if (className.length() == 0) {
            className = "noClassName";
         }
         addMouseMotionListener(this);
         addMouseListener(this);
         this.setLayout(new GridBagLayout());
         this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
         this.x = x;
         this.y = y;
         this.setLocation(x, y);
         JTextArea ta = new JTextArea();
         this.setSize(200, 40);
         ta.setSize(100, 30);
         ta.setBackground(Color.YELLOW);
         ta.setText(className);
         this.add(ta);
         boxCreated = true;
         this.setBackground(Color.RED);
      }
   }

   public boolean getBoxCreated() {
      return boxCreated;
   }

   // Sets the X and Y coordinates.
   @Override
   public void mouseDragged(MouseEvent e) {
      setX(e.getX() + this.x);
      setY(e.getY() + this.y);
      this.setLocation(this.x, this.y);
      RightPanel.rightPanel.updateRightPanel();
   }

   @Override
   public String toString() {
      return x + "," + y + "," + className + "\n";
   }

   @Override
   public void mousePressed(MouseEvent e) {
   }

   @Override
   public void mouseReleased(MouseEvent e) {
   }

   @Override
   public void mouseClicked(MouseEvent e) {
      RightPanel.rightPanel.boxClickTracker(this);
   }

   @Override
   public void mouseEntered(MouseEvent e) {

   }

   @Override
   public void mouseExited(MouseEvent e) {

   }

   @Override
   public void mouseMoved(MouseEvent e) {

   }

   public int getX() {
      return x;
   }

   public void setX(int x) {
      this.x = x;
   }

   public int getY() {
      return y;
   }

   public void setY(int y) {
      this.y = y;
   }

   public void setBoxCreated(boolean boxCreated) {
      this.boxCreated = boxCreated;
   }

   public String getClassName() {
      return className;
   }

}