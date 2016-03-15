import model.Expense;
import model.ExpenseList;


public class MockGUITesterLoadingFromDatabase {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExpensesController.getInstance().setPersistenceMode(PersistenceType.DATABASE);
		ExpensesController.getInstance().load();

		ExpenseList expenseList = ExpensesController.getInstance().getListOfExpenses();
		
		System.out.println("Retrieved this data from the database!");
		for(Expense expense : expenseList.getExpenses())
		{
			System.out.println(expense);
		}
		
	}

}
