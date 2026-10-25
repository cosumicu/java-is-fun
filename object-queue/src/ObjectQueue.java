import java.sql.SQLOutput;
import java.util.Collections;
import java.util.PriorityQueue;

public class ObjectQueue {

    private Object[] queue; // an object array for accepting both numerical and string values
    private int rear; // last element
    private int front; // first element
    private int size; // max size of the array

    // constructor, accepts max size
    public ObjectQueue(int size) {
        this.size = size;
        queue = new Object[this.size];
        rear = -1;
        front = 0;
    }

    //insert method of queue
    public void enQueue(Object item) {
        if (rear == size - 1)
            throw new RuntimeException("Queue is full"); // throws an exception if rear == size - 1

        rear++; // increment for shifting
        queue[rear] = item;
    }

    // remove method of queue
    public Object deQueue() {
        if (isEmpty())
            throw new RuntimeException("Queue is empty"); // throws an exception if the queue is empty

        Object item = queue[front];
        front++; // increment for shifting
        return item;
    }

    // checks if the queue is empty
    public boolean isEmpty() {
        return (front == rear + 1);
    }

    // displays the first element of the queue
    public void displayFirstElement() {
        System.out.println(queue[front]);
    }

    //displays the last element added to the queue
    public void displayLastElement() {
        System.out.println(queue[rear]);
    }

    //displays all the elements in the queue from right which is the first, to left which is the last added
    public void displayElements() {
        System.out.print("Elements: [ ");
        for (int i = rear; i >= front; i--) {
            System.out.print(queue[i] + " ");
        }
        System.out.print("]");
        System.out.println();
    }

    public void setQueueElement(Object value, int index) {
        this.queue[index] = value;
    }

    public Object getQueueElement(int index) {
        return this.queue[index];
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int countNullValues() {
        int count = 0;
        for(int i = 0; i < queue.length; i++) {
            if(queue[i] == null){
                count++;
            }
        }
        return count;
    }
}