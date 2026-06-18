class Solution {
    public int maxArea(int[] height) {
        int width,minheight=0,volume;
        int leftpt = 0;
        int rightpt = height.length - 1;
        int maxvol = 0;
        while(leftpt<rightpt){
            minheight = 0;
            width = rightpt - leftpt;
            if(height[leftpt] < height[rightpt]){
                minheight = height[leftpt];
                leftpt+=1;
            }else{
                minheight = height[rightpt];
                rightpt-=1;
            }
            volume = width * minheight;
            if(volume>maxvol){
                maxvol = volume;
            }
        }
        return maxvol;
    }
}
