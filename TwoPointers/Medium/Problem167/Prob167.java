class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int leftpt,rightpt;
        int nums[] = new int[2];
        leftpt = 0;
        rightpt = numbers.length-1;
        while(leftpt != rightpt){
            if(numbers[leftpt] + numbers[rightpt] > target){
                rightpt--;
            }
            else if(numbers[leftpt] + numbers[rightpt] < target){
                leftpt++;
            }else{
                nums[0] = leftpt+1;
                nums[1] = rightpt+1;
                return nums;
            }
        }
        return new int[0];
    }    
}