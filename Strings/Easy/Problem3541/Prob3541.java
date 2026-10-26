class Solution {
    public int maxFreqSum(String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                freq[ch - 'a']++;
            }
        }
        int maxVowel = 0;
        int maxConso = 0;
        for (int i = 0; i < 26; i++) {
            char ch = (char) ('a' + i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                maxVowel = Math.max(maxVowel, freq[i]);
            } else {
                maxConso = Math.max(maxConso, freq[i]);
            }
        }
        
        return maxVowel + maxConso;
    }
}
