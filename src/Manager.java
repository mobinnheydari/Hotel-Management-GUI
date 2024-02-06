import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Manager extends javax.swing.JFrame {
    private String name = "mobin";
    private String lastname = "heydari";
    private String email = "1";
    private String password = "1";
    ArrayList<Tourist> tourist = new ArrayList<>();
    ArrayList<Employe> employes = new ArrayList<>();
    JFrame frame;
ArrayList<Room>rooms=new ArrayList<>();

    public void show(JFrame frame) {
        frame.dispose();
        JFrame frame1 = new JFrame("مدیریت");
        JLabel label = new JLabel("به صفحه مدیریت خوش امدید");
        label.setBounds(420, -200, 500, 500);
        Font font = new Font("Arial", Font.BOLD, 24);
        Font font1 = new Font("Arial", Font.BOLD, 16);
        label.setFont(font);
        frame1.add(label);
        label.setForeground(new Color(69, 25, 82));
        JLabel namee = new JLabel("نام و نام خوانوادگی:");
        JLabel email = new JLabel("ایمیل:");
        String full = getName() + getLastname();
        JLabel label2 = new JLabel(full);
        JLabel label3 = new JLabel(getEmail());
        namee.setForeground(new Color(69, 25, 82));
        namee.setBounds(900, -50, 300, 300);
        email.setBounds(500, -50, 300, 300);
        label2.setBounds(700, -50, 300, 300);
        label3.setBounds(250, -50, 300, 300);
        namee.setFont(font1);
        email.setFont(font1);
        label2.setFont(font1);
        label3.setFont(font1);
        frame1.add(namee);
        frame1.add(email);
        frame1.add(label2);
        frame1.add(label3);
        JButton button = new JButton("افزودن کارمند");
        JButton button1 = new JButton("حذف کارمند");
        JButton button2 = new JButton("تغییر اطلاعات");
        JButton button3=new JButton("اضافه کردن اتاق");
        JButton button4=new JButton("حذف کردن اتاق");
        JButton button5=new JButton("اضافه کردن اتاق vip");
//        JButton button6=new JButton("کارمندان");
        JButton button7=new JButton("حقوق کارمندان");
        JButton button8=new JButton("هتل");
        JButton button9=new JButton("بازگشت");
        button.setBounds(870, 200, 200, 30);
        button1.setBounds(870, 300, 200, 30);
        button2.setBounds(870, 400, 200, 30);
        button3.setBounds(870,500,200,30);
        button4.setBounds(30,200,200,30);
        button5.setBounds(30,300,200,30);
//        button6.setBounds(30,300,200,30);
        button7.setBounds(30,400,200,30);
        button8.setBounds(30,500,200,30);
        button9.setBounds(30,600,200,30);
        button.setForeground(new Color(69, 25, 82));
        button1.setForeground(new Color(69, 25, 82));
        button2.setForeground(new Color(69, 25, 82));
        button.setBackground(new Color(243, 159, 90));
        button1.setBackground(new Color(243, 159, 90));
        button2.setBackground(new Color(243, 159, 90));
        button3.setForeground(new Color(69, 25, 82));
        button4.setForeground(new Color(69, 25, 82));
        button3.setBackground(new Color(243, 159, 90));
        button4.setBackground(new Color(243, 159, 90));
button8.setBackground(new Color(243, 159, 90));
button8.setForeground(new Color(69, 25, 82));
button8.setFont(font1);
        button5.setForeground(new Color(69, 25, 82));
//        button6.setForeground(new Color(69, 25, 82));
        button5.setBackground(new Color(243, 159, 90));
//        button6.setBackground(new Color(243, 159, 90));
        button7.setForeground(new Color(69, 25, 82));
        button7.setBackground(new Color(243, 159, 90));
        button.setFont(font1);
        button1.setFont(font1);
        button2.setFont(font1);
        button3.setFont(font1);
        button4.setFont(font1);
        button5.setFont(font1);
//        button6.setFont(font1);
        button7.setFont(font1);
frame1.add(button);
frame1.add(button1);
frame1.add(button2);
frame1.add(button3);
frame1.add(button4);
frame1.add(button5);
//frame1.add(button6);
frame1.add(button7);
frame1.add(button8);
frame1.add(button8);
frame1.add(button9);
button5.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
   roomvip(frame1);
    }
});
button4.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
       Room room=new Room("","");
       room.cnclroom(frame1);
    }
});
button.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {

        addempol(frame1);
    }
});
button1.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        deletemployee(frame1);

    }
});
button3.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        iroom(frame1);
    }
});
button8.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
Hotel hotel=new Hotel(frame1);
    }
});
        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Homepage homepage=new Homepage(frame1);
            }
        });
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
salary(frame1);
            }
        });

        frame1.setSize(1100, 700);
        frame1.getContentPane().setBackground(new Color(174, 68, 90));
        frame1.setLocationRelativeTo(null);
        frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame1.setResizable(false);
        frame1.setLayout(null);
        frame1.setVisible(true);
    }
    /*vip room */
    public void roomvip(JFrame frame){
        frame.dispose();
        JFrame frame1=new JFrame("اضافه کردن اتاق");
        Font font1 = new Font("Arial", Font.BOLD, 16);
        JTextField textField=new JTextField();
        JTextField textField1=new JTextField();
        JLabel label1=new JLabel("تعداد تخت");
        JLabel label2=new JLabel("قیمت");
        label1.setFont(font1);
        label2.setFont(font1);
        textField1.setBorder(null);
        textField.setBorder(null);
        label1.setForeground(new Color(224, 204, 190));
        label2.setForeground(new Color(224, 204, 190));
        label1.setBounds(50,100,200,30);
        label2.setBounds(50,150,200,30);
        textField.setBounds(120,100,200,30);
        textField1.setBounds(120,150,200,30);
        textField1.setFont(font1);
        textField.setFont(font1);
        frame1.add(label1);
        frame1.add(label2);
        JButton button=new JButton("اضافه اتاق");
        JButton button1=new JButton("بازشگت");
        textField.setBackground(Color.white);
        textField1.setBackground(Color.white);
        textField.setForeground(Color.black);
        textField1.setForeground(Color.black);
        button1.setFont(font1);
        button1.setForeground(new Color(238, 237, 235));
        button1.setBackground( new Color(116, 114, 100));
        button1.setBounds(20,20,100,40);
        button.setBounds(120,350,200,35);
        button.setBackground(new Color(116, 114, 100));
        button.setForeground(new Color(238, 237, 235));
        button.setFont(font1);
        frame1.add(textField);
        frame1.add(textField1);
        frame1.add(button);
        frame1.add(button1);
        ImageIcon imageIcon1=new ImageIcon("22.jpg");
        JLabel label=new JLabel(imageIcon1);
        label.setOpaque(false);
        label.setBounds(0,0,500,500);
        frame1.setSize(500, 500);
        frame1.add(label);
        frame1.setLocationRelativeTo(null);
        frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame1.setResizable(false);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
Room room=new Room(textField.getText(),textField1.getText());
room.viproom();
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                show(frame1);
            }
        });
        frame1.setLayout(null);
        frame1.setVisible(true);

    }
    /*hoghogh karmandan*/
    public void salary(JFrame frame){
frame.dispose();
JFrame frame1=new JFrame();
        Font font=new Font("Arial",Font.BOLD,17);

JLabel label=new JLabel("حقوق کارمندان");
label.setForeground(Color.black);
label.setBounds(200,10,250,30);
label.setFont(font);
frame1.add(label);
JButton button=new JButton("تغییر حقوق");
JButton button1=new JButton("پرداخت حقوق");
JButton button2=new JButton("بازگشت");
button.setFont(font);
button1.setFont(font);
button2.setFont(font);
button2.setBounds(150,250,250,35);
button.setBounds(150,50,250,35);
        button1.setBounds(150,150,250,35);
button.setBackground(new Color(226, 110, 229));
        button1.setBackground(new Color(226, 110, 229));
button.setForeground(new Color(243, 248, 255));
button1.setForeground(new Color(243, 248, 255));
        button2.setBackground(new Color(73, 16, 139));
        button2.setForeground(new Color(243, 248, 255));
frame1.getContentPane().setBackground(new Color(126, 48, 225));
frame1.add(button);
frame1.add(button1);
frame1.add(button2);
button1.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {

        salarypayment();
    }
});
button.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String input=JOptionPane.showInputDialog(frame,"کد ملی کارمند مورد نظر را وارد کنید");
        String array[]=new String[9999];
        int n=0;
        try {
            File file=new File("employee.txt");
            Scanner input1=new Scanner(file);
            while (input1.hasNextLine()){
                String tst=input1.nextLine();
                array[n]=tst;
                n++;
            }

        } catch (FileNotFoundException e1) {
            throw new RuntimeException(e1);
        }
        int x=0;
        boolean test=false;
        String name="";
        String lastname="";
        String hoghogh="";
        String email="";
        String password="";
String mojodi="";
        for(int i=0;i<n;i++){
            if(array[i].length()>2){
            String check[]=array[i].split(",");
            String codeemployee=check[4];
            if(codeemployee.equals(input)){
                mojodi=check[0];
                hoghogh=check[1];
                name=check[2];
                lastname=check[3];
                email=check[5];
                password=check[6];
                x=i;
                test=true;
            }
        }}
        if(test) {
            String input2 = JOptionPane.showInputDialog(frame, "حقوق جدید کارمند را وارد کنید");
            array[x] = mojodi + "," + input2 + "," + name + "," + lastname + "," + input + "," + email + "," + password + ",";
        }
else {
    JOptionPane.showMessageDialog(frame,"لطفا فقط عدد وارد کنید ارین");
}

        try {
            FileWriter writer=new FileWriter("employee.txt");
            for(int i=0;i<n;i++){
                writer.write(array[i]);
                writer.write("\n");
            }
            writer.close();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

    }
});
button2.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        show(frame1);
    }
});
        frame1.setSize(500, 500);
        frame1.setLocationRelativeTo(null);
        frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame1.setResizable(false);
        frame1.setLayout(null);
        frame1.setVisible(true);
    }
    /* پرداخت خقوق*/
    public void salarypayment(){
        String input=JOptionPane.showInputDialog(frame,"کد ملی کارمند مورد نظر را وارد کنید");
        String array[]=new String[9999];
        int n=0;
        try {
            File file=new File("employee.txt");
            Scanner input1=new Scanner(file);
            while (input1.hasNextLine()){
                String tst=input1.nextLine();
                array[n]=tst;
                n++;
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        int x=0;
        boolean test=false;
        for(int i=0;i<n;i++){
            if(array[i].length()>2){
            String check[]=array[i].split(",");
            String codeemployee=check[4];
            if(codeemployee.equals(input)){
                x=i;
                test=true;
            }
        }}
        if(test) {
            String check[] = array[x].split(",");
            String name = check[2];
            String lastname=check[3];
            String full=name+" "+lastname;
            String code=check[4];
            String salary=check[1];
            int choice = JOptionPane.showConfirmDialog(frame, "ایابا پرداخت حقوق کارمند به نام و نام خانوادگی:" +full+"و به شماره پرسنلی:"+code+"وحقوق:"+salary+"هستید؟", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (choice==JOptionPane.YES_OPTION){
            int c=0;
            String hotel[]=new String[9999];
            try {
                File file=new File("hotel.txt");
                Scanner input1=new Scanner(file);
                while (input1.hasNextLine()){
                    String tstt=input1.nextLine();
                    hotel[c]=tstt;
                    c++;
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

            double price=Double.parseDouble(salary);
            double moneyhotel=Double.parseDouble(hotel[1]);
            if(moneyhotel>price){
            moneyhotel=moneyhotel-price;
            hotel[1]= String.valueOf(moneyhotel);
                try {
                    FileWriter writer=new FileWriter("hotel.txt");
                    for(int i=0;i<c;i++){
                     writer.write(hotel[i]);
                     writer.write('\n');
                    }
                    writer.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                String inventory=check[0];
            String email=check[5];
            String password=check[6];
            double mojodi=Double.parseDouble(inventory);
            System.out.println(mojodi);
            mojodi=mojodi+price;
String money= String.valueOf(mojodi);
            String takmil=money+','+salary+','+name+','+lastname+','+code+','+email+','+password+',';
            array[x]=takmil;
            try {
                FileWriter writer=new FileWriter("employee.txt");
                for(int i=0;i<n;i++){
                    writer.write(array[i]);
                    writer.write('\n');
                }
                writer.close();
                JOptionPane.showMessageDialog(frame,"با موفقیت پرداخت شد");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }


        }
        else if(!test){
            JOptionPane.showMessageDialog(frame,"همچین کد پرسنلی در لیست کارمندان وجود ندارد");
        }
    }}

    /* delet empol panel*/

    public void deletemployee(JFrame frame){
        frame.dispose();
        JFrame frame1=new JFrame("حذف کارمند");
        JTextField textField=new JTextField();
        JTextField textField1=new JTextField();
        textField.setBounds(120,100,250,30);
        textField1.setBounds(120,150,250,30);
        Font font1 = new Font("Arial", Font.BOLD, 13);
textField.setBackground(Color.white);
textField1.setBackground(Color.white);
textField.setForeground(Color.black);
textField1.setForeground(Color.black);
textField.setFont(font1);
textField1.setFont(font1);
JButton button=new JButton("حذف کارمند");
JButton button1=new JButton("بازگشت");
button.setBounds(120,350,200,30);
button.setBackground(Color.white);
button.setForeground(Color.black);
button.setFont(font1);
button1.setFont(font1);
button1.setForeground(Color.black);
button1.setBackground(new Color(208, 0, 4));
button1.setBounds(20,20,100,40);
frame1.add(button);
frame1.add(textField);
frame1.add(textField1);
frame1.add(button1);
        frame1.getContentPane().setBackground(new Color(112, 128, 144));
  frame1.setSize(500,500);
  button.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
          String email=textField.getText();
          String password=textField1.getText();

          rimoveempol(email,password);
      }
  });
  button1.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
          show(frame1);
      }
  });
        frame1.setLocationRelativeTo(null);
        frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame1.setResizable(false);
        frame1.setLayout(null);
        frame1.setVisible(true);
    }
    /* rimove empol*/
    public void rimoveempol(String email,String password){
        int n = 0;
        String[] array = new String[9999];
        try {
            File file = new File("employee.txt");
            Scanner inpput1 = new Scanner(file);
            while (inpput1.hasNextLine()) {
                String gm = inpput1.nextLine();
                array[n] = gm;
                n++;
            }
        } catch (FileNotFoundException p) {
            p.printStackTrace();
        }
        boolean testt=false;
        String email1="";
        String password1="";
        for (int i=0;i<n;i++){
            if(array[i].length()>2){
                String check[]=array[i].split(",");
            if(check[5].equals(email)&&check[6].equals(password)){
                testt=true;
                array[i]="-1";
            }

            }


        }
        if(testt){
          try {
              FileWriter writer=new FileWriter("employee.txt");
              for(int i=0;i<n;i++){
                  String p=array[i];
                  writer.write(p);
                  writer.write('\n');
              }
              writer.close();
          } catch (IOException ex) {
              throw new RuntimeException(ex);
          }
          JOptionPane.showMessageDialog(frame,"با موفقیت حذف شد");
      }
    else if(!testt){
        JOptionPane.showMessageDialog(frame,"همچین کاربری یافت نشد");
        }
    }
    /*add room panel*/
public void iroom(JFrame frame){
        frame.dispose();
        JFrame frame1=new JFrame("اضافه کردن اتاق");
    Font font1 = new Font("Arial", Font.BOLD, 13);
    JTextField textField=new JTextField();
        JTextField textField1=new JTextField();
        textField.setBounds(120,100,200,30);
        textField1.setBounds(120,150,200,30);
        textField1.setFont(font1);
        textField.setFont(font1);
        JButton button=new JButton("اضافه اتاق");
        JButton button1=new JButton("بازشگت");
        textField.setBackground(Color.white);
        textField1.setBackground(Color.white);
        textField.setForeground(Color.black);
        textField1.setForeground(Color.black);
        JLabel label=new JLabel("تعداد تخت");
        JLabel label1=new JLabel("قیمت");
    button1.setFont(font1);
    button1.setForeground(Color.black);
    button1.setBackground(new Color(208, 0, 4));
    button1.setBounds(20,20,100,40);
        button.setBounds(120,350,200,35);
        button.setBackground(Color.white);
        button.setForeground(Color.black);
        button.setFont(font1);
        label.setFont(font1);
        label1.setFont(font1);
        label.setBounds(50,100,200,30);
        label1.setBounds(50,150,200,30);
        frame1.getContentPane().setBackground(new Color(232, 240, 186));
 frame1.add(textField);
 frame1.add(label);
 frame1.add(label1);
 frame1.add(textField1);
 frame1.add(button);
 frame1.add(button1);
 button.addActionListener(new ActionListener() {
     @Override
     public void actionPerformed(ActionEvent e) {
         String as=textField.getText();
String bs=textField1.getText();
Room room=new Room(as,bs);
addroom(room);
System.out.println(as);
     }
 });
 button1.addActionListener(new ActionListener() {
     @Override
     public void actionPerformed(ActionEvent e) {
         show(frame1);
     }
 });
        frame1.setSize(500,500);
    frame1.setLocationRelativeTo(null);
    frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame1.setResizable(false);
    frame1.setLayout(null);
    frame1.setVisible(true);
}
/* add empol panel*/
    public void addempol(JFrame frame){
        frame.dispose();
        JFrame frame1=new JFrame();
        Font font1 = new Font("Arial", Font.BOLD, 16);
        frame1.setSize(500, 500);
        JTextField namee=new JTextField();
        JTextField lastnamee=new JTextField();
        JTextField codee=new JTextField();
        JTextField money=new JTextField();
        JTextField emaill=new JTextField();
        JTextField passwordd=new JTextField();
        JButton button1=new JButton("بازگشت");
        button1.setFont(font1);
        button1.setForeground(Color.black);
        button1.setBackground(new Color(208, 0, 4));
        button1.setBounds(20,20,100,40);
namee.setBounds(120,100,250,30);
        lastnamee.setBounds(120,150,250,30);
        codee.setBounds(120,200,250,30);
        money.setBounds(120,250,250,30);
        emaill.setBounds(120,300,250,30);
        passwordd.setBounds(120,350,250,30);
        JLabel label1=new JLabel("نام");
        JLabel label2=new JLabel("نام خانوادگی");
        JLabel label3=new JLabel("کد پرسنلی");
        JLabel label6=new JLabel("حقوق");
        JLabel label4=new JLabel("ایمیل");
        JLabel label5=new JLabel("رمز عبور");
label1.setBounds(50,100,250,30);
        label2.setBounds(50,150,250,30);
        label3.setBounds(50,200,250,30);
        label6.setBounds(50,250,250,30);
        label4.setBounds(50,300,250,30);
        label5.setBounds(50,350,250,30);
label1.setFont(font1);
label4.setFont(font1);
label5.setFont(font1);
label6.setFont(font1);
label2.setFont(font1);
label3.setFont(font1);
        namee.setFont(font1);
        lastnamee.setFont(font1);
        codee.setFont(font1);
        money.setFont(font1);
        emaill.setFont(font1);
        passwordd.setFont(font1);
        namee.setBackground(Color.black);
        lastnamee.setBackground(Color.black);
        codee.setBackground(Color.black);
        emaill.setBackground(Color.black);
        passwordd.setBackground(Color.black);
        money.setBackground(Color.black);
        namee.setBorder(null);
lastnamee.setBorder(null);
codee.setBorder(null);
money.setBorder(null);
emaill.setBorder(null);
passwordd.setBorder(null);
namee.setForeground(Color.white);
lastnamee.setForeground(Color.white);
codee.setForeground(Color.white);
emaill.setForeground(Color.white);
money.setForeground(Color.white);
passwordd.setForeground(Color.white);
        JButton button=new JButton("ثبت نام");
        button.setFont(font1);
        ImageIcon imageIcon1=new ImageIcon("23.jpg");
        JLabel label=new JLabel(imageIcon1);
        label.setOpaque(false);
        label.setBounds(0,0,500,500);
        button.setForeground(Color.black);
        button.setBackground(Color.white);
        button.setBounds(120,400,250,30);
        frame1.add(button);
     frame1.add(namee);
     frame1.add(lastnamee);
     frame1.add(button1);
     frame1.add(codee);
     frame1.add(emaill);
     frame1.add(passwordd);
     frame1.add(money);
     frame1.add(label);
     button.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             String name=namee.getText();
             String lastname=lastnamee.getText();
             String code=codee.getText();
          int moneyy= Integer.parseInt(money.getText());
             String email=emaill.getText();
             String password=passwordd.getText();
             Pattern pattern = Pattern.compile("[a-z]");
             boolean check=false;
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
             int n = 0;
             String[] array = new String[9999];
             try {
                 File file = new File("employee.txt");
                 Scanner inpput1 = new Scanner(file);
                 while (inpput1.hasNextLine()) {
                     String gm = inpput1.nextLine();
                     array[n] = gm;
                     n++;
                 }
             } catch (FileNotFoundException p) {
                 p.printStackTrace();
             }
             for (int i = 0; i < n; i++) {
                 if(array[i].length()>2){
             String check1[]=array[i].split(",");
                 if(check1[5].equals(email)) {
JOptionPane.showMessageDialog(frame,"no");
                 }
                 }}
int ce=0;
               if (Pattern.matches("[a-z]+(.)+@(.)+[.][a-z]+", email)&&c>=3&& !check) {
                 Employe employe=new Employe(name,lastname,code,moneyy,email,password);
                 addemployee(employe);
                 JOptionPane.showMessageDialog(frame,"ثبت شد");
             }
             else if(!check) {
                 JOptionPane.showMessageDialog(frame,"ایمیل یا پسورد شما دارای قدرت امنیتی نبوده است");
             }
         }
     });
     button1.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             show(frame1);
         }
     });
        frame1.setLocationRelativeTo(null);
        frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame1.setResizable(false);
        frame1.setLayout(null);
        frame1.setVisible(true);
    }
    /* addd employee */
    public void addemployee(Employe employe) {
        employes.add(employe);
        try {
            FileWriter writer = new FileWriter("employee.txt",true);
            FileOutputStream fos = new FileOutputStream("employee.txt",true);
            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
            PrintWriter pw=new PrintWriter(osw);
            pw.print(employe.getMojodi());
            pw.print(',');
            pw.print(employe.getMoney());
            pw.print(',');
            pw.close();
            writer.write(employe.getName());
            writer.write(',');
            writer.write(employe.getLastname());
            writer.write(',');
            writer.write(employe.getCode());
            writer.write(',');
            writer.write(employe.getEmail());
            writer.write(',');
            writer.write(employe.getPassword());
            writer.write(',');
            writer.write('\n');
            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
/* add person*/
    public void addperson(Tourist tourists) {
        tourist.add(tourists);
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
        boolean test=false;
//        for (int i=0;i<n;i++){
//            String check[]=array[i].split(",");
//            if(check[2].equals(tourists.getCode())||check[3].equals(tourists.getEmail())){
//                test=true;
//            }
//        }
        if(!test){
        try {
            FileWriter writer = new FileWriter("tourist.txt", true);
            writer.write(tourists.getName());
            writer.write(',');
            writer.write(tourists.getLastname());
            writer.write(',');
            writer.write(tourists.getCode());
            writer.write(',');
            writer.write(tourists.getEmail());
            writer.write(',');
            writer.write(tourists.getPassword());
            writer.write(',');
            writer.write('\n');
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        JOptionPane.showMessageDialog(frame, "با موفقیت ثبت نام شد");
    }
    if(test){
        JOptionPane.showMessageDialog(frame,"همچین ایمیلی یا کد ملی قبلادر سیستم ثبت شده است");
    }

    }


    /*add room*/

public void addroom(Room room){
        int n=0;
    try {
        File file=new File("room.txt");
        Scanner inputt=new Scanner(file);
        while (inputt.hasNextLine()){
            String a=inputt.nextLine();
        n++;
        }
    } catch (FileNotFoundException e) {
e.printStackTrace();
    }
    rooms.add(room);
    String num= String.valueOf(n);
    try {
            FileWriter writer = new FileWriter("room.txt",true);
        writer.write(String.valueOf(room.isStatus()));
        writer.write(',');
        writer.write(num);
        writer.write(',');
        writer.write(room.getBed());
            writer.write(',');
        writer.write(room.getPrice());
        writer.write(',');
            writer.write('\n');
            writer.close();
    }
    catch (IOException e) {
        throw new RuntimeException(e);
    }
    JOptionPane.showMessageDialog(frame,"همچین اتاقی با شماره:"+num+"ثبت شد");

}

/* finishhhhhhhhhhhhhhhhhhhh*/






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

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
