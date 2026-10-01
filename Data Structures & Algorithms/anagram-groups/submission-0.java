class Solution {

    class StringPair implements Comparable<StringPair>{

        String s;
        int pos;
        StringPair(String s, int pos){

            this.s = s;
            this.pos = pos;
        }
        @Override
        public int compareTo(StringPair sp2){

            if(this.s.equals(sp2)){

                return Integer.compare(this.pos, sp2.pos);
            }
            else return this.s.compareTo(sp2.s);
        }
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        

        List<List<String>>ans = new ArrayList<>();


        List<StringPair>list = new ArrayList<>();

        int n = strs.length;

        for(int i = 0;i<n;i++){

            char []sArray = strs[i].toCharArray();

            Arrays.sort(sArray);

            String s = new String(sArray);

            list.add(new StringPair(s, i));
        }

        Collections.sort(list);

        List<String>current = new ArrayList<>();
        current.add(strs[list.get(0).pos]);

        for(int i = 1;i<n;i++){

            StringPair sp = list.get(i);
            if(sp.s.equals(list.get(i-1).s)){

                current.add(strs[sp.pos]);
            }
            else{
                if(!current.isEmpty()){

                    ans.add(current);
                    current = new ArrayList<>();
                    current.add(strs[sp.pos]);
                }
            }
        }

        if(!current.isEmpty())ans.add(current);

        return ans;



       
    }
}
