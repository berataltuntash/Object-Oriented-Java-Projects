package FileIO;
import java.util.Stack;
import java.util.Queue;
public class ArrayStorage {
	private Stack<String> stack;
	private Queue<String> queue;
	private int size;
	ArrayStorage(String[] array){
		size = array.length;
	}
	public Stack<String> getStack() {
		return stack;
	}
	public void add(String[] newArray,String a) {
		if (a == "stack"){
			stack.add(a);
		}else{
			queue.add(a);
		}
	}
	public int getSize(String a) {
		int size = 0;
		if (a == "stack"){
			size = stack.size();
		}else{
			size = queue.size();
		}
		return size;
	}
}
