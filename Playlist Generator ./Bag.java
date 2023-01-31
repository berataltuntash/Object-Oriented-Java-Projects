

public class Bag {
	private Object[] array = new Object[1];
	private int size = 0;
	private Object[] playlist = new Object[1];
	private int lenght = 0;
	private double totalMin;
	
	public void add(Object s) {
		if (s != null) {
			if (array.length == size){
				Object[] newArray = new Object[array.length*2];
				System.arraycopy(array, 0, newArray, 0, size);
				newArray[size] = s;
				size++;
				array = newArray;
			}
			else if(array.length > size) {
				array[size] = s; 
				size++;
			}
			
		}
	}
	public Object[] getArray() {
		return array;
	}
	
	public int size() {
		return size;
		
	}
	
			
		
	

	
}
