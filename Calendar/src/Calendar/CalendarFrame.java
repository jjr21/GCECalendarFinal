package Calendar;

import java.time.Month;
import java.time.Year;
import java.time.YearMonth;

// import Events.Holiday;
import Events.HolidayEnum;

import java.time.DayOfWeek;
import java.time.LocalDate;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class CalendarFrame extends Application {

	private LocalDate ld = LocalDate.now();
	private Month month = ld.getMonth();
	private Year year = Year.of(2018);

	// create the grid
	@Override
	public void start(Stage primaryStage) {

		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(2);
		grid.setVgap(2);

		createCalendar(grid);

		Scene scene = new Scene(grid, 900, 500);
		scene.getStylesheets().add(CalendarFrame.class.getResource("CalendarFrame.css").toExternalForm());

		primaryStage.setTitle("Calendar ");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	// fill the grid with info
	private void createCalendar(GridPane grid) {

		MoonPhase mp = new MoonPhase();
		ColorEvent ce = new ColorEvent();
		HolidayEnum h = HolidayEnum.CHRISTMAS;
		DayOfWeek day = DayOfWeek.SUNDAY;
		YearMonth ym = YearMonth.of(year.getValue(), month);
		boolean isOtherDays = false;

		// create the month label
		Label lMonth = new Label(month.toString());
		lMonth.setAlignment(Pos.CENTER);
		lMonth.setFont(Font.font("Tahoma", FontWeight.BOLD, 19));
		lMonth.setTextFill(Color.BLACK);
		lMonth.setStyle("-fx-background-color: grey");
		lMonth.setOpacity(0.98);
		lMonth.setPrefWidth(105);
		grid.add(lMonth, 3, 0);

		// create year label
		Label yL = new Label(year.toString());
		yL.setAlignment(Pos.CENTER);
		yL.setFont(Font.font("Tahoma", FontWeight.BOLD, 17));
		yL.setTextFill(Color.BLACK);
		yL.setStyle("-fx-background-color: grey");
		yL.setOpacity(0.98);
		yL.setPrefWidth(105);
		grid.add(yL, 3, 1);

		Button days = null;

		// create label for each day of week
		for (int i = 0; i < 7; i++) {

			if (i > 0)
				day = day.plus(1);
			Label lDay = new Label(day.toString());
			lDay.setAlignment(Pos.CENTER);
			lDay.setFont(Font.font("Tahoma", FontWeight.LIGHT, 17));
			lDay.setTextFill(Color.MEDIUMBLUE);
			lDay.setStyle("-fx-background-color: grey");
			lDay.setOpacity(0.98);
			lDay.setPrefWidth(105);
			grid.add(lDay, i, 2);
		}

		day = DayOfWeek.SUNDAY;
		// set x to equal the first day of the month;
		int x = ym.atDay(1).getDayOfWeek().getValue();
		int y = 0;

		// create blank spaces for previous month's days
		if (x < 7) {
			isOtherDays = true;
			for (int j = 0; j < x; j++) {

				day = day.plus(1);
				Label blankdays = new Label();
				blankdays.setFont(Font.font("Tahoma", FontWeight.LIGHT, 10));
				blankdays.setAlignment(Pos.TOP_LEFT);
				blankdays.setTextFill(Color.DIMGREY);
				blankdays.setPrefWidth(105);
				blankdays.setMinHeight(60);
				blankdays.setStyle("-fx-background-color: white");
				blankdays.setOpacity(.75);
				grid.add(blankdays, j, 3);

			}
		}

		// create current month's days
		for (int i = 0; i < ym.lengthOfMonth(); i++) {
			// make new week
			if (x == 7) {
				x = 0;
				y++;
			}

			day = day.plus(1);
			days = new Button(
					"" + (i + 1) + "\n\n  " + h.getBankHoliday(year.getValue(), month.getValue(), i, ym.atDay(1).getDayOfWeek().getValue()));

			days.setAlignment(Pos.TOP_LEFT);
			days.setPrefWidth(105);
			days.setMinHeight(60);
			days.setOpacity(.98);
			grid.add(days, x, (isOtherDays) ? 3 + y : 2 + y);

			x++;

			@SuppressWarnings("unused")
			WriteAndRead war = new WriteAndRead(days, day, (i + 1), year.getValue(), month);
			mp.moonMethod(days, (i + 1), year, month);
			ce.setColorEvent(days, (i+1), year, month);
			createButtons(grid);
		}
	}

	private void createButtons(GridPane grid) {
		// button for previous month
		Button prev = new Button("<<");
		GridPane.setHalignment(prev, HPos.RIGHT);
		grid.add(prev, 2, 0);
		prev.setOnAction(event -> {
			if (month.equals(Month.JANUARY))
				year = year.minusYears(1);
			month = month.minus(1);
			grid.getChildren().clear();
			createCalendar(grid);
		});

		// button for next month
		Button next = new Button(">>");
		grid.add(next, 4, 0);
		next.setOnAction(event -> {
			if (month.equals(Month.DECEMBER))
				year = year.plusYears(1);
			month = month.plus(1);
			grid.getChildren().clear();
			createCalendar(grid);
		});

		// button for prev year
		Button prevY = new Button("<<");
		GridPane.setHalignment(prevY, HPos.RIGHT);
		grid.add(prevY, 2, 1);
		prevY.setOnAction(event -> {
			year = year.minusYears(1);
			grid.getChildren().clear();
			createCalendar(grid);
		});

		// button for next year
		Button nextY = new Button(">>");
		grid.add(nextY, 4, 1);
		nextY.setOnAction(event -> {
			year = year.plusYears(1);
			grid.getChildren().clear();
			createCalendar(grid);
		});
	}

	// starts the application
	public static void main(String[] args) {
		// CalendarFrame cf = new CalendarFrame();
		// cf.testEqualDate();
		launch(args);

	}

}