package Toyota;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import configurations.Hooks;
import utility.Log;
import utility.CurrentDateSelection;
import utility.ExcelReadWrite;
import utility.GetScreenshot;

public class DealerCostPage {

	public WebDriver driver;

	public DealerCostPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String declineButton = "";
	public String submitButton = "";

	@FindBy(id = "econRemitTable")
	public WebElement econTable;
	
	

	public void verifyDealerCost(String firstName, String lastName, String vinNo, String expDealerCost, String RowNo,
			String Portal, String Dealer, String Product, String Coverage, String Term) {
		try {

			String status = "";
			String webDealetCost = "";
			String toDayDate = CurrentDateSelection.getCurrentDate();

			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("econRemitTable")));

			List<WebElement> trList = econTable.findElements(By.tagName("tr"));
			// System.out.println("trList:-"+trList.size());

			if (trList.size() > 0) {
				for (int i = trList.size()-1; i >= 0; i--) {
					List<WebElement> tdList = trList.get(i).findElements(By.tagName("td"));
					if (tdList.size() > 0) {
						String webLastName = tdList.get(1).getText().trim();
						String webFirstName = tdList.get(2).getText().trim();
						String webVin = tdList.get(3).getText().trim();
						webDealetCost = tdList.get(6).getText().trim();
						String webDate = tdList.get(8).getText().trim();
				
						String rowId = trList.get(i).getAttribute("id");//
						rowId = rowId.substring(4).trim();//

						/*
						 * System.out.println("webLastName:- "+webLastName);
						 * System.out.println("webFirstName:- "+webFirstName);
						 * System.out.println("webVin:- "+webVin);
						 * System.out.println("webDealetCost:- "+webDealetCost);
						 * System.out.println("webDate:- "+webDate);
						 */

						if (webLastName.equalsIgnoreCase(lastName) && webFirstName.equalsIgnoreCase(firstName)) {

							if (webVin.equalsIgnoreCase(vinNo) && webDate.equalsIgnoreCase(toDayDate)) {

								if (webDealetCost.equalsIgnoreCase(expDealerCost)) {
									status = "Pass";
									 declineButton = "declined_" + rowId;
									 submitButton = "accepted_" + rowId;
									break;
								} else {
									status = "Fail";
								}
								// System.out.println("status:- "+status);							
							}
						
						}

					}
					
				}
			}

			if (status == "") {
				webDealetCost = "";
				System.out.println("No Record Found");
				Assert.assertTrue("No Record Found", false);
			}
			
			String[] valueToWriteNew = null;
			valueToWriteNew = new String[13];
			valueToWriteNew[0] = RowNo;
			valueToWriteNew[1] = Portal;
			valueToWriteNew[2] = Dealer;
			valueToWriteNew[3] = Product;
			valueToWriteNew[4] = Coverage;
			valueToWriteNew[5] = Term;
			valueToWriteNew[6] = firstName;
			valueToWriteNew[7] = lastName;
			valueToWriteNew[8] = vinNo;
			valueToWriteNew[9] = expDealerCost;
			valueToWriteNew[10] = webDealetCost;
			valueToWriteNew[11] = status;
			valueToWriteNew[12] = toDayDate;

			ExcelReadWrite ERW = new ExcelReadWrite();
			ERW.writeExcelForm(System.getProperty("user.dir"), "result.xlsx", "E-Contracting_Result", valueToWriteNew);

			Log.log.debug("Expected Dealer Cost as:- " + expDealerCost);
			Log.log.debug("Actual Dealer Cost as:- " + webDealetCost);
			Log.log.debug("Status is:- " + status);

		} catch (Exception e) {
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(), false);
		}
	}	
	
	public void decline() {
		try {

			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(By.id(declineButton)));
			driver.findElement(By.id(declineButton)).click();
			// Thread.sleep(3000L);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			Thread.sleep(2000L);
			alert.accept();

			Log.log.debug("Click on Decline Button");		
			
		} catch (Exception e) {
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(), false);
		}
	}
	
	@FindBy(id = "submit")
	public WebElement sub;
	
	public void submit() {
		try {
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(By.id(submitButton)));
			WebElement subElement = driver.findElement(By.id(submitButton));
			if (!subElement.isSelected()) {
				subElement.click();
				Thread.sleep(3000L);
			}
			
			sub.click();
			Thread.sleep(10000L);
			Log.log.debug("Click on Submit Accepted Agreements button");
			if (Hooks.screenShotStatus.equalsIgnoreCase("Yes")) {
				GetScreenshot.captureScreenshot();
			}

			Log.log.debug("Click on check box");	
			

		} catch (Exception e) {
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(), false);
		}
	}

	
}
