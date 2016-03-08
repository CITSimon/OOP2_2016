package persistors;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
		//THIS WILL BE IMPLEMENTED LATER
	}
	public ExpenseList load()
	{
		//THIS WILL BE IMPLEMENTED LATER
		return null;
	}
}




