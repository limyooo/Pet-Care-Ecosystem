package Business.WorkQueue;

import java.util.ArrayList;

/**
 * WorkQueue stores all work requests assigned to
 * an organization or a user.
 */
public class WorkQueue {

    private ArrayList<WorkRequest> workRequestList;

    public WorkQueue() {
        workRequestList = new ArrayList<>();
    }

    public ArrayList<WorkRequest> getWorkRequestList() {
        return workRequestList;
    }
}
