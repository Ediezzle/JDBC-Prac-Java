package jdbcPrac;

import java.sql.*;

public class DatabaseQuery
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		// Get connection, execute query, get the result set
				// and print the entries from the result rest
				//try-with-resources eliminates the need to explicitly call connection.close()
				//on Connection, Statement, and 
				//ResultSet in a finally block since we used try-with-resources
				try (
						Connection connection = DatabaseConnector.connectToDatabase();
						Statement statement = connection.createStatement();
						ResultSet resultSet = statement.executeQuery("SELECT * FROM contact");
					)
					{
						System.out.println("ID \tfName \tlName \temail \t\tphoneNo");
						// from resultSet metadata, find out how many columns are there and then
						//read the column entries
						int numOfColumns = resultSet.getMetaData().getColumnCount();
						while (resultSet.next()) 
						{
						// remember that the column index starts from 1 not 0
							for(int i = 1; i <= numOfColumns; i++) 
							{
								// since we do not know the data type of the column, we use 
								//getObject()
								System.out.print(resultSet.getObject(i) + "\t");
							}
						
							System.out.println("");
							
						}
						
					}
						
						catch (SQLException sqle) 
						{
							sqle.printStackTrace();
						}
	 }

}
