import java.util.Scanner;

public class FindDuplicateFloydScanner {

    public static int findDuplicate(int[] nums) {
       
        int slow = nums[0]; //setting value for tort
        int fast = nums[0]; //setting value for hare

        do {                   //Pahse 1: to make sure that its a cycle or not
            slow = nums[slow]; 
            fast = nums[nums[fast]];
        } while (slow != fast);

                               // Phase 2: Find cycle entry
         slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow; //  got the duplicate value
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter size of array (n+1, >= 2): ");
            if (!sc.hasNextInt()) {
                System.out.println("Invalid input for size.");
                return;
            }
            int size = sc.nextInt();
            if (size < 2) {
                System.out.println("Size must be at least 2 (n+1 where n >= 1).");
                return;
            }

            int[] nums = new int[size];
            System.out.println("Enter " + size + " integers (each should be in range 1 to " + (size - 1) + "):");
            for (int i = 0; i < size; i++) {
                if (!sc.hasNextInt()) {
                    System.out.println("Insufficient/invalid integers provided. Exiting.");
                    return;
                }
                nums[i] = sc.nextInt();
            }

            boolean ok = true;
            for (int i = 0; i < size; i++) {
                if (nums[i] < 1 || nums[i] > size - 1) {
                    System.out.println("Warning: nums[" + i + "] = " + nums[i] +
                                       " is outside the expected range [1.." + (size - 1) + "].");
                    ok = false;
                }
            }
            if (!ok) {
                System.out.println("Algorithm assumes values in 1.." + (size - 1) + ". Results may be undefined.");
            }

            // Run Floyd's algorithm inside try to catch indexing issues if inputs are invalid
            int duplicate;
            try {
                duplicate = findDuplicate(nums);
                System.out.println("Duplicate number is: " + duplicate);
            } catch (ArrayIndexOutOfBoundsException ex) {
                System.out.println("Error: input values caused an out-of-bounds access. Check values are in 1..(n).");
            }

        } finally {
            sc.close();
        }
    }
}

