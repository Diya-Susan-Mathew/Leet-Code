class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String,Integer> countWords = new HashMap<>();
        ArrayList<String> result = new ArrayList<>();
        for(String word : s1.split(" ")){
            countWords.put(word,countWords.getOrDefault(word,0)+1);
        }
        for(String word : s2.split(" ")){
            countWords.put(word,countWords.getOrDefault(word,0)+1);
        }
        for(Map.Entry<String,Integer> entry : countWords.entrySet()){
            if(entry.getValue() == 1){
                result.add(entry.getKey());
            }
        }
        return result.toArray(new String[0]);
    }
}