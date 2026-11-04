class Solution {
    public int minElement(int[] nums) {
        int minElement = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            int elem = nums[i];
            int sum = findSum(elem);
            minElement = Math.min(sum,minElement);
        }
        return minElement;
    }
    public int findSum(int eleme){
        int sum1 = 0;
        while(eleme != 0){
            int digit = eleme % 10;
            sum1 += digit;
            eleme = eleme/10;
        }
        return sum1;
    }
}