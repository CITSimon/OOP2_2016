package persistors;

import model.ExpenseList;

public interface ExpensesPersistor {

	public void save(ExpenseList expenses);
	public ExpenseList load();
}
