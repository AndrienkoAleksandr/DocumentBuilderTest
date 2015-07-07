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

/**
 */
public class ComparePomXml {
    private static final String POM_ON_LINUX =
            "<project xmlns=\"http://maven.apache.org/POM/4.0.0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
            "  xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\">\n" +
            "  <modelVersion>4.0.0</modelVersion>\n" +
            "\n" +
            "  <groupId>W</groupId>\n" +
            "  <artifactId>W</artifactId>\n" +
            "  <version>1.0-SNAPSHOT</version>\n" +
            "  <packaging>jar</packaging>\n" +
            "\n" +
            "  <name>W</name>\n" +
            "  <url>http://maven.apache.org</url>\n" +
            "\n" +
            "  <properties>\n" +
            "    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>\n" +
            "  </properties>\n" +
            "\n" +
            "  <dependencies>\n" +
            "    <dependency>\n" +
            "      <groupId>junit</groupId>\n" +
            "      <artifactId>junit</artifactId>\n" +
            "      <version>3.8.1</version>\n" +
            "      <scope>test</scope>\n" +
            "    </dependency>\n" +
            "  </dependencies>\n" +
            "</project>\n";

    private static final String GET_POM_ON_LINUX_AFTER_REPLACE =
            "<project xmlns=\"http://maven.apache.org/POM/4.0.0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
            "  xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\">\n" +
            "  <modelVersion>4.0.0</modelVersion>\n" +
            "\n" +
            "  <groupId>W</groupId>\n" +
            "  <artifactId>W</artifactId>\n" +
            "  <version>1.0-SNAPSHOT</version>\n" +
            "  <packaging>jar</packaging>\n" +
            "\n" +
            "  <name>W</name>\n" +
            "  <url>http://maven.apache.org</url>\n" +
            "\n" +
            "  <properties>\n" +
            "    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>\n" +
            "  </properties>\n" +
            "\n" +
            "  <dependencies>\n" +
            "    <dependency>\n" +
            "      <groupId>junit</groupId>\n" +
            "      <artifactId>junit</artifactId>\n" +
            "      <version>3.8.1</version>\n" +
            "      <scope>test</scope>\n" +
            "    </dependency>\n" +
            "  </dependencies>\n" +
            "</project>\n";

    private static final String POM_ON_WINDOWS =
            "<project xmlns=\"http://maven.apache.org/POM/4.0.0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
            "  xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\">\n" +
            "  <modelVersion>4.0.0</modelVersion>\n" +
            "\n" +
            "  <groupId>G</groupId>\n" +
            "  <artifactId>G</artifactId>\n" +
            "  <version>1.0-SNAPSHOT</version>\n" +
            "  <packaging>jar</packaging>\n" +
            "\n" +
            "  <name>G</name>\n" +
            "  <url>http://maven.apache.org</url>\n" +
            "\n" +
            "  <properties>\n" +
            "    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>\n" +
            "  </properties>\n" +
            "\n" +
            "  <dependencies>\n" +
            "    <dependency>\n" +
            "      <groupId>junit</groupId>\n" +
            "      <artifactId>junit</artifactId>\n" +
            "      <version>3.8.1</version>\n" +
            "      <scope>test</scope>\n" +
            "    </dependency>\n" +
            "  </dependencies>\n" +
            "</project>\n";

    private static final String GET_POM_ON_WINDOWS_AFTER_REPLACE ="<project xmlns=\"http://maven.apache.org/POM/4.0.0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"&#xD;\n"+
            "  xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\">&#xD;\n"+
            "  <modelVersion>4.0.0</modelVersion>&#xD;\n"+
            "&#xD;\n"+
            "  <groupId>G</groupId>&#xD;\n"+
            "  <artifactId>G</artifactId>&#xD;\n"+
            "  <version>1.0-SNAPSHOT</version>&#xD;\n"+
            "  <packaging>jar</packaging>&#xD;\n"+
            "&#xD;\n"+
            "  <name>G</name>&#xD;\n"+
            "  <url>http://maven.apache.org</url>&#xD;\n"+
            "&#xD;\n"+
            "  <properties>&#xD;\n"+
            "    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>&#xD;\n"+
            "  </properties>&#xD;\n"+
            "&#xD;\n"+
            "  <dependencies>&#xD;\n"+
            "    <dependency>&#xD;\n"+
            "      <groupId>junit</groupId>&#xD;\n"+
            "      <artifactId>junit</artifactId>&#xD;\n"+
            "      <version>3.8.1</version>&#xD;\n"+
            "      <scope>test</scope>&#xD;\n"+
            "    </dependency>&#xD;\n"+
            "  </dependencies>&#xD;\n"+
            "</project>&#xD;\n";


    public static void main(String[] args) {
        System.out.println(POM_ON_LINUX.equals(GET_POM_ON_LINUX_AFTER_REPLACE));
        System.out.println(POM_ON_LINUX.equals(POM_ON_WINDOWS));
        System.out.println(POM_ON_WINDOWS.equals(GET_POM_ON_WINDOWS_AFTER_REPLACE));

        char[] linux = POM_ON_LINUX.toCharArray();
        char[] windows = POM_ON_WINDOWS.toCharArray();

        //System.out.println(POM_ON_WINDOWS.contains("\r"));
    }
}
