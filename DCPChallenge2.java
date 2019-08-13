package DailyCodingProblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DCPChallenge2 {
    static final double EPS = 1e-9;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter the number of elements in the array");
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }

        /*List<Integer> resultArray = getValue(arr);
        for (int j : resultArray) {
            System.out.println(j);
        }*/
        productPuzzle(arr);
    }

    //Time complexity O(n), Space Complexityo(n)
    /*static List<Integer> getValue(int[] inputValue) {
        int mulVal = 1;
        for (int j : inputValue) {
            mulVal = mulVal * j;
        }
        List<Integer> outputVal = new ArrayList<>();
        for (int j : inputValue) {
            outputVal.add(mulVal / j);
        }
        return outputVal;
    }*/
    //Time complexity O(n), Space Complexity o(1)
/*
    x = a * b * c * d
    log(x) = log(a * b * c * d)
    log(x) = log(a) + log(b) + log(c) + log(d)
    x = antilog(log(a) + log(b) + log(c) + log(d))*/
    static void productPuzzle(int a[]) {

        int n = a.length;
        // to hold sum of all values
        double sum = 0;
        for (int i = 0; i < n; i++) {
            System.out.println(Math.log10(a[i]));

            sum += Math.log10(a[i]);
        }
        System.out.println(sum);

        // output product for each index
        // anti log to find original product value
        for (int i = 0; i < n; i++)
            System.out.print((int) (EPS+Math.pow(10.00,
                    sum - Math.log10(a[i]))) + " ");
    }

}
