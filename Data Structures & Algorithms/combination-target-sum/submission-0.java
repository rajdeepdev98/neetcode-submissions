class Solution {

    List<List<Integer>>ans;

    void backtrack(int[]nums, int pos, int rem, List<Integer>curr){


        if(rem == 0){

            ans.add(new ArrayList<>(curr));
            return;
        }
        if(rem<0)return;

        for(int i = pos;i<nums.length;i++){


            curr.add(nums[i]);

            backtrack(nums, i, rem-nums[i], curr);

            curr.remove(curr.size()-1);

        }

    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {

        


        ans = new ArrayList<>();

        backtrack(nums, 0, target, new ArrayList<>());

        return ans;


        
    }
}
