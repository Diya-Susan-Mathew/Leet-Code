class Solution {
    public int mostWordsFound(String[] sentences) {
        int maxWords = 0;
        for (String sentence : sentences) {
            int spaceCount = 0;
            int len = sentence.length();
            
            for (int i = 0; i < len; i++) {
                if (sentence.charAt(i) == ' ') {
                    spaceCount++;
                }
            }
            maxWords = Math.max(maxWords, spaceCount + 1);
        } 
        return maxWords;
    }
}
