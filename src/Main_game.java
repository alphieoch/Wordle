//where the main game is
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import static java.lang.String.valueOf;

public class Main_game extends Main {
    //components
    int i = 0;
    String[] WordAttempt = {"X", "X", "X", "X","X","X"};//follow the attempt
    String[] WordCha = {"X","X","X","X","X"};//Separate the word
    String[] Conf = {"X","X","X","X","X"};//Shows what letter is correct
    String[][] Attempt = {{"A1","A2","A3","A4","A5","A6"}};
    public Main_game() {
        //Setup
        //components
        JFrame frame = new JFrame("/Wordle/");
        JPanel panel = new JPanel();
        panel.setLayout((null));
        JLabel label = new JLabel("Welcome to wordle");
        JTextField Input = new JTextField();
        JButton button = new JButton();
        //---for attempts
        JTextField Box1 = new JTextField();
        JTextField Box2 = new JTextField();
        JTextField Box3 = new JTextField();
        JTextField Box4 = new JTextField();
        JTextField Box5 = new JTextField();
        button.setText("Submit");
        //adding the values for frame
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
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
        Input.setBounds(0, 30, 200, 40);
        Input.setFont(new Font("Serif", Font.BOLD, 20));
        //Button
        panel.add(button);
        button.setBounds(0, 70, 200, 40);
        button.setFont(new Font("Serif", Font.BOLD, 20));
        //Attempts
        //1
        panel.add(Box1);
        Box1.setBounds(0, 30, 200, 40);
        Box1.setFont(new Font("Serif", Font.BOLD, 20));

        //text
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (i >= WordAttempt.length) {
                    System.out.println("Gameover");

            } else {
                //To get text fromt the user input
                String x = Input.getText();
                //To get text length
                int len = x.length();
                //System.out.println(len);
                System.out.println(x.length());
                //To get word of the day
                String Word = Main.Text;
                //check if what the user has input is correct
                //if correct
                if (Input.getText().equals(Word)) {
                    System.out.println("Correct");
                }
                //if incorrect
                else {
                    if (len == 5) {
                        //making sure the users text is correct and if not it will
                        System.out.println("It fit but not the right word");
                        WordAttempt[i] = x;
                        System.out.println(Arrays.toString(WordAttempt));
                        System.out.println("attempt:"+(i+1)+"/6");
                        i = i+1;
                        //Now going to go through each character in the text and adding it to the array "WordCha"
                        for (int i = 0; i < WordCha.length; i++){
                            WordCha[i] = String.valueOf(x.charAt(i));
                        }
                        System.out.println(Arrays.toString(WordCha));
                        //Now Going to compare each value
                        for (int i =0; i< Word.length(); i++){
                            //for the 2D array
                            if (x.charAt(i)==Word.charAt(i)){
                                //System.out.println("G"); //if character is equal
                                Conf[i] = "Y";
                                //System.out.println("pos:"+i);
                            }
                            else {
                                //System.out.println("R"); //if character is not equal
                                //check if the word is any other postion
                                for (int i1 = 0; i1 < WordCha.length;i1++){
                                    if (x.charAt(i)==Word.charAt(i1)){
                                        Conf[i]= "N";
                                        System.out.println("We have one here:"+Word.charAt(i1));
                                        //i1=0;//resets back to 0
                                    }
                                    else{
                                        Conf[i] = "L";

                                    }
                                }
                            }
                            }

                        }
                    else {
                        JOptionPane.showMessageDialog(panel,"This is not a 5 letter word try again");
                    }
                    System.out.println(Arrays.toString(Conf));
                }
            }
            }
        });
    }
        public void actionPerformed(ActionEvent e) {


    }
}

