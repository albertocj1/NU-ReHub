import java.util.Scanner;
class Simple{  
    public static void main(String args[]){  
        System.out.println("Hello Java");
        System.out.println("ampoge q");
    }  

    public static int getScore(){
        Scanner sc = new Scanner(System.in);
        int score = sc.nextInt();
        sc.close();
        return score;
        
    }
}  