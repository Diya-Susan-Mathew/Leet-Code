class Solution {
    public int prefixCount(String[] words, String pref) {
        int count = 0;
        for (String word : words) {
            if (word.length() >= pref.length()) {
                boolean isMatch = true;
                for (int j = 0; j < pref.length(); j++) {
                    if (word.charAt(j) != pref.charAt(j)) {
                        isMatch = false;
                        break;
                    }
                }
                if (isMatch) {
                    count++;
                }
            }
        }
        return count;
    }
}