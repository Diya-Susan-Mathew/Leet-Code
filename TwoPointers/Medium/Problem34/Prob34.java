// Using Two pointer method
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] index = new int[2];
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            if(nums[left]<target){
                left ++;
            }else if(nums[right]>target){
                right--;
            }else if((nums[right]== target) && (nums[left] == target)){
                index[0] = left;
                index[1] = right;
                return index;
            }
        }
        return new int[]{-1,-1};
    }
}


// Using Binary Search
class Solution {
    public int[] searchRange(int[] nums, int target) { 
        int first=search(nums,target,true);
        int last=search(nums,target,false);
        int[] arr=new int[2];
        arr[0]=first;
        arr[1]=last;
        return arr;


    }
    static int search(int[] arr,int target,boolean res){
        int start = 0;
        int end = arr.length - 1;
        int ans = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if(arr[mid]==target)
            {
                if(res){
                    ans=mid;
                    end=mid-1;

                }
                else {
                    ans = mid;
                    start = mid + 1;
                }
            }
            else if (arr[mid] < target) {
                start = mid + 1;

            } else
                end = mid - 1;
        }
        return ans;
    }

}