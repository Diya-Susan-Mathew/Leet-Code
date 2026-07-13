class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if(numRows == 0){
            return result;
        }
        List<Integer> firstrow = new ArrayList<>();
        firstrow.add(1);
        result.add(firstrow);
        if(numRows == 1){
            return result;
        }
        for(int i=1;i<numRows;i++){
            List<Integer> prevRow = result.get(i-1);
            List<Integer> currentRow = new ArrayList<>();
            currentRow.add(1);
            for(int j=0;j<i-1;j++){
                currentRow.add(prevRow.get(j) + prevRow.get(j+1));
            }
            currentRow.add(1);
            result.add(currentRow);
        }
    return result;
    }
}