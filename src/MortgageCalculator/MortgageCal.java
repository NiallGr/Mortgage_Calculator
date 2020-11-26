package MortgageCalculator;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCal {

	public static void main(String[] args) {
		final byte month_of_year = 12;
		final byte percent = 100;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Principal: ");
		int principal = scanner.nextInt();
		
		System.out.print("Annual Interest Rate: ");
		float annualInterest = scanner.nextFloat();
		float montlyInterest = annualInterest / percent / month_of_year;
		System.out.print("Period (Years): ");
		byte years = scanner.nextByte();
		int numberOfPayments = years * month_of_year;
		
		
		double mortgage = principal 
		* (montlyInterest * Math.pow(1 + montlyInterest, numberOfPayments))
		/ (Math.pow(1 + montlyInterest, numberOfPayments) - 1);
		
		String mortgageFormated = NumberFormat.getCurrencyInstance().format(mortgage);
				System.out.println("Montly Mortgage: " + mortgageFormated);
		
		double yearlyPayments = mortgage * (double)month_of_year;
		String fullYearPayment = NumberFormat.getCurrencyInstance().format(yearlyPayments);
		System.out.println("Yearly Mortgage: " + fullYearPayment);
	}
}

		