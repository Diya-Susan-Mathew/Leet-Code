class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character,String> letterToWord = new HashMap<>();
        Map<String,Character> wordToLetter = new HashMap<>();
        String[] words = s.split(" ");
        if(pattern.length() != words.length){
            return false;
        }
        for(int i=0;i<pattern.length();i++){
            char c = pattern.charAt(i);
            String word = words[i];
            if(letterToWord.containsKey(c) && !(letterToWord.get(c).equals(word))){
                return false;
            }
            if(wordToLetter.containsKey(word) && !(wordToLetter.get(word).equals(c))){
                return false;
            }
            letterToWord.put(c,word);
            wordToLetter.put(word,c);
        }
        return true;
    }
}