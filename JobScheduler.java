package DailyCodingProblem;

import java.util.Timer;
import java.util.TimerTask;

//Daily Coding Problem 10
public class JobScheduler {
    public static void main(String[] args) {
/*        solution(new Command(){
            @Override
            public void execute(){
                System.out.println("Daily Coding");
            }
        },1000);*/

        solution(() -> System.out.println("Hello World"), 1000);
    }

    public static void solution(Command command , int n){
        new Timer().schedule(new TimerTask(){
            @Override
            public void run(){
                command.execute();
            }
        },n);
    }
    interface  Command{
        public void execute();
    }
}
