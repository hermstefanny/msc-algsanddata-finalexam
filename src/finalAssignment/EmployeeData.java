package finalAssignment;

public class EmployeeData {
	private String employeeFirstName;
	private String employeeLastName;
	private double grossSalary;
	private int employeeDepartmentID;
	private int employeeID;
	static private int empCount = 1;
	
	//Attributes for Tax Calculation
	private double personalAllowance = 12570;
	private double deductableLimit = 125140;
	double[] incomeTax = { 150000, 50270, 12570, 0};
	double[] rateTax = { 0.45, 0.4, 0.2, 0};
	private double calculatedTax = 0;
	private double salaryAfterTax = 0;
	private double taxableSalary = 0;
	
	
	
	
	//METHODS
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
	
	//Methods for tax Calculation
	public double calculateTax() {
		
		if (grossSalary >= deductableLimit) {
			for (int i = 0; i < incomeTax.length; i++) {
				if (incomeTax[i] > personalAllowance) {
					incomeTax[i] = incomeTax[i] - personalAllowance;
				} else {
					incomeTax[i] = 0;
				}
			}
		}
		
		double[] auxTable =  {(incomeTax[0]-incomeTax[1])*rateTax[1], 
							  (incomeTax[1]-incomeTax[2])*rateTax[2], 
							  (incomeTax[2]-incomeTax[3])*rateTax[3]};
		
		double firstValue=0;
		double auxValue=0;
		int i = 0;
		while (grossSalary - incomeTax[i] < 0) {
			i++;
		}
		
		 firstValue = (grossSalary - incomeTax[i]) * rateTax[i];
		
		 for (int j = 0; j < auxTable.length - i; j++) {
			auxValue = auxValue + auxTable[i+j];
		}
		 
		calculatedTax = firstValue + auxValue;
		
		return calculatedTax;
	}
	
	public double calculateAfterTax() {
		salaryAfterTax = grossSalary - calculatedTax;
		return salaryAfterTax;
	}
	
	
}
