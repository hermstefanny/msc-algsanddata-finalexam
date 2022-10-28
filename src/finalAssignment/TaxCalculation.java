package finalAssignment;

import java.util.*;

public class TaxCalculation {
	// ATTRIBUTES
	double[] incomeTax = { 150000, 50270, 12570, 0 };
	double[] rateTax = { 0.45, 0.4, 0.2, 0 };
	private double salary;
	private double calculatedTax = 0;
	private double salaryAfterTax = 0;
	private double personalAllowance = 12570;
	private double deductableLimit = 125140;

	// METHODS
	// Construct
	public TaxCalculation(double salaryIn) {
		salary = salaryIn;
	}

	public double getSalary() {
		return salary;
	}

	public double calculateTax() {

		if (salary >= deductableLimit) {
			// The upper bound it's always maintained, so it starts from 1
			for (int i = 1; i < incomeTax.length; i++) {
				if (incomeTax[i] > personalAllowance) {
					incomeTax[i] = incomeTax[i] - personalAllowance;
				} else {
					incomeTax[i] = 0;
				}
			}
		}

		double[] totalTaxesByBand = new double[incomeTax.length - 1];
		for (int i=0; i < incomeTax.length - 1; i++) {
			totalTaxesByBand[i] = rateTax[i+1] * (incomeTax[i] - incomeTax[i+1]);
		}
		
		double taxInLowerBands = 0;
		int salaryBandIndex = 0;
		while (salary - incomeTax[salaryBandIndex] < 0) {
			salaryBandIndex++;
		}

		double taxInTheSalaryBand = (salary - incomeTax[salaryBandIndex]) * rateTax[salaryBandIndex];
		// System.out.println("Calculated before for "+ calculatedTax +" the index is "+
		// i);

		for (int j = 0; j < totalTaxesByBand.length - salaryBandIndex; j++) {
			taxInLowerBands = taxInLowerBands + totalTaxesByBand[salaryBandIndex + j];
		}
		calculatedTax = taxInTheSalaryBand + taxInLowerBands;
		return calculatedTax;
	}

	public double calculateAfterTax() {
		salaryAfterTax = salary - calculatedTax;
		return salaryAfterTax;
	}
}
