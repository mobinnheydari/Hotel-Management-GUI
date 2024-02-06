import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Game {
    //    private String array[]=new String[9];
    private String x;
    private String o;

    public Game() {
        JFrame frame1 = new JFrame();
        JButton button[] = new JButton[9];
        Font font = new Font("Arial", Font.BOLD, 25);
        for (int i = 0; i < 9; i++) {
            button[i] = new JButton(String.valueOf(i + 1));
            button[i].setForeground(new Color(191, 41, 236));
            button[i].setBackground(Color.black);
            button[i].setFont(font);
            frame1.add(button[i]);
        }
        frame1.getContentPane().setBackground(Color.black);
        button[0].setBounds(20, 70, 150, 150);
        button[1].setBounds(170, 70, 150, 150);
        button[2].setBounds(320, 70, 150, 150);
        button[3].setBounds(20, 220, 150, 150);
        button[4].setBounds(170, 220, 150, 150);
        button[5].setBounds(320, 220, 150, 150);
        button[6].setBounds(20, 370, 150, 150);
        button[7].setBounds(170, 370, 150, 150);
        button[8].setBounds(320, 370, 150, 150);
        Random rand = new Random();
        int randomInt = rand.nextInt(2);
//        label.setFont(new Font("Arial",Font.BOLD,17));
        System.out.println(randomInt);
        JLabel l1;
        l1 = new JLabel("....");
        l1.setBounds(200, 20, 100, 30);
        Font font1 = new Font("Arial", Font.BOLD, 17);
        l1.setFont(font);
        final boolean[] status = {true};
        for (int i = 0; i < 9; i++) {
            if (randomInt ==0||randomInt==1) {
                l1.setText(" start player x");
                int finalI = i;
                button[i].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (status[0]) {

                            if (!button[finalI].getText().equals("x")) {
                                button[finalI].setText("x");
                                status[0] = false;
                                check(button, frame1);

                            } else {
                                JOptionPane.showMessageDialog(frame1, "کادر خالی را انتخاب کنید");
                            }
                        }
                        else if (!status[0]) {
                            if (!button[finalI].getText().equals("o")) {
                                button[finalI].setText("o");
                                status[0] = true;
                                check(button, frame1);

                            } else {
                                JOptionPane.showMessageDialog(frame1, "کادر خالی را انتخاب کنید");
                            }

                        }

                    }
                });


            }

        }


        l1.setForeground(Color.white);
        frame1.setSize(500, 600);
        frame1.setLocationRelativeTo(null);
        frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame1.setResizable(false);
        frame1.setLayout(null);
        frame1.setVisible(true);
        frame1.add(l1);
    }

    public void check(JButton button[], JFrame frame1) {

        if (button[0].getText().equals("o") && button[4].getText().equals("o") && button[8].equals("o")) {
            JOptionPane.showMessageDialog(frame1, "player o win");
        }
        if (button[0].getText().equals("x") && button[4].getText().equals("x") && button[8].equals("x")) {
            JOptionPane.showMessageDialog(frame1, "player x win");
        }
        int c = 0;
        int d = 0;
        for (int j = 0; j < 3; j++) {
            if (button[j].getText().equals("o")) {
                c++;
                if (c == 3) {
                    JOptionPane.showMessageDialog(frame1, "player o won");
                }

            } else if (button[j].getText().equals("x")) {
                d++;
                if (d == 3) {
                    JOptionPane.showMessageDialog(frame1, "player x won");
                }
            }
        }
        if (button[3].getText().equals("x") && button[4].getText().equals("x") && button[5].getText().equals("x") || button[6].getText().equals("x") && button[7].getText().equals("x") && button[8].getText().equals("x")) {
            JOptionPane.showMessageDialog(frame1, "player x won");

        }
        if (button[3].getText().equals("o") && button[4].getText().equals("o") && button[5].getText().equals("o") || button[6].getText().equals("o") && button[7].getText().equals("o") && button[8].getText().equals("o")) {
            JOptionPane.showMessageDialog(frame1, "player o won");
        }
        if (button[2].getText().equals("o") && button[4].getText().equals("o") && button[6].getText().equals("o")) {
            JOptionPane.showMessageDialog(frame1, "player o won");

        }
        if (button[2].getText().equals("x") && button[4].getText().equals("x") && button[6].getText().equals("x")) {
            JOptionPane.showMessageDialog(frame1, "player x won");

        }
        if (button[0].getText().equals("x") && button[3].getText().equals("x") && button[6].getText().equals("x")) {
            JOptionPane.showMessageDialog(frame1, "player x won");
        }
        if (button[0].getText().equals("o") && button[3].getText().equals("o") && button[6].getText().equals("o")) {
            JOptionPane.showMessageDialog(frame1, "player x won");
        }

        if (button[1].getText().equals("x") && button[4].getText().equals("x") && button[7].getText().equals("x")) {
            JOptionPane.showMessageDialog(frame1, "player x won");
        }
        if (button[1].getText().equals("o") && button[4].getText().equals("o") && button[7].getText().equals("o")) {
            JOptionPane.showMessageDialog(frame1, "player o won");
        }
        if(button[3].getText().equals("x")&&button[5].getText().equals("x")&&button[8].getText().equals("x")){
            JOptionPane.showMessageDialog(frame1,"player x won");
        }
        if(button[3].getText().equals("o")&&button[5].getText().equals("o")&&button[8].getText().equals("o")){
            JOptionPane.showMessageDialog(frame1,"player o won");
        }
    }
    }
