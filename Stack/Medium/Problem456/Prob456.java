class Solution {
    public boolean find132pattern(int[] nums) {
        // If the array has fewer than 3 elements, the pattern is impossible
        if (nums.length < 3) {
            return false;
        }

        // This will keep track of our "2" (nums[k])
        int thirdElement = Integer.MIN_VALUE; 
        
        // The stack will keep track of our potential "3"s (nums[j])
        java.util.Stack<Integer> stack = new java.util.Stack<>();

        // Traverse the array from right to left
        for (int i = nums.length - 1; i >= 0; i--) {
            
            // If we find a "1" that is smaller than our "2", we found the pattern!
            if (nums[i] < thirdElement) {
                return true;
            }
            
            // If current element is greater than the top of the stack, 
            // it's a potential "3". We pop from the stack to update our "2".
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                thirdElement = stack.pop();
            }
            
            // Push the current element as a potential "3" for future iterations
            stack.push(nums[i]);
        }

        return false;
    }
}