package MortgageCalculator;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCal {

	public static void main(String[] args) {
		final byte month_of_year = 12;
		final byte percent = 100;
		int principal = 0;
		float annualInterest = 0;
		float montlyInterest = 0;
		byte years = 0;
		int numberOfPayments = 0;
		
		Scanner scanner = new Scanner(System.in);
		
//		Input For Principal
		while (true) {
		System.out.print("Principal: ");
		principal = scanner.nextInt();
		if (principal >= 1000 && principal <= 10_000_000)
			break;
		else System.out.println("** Principal Must Be More Than 1,000 and Less then 10,000,000 **");
		}
		
//		Input For Annual Interest Rate
		while (true) {
		System.out.print("Annual Interest Rate: ");
		annualInterest = scanner.nextFloat();
		montlyInterest = annualInterest / percent / month_of_year;
		if (annualInterest > 1 && annualInterest <= 30)
			break;
		else System.out.println("** Intrest Rate Must Be Above 1% and Less Than 30% **");
		}
		
//		Input For Period (Year)
		while (true) {
			System.out.print("Period (Years): ");
		years = scanner.nextByte();
		numberOfPayments = years * month_of_year;
		if(years > 1 && years <= 100)
			break;
		else System.out.println("** Period (Years) Must Be Over 1 Year & Less Than 100 Years **");
		}
		
//		Monthly Mortgage Calculation		
		double mortgage = principal 
		* (montlyInterest * Math.pow(1 + montlyInterest, numberOfPayments))
		/ (Math.pow(1 + montlyInterest, numberOfPayments) - 1);
		String mortgageFormated = NumberFormat.getCurrencyInstance().format(mortgage);
				System.out.println("Montly Mortgage: " + mortgageFormated);
				
//		Yearly Mortgage Calculation
		double yearlyPayments = mortgage * (double)month_of_year;
		String fullYearPayment = NumberFormat.getCurrencyInstance().format(yearlyPayments);
		System.out.println("Yearly Mortgage: " + fullYearPayment);
		
//		Overall Payment Calculation	
		double OverallPayment = mortgage * (double)numberOfPayments;
		String totalPayment = NumberFormat.getCurrencyInstance().format(OverallPayment);
		System.out.println("Total Payment: " + totalPayment);
	}
}

		