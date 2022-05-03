//where the main game is
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

import static java.awt.Color.*;
import static java.lang.String.valueOf;

public class Main_game extends Main {
    //components
    int i = 0;
    String[] WordAttempt = {"X", "X", "X", "X","X","X"};//follow the attempt
    String[] WordCha = {"X","X","X","X","X"};//Separate the word
    String[] Conf = {"X","X","X","X","X"};//Shows what letter is correct
    //LinkedList co containting all the Text field text
    LinkedList<String> JTF = new LinkedList<>();
    public Main_game() {
        //Setup

        //components
        JFrame frame = new JFrame("/Wordle/");
        JPanel panel = new JPanel();
        panel.setLayout((null));
        JLabel label = new JLabel("Wordle");
        JTextField Input = new JTextField();
        JButton button = new JButton();//main button to Submit
        JButton Help = new JButton();//main button to Submit
        //---for attempts
        //2d array to reduce amount
        JTextField[][] field = new JTextField[6][5];
        //first
        field[0][0] = new JTextField();
        field[0][1] = new JTextField();
        field[0][2] = new JTextField();
        field[0][3] = new JTextField();
        field[0][4] = new JTextField();
        //Second row
        field[1][0] = new JTextField();
        field[1][1] = new JTextField();
        field[1][2] = new JTextField();
        field[1][3] = new JTextField();
        field[1][4] = new JTextField();
        //thrid row
        field[2][0] = new JTextField();
        field[2][1] = new JTextField();
        field[2][2] = new JTextField();
        field[2][3] = new JTextField();
        field[2][4] = new JTextField();
        //forth row
        field[3][0] = new JTextField();
        field[3][1] = new JTextField();
        field[3][2] = new JTextField();
        field[3][3] = new JTextField();
        field[3][4] = new JTextField();
        //fith row
        field[4][0] = new JTextField();
        field[4][1] = new JTextField();
        field[4][2] = new JTextField();
        field[4][3] = new JTextField();
        field[4][4] = new JTextField();
        //sixth row
        field[5][0] = new JTextField();
        field[5][1] = new JTextField();
        field[5][2] = new JTextField();
        field[5][3] = new JTextField();
        field[5][4] = new JTextField();
        //Frame
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        panel.setBackground(black);
        //Adding components
        //Panel
        frame.add(panel);
        //label
//        for (int i =0; i< 5; i++){
//            JTextField Box1 = new JTextField();
//            panel.add(label);
//            label.setBounds(0, 0, 200, 40);
//            Box1.setBackground(Color.gray);
//        }
        //Title
        panel.add(label);
        label.setFont(new Font(Font.MONOSPACED, Font.BOLD, 25));
        label.setBounds(196, -24,100,100);
        label.setForeground(Color.WHITE);
        //Help
        panel.add(Help);
        Help.setBounds(10, 10, 40, 40);
        Help.setFont(new Font("Serif", Font.BOLD, 20));
        Help.setForeground(black);
        Help.setFont(new Font(Font.MONOSPACED, Font.BOLD, 30));
        Help.setText("?");
        //Input
        panel.add(Input);
        Input.setBounds(95, 350, 300, 40);
        Input.setFont(new Font("Serif", Font.BOLD, 20));
        Input.setHorizontalAlignment(JTextField.CENTER);
        Input.setFont(new Font(Font.MONOSPACED, Font.BOLD, 30));
        //Prevents the user from adding more than 5 characters
        Input.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (Input.getText().length() >= 5){
                    e.consume();
                }
            }

        });
        //Button (to submit text
        panel.add(button);
        button.setBounds(150, 400, 200, 40);
        button.setFont(new Font("Serif", Font.BOLD, 20));
        button.setForeground(black);
        button.setFont(new Font(Font.MONOSPACED, Font.BOLD, 30));
        button.setText("Submit");
        //Attempts
                //help align
        int ix = 50;
        int iy = 50;
        // row 1
        //1
        int FN = -1;
        for (int y = 0; y <= 5; y++) { //y co,
            for (int x = 0; x < 5; x++) { //x co
                FN++;
                panel.add(field[y][x]);
                field[y][x].setBounds(117+(x*ix) ,50+(y*iy), 50, 50); //x,y,h,w
                field[y][x].setFont(new Font("Serif", Font.BOLD, 20));
                field[y][x].setBackground(gray);
                field[y][x].setEditable(false);
                field[y][x].setHorizontalAlignment(JTextField.CENTER);
                field[y][x].setForeground(Color.white);
                field[y][x].setFont(new Font(Font.MONOSPACED, Font.BOLD, 30));
                //System.out.println(FN);
            }
        }
        button.addActionListener(new ActionListener() {
            int LC = 0; //level count go through each level
            public void actionPerformed(ActionEvent arg0) {
                //to make sure the user is using actual words
                File file = new File("gameDictionary.txt");
                if (i >= WordAttempt.length) {
                    System.out.println("Gameover");

                } else {
                    //To get text fromt the user input
                    String x = Input.getText();
                    x = x.toLowerCase();//sets the text to lower case so its not case sensitive
                    //checking if the users input is alphabetical
                    if(x == null || x.equals("") ){
                        System.out.println("Please enter characters");
                        JOptionPane.showMessageDialog(frame,"Please enter a word");
                    }
                    else {
                        if (!x.chars().allMatch(Character::isLetter)){
                            //if the user inputs a non alphabetical it wont allow them to contiune
                            String mes1 =("Please only input alphabetical characters"); //no need to repeat a message
                            System.out.println(mes1);
                            JOptionPane.showMessageDialog(frame, mes1);
                            //testing if it would work in this section
                        }
                        else {
                            //checking if the word is valid- =_= --- 1 issue
                            Wordcheck WRD = new Wordcheck(x);
                            }
                            //To get word of the day
                            String target = Main.Text;
                        //havent been deleted as requested ^
                            if (x.equals(target)) {
                                WordAttempt[i] = x;//adding to the array
                                System.out.println("Correct");
                                Input.setEditable(false);//Stops user from continuing
                                button.setForeground(Color.GREEN);
                                //field[x][0].setBackground(GREEN);///--------
                                JOptionPane.showMessageDialog(frame, "Congratulations completed in:"+ " "+(LC+1)+" attempts."+ " Reset program to have another go.");
                                for (int i = 0; i < 5;i++ ){
                                    field[LC][i].setBackground(GREEN);
                                    field[LC][i].setText(String.valueOf(x.charAt(i)));
                                }
                                button.setEnabled(false);
                            } else {
                                //x = x.toLowerCase();
                                WordAttempt[i] = x;
                                System.out.println("attempt:" + (i+1) + "/6");
                                //showing the attempts
                                System.out.println(Arrays.toString(WordCha));
                                //Now Going to compare each value
                                for (int i = 0; i < target.length(); i++) {
                                    if (x.charAt(i) == target.charAt(i)) {
                                        //System.out.println("G"); //if character is equal
                                        Conf[i] = "G"; // green is mean
                                        field[LC][i].setBackground(GREEN);//setting colour green
                                        field[LC][i].setText(String.valueOf(x.charAt(i)));
                                        //System.out.println("pos:"+i);
                                    }
                                    else if (x.charAt(i) != target.charAt(i)){
                                        for (int i1 = 0; i1 < target.length(); i1++) {
                                        if (target.charAt(i1) == x.charAt(i)) {
                                            Conf[i] = "Y";
                                            field[LC][i1].setBackground(YELLOW);//setting colour green
                                            field[LC][i].setText(String.valueOf(x.charAt(i)));
                                            System.out.println("We have one here:" + target.charAt(i1));
                                            //i1=0;//resets back to 0
                                        } else {
                                            //if unavailable to be R (RED)
                                            Conf[i] = "R";
                                            field[LC][i1].setBackground(RED);//setting colour green
                                            field[LC][i].setText(String.valueOf(x.charAt(i)));
                                        }
                                        }
                                    }
                                }
                                LC++;
                                System.out.println("The target word is:"+target);
                                System.out.println(Arrays.toString(WordAttempt));
                            }
                        }
                    }
                }
        });
        Help.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Please enter characters");
                JOptionPane.showMessageDialog(frame,"Welcome to wordle." +
                        "Fill in the gaps and see if you can guess the word you have six attemopt good luck - Alphonce Ochieng");

            }
        })
    ;}

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

