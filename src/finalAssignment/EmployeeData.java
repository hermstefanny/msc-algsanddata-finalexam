package finalAssignment;

public class EmployeeData {
	private String employeeFirstName;
	private String employeeLastName;
	private double grossSalary;
	private int employeeDepartmentID;
	private int employeeID;
	static private int empCount = 1;
	
	public EmployeeData(String employeeFirstNameIn, String employeeLastNameIn, double grossSalaryIn, int employeeDepartmentIDIn) {
		employeeFirstName = employeeFirstNameIn;
		employeeLastName = employeeLastNameIn ;
		grossSalary = grossSalaryIn;
		employeeDepartmentID = employeeDepartmentIDIn;
		employeeID = empCount;
		EmployeeData.empCount++;
	}
	
	public String getEmployeeFirstName() {
		return employeeFirstName;
	}
	
	public String getEmployeeLastName() {
		return employeeLastName;
	}
	
	public double getEmployeeGrossSalary() {
		return grossSalary;
	}
	
	public int getEmployeeDepartmentID() {
		return employeeDepartmentID;
	}
	
	public int getEmployeeID() {
		return employeeID;
	}
}
