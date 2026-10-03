class MinStack {

    int []arr;
    int n;
    int size;
    int minPos;
    List<Integer>list;


    public MinStack() {

        this.n = 10005; 
        this.arr = new int[n];
        this.size = 0;
        this.minPos = -1;
        list = new ArrayList<>();

    }

    private void expandArray(){

        int[]temp = new int[2*n];
        for(int i = 0;i<n;i++){

                temp[i]=arr[i];
        }
        arr = temp;
        n = 2*n;

    }
    
    public void push(int val) {
        
        if(this.size == n){

            expandArray();
            
        }
        this.arr[size] = val;
        size++;
        if(list.isEmpty())list.add(size-1);
        else{

            if(arr[list.get(list.size()-1)]> val){

                list.add(size-1);
            }
        }
    }
    
    public void pop() {
        
        int val = arr[size-1];
        size --;
        if(size == list.get(list.size()-1))list.remove(list.size()-1);
    }
    
    public int top() {

        return this.arr[size-1];
        
    }
    
    public int getMin() {

        return arr[this.list.get(list.size()-1)];
        
    }
}

