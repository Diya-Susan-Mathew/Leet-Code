class Solution {
    public int[] concatWithReverse(int[] nums) {
        int[] result = new int[2*nums.length];
        for(int i=0;i<nums.length;i++){
            result[i] = nums[i];
        }
        int j = nums.length-1;
        for(int i = nums.length;i<result.length;i++){
            result[i] = nums[j];
            j--;
        }
        return result;
    }
}