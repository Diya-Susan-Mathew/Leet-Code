class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] answer = new int[n];
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && prices[i]<=prices[stack.peek()]){
                int poppedindex = stack.pop();
                answer[poppedindex] = prices[poppedindex] - prices[i];
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int poppedindex = stack.pop();
            answer[poppedindex] = prices[poppedindex];
        }
        return answer;
    }
}