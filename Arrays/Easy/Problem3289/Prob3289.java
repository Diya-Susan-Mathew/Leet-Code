class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int j=0;
        int[] arr = new int[2];
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(!set.contains(nums[i])){
                set.add(nums[i]);
            }else{
                arr[j] = nums[i];
                j++;
            }
        }
        return arr;
    }
}