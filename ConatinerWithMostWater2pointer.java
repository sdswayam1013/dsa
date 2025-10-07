import java.util.*;


public class ConatinerWithMostWater2pointer {
    public static int maxArea(int height[]){

        if(height == null || height.length<2)
        return 0;

        int left = 0;
        int right = height.length-1;
        int maxArea = 0;

        while(left<right){
            int width = right  - left;
            int minHeight = Math.min(height[left], height[right]);
            int area = width * minHeight;
            maxArea = Math.max( maxArea,area);

            // move the smaller pointer
             if(height[left]< height[right])
               left++;
             else
               right--;
        }
            return maxArea;
    }

    public static void main(String[]args){
        Scanner scn = new Scanner(System.in);

        System.out.println("enter the no of the elements");
        int n = scn.nextInt();

        int height[] = new int[n];
        System.out.println("enter the heights of those elements");
        

        for(int i=0 ; i<n; i++){
          height[i] = scn.nextInt();
        }
         int result = maxArea(height);
         System.out.println("Maximumarea"+ result);
         scn.close();
    }
    
     
}
