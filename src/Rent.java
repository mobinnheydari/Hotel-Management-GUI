import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Rent extends javax.swing.JFrame{
    private LocalDateTime time;
    private String code;
    private int price;
    private String codeemploye;
    private int day;
    private int id;
    private ArrayList<Room>rooms=new ArrayList<>();
JFrame frame;
    public Rent(LocalDateTime time, String code, int price, String codeemploye, int day, int id) {
        this.time = time;
        this.code = code;
        this.price = price;
        this.codeemploye = codeemploye;
        this.day = day;
        this.id = id;
    }
    public void rentroom(String room,String memeber,String day,String price){
        String name1 = "";
        String lastname1 = "";
        String code1 = "";
        String email1 = "";
int c=0;
String []arr=memeber.split(",");
String codemeli=arr[2];
String array[]=room.split(",");
String numberroom=array[1];
boolean test=false;
        try {
            FileWriter writer = new FileWriter("rent.txt",true);
        writer.write(codemeli);
        writer.write(',');
        writer.write(numberroom);
        writer.write(',');
        writer.write(price);
        writer.write(',');
        writer.write(day);
        writer.write(',');
        writer.write('\n');
            JOptionPane.showMessageDialog(frame,"درخواست رزرو شما ثبت شد منتظر تایید کارکنان مان باشید");
            writer.close();
            test=true;
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        int n=0;
        String aray[]=new String[9999];
        if(test){
            try {
                File file=new File("room.txt");
                Scanner input=new Scanner(file);
                while (input.hasNextLine()){
                    String tst=input.nextLine();
                    aray[n]=tst;
                    n++;
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            for (int i=0;i<n;i++){
                if(aray[i].equals(room)){
                    String information[]=room.split(",");
                    String status=information[0];
                    String numberoom=information[1];
                    String bed=information[2];
                    String money=information[3];
                    status="waite";
                    String full=status+','+numberoom+','+bed+','+money+',';
                    aray[i]=full;
                }
            }
            try {
                FileWriter writer=new FileWriter("room.txt");
for(int i=0;i<n;i++){
    writer.write(aray[i]);
    writer.write('\n');
}
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
/*status room taghir dadeh nahsoe*/
    public void cnslbook(String person){
      String codemeli="";
        String array[]=new String[9999];
        int n=0;
        boolean test=false;
        String numberroom="";
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
        int x=0;
        String price="";
        String day="";
for(int i=0;i<n;i++){
    if(array[i].length()>2){
    String check[]=array[i].split(",");
    String tst[]=person.split(",");
    if(check[0].equals(tst[2])){
        test=true;
        x=i;
        numberroom=check[1];
        codemeli=check[0];
        day=check[3];
        check[2]=price;
    }
}}
if(!test){
    JOptionPane.showMessageDialog(frame,"شما تا الان درخواست رزروی ندارید");
}
if(test){
    array[x]=codemeli+","+numberroom+","+price+","+day+","+"-2"+",";
    try {
        FileWriter writer=new FileWriter("rent.txt");
        for(int i=0;i<n;i++){
            writer.write(array[i]);
            writer.write('\n');
        }
        writer.close();
    } catch (IOException e) {
        throw new RuntimeException(e);
    }

    JOptionPane.showMessageDialog(frame," درخواست شما با موفقیت کنسل شد منتظر تایید کارمندانمان باشید");
}
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCodeemploye() {
        return codeemploye;
    }

    public void setCodeemploye(String codeemploye) {
        this.codeemploye = codeemploye;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
