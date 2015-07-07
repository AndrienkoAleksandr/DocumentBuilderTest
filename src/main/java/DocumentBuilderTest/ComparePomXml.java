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
    private static final String pomOnLinux = "<project xmlns=\"http://maven.apache.org/POM/4.0.0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
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

    private static final String getPomOnLinuxAfterReplace =
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

    public static void main(String[] args) {
        System.out.println(pomOnLinux.equals(getPomOnLinuxAfterReplace));
    }
}
