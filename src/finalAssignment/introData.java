package finalAssignment;

import java.util.*;

public class introData {
	
	ArrayList<EmployeeData> sortedArrayBySalary= new ArrayList<EmployeeData>();
	
	public ArrayList sortBySalary(ArrayList <EmployeeData> empIn) {
	 
		return sortedArrayBySalary;
	}

	public static void main(String args[]) {
		ArrayList<DepartmentData> departments = new ArrayList<DepartmentData>();
		ArrayList<EmployeeData> employees = new ArrayList<EmployeeData>();

		Scanner sc = new Scanner(System.in);

		String nameDep;
		String addressDep;

		char c1 = 'y';
		char c2 = 'y';

		// DATA OF DEPARTMENTS
		System.out.println("DATA OF DEPARTMENTS: ");
		while (c1 == 'y') {
			System.out.println("Please add the NAME of the department: ");
			nameDep = sc.nextLine();
			System.out.println("Please add the ADDRESS of the department: ");
			addressDep = sc.nextLine();

			DepartmentData dep = new DepartmentData(nameDep, addressDep);

			departments.add(dep);

			System.out.println(
					"Press 'y' to continue login DEPARTMENTS. Press any other key to continue to the next section ");
			String temp = sc.nextLine();
			if (temp.length() > 0) {
				c1 = temp.charAt(0);
			} else {
				c1 = 'n';
			}
		}

		System.out.println("DATA OF EMPLOYEES: ");
		while (c2 == 'y') {

			System.out.println("Please add the  FIRST NAME of the employee: ");
			String firstNameEmp = sc.nextLine();

			System.out.println("Please add the  LAST NAME of the employee: ");
			String lastNameEmp = sc.nextLine();

			System.out.println("Please add the  GROSS SALARY of the employee: ");
			double grossSalaryEmp = Double.parseDouble(sc.nextLine());

			System.out.println("Please add the  ID of the  of the employee's department: ");
			int depIDEmp = Integer.parseInt(sc.nextLine());
			while (DepartmentData.verifyDepartmentID(depIDEmp) == false) {
				System.out.println("ERROR: NON EXISTENT DEPARTMENT ID ");
				System.out.println("Please add the correct ID for the department: ");
				depIDEmp = Integer.parseInt(sc.nextLine());
			}

			EmployeeData emp = new EmployeeData(firstNameEmp, lastNameEmp, grossSalaryEmp, depIDEmp);

			employees.add(emp);

			System.out.println(
					"Press 'y' to continue login EMPLOYEES. Press any other key to continue to the next section ");

			String temp = sc.nextLine();
			if (temp.length() > 0) {
				c2 = temp.charAt(0);
			} else {
				c2 = 'n';
			}

		}
		sc.close();

		System.out.println("DEPARTMENTS");
		System.out.println("| Department ID | " + "  Department Name  " + " |      Department Address      |");
		for (int i = 0; i < departments.size(); i++) {
			System.out.println("\t" + departments.get(i).getDepartmentID() + "\t  "
					+ departments.get(i).getDepartmentName() + "\t\t" + departments.get(i).getDepartmentAddress());
		}

		System.out.println("EMPLOYEES");
		System.out.println("| EMPLOYEE ID | " + " FIRST NAME " + " | LAST NAME |" + " DEPARTMENT ID "
				+ " | GROSS SALARY |" + "    TAX    " + "| SALARY AFTER TAX | ");
		for (int i = 0; i < employees.size(); i++) {
			System.out.println("\t" + employees.get(i).getEmployeeID() + "\t" + employees.get(i).getEmployeeFirstName()
					+ "\t\t" + employees.get(i).getEmployeeLastName() + "\t\t"
					+ employees.get(i).getEmployeeDepartmentID() + "\t" + employees.get(i).getEmployeeGrossSalary()
					+ "\t\t" + employees.get(i).calculateTax() + "\t\t" + employees.get(i).calculateAfterTax());
		}
		
		System.out.println("SORTED BY SALARY");
		/*employees.sort(Comparator.comparing(EmployeeData::getEmployeeGrossSalary));
		for (int i = 0; i < employees.size(); i++) {
			System.out.println("Name" + employees.get(i).getEmployeeFirstName() +
		"Salary"+ employees.get(i).getEmployeeGrossSalary());
		}*/

	}
}
