//where the main game is
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

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
        JLabel label = new JLabel("Welcome to wordle");
        JTextField Input = new JTextField();
        JButton button = new JButton();//main button to Submit
        //---for attempts
        JTextField[] field = new JTextField[31];
        //first
        field[0] = new JTextField();
        field[1] = new JTextField();
        field[2] = new JTextField();
        field[3] = new JTextField();
        field[4] = new JTextField();
        //Second row
        field[5]= new JTextField();
        field[6] = new JTextField();
        field[7] = new JTextField();
        field[8] = new JTextField();
        field[9] = new JTextField();
        //thrid row
        field[10] = new JTextField();
        field[11] = new JTextField();
        field[12] = new JTextField();
        field[13] = new JTextField();
        field[14] = new JTextField();
        //forth row
        field[15] = new JTextField();
        field[16] = new JTextField();
        field[17] = new JTextField();
        field[18] = new JTextField();
        field[19] = new JTextField();
        //fith row
        field[20] = new JTextField();
        field[21] = new JTextField();
        field[22] = new JTextField();
        field[23] = new JTextField();
        field[24] = new JTextField();
        //sixth row
        field[25] = new JTextField();
        field[26] = new JTextField();
        field[27] = new JTextField();
        field[28] = new JTextField();
        field[29] = new JTextField();
        field[30] = new JTextField();
        //submit button
        button.setText("Submit");
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
        //Input
        panel.add(Input);
        Input.setBounds(95, 350, 300, 40);
        Input.setFont(new Font("Serif", Font.BOLD, 20));
        Input.setHorizontalAlignment(JTextField.CENTER);
        //Prevents the user from adding more than 5 characters
        Input.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (Input.getText().length() >= 5){
                    e.consume();
                }
            }

        });
        //Button
        panel.add(button);
        button.setBounds(150, 400, 200, 40);
        button.setFont(new Font("Serif", Font.BOLD, 20));
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
                panel.add(field[FN]);
                field[FN].setBounds(117+(x*ix) ,50+(y*iy), 50, 50); //x,y,h,w
                field[FN].setFont(new Font("Serif", Font.BOLD, 20));
                field[FN].setBackground(gray);
                field[FN].setEditable(false);
                System.out.println(FN);
            }
        }
        ///interaction
        int LC; //letter count
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (i >= WordAttempt.length) {
                    System.out.println("Gameover");

                } else {
                    //To get text fromt the user input
                    String x = Input.getText();
                    x = x.toLowerCase();//sets the text to lower case so its not case sensitive
                    //checking if the users input is alphabetical
                    if (x == null || x.equals("") || !x.chars().allMatch(Character::isLetter)){
                        //if the user inputs a non alphabetical it wont allow them to contiune
                        String mes1 =("Please only input alphabetical characters"); //no need to repeat a message
                        System.out.println(mes1);
                        JOptionPane.showMessageDialog(frame, mes1);
                        //testing if it would work in this section
                    }
                    else {
                        //To get word of the day
                        String Word = Main.Text;
                        if (x.equals(Word)) {
                            WordAttempt[i] = x;//adding to the array
                            System.out.println("Correct");
                            Input.setEditable(false);//Stops user from continuing
                            button.setForeground(Color.GREEN);
                            field[0].setBackground(GREEN);
                            JOptionPane.showMessageDialog(frame, "correct");
                            button.setEnabled(false);


                        } else {
                            //x = x.toLowerCase();
                            WordAttempt[i] = x;
                            System.out.println(Arrays.toString(WordAttempt));
                            System.out.println("attempt:" + (i) + "/6");
                            //showing the attempts
                            System.out.println(Arrays.toString(WordCha));
                            //Now Going to compare each value
                            for (int i = 0; i < Word.length(); i++) {
                                if (x.charAt(i) == Word.charAt(i)) {
                                    //System.out.println("G"); //if character is equal
                                    Conf[i] = "G"; // green is mean
                                    //System.out.println("pos:"+i);
                                } else {
                                    //take current letter and compare with other elements
                                    for (int i1 = 0; i1 < Word.length(); i1++) {
                                        System.out.println(Word);
                                        if (Word.charAt(i1) == x.charAt(i)) {
                                            Conf[i] = "Y";
                                            //set the value to be L
                                            System.out.println("We have one here:" + Word.charAt(i1));
                                            //i1=0;//resets back to 0
                                        } else {
                                            //if unavailable to be R (RED)
                                            Conf[i] = "R";
                                        }
                                        System.out.println(Arrays.toString(Conf));
                                    }
                                }
                            }

                        }
                    }
                }
            }
        })
    ;}

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

