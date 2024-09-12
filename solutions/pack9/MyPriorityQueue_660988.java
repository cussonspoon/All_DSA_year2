package solutions.pack9;

public class MyPriorityQueue_660988 implements MyQueueInterface {
    MyMinHeap_660988 heap = new MyMinHeap_660988();

    @Override
    public void enqueue(int d){
        if (heap.isFull()){
            System.out.println("Heap is full");
        }
        else{
            heap.insert(d);
        }
    }

    @Override
    public int dequeue(){
        if (heap.isEmpty()){
            System.out.println("Heap is empty");
            return -1;
        }
        else{
            return heap.remove();
        }
    }

    @Override
    public int front(){
        return heap.peek();
    }

    @Override
    public boolean isFull(){
        return heap.isFull();
    }

    @Override
    public boolean isEmpty(){
        return heap.isEmpty();
    }

    public String toString(){
        return heap.toString();
    }
}
