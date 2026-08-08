# Employee Leave Management System

## Project Description
A JDBC-based Employee Leave Management System developed using Java and MySQL to manage employee leave requests, approvals, rejections, and leave balances.

## Modules
- Employee Registration
- Apply Leave
- Approve/Reject Leave
- Leave Balance Tracking

## Technologies Used
- Java
- JDBC
- MySQL
- Eclipse IDE
- MySQL Workbench

## JDBC Concepts
- CRUD Operations
- Transactions
- Date Handling
- PreparedStatement
- Database Connectivity

## Database Tables
- employees
- leave_requests
- leave_balance

## Project Files
- `DBConnection.java` – Database connection
- `Employee.java` – Employee model
- `EmployeeService.java` – Employee operations
- `LeaveRequest.java` – Leave request model
- `LeaveBalance.java` – Leave balance model
- `LeaveDAO.java` – Leave database operations
- `LeaveService.java` – Leave service operations
- `Main.java` – Main program
- `employee_leave_management.sql` – Database structure and data

## How to Run
1. Create the MySQL database using `employee_leave_management.sql`.
2. Configure the MySQL username, password, and database details in `DBConnection.java`.
3. Add the MySQL Connector/J library to the project.
4. Run `Main.java` from Eclipse.
