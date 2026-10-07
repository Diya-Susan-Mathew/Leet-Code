class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,(a,b)->Integer.compare(b[1],a[1]));
        int size = 0;
        int units = 0;
        int remsize = truckSize;
        for(int i=0;i<boxTypes.length;i++){
            if(remsize < boxTypes[i][0]){
                size += remsize;
                units = units + remsize * boxTypes[i][1];
                break;
            }else{
                size += boxTypes[i][0];
                units = units + (boxTypes[i][0] * boxTypes[i][1]);
                remsize = truckSize - size;
            }
        }
        return units;
    }
}