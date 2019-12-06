package sample.Model.Statuses;

public enum ReservationStatus {
    WAITING("Waiting", 1),
    PENDING("Pending", 2),
    COMPLETED("Competed", 3),
    CANCELED("Canceled", 4);
    private final String status;
    private final int statusId;
    ReservationStatus(String status, int statusId) {
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
