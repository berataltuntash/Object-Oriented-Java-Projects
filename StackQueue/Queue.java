import java.util.Iterator;

public class Queue<Item> {
	private static int front, rear, capacity, count; 
    @SuppressWarnings("unused")
	private Item queue[]; 
   
    @SuppressWarnings("unchecked")
	Queue(int size) { 
        front = rear = count = 0; 
        capacity = size; 
        queue = (Item[]) new Object[capacity];
    } 
    public Item dequeue()
    {
        if (isEmpty())
        {
            System.out.println("Cant dequeue cuz queue empty");
        }
 
        Item x = queue[front];
  
        front = (front + 1) % capacity;
 
        return x;
    }
 
    public void enqueue(Item item)
    {
        if (isFull())
        {
            System.out.println("Queue full");
        } 
        rear = (rear + 1) % capacity;
        queue[rear] = item;
        count++;
    }
 
    public Item peek()
    {
        if (isEmpty())
        {
            System.out.println("Underflow\nProgram Terminated");
            System.exit(-1);
        }
        return queue[front];
    }
 
    public int size() {
        return count;
    }
 
    public boolean isEmpty() {
        return (size() == 0);
    }
 
    public boolean isFull() {
        return (size() == capacity);
    }
   
   
    public void display() 
    { 
        int i; 
        if (isEmpty()) { 
            System.out.printf("Queue is Empty\n"); 
            return; 
        } 
        for (i = front; i < rear; i++  ) {
			System.out.println(queue[i]);
			
		}
        return; 
    } 
  
}
