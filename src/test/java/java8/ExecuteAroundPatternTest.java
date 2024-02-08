package java8;

import com.utility.FileUtility;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;

public class ExecuteAroundPatternTest {

    @Test
    public void readTwoLinesTest() throws IOException {
        String twoLines = FileUtility.processFileDynamically((BufferedReader br) -> br.readLine() + " " + br.readLine());
        System.out.println(twoLines);
    }

    @Test
    public void readFirstLine() throws IOException{
        String firstLine = FileUtility.processFileDynamically((BufferedReader br) -> br.readLine());
        System.out.println(firstLine);
    }
}
