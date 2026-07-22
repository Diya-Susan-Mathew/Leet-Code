class Solution {
    Integer[] memo;
    public int rob(int[] nums) {
        memo = new Integer[nums.length];
        return checkHouse(nums,0);

        
    }
    private int checkHouse(int[] nums,int i){
        if(i >= nums.length){
            return 0;
        }
        if(memo[i] != null){
            return memo[i];
        }
        int robit  = nums[i] + checkHouse(nums,i+2);
        int skipit = checkHouse(nums,i+1);
        memo[i] = Math.max(robit,skipit);
        return memo[i];
    }
}