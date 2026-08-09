class Solution {
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '*') {
                // Remove the last appended character (simulating stack pop)
                sb.deleteCharAt(sb.length() - 1);
            } else {
                // Append the character (simulating stack push)
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}
