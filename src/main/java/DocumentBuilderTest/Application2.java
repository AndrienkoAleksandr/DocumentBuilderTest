/*******************************************************************************
 * Copyright (c) 2012-2015 Codenvy, S.A.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * <p/>
 * Contributors:
 * Codenvy, S.A. - initial API and implementation
 *******************************************************************************/
package DocumentBuilderTest;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.FileInputStream;

/**
 */
public class Application2 {
    public static void main(String[] args) {

        // create a new DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            // use the factory to create a documentbuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // create a new document from input stream
            FileInputStream fis = new FileInputStream("src/main/resources/pom.xml");
            Document doc = builder.parse(fis);

            // get the first element
            Element element = doc.getDocumentElement();

            // get all child nodes
            NodeList nodes = element.getChildNodes();

            // print the text content of each child
            for (int i = 0; i < nodes.getLength(); i++) {
                System.out.println(nodes.item(i).getNodeName() + " " + nodes.item(i).getTextContent());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
