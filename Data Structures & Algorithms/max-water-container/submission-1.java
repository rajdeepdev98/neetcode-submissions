class Solution {
    public int maxArea(int[] heights) {


        int n = heights.length;

        int l = 0,r = n-1;
        int ans = 0;
        
        while(l<r){

            int curArea = Math.min(heights[l],heights[r])*(r-l);
            ans = Math.max(ans, curArea);


            if(heights[l]< heights[r]){
                l++;
            }
            else if(heights[l] > heights[r]) r--;
            else{
                l++;
                r--;
            }

        }
        return ans;
        


    }
}
