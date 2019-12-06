package sample.Model.Statuses;

public enum Status {
    ADMIN("Admin", 1),
    LIBRARIAN("Librarian", 2),
    STUDENT("Student", 3),
    BORROWED("Borrowed", 4),
    ISSUED("Issued", 5),
    FINED("Fined", 6);
    private final String status;
    private final int statusId;
    Status(String status, int statusId) {
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
