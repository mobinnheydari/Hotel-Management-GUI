public class Main {
    public static void main(String[] args) {
//Game game=new Game();
//Homepage homepage= new Homepage(new JFrame());
        int n=5;
        int c=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
               c++;
            }
            n=n/2;
        }
        System.out.println(c);
    }
}
