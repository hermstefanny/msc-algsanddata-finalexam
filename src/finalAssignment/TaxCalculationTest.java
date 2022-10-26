package finalAssignment;

public class TaxCalculationTest {
	public static void main(String args[]) {
		TaxCalculation sal1 = new TaxCalculation(50000);
		TaxCalculation sal2 = new TaxCalculation(40000);
		TaxCalculation sal3 = new TaxCalculation(80000);
		TaxCalculation sal4 = new TaxCalculation(165000);
		TaxCalculation sal5 = new TaxCalculation(12000);
		TaxCalculation sal6 = new TaxCalculation(38000);
		
		System.out.println("| SALARY | " + "  TAX  " + " | SALARY AFTER TAX |");
		System.out.println("  "+ sal1.getSalary() + "   " + sal1.calculateTax() + "  \t " + sal1.calculateAfterTax());
		System.out.println("  "+ sal2.getSalary() + "   " + sal2.calculateTax() + "  \t " + sal2.calculateAfterTax());
		System.out.println("  "+ sal3.getSalary() + "   " + sal3.calculateTax() + "  \t " + sal3.calculateAfterTax());
		System.out.println("  "+ sal4.getSalary() + "  " + sal4.calculateTax() + "  \t " + sal4.calculateAfterTax());
		System.out.println("  "+ sal5.getSalary() + "   " + sal5.calculateTax() + "  \t " + sal5.calculateAfterTax());
		System.out.println("  "+ sal6.getSalary() + "   " + sal6.calculateTax() + "  \t " + sal6.calculateAfterTax());
		
	}

}
