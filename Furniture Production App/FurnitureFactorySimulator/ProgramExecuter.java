package FurnitureFactorySimulator;
import java.io.FileNotFoundException;
import java.util.*;

import FileIO.ArrayStorage;
import FileIO.FileIO;
public class ProgramExecuter {
	public ProgramExecuter() throws FileNotFoundException{
		printOnScreen();
	}
	private void printOnScreen() throws FileNotFoundException {
		FileIO fileIO = new FileIO("C:\\Users\\Gaming PC\\Desktop\\HW3\\");
		Stack x = (Stack)fileIO.getArray("furniture1","stack");
		while (!x.empty()){
 			for (String i:(String[])x.pop()){
				System.out.println(i);
			}
		}
	}
}
