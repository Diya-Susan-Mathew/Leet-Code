import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> result = new ArrayList<>();
        
        // Base case for Row 0: [1]
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        result.add(firstRow);
        
        if (rowIndex == 0) {
            return result.get(0);
        }
        
        // Notice the loop condition changes to "i <= rowIndex" to include the target row
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> prevRow = result.get(i - 1);
            List<Integer> currentRow = new ArrayList<>();
            
            currentRow.add(1); // Row always starts with 1
            
            // Fixed loop boundaries for adding middle elements
            for (int j = 0; j < prevRow.size() - 1; j++) {
                currentRow.add(prevRow.get(j) + prevRow.get(j + 1));
            }
            
            currentRow.add(1); // Row always ends with 1
            result.add(currentRow);
        }
        
        return result.get(rowIndex);
    }
}
