class Solution {
    public int heightChecker(int[] heights) {
        int ans = 0;
        int currentHeight = 1;
        int[] count = new int[101]; // Array size 101 to safely index up to height 100
        
        // Step 1: Count the occurrences of each height
        for (int height : heights) {
            count[height]++;
        }
        
        // Step 2: Traverse heights and compare to expected height order
        for (int height : heights) {
            // Find the next height that should be in line
            while (count[currentHeight] == 0) {
                currentHeight++;
            }
            
            // If the current student does not match the expected height, increment answer
            if (height != currentHeight) {
                ans++;
            }
            
            // Consume one instance of this expected height
            count[currentHeight]--;
        }
        
        return ans;
    }
}
