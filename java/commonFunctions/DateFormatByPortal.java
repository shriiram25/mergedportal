package commonFunctions;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatByPortal {

	// <<<-- Get the Current Date with pattern based on portals
	public String getCurrentDateFormatByPortal(String portal) {
		portal = portal.toUpperCase();
		String pattern = "";

		if (portal.contains("VOLKSWAGEN") || portal.contains("AUDI") || portal.contains("DUCATI")
				|| portal.contains("QUALITYPROTECT") || portal.contains("ALPHERA") || portal.contains("HARLEY_US")) {
			pattern = "MM/dd/yyyy"; // mm/dd/yyyy
		} else if (portal.contains("PORSCHE") || portal.contains("BENTLEY") || portal.contains("LAMBORGHINI")
				|| portal.contains("HARLEY_CANADA") || portal.contains("VROOM") || portal.contains("BMW_MINI")
				|| portal.contains("MOTORRAD") || portal.contains("ROLLSROYCE") || portal.contains("PENSKE")
				|| portal.contains("FUCCILLO") || portal.contains("HONDA") || portal.contains("ACURA")) {
			pattern = "yyyy-MM-dd"; // yyyy-mm-dd
		} else {
			pattern = "yyyy-MM-dd";
		}

		SimpleDateFormat df = new SimpleDateFormat(pattern);
		Date dateobj = new Date();
		String currentDate = (df.format(dateobj));
		// System.out.println("Current Date is:- "+currentDate);

		return currentDate;
	}

}
