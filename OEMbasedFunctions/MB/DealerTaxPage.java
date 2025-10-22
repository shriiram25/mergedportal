package MB;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;
import utility.CurrentDateSelection;
import utility.ExcelReadWrite;
import utility.GetScreenshot;
import utility.Log;
import configurations.Hooks;

public class DealerTaxPage {
	
	public String webDealerCost=null;
	public String webDealerHST_GST=null;
	public String webDealerQST=null;	
	public String webDealerPST=null;
	public String DealerState=null;
	
	public WebDriver driver;
	
	public DealerTaxPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="web_con_dealercost")
	public WebElement dealerCost;
	
	public String getWebDealerCost()
	{
		webDealerCost=dealerCost.getAttribute("value").trim();
		return webDealerCost;
	}
	
	@FindBy(id="web_con_dc_hst_gst")
	public WebElement dealerHST_GST;
	
	public String getWebDealerHST_GST()
	{
		webDealerHST_GST=dealerHST_GST.getAttribute("value").trim();
		return webDealerHST_GST;
	}
	
	@FindBy(id="web_con_dc_qst")
	public WebElement dealerQST;
	
	public String getWebDealerQST()
	{
		webDealerQST=dealerQST.getAttribute("value").trim();
		return webDealerQST;
	}
	
	@FindBy(id="web_con_dc_pst")
	public WebElement dealerPST;
	
	public String getWebDealerPST()
	{
		webDealerPST=dealerPST.getAttribute("value").trim();
		return webDealerPST;
	}
	
	@FindBy(id="web_con_dealer_state")
	public WebElement dealerState;
	
	public String getWebDealerProvince()
	{
		DealerState=dealerState.getAttribute("value").trim();
		return DealerState;
	}
	
	public void verifyDealerTax(String ExpectedDealerCost, String ExpectedDealerHST_GST, String ExpectedDealerQST, String ExpectedDealerPST, String State, String TestCase, String Dealer, String VehicleID, String Product, String Coverage, String Term, String FirstName, String LastName, String Category)
	{
		try {
			
			String status=null;
		
			webDealerCost = getWebDealerCost();
			webDealerHST_GST = getWebDealerHST_GST();
			webDealerQST = getWebDealerQST();
			webDealerPST = getWebDealerPST();
					
			/*System.out.println("webDealerCost:- "+webDealerCost);
			System.out.println("webDealerHST_GST:- "+webDealerHST_GST);
			System.out.println("webDealerQST:- "+webDealerQST);
			System.out.println("webDealerPST:- "+webDealerPST);*/
						
			ExpectedDealerCost = ExpectedDealerCost.replace("$", "");
					
			DealerState=getWebDealerProvince();
			
			if(webDealerCost.equalsIgnoreCase(ExpectedDealerCost.trim()) && webDealerHST_GST.equalsIgnoreCase(ExpectedDealerHST_GST.trim()))
			{
				if(State.equalsIgnoreCase("QC")||State.equalsIgnoreCase("BC")||State.equalsIgnoreCase("MB")||State.equalsIgnoreCase("SK")||State.equalsIgnoreCase("NB")||State.equalsIgnoreCase("NU")||State.equalsIgnoreCase("ON")||State.equalsIgnoreCase("PE")||State.equalsIgnoreCase("NS")||State.equalsIgnoreCase("NT"))		
				{
			
					if(State.equalsIgnoreCase("QC"))
					{
						if(webDealerQST.equalsIgnoreCase(ExpectedDealerQST))
						{
							//System.out.println("In IF First IF BLOCK");
							status="Pass";
						}
					}
					else if(State.equalsIgnoreCase("BC")||State.equalsIgnoreCase("MB")||State.equalsIgnoreCase("SK"))
					{
						if(webDealerPST.equalsIgnoreCase(ExpectedDealerPST))
						{
							//System.out.println("In IF Second IF BLOCK");
							status="Pass";
						}
					}
					else
					{
						//System.out.println("In IF Inside ELSE BLOCK");
						status="Pass";
					}
		
				}
				else
				{
					if(DealerState.equalsIgnoreCase("QC"))
					{
						if(webDealerQST.equalsIgnoreCase(ExpectedDealerQST))
						{
							//System.out.println("In ELSE First IF BLOCK");
							status="Pass";
						}
					}
					else if(DealerState.equalsIgnoreCase("BC")||DealerState.equalsIgnoreCase("MB")||DealerState.equalsIgnoreCase("SK"))
					{
						if(webDealerPST.equalsIgnoreCase(ExpectedDealerPST))
						{
							//System.out.println("In ELSE Second IF BLOCK");
							status="Pass";
						}
					}
					else
					{
						//System.out.println("In ELSE Inside ELSE BLOCK");
						status="Pass";
					}
				}
			}
			else
			{
				//System.out.println("Outside ELSE BLOCK");
				status="Fail";
			}
						
			/*System.out.println("Status:- "+status);
			System.out.println("ExpectedDealerCost:- "+ExpectedDealerCost);
			System.out.println("ExpectedDealerHST_GST:- "+ExpectedDealerHST_GST);
			System.out.println("ExpectedDealerQST:- "+ExpectedDealerQST);
			System.out.println("ExpectedDealerPST:- "+ExpectedDealerPST);*/
		
			String[] valueToWriteNew=null;
			valueToWriteNew = new String[20];
			valueToWriteNew[0]=TestCase;			
			valueToWriteNew[1]=Dealer;
			valueToWriteNew[2]=VehicleID;
			valueToWriteNew[3]=Product;
			valueToWriteNew[4]=Coverage;
			valueToWriteNew[5]=Term;
			valueToWriteNew[6]=FirstName;
			valueToWriteNew[7]=LastName;
			valueToWriteNew[8]=State;
			valueToWriteNew[9]=DealerState;
			valueToWriteNew[10]=ExpectedDealerCost;
			valueToWriteNew[11]=webDealerCost;
			valueToWriteNew[12]=ExpectedDealerHST_GST;
			valueToWriteNew[13]=webDealerHST_GST;
			valueToWriteNew[14]=ExpectedDealerPST;
			valueToWriteNew[15]=webDealerPST;
			valueToWriteNew[16]=ExpectedDealerQST;
			valueToWriteNew[17]=webDealerQST;
			valueToWriteNew[18]=status;
			valueToWriteNew[19]=CurrentDateSelection.getCurrentDate();
			
			
			ExcelReadWrite ERW=new ExcelReadWrite();
		
			ERW.writeExcelForm(System.getProperty("user.dir"), "result.xlsx", "Dealer_Tax_Result",valueToWriteNew);
			
			Log.log.debug("Verify Dealer Tax as:-");
    		Log.log.debug("Expected Dealer Cost as:- "+ExpectedDealerCost);
    		Log.log.debug("Actual Dealer Cost as:- "+webDealerCost);
    		Log.log.debug("Expected Dealer HST_GST as:- "+ExpectedDealerHST_GST);
    		Log.log.debug("Actual Dealer HST_GST as:- "+webDealerHST_GST);   
    		Log.log.debug("Expected Dealer PST as:- "+ExpectedDealerPST);
    		Log.log.debug("Actual Dealer PST as:- "+webDealerPST);
    		Log.log.debug("Expected Dealer QST as:- "+ExpectedDealerQST);
    		Log.log.debug("Actual Dealer QST as:- "+webDealerQST);
    		Log.log.debug("Status:- "+status);
			
		} catch (IOException e) {
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
		
	}
	
}
