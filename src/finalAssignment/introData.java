package finalAssignment;

import java.util.*;

public class introData {

	public static void printArrayDepartments(ArrayList<DepartmentData> departments) {
		
		System.out.println("| Department ID | " + "  Department Name  " + " |      Department Address      |");
		for (int i = 0; i < departments.size(); i++) {
			System.out.println("\t" + departments.get(i).getDepartmentID() + "\t  "
					+ departments.get(i).getDepartmentName() + "\t\t" + departments.get(i).getDepartmentAddress());
		}
		System.out.println("-------------------------------------------------------------------");
	}

	public static void printArrayEmployees(ArrayList<EmployeeData> Emp) {
		
		System.out.println("| EMPLOYEE ID | " + " FIRST NAME " + " | LAST NAME |" + " DEPARTMENT ID "
				+ " | GROSS SALARY |" + "    TAX    " + "| SALARY AFTER TAX | ");

		for (int i = 0; i < Emp.size(); i++) {
			System.out.println("\t" + Emp.get(i).getEmployeeID() + "\t" + Emp.get(i).getEmployeeFirstName() + "\t\t"
					+ Emp.get(i).getEmployeeLastName() + "\t\t" + Emp.get(i).getEmployeeDepartmentID() + "\t\t"
					+ Emp.get(i).getEmployeeGrossSalary() + "\t  " + Emp.get(i).calculateTax() + "\t\t"
					+ Emp.get(i).calculateAfterTax());
		}
		System.out.println("-------------------------------------------------------------------");

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
		
		//2. Printing the table of the departments and elements with the with Tax Calculated

		System.out.println("DEPARTMENTS");
		printArrayDepartments(departments);

		System.out.println("EMPLOYEES");
		printArrayEmployees(employees);

		//3.SORTING EMPLOYEES BY SALARY//
		// Creating a copy of the original array to be sorted by salary
		ArrayList<EmployeeData> sortedArrayBySalary = new ArrayList<EmployeeData>(employees);
		//Object to sort the Employees Array by Salary
		SortEmployeesSalary sort1 = new SortEmployeesSalary();

		sort1.mergeSortSalary(sortedArrayBySalary, 0, sortedArrayBySalary.size() - 1);
		
		System.out.println("EMPLOYES SORTED BY SALARY");
		printArrayEmployees(sortedArrayBySalary);
		
		//4. SORTING EMPLOYES BY DEPARTMENT ID //
		// Creating a copy of the original array to be sorted by Department ID
		ArrayList<EmployeeData> sortedArrayByDepID = new ArrayList<EmployeeData>(employees);

		//Object to sort the Employees Array by Department ID
		SortEmployeesbyDepartmentID sort2 = new SortEmployeesbyDepartmentID();
		
		sort2.mergeSortDepartmentID(sortedArrayByDepID, 0, sortedArrayByDepID.size()-1);
		System.out.println("EMPLOYES SORTED BY DEPARTMENT ID");
		printArrayEmployees(sortedArrayByDepID);

	}

}

class SortEmployeesSalary {

	public void mergeElementsSalary(ArrayList<EmployeeData> A, int p, int q, int r) {
		int n1 = q - p + 1;
		int n2 = r - q;

		ArrayList<EmployeeData> L = new ArrayList<EmployeeData>();
		ArrayList<EmployeeData> R = new ArrayList<EmployeeData>();

		// Creation of an element with infinite salary
		EmployeeData empInf = new EmployeeData("NN", "NN", Double.POSITIVE_INFINITY, 0);

		for (int i = 0; i < n1; i++) {
			L.add(A.get(p + i));
		}

		for (int j = 0; j < n2; j++) {
			R.add(A.get(q + j + 1));
		}

		L.add(empInf);
		R.add(empInf);

		int i = 0;
		int j = 0;

		for (int k = p; k <= r; k++) {
			if (L.get(i).getEmployeeGrossSalary() <= R.get(j).getEmployeeGrossSalary()) {
				A.set(k, L.get(i));
				i++;
			} else {
				A.set(k, R.get(j));
				j++;
			}

		}

	}

	public void mergeSortSalary(ArrayList<EmployeeData> A, int p, int r) {
		if (p < r) {
			int q = (p + r) / 2;
			mergeSortSalary(A, p, q);
			mergeSortSalary(A, q + 1, r);
			mergeElementsSalary(A, p, q, r);

		}
	}

}

class SortEmployeesbyDepartmentID {

	public void mergeElementsDepID(ArrayList<EmployeeData> A, int p, int q, int r) {
		int n1 = q - p + 1;
		int n2 = r - q;

		ArrayList<EmployeeData> L = new ArrayList<EmployeeData>();
		ArrayList<EmployeeData> R = new ArrayList<EmployeeData>();

		// Creation of an element with infinite salary
		EmployeeData empInf = new EmployeeData("NN", "NN", Double.POSITIVE_INFINITY, 0);

		for (int i = 0; i < n1; i++) {
			L.add(A.get(p + i));
		}

		for (int j = 0; j < n2; j++) {
			R.add(A.get(q + j + 1));
		}

		L.add(empInf);
		R.add(empInf);

		int i = 0;
		int j = 0;

		for (int k = p; k <= r; k++) {
			if (L.get(i).getEmployeeDepartmentID() <= R.get(j).getEmployeeDepartmentID()) {
				A.set(k, L.get(i));
				i++;
			} else {
				A.set(k, R.get(j));
				j++;
			}

		}

	}

	public void mergeSortDepartmentID(ArrayList<EmployeeData> A, int p, int r) {
		if (p < r) {
			int q = (p + r) / 2;
			mergeSortDepartmentID(A, p, q);
			mergeSortDepartmentID(A, q + 1, r);
			mergeElementsDepID(A, p, q, r);

		}
	}

}
