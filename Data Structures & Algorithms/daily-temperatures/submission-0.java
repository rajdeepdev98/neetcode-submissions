class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        

        int n = temperatures.length;
        Deque<Integer>stack = new ArrayDeque<>();

        int []ans = new int[n];

        for(int i = 0;i<n;i++){

            int temp = temperatures[i];

            while(!stack.isEmpty() && temperatures[stack.peek()] < temp){

                int pos = stack.pop();
                ans[pos] = i - pos;
            }
            stack.push(i);
        }

        return ans;
        
        
    }
}
