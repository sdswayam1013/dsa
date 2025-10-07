
    
    import java.util.Scanner;

public class TrappingRWprefixarrayOpt {    
   
    public static int trapWithPrefixArrays(int[] height) {
        int n = height.length;
        if (n == 0) return 0;

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int water = 0;

       
        leftMax[0] = height[0]; //building of left array
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]); //using leftMax of previously calculated and not 
                                                               //calculating again and again as in brute force
        }

         rightMax[n - 1] = height[n - 1]; //building of right array
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        for (int i = 0; i < n; i++) {
            water += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return water;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

         System.out.print("Enter number of pillar heights: ");
        int n = sc.nextInt();

        int[] height = new int[n];

        System.out.println("Enter heights of pillars: ");
        for (int i = 0; i < n; i++) {
            height[i] = sc.nextInt();
        }
        System.out.println("Water Trapped" + trapWithPrefixArrays(height));
        sc.close();
    }
}

