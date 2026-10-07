class Solution {
    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        Set<Integer> set = new TreeSet<>();
        for(int bulb : bulbs){
            if(set.contains(bulb)){
                set.remove(bulb);
            }else{
                set.add(bulb);
            }
        }
        List<Integer> result = new ArrayList<>(set);
        return result;
    }
}