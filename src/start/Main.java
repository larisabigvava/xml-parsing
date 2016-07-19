package start;

import org.xml.sax.SAXException;
import parser.dom.LibraryDomParser;
import parser.sax.SaxParser;
import parser.stax.LibraryStAXParser;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Larisa_Bigvava on 7/19/2016.
 */
public class Main {
    private static final String xmlFilePath = "C:\\Users\\Larisa_Bigvava@epam.com\\Desktop\\Java Hometask\\xml-parsing\\xml-parsing\\resources\\library.xml";

    public static void main(String[] args){
        LibraryDomParser.parseLibrary(xmlFilePath);
        try {
            SaxParser.libraryParse(xmlFilePath);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.println("Exception during sax parsing");
        }
        try {
            LibraryStAXParser.libraryParse(xmlFilePath);
        } catch (FileNotFoundException | XMLStreamException e) {
            System.out.println("Exception during stAX parsing");
        }
    }
}
