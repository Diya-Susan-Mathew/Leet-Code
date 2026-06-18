package Problem349;
/* 
349 - Intersection of Arrays
//Problem Name - Intersection of Arrays
//Pattern Used : Hashset
Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.
Example 1:
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
*/
import java.util.HashSet;
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        for(int i=0;i<nums1.length;i++){ 
            int num = nums1[i];
            set.add(num);
        }
        for(int i=0;i<nums2.length;i++){
            int num = nums2[i];
            if(set.contains(num)){
                set2.add(num);
            }
        }
        int nums[] = new int[set2.size()];
        int i=0;
        for(int num : set2){
            nums[i] = num;
            i++;
        }
        return nums;

    }
}