import java.util.Arrays;

public class Stack<Item> {
	    private Item arr[];
	    private int top;
	    private int capacity;
	 
	    @SuppressWarnings("unchecked")
		Stack(int size)
	    {
	        arr = (Item[]) new Object[size];
	        capacity = size;
	        top = -1;
	    }

	    public void push(Item newItem)
	    {
	        if (isFull())
	        {
	            System.out.println("Overflow\nProgram Terminated\n");
	            reSize();
	        }
	        top++;
	        arr[top] = newItem;
	    }
	 
	    public Item pop()
	    {
	        if (isEmpty())
	        {
	            System.out.println("Stack Is Empty");
	            System.exit(-1);
	        }
	 
	        return arr[top--];
	    }
	 
	    public Item peek()
	    {
	        if (!isEmpty()) {
	            return arr[top];
	        }
	        else {
	        	System.out.println("Stack Is Empty");
	        }
	 
	        return null;
	    }
	 
	    public int size() {
	        return top + 1;
	    }
	 
	    public boolean isEmpty() {
	        return top == -1;              
	    }
	 
	    public boolean isFull() {
	        return top == capacity - 1;    
	    }
	    public void reSize() {
	    	capacity *= 2;
	    	arr = Arrays.copyOf(arr, capacity);
	    }
}
