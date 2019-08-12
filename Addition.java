
//a list of numbers and a number k, return whether any two numbers from the list add up to k
package CodeChef;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Addition {
    public static void main(String[] args){

        int k =130;
        int[] arr ={4,6,10,3,11,20,2,9,13,3};

         List<Integer> twoNumbers = adding(k,arr);
         if(twoNumbers.size()==0){
             System.out.println("There are no numbers");
         }
         else{
             Stream.of(twoNumbers).forEach(s-> System.out.println(s));
         }
    }

    static List<Integer> adding(int a,int[] ar){
        List<Integer> arList = Arrays.stream( ar ).boxed().collect( Collectors.toList() );
        Collections.sort(arList);
        int start = 0;
        int rear = arList.size()-1;
        List<Integer>  twoNumbers = new ArrayList<>();

        while(rear > start){
            if((arList.get(start)+arList.get(rear))>a)
            {
                rear--;
            }
            else if((arList.get(start)+arList.get(rear))<a){
                start ++;
            }
            else{
                twoNumbers.add(arList.get(start));
                twoNumbers.add(arList.get(rear));
                break;
            }
        }
        return twoNumbers;
    }

}
