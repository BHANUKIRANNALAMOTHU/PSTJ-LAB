import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the number of lines
        int n = scanner.nextInt();
        
        // Create a 2D ArrayList (ArrayList of ArrayLists)
        List<List<Integer>> lines = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            int d = scanner.nextInt(); // Number of elements in current line
            List<Integer> line = new ArrayList<>();
            for (int j = 0; j < d; j++) {
                line.add(scanner.nextInt());
            }
            lines.add(line);
        }
        
        // Read the number of queries
        int q = scanner.nextInt();
        
        for (int i = 0; i < q; i++) {
            int x = scanner.nextInt(); // 1-based line number
            int y = scanner.nextInt(); // 1-based position number
            
            // Adjust to 0-based indexing for Java ArrayList
            int lineIdx = x - 1;
            int posIdx = y - 1;
            
            // Check if line index and position index are within valid bounds
            if (lineIdx >= 0 && lineIdx < lines.size() && posIdx >= 0 && posIdx < lines.get(lineIdx).size()) {
                System.out.println(lines.get(lineIdx).get(posIdx));
            } else {
                System.out.println("ERROR!");
            }
        }
        
        scanner.close();
    }
}
