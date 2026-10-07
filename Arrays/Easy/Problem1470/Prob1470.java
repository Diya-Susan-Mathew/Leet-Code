class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[nums.length];
        int j = 0;
        for(int i=0;i<nums.length;i=i+2){
            result[i] = nums[j];
            j++;
        }
        int k = 0;
        for(int i=1;i<nums.length;i=i+2){
            result[i] = nums[n+k];
            k++;
        }
        return result;
    }
}