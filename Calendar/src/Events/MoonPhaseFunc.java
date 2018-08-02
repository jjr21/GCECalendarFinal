package Events;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.YearMonth;
import java.sql.*;
public class MoonPhaseFunc {
private int days;
private LocalDate MoonCurrentMonth;

public MoonPhaseFunc() {
	days = 28;
}

public int getDays() {
	return days;
}

public void MoonMathFulltoFull() {
	int y = 1;
	YearMonth yearMonthObject = YearMonth.of(2018, y);
	int daysInMonth = yearMonthObject.lengthOfMonth();
	MoonCurrentMonth = LocalDate.of(2018, 1, 1);

	for (int x = 0; x < 200; x++) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/calendargce", "root", "");
			Statement stmt = con.createStatement();
			String sql = "INSERT INTO `moonphase` (`moonID`, `moonDate`, `moonShape`) VALUES (NULL, '"
					+ MoonCurrentMonth + "', 'FULL')";

			// String sql="select * from moonphase";
			int rs = stmt.executeUpdate(sql);
			// System.out.println(MoonCurrentMonth);
			LocalDate MoonTemp = MoonCurrentMonth.plusDays(29);
			MoonCurrentMonth = MoonTemp;
			String[] arr = null;

			con.close();
		}

		catch (Exception e) {
			System.out.println(e);
		}

	}
	MoonCurrentMonth = LocalDate.of(2018, 1, 1);
	for (int x = 0; x < 200; x++) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/calendargce", "root", "");
			Statement stmt = con.createStatement();
			String sql = "INSERT INTO `moonphase` (`moonID`, `moonDate`, `moonShape`) VALUES (NULL, '"
					+ MoonCurrentMonth + "', 'FULL')";

			// String sql="select * from moonphase";
			int rs = stmt.executeUpdate(sql);
			// System.out.println(MoonCurrentMonth);

			LocalDate MoonTemp = MoonCurrentMonth.plusDays(-29);
			MoonCurrentMonth = MoonTemp;
			String[] arr = null;

			con.close();}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}
	
	

public void getMoonDB() {
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/calendargce", "root", "");
		Statement stmt = con.createStatement();
		String sql = "select * from moonphase";
		ResultSet rs = stmt.executeQuery(sql);
		String[] arr = null;
		while (rs.next()) {
			String usernameQ = rs.getString("moonDate");
			arr = usernameQ.split("\n");
			for (int i = 0; i < arr.length; i++) {
				String TempDate = arr[i];
				@SuppressWarnings("unused")
				LocalDate moonLocalDate = LocalDate.parse(TempDate);
				
			}
		}
		con.close();
	} catch (Exception e) {
		System.out.println(e);
	}
}



//		catch (Exception e) {
//			System.out.println(e);
//		}
//
//	}



private void testEqualDate() {
	LocalDate l = LocalDate.now();

	System.out.println(l.equals(LocalDate.now()));
}

public static void main(String[] args) {

	MoonPhaseFunc mp = new MoonPhaseFunc();
//mp.getMoonDB();
	//mp.MoonMathFulltoFull();
	mp.MoonMathFulltoFull();
}
}