// My Approach

class Solution {
    public String removeDuplicates(String s) {
        
        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray()) {
            if(!stack.isEmpty() && stack.peek()==ch){
                stack.pop();
            }else{
                stack.push(ch);
            }
        }

        StringBuilder result = new StringBuilder();

        for(char ch : stack){
            result.append(ch);
        }
        return result.toString();
    }
}