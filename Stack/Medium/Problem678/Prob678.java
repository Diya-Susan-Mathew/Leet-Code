class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> open_stack = new Stack<>();
        Stack<Integer> star_stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '('){
                open_stack.push(i);
            }else if(s.charAt(i) == '*'){
                star_stack.push(i);
            }else if(s.charAt(i) == ')'){
                if(!open_stack.isEmpty()){
                    open_stack.pop();
                }else if(open_stack.isEmpty() && !star_stack.isEmpty()){
                    star_stack.pop();
                }else if(open_stack.isEmpty() && star_stack.isEmpty()){
                    return false;
                }
            }
        }
        while(!open_stack.isEmpty() && !star_stack.isEmpty()){
            int first = open_stack.pop();
            int second = star_stack.pop();
            if(first > second){
                return false;
            }
        }
        return open_stack.isEmpty();

    }
}