/* package yr_command_line;
 *
 * Programmer: Kun Deng
 * Date Created: 07/20/2015
 *
 * Purpose: Prints out the Federal Withholding Tax, Illinois
 * Withholding Tax, Social Security Tax, and Medicare Tax
 * totaling the taxes taken out of each paycheck. I work at
 * Aurora University's ITS Department as a student worker.
 */

import java.util.Scanner;


public class PayrollCalculator
{
	public PayrollCalculator()
	{

	}
	public PayrollCalculator(double hoursFromMain)
    	{
	        hours = hoursFromMain;
    	}

    	private static double payRate;
   	private static double hours;
	private static double grossPay;
   	private static double netPay;
   	private static double fedTax;
   	private static double stateTax;
   	private static double socialSecurityTax;
   	private static double medicareTax;
	B
   	private static double totalTax;

	public static void setPayRate(double payRateFromMain)
	{
		payRate = payRateFromMain;
	}	
    	public static void setHours(double hoursFromMain)
    	{
        	hours = hoursFromMain;
    	}
    	public static void setGrossPay()
		B
    	{
		//Multiplying by hundred then dividng the rounded
		//number product by 100 to get a number in the
		//hundreths place
        	grossPay = Math.round(hours * payRate * 100)/100.0;
    	}
    	public static void setFedTax()
    	{
        	if (grossPay < 87) //Changed ceilling from 86.5 to 87
        	{
            		fedTax = 0;
        	}
        	else if (grossPay >= 87 && grossPay <= 443) //Changed floor from 86.5 to 87
        	{
			//Using the floor method instead of the round method
			//the government does not round up
            		fedTax = Math.floor((grossPay - 86.65) * .10 * 100)/100.0;
        	}	
        	else if (grossPay >= 443 && grossPay <= 1529) //Changed ceilling from 1529 to 1535
        	{
			//Changed deduction from 35.50 to 205.46 and changed 
			//percentage from 10 percent to 15 percent
			fedTax = Math.floor((grossPay - 208.00) * .15 * 100)/100.0;
        	}
   	 }	
    	public static void setStateTax()
    	{
        	stateTax = Math.round(grossPay * .0375 * 100)/100.0;
   	}	
   	public static void setSocialSecurityTax()
	{	
		//The amount of hours is a rough estimate
		//With more practice I might find the right
		//amount of hours. Even then changes in tax
		//in years might make things innaccurate
        	//Update: Turns out only the federal government
		//rounds down, the other taxes round up
		if (hours >= 26)
        	{
            		socialSecurityTax = Math.round((grossPay * .062) * 100)/100.0;
        	}
        	else
            		socialSecurityTax = 0;
    	}	
    	public static void setMedicareTax()
    	{
		
        	if (hours >= 26)
        	{
            		medicareTax = Math.round((grossPay * .0145) * 100)/100.0;
        	}
        	else
            		medicareTax = 0;
    	}	
    	public static void setTotalTax()
    	{
        	totalTax = (fedTax + stateTax + socialSecurityTax + medicareTax);
    	}

    	public static void setNetPay()
    	{
        	netPay = (grossPay - totalTax);
    	}
	public static double getPayRate()
	{
		return payRate;
	}	
    	public static double getHours()
    	{
        	return hours;
    	}
    	public static double getGrossPay()
    	{
        	return grossPay;
    	}
    	public static double getFedTax()
    	{
        	return fedTax;
    	}
    	public static double getStateTax()
    	{
        	return stateTax;
    	}
    	public static double getSocialSecurityTax()
    	{
        	return socialSecurityTax;
    	}
    	public static double getMedicareTax()
    	{
        	return medicareTax;
    	}
    	public static double getTotalTax()
    	{
        	return totalTax;
    	}
    	public static double getNetPay()
    	{
        	return netPay;
    	}
    	public static void lineSeparator()
    	{
        	for (int i = 0; i < 2; i++)
        	{
            		for (int k = 0; k < 5; k++)
            		{
                		System.out.printf("%s", "~~");
            		}
           		 System.out.println();
        	}
    	}
    	public static void getPayInformation()
    	{

        	lineSeparator();
	        System.out.println("Paycheck Information");
        	lineSeparator();

        	System.out.printf("Total Hours: %.2f", PayrollCalculator.getHours());
        	System.out.printf("\nGross Pay: $%.2f", PayrollCalculator.getGrossPay());
        	System.out.printf("\nNet Pay: $%.2f\n", PayrollCalculator.getNetPay());
        	lineSeparator();
        	System.out.println("Tax Withholding");
        	lineSeparator();
        	System.out.printf("Total Tax: $%.2f\n", PayrollCalculator.getTotalTax());
        	System.out.printf("Federal Tax Withholding: $%.2f\n", PayrollCalculator.getFedTax());
        	System.out.printf("Illinois Tax Withholding: $%.2f\n", PayrollCalculator.getStateTax());
        	System.out.printf("Social Security Tax Withholding: $%.2f\n", PayrollCalculator.getSocialSecurityTax());
        	System.out.printf("Medicare Tax Withholding: $%.2f\n", PayrollCalculator.getMedicareTax());
    	}	

    	public static void main(String[] args)
    	{
        	Scanner userInput = new Scanner(System.in);
        	double hours, payRate;

        	System.out.print("Enter hours worked: ");

        	hours = userInput.nextDouble();

		System.out.print("Enter Pay Rate: ");
		payRate = userInput.nextDouble();

        	while (hours < 0)
        	{
            		System.out.print("Hours can not be less than zero");
            		System.out.print("\nTry again: ");

            		hours = userInput.nextDouble();
        	}
        	if (hours == 0)
        	{
            		System.out.println("You did not work this pay schedule");
        	}
        	else
        	{
			PayrollCalculator.setPayRate(payRate);
            		PayrollCalculator.setHours(hours);
            		PayrollCalculator.setGrossPay();
            		PayrollCalculator.setFedTax();
            		PayrollCalculator.setStateTax();
            		PayrollCalculator.setSocialSecurityTax();
            		PayrollCalculator.setMedicareTax();
            		PayrollCalculator.setTotalTax();
          		PayrollCalculator.setNetPay();
        	}
        	PayrollCalculator.getPayInformation();
        	userInput.close();
    	}	
}
