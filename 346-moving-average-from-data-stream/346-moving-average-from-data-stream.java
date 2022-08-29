class MovingAverage {
    int size;
    Queue<Integer>queue;
    public MovingAverage(int size) {
        this.size=size;
          queue = new LinkedList<>();
    }
    
    public double next(int val) {
        double result =0;
        queue.add(val);
        while(queue.size()>size)queue.poll();
        for(Integer item : queue){
            result = result+item;
        }
        return result/queue.size();
        
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */