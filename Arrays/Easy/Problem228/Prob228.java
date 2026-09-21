class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        int begin=0,end=0,i=0;
        while(i<nums.length){
            begin = i;
            while(i < nums.length-1 && nums[i] == nums[i+1]-1){
                i++;
            }
            end = i;
            if(nums[begin] == nums[end]){
                list.add(Integer.toString(nums[begin]));
            }else{
                list.add(nums[begin]+"->"+nums[end]);
            }
            i++;
        }
        return list;
    }
}