package ui;

import dao.EmployeeDAO;
import model.Employee;
import dao.LeaveDAO;
import model.LeaveBalance;
import model.LeaveRequest;

public class Main {

    public static void main(String[] args) {

        Employee emp = new Employee();

        emp.setEmpName("Manish");
        emp.setDepartment("IT");
        emp.setEmail("manish@gmail.com");
        emp.setPhone("9876543210");

        EmployeeDAO dao = new EmployeeDAO();

        if (dao.addEmployee(emp)) {
            System.out.println("Employee Added Successfully");
        } else {
            System.out.println("Failed to Add Employee");
        }
        LeaveBalance leave = new LeaveBalance();

        leave.setEmpId(1);
        leave.setCasualLeave(10);
        leave.setSickLeave(8);
        leave.setEarnedLeave(15);

        LeaveDAO leaveDAO = new LeaveDAO();

        if (leaveDAO.addLeaveBalance(leave)) {
            System.out.println("Leave Balance Added Successfully");
        } else {
            System.out.println("Failed to Add Leave Balance");
        }
        LeaveRequest request = new LeaveRequest();

        request.setEmpId(1);
        request.setLeaveType("Casual");
        request.setFromDate("2026-08-10");
        request.setToDate("2026-08-12");
        request.setReason("Personal Work");
        request.setStatus("Pending");

        if (leaveDAO.applyLeave(request)) {
            System.out.println("Leave Request Added Successfully");
        } else {
            System.out.println("Failed to Add Leave Request");
        }
            if (leaveDAO.approveLeaveTransaction(1, 1, "Casual")) {
                System.out.println("Leave Approved Successfully");
            } else {
                System.out.println("Failed to Approve Leave");
            }
        
        if (leaveDAO.updateLeaveStatus(2, "Rejected")) {
            System.out.println("Leave Rejected Successfully");
        } else {
            System.out.println("FAiled to Reject leave");
        }

        leaveDAO.viewLeaveBalance(1);
    }
}