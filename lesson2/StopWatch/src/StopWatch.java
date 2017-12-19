import java.util.Scanner;

public class StopWatch {
    public static void main(String[] argc)
    {   Scanner s=new Scanner(System.in);
       tuka: while(true) {
            System.out.println("Enter 'start' to start counting");
            String word = s.next();
            if (word.toLowerCase().equals("start")) {
                Watch stopwatch=new Watch();
                stopwatch.start();
                System.out.println("start stopwatch ");
                while(true) {
                    System.out.println("Enter 'p' to pause counting");
                    System.out.println("Enter 'r' to continue counting");
                    System.out.println("Enter 's' to stop counting");


                    word = s.next();
                    if (word.toLowerCase().equals("p")) {
                        System.out.println("pause stopwatch ");
                        stopwatch.pause();

                    } else if (word.toLowerCase().equals("r")) {
                        System.out.println("resume stopwatch ");
                        stopwatch.resume();

                    } else if (word.toLowerCase().equals("s")) {
                       stopwatch.stop();
                        break tuka;
                    } else {
                        System.out.println("Please enter pause/resume/stop");
                    }
                }
            }
        }

        System.out.println("You stopped the counter");
    }

}
