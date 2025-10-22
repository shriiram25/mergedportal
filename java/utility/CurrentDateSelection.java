package utility;
 
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class CurrentDateSelection {
	
	public static String getCurrentDate()
	{
		DateFormat df = new SimpleDateFormat("YYYY-MM-dd");
		df.setTimeZone(TimeZone.getTimeZone("US/Eastern"));
		return df.format(new Date());

	}
	
	public static void main(String[] args) {
		String date=CurrentDateSelection.getCurrentDate();
			System.out.println(date);	
	}

}
