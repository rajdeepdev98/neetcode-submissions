class Solution {
    public int largestRectangleArea(int[] heights) {


        int n = heights.length;

        
        int []leftNextSmaller = new int[n];
        int []rightNextSmaller = new int[n];

        Arrays.fill(leftNextSmaller, -1);
        Arrays.fill(rightNextSmaller, n);


        Deque<Integer>stack = new ArrayDeque<>();

        for(int i = 0;i<n;i++){


            int val = heights[i];

            while(!stack.isEmpty() && heights[stack.peek()]> val){
                int pos = stack.pop();
                rightNextSmaller[pos] = i;
                if(!stack.isEmpty())leftNextSmaller[pos] = stack.peek();
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){


            int pos = stack.pop();
            if(!stack.isEmpty())leftNextSmaller[pos]=stack.peek();
        }


        // stack.clear();

        // for(int i = n-1;i>=0;i--){

        //     int val = heights[i];
        //     while(!stack.isEmpty() && heights[stack.peek()]> val){

        //         leftNextSmaller[stack.pop()] = i;
        //     }
        //     stack.push(i);

        // }

        int ans = 0;

        for(int i = 0;i<n;i++){

            int l = leftNextSmaller[i];
            int r = rightNextSmaller[i];

            ans = Math.max(ans, (r-l-1)*heights[i]);
        }

        return ans;

        
    }
}
