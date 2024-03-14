

package extentReport;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

//final -> We do not want any class to extend this class
public final class DateUtils {

    private DateUtils() {
    }

   
    public static String getCurrentDate() {
        Date date = new Date();
        return date.toString().replace(":", "_").replace(" ", "_");
    }  
   
    public static String getCurrentDateTime() {
        Date now = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return formatter.format(now);
    }
    
    public static String getCurrentDateTimeYYYYMMDD() {
        Date now = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(now);
    }

	public static String addDatesToCurrentDate(int no_of_days) {
              
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        Calendar cal =  Calendar.getInstance();
        cal.add(cal.DAY_OF_MONTH, no_of_days);
        String format = formatter.format(cal.getTime());
        return format;
       
    }
    public static String getCurrentDateInMMddyyyyFormat() {
        Date now = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        return formatter.format(now);
    }
    public static String getCurrentDateTimeCustom(String separator_Character) {
        Date now = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String timeStamp = formatter.format(now).replace("/", separator_Character);
        timeStamp = timeStamp.replace(" ", separator_Character);
        timeStamp = timeStamp.replace(":", separator_Character);
        return timeStamp;
    }
    public static String convertStringToDateMMM_ddFormat(String date) throws ParseException {
    	 SimpleDateFormat formatter1 = new SimpleDateFormat("MMM dd", Locale.ENGLISH);
    	 String[] split = date.split(",");
//    	 "Tue, Sep 5"
    	String wholeDate =  split[1].trim();
//    	String[] split2 = wholeDate.split(" ");
    	 Date dateValue1 =  formatter1.parse(wholeDate);
    	 System.out.println("DateValue :: "+dateValue1);
    	String format = formatter1.format(dateValue1);
//    	String parse = formatter1.format(format);
    	
    	SimpleDateFormat formatter2 = new SimpleDateFormat("dd-MM-yyyy");
    	
    	String format2 = formatter2.format(dateValue1);
    	System.out.println("format:"+format2);
    	Date parse = formatter2.parse(format2);
    	System.out.println("parse: "+parse);
    	
        return format;
    }
}
