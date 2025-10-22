package agents.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import configurations.Hooks;
import org.junit.Assert;
import utility.CurrentDateSelection;
import utility.ExcelReadWrite;
import utility.GetScreenshot;
import utility.Log;

public class VerifyDealerCostPage {
	
	//public String status=null;
	
	
	public WebDriver driver;
	
	public VerifyDealerCostPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="remitListTable")
	public WebElement eTable;
	
	public String[] veryfyDealerCost(String LastName, String FirstName, String VehicleID, String ExpDealerCost, String Test_Case, String Dealer, String Product, String Coverage, String Term)
	{
		String webDealerCost=null;
		String status=null;
		
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("remitListTable")));
			
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
						String webLastName=tdList.get(2).getText().trim();
						String webFirstName=tdList.get(3).getText().trim();
						String webVin=tdList.get(4).getText();
						webDealerCost=tdList.get(6).getText().trim();
						String webDate=tdList.get(8).getText().trim();
						
						/*System.out.println("webLastName:- "+webLastName);
						System.out.println("webFirstName:- "+webFirstName);
						System.out.println("webVin:- "+webVin);
						System.out.println("webDealerCost:- "+webDealerCost);
						System.out.println("webVin:- "+webVin);
						System.out.println("VehicleID:- "+VehicleID);*/
						
						/*System.out.println("LastName:- "+LastName.trim());
						System.out.println("FirstName:- "+FirstName.trim());
						System.out.println("VehicleID:- "+VehicleID.trim());*/
						if(webLastName.equalsIgnoreCase(LastName.trim()) && webFirstName.equalsIgnoreCase(FirstName.trim()) )
						{
							//System.out.println("YESsssssssssssssssssssssssssssssss");
							//Assert.assertEquals(webVin.trim(), VehicleID.trim());
							if(webVin.trim().equalsIgnoreCase(VehicleID.trim()) && webDate.equalsIgnoreCase(CurrentDateSelection.getCurrentDate()))
							{
								//System.out.println("YES");
								if(webDealerCost.equals(ExpDealerCost))
								{
									status="Pass";									
								}else{
									status="Fail";									
								}
								
								//System.out.println("status:- "+status);
								
								/*String[] valueToWriteNew=null;
								valueToWriteNew = new String[12];
				        		valueToWriteNew[0]=Test_Case;
				        		valueToWriteNew[1]=Dealer;
				        		valueToWriteNew[2]=VehicleID;
				        		valueToWriteNew[3]=Product;
				        		valueToWriteNew[4]=Coverage;
				        		valueToWriteNew[5]=Term;
				        		valueToWriteNew[6]=FirstName;
				        		valueToWriteNew[7]=LastName;
				        		valueToWriteNew[8]=ExpDealerCost;
				        		valueToWriteNew[9]=webDealerCost;
				        		valueToWriteNew[10]=status;
				        		valueToWriteNew[11]=CurrentDateSelection.getCurrentDate();
				        		
				        		ExcelReadWrite ERW=new ExcelReadWrite();
				        		ERW.writeExcelForm(System.getProperty("user.dir"), "result.xlsx", "E-Contracting_Result",valueToWriteNew);*/
				        		
				        		Log.log.debug("Verify Dealer Cost as:-");
				        		Log.log.debug("Expected Dealer Cost as:- "+ExpDealerCost);
				        		Log.log.debug("Actual Dealer Cost as:- "+webDealerCost);
				        		Log.log.debug("Status as:- "+status);
				        		
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
