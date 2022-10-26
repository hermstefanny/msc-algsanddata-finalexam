package finalAssignment;

import java.util.*;

public class TaxCalculation {
	// ATTRIBUTES
	double[] incomeTax = { 150000, 50270, 12570, 0 };
	double[] rateTax = { 0.45, 0.4, 0.2, 0 };
	private double salary;
	private double calculatedTax = 0;
	private double salaryAfterTax = 0;

	// METHODS
	// Construct
	public TaxCalculation(double salaryIn) {
		salary = salaryIn;
	}

	public double getSalary() {
		return salary;
	}

	public double calculateTax() {
		
		double[] auxTable =  {(incomeTax[0]-incomeTax[1])*rateTax[1], 
							  (incomeTax[1]-incomeTax[2])*rateTax[2], 
							  (incomeTax[2]-incomeTax[3])*rateTax[3]};
		
		double firstValue=0;
		double auxValue=0;
		int i = 0;
		while (salary - incomeTax[i] < 0) {
			//System.out.println("en el while "+ (salary - incomeTax[i]) + i);
			i++;
		}
		
		 firstValue = (salary - incomeTax[i]) * rateTax[i];
		//System.out.println("Calculated before for "+ calculatedTax +" the index is "+ i);
		
		for (int j = 0; j < auxTable.length - i; j++) {
			auxValue = auxValue + auxTable[i+j];
		}
		calculatedTax = firstValue + auxValue;
		return calculatedTax;
	}
	
	public double calculateAfterTax() {
		salaryAfterTax = salary - calculatedTax;
		return salaryAfterTax;
	}
}
