package DailyCodingProblem;

public class MaxSum {
    public static void main(String[] args) {

        int arr[] = new int[]{5, 5, 10, 100, 10, 5};
        System.out.println("The maximum sum is : "+findMaxSum(arr));
    }

    static int findMaxSum(int arr[]){
        int len = arr.length;
        int incl = arr[0];
        int excl = 0;
        int excl_tmp;
        for(int i=1;i<len;i++){

            /* current max excluding i */
            excl_tmp =(incl>excl)?incl:excl;

            /* current max including i */
            incl = excl+arr[i];

            excl = excl_tmp;
        }

        /* return max of incl and excl */
        return ((incl>excl)?incl:excl);
    }
}
