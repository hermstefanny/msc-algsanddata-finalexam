package finalAssignment;

import java.util.*;

public class SortEmployees {
	static ArrayList<EmployeeData> empTest = new ArrayList<EmployeeData>();

	EmployeeData emp1 = new EmployeeData("Ady", "Sin", 300000, 1);
	EmployeeData emp2 = new EmployeeData("Bur", "The", 800, 2);
	EmployeeData emp3 = new EmployeeData("Cas", "Une", 12000, 3);
	EmployeeData emp4 = new EmployeeData("Dan", "Vox", 160000, 3);
	EmployeeData emp5 = new EmployeeData("Ema", "Wix", 500, 1);
	EmployeeData emp6 = new EmployeeData("Flo", "Xor", 320000, 2);
	EmployeeData emp7 = new EmployeeData("Giz", "Yus", 22000, 2);

	EmployeeData empInf = new EmployeeData("NN", "NN", Double.POSITIVE_INFINITY, 0);

	public void addElements() {
		empTest.add(emp1);
		empTest.add(emp2);
		empTest.add(emp3);
		empTest.add(emp4);
		empTest.add(emp5);
		empTest.add(emp6);
		empTest.add(emp7);
	}

	public void mergeElements(ArrayList<EmployeeData> A, int p, int q, int r) {
		int n1 = q - p;
		int n2 = r - q + 1;

		ArrayList<EmployeeData> L = new ArrayList<EmployeeData>(A.subList(p, q + 1));
		ArrayList<EmployeeData> R = new ArrayList<EmployeeData>(A.subList(q + 1, r + 1));

		System.out.println("Left side");
		for (int i = 0; i < L.size(); i++) {
			System.out.println(L.get(i).getEmployeeFirstName());
		}

		System.out.println("Right side");
		for (int i = 0; i < R.size(); i++) {
			System.out.println(R.get(i).getEmployeeFirstName());
		}

		L.add(empInf);
		R.add(empInf);

		int i = 0;
		int j = 0;

		for (int k = p; k <=r; k++) {
			if (L.get(i).getEmployeeGrossSalary() <= R.get(j).getEmployeeGrossSalary()) {
				A.set(k, L.get(i));
				i++;
			} else {
				A.set(k, R.get(j));
				j++;
			}

		}

	}

	public void mergeSort(ArrayList<EmployeeData> A, int p, int r) {
		if (p < r) {
			int q = (p + r) / 2;
			mergeSort(A, p, q);
			mergeSort(A, q + 1, r);
			mergeElements(A, p, q, r);

		}
	}

	public void printArrayList(ArrayList<EmployeeData> Emp) {
		System.out.println("Printing array");
		for (int i = 0; i < Emp.size(); i++) {
			System.out.println(
					"Name " + Emp.get(i).getEmployeeFirstName() + " Salary " + Emp.get(i).getEmployeeGrossSalary());
		}

	}

	public static void main(String args[]) {
		SortEmployees sort1 = new SortEmployees();
		sort1.addElements();
		sort1.mergeSort(empTest, 0, empTest.size() - 1);

		sort1.printArrayList(empTest);

	}

}
