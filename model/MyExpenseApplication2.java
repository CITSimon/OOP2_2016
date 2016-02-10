package model;
//This is a tidier version of MyExpenseApplication. In this case we have "encapsulated" / "wrapped up" some of the more 
//complex logic like the ArrayList and the for loop in another class called ExpenseList so that we can re-use it.

public class MyExpenseApplication2 {

	public static void main(String[] args) {		
		ExpenseList myList = new ExpenseList();

		MonthlyExpense phone = new MonthlyExpense("Phone", 30, 22);
		WeeklyExpense bus = new WeeklyExpense("Bus", 2.50, WeeklyExpense.TUESDAY);
		AnnualExpense carInsurance = new AnnualExpense(350.25, "Car Insurance", "Insured with AVIVA - Policy ABC123");
		
		myList.add(phone);
		myList.add(bus);
		myList.add(carInsurance);
		
		System.out.println("Monthly Expenses = "+myList.getCostPerMonthOfAllExpenses());
		
	}

}
