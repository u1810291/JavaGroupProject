package sample.Model;

import javafx.scene.control.Button;

import java.io.BufferedReader;

public class Books { //title, subject, author, ISBN, publishDate, addBook, editBook, deleteBook
    private String title, subject, author, ISBN, publishDate;
    Button add, edit, delete;

    public Books(String t, String s, String a, String i, String p, Button ad, Button ed, Button de) {
        this.title = t;
        this.subject = s;
        this.author = a;
        this.ISBN = i;
        this.publishDate = p;
        this.add = ad;
        this.edit = ed;
        this.delete = de;
    }

    public Button getAdd() {
        return add;
    }

    public void setAdd(Button add) {
        this.add = add;
    }

    public Button getEdit() {
        return edit;
    }

    public void setEdit(Button edit) {
        this.edit = edit;
    }

    public Button getDelete() {
        return delete;
    }

    public void setDelete(Button delete) {
        this.delete = delete;
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
