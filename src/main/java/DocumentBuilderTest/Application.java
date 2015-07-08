package DocumentBuilderTest;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
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
import static java.lang.System.arraycopy;

/**
 *
 */
public class Application {
    public static void main( String[] args ) throws ParserConfigurationException {
        byte[] bytes = null;
        try (FileChannel channel = (FileChannel)Files.newByteChannel(Paths.get("src/main/resources/pom.xml"))) {
            long size = channel.size();
            bytes = new byte[(int)size];
            System.out.println("size: " + size);

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

        byte[] testBytes = replaceAll(bytes, (byte)'\r', "&#xD;".getBytes(), rootStart(bytes));

        //ByteArrayInputStream byteStream = new ByteArrayInputStream(bytes);
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = documentBuilderFactory.newDocumentBuilder();
        Document document = null;
        try {
            //document = db.parse(byteStream);
            document = db.parse(new ByteArrayInputStream(testBytes));
        } catch (SAXException | IOException e) {
            System.out.println(e.getMessage());
        }
        assert document != null;

        Element element = document.getDocumentElement();
        NodeList nodes = element.getChildNodes();

        for (int i = 0; i < nodes.getLength(); i++) {
            System.out.println(nodes.item(i).getNodeName() + " " + nodes.item(i).getTextContent());
        }

        if (element.getElementsByTagName("version").item(0) != null) {
            System.out.println("@@@ " + element.getElementsByTagName("version").item(0).getTextContent());
        }
    }

    public static int rootStart(byte[] xml) {
        final byte[] open = {'<'};
        int pos = indexOf(xml, open, 0);
        while (xml[pos + 1] == '?' || xml[pos + 1] == '!') {
            if (xml[pos + 1] == '!' && xml[pos + 2] == '-' && xml[pos + 3] == '-') {
                pos = indexOf(xml, new byte[] {'-', '-', '>'}, pos + 1);
            }
            pos = indexOf(xml, open, pos + 1);
        }
        return pos;
    }

    public static int indexOf(byte[] src, byte[] target, int fromIdx) {
        final int to = src.length - target.length + 1;
        for (int i = fromIdx; i < to; i++) {
            if (src[i] == target[0]) {
                boolean equals = true;
                for (int j = 1, k = i + 1; j < target.length && equals; j++, k++) {
                    if (src[k] != target[j]) {
                        equals = false;
                    }
                }
                if (equals) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static byte[] replaceAll(byte[] src, byte target, byte[] replacement, int startFrom) {
        if (startFrom >= src.length) {
            throw new IndexOutOfBoundsException("Start from index is out of range");
        }
        int matches = 0;
        for (int i = startFrom; i < src.length; i++) {
            if (src[i] == target) {
                matches++;
            }
        }
        if (matches == 0) {
            return src;
        }
        final byte[] newSrc = new byte[src.length - matches + matches * replacement.length];
        arraycopy(src, 0, newSrc, 0, startFrom);
        for (int i = startFrom, j = startFrom; i < src.length; i++) {
            if (target != src[i]) {
                newSrc[j++] = src[i];
            } else {
                System.arraycopy(replacement, 0, newSrc, j, replacement.length);
                j += replacement.length;
            }
        }
        return newSrc;
    }
}
