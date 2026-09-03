class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
                map.put(num,map.getOrDefault(num,0)+1);
        }
        for(Integer key : map.keySet()){
            int num = map.get(key);
            if(num == 2){
                result.add(key);
            }
        }
        return result;
    }
}