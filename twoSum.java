import java.util.*;
public class twoSum {

    public static void two_(int arr[], int target) {

        ArrayList<Integer>list=new ArrayList<>();

      int start=0;
      int end=arr.length-1;

      while(start<end){

        if((arr[start]+arr[end])==target) {
            System.out.println(start+" "+end);
        }
        else if((arr[start]+arr[end])<target){
            start++;
        }
        else{
            end--;
        }
        

      
    
    }
    }

    public static void main(String args[]){

        int arr[]={2,3,4,6,7,8};

        int target=10;
        two_sum(arr, target);

    



    }
    
}
