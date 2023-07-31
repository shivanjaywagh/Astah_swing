import View.*;
import Model.*;
import javax.swing.*;
import Controller.*;

/**
 * @author Anantha Kandrapu
 * @author Mohammad Danish Khan
 * @author Paromita Roy
 * @author Loka Kalyan Balla
 * @author Shivanjay Wagh
 * @author Venkata Sai Pradeep Nagisetti
 * 
 * This is the driver code that initialises the main frame and creates the layout. 
 * It contains a menu bar consisting of a save and load feature, a status box, a right 
 * panel for the diagram, and a left panel for the code.
 * 
 */

public class Main extends JFrame {

    public static void main(String[] args) {

        JMenu file, help;
        JMenuItem newButton, save, load, about;

        JFrame frame = new JFrame("Final Project 564");

        JMenuBar mb = new JMenuBar();
        file = new JMenu("File");
        help = new JMenu("Help");
        newButton = new JMenuItem("New");
        save = new JMenuItem("Save");
        load = new JMenuItem("Load");
        about = new JMenuItem("About");
        about.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JOptionPane.showMessageDialog(frame, "                    Team: \n Anantha Ramayya Kandrapu  " +
                        "\n Paromita Roy \n Mohammad Danish Khan \n Shivanjay Wagh \n Venkata Sai Pradeep Nagisetti \n " +
                        "Loka Kalyan Balla");
            }
        });

        StatusPanel statusPanel = new StatusPanel();
        file.add(newButton);
        file.add(save);
        file.add(load);
        help.add(about);
        mb.add(file);
        mb.add(help);
        mb.add(statusPanel);

        LeftPanel lp = new LeftPanel();
        RightPanel.getRightPanel();
        RightPanel.rightPanel.addSubscriber(lp);
        RightPanel.rightPanel.addSubscriber(statusPanel);

        save.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String fileName = JOptionPane.showInputDialog(frame,
                        "Please enter the filename.", null);
                String fileContent = RightPanel.rightPanel.encode();
                FileHandle fileHandle = new FileHandle(fileName);
                fileHandle.write(fileContent);
            }
        });

        load.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String fileName = JOptionPane.showInputDialog(frame,
                        "Please enter the filename.", null);
                FileHandle fileHandle = new FileHandle(fileName);
                fileHandle.read();
            }
        });

//        JScrollPane panelPane = new JScrollPane(lp);
//        panelPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        newButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lp.removeAll();
                lp.repaint();
                statusPanel.selectAll();
                statusPanel.replaceSelection(" ");
                RightPanel.rightPanel.removeAll();
                RightPanel.rightPanel.repaint();
            }
        });
        JSplitPane hSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, lp, RightPanel.rightPanel);
        hSplit.setDividerLocation(500);
        JSplitPane vSplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT, hSplit, statusPanel);
        vSplit.setResizeWeight(0.97);
        frame.getContentPane().add(vSplit);
        frame.setJMenuBar(mb);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(2000, 700);
        frame.setVisible(true);

    }
}