package DocumentBuilderTest;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 */
public class CreateFile {

    public static void main(String[] args) {
        File file = new File("src/main/resources/extreme/pom.xml");
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(file);
            printWriter.write("\n");printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (printWriter != null) {
                printWriter.close();
            }
        }
    }
}
