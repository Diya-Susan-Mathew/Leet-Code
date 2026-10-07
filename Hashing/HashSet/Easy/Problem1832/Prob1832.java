class Solution {
    public boolean checkIfPangram(String sentence) {
        HashSet<Character> set = new HashSet<>();
        for(char c : sentence.toCharArray()){
            set.add(c);
        }
        int count = set.size();
        if(count == 26){
            return true;
        }
        return false;
    }
}