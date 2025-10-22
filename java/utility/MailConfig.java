
package utility;

import configurations.Hooks;

public class MailConfig{
	
	public static String server="office365.etch.com";
	public static String from = "QA-automation@sgintl.com";
	public static String password = "";	
	
	public static String[] to = Hooks.mailTo;
	public static String[] cc = Hooks.mailCc;
		
	public static String subject = Hooks.mailSubject;	
	public static String messageBody = Hooks.mailmessageBody;
	
	public static String attachmentPath="./Result.xlsx";	
	public static String attachmentPath1="./target/report.html";
	public static String attachmentPath2="./logFiles/app.log";
	public static String attachmentName="Result.xlsx";
	public static String attachmentName1="Report.html";
	public static String attachmentName2="LogDetails.txt";
	
	public static void main(String[] args) throws Exception {
		MonitoringMail mail=new MonitoringMail();
		mail.sendMail(MailConfig.server, MailConfig.from, MailConfig.to, MailConfig.cc, MailConfig.subject, MailConfig.messageBody,
				MailConfig.attachmentPath, MailConfig.attachmentPath1, MailConfig.attachmentPath2,
				MailConfig.attachmentName, MailConfig.attachmentName1, MailConfig.attachmentName2);
	}
	
}
