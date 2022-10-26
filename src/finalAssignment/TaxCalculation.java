package finalAssignment;

import java.util.*;

public class TaxCalculation {
	// ATTRIBUTES
	double[] incomeTax = { 150000, 50270, 12570, 0 };
	double[] rateTax = { 0.45, 0.4, 0.2, 0 };
	private double salary;
	private double calculatedTax = 0;

	// METHODS
	// Construct
	public TaxCalculation(double salaryIn) {
		salary = salaryIn;
	}

	public double getSalary() {
		return salary;
	}

	public double calculateTax() {

		int i = 0;
		while (salary - incomeTax[i] < 0) {
			i++;
		}
		//System.out.println(salary - incomeTax[i]);

		calculatedTax = (salary - incomeTax[i]) * rateTax[i];
		System.out.println("Calculated before for "+ calculatedTax +" the index is "+ i);

		
		for (int j = 1; j < (incomeTax.length-1 - i); j++) {
			calculatedTax = calculatedTax + ((incomeTax[i + j] - incomeTax[i + (j + 1)]) * rateTax[i]);
			//System.out.println("Calculated during for "+ calculatedTax);
		}
		//System.out.println("Calculated after for "+ calculatedTax);
		return calculatedTax;
	}

	
	public double calculateTaxAlternative() {
		
		double[] auxTable =  {(incomeTax[0]-incomeTax[1])*rateTax[1], 
							  (incomeTax[1]-incomeTax[2])*rateTax[2], 
							  (incomeTax[2]-incomeTax[3])*rateTax[3]};
		
		double auxValue=0;
		int i = 0;
		while (salary - incomeTax[i] < 0) {
			i++;
		}
		
		calculatedTax = (salary - incomeTax[i]) * rateTax[i];
		System.out.println("Calculated before for "+ calculatedTax +" the index is "+ i);
		
		for (int j = 0; j < auxTable.length - i; j++) {
			auxValue = auxValue + auxTable[i+j];
		}
		
		return calculatedTax + auxValue;
	}
}
