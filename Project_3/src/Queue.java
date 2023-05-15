public class Queue {
    public int front;
    public int rear;
    public int size;
    public Object[] queueArray;

    public Queue(int size){
        this.size = size;
        this.front = 0;
        this.rear = 0;
        this.queueArray = new Object[size];
        for (int i = 0; i < size; i++){
            queueArray[i] = null;
        }
    }

    public boolean isEmpty(){
        return this.front == this.rear;
    }

    public boolean isFull(){
        return nextRear() == front;
    }
    private int nextRear(){
//        int nextRear = this.rear;
//        System.out.println("nextRear: " + nextRear);
        if (this.rear == this.size-1) return 0;
        return this.rear + 1;
    }
    public void enqueue(Object element){
        if (isFull()){
            System.out.println("Queue is full");
            return;
        }
        this.queueArray[this.rear] = element;
        this.rear = nextRear();
    }
    private int nextFront(){
//        int nextFront = this.front;
//        System.out.println("nextFront: " + nextFront);
        if (this.front == this.size -1) return 0;
        return this.front + 1;
    }
    public Object dequeue(){
        if (isEmpty()){
            System.out.println("Queue is empty");
            return null;
        }
        Object element = this.queueArray[this.front];
        this.queueArray[this.front] = null;
        this.front = nextFront();
        return element;
    }
    public void print(){
//        if (isEmpty()){
//            System.out.println("Queue is empty");
//            return;
//        }
        for(int i = 0; i < this.size; i++){
            System.out.print(this.queueArray[i] + " ");
            if (i == this.rear) System.out.print("R");
            if (i == this.front) System.out.print("F");
            System.out.println();
        }
        System.out.println();
    }

}

//class Main { //testing
//    public static void main(String[] args) {
//        Queue queue = new Queue(5);
//        queue.print();
//        queue.enqueue(1);
//        queue.print();
//        queue.enqueue(2);
//        queue.print();
//        queue.enqueue(3);
//        queue.print();
//        queue.dequeue();
//        queue.print();
//        queue.enqueue(4);
//        queue.print();
//        queue.enqueue(5);
////        queue.enqueue(6);
//        queue.print();
//        queue.dequeue();
//        queue.print();
//        queue.dequeue();
//        queue.print();
//        queue.enqueue(7);
//        queue.print();
//        queue.dequeue();
//        queue.print();
//        queue.dequeue();
//        queue.print();
//        queue.dequeue();
//        queue.print();
//        queue.enqueue(1);
//        queue.print();
//        queue.enqueue(2);
//        queue.print();
//        queue.enqueue(3);
//        queue.print();
//        queue.enqueue(4);
//        queue.print();
//        queue.dequeue();
//        queue.print();
//        queue.dequeue();
//        queue.print();
//        queue.dequeue();
//        queue.print();
//        queue.dequeue();
//        queue.print();
//    }
//}
