package DocumentBuilderTest;

import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import org.w3c.dom.Document;

/**
 *
 */
public class Application {
    public static void main( String[] args ) throws ParserConfigurationException {
        byte[] bytes = null;
        try (FileChannel channel = (FileChannel)Files.newByteChannel(Paths.get("src/main/resources/pom.xml"))) {
            long size = channel.size();
            bytes = new byte[(int)size];
            System.out.println("size: " + size + "\n");

            MappedByteBuffer mbb = channel.map(FileChannel.MapMode.READ_ONLY, 0, size);
            for (long i = 0; i < size; i++) {
                byte b = mbb.get();
                bytes[(int)i] = b;
                System.out.print((char)b);
            }
        } catch (InvalidPathException e) {
            System.out.println("Path error");
        } catch (IOException e) {
            System.out.println("IOException");
        }

        if (bytes == null) {
            return;
        }

        ByteArrayInputStream byteStream = new ByteArrayInputStream(bytes);
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = documentBuilderFactory.newDocumentBuilder();
        Document document = null;
        try {
            document = db.parse(byteStream);
        } catch (SAXException | IOException e) {
            System.out.println(e.getMessage());
        }
        assert document != null;
        System.err.println(document.getTextContent());
    }
}
