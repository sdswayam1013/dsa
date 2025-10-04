import java.util.Arrays;
import java.util.Scanner;

public class FindDisappearedDynamic {
    
    public static int[] findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        if (n == 0) return new int[0];

        
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);     // original value regardless of sign, use of absolute
            if (num >= 1 && num <= n) {     
                int idx = num - 1;
                if (nums[idx] > 0) {
                    nums[idx] = -nums[idx]; // mark visited by negating the value at index (num-1).
                }
            }
        }

        int missingCount = 0;                 //Count the positive value and those willbe the no. got deleted
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) missingCount++;
        }

       
        int[] result = new int[missingCount];  // result array of exact size and fill it and to get the exact value,
        int pos = 0;                           //we have to add 1 to i because we have already reduced it before.
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                result[pos++] = i + 1; //result[pos] = i + 1; pos = pos + 1;
            }
        }

        return result;
    }

   

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n (array length): ");
        if (!sc.hasNextInt()) {
            System.out.println("Invalid input for n.");
            sc.close();
            return;
        }
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter " + n + " integers (space separated): ");
        for (int i = 0; i < n; i++) {
            if (sc.hasNextInt()) nums[i] = sc.nextInt();
            else nums[i] = 0; // if no value is given by user , it will take it as 0.
        }
        sc.close();

        System.out.println("Input:  " + Arrays.toString(nums)); //without toString address would get printed
        int[] missing = findDisappearedNumbers(nums);
        System.out.println("Missing: " + Arrays.toString(missing));

       
    }
}
