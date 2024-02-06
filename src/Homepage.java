import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.*;

public class Homepage extends javax.swing.JFrame {
    JFrame frame;
    public Homepage(JFrame frame12){
        frame12.dispose();
        frame=new JFrame("Homepage");
        ImageIcon imageIcon=new ImageIcon("2.jpg");
        JLabel label=new JLabel(imageIcon);
        label.setBounds(0,0,500,500);
        JButton button=new JButton("مدیر");
        JButton button1=new JButton("کارمند");
        JButton button2=new JButton("مسافر");
        JButton button3=new JButton("سرگرمی");
        button3.setBounds(80,350,300,30);
        button.setBounds(80,50,300, 30);
        button1.setBounds(80,150,300,30);
        button2.setBounds(80,250,300,30);
        button.setForeground(Color.black);
        button1.setForeground(Color.black);
        button2.setForeground(Color.black);
        button1.setBackground(Color.white);
        button.setBackground(Color.white);
        button2.setBackground(Color.white);
        button3.setBackground(Color.white);
        button3.setForeground(Color.black);
            frame.add(button);
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.setSize(500,500);
        frame.add(label);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame1=new JFrame("مدیریت");
                ImageIcon imageIcon1=new ImageIcon("manag.jpg");
JLabel label1=new JLabel(imageIcon1);
label1.setBounds(0,0,500,500);
JLabel label2=new JLabel("به صفحه ورود مدیریت خوش امدید");
label2.setForeground(new Color(153, 153, 153));
label2.setBounds(150,-100,200,250);
                Font font = new Font("Arial", Font.PLAIN, 17);
                label2.setFont(font);
                JLabel label3=new JLabel("ایمیل");
                JLabel label4=new JLabel("رمز عبور");
//                label3.setForeground(Color.white);
//                label4.setForeground(Color.white);
label3.setBounds(50,150,300,25);
                label4.setBounds(40,250,300,25);
label2.setFont(font);
label3.setFont(font);
label4.setFont(font);
                frame1.setSize(500,500);
label1.setOpaque(false);
JPanel panel=new JPanel();
frame1.add(label1);
JTextField textField=new JTextField();
JTextField textField1=new JTextField();
textField.setBackground(Color.white);
textField1.setBackground(Color.white);
textField.setBounds(80,150,300,25);
textField1.setBounds(80,250,300,25);
frame1.add(label2);
frame1.add(label3);
frame1.add(label4);
                JButton button3=new JButton("ورود");
                button3.setBounds(45,380,400,50);
                button3.setBackground(Color.black);
                button3.setForeground(Color.white);
                frame1.add(button3);
frame1.add(textField);
frame1.add(textField1);
button3.setFont(font);
button3.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        Manager manager=new Manager();
        String email=textField.getText();
       String password=textField1.getText();
       if(email.equals(manager.getEmail())&&password.equals(manager.getPassword())){
           manager.show(frame1);
       }
    }
});
frame1.add(panel);
panel.add(label1);
panel.setOpaque(false);
label1.setOpaque(false);
                frame1.setLocationRelativeTo(null);
                frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame1.setResizable(false);
                frame1.setVisible(true);
frame.dispose();
            }
        });
        /*employee*/

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                JFrame frame1 = new JFrame();
                JTextField textField = new JTextField();

                JTextField textField1 = new JTextField();
                Font font=new Font("Arial",Font.BOLD,17);
                textField.setBounds(100, 50, 250, 25);
                textField1.setBounds(100, 150, 250, 25);
                textField.setForeground(new Color(239, 225, 209));
                textField1.setForeground(new Color(239, 225, 209));
                textField.setBackground(new Color(167, 130, 149));
                textField1.setBackground(new Color(167, 130, 149));
                textField.setBorder(null);
                textField1.setBorder(null);
                textField.setFont(font);
                textField1.setFont(font);
                frame1.add(textField);
                frame1.add(textField1);
                JLabel label1=new JLabel("ایمیل");
                JLabel label2=new JLabel("رمز عبور");
                label1.setBounds(50,50,250,25);
                label2.setBounds(35,150,250,25);
label1.setFont(font);
label2.setFont(font);
label1.setForeground(new Color(239, 225, 209));
label2.setForeground(new Color(239, 225, 209));
                JButton button4 = new JButton("ورورد");
      frame1.add(label1);
      frame1.add(label2);
                button4.setFont(font);
                button4.setBounds(100, 300, 100, 30);
                button4.setBackground(new Color(63, 46, 62));
                button4.setForeground(new Color(239, 225, 209));
                frame1.add(button4);
                frame1.setSize(500, 500);
                JButton button3=new JButton("بازگشت");
                button3.setFont(font);
                button3.setBounds(400, 10, 80, 40);
                button3.setBackground(new Color(51, 29, 44));
                button3.setForeground(new Color(239, 225, 209));
                frame1.add(button3);
                ImageIcon imageIcon1=new ImageIcon("20.jpg");
                JLabel label11=new JLabel(imageIcon1);
//                label11.setOpaque(false);
                label11.setBounds(0,0,500,500);
                frame1.add(label11);
                button4.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Employe employe = new Employe("", "", "", 0, "", "");
                        employe.checkemployee(textField.getText(), textField1.getText(),frame1);
                        textField.setText("");
                        textField1.setText("");
                    }
                });
                button3.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Homepage homepage=new Homepage(frame1);
                    }
                });

                frame1.setLocationRelativeTo(null);
                frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame1.setResizable(false);
                frame1.setLayout(null);
                frame1.setVisible(true);
//                frame.dispose();
            }
            });

        /* person*/

button2.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame jframe=new JFrame();
        JButton button3=new JButton("ثبت نام");
        JButton button4=new JButton("ورود");
        JButton button5=new JButton("بازگشت");
        button3.setBounds(60,100,300,35);
        button4.setBounds(60,200,300,35);
        button5.setBounds(60,300,300,35);
        jframe.add(button3);
        jframe.add(button4);
        jframe.add(button5);
        jframe.setSize(400,400);
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Homepage homepage=new Homepage(jframe);
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame1=new JFrame();
                JTextField textField=new JTextField();
                JTextField textField1=new JTextField();
                JTextField textField2=new JTextField();
                JTextField textField3=new JTextField();
JTextField textField4=new JTextField();
                ImageIcon imageIcon1=new ImageIcon("1.jpg");
                JLabel jLabel=new JLabel(imageIcon1);
                JLabel name=new JLabel("نام");
                JLabel lastname=new JLabel ("نام خانوادگی");
                JLabel code=new JLabel("کد ملی");
                JLabel email=new JLabel("ایمیل");
                JLabel password=new JLabel("پسورد");
                name.setForeground(Color.white);
                lastname.setForeground(Color.white);
                code.setForeground(Color.white);
                email.setForeground(Color.white);
                password.setForeground(Color.white);
                name.setBounds(50,50,200,200);
                lastname.setBounds(50,120,200,200);
                code.setBounds(50,200,200,200);
                email.setBounds(50,280,200,200);
                password.setBounds(50,350,200,200);
                jLabel.setBounds(0,0,600,600);
                textField.setBackground(new Color(153, 153, 153));
                textField1.setBackground(new Color(153, 153, 153));
                textField2.setBackground(new Color(153, 153, 153));
                textField3.setBackground(new Color(153, 153, 153));
                textField4.setBackground(new Color(153, 153, 153));
                textField.setForeground(Color.white);
                textField1.setForeground(Color.white);
                textField2.setForeground(Color.white);
                textField3.setForeground(Color.white);
                textField4.setForeground(Color.white);
                textField.setBounds(120,130,300,25);
                textField1.setBounds(120,210,300,25);
                textField2.setBounds(120,290,300,25);
textField3.setBounds(120,370,300,25);
textField4.setBounds(120,440,300,25);
                JButton button3=new JButton("ثبت نام");
                button3.setBackground(Color.white);
                button3.setBounds(75,490,400,50);
                frame1.add(button3);
                frame1.add(textField);
                frame1.add(textField1);
                frame1.add(textField3);
                frame1.add(textField2);
                frame1.add(textField4);
                frame1.add(name);
                frame1.add(lastname);
                frame1.add(code);
                frame1.add(email);
                frame1.add(password);

                frame1.add(jLabel);
                frame1.setSize(600,600);
                button3.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Manager manager=new Manager();
                        String name=textField.getText();
                        String lastname=textField1.getText();
                        String code=textField2.getText();
                        String email=textField3.getText();
                        String password=textField4.getText();
                        Pattern pattern = Pattern.compile("[a-z]");
                        Matcher matcher = pattern.matcher(password);
                        int c = 0;
                        if (matcher.find()) {
                            c++;
                        }
                        Pattern pattern1 = Pattern.compile("[A-Z]");
                        Matcher matcher1 = pattern1.matcher(password);
                        if (matcher1.find()) {
                            c++;
                        }
                        Pattern pattern2 = Pattern.compile("[0-9]");
                        Matcher matcher2 = pattern2.matcher(password);
                        if (matcher2.find()) {
                            c++;
                        }
                        int d = 0;
                        if (Pattern.matches(".*[\\W].*",password)) {
                            c++;
                        }
                        Pattern pattern4 = Pattern.compile("(.){9}");
                        Matcher matcher4 = pattern4.matcher(password);
                        if (matcher4.find()) {
                            c++;}

                          if(Pattern.matches("[A-Za-z]+(.)+@(.)+[.][a-z]+", email)&&c>=3) {
                        Tourist tourist = new Tourist(name, lastname, code, email, password);
                        manager.addperson(tourist);
                        textField.setText(null);
                        textField1.setText(null);
                        textField2.setText(null);
                        textField3.setText(null);
                        textField4.setText(null);
                    }
                    else {
                        JOptionPane.showMessageDialog(frame1,"ایمیل یا پسورد شما دارای قدرت امنیتی نبوده است");
                    }

                    }
                });
                frame1.setLocationRelativeTo(null);
                frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame1.setResizable(false);
                frame1.setLayout(null);
                frame1.setVisible(true);
                jframe.dispose();
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImageIcon imageIcon1=new ImageIcon("4.jpg");
                JLabel label1=new JLabel(imageIcon1);
                label1.setBounds(0,0,500,500);
JFrame frame1=new JFrame("ورود کاربر");
JTextField textField=new JTextField();
JTextField textField1=new JTextField();
JLabel label2=new JLabel("ایمیل");
                JLabel label3=new JLabel("رمزعبور");
Font font=new Font("Arial",Font.BOLD,16);
label2.setBounds(60,50,250,25);
label3.setBounds(60,150,250,25);
textField.setBounds(110,50,250,25);
textField1.setBounds(110,150,250,25);
textField.setBackground(Color.black);
textField1.setBackground(Color.black);
textField.setForeground(Color.white);
textField1.setForeground(Color.white);
label2.setForeground(Color.white);
JButton button5=new JButton("ورود");
                label3.setForeground(Color.white);
label2.setFont(font);
                label3.setFont(font);
frame1.add(label2);
frame1.add(label3);
button5.setBackground(Color.black);
button5.setForeground(Color.white);
button5.setBounds(100,350,250,30);
button5.setFont(font);
textField.setFont(font);
textField1.setFont(font);

button5.setBorder(null);
frame1.add(textField);
                frame1.add(textField1);
                frame1.add(button5);
                frame1.setSize(500,500);
                frame1.add(label1);
frame1.setLocationRelativeTo(null);
                frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame1.setResizable(false);
                frame1.setLayout(null);
                frame1.setVisible(true);
                jframe.dispose();
button5.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String email1=textField.getText();
        String password1=textField1.getText();
        System.out.println(email1);
        System.out.println(password1);
        Tourist tourist=new Tourist(email1,password1);
        tourist.check(email1,password1,frame1);
        textField.setText(null);
        textField1.setText(null);

    }
});


            }
        });

        jframe.setLocationRelativeTo(null);
        jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jframe.setResizable(false);
        jframe.setLayout(null);
        jframe.setVisible(true);
        frame.dispose();
    }
    }
);
button3.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        Game game=new Game();
    }
});
}

}
