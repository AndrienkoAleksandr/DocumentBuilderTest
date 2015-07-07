package DocumentBuilderTest;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 *
 */
public class Application3 {
    public static final String POM_XML =
            "<project xmlns=\"http://maven.apache.org/POM/4.0.0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"&#xD;\n" +
            "  xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\">&#xD;\n" +
            "  <modelVersion>4.0.0</modelVersion>&#xD;\n" +
            "&#xD;\n" +
            "  <groupId>Spring</groupId>&#xD;\n" +
            "  <artifactId>Spring</artifactId>&#xD;\n" +
            "  <version>1.0-SNAPSHOT</version>&#xD;\n" +
            "  <packaging>jar</packaging>&#xD;\n" +
            "&#xD;\n" +
            "  <name>Spring</name>&#xD;\n" +
            "  <url>http://maven.apache.org</url>&#xD;\n" +
            "&#xD;\n" +
            "  <properties>&#xD;\n" +
            "    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>&#xD;\n" +
            "  </properties>&#xD;\n" +
            "&#xD;\n" +
            "  <dependencies>&#xD;\n" +
            "    <dependency>&#xD;\n" +
            "      <groupId>junit</groupId>&#xD;\n" +
            "      <artifactId>junit</artifactId>&#xD;\n" +
            "      <version>3.8.1</version>&#xD;\n" +
            "      <scope>test</scope>&#xD;\n" +
            "    </dependency>&#xD;\n" +
            "  </dependencies>&#xD;\n" +
            "</project>&#xD;\n";

    public static void main(String[] args) throws ParserConfigurationException {
        byte[] bytes = POM_XML.getBytes();

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = documentBuilderFactory.newDocumentBuilder();
        Document document = null;
        try {
            document = db.parse(new ByteArrayInputStream(bytes));
        } catch (SAXException | IOException e) {
            System.out.println(e.getMessage());
        }
        assert document != null;

        Element element = document.getDocumentElement();
        NodeList nodes = element.getChildNodes();

        for (int i = 0; i < nodes.getLength(); i++) {
            System.out.println(nodes.item(i).getNodeName() + " " + nodes.item(i).getTextContent());
        }

        System.out.println("@@@ " + element.getElementsByTagName("version").item(0).getTextContent());
    }
}
