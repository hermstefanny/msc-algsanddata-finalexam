package finalAssignment;

import java.util.ArrayList;
import java.util.Scanner;

public class introData {

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
			nameDep = sc.next();
			System.out.println("Please add the ADDRESS of the department: ");
			addressDep = sc.next();

			DepartmentData dep = new DepartmentData(nameDep, addressDep);

			departments.add(dep);

			System.out.println(
					"Press 'y' to continue login DEPARTMENTS. Press any other key to continue to the next section ");
			c1 = sc.next().charAt(0);

		}

		System.out.println("DATA OF EMPLOYEES: ");
		while (c2 == 'y') {
			
			System.out.println("Please add the  FIRST NAME of the employee: ");
			String firstNameEmp = sc.next();

			System.out.println("Please add the  LAST NAME of the employee: ");
			String lastNameEmp = sc.next();

			System.out.println("Please add the  GROSS SALARY of the employee: ");
			double grossSalaryEmp = sc.nextDouble();

			System.out.println("Please add the  ID of the  of the employee's department: ");
			int depIDEmp = sc.nextInt();
			while (DepartmentData.verifyDepartmentID(depIDEmp) == false) {
				System.out.println("ERROR: NON EXISTENT DEPARTMENT ID ");
				System.out.println("Please add the correct ID for the department: ");
				depIDEmp = sc.nextInt();
			}

			EmployeeData emp = new EmployeeData(firstNameEmp, lastNameEmp, grossSalaryEmp, depIDEmp);

			employees.add(emp);

			System.out.println(
					"Press 'y' to continue login EMPLOYEES. Press any other key to continue to the next section ");
			c2 = sc.next().charAt(0);

		}
		sc.close();

		System.out.println("DEPARTMENTS");
		System.out.println("| Department ID | " + "Department Name" + " | Department Address |");
		for (int i = 0; i < departments.size(); i++) {
			System.out.println("\t" + departments.get(i).getDepartmentID() + "\t" + "\t"
					+ departments.get(i).getDepartmentName() + "\t" + "\t" + departments.get(i).getDepartmentAddress());
		}

		System.out.println("EMPLOYEES");
		System.out.println(
				"| EMPLOYEE ID | " + " FIRST NAME " + " | LAST NAME |" + " DEPARTMENT ID " + " | GROSS SALARY |");
		for (int i = 0; i < employees.size(); i++) {
			System.out.println("\t" + employees.get(i).getEmployeeID() + "\t" 
					+ employees.get(i).getEmployeeFirstName() + "\t\t" + employees.get(i).getEmployeeLastName()
					+ "\t\t" + employees.get(i).getEmployeeDepartmentID() + "\t\t" 
					+ employees.get(i).getEmployeeGrossSalary());
		}

	}
}
