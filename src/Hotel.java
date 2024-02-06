import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;


    public class Hotel extends javax.swing.JFrame {
        private int money;
        private String name;
        private boolean status=true;

        public Hotel(JFrame frame) {
            frame.dispose();
            JFrame frame1=new JFrame();
            JLabel label=new JLabel("به صفحه اصلی هتل خوش امدید");
            JLabel label1=new JLabel("موجودی هتل:");
            JLabel label2=new JLabel("به نام خدایی که هست");
            JLabel label4=new JLabel("اسم هتل:");
            Font font = new Font("Arial", Font.BOLD, 24);
            Font font1 = new Font("Arial", Font.BOLD, 16);
            ImageIcon imageIcon1=new ImageIcon("e1.png");
            JLabel label3=new JLabel(imageIcon1);
            label4.setForeground(Color.white);
            label4.setFont(font);
            int n=0;
            String mojodi="";
            String array[]=new String[3];
            try {
                File file=new File("hotel.txt");
                Scanner input =new Scanner(file);
                while (input.hasNextLine()){
                    mojodi=input.nextLine();
                    array[n]=mojodi;
                    n++;
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            JLabel label5=new JLabel(array[0]);
JLabel label43=new JLabel(array[1]);
            System.out.println(array[1]);
            label3.setBounds(0,0,1000,700);
            label.setFont(font);
            label1.setFont(font);
            label2.setFont(font);
            label.setForeground(Color.white);
            label1.setForeground(Color.white);
            label2.setForeground(Color.white);
            label1.setBounds(150,30,350,50);
            label.setBounds(350,80,350,50);
            label2.setBounds(800,2,350,50);
label4.setBounds(800,30,350,50);
label5.setBounds(700,30,350,50);
label5.setFont(font);
label5.setForeground(Color.white);
            JButton button=new JButton("لیست مسافران");
            JButton button1=new JButton("لیست کارمندان");
            JButton button2=new JButton("صف رزرو ها");
            JButton button3=new JButton("تعداد اتاق");
            JButton button4= new JButton("لیست اتاق ها");
            JButton button5=new JButton("بازگشت");
            button.setBounds(800,150,150,75);
            button1.setBounds(800,250,150,75);
            button2.setBounds(800,350,150,75);
            button3.setBounds(800,450,150,75);
            button4.setBounds(800,550,150,75);
            button.setBackground(new Color(20, 39, 74));
            button1.setBackground(new Color(20, 39, 74));
            button2.setBackground(new Color(20, 39, 74));
            button3.setBackground(new Color(20, 39, 74));
            button4.setBackground(new Color(20, 39, 74));
            button.setForeground(Color.white);
            button1.setForeground(Color.white);
            button2.setForeground(Color.white);
            button3.setForeground(Color.white);
            button4.setForeground(Color.white);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    tourist(frame1);
                }
            });
            button1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    employee(frame1);
                }
            });
            button2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
stackbook(frame1);
                }
            });
            button4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
statusroom(frame1);
                }
            });
            label43.setBounds(30,30,350,50);
            label43.setFont(font1);
            label43.setForeground(Color.white);
frame1.add(label43);
            frame1.add(button);
            frame1.add(button1);
            frame1.add(button2);
            frame1.add(label4);
            frame1.add(label5);
            frame1.add(button3);
            frame1.add(button4);
            frame1.add(label1);
            frame1.add(label);
            frame1.add(label2);
            frame1.add(label3);
            frame1.add(button5);
            frame1.setSize(1000,700);
            frame1.setLocationRelativeTo(null);
            frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame1.setResizable(false);
            frame1.setLayout(null);
            frame1.setVisible(true);
        }
        public void statusroom(JFrame frame){
            frame.dispose();
            JFrame frame1=new JFrame();
            int n=0;
            Font font1 = new Font("Arial", Font.BOLD, 17);
            String array[]=new String[9999];
            try {
                File file=new File("room.txt");
                Scanner input=new Scanner(file);
                while (input.hasNextLine()){
                    String tst=input.nextLine();
                    array[n]=tst;
                    n++;
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            String colmoun[]={"وضیعت اتاق","شماره اتاق","تعداد تخت","قیمت"};
String status="";
String numberroom="";
String bed="";
String price="";
            String inforamation[][]=new String[n][4];
            for(int i=0;i<n;i++){
                if(array[i].length()>2) {
                    String test = array[i];
                    String part[] = test.split(",");
 status=part[0];
                    numberroom = part[1];
                    bed = part[2];
                    price = part[3];
                }
                for(int j=0;j<n;j++){
                    for(int k=0;k<4;k++){
                        if(j==0) {
                            inforamation[i][j]= status;
                        }
                        if(j==1){
                            inforamation[i][j]=numberroom;
                        }
                        if(j==2){
                            inforamation[i][j]=bed;

                        }
                        if(j==3){
                            inforamation[i][j]=price;
                        }
                    }}}
                JTable table=new JTable(inforamation,colmoun);
                table.setEnabled(false);
                table.setFont(font1);
                table.setBackground(new Color(54, 48, 98));
                table.setForeground(new Color(216, 185, 195));
                JScrollPane scrollPane=new JScrollPane(table);
                frame1.add(scrollPane);
                frame1.setSize(1400,700);
                frame1.setLocationRelativeTo(null);
                frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame1.setResizable(false);
                frame1.setVisible(true);
            }
public void stackbook(JFrame frame){
            frame.dispose();
            JFrame frame1=new JFrame();
    int n=0;
    Font font1 = new Font("Arial", Font.BOLD, 17);
    String array[]=new String[9999];
    try {
        File file=new File("acceptrent.txt");
        Scanner input=new Scanner(file);
        while (input.hasNextLine()){
            String tst=input.nextLine();
            array[n]=tst;
            n++;
        }
    } catch (FileNotFoundException e) {
        throw new RuntimeException(e);
    }
    LocalDateTime localDateTime=LocalDateTime.now();
    LocalDateTime localDateTime1=LocalDateTime.now();
    String codeemploye="";
    String codeperson="";
    String day="";
    String id="";
    String price="";
    System.out.println(n);
    String temp="";
    String colmoun[]={"تاریخ رزرو","کد پرسنلی کارمند تایید کننده","کد ملی کاربر","مدت اقامت","شماره اتاق","قیمت"};
    String inforamation[][]=new String[n][6];

    for(int i=0;i<n-1;i++) {
        if (array[i].length()>2) {
            String check[] = array[i].split(",");
            for (int j = i + 1; j < n; j++) {
                String test[] = array[j].split(",");
                localDateTime1 = LocalDateTime.parse(test[0]);
                if (localDateTime1.isAfter(localDateTime)) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
    for(int i=0;i<n;i++){
        if(array[i].length()>2) {
            String test = array[i];
            String part[] = test.split(",");
            localDateTime = LocalDateTime.parse(part[0]);
            codeemploye = part[1];
            codeperson = part[2];
            day = part[3];
            id = part[4];
            price = part[5];


    for(int j=0;j<n;j++){
        for(int k=0;k<6;k++){
            if(j==0) {
                inforamation[i][j]= String.valueOf(localDateTime);
            }
            if(j==1){
                inforamation[i][j]=codeemploye;
            }
            if(j==2){
                inforamation[i][j]=codeperson;

            }
            if(j==3){
                inforamation[i][j]=day;
            }
            if(j==4){
                inforamation[i][j]=id;

            }
            if(j==5){
inforamation[i][j]=price;
            }
        }}}
    JTable table=new JTable(inforamation,colmoun);
    table.setEnabled(false);
    table.setFont(font1);
    table.setBackground(Color.black);
    table.setForeground(Color.white);

    JScrollPane scrollPane=new JScrollPane(table);
        frame1.add(scrollPane);
        ImageIcon imageIcon1=new ImageIcon("room1.png");
//        JLabel label=new JLabel(imageIcon1);
//        label.setOpaque(false);
//        label.setBounds(0,0,1400,700);
        frame1.setSize(1400,700);
        frame1.setLocationRelativeTo(null);
        frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame1.setResizable(false);
        frame1.setVisible(true);

}}

        public void tourist(JFrame frame){
            frame.dispose();
            JFrame frame1=new JFrame();

            int n=0;
            Font font1 = new Font("Arial", Font.BOLD, 17);
            String array[]=new String[9999];
            try {
                File file=new File("tourist.txt");
                Scanner input=new Scanner(file);
                while (input.hasNextLine()){
                    String tst=input.nextLine();
                    array[n]=tst;
                    n++;
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            String colmoun[]={"نام","نام خانوادگی","کد ملی","ایمیل","رمز عبور"};
            ArrayList<Tourist> tourists=new ArrayList<>();
            for(int i=0;i<n;i++){
                if(array[i].length()>2){
                String test=array[i];
                String part[]=test.split(",");
                String name=part[0];
                String lastname=part[1];
                String code=part[2];
                String email=part[3];
                String password=part[4];
                tourists.add(new Tourist(name,lastname,code,email,password));
            }}
            String inforamation[][]=new String[n][5];
            for(int i=0;i<n;i++){
                for(int j=0;j<5;j++){
                    Tourist tourist=tourists.get(i);
                    if(j==0) {
                        inforamation[i][j]=tourist.getName();
                    }
                    if(j==1){
                        inforamation[i][j]=tourist.getLastname();

                    }
                    if(j==2){
                        inforamation[i][j]=tourist.getCode();

                    }
                    if(j==3){
                        inforamation[i][j]=tourist.getEmail();
                    }
                    if(j==4){
                        inforamation[i][j]=tourist.getPassword();

                    }
                }}
            JTable table=new JTable(inforamation,colmoun);
            table.setEnabled(false);
            table.setFont(font1);
            table.setBackground(Color.black);
            table.setForeground(Color.white);

            JScrollPane scrollPane=new JScrollPane(table);
            frame1.add(scrollPane);
            frame1.setSize(1400,700);
            frame1.setLocationRelativeTo(null);
            frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame1.setResizable(false);
            frame1.setVisible(true);

        }
        public void employee(JFrame frame){
            frame.dispose();
            JFrame frame1=new JFrame();

            int n=0;
            Font font1 = new Font("Arial", Font.BOLD, 17);
            String array[]=new String[9999];
            try {
                File file=new File("employee.txt");
                Scanner input=new Scanner(file);
                while (input.hasNextLine()){
                    String tst=input.nextLine();
                    array[n]=tst;
                    n++;
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            String colmoun[]={"نام","نام خانوادگی","کد ملی"," میزان حقوق","ایمیل","رمز عبور"};
ArrayList<Employe>employes=new ArrayList<>();
            for(int i=0;i<n;i++){
                String test=array[i];
                String part[]=test.split(",");
                int hoghogh= Integer.parseInt(part[1]);
                String name=part[2];
                String lastname=part[3];
                String code=part[4];
                String email=part[5];
                String password=part[6];
                employes.add(new Employe(name,lastname,code,hoghogh,email,password));
            }
            String inforamation[][]=new String[n][6];
            for(int i=0;i<n;i++){
                Employe employe=employes.get(i);
                for(int j=0;j<6;j++){
                    if(j==0) {
                        inforamation[i][j]=employe.getName();
                    }
                    if(j==1){
                        inforamation[i][j]=employe.getLastname();

                    }
                    if(j==2){
                        inforamation[i][j]=employe.getCode();

                    }
                    if(j==3){
                        String tst= String.valueOf(employe.getMoney());
                        inforamation[i][j]=tst;
                    }
                    if(j==4){
                        inforamation[i][j]=employe.getEmail();
                    }
                    if(j==5){
                        inforamation[i][j]=employe.getPassword();

                    }
                }}

            JTable table=new JTable(inforamation,colmoun);
            table.setEnabled(false);
            table.setFont(font1);
            table.setBackground(Color.black);
            table.setForeground(Color.white);
            table.setBackground(Color.black);
            table.setForeground(Color.white);
            JScrollPane scrollPane=new JScrollPane(table);
            frame1.add(scrollPane);
            frame1.setSize(1400,700);
            frame1.setLocationRelativeTo(null);
            frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame1.setResizable(false);
            frame1.setVisible(true);
        }
        public int getMoney() {
            return money;
        }

        public void setMoney(int money) {
            this.money = money;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isStatus() {
            return status;
        }

        public void setStatus(boolean status) {
            this.status = status;
        }

    }


