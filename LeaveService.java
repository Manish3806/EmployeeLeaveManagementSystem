package service;

import dao.LeaveDAO;
import model.LeaveBalance;
import model.LeaveRequest;

public class LeaveService {

    private LeaveDAO leaveDAO = new LeaveDAO();

    public boolean addLeaveBalance(LeaveBalance leave) {
        return leaveDAO.addLeaveBalance(leave);
    }

    public boolean applyLeave(LeaveRequest leave) {
        return leaveDAO.applyLeave(leave);
    }
}