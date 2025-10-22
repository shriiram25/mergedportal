package nissaninfiniti.pageobjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.junit.Assert;
import configurations.Hooks;
import utility.Log;
import utility.CurrentDateSelection;
import utility.ExcelReadWrite;
import utility.GetScreenshot;

public class DealerTaxPage {
	
	public String webDealerCost=null;
	public String webDealerHST_GST=null;
	public String webDealerQST=null;	
	public String webDealerPST=null;
	public String DealerProvince=null;
	
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
	public WebElement dealerProvince;
	
	public String getWebDealerProvince()
	{
		DealerProvince=dealerProvince.getAttribute("value").trim();
		return DealerProvince;
	}
	
	public void verifyDealerTax(String ExpectedDealerCost, String ExpectedDealerHST_GST, String ExpectedDealerQST, String ExpectedDealerPST, String Province, String TestCase, String Portal, String Dealer, String VehicleID, String Product, String Coverage, String Term, String FirstName, String LastName, String Category)
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
			
			webDealerCost = webDealerCost.replace(",", "");			
			
			ExpectedDealerCost = ExpectedDealerCost.replace("$", "");
			//ExpectedDealerCost = ExpectedDealerCost.replace(",", "");
			
			//QVGS Forms
			if(Category.equalsIgnoreCase("QVGS-CAN")||Category.equalsIgnoreCase("QVGS-FR"))
			{
				if(webDealerCost.equalsIgnoreCase(ExpectedDealerCost.trim()) && webDealerHST_GST.equalsIgnoreCase(ExpectedDealerHST_GST.trim()))
				{
					if(Province.equalsIgnoreCase("QC"))
					{
						if(webDealerQST.equalsIgnoreCase(ExpectedDealerQST))
						{
							//System.out.println("In QVGS IF First IF BLOCK");
							status="Pass";
						}
					}
					else if(Province.equalsIgnoreCase("BC")||Province.equalsIgnoreCase("MB")||Province.equalsIgnoreCase("SK"))
					{
						if(webDealerPST.equalsIgnoreCase(ExpectedDealerPST))
						{
							//System.out.println("In QVGS IF Second IF BLOCK");
							status="Pass";
						}
					}
					else
					{
						//System.out.println("In QVGS IF Inside ELSE BLOCK");
						status="Pass";
					}					
				}
				else
				{
					//System.out.println("QVGS Outside ELSE BLOCK");
					status="Fail";
				}
			} 
			//Non QVGS Forms
			else 
			{
				DealerProvince=getWebDealerProvince();
				
				if(webDealerCost.equalsIgnoreCase(ExpectedDealerCost.trim()) && webDealerHST_GST.equalsIgnoreCase(ExpectedDealerHST_GST.trim()))
				{
					if(Province.equalsIgnoreCase("QC")||Province.equalsIgnoreCase("BC")||Province.equalsIgnoreCase("MB")||Province.equalsIgnoreCase("SK")||Province.equalsIgnoreCase("NB")||Province.equalsIgnoreCase("NU")||Province.equalsIgnoreCase("ON")||Province.equalsIgnoreCase("PE")||Province.equalsIgnoreCase("NS")||Province.equalsIgnoreCase("NT"))		
					{
				
						if(Province.equalsIgnoreCase("QC"))
						{
							if(webDealerQST.equalsIgnoreCase(ExpectedDealerQST))
							{
								//System.out.println("In IF First IF BLOCK");
								status="Pass";
							}
						}
						else if(Province.equalsIgnoreCase("BC")||Province.equalsIgnoreCase("MB")||Province.equalsIgnoreCase("SK"))
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
						if(DealerProvince.equalsIgnoreCase("QC"))
						{
							if(webDealerQST.equalsIgnoreCase(ExpectedDealerQST))
							{
								//System.out.println("In ELSE First IF BLOCK");
								status="Pass";
							}
						}
						else if(DealerProvince.equalsIgnoreCase("BC")||DealerProvince.equalsIgnoreCase("MB")||DealerProvince.equalsIgnoreCase("SK"))
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
			}
			
			/*System.out.println("Status:- "+status);
			System.out.println("ExpectedDealerCost:- "+ExpectedDealerCost);
			System.out.println("ExpectedDealerHST_GST:- "+ExpectedDealerHST_GST);
			System.out.println("ExpectedDealerQST:- "+ExpectedDealerQST);
			System.out.println("ExpectedDealerPST:- "+ExpectedDealerPST);*/
		
			String[] valueToWriteNew=null;
			valueToWriteNew = new String[21];
			valueToWriteNew[0]=TestCase;
			valueToWriteNew[1]=Portal;
			valueToWriteNew[2]=Dealer;
			valueToWriteNew[3]=VehicleID;
			valueToWriteNew[4]=Product;
			valueToWriteNew[5]=Coverage;
			valueToWriteNew[6]=Term;
			valueToWriteNew[7]=FirstName;
			valueToWriteNew[8]=LastName;
			valueToWriteNew[9]=Province;
			valueToWriteNew[10]=DealerProvince;
			valueToWriteNew[11]=ExpectedDealerCost;
			valueToWriteNew[12]=webDealerCost;
			valueToWriteNew[13]=ExpectedDealerHST_GST;
			valueToWriteNew[14]=webDealerHST_GST;
			valueToWriteNew[15]=ExpectedDealerPST;
			valueToWriteNew[16]=webDealerPST;
			valueToWriteNew[17]=ExpectedDealerQST;
			valueToWriteNew[18]=webDealerQST;
			valueToWriteNew[19]=status;
			valueToWriteNew[20]=CurrentDateSelection.getCurrentDate();
			
			
			ExcelReadWrite ERW=new ExcelReadWrite();
		
			ERW.writeExcelForm(System.getProperty("user.dir"), "result.xlsx", "Dealer_Tax_Result",valueToWriteNew);
			
			Log.log.debug("Verify Dealer Tax as:-");
    		Log.log.debug("Expected Dealer Cost as:- "+ExpectedDealerCost);
    		Log.log.debug("Actual Dealer Cost as:- "+webDealerCost);
    		Log.log.debug("Expected Dealer HST_GST as:- "+ExpectedDealerHST_GST);
    		Log.log.debug("Actual Dealer HST_GST as:- "+webDealerHST_GST);    		
    		Log.log.debug("Actual Dealer QST as:- "+webDealerQST);
    		Log.log.debug("Status:- "+status);
			
		} catch (IOException e) {
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
		
	}
	
}
