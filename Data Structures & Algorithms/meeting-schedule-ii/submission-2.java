/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {

        Collections.sort(intervals, (a,b)->Integer.compare(a.end,b.end));

        PriorityQueue<Interval> pq = new PriorityQueue<>((a,b)->
            Integer.compare(a.start, b.start)
        );
        for(Interval i:intervals)pq.add(i);

        int ans= 0;

        while(!pq.isEmpty()){
            ans++;

            Interval i = pq.poll();

            List<Interval> temp = new ArrayList<>();
            while(!pq.isEmpty()){

                Interval top = pq.poll();
                if(top.start >= i.end){
                    i = top;
                }
                else{
                    temp.add(top);
                }

            }
            if(!temp.isEmpty())pq.addAll(temp);
        }
        return ans;



        //seems like a priority queue problem

    }
}
