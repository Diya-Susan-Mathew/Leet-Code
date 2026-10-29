class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i] > max){
                max = nums[i];
            }
            if(nums[i] < min){
                min = nums[i];
            }
        }
        ArrayList<Integer> list1 = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            list1.add(nums[i]);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=min;i<=max;i++){
            if(!list1.contains(i)){
                list.add(i);
            }
        }
        return list;
    }
}