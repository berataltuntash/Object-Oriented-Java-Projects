package FileReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileIO {
    private String line;
    private int arrCapacity = 5000;

    public String[] readCsv(String path) throws IOException, FileNotFoundException{

    	// General CSV reader, returns an array of all the lines in the given csv path
        BufferedReader br = new BufferedReader(new FileReader(path));
        String[] readFiles = new String[arrCapacity];
        int count = 0;

        this.line = br.readLine();

        while((this.line = br.readLine()) != null){
            readFiles[count] = this.line;
            count++;
        }

        br.close();
        return readFiles;
    }    
}
