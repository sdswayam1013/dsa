import java.util.Scanner;

public class ProductExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];   // prefix product
        int[] right = new int[n];  // suffix product
        int[] answer = new int[n];

        
        left[0] = 1; //For index 0 (the first element in the array), there are no elements to its left.
                      //the product of “no numbers” is taken as 1 (the multiplicative identity).
                      //makes the formula consistent. answer[0] = left[0] * right[0]=  = 1 * product(all elements right of 0)
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        right[n - 1] = 1; //Similar concept. Last element and no more element to right, product of "no number" is taken as 1
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        // Answer = left * right
        for (int i = 0; i < n; i++) {
            answer[i] = left[i] * right[i];
        }
         return answer;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = scn.nextInt();
        int[] nums = new int[n];

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = scn.nextInt();
        }
        int[] result = productExceptSelf(nums);

        System.out.println("Product array except self:");
        for (int val : result) {
            System.out.print(val + " ");
        }
        scn.close();
    }
}
