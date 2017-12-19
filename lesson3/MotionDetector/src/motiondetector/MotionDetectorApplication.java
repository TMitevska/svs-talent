package motiondetector;

import java.util.Scanner;

public class MotionDetectorApplication {
    public static void main(String [] argc)
    {
        System.out.print("Enter 'start' to activate motion detector");
        Scanner scanner=new Scanner(System.in);
        String input= scanner.nextLine().toLowerCase();
        if(input.equals("start")){new MotionDetector().start();}

    }
}
