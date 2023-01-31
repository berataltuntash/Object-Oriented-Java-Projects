package FileIO;

import java.io.BufferedReader;
//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class FileIO {
	String furniture1;
	String furniture2;
	String materials1;
	String materials2;
	String vendor;
	String furnitureParts;
	String rawMaterial;
	public FileIO(String folder){
		addFolderAdresses(folder);
	}
	private void addFolderAdresses(String folder) {
		furniture1 = folder + "Manufacturer1Furnitures.csv";
		furniture2 = folder + "Manufacturer2Furnitures.csv";
		materials1 = folder + "Manufacturer1Materials.csv";
		materials2 = folder + "Manufacturer2Materials.csv";
		vendor = folder + "VendorPossessions.csv";
		furnitureParts = folder + "FurnitureParts.csv";
		rawMaterial = folder + "RawMaterialProperties.csv";
	}
	public Object getData(String fileType,String dataType){
		Object a = null;
		switch(fileType) {
		case "furniture1":
			a = prepareArray(furniture1,dataType);
			break;
		case "furniture2":
			a = prepareArray(furniture2,dataType);
			break;
		case "materials1":
			a = prepareArray(materials1,dataType);
			break;
		case "materials2":
			a = prepareArray(materials2,dataType);
			break;
		case "vendor":
			a = prepareArray(vendor,dataType);
			break;
		case "furnitureParts":
			a = prepareArray(furnitureParts,dataType);
			break;
		case "rawMaterial":
			a = prepareArray(rawMaterial,dataType);
			break;
		}
		return a;
		
	}
	/*private String[][] prepareArray(String fileType){
		String[] a = null;
		String[][] b = null;
		int leni = 0;
		int lenj = 0;
		int counti = 0;
		int countj = 0;
		for (String i:a = Reader(fileType)) {
			switch (count) {
			case 0:
				String[] firstDay = new EnhancedStringTokenizer(i,",").getTokens();
				break;
			case 1:
				String[] secondDay = new EnhancedStringTokenizer(i,",").getTokens();
			}
			int maxSoldDayLength = 0;
			if (b==null) {
				int maxSoldDayLength = 0;
				int[] daysLength = {firstDay.length,secondDay.length,thirdDay.length};
				for (int dayLength: daysLength) {
					if (dayLength > maxSoldDayLength) {
						maxSoldDayLength = dayLength;
					}
				}//here java doesn't allow us to use switch-case. 
				if (maxSoldDayLength == firstDay.length) {
					maxSoldDay = firstDay;
					System.out.println("1");
				} else if (maxSoldDayLength == secondDay.length) {
					maxSoldDay = secondDay;
					System.out.println("2");
				}else{
					System.out.println("3");
					maxSoldDay = thirdDay;
				}
				leni = a.length;
				b = new String[leni][maxSoldDayLength];
			}
			countj = 0;
			for (String y: ) {
				b[counti][countj] = y;
				countj++;
			}
			counti++;
		}
		return b;
	}*/
	private Collection prepareArray(String fileType,String dataType) {
		Collection a = null;
		if (dataType == "stack"){
			a = new Stack<String[]>();
		}else{
			a = new LinkedList<String[]>();
		}
		for (String i: Reader(fileType)) {
			a.add(new EnhancedStringTokenizer(i,",").getTokens()); 
		}
		return a;
		
	} 
	private String[] Reader(String adress){
		BufferedReader objReader = null;
		String[] a = new String[0];
  		try {
  			objReader = new BufferedReader(new FileReader(adress));
			String x;
			while ((x = objReader.readLine()) != null) {
				String[] b = new String[a.length+1];
				for (int i= 0;i<a.length;i++) {
					b[i] = a[i];
				}
				b[a.length] = x;
				a = b;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  		/*for (String i:(a = (String[]) objReader.lines().toArray())) {
  			System.out.println(a.toString());
  		}*/
		  return a;
	}
}
