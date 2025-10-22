package configurations;

//Standard Cucumber Framework  
//Author: Harish K
//For: SGI QA Team
//For: EAS Portals Automation

import java.io.IOException;
import org.junit.runner.RunWith;

import annotations.AfterSuite;
import annotations.BeforeSuite;
import cucumber.api.CucumberOptions;
import utility.MailConfig;
import utility.MonitoringMail;
import utility.RemoveData;
import utility.Report;


@CucumberOptions(
		features = { "src/test/featurefiles" }, 
		plugin = { "pretty", "html:target/cucumber-html-report",
				"junit:target/cucumber-junit-report/allcukes.xml", "json:target/cucumber-report.json",
				"json:target/cucumber.json", "usage:target/cucumber-usage.json",
				"com.cucumber.listener.ExtentCucumberFormatter:target/report.html"},
		         tags= {" @SaveContract_Hyundai_QA,@RateLookUp,@RemitContract_Hyundai_QA,@SaveContract_Fuccillo_PROD "}
		          //tags= { "@RateLookUp" }
				//tags = {" @SaveContract_Hyundai_QA "} /*@SaveContract_Hyundai_QA @RemitContract_Hyundai_QA*/
				//tags = {" @SaveContract__US_portal_QUICK_Regression "}
		//tags = {" @SaveContract_Fuccillo_PROD "}//,@SaveContract_Vroom_PROD,@SaveContract_BMW-MINI_PROD,@SaveContract_HONDA-ACURA_PROD,@SaveContract_RollsRoyce_PROD,@SaveContract_Penske_PROD "}
		//tags = {" @SaveContract_Hyundai_PROD "} @SaveContract__US_portal_QUICK_Regression,
		//tags = {"  @SaveContract_Canadian_portal_QUICK_Regression, @SaveContract__US_portal_QUICK_Regression, @SaveContract_Hyundai_PROD  "}
		
		//tags = {"  @SaveContract_HD_CA_PROD,@SaveContract_HD_US_PROD,@SaveContract_VCI_PROD "}
		
		//tags = {" @SaveContract_PBL_CANADA_QA, @SaveContract_PBL_US_QA, @SaveContract_VCI_QA_2 "}
		
		//tags = {" @SaveContract_HD_US_PROD,@SaveContract_HD_CA_PROD,@SaveContract_HONDA-ACURA_PROD,@SaveContract_RollsRoyce_PROD,@SaveContract_Vroom_PROD,@SaveContract_VCI_PROD,@SaveContract_PBL_CANADA_PROD,@SaveContract_PBL_US_PROD,@SaveContract_Penske_PROD,@SaveContract_Fuccillo_PROD "}
		
		//tags = {" @SubmitContract__US_portal_QUICK_Regression,@SubmitContract_Canadian_portal_QUICK_Regression "}
		
		
	   //Legacy link
		//BMW savecontract,subcontract,vindecoding tags
		//tags = {" @SaveContractBMWR,@SubmitContractBMWR,@LegacyVinDecoderBMW  "}//   
		//tags = {"  @LegacySaveContractMINI,@LegacySubmitContractMINI, @LegacyVinDecoderMINI "}
		
		
		//Legacy Autonation savecontract,subcontract,vindecoding tags
		//tags = {" @LegacyANSaveContractAN, @LegacyANRemitContract,@LegacyANVinDecoder  "}//@LegacyANSaveContractAN, @LegacyANRemitContract,@LegacyANVinDecoder,@LegacyANCancellationQuote,@LegacyANCancellations    "}
		
		//Legacy Mercedes Benz savecontract,subcontract,vindecoding tags
		//		tags = {" @MB_USSaveContract_all, @MB_USSubmitContract_Regression,@MB_USVinDecoder "}
		
		//Legacy Honda savecontract tags.
		//		tags = {" @LegacyHondaSaveContract "}
		
		//Legacy toyota savecontact tag
		//tags = {" @LegacyToyotaSaveContract   "}// @LegacyToyotaSaveContract,@LegacyToyotaSubmitContract,@LegacyToyotaVinDecoder
		
         
		
	   //Legacy Agent portal savecontract Tag, submit contract ,Vindecoder
		//tags= {" @LegacyAgentVinDecoder"}//@AgentSaveContract @LegacyAgentVinDecoder @LegacyAgentSubmitContract
	
		
)

@RunWith(ExtendedCucumberRunner.class)
public class RunnerTest {

	@BeforeSuite                    // this will delete the already present data in result excel file
	public static void setUp() throws IOException {
		
		RemoveData objExcelFile = new RemoveData();
		objExcelFile.deleteExcel(System.getProperty("user.dir"), "Result.xlsx", "US_Portal_Report");
		objExcelFile.deleteExcel(System.getProperty("user.dir"), "Result.xlsx", "Canada_Portal_Report");
		objExcelFile.deleteExcel(System.getProperty("user.dir"), "Result.xlsx", "Login_Status_Report");
		objExcelFile.deleteExcel(System.getProperty("user.dir"), "Result.xlsx", "VIN_Decoding_Report");
		objExcelFile.deleteExcel(System.getProperty("user.dir"), "Result.xlsx", "Result");
		objExcelFile.deleteExcel(System.getProperty("user.dir"), "Result.xlsx", "RateLookUp");
		objExcelFile.deleteExcel(System.getProperty("user.dir"), "Result.xlsx", "Web_Remittance_Table");
		objExcelFile.deleteExcel(System.getProperty("user.dir"), "Result.xlsx", "web_con_m1_Table");
		objExcelFile.deleteExcel(System.getProperty("user.dir"), "Result.xlsx", "VIN_Decoding_Result");
		objExcelFile.deleteExcel(System.getProperty("user.dir"), "Result.xlsx", "CancellationResult");
		objExcelFile.deleteExcel(System.getProperty("user.dir"), "Result.xlsx", "Rate_Remit_Result");
		objExcelFile.deleteExcel(System.getProperty("user.dir"), "Result.xlsx", "MB_US_EContract_Result");
		
	}

	// this is to generate the report after the execution
	@AfterSuite            
	public static void tearDown() throws Exception {
		Report.reportGen();
		
		MonitoringMail mail = new MonitoringMail();		
		mail.sendMail(MailConfig.server, MailConfig.from, MailConfig.to, MailConfig.cc, MailConfig.subject,	MailConfig.messageBody, MailConfig.attachmentPath, MailConfig.attachmentPath1, MailConfig.attachmentPath2, MailConfig.attachmentName, MailConfig.attachmentName1, MailConfig.attachmentName2);
	}

}


