package DailyCodingProblem;

import java.util.Scanner;

public class StairCaseCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int steps = sc.nextInt();
        int[] ways = {1,3,5};
        System.out.println("The number ways are "+findNoSteps(steps));
       // System.out.println("The number of ways with given number of steps are "+findSpecificSteps(steps,ways));

    }


    //Recursion
/*    static int findNoSteps(int n){
        if(n==1||n==0)
            return 1;
        else if(n==2)
            return 2;
        else{
            return (findNoSteps(n-2)+findNoSteps(n-1));
        }
    }*/

//Dynamic Programming

    static int findNoSteps(int n){
        if (n <= 1) {
            return 1;
        }

        // base case: 1 way (with no steps)
        int a = 1;

        // There is only 1 way to reach the 1st stair
        int b = 1;

        // There are 2 ways to reach the 2nd stair
        int c = 2;

        for (int i = 3; i <= n; i++)
        {
            int result = b + c;

            a = b;
            b = c;
            c = result;
        }

        return c;
    }


}
