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

public class Employe extends javax.swing.JFrame {
    private String name;
    private String lastname;
    private String email;
    private String password;
    private String code;
    private int  money;
    private int mojodi=0;
    JFrame frame;

    public Employe(String name, String lastname, String code, int money, String email, String password)  {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.code = code;
        this.money=money;
    }
    @Override
    public String getName() {
        return name;
    }
    public void addmoney(String money){

    }
    public void checkemployee(String email1,String password1,JFrame frame1){
        int n=0;
        String array[]=new String[9999];
if(email1.equals(null)&&password1.equals(null)){
    JOptionPane.showMessageDialog(frame,"لطفا تکست فیلد هارا پر کنید");
}
        try {
            File file=new File("employee.txt");
            Scanner input = new Scanner(file);
            while (input.hasNextLine()) {
                String gm = input.nextLine();
                array[n] = gm;
                n++;
            }
        }

        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        int k = 0;
        int z = 0;
        boolean test1=false;
        String emaill = "";
        String paswordd = "";
        for(int i=0;i<n;i++){
            if(array[i].length()>2){
         String check[]=array[i].split(",");
         emaill=check[5];
         paswordd=check[6];
        if(email1.equals(emaill)&&password1.equals(paswordd)){
                z=i;
                JOptionPane.showMessageDialog(frame,"با موفقیت وارد شدید");
                panelemploye(array[i],frame1);
                test1=true;
                break;
            }
        }}
        if(!test1){
            JOptionPane.showMessageDialog(frame,"همچین مشخصاتی یافت نشد");
        }
    }
    public void panelemploye(String array,JFrame frame){
        frame.dispose();
        JFrame frame1=new JFrame();
        Font font1 = new Font("Arial", Font.BOLD, 14);
        Font font=new Font("Arial",Font.BOLD,16);
ImageIcon imageIcon1=new ImageIcon("e.jpg");
JLabel label11=new JLabel(imageIcon1);
label11.setOpaque(false);
label11.setBounds(0,0,900,700);
        JLabel label=new JLabel("نام و نام خانوادگی:");
        JLabel label1=new JLabel("ایمیل:");
        JLabel label2=new JLabel("موجودی:");
        label.setBounds(750,20,200,30);
        label1.setBounds(450,20,200,30);
        label2.setBounds(150,20,200,30);
        label.setFont(font);
        label1.setFont(font);
        label2.setFont(font);
        label.setForeground(Color.white);
        label1.setForeground(Color.white);
        label2.setForeground(Color.white);
        int c=0;
        String  moojodi="";
        String name="";
        String lastanme="";
        String full="";
        String email="";
        JButton button=new JButton("بازگشت");
        button.setFont(font1);
        button.setBackground(new Color(208, 0, 4));
        button.setForeground(Color.white);
        button.setBounds(20,100,100,50);
        JButton button1=new JButton("تایید رزرو");
        JButton button2=new JButton("لیست رزرو تایید نشده");
        JButton button3=new JButton("لیست رزرو تایید شده");
        JButton button4=new JButton("تایید کنسل رزرو");
        button1.setFont(font1);
        button1.setBackground(Color.white);
        button1.setForeground(Color.black);
       button1.setBounds(700,100,150,70);
        button2.setFont(font1);
        button2.setBackground(Color.white);
        button2.setForeground(Color.black);
        button2.setBounds(700,200,150,70);
        button3.setFont(font1);
        button3.setBackground(Color.white);
        button3.setForeground(Color.black);
        button3.setBounds(700,300,150,70);
        button4.setFont(font1);
        button4.setBackground(Color.white);
        button4.setForeground(Color.black);
        button4.setBounds(700,400,150,70);
        for(int i=0;i<array.length();i++){
        String check[]=array.split(",");
        moojodi=check[0];
        name=check[2];
        lastanme=check[3];
        email=check[5];

        }
        full=name+lastanme;
        JLabel label3=new JLabel(full);
        label3.setBounds(550,20,200,30);
        label3.setFont(font1);
        label3.setForeground(Color.white);
        JLabel label4=new JLabel(email);
        label4.setForeground(Color.white);
        label4.setBounds(250,20,200,30);
        label4.setFont(font1);
        JLabel label5=new JLabel(moojodi);
        label5.setBounds(20,20,200,30);
        label5.setFont(font1);
        label5.setForeground(Color.white);
        frame1.add(label);
        frame1.add(label1);
        frame1.add(label2);
        frame1.add(label3);
        frame1.add(label4);
        frame1.add(label5);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Homepage homepage=new Homepage(frame1);
                frame1.dispose();
            }
        });
button1.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {
    acceptremt(array ,frame1);
    frame1.dispose();
    }
});
button2.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
notconfirmed(frame1);
    }
});
button3.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        confirmed(frame1);
    }
});
button4.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
acceotcnslbook(frame1);
    }
});
        frame1.add(button);
        frame1.add(button1);
        frame1.add(button3);
        frame1.add(button4);
        frame1.add(button2);
        frame1.add(label11);
        frame1.setLayout(null);
        frame1.setSize(900,700);
        frame1.setLocationRelativeTo(null);
        frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame1.setResizable(false);
        frame1.setVisible(true);
    }
public void acceotcnslbook(JFrame frame){
        frame.dispose();
JFrame frame1=new JFrame();
int n=0;
String array[]=new String[9999];
try {
        File file=new File("rent.txt");
        Scanner input=new Scanner(file);
        while (input.hasNextLine()){
            String tst=input.nextLine();
            array[n]=tst;
            n++;
        }
    } catch (FileNotFoundException e) {
        throw new RuntimeException(e);
    }

int counter=0;
for(int i=0;i<n;i++){
    String chek[]=array[i].split(",");
    Pattern pattern=Pattern.compile("[-2]");
    Matcher matcher=pattern.matcher(array[i]);
    if(matcher.find()){
counter++;
    }
}
    Font font1=new Font("Arial",Font.BOLD,16);

JLabel label1=new JLabel("درخواست کنسل رزرو");
label1.setFont(new Font("Arial",Font.BOLD,25));
label1.setBounds(400,20,250,30);
label1.setForeground(Color.white);
    JButton[] buttons = new JButton[n];
    int x=10;
    int y=40;
    for(int i=0;i<n;i++){
        String test[]=array[i].split(",");
        String chek[]=array[i].split(",");
        Pattern pattern=Pattern.compile("[0-9&&-2]");
        Matcher matcher=pattern.matcher(array[i]);
        if(matcher.find()) {
            String result = test[1];
            String codemeli = test[0];
            String price = test[2];/* gheymat otagh */
            String day = test[3];
            buttons[i] = new JButton("اتاق شماره:" + result + "کد ملی رزرو کننده:" + codemeli);
            buttons[i].setFont(font1);
            buttons[i].setBackground(new Color(57, 62, 70));
            buttons[i].setForeground(new Color(238, 238, 238));
            x = x + 150;
            final int index = i;
            if (x > 900) {
                y = y + 75;
                x = 10;
            }
            buttons[i].addActionListener(e -> {
                String testt = buttons[index].getText();
                Room room = new Room("", "");
                int choice = JOptionPane.showConfirmDialog(frame, "ایا موافق کنسل رزرو این اتاق شماره:" + result + "با کد ملی رزرو کننده:" + codemeli + "و  برای شب:" + day + "و این قیمت:" + price + "هستید؟", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
editsalary(result);
                }

            });
        frame1.add(buttons[i]);
        }

    }
    JButton button=new JButton("بازگشت");
    button.setBounds(800,600,100,50);
    frame1.add(button);
            ImageIcon imageIcon1=new ImageIcon("24.jpg");
            JLabel label=new JLabel(imageIcon1);
            label.setBounds(0,0,900,700);
            label.setOpaque(false);
 frame1.add(label1);
 frame1.add(label);
    frame1.setLayout(null);
    frame1.setSize(900,700);
    frame1.setLocationRelativeTo(null);
    frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame1.setResizable(false);
    frame1.setVisible(true);
}
public void editsalary(String roomnumber)  {
    int i=0;
    String array1[]=new String[9999];
    try {
        File file=new File("room.txt");
        Scanner input=new Scanner(file);
        while (input.hasNextLine()){
            String tst=input.nextLine();
            array1[i]=tst;
            i++;
        }

    } catch (FileNotFoundException e) {
        throw new RuntimeException(e);
    }
    for(int j=0;j<i;j++){
        String check[]=array1[j].split(",");
        if(check[1].equals(roomnumber)){
            array1[j]="";
            array1[j]="false"+','+roomnumber+','+check[2]+','+check[3]+',';
        }
    }
    try {
        FileWriter writer=new FileWriter("room.txt");
        for(int j=0;j<i;j++){
         writer.write(array1[j]);
         writer.write("\n");
        }
        writer.close();
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}
    public void confirmed(JFrame frame){
        JFrame frame1=new JFrame();

        int n=0;
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
        Font font=new Font("Arial",Font.BOLD,17);
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
            table.setFont(font);
            table.setBackground(Color.black);
            table.setForeground(Color.white);

            JScrollPane scrollPane=new JScrollPane(table);
            frame1.add(scrollPane);
            frame1.add(scrollPane);
            frame1.setSize(1400,700);
            frame1.setLocationRelativeTo(null);
            frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame1.setResizable(false);
            frame1.setVisible(true);
    }}
    public void notconfirmed(JFrame frame){
        JFrame frame1=new JFrame();
        int n=0;

        String array[]=new String[9999];
        try {
            File file=new File("rent.txt");
            Scanner input=new Scanner(file);
            while (input.hasNextLine()){
                String tst=input.nextLine();
                array[n]=tst;
                n++;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String colmoun[]={"کد ملی مسافر","شماره اتاق","قیمت","مدت اقامت"};
        String inforamation[][]=new String[n][4];
       String numberroom="";
       String code="";
       String price="";
       String day="";

        for(int i=0;i<n;i++){
            if(array[i].length()>2) {
                String test = array[i];
                String part[] = test.split(",");
                code=part[0];
                numberroom = part[1];
                price = part[2];
                day = part[3];
            }
            for(int j=0;j<n;j++){
                for(int k=0;k<4;k++){
                    if(j==0) {
                        inforamation[i][j]= code;
                    }
                    if(j==1){
                        inforamation[i][j]=numberroom;
                    }
                    if(j==2){
                        inforamation[i][j]=price;

                    }
                    if(j==3){
                        inforamation[i][j]=day;
                    }
                }}}
        Font font1=new Font("Arial",Font.BOLD,16);
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



    public void acceptremt(String employe,JFrame frame){
        frame.dispose();
        JFrame frame1=new JFrame();
        JLabel label=new JLabel("لیست های رزرو شده تایید نشده");
        Font font = new Font("Arial", Font.BOLD, 16);
label.setFont(font);
JButton button=new JButton("بازگشت");
button.setBounds(800,500,100,50);
label.setBounds(400,2,250,50);
        button.setFont(font);
        frame1.add(label);
        int n=0;

        String array[]=new String[9999];
        try {
            File file=new File("rent.txt");
            Scanner input=new Scanner(file);
            while (input.hasNextLine()){
                String tst=input.nextLine();
                array[n]=tst;
                n++;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Font font1 = new Font("Arial", Font.BOLD, 13);
        JButton[] buttons = new JButton[n];
        /* eroorororor baraye addad 2 raghami  v ertefa*/
        int x=10;
        int y=40;
        for(int i = 0; i<n; i++){
            if(array[i].length()>2){
                String test[]=array[i].split(",");
                String result=test[1];
                String codemeli=test[0];
                String price=test[2];/* gheymat otagh */
                String day=test[3];
                buttons[i]=new JButton("اتاق شماره:"+result+"کد ملی رزرو کننده:"+codemeli);
                buttons[i].setFont(font1);
                buttons[i].setBackground(new Color(68, 60, 104));
                buttons[i].setBounds(x,y,235,100);
                buttons[i].setForeground(Color.white);
                x=x+150;
                final int index = i;
if(x>900){
    y=y+75;
    x=10;
}
                buttons[i].addActionListener(e -> {
                    String testt=buttons[index].getText();
                    Room room=new Room("","");
                    int choice = JOptionPane.showConfirmDialog(frame,"ایا موافق تایید رزرو این اتاق شماره:"+result+"با کد ملی رزرو کننده:"+codemeli+"و  برای شب:"+day+"و این قیمت:"+price+"هستید؟", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (choice==JOptionPane.YES_OPTION){
//                    JOptionPane.showMessageDialog(frame,"تایید شد");
book(employe,frame1,result,codemeli,day,price);
                }
                else if(choice==JOptionPane.NO_OPTION){
                    JOptionPane.showMessageDialog(frame,"با موفقیت ثبت نشد");
                }
                });
                frame1.add(buttons[i]);
            }}
        button.setBounds(900,650,50,50);
        button.setForeground(Color.black);
        button.setBackground(Color.white);
        frame1.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelemploye(employe,frame);
            }
        });
        ImageIcon imageIcon1=new ImageIcon("t1.jpg");
        JLabel label1=new JLabel(imageIcon1);
label1.setBounds(0,0,1000,700);
label1.setOpaque(false);
frame1.add(label1);
        frame1.setLayout(null);
        frame1.setSize(1000,700);
        frame1.setLocationRelativeTo(null);
        frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame1.setResizable(false);
        frame1.setVisible(true);
    }


    /* sabt etelatt rzrv taeed shode*/
    public void book(String employe,JFrame frame,String numberroom,String codemeli,String day,String price) {
        LocalDateTime localDateTime = LocalDateTime.now();
        String tst[] = employe.split(",");
        String codeemployee = tst[4];
        try {
            FileWriter writer = new FileWriter("acceptrent.txt", true);
            writer.write(String.valueOf(localDateTime));
            writer.write(',');
            writer.write(codeemployee);
            writer.write(',');
            writer.write(codemeli);
            writer.write(',');
            writer.write(day);
            writer.write(',');
            writer.write(numberroom);
            writer.write(',');
            writer.write(price);
            writer.write(',');
            writer.write('\n');
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String array[] = new String[9999];
        int n = 0;
        try {
            File file = new File("room.txt");
            Scanner input = new Scanner(file);
            while (input.hasNextLine()) {
                String tstt = input.nextLine();
                array[n] = tstt;
                n++;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < n; i++) {
            String check[] = array[i].split(",");
            String room = check[1];
            if (room.equals(numberroom)) {
                String status = check[0];
                String bed = check[2];
                String prce = check[3];
                status = "true";
                String full = status + ',' + room + ',' + bed + ',' + prce + ',';
                array[i] = full;
            }
        }
        try {
            FileWriter writer = new FileWriter("room.txt");
            for (int i = 0; i < n; i++) {
                writer.write(array[i]);
                writer.write('\n');
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int x = 0;
        String hotel[] = new String[9999];
        try {
            File file = new File("hotel.txt");
            Scanner input1 = new Scanner(file);
            while (input1.hasNextLine()) {
                String tstt = input1.nextLine();
                hotel[x] = tstt;
                x++;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        double money = Double.parseDouble(hotel[1]);
        double arzesh = Double.parseDouble(price);
        double sum = money + arzesh;
        hotel[1] = String.valueOf(sum);
        try {
            FileWriter writer = new FileWriter("hotel.txt");
            writer.write(hotel[0]);
            writer.write('\n');
            writer.write(hotel[1]);
            writer.write('\n');
            writer.write(hotel[2]);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int i = 0;
        String rent[] = new String[9999];
        try {
            File file = new File("rent.txt");
            Scanner input = new Scanner(file);
            while (input.hasNextLine()) {
                String bit = input.nextLine();
                rent[i] = bit;
                i++;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
for(int j=0;j<i;j++){
    String check[]=rent[j].split(",");
    if(check[0].equals(codemeli)){
        rent[j]="-1";
    }
}
        try {
            FileWriter writer=new FileWriter("rent.txt");
            for(int j=0;j<i;j++){
                writer.write(rent[j]);
                writer.write('\n');
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getMojodi() {
        return mojodi;
    }

    public void setMojodi(int mojodi) {
        this.mojodi = mojodi;
    }
}

