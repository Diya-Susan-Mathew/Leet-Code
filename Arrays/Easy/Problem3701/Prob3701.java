class Solution {
    public int alternatingSum(int[] nums) {
        int sum = 0;
        for(int i=0;i<nums.length;i=i+2){
            sum+=nums[i];
        }
        for(int i =1;i<nums.length;i=i+2){
            sum-=nums[i];
        }
        return sum;
    }
}