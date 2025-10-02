import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

// problem link: https://www.hackerrank.com/challenges/arrays-ds/problem?isFullScreen=true
class Result {

    
    public static List<Integer> reverseArray(List<Integer> a) {
      
   // ArrayList<Integer> a1 = new ArrayList<>(a);//here a new arraylist a1 is created and the elements of "a" is copied to a1 and then a1 is reversed.
    Collections.reverse(a);//instead we can directly write Collections.reverse(a)
    return a;
    }

    }



public class ArrayReverse {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        
        for (int i = 0; i < Math.min(arrCount, arrTemp.length); i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }
        
        List<Integer> res = Result.reverseArray(arr);

        for (int i = 0; i < res.size(); i++) {
            bufferedWriter.write(String.valueOf(res.get(i)));

            if (i != res.size() - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
