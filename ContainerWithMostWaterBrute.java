import java.util.Scanner;
public class ContainerWithMostWaterBrute {
    public static int maxAreaBruteForce(int[] height) {
        int n = height.length;
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int area = Math.min(height[i], height[j]) * (j - i);
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        return maxArea;
}


public static void main(String[]args){

    Scanner sc = new Scanner(System.in);
    try{
    System.out.println("enter the number of lines ");
    int n = sc.nextInt();

    if(n<2){
        System.out.println("At least two lines are needed to make a container");
        return;
    }

    int[] height = new int[n];
    System.out.println("enter the heights of the lines");
    for(int i=0; i<n; i++){
        height[i] = sc.nextInt();
    }
     
    int result = maxAreaBruteForce(height);
    System.out.println(result);
}
 finally{
    sc.close();
 }
}
}
