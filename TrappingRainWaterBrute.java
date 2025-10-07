
    import java.util.Scanner;
public class TrappingRainWaterBrute {
    public static int trap(int[] height) {
        int n = height.length;
        int water = 0;

        for (int i = 0; i < n; i++) {
            int leftMax = height[i];
            int rightMax = height[i];

            for (int j = 0; j <= i; j++) {
                leftMax = Math.max(leftMax, height[j]);
            }
            for (int j = i; j < n; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }

            water += Math.min(leftMax, rightMax) - height[i];
        }

        return water;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] height = new int[n];

        System.out.println("Enter heights: ");
        for (int i = 0; i < n; i++) {
            height[i] = sc.nextInt();
        }

        int result = trap(height);
        System.out.println("Total trapped rainwater: " + result);

        sc.close();
    }
}


