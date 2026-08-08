package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import database.DBConnection;
import model.LeaveBalance;
import model.LeaveRequest;
import java.sql.ResultSet;

public class LeaveDAO {

    public boolean addLeaveBalance(LeaveBalance leave) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO leave_balance(emp_id, casual_leave, sick_leave, earned_leave) VALUES(?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, leave.getEmpId());
            ps.setInt(2, leave.getCasualLeave());
            ps.setInt(3, leave.getSickLeave());
            ps.setInt(4, leave.getEarnedLeave());

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
    public boolean applyLeave(LeaveRequest leave) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO leave_requests(emp_id, leave_type, from_date, to_date, reason, status) VALUES(?,?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, leave.getEmpId());
            ps.setString(2, leave.getLeaveType());
            ps.setString(3, leave.getFromDate());
            ps.setString(4, leave.getToDate());
            ps.setString(5, leave.getReason());
            ps.setString(6, leave.getStatus());

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
    public boolean updateLeaveStatus(int requestId, String status) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "UPDATE leave_requests SET status = ? WHERE request_id = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, status);
            ps.setInt(2, requestId);

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
    public void viewLeaveBalance(int empId) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM leave_balance WHERE emp_id = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, empId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("===== Leave Balance =====");
                System.out.println("Employee ID : " + rs.getInt("emp_id"));
                System.out.println("Casual Leave : " + rs.getInt("casual_leave"));
                System.out.println("Sick Leave : " + rs.getInt("sick_leave"));
                System.out.println("Earned Leave : " + rs.getInt("earned_leave"));
            } else {
                System.out.println("No Leave Balance Found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean deductLeave(int empId, String leaveType) {

            try {
                Connection con = DBConnection.getConnection();

                String sql = "";

                if (leaveType.equalsIgnoreCase("Casual")) {
                    sql = "UPDATE leave_balance SET casual_leave = casual_leave - 1 WHERE emp_id = ?";
                } else if (leaveType.equalsIgnoreCase("Sick")) {
                    sql = "UPDATE leave_balance SET sick_leave = sick_leave - 1 WHERE emp_id = ?";
                } else if (leaveType.equalsIgnoreCase("Earned")) {
                    sql = "UPDATE leave_balance SET earned_leave = earned_leave - 1 WHERE emp_id = ?";
                }

                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, empId);

                int rows = ps.executeUpdate();

                return rows > 0;

            } catch (Exception e) {
                e.printStackTrace();
            }

            return false;
        }
    public boolean approveLeaveTransaction(int requestId, int empId, String leaveType) {

        Connection con = null;

        try {
            con = DBConnection.getConnection();

            con.setAutoCommit(false);

            String sql1 = "UPDATE leave_requests SET status='Approved' WHERE request_id=?";
            PreparedStatement ps1 = con.prepareStatement(sql1);
            ps1.setInt(1, requestId);
            ps1.executeUpdate();

            String sql2 = "";

            if (leaveType.equalsIgnoreCase("Casual")) {
                sql2 = "UPDATE leave_balance SET casual_leave = casual_leave - 1 WHERE emp_id=?";
            } else if (leaveType.equalsIgnoreCase("Sick")) {
                sql2 = "UPDATE leave_balance SET sick_leave = sick_leave - 1 WHERE emp_id=?";
            } else if (leaveType.equalsIgnoreCase("Earned")) {
                sql2 = "UPDATE leave_balance SET earned_leave = earned_leave - 1 WHERE emp_id=?";
            }

            PreparedStatement ps2 = con.prepareStatement(sql2);
            ps2.setInt(1, empId);
            ps2.executeUpdate();

            con.commit();

            return true;

        } catch (Exception e) {

            try {
                if (con != null)
                    con.rollback();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            e.printStackTrace();
            return false;

        } finally {

            try {
                if (con != null)
                    con.setAutoCommit(true);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}