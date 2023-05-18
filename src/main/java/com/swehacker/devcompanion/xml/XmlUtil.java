package com.swehacker.devcompanion.xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.IOException;
import java.io.StringWriter;

/**
 * Utility for making xml look great. Sadly jackson is not working correctly when trying to convert xml into compact
 * format so, we had to change to xerxes instead.
 */
public final class XmlUtil {

    public static final String UTF_8 = "UTF-8";

    private XmlUtil() {
        // Util class
    }

    public static String compactFormat(String xmlString, boolean skipDeclaration) {
        try {
            OutputFormat format = OutputFormat.createCompactFormat();
            return convertToText(format, skipDeclaration, xmlString);
        } catch (Exception e) {
            throw new RuntimeException("Error occurs when using compact-format xml: %s".formatted(xmlString), e);
        }
    }

    public static String prettyPrint(String xmlString, int indent, boolean skipDeclaration) throws DocumentException, IOException {
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setIndentSize(indent);
        return convertToText(format, skipDeclaration, xmlString);
    }


    private static String convertToText(OutputFormat format, boolean skipDeclaration, String xmlString) throws DocumentException, IOException {
        format.setSuppressDeclaration(skipDeclaration);
        format.setEncoding(UTF_8);

        Document document = DocumentHelper.parseText(xmlString);
        StringWriter sw = new StringWriter();
        XMLWriter writer = new XMLWriter(sw, format);
        writer.write(document);
        return sw.toString();
    }
}
