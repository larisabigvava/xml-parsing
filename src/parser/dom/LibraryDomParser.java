package parser.dom;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import entity.Book;
import entity.Genre;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Created by Larisa_Bigvava on 7/19/2016.
 */
public class LibraryDomParser {

    public static void parseLibrary(String xmlFilePath){
        DOMParser parser = new DOMParser();
        try {
            parser.parse(xmlFilePath);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
        Document document = parser.getDocument();
        Element root = document.getDocumentElement();
        List<Book> library = new ArrayList<Book>();
        NodeList bookNodes = root.getElementsByTagName("book");
        Book book = null;
        for (int i=0; i < bookNodes.getLength(); i++){
            book = new Book();
            Element bookElement = (Element) bookNodes.item(i);
            book.setCountOfPages(Integer.parseInt(bookElement.getAttribute("countOfPages")));
            book.setTitle(String.valueOf(bookElement.getElementsByTagName("title").item(0).getTextContent()));
            book.setAuthor(String.valueOf(bookElement.getElementsByTagName("author").item(0).getTextContent()));
            book.setGenre(Genre.valueOf(bookElement.getElementsByTagName("genre").item(0).getTextContent()));
            if (bookElement.hasAttribute("yearOfPublishing")){
                book.setYearOfPublishing(Integer.valueOf(bookElement.getAttribute("yearOfPublishing")));
            }
            library.add(book);
        }
    }
}

