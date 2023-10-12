import java.util.Scanner;
public class Scores {
    public static void main(String[] args) throws Exception {
        int [] arr = {90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100};
        int [] midGrade = {80, 81, 82, 83, 84, 85, 86, 87, 88, 89};
        int [] lower = {70, 71, 72, 73, 74, 75, 76, 77, 78, 79};
        int [] midLower = {60, 61, 62, 63, 64, 65, 66, 67, 68, 69};
        
        System.out.println("Enter Student's Score: ");
        int scoreValue = getScore();

        assignGrade(scoreValue, arr, 4.0);
        assignGrade(scoreValue, midGrade, 3.0);
        assignGrade(scoreValue, lower, 2.0);
        assignGrade(scoreValue, midLower, 1.0);
        
    }

    public static int getScore(){
        Scanner sc = new Scanner(System.in);
        int score = sc.nextInt();
        sc.close();
        return score;
        
    }

    public static void assignGrade(int scoreValue, int [] gradeArray, double grade) {

        for (int value : gradeArray) {
            if (value == scoreValue) {
                System.out.println(grade);
                return;
            }

        }
    }
   
}
