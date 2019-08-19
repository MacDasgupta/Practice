package DailyCodingProblem;

// Java program to find the smallest
// positive missing number
import java.util.*;

class SmallestMissingNumber
{

    /* Utility function that puts all non-positive
    (0 and negative) numbers on left side of
    arr[] and return count of such numbers */
    static int segregate (int arr[], int size)
    {
        int j = 0, i;
        for(i = 0; i < size; i++)
        {
            if (arr[i] <= 0)
            {
                int temp;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                // increment count of non-positive
                // integers
                j++;
            }
        }
        System.out.println("The segregated array "+Arrays.toString(arr));
        return j;
    }

    /* Find the smallest positive missing
    number in an array that contains
    all positive integers */
    static int findMissingPositive(int arr[], int size)
    {
        int i;

        // Mark arr[i] as visited by making
        // arr[arr[i] - 1] negative. Note that
        // 1 is subtracted because index start
        // from 0 and positive numbers start from 1
        int in=1;
        System.out.println("the size is :"+size);
        for(i = 0; i < size; i++)
        {
            int x = Math.abs(arr[i]);

            if(x - 1 < size && arr[x - 1] > 0){
                arr[x - 1] = -arr[x - 1];
                System.out.println("the value is :"+arr[x-1]);
                System.out.println("Inside the if condition "+ (x-1));
            }
            System.out.println("The value of changing array :"+Arrays.toString(arr));
        }
        System.out.println("The final array values "+Arrays.toString(arr));

        // Return the first index value at which
        // is positive
        for(i = 0; i < size; i++)
            if (arr[i] > 0)
                return i+1; // 1 is added becuase indexes
        // start from 0

        return size+1;
    }

    /* Find the smallest positive missing
    number in an array that contains
    both positive and negative integers */
    static int findMissing(int arr[], int size)
    {
        // First separate positive and
        // negative numbers
        int shift = segregate (arr, size);
        System.out.println("Normal size :"+size);
        System.out.println("Shift size :"+shift);
        int arr2[] = new int[size-shift];
        int j=0;
        for(int i=shift;i<size;i++)
        {
            arr2[j] = arr[i];
            j++;
        }
        System.out.println("The new array "+Arrays.toString(arr2));
        // Shift the array and call
        // findMissingPositive for
        // positive part
        return findMissingPositive(arr2, j);
    }


    // main function
    public static void main (String[] args)
    {
        int arr[] = {0, 10, 1, -10, -20,-30,4,2,6,3,8};
        int arr_size = arr.length;
        int missing = findMissing(arr, arr_size);
        System.out.println("The smallest positive missing number is "+
                missing);
    }
}

