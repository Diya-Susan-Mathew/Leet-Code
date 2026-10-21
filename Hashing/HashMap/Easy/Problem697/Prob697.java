class Solution {
    public int findShortestSubArray(int[] nums) {
        // Map to store the index of the first occurrence of each number
        Map<Integer, Integer> firstSeen = new HashMap<>();
        // Map to store the frequency count of each number
        Map<Integer, Integer> counts = new HashMap<>();
        
        int degree = 0;
        int minLength = Integer.MAX_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            
            // Record the first time we see this number
            if (!firstSeen.containsKey(num)) {
                firstSeen.put(num, i);
            }
            
            // Update the frequency count
            counts.put(num, counts.getOrDefault(num, 0) + 1);
            int currentCount = counts.get(num);
            
            // Case 1: We found a number with a higher frequency (new degree)
            if (currentCount > degree) {
                degree = currentCount;
                minLength = i - firstSeen.get(num) + 1;
            } 
            // Case 2: We found another number that matches the current maximum degree
            else if (currentCount == degree) {
                minLength = Math.min(minLength, i - firstSeen.get(num) + 1);
            }
        }
        return minLength;
        
    }
}