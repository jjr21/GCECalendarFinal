
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;

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

public class draft extends Application {
	
  private static LocalDate ld = LocalDate.now();
  private Month month = ld.getMonth();
  private Year year = Year.of(2018);
  private static LocalDate moonDate;

  private final int moonFunc = 29;
  // create the grid
  @Override
  public void start(Stage primaryStage) {

    GridPane grid = new GridPane();
    grid.setAlignment(Pos.CENTER);
    grid.setHgap(5);
    grid.setVgap(5);


    createCalendar(grid);

    grid.setGridLinesVisible(false);

    Scene scene = new Scene(grid, 900, 500);
  //scene.getStylesheets().add(Calendar.class.getResource("CalendarFrame.css").toExternalForm());

    primaryStage.setTitle("Calendar");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  // fill the grid with info
  public void createCalendar(GridPane grid) {
	//  System.out.println("Moon Date: " + moonDate);
	 
    DayOfWeek day = DayOfWeek.SUNDAY;
   month = ld.getMonth();
    YearMonth ym = YearMonth.of(year.getValue(), month);
    MoonFunction();

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

    
    //set x to equal the first day of the month;
    int x = ym.atDay(1).getDayOfWeek().getValue();
    
    int y = 0;
    

    for (int i = 0; i < ym.lengthOfMonth(); i++) {
      
      //make new week
      if (x == 7) {
        x = 0;
        y++;
      }
      
      Label days = new Label("" + (i + 1));
      days.setFont(Font.font("Tahoma", FontWeight.LIGHT, 10));
      days.setAlignment(Pos.TOP_LEFT);
      days.setTextFill(Color.DIMGREY);
      days.setPrefWidth(105);
      days.setMinHeight(60);
      days.setStyle("-fx-background-color: white");
      days.setOpacity(.98);
      
      grid.add(days, x, 3 + y);
      x++;
      
    }

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
  public static void setCurrentDay() {
	  
  }
  public static void MoonFunction() {
	  System.out.println(ld);
	   moonDate = LocalDate.of(2018, 7, 27);

  }
  

  // starts the application
  public static void main(String[] args) {
	 
    launch(args);
   
  }
}
