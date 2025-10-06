import java.util.Scanner;

public class FindDuplicateNumber {
    public static int findDuplicate(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);  

            if (nums[num] < 0) {
                return num; // duplicate found
            }
            nums[num] = -nums[num]; //marking the index
        }
        return -1; 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array (n+1): ");
        int size = sc.nextInt();

        int[] nums = new int[size];
        System.out.println("Enter " + size + " elements (values in range 1 to " + (size - 1) + "):");
        for (int i = 0; i < size; i++) {
            nums[i] = sc.nextInt();
        }

        int duplicate = findDuplicate(nums);
        if (duplicate != -1) {
            System.out.println("Duplicate number is: " + duplicate);
        } else {
            System.out.println("No duplicate found.");
        }

        sc.close();
    }
}
