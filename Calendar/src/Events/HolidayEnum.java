package Events;

public enum HolidayEnum {

	  NEWYEARS("New Years Day"), 
	  MLK("Martin Luther King Day"), 
	  PRESIDENTS("President's Day"), 
	  EASTER("Easter Sunday"), 
	  MEMORIALOBS("Mem. Day Obs"), 
	  INDEPENDENCE("Ind. Day"), 
	  LABOR("Labor Day"), 
	  COLUMBUS("Columbus Day*"), 
	  VETERANS("Veteran's Day"),
	  THANKSGIVING("Thanksgiving"),
	  CHRISTMASEVE("Christmas Eve"), 
	  CHRISTMAS("Christmas Day"), 
	  NEWYEARSEVE("New Year's Eve");

	  HolidayEnum(String holidayName) {
	    this.setHolidayName(holidayName);
	  }

	  private String holidayName;

	  HolidayEnum holidays;
	  
	  public String getHolidayName() {
	    return holidayName;
	  }

	  public void setHolidayName(String holidayName) {
	    this.holidayName = holidayName;
	  }

	  public String getBankHoliday(int year, int month, int day, int firstDay) {

	    if (month == 1 && day == 0) {
	      holidays = NEWYEARS;
	      return holidays.getHolidayName();
	    }

	    // check mlk 45- 88
	    switch (firstDay) {
	      case 1:
	        if (month == 1 && day == 14) {
	          holidays = MLK;
	          return holidays.getHolidayName();
	        }
	        break;
	      case 2:
	        if (month == 1 && day == 20) {
	          holidays = MLK;
	          return holidays.getHolidayName();
	        }
	        break;
	      case 3:
	        if (month == 1 && day == 19) {
	          holidays = MLK;
	          return holidays.getHolidayName();
	        }
	        break;
	      case 4:
	        if (month == 1 && day == 18) {
	          holidays = MLK;
	          return holidays.getHolidayName();
	        }
	        break;
	      case 5:
	        if (month == 1 && day == 17) {
	          holidays = MLK;
	          return holidays.getHolidayName();
	        }
	        break;
	      case 6:
	        if (month == 1 && day == 16) {
	          holidays = MLK;
	          return holidays.getHolidayName();
	        }
	        break;
	      case 7:
	        if (month == 1 && day == 15) {
	          holidays = MLK;
	          return holidays.getHolidayName();
	        }
	        break;
	    }

	    // check Presidents Day 91 - 134
	    switch (firstDay) {
	      case 1:
	        if (month == 2 && day == 14) {
	          holidays = PRESIDENTS;
	          return holidays.getHolidayName();
	        }
	        break;
	      case 2:
	        if (month == 2 && day == 20) {
	          holidays = PRESIDENTS;
	          return holidays.getHolidayName();
	        }
	        break;
	      case 3:
	        if (month == 2 && day == 19) {
	          holidays = PRESIDENTS;
	          return holidays.getHolidayName();
	        }
	        break;
	      case 4:
	        if (month == 2 && day == 18) {
	          holidays = PRESIDENTS;
	          return holidays.getHolidayName();
	        }
	        break;
	      case 5:
	        if (month == 2 && day == 17) {
	          holidays = PRESIDENTS;
	          return holidays.getHolidayName();
	        }
	        break;
	      case 6:
	        if (month == 2 && day == 16) {
	          holidays = PRESIDENTS;
	          return holidays.getHolidayName();
	        }
	        break;
	      case 7:
	        if (month == 2 && day == 15) {
	          holidays = PRESIDENTS;
	          return holidays.getHolidayName();
	        }
	        break;
	    }

	    // check memorial day 136 - 180
	    switch (firstDay) {
	      case 1:
	        if (month == 5 && day == 28) {
	          holidays = MEMORIALOBS;
	          return holidays.getHolidayName();
	        }
	        break;
	      case 2:
	        if (month == 5 && day == 27) {
	          holidays = MEMORIALOBS;
	          return holidays.getHolidayName();
	        }
	        break;
	      case 3:
	        if (month == 5 && day == 26) {
	          holidays = MEMORIALOBS;
	          return holidays.getHolidayName();
	        }
	        break;
	      case 4:
	        if (month == 5 && day == 25) {
	          holidays = MEMORIALOBS;
	          return holidays.getHolidayName();
	        }
	        break;
	      case 5:
	        if (month == 5 && day == 24) {
	          holidays = MEMORIALOBS;
	          return holidays.getHolidayName();
	        }
	        break;
	      case 6:
	        if (month == 5 && day == 30) {
	          holidays = MEMORIALOBS;
	          return holidays.getHolidayName();
	        }
	        break;
	      case 7:
	        if (month == 5 && day == 29) {
	          holidays = MEMORIALOBS;
	          return holidays.getHolidayName();
	        }
	        break;
	    }

	    // check Labor Day 181 - 225
	    switch (firstDay) {
	      case 1:
	        if (month == 9 && day == 0) {
	          holidays = LABOR;
	          return holidays.getHolidayName();
	        }
	        break;
	      case 2:
	        if (month == 9 && day == 6) {
	          holidays = LABOR;
	          return holidays.getHolidayName();
	        }
	        break;
	      case 3:
	        if (month == 9 && day == 5) {
	          holidays = LABOR;
	          return holidays.getHolidayName();
	        }
	        break;
	      case 4:
	        if (month == 9 && day == 4) {
	          holidays = LABOR;
	          return holidays.getHolidayName();
	        }
	        break;
	      case 5:
	        if (month == 9 && day == 3) {
	          holidays = LABOR;
	          return holidays.getHolidayName();
	        }
	        break;
	      case 6:
	        if (month == 9 && day == 2) {
	          holidays = LABOR;
	          return holidays.getHolidayName();
	        }
	        break;
	      case 7:
	        if (month == 9 && day == 1) {
	          holidays = LABOR;
	          return holidays.getHolidayName();
	        }
	        break;
	    }
	    
	    // check columbus day line 228 - 271
	    switch (firstDay) {
	      case 1:
	        if (month == 10 && day == 7) {
	          holidays = COLUMBUS;
	          return holidays.getHolidayName();
	        }
	        break;
	      case 2:
	        if (month == 10 && day == 6) {
	          holidays = COLUMBUS;
	          return holidays.getHolidayName();
	        }
	        break;
	      case 3:
	        if (month == 10 && day == 5) {
	          holidays = COLUMBUS;
	          return holidays.getHolidayName();
	        }
	        break;
	      case 4:
	        if (month == 10 && day == 4) {
	          holidays = COLUMBUS;
	          return holidays.getHolidayName();
	        }
	        break;
	      case 5:
	        if (month == 10 && day == 3) {
	          holidays = COLUMBUS;
	          return holidays.getHolidayName();
	        }
	        break;
	      case 6:
	        if (month == 10 && day == 2) {
	          holidays = COLUMBUS;
	          return holidays.getHolidayName();
	        }
	        break;
	      case 7:
	        if (month == 10 && day == 1) {
	          holidays = COLUMBUS;
	          return holidays.getHolidayName();
	        }
	        break;
	    }
	    
	    // check Thanksgiving lines 274 - 317
	    switch(firstDay) {
	      case 1:
	        if(month == 11 && day == 24) {
	          holidays = THANKSGIVING;
	          return holidays.getHolidayName();
	        }
	        break;
	      case 2:
	        if(month == 11 && day == 23) {
	          holidays = THANKSGIVING;
	          return holidays.getHolidayName();
	        }
	        break;
	      case 3:
	        if(month == 11 && day == 22) {
	          holidays = THANKSGIVING;
	          return holidays.getHolidayName();
	        }
	        break;
	      case 4:
	        if(month == 11 && day == 21) {
	          holidays = THANKSGIVING;
	          return holidays.getHolidayName();
	        }
	        break;
	      case 5:
	        if(month == 11 && day == 27) {
	          holidays = THANKSGIVING;
	          return holidays.getHolidayName();
	        }
	        break;
	      case 6:
	        if(month == 11 && day == 26) {
	          holidays = THANKSGIVING;
	          return holidays.getHolidayName();
	        }
	        break;
	      case 7:
	        if(month == 11 && day == 25 ) {
	          holidays = THANKSGIVING;
	          return holidays.getHolidayName();
	        }
	        break;
	    }
	    
	    // easter
	    if (findEasterDay(year) == (day + 1) && findEasterMonth(year) == month) {
	      holidays = EASTER;
	      return holidays.getHolidayName();
	    }

	    // independance day
	    if (month == 7 && day == 3) {
	      holidays = INDEPENDENCE;
	      return holidays.getHolidayName();
	    }

	    // vet day
	    if (month == 11 && day == 10) {
	      holidays = VETERANS;
	      return holidays.getHolidayName();
	    }

	    // christmas eve
	    if (month == 12 && day == 23) {
	      holidays = CHRISTMASEVE;
	      return holidays.getHolidayName();
	    }
	    
	    // christmas day
	    if (month == 12 && day == 24) {
	      holidays = CHRISTMAS;
	      return holidays.getHolidayName();
	    }

	    // new years eve
	    if (month == 12 && day == 30) {
	      holidays = NEWYEARSEVE;
	      return holidays.getHolidayName();
	    }

	    return "";
	  }

	  public int findEasterDay(int year) {

	    int c = year / 100;
	    int n = year - 19 * (year / 19);
	    int k = (c - 17) / 25;
	    int i = c - c / 4 - (c - k) / 3 + 19 * n + 15;
	    i = i - 30 * (i / 30);
	    i = i - (i / 28) * (1 - (i / 28) * (29 / (i + 1)) * ((21 - n) / 11));
	    int j = year + year / 4 + i + 2 - c + c / 4;
	    j = j - 7 * (j / 7);
	    int l = i - j;
	    int m = 3 + (l + 40) / 44;
	    int d = l + 28 - 31 * (m / 4);
	    return d;
	  }

	  public int findEasterMonth(int year) {

	    int c = year / 100;
	    int n = year - 19 * (year / 19);
	    int k = (c - 17) / 25;
	    int i = c - c / 4 - (c - k) / 3 + 19 * n + 15;
	    i = i - 30 * (i / 30);
	    i = i - (i / 28) * (1 - (i / 28) * (29 / (i + 1)) * ((21 - n) / 11));
	    int j = year + year / 4 + i + 2 - c + c / 4;
	    j = j - 7 * (j / 7);
	    int l = i - j;
	    int m = 3 + (l + 40) / 44;
	    return m;
	  }
	}
  