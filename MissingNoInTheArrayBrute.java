import java.util.*;
public class MissingNoInTheArrayBrute {
    public static List<Integer> findDisappearedNumbers(int nums[] ){
        List<Integer> result = new ArrayList<>();

        for(int i = 1 ; i<= nums.length; i++){
            boolean found = false;
            for(int j= 0; j < nums.length; j++){
                if( nums[j] == i){
                    found = true;
                    break;
                }
            }
            if (!found)
            result.add(i);
        }
        return result;
    }

    

public static void main(String[]args){
    System.out.println("enter the number of elements in the array");
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    System.out.println("entr the elements in the array");
    int [] nums = new int[n];

    for(int i =0; i < n; i++){
         nums [i] = scn.nextInt();

    }
    List<Integer> missing = findDisappearedNumbers(nums);
    System.out.println("Missing numbers:" + missing);

    scn.close();
}
}
