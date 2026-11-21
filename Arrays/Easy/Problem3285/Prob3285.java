class Solution {
    public List<Integer> stableMountains(int[] height, int threshold) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<height.length;i++){
            if(i == height.length - 1){
                break;
            }
            else if(height[i] > threshold &&(height[i+1]<threshold || height[i+1] >= threshold)){
                list.add(i+1);
            }
        }
        return list;
    }
}