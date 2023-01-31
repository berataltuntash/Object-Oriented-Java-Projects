package InputOutput;

import java.util.Scanner;

public class KeyboardIO {
    private String outputLine;

    public KeyboardIO(){
        this.outputLine = "********************\n"
				+ "Please press\n"
				+ "1 to see all sold vehicles list\n"
				+ "2 to see sold sedan list\n"
				+ "3 to see soldhatchbacklist\n"
				+ "4 to see sold minivan list\n"
				+ "5 to see sold pickup trucklist\n"
				+ "6 to see sold bicycle list\n"
				+ "To exit from program please press 'q'\n"
				+ "********************\n";
    }

    // This version of the constructor is used to put this class as a more general purpose class, but will not be used during this project
    public KeyboardIO(String _outputLine){
        this.outputLine = _outputLine;
    }
    
    //Reads user Input from keyboard
    public String readUserInput(){
    	System.out.println(this.outputLine);
        Scanner keyboardScanner = new Scanner(System.in);
        
        String returnString = keyboardScanner.next();
        
        return returnString;
    }


    // This version of readUserInput is used to put this class as a more general purpose class, but will not be used during this project.
    public static String readUserInput(String _outputString){
        Scanner keyboScanner = new Scanner(System.in);
        System.out.println(_outputString);

        String returnString = keyboScanner.nextLine();
        keyboScanner.close();

        return returnString;
    }
}

