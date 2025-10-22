package nissaninfiniti.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.junit.Assert;
import configurations.Hooks;
import utility.CurrentDateSelection;
import utility.ExcelReadWrite;
import utility.GetScreenshot;
import utility.Log;

public class VerifyDealerCostPage {
	
	public String status=null;
	
	public WebDriver driver;
	
	public VerifyDealerCostPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="econRemitTable")
	public WebElement eTable;
	
	public String[] veryfyDealerCost(String FirstName, String LastName, String VehicleID, String ExpDealerCost, String TestCase, String Portal,  String Dealer, String Product, String Coverage, String Term)
	{
		
		String webDealerCost=null;
		String status=null;
		
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("econRemitTable")));
			wait.until(ExpectedConditions.visibilityOf(eTable));
			
			List<WebElement> tagList=eTable.findElements(By.tagName("tbody"));
			if(tagList.size()>0)
			{
				//System.out.println("tagListSIZE:- "+tagList.size());
				List<WebElement> trList=tagList.get(0).findElements(By.tagName("tr"));
				if(trList.size()>0)
				{
					//System.out.println("trListSize:- "+trList.size());
					for(int i=0;i<trList.size();i++)
					{
						List<WebElement> tdList=trList.get(i).findElements(By.tagName("td"));
						//System.out.println("tdListSize:- "+tdList.size());
						String WebLastName=tdList.get(2).getText().trim();
						String WebFirstName=tdList.get(3).getText().trim();
						String WebVin=tdList.get(4).getText();
						webDealerCost=tdList.get(6).getText().trim();
						String WebDate=tdList.get(8).getText().trim();
						
						/*System.out.println("webLastName:- "+webLastName);
						System.out.println("webFirstName:- "+webFirstName);
						System.out.println("webVin:- "+webVin);
						System.out.println("webDealerCost:- "+webDealerCost);
						System.out.println("webVin:- "+webVin);
						System.out.println("VehicleID:- "+VehicleID);*/
						
						/*System.out.println("LastName:- "+LastName.trim());
						System.out.println("FirstName:- "+FirstName.trim());
						System.out.println("VehicleID:- "+VehicleID.trim());*/
						if(WebLastName.equalsIgnoreCase(LastName.trim()) && WebFirstName.equalsIgnoreCase(FirstName.trim()) )
						{
							//System.out.println("YESsssssssssssssssssssssssssssssss");
							//Assert.assertEquals(webVin.trim(), VehicleID.trim());
							if(WebVin.trim().equalsIgnoreCase(VehicleID.trim()) && WebDate.equalsIgnoreCase(CurrentDateSelection.getCurrentDate()))
							{
								
								webDealerCost = webDealerCost.replace(",", "");
								ExpDealerCost = ExpDealerCost.replace(",", "");
								
								if(webDealerCost.equals(ExpDealerCost))
								{
									status="Pass";
								}else{
									status="Fail";
								}
								
								//System.out.println("status:- "+status);
								
								/*String[] valueToWriteNew=null;
								valueToWriteNew = new String[13];
				        		valueToWriteNew[0]=TestCase;
				        		valueToWriteNew[1]=Portal;
				        		valueToWriteNew[2]=Dealer;
				        		valueToWriteNew[3]=VehicleID;
				        		valueToWriteNew[4]=Product;
				        		valueToWriteNew[5]=Coverage;
				        		valueToWriteNew[6]=Term;
				        		valueToWriteNew[7]=FirstName;
				        		valueToWriteNew[8]=LastName;
				        		valueToWriteNew[9]=ExpDealerCost;
				        		valueToWriteNew[10]=WebDealerCost;
				        		valueToWriteNew[11]=status;
				        		valueToWriteNew[12]=CurrentDateSelection.getCurrentDate();
				        		
				        		ExcelReadWrite ERW=new ExcelReadWrite();
				        		ERW.writeExcelForm(System.getProperty("user.dir"), "result.xlsx", "E-Contracting_Result",valueToWriteNew);*/
				        		
				        		Log.log.debug("Verify Dealer Cost as:-");
				        		Log.log.debug("Expected Dealer Cost as:- "+ExpDealerCost);
				        		Log.log.debug("Actual Dealer Cost as:- "+webDealerCost);
				        		Log.log.debug("Status:- "+status);
				        		
				        		break;					        		
							}
						}													
					}
					
					if(status==null){
						webDealerCost = "";
						System.out.println("No Record Found");
						Assert.assertTrue("No Record Found", false);
					}
				}
			}
									
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
		
		String[] data = { webDealerCost, status };
		
		return data;
	}
	
}
