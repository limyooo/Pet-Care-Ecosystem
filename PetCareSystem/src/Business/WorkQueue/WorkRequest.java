package Business.WorkQueue;

import Business.UserAccount.UserAccount;
import java.util.Date;

/**
 * Base class for all work requests.
 * Different request types will extend this class.
 */
public abstract class WorkRequest {

    private String message;          // short description
    private UserAccount sender;      // who created the request
    private UserAccount receiver;    // who is currently handling it
    private String status;           // e.g. "Pending", "Processing", "Completed"
    private Date requestDate;        // created time
    private Date resolveDate;        // finished time

    public WorkRequest() {
        requestDate = new Date();
    }

    // ----- getters & setters -----

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserAccount getSender() {
        return sender;
    }

    public void setSender(UserAccount sender) {
        this.sender = sender;
    }

    public UserAccount getReceiver() {
        return receiver;
    }

    public void setReceiver(UserAccount receiver) {
        this.receiver = receiver;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public Date getResolveDate() {
        return resolveDate;
    }

    public void setResolveDate(Date resolveDate) {
        this.resolveDate = resolveDate;
    }

    @Override
    public String toString() {
        // 通常在 JTable 里显示 status 或 message
        return status;
    }
}
