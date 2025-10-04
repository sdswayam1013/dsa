import java.util.*;

public class MaximumSubarrayKadane {
    public static int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];
         for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);//maths.max is used to tackle the boundary conditions
            maxSum = Math.max(maxSum, currentSum);
        }
         return maxSum;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
         int n = scn.nextInt();
        int[] nums = new int[n];
        
        for (int i = 0; i < n; i++) {
            nums[i] = scn.nextInt();
        }
         int result = maxSubArray(nums);
        System.out.println(result);

        scn.close();
    }
}
