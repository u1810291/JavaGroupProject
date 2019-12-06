package sample.Model.Statuses;

public enum AccountStatus {
    ACTIVE("Active", 1),
    CLOSED("Closed", 2),
    CANCELED("Canceled", 3),
    BLACKLIST("BlackList", 4);
    private final String status;
    private final int statusId;
    AccountStatus(String status, int statusId){
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
