package persistors;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.AnnualExpense;
import model.Expense;
import model.ExpenseList;

public class DatabasePersistor implements ExpensesPersistor 
{
	//This is the JDBC Connection object.
	private Connection dbConnection;
	
	//Override the default constructor and put the database connection code in here
	public DatabasePersistor()
	{
		try
		{
			//Create an instance of the database driver (This class is in the JAR file)
			Class.forName("com.mysql.jdbc.Driver");
			//Now we want to try connecting to the database using our connection string.
			this.dbConnection = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/expensesdb?user=citsimon2016&password=abc123");
		
			if(this.dbConnection != null)
			{
				System.out.println("CONNECTED TO DATABASE!! : "+this.dbConnection);
			}
			else
			{
				System.out.println("CONNECTION FAILED!!");
			}
		}
		catch(ClassNotFoundException c)
		{
			System.out.println(c.getMessage());
		}
		catch(SQLException s)
		{
			System.out.println(s.getMessage());
		}
	}

	public void save(ExpenseList expenses)
	{
		try
		{
			dbConnection.setAutoCommit(false);
			//For the moment we are going to deal purely with AnnualExpense objects. 
			//We will extend this in future labs.
			
			for(Expense currExpense : expenses.getExpenses())
			{
				//We are dealing with all AnnualExpense objects so we cast the Expense to an AnnualExpense
				AnnualExpense annualExpense = (AnnualExpense)currExpense;
				PreparedStatement prepStmt = dbConnection.prepareStatement("INSERT into expense values (?, ?, ?, ?)");
				prepStmt.setDouble(1, annualExpense.getAmount());
				prepStmt.setString(2, annualExpense.getName());
				prepStmt.setString(3, annualExpense.getDescription());
				//We convert the long number to its String equivalent for storage in the database using Long.toString.
				prepStmt.setString(4, Long.toString(annualExpense.getCreationDateTime()));
				prepStmt.executeUpdate();
				prepStmt.close();
			}
			dbConnection.commit();
			dbConnection.setAutoCommit(true);
		}
		catch(SQLException sqlEx)
		{
			System.out.println(sqlEx.getMessage());
		}
		
		
		
	}
	public ExpenseList load()
	{
		//Create an initially empty ExpenseList which we will populate with the re-created AnnualExpense objects below
		ExpenseList expenseList = new ExpenseList();
		try
		{
			Statement stmt = dbConnection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * from expense");
			
			//We go through each row in the database and take each piece of information out of each 
			//column in the row. We then use this data to reconstruct an AnnualExpense object
			while(rs.next())
			{
				double amount = rs.getDouble("amount");
				String name = rs.getString("name");
				String description = rs.getString("description");
				String creationTime = rs.getString("creationtime");
				
				//Re-create an AnnualExpense object with the data just read from the database.
				AnnualExpense recreatedExpense = 
						new AnnualExpense(amount, name, description, Long.parseLong(creationTime));
				expenseList.add(recreatedExpense);
			}
			rs.close();
			stmt.close();
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
		return expenseList;
	}
}









