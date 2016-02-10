package model;

import java.util.ArrayList;

public class MyExpenseApplication {
		
	public static void main(String[] args)
	{
		//This is a polymorphic array list which can hold any object which is an Expense. 
		//(i.e. Any subclass of Expense)
		ArrayList<Expense> myexpenses = new ArrayList<Expense>();
		
		MonthlyExpense phone = new MonthlyExpense("Phone", 30, 22);
		WeeklyExpense bus = new WeeklyExpense("Bus", 2.50, WeeklyExpense.TUESDAY);
		AnnualExpense carInsurance = new AnnualExpense(350.25, "Car Insurance", "Insured with AVIVA - Policy ABC123");
		
		myexpenses.add(phone);
		myexpenses.add(bus);
		myexpenses.add(carInsurance);
		
		//Go through all expenses, print each one out and work out the monthly cost.
		
		//This is an example of polymorphism. From the point of view of this for loop it only 
		//cares that there are a list of Expense objects and that each one can send back its monthly cost.
		
		double monthlyTotal = 0.0;		
		for(Expense exp : myexpenses)
		{
			System.out.println(exp.getName() + " "+exp.getAmount());
			monthlyTotal += exp.calculateCostPerMonth();
		}
		
		System.out.println("Your monthly cost is : "+monthlyTotal);
	}
	
}
