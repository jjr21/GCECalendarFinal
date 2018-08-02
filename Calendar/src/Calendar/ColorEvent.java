package Calendar;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ColorEvent {

	public void setColorEvent(Button days, int dayofmonth, Year year, Month month) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/calendargce", "root", "");
			Statement stmt = con.createStatement();
			// String str = JOptionPane.showInputDialog("Enter Query:");
			String sql = "select * from eventhandle";
			ResultSet rs = stmt.executeQuery(sql);
			String[] arr = null;
			while (rs.next()) {
				String loginid = rs.getString("EventDate");
				arr = loginid.split("\n");
				for (int i = 0; i < arr.length; i++) {
					String TempDate = arr[i];
					LocalDate moonLocalDate = LocalDate.parse(TempDate);
					if (moonLocalDate.getMonth().equals(month) && moonLocalDate.getYear() == year.getValue()
							&& moonLocalDate.getDayOfMonth() == dayofmonth) {
						FileInputStream inputstream = null;
						try {
							inputstream = new FileInputStream("C:\\Users\\gce\\Desktop\\blueIcon.png");
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						}
						Image moonImage = new Image(inputstream);

						ImageView imgView = new ImageView(moonImage);

						days.setGraphic(imgView);
					}
				}

			}
			con.close();
		}

		catch (Exception e) {
			System.out.println(e);
		}
	}

}
