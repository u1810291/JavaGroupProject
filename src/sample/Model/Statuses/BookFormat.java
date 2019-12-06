package sample.Model.Statuses;

public enum BookFormat {
    HARDCOVER("Hardcover",1),
    PAPERBACK("Paperback",2),
    AUDIOBOOK("AudioBook",3),
    EBOOK("Ebook",4),
    NEWSPAPER("Newspaper",5),
    MAGAZINE("Magazine",6),
    JOURNAL("Journal",7),
    COMICS("Comics",8);
    private final String status;
    private final int statusId;
    BookFormat(String status, int statusId){
        this.status = status;
        this.statusId = statusId;
    }

    public String getStatus() {
        return status;
    }

    public int getStatusId() {
        return statusId;
    }
}
