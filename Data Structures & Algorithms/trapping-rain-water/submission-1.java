class Solution {
    public int trap(int[] height) {

        int n = height.length;
        int[] rightMax = new int[n];

        int mx = 0;
        for (int i = n - 1; i >= 0; i--) {
            rightMax[i] = mx;
            mx = Math.max(mx, height[i]);
        }

        int leftMax = 0;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int water = Math.max(Math.min(leftMax, rightMax[i]) - height[i], 0);

            ans += water;
            leftMax = Math.max(leftMax, height[i]);
        }

        return ans;
    }
}
