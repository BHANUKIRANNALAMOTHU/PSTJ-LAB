import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef {
    public static void main (String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        
        int T = sc.nextInt();
        while (T-- > 0) {
            String s = sc.next();
            int len = s.length();
            int halfLen = len / 2;
            
            // Extract the left and right halves
            String leftHalf = s.substring(0, halfLen);
            // If length is odd, skip the middle character (hence len - halfLen)
            String rightHalf = s.substring(len - halfLen);
            
            // Convert to char arrays and sort
            char[] leftArr = leftHalf.toCharArray();
            char[] rightArr = rightHalf.toCharArray();
            
            Arrays.sort(leftArr);
            Arrays.sort(rightArr);
            
            // Compare sorted arrays
            if (Arrays.equals(leftArr, rightArr)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        sc.close();
    }
}
