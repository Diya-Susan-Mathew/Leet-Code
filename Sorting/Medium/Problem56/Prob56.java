class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length <=1){
            return intervals;
        }
        ArrayList<int[]> merged = new ArrayList<>();
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));
        int[] currentInterval = intervals[0];
        merged.add(currentInterval);
        for(int interval[] : intervals){
            int currentEnd = currentInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            if(currentEnd >= nextStart){
                currentInterval[1] = Math.max(nextEnd,currentEnd);
            }else{
                currentInterval = interval;
                merged.add(currentInterval);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}