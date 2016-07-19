package parser.sax;
import entity.Book;
import entity.Genre;
import entity.LibraryTagName;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Larisa_Bigvava on 7/19/2016.
 */
public class LibrarySaxHandler extends DefaultHandler {

    private Book book;
    private StringBuilder text;
    private List<Book> bookList = new ArrayList<Book>();

    public List<Book> getBookList() {
        return bookList;
    }

    @Override
    public void startDocument() throws SAXException {
    }

    @Override
    public void endDocument() throws SAXException {
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        text = new StringBuilder();
        if (qName.equals("book")){
            book = new Book();
            book.setCountOfPages(Integer.valueOf(attributes.getValue("countOfPages")));
            if (attributes.getValue("yearOfPublishing") != null){
                book.setYearOfPublishing(Integer.valueOf(attributes.getValue("yearOfPublishing")));
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        LibraryTagName tagName = LibraryTagName.valueOf(qName.toUpperCase().replace(":","_"));
        switch (tagName){
            case TITLE:
                book.setTitle(text.toString());
                break;
            case AUTHOR:
                book.setAuthor(text.toString());
                break;
            case GENRE:
                book.setGenre(Genre.valueOf(text.toString()));
                break;
            case BOOK:
                bookList.add(book);
                book = null;
                break;
        }
    }

    @Override
    public void characters(char[] buffer, int start, int lenght) throws SAXException {
        text.append(buffer, start, lenght);
    }
}
