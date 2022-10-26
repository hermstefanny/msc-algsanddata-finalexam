package finalAssignment;

public class TaxCalculationTest {
	public static void main(String args[]) {
		TaxCalculation sal1 = new TaxCalculation(50000);
		TaxCalculation sal2 = new TaxCalculation(40000);
		TaxCalculation sal3 = new TaxCalculation(80000);
		TaxCalculation sal4 = new TaxCalculation(165000);
		TaxCalculation sal5 = new TaxCalculation(12000);
		TaxCalculation sal6 = new TaxCalculation(38000);
		
		System.out.println("| SALARY |"+ sal1.getSalary() + "| TAX | " + sal1.calculateTaxAlternative() + "|");
		System.out.println("| SALARY |"+ sal2.getSalary() + "| TAX | " + sal2.calculateTaxAlternative() + "|");
		//System.out.println("| SALARY |"+ sal3.getSalary() + "| TAX | " + sal3.calculateTax() + "|");
		System.out.println("| SALARY |"+ sal3.getSalary() + "| TAX | " + sal3.calculateTaxAlternative() + "|");
		System.out.println("| SALARY |"+ sal4.getSalary() + "| TAX | " + sal4.calculateTaxAlternative() + "|");
	}

}
