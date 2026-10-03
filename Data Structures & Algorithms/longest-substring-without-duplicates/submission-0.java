class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        Map<Character,Integer>map = new HashMap<>();
        int n = s.length();
        int ans = 0;
        int l = -1;

        for(int i = 0;i<n;i++){

            char c = s.charAt(i);
            if(!map.containsKey(c)){

                ans = Math.max(ans, i - l);
            }
            else{

                int pos = map.get(c);
                for(int j = l+1;j<=pos;j++){

                    map.remove(s.charAt(j));
                }
                l = pos;
            }

            map.put(c,i);

        }
        return ans;

    }
}
