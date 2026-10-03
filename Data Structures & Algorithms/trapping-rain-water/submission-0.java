class Solution {
    public int trap(int[] height) {

        int n = height.length;

        int []leftMax = new int[n];
        int []rightMax = new int [n];

        int mx = 0;
        for(int i = 0;i<n;i++){

            leftMax[i] = mx;
            mx = Math.max(mx, height[i]);

        }

        mx = 0;
        for(int i = n-1;i>=0;i--){

            rightMax[i] = mx;
            mx = Math.max(mx, height[i]);
        }

        int ans = 0;

        for(int i =0;i<n;i++){
            int val = Math.max(Math.min(leftMax[i], rightMax[i])-height[i], 0);
            // System.out.println("val = "+val);
            ans+=val;
        }
        return ans;


        
    }
}
