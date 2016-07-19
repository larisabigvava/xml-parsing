package parser.sax;

import entity.Book;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;


/**
 * Created by Larisa_Bigvava on 7/19/2016.
 */
public class SaxParser {

    public static void libraryParse(String xmlFilePath) throws ParserConfigurationException, IOException, SAXException {
        org.xml.sax.XMLReader reader = XMLReaderFactory.createXMLReader();
        LibrarySaxHandler handler = new LibrarySaxHandler();
        reader.setContentHandler(handler);
        reader.parse(xmlFilePath);
        List<Book> library = handler.getBookList();
    }
}
