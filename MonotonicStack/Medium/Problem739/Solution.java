import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n]; // Automatically initialized to 0s
        
        // Deque is faster and preferred over the legacy Stack class
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int currentIndex = 0; currentIndex < n; currentIndex++) {
            // Check if current temperature is warmer than the temperature at the stack's top index
            while (!stack.isEmpty() && temperatures[currentIndex] > temperatures[stack.peek()]) {
                int previousIndex = stack.pop();
                // Calculate the day difference
                answer[previousIndex] = currentIndex - previousIndex;
            }
            // Push the current day's index onto the stack
            stack.push(currentIndex);
        }
        
        return answer;
    }
}
