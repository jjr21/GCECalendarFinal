import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.GregorianCalendar;


public class MoonFunction {
	final int MoonFunc = 29;

	public static void main(String... args) {
		
		try {
			 
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/calendargce", "root", "");
			Statement stmt = con.createStatement();
			//String str = JOptionPane.showInputDialog("Enter Query:");
			String sql="select * from moonphase";
			ResultSet rs= stmt.executeQuery(sql);
			String[] arr = null;
            while (rs.next()) {
                String loginid = rs.getString("moonID");
               arr = loginid.split("\n");
               for (int i =0; i < arr.length; i++){
                   System.out.println(arr[i]);
                  
                  
               }
             
               String usernameQ = rs.getString("moonDate");
               arr = usernameQ.split("\n");
               for (int i =0; i < arr.length; i++){
                   System.out.println(arr[i]);
               }
              
               String passwordQ = rs.getString("moonShape");
               arr = passwordQ.split("\n");
               for (int i =0; i < arr.length; i++){
                 System.out.println(arr[i]);
               }
              
            }
			con.close();
			}
		
		catch(Exception e){
			System.out.println(e);
		}
	}
}
