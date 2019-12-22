package sample.Model;


public class Books { //title, subject, author, ISBN, publishDate, addBook, editBook, deleteBook
    private String title, subject, author, ISBN, publishDate;
    public Books(String t, String s, String a, String i, String p) {
        this.title = t;
        this.subject = s;
        this.author = a;
        this.ISBN = i;
        this.publishDate = p;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getTitle() {
        return title;
    }
}
