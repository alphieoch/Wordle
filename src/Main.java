import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.util.LinkedList;
//for swing
import javax.swing.*;
//For the Jswing GUI


////Main part
public abstract class Main {
    //Text Variable
    static String Text;
    //main application
    public static void main(String args[]){
        // Creating an empty LinkedList where the word generated will be separated
        LinkedList list = new LinkedList();
        RTG text = new RTG();
        //save the generated Text
        Text = text.Text();
        System.out.println("the Target word:" + Text);
        //Now separating each character into its individual form
        for (int i = 0; i < Text.length(); i++) {
            System.out.print("Pos:"+(i+1)+" = "+Text.charAt(i)+",");
            //outputting the link list
            list.add(String.valueOf(Text.charAt(i)));
        }
        System.out.println(list);
        //making the Swing GUI for wordle Insturction panel
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main_game();
            }
        });
    }

    public abstract void actionPerformed(ActionEvent e);
}