class Solution {
    class Pair implements Comparable<Pair>{

        int num;
        int freq;

        Pair(int num, int freq){

            this.num = num;
            this.freq = freq;

        }

        public int compareTo(Pair p2){

            return Integer.compare(p2.freq, this.freq);
        }

    }
    public int[] topKFrequent(int[] nums, int k) {



        Map<Integer, Integer> map = new HashMap<>();

        int n = nums.length;

        for(int i = 0;i<n;i++){

            int val = nums[i];
            map.merge(val , 1, Integer::sum );
        }

        PriorityQueue<Pair>pq = new PriorityQueue<>();

        for(Map.Entry<Integer,Integer> entry: map.entrySet()){

            pq.add(new Pair(entry.getKey(), entry.getValue()));
        }

        int []ans = new int[k];

        for(int i = 0;i<k;i++){

            Pair p = pq.poll();
            ans[i] = p.num;
        }
        return ans;
        
    }
}
