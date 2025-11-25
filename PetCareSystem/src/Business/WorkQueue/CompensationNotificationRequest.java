package Business.WorkQueue;

/**
 * Request to notify another organization about compensation.
 * For example: Insurance Claim -> Pet Boarding for payment info.
 */
public class CompensationNotificationRequest extends WorkRequest {

    private double compensationAmount;   // final compensation amount
    private String note;                 // extra message (optional)

    public double getCompensationAmount() {
        return compensationAmount;
    }

    public void setCompensationAmount(double compensationAmount) {
        this.compensationAmount = compensationAmount;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
