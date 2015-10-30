import java.util.Calendar;



public class Date implements Comparable<Date>{
   private int day;
   private int month;
   private int year;
   /**
    * A default constructor that uses todays date to initialise the day, month and year.
    */
   public Date(){
	   Calendar rightNow = Calendar.getInstance();
	   this.day= rightNow.get(Calendar.DAY_OF_MONTH);
	   this.month=rightNow.get(Calendar.MONTH)+1;
	   this.year=rightNow.get(Calendar.YEAR);
   }
   /**
    * A constructor that accepts day, month and year parameters
    * @param day (between 1 and 28-31, depending on the month)
    * @param month (between 1 and 12)
    * @param year input year
    * throws IllegalArgumentException if the date is invalid
    */
   public Date(int day,int month,int year){
	   if (!isValidDate(month, day, year)) throw new IllegalArgumentException("Invalid date!");
	   
	   this.setDay(day);
	   this.setMonth(month);
	   this.setYear(year);
   }
   
   /**
    * A constructor that accepts an ISO 8601 date string as a parameter
    * @param date
    */
   public Date(String date){
	   String[] splitDateString = date.split("-");
       if (splitDateString.length != 3) {
           throw new IllegalArgumentException("Invalid date!");
       }
       this.day   = Integer.parseInt(splitDateString[0]);
       this.month = Integer.parseInt(splitDateString[1]);
       this.year  = Integer.parseInt(splitDateString[2]);
       if (!isValidDate(day,month, year)) throw new IllegalArgumentException("Invalid date!");
   }
   /**
    * set Day
    * @param day
    */
   public void setDay(int day) {
	   this.day = day;
   }
   /**
    * set Month
    * @param month
    */
   public void setMonth(int month) {
	   this.month = month;
   }
   /**
    * set Year
    * @param year
    */
   public void setYear(int year) {
	   this.year = year;
   }
   /**
    * get Day
    * @return
    */
   public int getDay() {
	   return day;
   }
   /**
    * get getMonthMonth
    * @return
    */
   public int getMonth() {
	   return month;
   }
   /**
    * get Year
    * @return
    */
   public int getYear() {
	   return year;
   }	
   /**
    * yyyy-MM-dd ISO 8601 format
    */
   @Override
   public String toString(){
	  return year+"-"+month+"-"+day;
   }
   /**
    * A method to compare the date with another
    */
   @Override
   public int compareTo(Date date) {
	   if (this.year  < date.year)  return -1;
       if (this.year  > date.year)  return +1;
       if (this.month < date.month) return -1;
       if (this.month > date.month) return +1;
       if (this.day   < date.day)   return -1;
       if (this.day   > date.day)   return +1;
       return 0;
   }
   /**
    * is Valid Date
    * @param month
    * @param day
    * @param year
    * @return
    */
   private boolean isValidDate(int day,int month, int year) {
	   final int[] days = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	   if (month < 1 || month > 12)      return false;
       if (day < 1 || day > days[month]) return false;
       if (month == 2 && day == 29 && !isLeapYear(year)) return false;
       return true;
   }
   /**
    * check if year is leap year
    * @param year
    * @return
    */
   private boolean isLeapYear(int year) {
	   if (year % 400 == 0) return true;
       if (year % 100 == 0) return false;
       return year % 4 == 0;
   }
   /**
    * Is this date before otherdate?
    * @return true if this date is before date otherdate; false otherwise
    */
   public boolean isEarlier (Date otherdate) {
       return compareTo(otherdate) < 0;
   } 
   
}
