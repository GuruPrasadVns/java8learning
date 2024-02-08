package com.utility;

import com.interfaces.BufferedReaderInterface;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileUtility {

    public static String FILE_LOCATION = "C:\\Users\\prasag1\\OneDrive - Boston Scientific\\Documents\\Javaws\\java8learning\\src\\main\\java\\com\\utility\\data.txt";

    public static String processFile() throws IOException{
        try(BufferedReader br = new BufferedReader(new FileReader("data.txt"))){
                return br.readLine();
        }
    }

    public static String processFileDynamically(BufferedReaderInterface bufferedReaderInterface) throws IOException{
        try(BufferedReader br = new BufferedReader(new FileReader(FILE_LOCATION))){
            return bufferedReaderInterface.processFileDynamically(br);
        }
    }
}
