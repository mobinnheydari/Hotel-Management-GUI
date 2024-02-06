import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tourist extends javax.swing.JFrame {
    private String name;
    private String lastname;
    private String email;
    private String password;
    private String code;
    JFrame frame;

    public Tourist(String name, String lastname, String code, String email, String password) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.code = code;
    }

    public Tourist(String email, String password) {
        this.email = email;
        this.password = password;
    }


    public void panel(String array, int a) {
        JFrame frame1 = new JFrame();
        LocalDateTime dateTime = LocalDateTime.now();
        JLabel label = new JLabel(String.valueOf(dateTime));
        JLabel label1 = new JLabel("با موفقیت وارد شدید");
        label.setBounds(370, -30, 300, 200);
        label1.setBounds(210, -30, 200, 200);
        frame1.setSize(900, 700);
        label1.setForeground(Color.white);
        Font font1 = new Font("Arial", Font.BOLD, 17);
        label.setFont(font1);

        label.setForeground(Color.white);
        label.setFont(font1);
        label1.setFont(font1);
        frame1.add(label);
        frame1.add(label1);
        JLabel label2 = new JLabel("نام و نام خانوادگی:");
        JLabel label3 = new JLabel("کد ملی:");
        JLabel label4 = new JLabel("ایمیل:");
        label2.setBounds(720, 0, 200, 200);
        label3.setBounds(500, 0, 200, 200);
        label4.setBounds(250, 0, 200, 200);
        label2.setForeground(new Color(244, 238, 224));
        label3.setForeground(new Color(244, 238, 224));
        label4.setForeground(new Color(244, 238, 224));
        label2.setFont(font1);
        label3.setFont(font1);
        label4.setFont(font1);
        frame1.add(label2);
        frame1.add(label3);
        frame1.add(label4);
        int c = 0;
        String name1 = "";
        String lastname1 = "";
        String code1 = "";
        String email1 = "";

         String chek[]=array.split(",");
         name1=chek[0];
         lastname1=chek[1];
         code1=chek[2];
         email1=chek[3];

        String full = name1 + " " + lastname1;

        JLabel label5 = new JLabel(full);
        JLabel label6 = new JLabel(code1);
        JLabel label7 = new JLabel(email1);
        label5.setBounds(620, 0, 200, 200);
        label6.setBounds(400, 0, 200, 200);
        label7.setBounds(50, 0, 200, 200);
        label5.setForeground(new Color(244, 238, 224));
        label6.setForeground(new Color(244, 238, 224));
        label7.setForeground(new Color(244, 238, 224));
        label5.setFont(font1);
        label6.setFont(font1);
        label7.setFont(font1);
        JButton button3 = new JButton("بازگشت");
        button3.setFont(font1);
        button3.setBackground(new Color(255, 229, 173));
        button3.setForeground(Color.black);
        button3.setBounds(20, 30, 100, 50);
        frame1.add(label5);
        frame1.add(label6);
        frame1.add(label7);
        frame1.add(button3);
        JButton button = new JButton("رزرو اتاق");
        JButton button1 = new JButton("کنسل رزرو");
        JButton button2 = new JButton("تغییر اطلاعات");
        JButton button4=new JButton("تحویل اتاق ");
        button.setBounds(700, 250, 150, 50);
        button1.setBounds(700, 350, 150, 50);
        button2.setBounds(700, 450, 150, 50);
        button4.setBounds(700,550,150,50);
        button.setFont(font1);
        button1.setFont(font1);
        button2.setFont(font1);
        button3.setFont(font1);
        button.setBackground(new Color(79, 69, 87));
        button1.setBackground(new Color(79, 69, 87));
        button.setForeground(new Color(244, 238, 224));
        button1.setForeground(new Color(244, 238, 224));
        button2.setBackground(new Color(79, 69, 87));
        button2.setForeground(new Color(244, 238, 224));
        button4.setFont(font1);
        button4.setBackground(new Color(79, 69, 87));
        button4.setForeground(new Color(244, 238, 224));
        frame1.add(button);
        frame1.add(button1);
        frame1.add(button2);
        frame1.add(button3);
        frame1.add(button4);

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Homepage homepage = new Homepage(frame1);
                frame1.dispose();
            }
        });
//            frame1.getContentPane().setBackground(new Color(152, 33, 118));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rentroom(array, frame1);
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editinformation(frame1,a,array);
            }
        });
        String finalCode1 = code1;
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
Room room=new Room("","");
room.deliveryroom(finalCode1,array,a);
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LocalDateTime localDateTime=LocalDateTime.now();
             Rent rent=new Rent(localDateTime,"",0,"",0,0);
             rent.cnslbook(array);
            }
        });
        ImageIcon imageIcon1=new ImageIcon("12.jpg");
        JLabel label8=new JLabel(imageIcon1);
        label8.setBounds(0,0,900,700);
        label8.setOpaque(false);
        frame1.add(label8);
        frame1.setLocationRelativeTo(null);
        frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame1.setResizable(false);
        frame1.setLayout(null);
        frame1.setVisible(true);
    }



    /* ادیت اطلاعات کاربر*/
    public void editinformation(JFrame frame,int a,String inforamtion) {
        frame.dispose();
        JFrame frame1 = new JFrame();
        Font font = new Font("Arial", Font.BOLD, 20);
        JLabel label = new JLabel("به صفحه تغییر اطلاعات مسافران خوش امدید به نکات زیر توجه داشته باشید");
        JLabel label1 = new JLabel("تمام اطلاعات شما در باکس مربوط به خود قرار دارد برای تغییر هر کدام");
      JLabel label2=new JLabel(" از ان اطلاعات قبلی را حذف واطلاعات جدید را وارد نمایید و کلید ثبت را فشار دهید");
        label.setBounds(400, 5, 1000, 25);
        label1.setBounds(380, 30, 1500, 25);
        label.setFont(font);
        label1.setFont(font);
        label1.setForeground(new Color(240, 236, 229));
        label.setForeground(new Color(240, 236, 229));
        label2.setBounds(50,50,1500,25);
        frame1.add(label);
        frame1.add(label1);
        frame1.add(label2);
        label2.setFont(font);
        label2.setForeground(new Color(240, 236, 229));
        JTextField namee=new JTextField();
        JTextField lastnamee=new JTextField();
        JTextField emaill=new JTextField();
        JTextField passwordd=new JTextField();
        JTextField codee=new JTextField();
//String array[]=new String[9999] ;
        Font font1 = new Font("Arial", Font.BOLD, 16);

        String chek[]=inforamtion.split(",");
        String name=chek[0];
        String lastname=chek[1];
        String code=chek[2];
        String email=chek[3];
        String password=chek[4];
        namee.setText(name);
        lastnamee.setText(lastname);
        codee.setText(code);
        emaill.setText(email);
        passwordd.setText(password);
        namee.setBorder(null);
            lastnamee.setBorder(null);
            codee.setBorder(null);
            emaill.setBorder(null);
            passwordd.setBorder(null);
namee.setBackground(new Color(182, 187, 196));
lastnamee.setBackground(new Color(182, 187, 196));
emaill.setBackground(new Color(182, 187, 196));
codee.setBackground(new Color(182, 187, 196));
passwordd.setBackground(new Color(182, 187, 196));
            namee.setForeground(new Color(49, 48, 77));
            lastnamee.setForeground(new Color(49, 48, 77));
            emaill.setForeground(new Color(49, 48, 77));
            codee.setForeground(new Color(49, 48, 77));
            passwordd.setForeground(new Color(49, 48, 77));
            namee.setFont(font1);
            lastnamee.setFont(font1);
            codee.setFont(font1);
            emaill.setFont(font1);
            passwordd.setFont(font1);
            namee.setBounds(100,200,180,30);
            lastnamee.setBounds(400,200,180,30);
            codee.setBounds(700,200,180,30);
            emaill.setBounds(100,300,180,30);
            passwordd.setBounds(400,300,180,30);

        ImageIcon imageIcon1 = new ImageIcon("poolside.png");
        JLabel label3 = new JLabel(imageIcon1);
        label3.setBounds(0, 0, 1000, 700);
        JLabel label4=new JLabel(":نام");
        label4.setForeground(Color.white);
        label4.setFont(font);
        JLabel label5=new JLabel(":نام خانوادگي");
        label5.setForeground(Color.white);
        label5.setFont(font);
        JLabel label6=new JLabel(":کد ملی");
        label6.setForeground(Color.white);
        label6.setFont(font);
        JLabel label7=new JLabel(":جیمیل");
        label7.setForeground(Color.white);
        label7.setFont(font);
        JLabel label8=new JLabel(":پسورد");
        label8.setForeground(Color.white);
        label8.setFont(font);
        label4.setBounds(30,200,200,30);
        label5.setBounds(300,200,200,30);
        label6.setBounds(630,200,200,30);
        label7.setBounds(35,300,200,30);
        label8.setBounds(330,300,200,30);
        JButton button=new JButton("بازگشت");
        JButton button1=new JButton("ثبت تغیرات");
        button.setForeground(Color.white);
        button1.setForeground(Color.white);
        button.setBackground(new Color(22, 26, 48));
        button1.setBackground(new Color(22, 26, 48));
        button.setFont(font1);
        button1.setFont(font1);
        button.setBounds(50,600,100,50);
        button1.setBounds(850,600,100,50);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel(inforamtion,a);
  frame1.dispose();
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String full=namee.getText()+','+lastnamee.getText()+','+codee.getText()+','+emaill.getText()+','+passwordd.getText()+',';
                acceptedit(full,a);
            }
        });
frame1.add(label4);
frame1.add(label5);
frame1.add(button);
frame1.add(button1);
frame1.add(label6);
frame1.add(label7);
frame1.add(label8);
        frame1.add(namee);
        frame1.add(lastnamee);
        frame1.add(codee);
        frame1.add(emaill);
        frame1.add(passwordd);
        label3.setOpaque(false);
        frame1.add(label3);
        frame1.setSize(1000, 700);
        frame1.setLocationRelativeTo(null);
        frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame1.setResizable(false);
        frame1.setLayout(null);
        frame1.setVisible(true);
    }
public void acceptedit(String information,int a) {
    String check[] = information.split(",");
    String email = check[3];
    String password = check[4];
    String code = check[2];
    String array[] = new String[9999];
    int n = 0;
    try {
        File file = new File("tourist.txt");
        Scanner input = new Scanner(file);
        while (input.hasNextLine()) {
            String TST = input.nextLine();
            array[n] = TST;
            n++;
        }
    } catch (FileNotFoundException e) {
        throw new RuntimeException(e);
    }
    boolean test=false;
for(int i=0;i<n;i++){
    String check1[]=array[i].split(",");
    if(!check1[2].equals(code)&&!check1[3].equals(email)&&!password.equals(check1[4])){
        test=true;
    }
}
if(!test){
    JOptionPane.showMessageDialog(frame,"همچین اطلاعاتی قبلا در سیستم ثبت است");
}
if (test){
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
        c++;
    }
    if(Pattern.matches("[A-Za-z]+(.)+@(.)+[.][A-Za-z]+",email)&&c>=3){
        array[a]=information;
        try {
            FileWriter writer=new FileWriter("tourist.txt");
            for(int i=0;i<n;i++){
                writer.write(array[i]);
                writer.write('\n');
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        JOptionPane.showMessageDialog(frame,"اطلاعات شما با موفقیت تغغیر کرد");
    }
    else {
        JOptionPane.showMessageDialog(frame,"فرم ایمیل یا پسورد شما دارای قدرت نبوده است ");
    }
}




}

    public void check(String email,String password,JFrame frame) {
        int n = 0;
        String array[] = new String[9999];
        try {
            File file = new File("tourist.txt");
            Scanner inpput1 = new Scanner(file);
            while (inpput1.hasNextLine()) {
                String gm = inpput1.nextLine();
                array[n] = gm;
                n++;
            }

        } catch (FileNotFoundException p) {
            p.printStackTrace();
        }
        int k = 0;
        int z = 0;
        String emaill = "";
        String paswordd = "";
        boolean test=false;
//        if(email.equals("")&&paswordd.equals("")){
//            JOptionPane.showMessageDialog(frame,"لطفا فیلد هارو پر کنید");
//        test=true;
//        }
        for (int i = 0; i < n; i++) {
            if(array[i].length()>2){
String check[]=array[i].split(",");
emaill=check[3];
paswordd=check[4];
            if (email.equals(emaill) && password.equals(paswordd)) {
                z = i;
                k++;
                test=true;
                JOptionPane.showMessageDialog(frame,"با موفقیت وارد شدید");
                panel(array[i], z);
                frame.dispose();
                break;
            }
        }

    }
        if (test) {
            JOptionPane.showMessageDialog(frame, "همچین اطلاعاتی در سیستم وجود ندارد");
        }
    }

    public void rentroom(String array1, JFrame frame) {
        frame.dispose();
        JFrame frame1 = new JFrame("رزرو اتاق");
        Font font1 = new Font("Arial", Font.BOLD, 13);
        Font font = new Font("Arial", Font.BOLD, 18);
        String[] array = new String[9999];
        int n = 0;
        try {
            File file = new File("room.txt");
            Scanner inpput1 = new Scanner(file);
            while (inpput1.hasNextLine()) {
                String gm = inpput1.nextLine();
                array[n] = gm;
                n++;
            }
        } catch (FileNotFoundException p) {
            p.printStackTrace();
        }
        int d=0;
        String t="";
        for(int i=0;i<n;i++){

            if(array[i].contains("vip")){
                t=array[i];
array[i]=array[d];
array[d]=t;
                d++;
            }
        }
        int waite = 0;
        int truee = 0;
        int falsee = 0;
        int unavabile = 0;
        for (int i = 0; i < n; i++) {
            String check[] = array[i].split(",");
            String tedad = check[0];
            if (tedad.equals("waite")) {
                waite++;
            }
            if (tedad.equals("true")) {
                truee++;
            }
            if (tedad.equals("false")) {
                falsee++;
            }
            if (tedad.equals("-1")) {
                unavabile++;
            }
        }
        for(int i=0;i<n;i++){
            System.out.println(array[i]);
        }
        int x = 10;
        int y = 150;
        int counter = 0;
        for (int i = 0; i < n; i++) {
            if (array[i].length() > 2) {
                counter++;
            }
        }
        JButton[] buttons = new JButton[n];
        JLabel label = new JLabel("اتاق های رزرو شده");
        JLabel label1 = new JLabel("اتاق های در انتظار");
        JLabel label2 = new JLabel("اتاق های رزرو نشده");
        JLabel label22 = new JLabel("اتاق های غیرفعال");
        JLabel label3 = new JLabel(" تعداد اتاق های غیر قابل رزرو:");
        JLabel label33 = new JLabel("تعداد اتاق های رزرو نشده:");
        JLabel label4 = new JLabel("تعداد اتاق های در حال بررسی:");
        JButton button=new JButton("بازگشت");
        JLabel label5 = new JLabel("تعداد اتاق های رزرو شده");
        JLabel label6 = new JLabel(String.valueOf(unavabile));
        JLabel label7 = new JLabel(String.valueOf(waite));
        JLabel label8 = new JLabel(String.valueOf(truee));
        JLabel label9 = new JLabel(String.valueOf(falsee));
        label.setFont(font);
        label1.setFont(font);
        label2.setFont(font);
        label3.setFont(font);
        label4.setFont(font);
        label5.setFont(font);
        label6.setFont(font);
        label7.setFont(font);
        label8.setFont(font);
        label33.setFont(font);
        label22.setFont(font);
        label9.setFont(font);
        label.setBounds(600, 35, 300, 30);
        label1.setBounds(600, 60, 300, 30);
        label2.setBounds(600, 85, 300, 30);
        label3.setBounds(50, 5, 300, 30);
        label4.setBounds(350, 5, 300, 30);
        label5.setBounds(600, 5, 300, 30);
        label6.setBounds(10, 5, 300, 30);
        label7.setBounds(310, 5, 300, 30);
        label8.setBounds(560, 5, 300, 30);
        label33.setBounds(350, 25, 300, 30);
        label9.setBounds(310, 25, 300, 30);
        label22.setBounds(600, 110, 300, 30);
        label.setForeground(new Color(250, 239, 93));
        label1.setForeground(new Color(255, 0, 7));
        label2.setForeground(new Color(126, 37, 83));
        label3.setForeground(Color.white);
        label4.setForeground(Color.white);
        label5.setForeground(Color.white);
        label6.setForeground(Color.white);
        label7.setForeground(Color.white);
        label8.setForeground(Color.white);
        label33.setForeground(Color.white);
        label9.setForeground(Color.white);
        label22.setFont(font);
        label22.setForeground(new Color(241, 26, 123));
        /* eroorororor baraye addad 2 raghami */
        for (int i = 0; i < n; i++) {
            if (array[i].length() > 2) {
                String test[] = array[i].split(",");
                String result = test[1];
                buttons[i] = new JButton("اتاق شماره:" + result);
                Room room1 = new Room("", "");
                int counter1 = room1.checkstatusroomcolor(result);
                if (counter1 == 0) {
                    buttons[i].setBackground(new Color(250, 239, 93));
                } else if (counter1 == 1) {
                    buttons[i].setBackground(new Color(255, 0, 77));
                } else if (counter1 == 2) {
                    buttons[i].setBackground(new Color(126, 37, 83));
                } else if (counter1 == 3) {
                    buttons[i].setBackground(new Color(241, 26, 123));
                }
                 if(array[i].contains("vip")){
                    buttons[i].setBackground(new Color(255,215,0));
                }
                buttons[i].setFont(font1);
                buttons[i].setForeground(Color.white);
                buttons[i].setBounds(x, y, 100, 70);
                x = x + 100;
                if (x > 700) {
                    x = 0;
                    y = y + 100;
                }
                final int index = i;
                buttons[i].addActionListener(e -> {
                    String testt = buttons[index].getText();
                    Room room = new Room("", "");
                    int addad = Character.getNumericValue(testt.charAt(11));
                    room.checkrent(array1, array[index]);
                });
                frame1.add(buttons[i]);
            }
        }
        button.setBounds(700,600,100,55);
        frame1.add(label);
        frame1.add(button);
        frame1.add(label1);
        frame1.add(label2);
        frame1.add(label3);
        frame1.add(label4);
        frame1.add(label5);
        frame1.add(label6);
        frame1.add(label7);
        frame1.add(label8);
        frame1.add(label9);
        frame1.add(label33);
        frame1.add(label22);
        frame1.getContentPane().setBackground(new Color(29, 43, 83));
        frame1.setSize(800, 700);
        frame1.setLocationRelativeTo(null);
        frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame1.setResizable(false);
        frame1.setLayout(null);
        frame1.setVisible(true);
button.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        panel(array1,0);
        frame1.dispose();
    }
});
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
