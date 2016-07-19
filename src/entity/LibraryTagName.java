package entity;

/**
 * Created by Larisa_Bigvava on 7/19/2016.
 */
public enum LibraryTagName {
    TITLE, AUTHOR, GENRE, BOOK, LIB_BOOKS;

    public static LibraryTagName getElementTagName(String element){
        switch (element){
            case "title":
                return TITLE;
            case "author":
                return AUTHOR;
            case "genre":
                return GENRE;
            case "book":
                return BOOK;
            case "lib:books":
                return LIB_BOOKS;
            default:throw new EnumConstantNotPresentException(LibraryTagName.class, element);
        }
    }
}
