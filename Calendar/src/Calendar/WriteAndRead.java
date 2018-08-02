package Calendar;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WriteAndRead {

	WriteAndRead(Button days, DayOfWeek dayofWeek, int daynumber, int year, Month month) {
		days.setOnAction(event -> {

			Group root = new Group();
			Stage stage = new Stage();

			TextArea ta = new TextArea();
			Button buttonSave = new Button("Save");
			Button buttonDelete = new Button("Delete");
	
			try {
				ReadFromServer(ta, year, month, daynumber);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				

			writeToServer(buttonSave, ta, year, month, daynumber);
			DeleteFromServer(buttonDelete, year, month, daynumber);

			VBox vBox = new VBox();
			
			vBox.getChildren().addAll(ta, buttonSave, buttonDelete);

			root.getChildren().add(vBox);

			stage.setTitle("Events For Today: ");
			stage.setScene(new Scene(root, 450, 500));
			stage.show();
		});
	}

	private void DeleteFromServer(Button delete, int year, Month month, int day) {
		delete.setOnAction(event -> {
			
			LocalDate ldTemp = LocalDate.of(year, month, day);
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/calendargce", "root", "");
				Statement stmt = con.createStatement();
				String sql = "DELETE FROM `eventhandle` WHERE EventDate = '" + ldTemp + "';";

				@SuppressWarnings("unused")
				int rs = stmt.executeUpdate(sql);

				con.close();

			}

			catch (Exception e) {
				System.out.println(e);
			}
			
		});
	}
	
	private void writeToServer(Button save, TextArea ta, int year, Month month, int day) {
		save.setOnAction(event2 -> {

			LocalDate ldTemp = LocalDate.of(year, month, day);
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/calendargce", "root", "");
				Statement stmt = con.createStatement();
				String sql = "INSERT INTO `eventhandle` (`EventID`, `EventNote`,`EventDate`) VALUES (NULL, '"
						+ ta.getText() + "', '" + ldTemp + "' )";

				@SuppressWarnings("unused")
				int rs = stmt.executeUpdate(sql);

				con.close();

			}

			catch (Exception e) {
				System.out.println(e);
			}

		});

	}

	private void ReadFromServer(TextArea ta, int year, Month month, int day) throws IOException {
		try {

			LocalDate ldTemp = LocalDate.of(year, month, day);
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/calendargce", "root", "");
			Statement stmt = con.createStatement();
			String sql = "select EventNote from eventhandle where EventDate = '" + ldTemp + "';";
			ResultSet rs = stmt.executeQuery(sql);

			try {
				while (rs.next()) {
					String note = rs.getString("EventNote");

					ta.appendText(note);

				}
				con.close();
			} catch (Exception e) {

			}
		}

		catch (Exception e) {
			System.out.println(e);
		}
	}
}
