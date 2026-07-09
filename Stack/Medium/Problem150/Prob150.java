import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for (String token : tokens) {
            // Using a switch block handles operators beautifully without repetitive code
            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                    
                case "-":
                    // Order matters: second popped minus first popped
                    int firstSub = stack.pop();
                    int secondSub = stack.pop();
                    stack.push(secondSub - firstSub);
                    break;
                    
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                    
                case "/":
                    // Order matters: second popped divided by first popped
                    int firstDiv = stack.pop();
                    int secondDiv = stack.pop();
                    stack.push(secondDiv / firstDiv);
                    break;
                    
                default:
                    // If it is not an operator, it must be a number (handles negatives too!)
                    stack.push(Integer.parseInt(token));
                    break;
            }
        }
        
        return stack.pop();
    }
}
