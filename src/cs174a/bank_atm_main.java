package cs174a;

import java.sql.*;

public class bank_atm_main {
	
	static Connection conn;
	/*CREATE (Insert)*/
	static String insertToAcctType = "insert into Account_Types(Acct_Type,Interest_Rate,Accrued) Values(?,?,?)";
	static String insertToAcctCust = "insert into Acct_Cust(Account_ID,Tax_ID,Primary_Acct) Values(?,?,?)";
	static String insertToAcct = "insert into Accounts(Balance, Account_ID, Branch, Status, Acct_Type) Values(?,?,?,?,?)";
	static String insertToCust = "insert into Customers(Name,Address,Tax_ID,Pin) Values(?,?,?,?)";

	/*READ (Select)*/
	static String selectTaxIDfromName = "select Tax_ID from customers where Name = ?";
	static String selectNumAcct = "select count(Account_ID) from Accounts";
	
	/*UPDATE (Update)*/
	
	/*DELETE (Delete)*/
	public bank_atm_main()
	{
		
	}

	public static void createConnection()
	{
		try {
			conn = DriverManager.getConnection ("jdbc:oracle:thin:@uml.cs.ucsb.edu:1521:xe","daniel_trinh","8917148");

		} catch(SQLException ex) {
			System.err.println("SQLException in connectionCreate: " + ex.getMessage());
		}
	}
	public static PreparedStatement getPrStatement(String query) throws SQLException
	{
	    PreparedStatement pstmt = conn.prepareStatement(query);
	    return pstmt;
	}
	public static Statement getStatement() throws SQLException
	{
	    Statement stmt = conn.createStatement();
	    
		return stmt;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) throws SQLException{
		
		// 1. Load the Oracle JDBC driver for this program
		try 
		{
	      DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
		}
		catch ( Exception e)
		{ 
			e.printStackTrace(); 
		}
		
		createConnection();
		///////////////////////////////////////////////////

	    // 2. Test functions for each query
	//	print_all();
		
//		System.out.println("1. withdrawal");
//		withdraw(222, 50);
		//print_all();
//		
//		System.out.println("2. deposit");
//		deposit(222, 55);
//		print_all();
//		
//		System.out.println("3. transfer");
//		transfer(222,111,34.45);
//		print_all();
		
		//System.out.println("4. number of accounts: " + numOfaccount());
		buildDataSet();
		conn.close();
		System.out.println("Connection closed");
		//insertAccount("400.0", "12345", "Goleta Banking", "Open", "Savings");
	}

	public static void print_all() throws SQLException
	{
	    // Create a Statement
		Statement stmt = getStatement();
	    // Specify the Query to run
	    ResultSet rs = stmt.executeQuery ("select Account_Id, Balance, Acct_Type from Accounts");

	    // Iterate through the result and print the data
	    System.out.println("result:");
	    System.out.println("Account_Id\tBalance\t\tType");
	    
	    while(rs.next())
	    {
	    	System.out.println(String.format("%d\t%f\t%s",rs.getInt("Account_ID"), rs.getFloat("Balance"), rs.getString("Acct_Type")));
	    }
	    // don't miss this
	    rs.close();
	}
	
	private static void buildDataSet() throws SQLException
	{
		/*
		System.out.println("Inserting account types:");
		Date sqlDate = new Date(new java.util.Date().getTime());
		float interest = (float) 5.50;
		insertAcctType("Savings", interest, sqlDate);
		interest = (float) 0.00;
		insertAcctType("Student Checking", interest, sqlDate);
		interest = (float) 7.00;
		insertAcctType("Interest Checking", interest, sqlDate);
		*/
		//System.out.println("Inserting customers:");
		/*
		insertCustomer("Alfred Hitchcock", "6667 ElColegio #40", 361721022, 12345);
		insertCustomer("Billy Clinton", "5777 Hollister", 231403227, 14682);
		insertCustomer("Cindy Laugher", "7000 Hollister", 412231856, 37642);
		insertCustomer("David Copperfill", "1357 State St", 207843218, 85821);
		insertCustomer("Elizabeth Sailor", "4321 State St", 122219876, 38567);
		insertCustomer("Fatal Castro", "3756 La Cumbre Plaza", 401605312, 81934);
		insertCustomer("George Brush", "5346 Foothill Av", 201674933, 98246);
		insertCustomer("Hurryson Ford", "678 State St", 212431965, 35328);
		insertCustomer("Ivan Lendme", "1235 Johnson Dr", 322175130, 84713);
		insertCustomer("Joe Pepsi", "3210 State St", 344151573, 36912);
		insertCustomer("Kelvin Coster", "Santa Cruz #3579", 209378521, 46590);
		insertCustomer("Li Kung", "2 People's Rd Beijing", 212116070, 91734);
		insertCustomer("Magic Jordon", "3852 Court Rd", 188212217, 73521);
		insertCustomer("Nam-hoi Chung", "1997 People's St HK", 203491209, 53540);
		insertCustomer("Olive Stoner", "6689 El Colegio #151", 210389768, 82452);
		insertCustomer("Pit Wilson", "911 State St", 400651982, 18221);
		*/
		//System.out.println("Inserting Accounts:");
/*
		insertAccount((float)9289.0, 17431, "San Francisco", "Open", "Student Checking");
		insertAccount((float)18000.0, 54321, "Los Angeles", "Open", "Student Checking");
		insertAccount((float)1000.0, 12121, "Goleta", "Open", "Student Checking");
		insertAccount((float)10000.0, 41725, "Los Angeles", "Open", "Interest Checking");
		insertAccount((float)6000.0, 76543, "Santa Barbara", "Open", "Interest Checking");
		insertAccount((float)80000.0, 93156, "Goleta", "Open", "Interest Checking");
		insertAccount((float)711.0, 43942, "Santa Barbara", "Open", "Savings");
		insertAccount((float)30000.0, 29107, "Los Angeles", "Open", "Savings");
		insertAccount((float)3300.0, 19023, "San Francisco", "Open", "Savings");
		insertAccount((float)5000.0, 32156, "Goleta","Open","Savings");
*/
		//System.out.println("Select TaxID w/ name param");
		//System.out.print(SelectTaxIDFromName("Cindy Laugher"))
		System.out.println("Inserting Acct_Cust Pairs");
		/*
		insertAcctCust(19023,"Cindy Laugher","Yes");
		insertAcctCust(19023,"George Brush","No");
		insertAcctCust(19023,"Fatal Castro","No");
		
		insertAcctCust(29107,"Kelvin Costner","Yes");
		
		
		insertAcctCust(29107,"Li Kung","No");
		insertAcctCust(43942,"Alfred Hitchcock","Yes");
		insertAcctCust(43942,"Pit Wilson","No");
		insertAcctCust(43942,"Hurryson Ford","No");
		insertAcctCust(43942,"Ivan Lendme", "No");
		insertAcctCust(93156,"Kelvin Costner","No");
		/*insertAcctCust(93156,"Magic Jordon","No");
		insertAcctCust(93156,"Olive Stoner","No");
		insertAcctCust(93156,"Elizabeth Sailor","No");
		*//*
		insertAcctCust(93156,"Nam-hoi Chung","No");
		insertAcctCust(54321,"Hurryson Ford", "Yes");
		insertAcctCust(54321,"Cindy Laugher","No");
		insertAcctCust(54321,"Elizabeth Sailor","No");
		insertAcctCust(54321,"Nam-hoi Chung","No");
		insertAcctCust(17431,"Joe Pepsi","Yes");
		insertAcctCust(17431,"Cindy Laugher","No");
		
		insertAcctCust(17431,"Ivan Lendme","No");
		insertAcctCust(12121,"David Copperfill","Yes");
		insertAcctCust(41725,"George Brush","Yes");
		insertAcctCust(41725,"Fatal Castro","No");
		insertAcctCust(41725,"Billy Clinton","No");
		
		insertAcctCust(76543,"Li Kung","Yes");
		
		insertAcctCust(76543,"Magic Jordon","No");
		insertAcctCust(32156,"Magic Jordon","Yes");
		
		insertAcctCust(32156,"David Copperfill","No");
		
		insertAcctCust(32156,"Elizabeth Sailor","No");
		
		insertAcctCust(32156,"Joe Pepsi","No");
		
		insertAcctCust(32156,"Nam-hoi Chung","No");
		insertAcctCust(32156,"Olive Stoner","No");
		*/
	}
	public static int withdraw(int accid, double bal) throws SQLException
	{
		PreparedStatement withraw_statement;
	    String updateSuppSQL = "update account set bal=bal-? where accid = ?";
	    withraw_statement = conn.prepareStatement(updateSuppSQL);
	    
	    withraw_statement.setDouble(1, bal);
	    withraw_statement.setInt(2,accid);
	    
	    int n = withraw_statement.executeUpdate();
	    System.out.println("updates  : " + n );
	    withraw_statement.close();

		return n;
	}
	
	/*UPDATE*/
	public static int deposit(int accid, double bal)
	{
		return 0;
	}
	
	public static int transfer(int accid_from, int accid_to, double bal)
	{
		return 0;
	}
	
	public static int writecheck(int accid, double bal)
	{
		return 0;
	}
	
	/*READ*/
	private static int SelectTaxIDFromName(String name) throws SQLException
	{
		ResultSet rs = null;
		PreparedStatement stmt = getPrStatement(selectTaxIDfromName);
		
		int tax_id = -1;
		//String insertString1 = "insert into Accounts values('"+acct_type+"', "+interest+", "+accr_date+")";
		//String insertString2 = "Commit";
		try {
			stmt.setString(1, name);
			rs = stmt.executeQuery();
			//select first tax_Id if multiple of same name
			rs.next();
			tax_id = rs.getInt(1);
			
			stmt.close();
		} catch(SQLException ex) {
			System.err.println("SQLException SelectTaxID: " + ex.getMessage());
		}
		stmt.close();
		return tax_id;
	}
	
	public static int numOfaccount() throws SQLException
	{
		int retVal;
		// Connect to the database  ... connection pool managers?
		
	    // Create a Statement
	    Statement stmt = getStatement();
	    // Specify the Query to run
	    
	    ResultSet rs = stmt.executeQuery(selectNumAcct);

	    // get data of the first column
	    rs.next();
	    retVal= rs.getInt(1);
	    // don't miss this
	    rs.close();
		
	    return retVal;
	}
	
	/*CREATE*/
	private static int insertAcctType(String acct_type, float interest, Date accr_date) throws SQLException
	{
		int rowCount = -1;
		PreparedStatement stmt = getPrStatement(insertToAcctType);
		
		//String insertString1 = "insert into Accounts values('"+acct_type+"', "+interest+", "+accr_date+")";
		//String insertString2 = "Commit";
		try {
			//stmt.executeUpdate(insertString1);
			//stmt.executeUpdate(insertString2);
			stmt.setString(1, acct_type);
			stmt.setFloat(2, interest);
			stmt.setDate(3, accr_date);
			rowCount = stmt.executeUpdate();
			
			stmt.close();
			
		} catch(SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
			
		}
		stmt.close();
		return rowCount;
	}
	
	private static int insertAcctCust(int a_id, String name, String primary) throws SQLException
	{
		int rowCount = -1;
		int taxID = SelectTaxIDFromName(name); 
		PreparedStatement stmt = getPrStatement("insert into Acct_Cust(Account_ID,Tax_ID,Primary_Acct) Values(?,?,?)");
		ResultSet rs;

		try {
			stmt.setInt(1, a_id);
			stmt.setInt(2, taxID);
			stmt.setString(3, primary);
			rs = stmt.executeQuery();
			
			stmt.close();
			rs.close();
		} catch(SQLException ex) {
			stmt.close();
			System.err.println("SQLException: " + ex.getMessage());
		}
		return rowCount;	
	}
	
	private static int insertCustomer(String name, String address, int Tax_ID, int pin) throws SQLException
	{
		int rowCount = -1;
		PreparedStatement stmt = getPrStatement("insert into Customers(Name,Address,Tax_ID,Pin) Values(?,?,?,?)");
		ResultSet rs = null;
		//String insertString1 = "insert into Accounts values('"+acct_type+"', "+interest+", "+accr_date+")";
		//String insertString2 = "Commit";
		try {
			//stmt.executeUpdate(insertString1);
			//stmt.executeUpdate(insertString2);
			stmt.setString(1, name);
			stmt.setString(2, address);
			stmt.setInt(3, Tax_ID);
			stmt.setInt(4, pin);
			rs = stmt.executeQuery();
			
		} catch(SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
		rs.close();
		stmt.close();
		return rowCount;
	}
	
	/*A transaction is added to the database whenever a withdraw/deposit/wire/transfer/write-check occurs*/
	private static int insertTransaction(String tr_type, int amount, int a_id1, int a_id2, String date, int tr_id, int tax_id, int check_id)
	{
		return 0;
	}

	private static void insertAccount(float balance, int a_id, String bank_branch, String status, String a_type) throws SQLException
	{
		int retVal;
		ResultSet rs;
		PreparedStatement stmt = getPrStatement(insertToAcct);

		try {
			stmt.setFloat(1, balance);
			stmt.setInt(2, a_id);
			stmt.setString(3, bank_branch);
			stmt.setString(4, status);
			stmt.setString(5, a_type);
			rs = stmt.executeQuery();
			rs.close();
		} catch(SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
		stmt.close();
	}
}
