package InputOutput;
import java.io.*;

public class FileIO {
	private	String line;
	private int arrayCapacity;

	public FileIO(){
		this.arrayCapacity = 100;
	}
	
	public String[] readCsvFile(String path) {
		String[] vehicles=new String[arrayCapacity];
		try {
			int index = 0;
			BufferedReader br=new BufferedReader(new FileReader("HW2_SoldVehicles.csv"));

			while((this.line = br.readLine()) != null){
				vehicles[index] = this.line;
				index++;
			}
			br.close();

		} catch (FileNotFoundException e) {
			System.out.println("This file is not found.");
			System.exit(0);
		} catch (IOException e){
			System.out.println("File IO Error!");
			System.exit(0);
		}

		return vehicles;
	}
}