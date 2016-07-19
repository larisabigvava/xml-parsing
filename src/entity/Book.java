package entity;

/**
 * Created by Larisa_Bigvava on 7/19/2016.
 */
public class Book {
    private String title;
    private String author;
    private Genre genre;
    private Integer countOfPages;
    private Integer yearOfPublishing;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public entity.Genre getGenre() {
        return genre;
    }

    public void setGenre(entity.Genre genre) {
        this.genre = genre;
    }

    public Integer getCountOfPages() {
        return countOfPages;
    }

    public void setCountOfPages(Integer countOfPages) {
        this.countOfPages = countOfPages;
    }

    public Integer getYearOfPublishing() {
        return yearOfPublishing;
    }

    public void setYearOfPublishing(Integer yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }
}
