package parser.stax;

import entity.Book;
import entity.Genre;
import entity.LibraryTagName;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Larisa_Bigvava on 7/19/2016.
 */
public class LibraryStAXParser {

    public static void libraryParse(String xmlFilePath) throws FileNotFoundException, XMLStreamException {
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        InputStream input = new FileInputStream(xmlFilePath);
        XMLStreamReader reader = inputFactory.createXMLStreamReader(input);
        List<Book> library = process(reader);
    }

    private static List<Book> process(XMLStreamReader reader) throws XMLStreamException {
        List<Book> library = new ArrayList<Book>();
        Book book = null;
        LibraryTagName elementName = null;
        while (reader.hasNext()){
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    elementName = LibraryTagName.getElementTagName(reader.getLocalName());
                        switch (elementName) {
                            case BOOK:
                                book = new Book();
                                Integer countOfPages = Integer.parseInt(reader.getAttributeValue(null, "countOfPages"));
                                book.setCountOfPages(countOfPages);
                                if (!(reader.getAttributeValue(null, "yearOfPublishing") == null) && !(reader.getAttributeValue(null, "yearOfPublishing").isEmpty())) {
                                    Integer yearOfPublishing = Integer.parseInt(reader.getAttributeValue(null, "yearOfPublishing"));
                                    book.setYearOfPublishing(yearOfPublishing);
                                }
                                break;
                        }
                        break;
                case XMLStreamConstants.CHARACTERS:
                    String text = reader.getText().trim();
                    if (text.isEmpty()) {
                        break;
                    }
                    switch (elementName) {
                        case TITLE:
                            book.setTitle(text);
                            break;
                        case AUTHOR:
                            book.setAuthor(text);
                            break;
                        case GENRE:
                            book.setGenre(Genre.valueOf(text));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    elementName = LibraryTagName.getElementTagName(reader.getLocalName());
                    switch (elementName) {
                        case BOOK:
                            library.add(book);
                            break;
                    }
                    break;
            }
        }
        return library;
    }
}
