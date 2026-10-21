class Solution {
    public int reverseDegree(String s) {
        int sum = 0;
        
        for (int i = 0; i < s.length(); i++) {
            // Calculate reverse alphabet position: 'a' -> 26, 'b' -> 25, ..., 'z' -> 1
            int reverseValue = 26 - (s.charAt(i) - 'a');
            
            // Multiply by 1-based string index (i + 1)
            sum += (i + 1) * reverseValue;
        }
        
        return sum;
    }
}
