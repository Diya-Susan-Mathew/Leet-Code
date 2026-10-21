import java.util.Stack;

class Solution {
    public String reverseVowels(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'u' || s.charAt(i) == 'U' ||
                s.charAt(i) == 'o' || s.charAt(i) == 'O' ||
                s.charAt(i) == 'a' || s.charAt(i) == 'A' ||
                s.charAt(i) == 'e' || s.charAt(i) == 'E' ||
                s.charAt(i) == 'i' || s.charAt(i) == 'I') {
                stack.push(s.charAt(i));
            }
        }

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == 'u' || sb.charAt(i) == 'U' ||
                sb.charAt(i) == 'o' || sb.charAt(i) == 'O' ||
                sb.charAt(i) == 'a' || sb.charAt(i) == 'A' ||
                sb.charAt(i) == 'e' || sb.charAt(i) == 'E' ||
                sb.charAt(i) == 'i' || sb.charAt(i) == 'I') {
                sb.setCharAt(i, stack.pop());
            }
        }

        return sb.toString();
    }
}