class Solution {
    public int hammingDistance(int x, int y) {
        int xor_result = x ^ y;
        int hammingDist = 0;
        while(xor_result > 0){
            xor_result = xor_result & (xor_result-1);
            hammingDist++;
        }
        return hammingDist;
    }
}