package model;

public class Employee {

    private int empId;
    private String empName;
    private String department;
    private String email;
    private String phone;

    public Employee() {
    }

    public Employee(int empId, String empName, String department, String email, String phone) {
        this.empId = empId;
        this.empName = empName;
        this.department = department;
        this.email = email;
        this.phone = phone;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}