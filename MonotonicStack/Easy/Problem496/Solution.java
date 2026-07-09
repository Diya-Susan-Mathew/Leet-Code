import java.util.HashMap;
import java.util.Stack;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // Map to store the next greater element for each number in nums2
        HashMap<Integer, Integer> nextGreaterMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
       
        // Step 1 & 2: Process nums2 using a monotonic stack
        for (int num : nums2) {
            // While stack is not empty and current number is greater than stack top
            while (!stack.isEmpty() && num > stack.peek()) {
                // We found the next greater element for the stack top!
                nextGreaterMap.put(stack.pop(), num);
            }
            // Push the current number onto the stack to wait for its next greater
            stack.push(num);
        }
       
        // Step 3: Build the result array for nums1
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            // Look up the answer in the map.
            // If the number never found a greater element, default to -1.
            result[i] = nextGreaterMap.getOrDefault(nums1[i], -1);
        }
       
        return result;
    }
}