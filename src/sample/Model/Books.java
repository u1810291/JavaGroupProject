package sample.Model;

public class Books {
    private int book_id;
    private String borrowedStatus, title, subject, author, ISBN, publishDate;
    public int getBook_id() {
        return book_id;
    }
    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }
    public String getBorrowedStatus() {
        return borrowedStatus;
    }
    public void setBorrowedStatus(String borrowedStatus) {
        this.borrowedStatus = borrowedStatus;
    }
    public String getTitle() {
        return title;
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

}
