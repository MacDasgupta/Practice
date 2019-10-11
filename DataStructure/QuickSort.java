package DataStructure;

public class QuickSort {

    private int array[];
    private int length;
    public static void main(String[] args) {
        QuickSort sorter = new QuickSort();
        int[] input = {24,2,45,20,56,75,2,56,99,53,12};
        sorter.sort(input);
        for (int i:input
             ) {
            System.out.print(i+ " ");
        }
    }

    public void sort(int[] inputArray){
        if(inputArray==null||inputArray.length==0){
            return;
        }
        this.array=inputArray;
        length=inputArray.length;
        quickSort(0,length-1);
    }
    private void quickSort(int lowerindex,int higherIndex){
        int i=lowerindex;
        int j=higherIndex;

        //calculate pivot number,
        int pivot =array[lowerindex+(higherIndex-lowerindex)/2];

        //Divide into 2 arrays
        while (i<=j){
            //In each iteration we will find a value greater than pivot from left and swap with the right
            while(array[i]<pivot)
                i++;
            while(array[j]>pivot)
                j--;
            if(i<=j){
                exchangeNumbers(i,j);
                i++;
                j--;
            }
        }
        if(lowerindex<j)
            quickSort(lowerindex,j);
        if(i<higherIndex)
            quickSort(i,higherIndex);
    }

    private void exchangeNumbers(int i,int j){
        int temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }
}
