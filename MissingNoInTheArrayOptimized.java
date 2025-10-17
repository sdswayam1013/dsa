import java.util.*;
public class MissingNoInTheArrayOptimized {
    
public static void main(String[]args){
    Scanner scn = new Scanner(System.in);

    System.out.println("enter the number of elements in the array:");
    int n = scn.nextInt();

    int [] nums = new int[n];
    System.out.println("enter the elements:");

    for(int i=0 ; i < n; i++){
        nums[i] = scn.nextInt();
    }
    List<Integer> missing  = Missingno(nums);
    System.out.println("Missing numbers" + missing);

    scn.close();
}

public static List<Integer> Missingno(int nums[]){

    //mark the visited elements by making them negative
  for(int i = 0; i < nums.length ; i++){
    int index  = Math.abs(nums[i]) - 1; //get correct index
    if(nums[index] > 0){
        nums[index] = -nums[index];
    }
  }
  // Collect indexes that are still positive

  List<Integer> result = new ArrayList<>() ;
    for(int i = 0; i< nums.length; i++){
        if(nums[i] > 0){
          result.add(i+1); // index + 1 gives the missing number
        }
    }
    return result; 
  }


   
    
}

