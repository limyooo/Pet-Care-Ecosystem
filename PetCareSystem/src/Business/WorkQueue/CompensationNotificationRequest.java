package Business.WorkQueue;

/**
 * CompensationNotificationRequest:
 * A work request used to notify another organization about
 * the result of a compensation calculation.
 */

public class CompensationNotificationRequest extends WorkRequest {

    private double compensationAmount;   // Final approved compensation
    private String note;                 // Additional remarks

    
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
