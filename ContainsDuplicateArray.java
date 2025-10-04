import java.util.Arrays;
import java.util.Scanner;

public class ContainsDuplicateArray {
    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums); //first sorting the array

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true; //comapring only the adjacent elements 
            }
        }
        return false; 
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = scn.nextInt();
        int[] nums = new int[n];

        System.out.println("Enter the elements: ");
        for (int i = 0; i < n; i++) {
            nums[i] = scn.nextInt();
        }

        boolean result = containsDuplicate(nums);

        System.out.println(result ? "true" : "false");
    }
}
