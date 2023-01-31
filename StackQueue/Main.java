import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		// Create sorted product stacks
		// tuna corn pudding noodle
		Stack<Object> tunaStack = new Stack<Object>(30);
		Stack<Object> cornStack = new Stack<Object>(30);
		Stack<Object> puddingStack = new Stack<Object>(30);
		Stack<Object> noodleStack = new Stack<Object>(30);
		
		Queue<String> orderQueue = new Queue<String>(60);
		
		String[] cargoList = new String[30];
		
		String month = null;
		int year =2022;
		
		for( int i = 0; i < 4; i++) {
			for(int j = 0; j < 30; j++) {
				
				String tuna = "Net Weight 75 GR drained weight 50 GR ingredients tuna, sunflower oil, salt ";
				String corn = "net weight 220 GR drained weight 132 GR production country turkey ";
				String pudding = "net weight 120 GR flavo banana ";
				String noodle = "net weight 120 GR simmer duration 3 ";
				year = 0;
				year = 2022 + (j / 12);
				int k = j % 12;
				switch (k) {
				case 0: {
					month = "July";
					break;
				}
				case 1: {
					month = "August";
					break;
				}
				case 2: {
					month = "September";
					break;
				}
				case 3: {
					month = "October";
					break;
				}
				case 4: {
					month = "November";
					break;
				}
				case 5: {
					month = "December";
					break;
				}
				case 6: {
					month = "January";
					break;
				}
				case 7: {
					month = "February";
					break;
				}
				case 8: {
					month = "March";
					break;
				}
				case 9: {
					month = "April";
					break;
				}
				case 10: {
					month = "May";
					break;
				}
				case 11: {
					month = "June";
					break;
				}}
				
				switch (i) {
				case 0: {
					tuna += month + Integer.toString(year);
					tunaStack.push(tuna);
					break;
				}
				case 1 :{
					corn += month + Integer.toString(year);
					cornStack.push(corn);
				}
				case 2 :{
					pudding += month + Integer.toString(year);
					puddingStack.push(pudding);
				}
				case 3 :{
					noodle += month + Integer.toString(year);
					noodleStack.push(noodle);
				}
			}
		}
			
		Scanner sc = new Scanner(new File("orders.csv"));
		sc.useDelimiter("\n");
		while(sc.hasNext()) {
			orderQueue.enqueue(sc.next().toString());
		}
		for(int i1 = 0; i1 < orderQueue.size(); i1++) {
			String item = orderQueue.dequeue();
			String[] itemArr = item.split(",");
			System.out.println(item);
			String cargo = "";
			for(int j = 2; j < itemArr.length; j++ ) {
				switch (itemArr[j]) {
				case "corn": {
					cargo += cornStack.pop();
					break;
				}
				case "pudding": {
					cargo += puddingStack.pop();
					break;
				}
				case "noodle": {
					cargo += noodleStack.pop();
					break;
				}
				case "tuna": {
					cargo += tunaStack.pop();
					break;
				}
				
				}
			}
			cargoList[i1] = cargo;
		}
		
		
		// for each product in order pop from the product stack
		
		// cargo packet list, sorted by ID
		
		// Print every product stack before & after orders
		
		// Print order queue
		
		// Print cargo list
		
		// Print expiration date of cargo list ID 25
		
		// Remove cargo packet ID 20, print cargo list again
		
		
	}
}}
