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

public class Room extends javax.swing.JFrame {
    private String bed;
    private int id;
    private String price;
    private boolean status = false;
    JFrame frame;

    //public Room(boolean status,int id,String bed,String price){
//    this.status=status;
//    this.id=id;
//    this.bed=bed;
//    this.price=price;
//}
    public Room(String bed, String price) {
        this.bed = bed;
        this.price = price;
    }
public void viproom(){
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
    String num= String.valueOf(n);
    try {
        FileWriter writer = new FileWriter("room.txt",true);
        writer.write(String.valueOf(status));
        writer.write(',');
        writer.write(num);
        writer.write(',');
        writer.write(bed);
        writer.write(',');
        writer.write(price);
        writer.write(',');
        writer.write("vip");
        writer.write(",");
        writer.write('\n');
        writer.close();
    }
    catch (IOException e) {
        throw new RuntimeException(e);
    }
    JOptionPane.showMessageDialog(frame,"همچین اتاقیvip    با شماره:"+num+"ثبت شد");

}


    public void checkrent(String inforamtion, String room) {
        int c = 0;
        String bolean = "";
        String bed = "";
        String price = "";
        String id = "";
        for (int i = 0; i < room.length(); i++) {
            if (room.charAt(i) == ',') {
                c++;
            }
            if (c == 0 && room.charAt(i) != ',') {
                bolean = bolean + room.charAt(i);
            }
            if (c == 1 && room.charAt(i) != ',') {
                id = id + room.charAt(i);
            }
            if (c == 2 && room.charAt(i) != ',') {
                bed = bed + room.charAt(i);
            }
            if (c == 3 && room.charAt(i) != ',') {
                price = price + room.charAt(i);
            }
        }
        if (bolean.equals("true")) {
            JOptionPane.showMessageDialog(frame, "همچین اتاقی قبلا توسط مسافر دیگری رزرو شده است");
        } else if (bolean.equals("false")) {
            int choice = JOptionPane.showConfirmDialog(frame, "تعداد تخت این اتاق:" + bed + "با همچین قیمتی:" + price + "ایا موافق رزرو هستید؟", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(frame, "رزرو نشد");
            } else if (choice == JOptionPane.YES_OPTION) {
                String input = JOptionPane.showInputDialog(frame, "تعداد روز اقامت را وارد کنید");
                int dey = Integer.parseInt(input);
                System.out.println(input);
                int pricee = Integer.parseInt(price);
                pricee = dey * pricee;
                String price1 = String.valueOf(pricee);
                System.out.println(price1);
                LocalDateTime localDateTime = LocalDateTime.now();
                Rent rent = new Rent(localDateTime, "", 0, "", 0, 0);
                rent.rentroom(room, inforamtion, input, price1);
            }
        }
        else if(bolean.equals("waite")){
            JOptionPane.showMessageDialog(frame,"این اتاق در حال حاضر در حال بررسی برای رزرو است");
        }
        else if(bolean.equals("-1")){
            JOptionPane.showMessageDialog(frame,"این اتاق غیر قابل رزرو است");
        }
    }

    public void cnclroom(JFrame frame) {
        frame.dispose();
        JFrame frame1 = new JFrame();
        Font font = new Font("Arial", Font.BOLD, 15);
        ImageIcon imageIcon1=new ImageIcon("2r.png");
        JLabel label11=new JLabel(imageIcon1);
        JTextField textField = new JTextField();
        textField.setBounds(150, 200, 200, 35);
        JButton button = new JButton("حذف اتاق");
        button.setBounds(150, 400, 200, 35);
        JLabel label = new JLabel("ایدی اتاق");
        JButton button1 = new JButton("بازگشت");
        label.setFont(new Font("Arial",Font.BOLD,22));
        label.setBounds(70, 200, 150, 35);
        frame1.add(button);
        frame1.add(textField);
        label11.setBounds(0,0,500,500);
        label11.setOpaque(false);
        button.setBackground(new Color(125, 10, 10));
        button.setForeground(Color.white);
        label.setForeground(new Color(243, 237, 200));
        button.setFont(font);
        textField.setFont(font);
        button1.setFont(font);
        textField.setBorder(null);
        textField.setBackground(new Color(241, 235, 144));
        button1.setForeground(Color.white);
        button1.setBackground(new Color(159, 187, 115));
        button1.setBounds(350,10,100,50);
        frame1.add(label);
        frame1.add(button1);
        frame1.add(label11);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Manager manager=new Manager();
                manager.show(frame1);
            }
        });
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = textField.getText();
                acceptcnlsroom(id);
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        frame1.setSize(500, 500);
        frame1.setLocationRelativeTo(null);
        frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame1.setResizable(false);
        frame1.setLayout(null);
        frame1.setVisible(true);
    }

    public void acceptcnlsroom(String id) {
        String array[] = new String[9999];
        int n = 0;
        try {
            File file = new File("room.txt");
            Scanner input = new Scanner(file);
            while (input.hasNextLine()) {
                String data = input.nextLine();
                array[n] = data;
                n++;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < n; i++) {
            String check[] = array[i].split(",");
            String id1 = check[1];
            String bed = check[2];
            String price = check[3];
            if (id1.equals(id)) {
                String status = check[0];
                if (status.equals("true")) {
                    JOptionPane.showMessageDialog(frame, "همچین اتاقی در حال حاضر رزرو است");
                } else if (status.equals("false")) {
                    int choice = JOptionPane.showConfirmDialog(frame, "اطمینان از حذف این اتاق دارید", "Confirmation", JOptionPane.YES_NO_OPTION);
                    if (choice == JOptionPane.YES_OPTION) {
                        status = "-1";
                        String full = status + ',' + id1 + ',' + bed + ',' + price + ',';
                        array[i] = full;
                        try {
                            FileWriter writer = new FileWriter("room.txt");
                            for (int j = 0; j < n; j++) {
                                writer.write(array[j]);
                                writer.write('\n');
                            }
                            writer.close();

                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }

                    } else if (choice == JOptionPane.NO_OPTION) {
                        cnclroom(frame);
                    }
                } else if (status.equals("waite")) {
                    JOptionPane.showMessageDialog(frame, "همچین اتاقی در حال تایید رزرو است");
                }
            }
        }
    }

    public int checkstatusroomcolor(String i) {
        int c = 10;
        /* c baraye rezrv shode ha 0 baraye dar hal 1 v baraye rzrvr nshde 2*/
        String array[] = new String[9999];
        int n = 0;
        try {
            File file = new File("room.txt");
            Scanner input = new Scanner(file);
            while (input.hasNextLine()) {
                String tst = input.nextLine();
                array[n] = tst;
                n++;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        for (int j = 0; j < n; j++) {
            String check[] = array[j].split(",");
            String numberroom = check[1];
            String status = check[0];
            if (numberroom.equals(i)) {
                if (status.equals("waite")) {
                    c = 1;

                } else if (status.equals("false")) {
                    c = 2;
                } else if (status.equals("true")) {
                    c = 0;
                }
                else if(status.equals("-1")){
                    c=3;
                }

            }
        }
        return c;
    }



    /*delivery room*/
public void deliveryroom(String code,String inforamtion,int a){
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
    boolean test=false;
    String roomnumber="";
for(int i=0;i<n;i++){
    if(array[i].length()>2){
    String check[]=array[i].split(",");
    if(check[2].equals(code)){
        roomnumber=check[4];
        int choice = JOptionPane.showConfirmDialog(frame,"ایا موافق تایید تحویل این اتاق شماره:"+check[4]+"با کد ملی رزرو کننده:"+code+"و  برای شب:"+check[3]+"و این قیمت:"+check[5]+"هستید؟", "Confirmation", JOptionPane.YES_NO_OPTION);
if(JOptionPane.YES_OPTION==choice){
array[i]="-1";
test=true;
}
else if(choice==JOptionPane.NO_OPTION) {
    JOptionPane.showMessageDialog(frame,"ok");
}
    }
}}
if (test){
    try {
        FileWriter writer=new FileWriter("acceptrent.txt");
        for(int i=0;i<n;i++){
writer.write(array[i]);
writer.write('\n');
        }
        writer.close();

    } catch (IOException e) {
        throw new RuntimeException(e);
    }
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
        FileWriter fileWriter=new FileWriter("room.txt");
        for(int j=0;j<i;j++){
            fileWriter.write(array1[j]);
            fileWriter.write("\n");
        }
        fileWriter.close();
        int choice = JOptionPane.showConfirmDialog(frame,"با موفقیت تحویل داده شد ایا از خدمات ما راضی بودید؟","Confirmation", JOptionPane.YES_NO_OPTION);
        if (choice==JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(frame,"با تشکر از نظر لطف شما منتظر دیدار دوباره شما هستیم" );
        }
        else if(choice==JOptionPane.NO_OPTION){
            JOptionPane.showMessageDialog(frame," مهم نیست");
        }
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}
if(!test){
    JOptionPane.showMessageDialog(frame,"s");
}
}

    /*cancellothgh*/
    public void cancelroom(JFrame frame){
        frame.dispose();
JFrame frame1=new JFrame();
JTextField textField=new JTextField();
ImageIcon imageIcon1=new ImageIcon("room.png");
JLabel label=new JLabel(imageIcon1);
label.setBounds(0,0,800,600);
label.setOpaque(false);
frame1.add(label);
        frame1.setSize(800, 600);
        frame1.setLocationRelativeTo(null);
        frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame1.setResizable(false);
        frame1.setLayout(null);
        frame1.setVisible(true);
    }

    public String getBed() {
        return bed;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setBed(String bed) {
        this.bed = bed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
