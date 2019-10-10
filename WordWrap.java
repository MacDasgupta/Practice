package DailyCodingProblem;

public class WordWrap {
    public static void main(String[] args) {
        WordWrap w = new WordWrap();
        //length of each word
        int l[]={3,2,2,5};
        int n = l.length;
        int M = 6;
        solveWordWarap(l,n,M);
    }
    //method to find  space optimized soln
    static void solveWordWarap(int arr[],int n,int k){
        int i,j;
        //variable to store number of characters in given line
        int currlen;
        //variable to store min cost of the line
        int cost;
        //Dp table in which dp[i] represents cost of line starting with word arr[i]
        int dp[]=new int[n];
        //array in which ans[i] stores index of last word in line starting  with word arr[i]
        int ans[]=new int[n];

        dp[n-1]=0;
        ans[n-1]=n-1;

        for( i=n-2;i>=0;i--){
            currlen=-1;
            dp[i]=Integer.MAX_VALUE;
            for(j=1;j<n;j++){
                currlen+=(arr[j]+1);
                if(currlen>k)
                    break;

                if(j==n-1)
                    cost=0;
                else{
                    cost=(k-currlen)*(k-currlen)+dp[j+1];
                }
                if (cost < dp[i])
                {
                    dp[i] = cost;
                    ans[i] = j;
                }
            }
        }
        i=0;
        while(i<n){
            System.out.print((i + 1) + " " +
                    (ans[i] + 1) + " ");
            i = ans[i] + 1;
        }
    }
}
