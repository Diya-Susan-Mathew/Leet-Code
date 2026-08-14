class Solution {
    public int totalFruit(int[] fruits) {
        int left = 0;
        int maxLength = Integer.MIN_VALUE;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int right = 0;right < fruits.length;right++){
            map.put(fruits[right],map.getOrDefault(fruits,0)+1);
            while(map.size() > 2){
                int fruitCount = map.get(fruits[left]);
                if(fruitCount == 1){
                    map.remove(fruits[left]);
                }else{
                    map.put(fruits[left],fruitCount-1);
                }
                left++;
            }
            maxLength = Math.max(maxLength,right-left+1);   
        }
        return maxLength;
    }
}