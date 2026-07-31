class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer,Integer> FreqMap = new HashMap<>();
        int Rabbitcount = 0;
        for(int ans : answers){
            if(!FreqMap.containsKey(ans) || FreqMap.get(ans) == 0){
                Rabbitcount = Rabbitcount + ans + 1;
                FreqMap.put(ans,ans);
            }else{
                FreqMap.put(ans,FreqMap.get(ans)-1);
            }
        }
        return Rabbitcount;
        
    }
}