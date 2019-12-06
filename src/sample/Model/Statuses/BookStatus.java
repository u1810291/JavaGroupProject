package sample.Model.Statuses;

public enum BookStatus {
    AVAILABLE("Available",1),
    RESERVED("Reserved",2),
    LOANED("Loaned",3),
    LOST("Lost",4);
    private final String status;
    private final int statusId;
    BookStatus(String status, int statusId) {
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
