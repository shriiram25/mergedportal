package commonFunctions;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import configurations.Hooks;
import utility.GetScreenshot;

public class SubmitEcontractPage {
	public WebDriver driver;

	public SubmitEcontractPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "table")
	public WebElement table;

	// <<<-- Logic to click the check box of the saved eContarct
	public void selectContract(String lastName, String vin, String product, String portal) {
		DateFormatByPortal df = new DateFormatByPortal();
		String currentDate = df.getCurrentDateFormatByPortal(portal);
		clickPendingeContractsNoticePopUp();
		vin = vin.substring(9, 17);
		boolean status = false;
		try {

			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(table));

			List<WebElement> bodyList = table.findElements(By.tagName("tbody"));
			if (bodyList.size() > 0) {
				List<WebElement> trList = bodyList.get(0).findElements(By.tagName("tr"));
				if (trList.size() > 0) {

					for (int i = 0; i < trList.size(); i++) {
						List<WebElement> tdList = trList.get(i).findElements(By.tagName("td"));
						String webLastName = tdList.get(1).getText().trim();
						String webVIN = tdList.get(2).getText().trim();
						String webProduct = tdList.get(3).getText().trim();
						String modifiedDate = tdList.get(7).getText().trim();

						if (webLastName.endsWith(lastName.trim()) && webVIN.equalsIgnoreCase(vin.trim())
								&& modifiedDate.equalsIgnoreCase(currentDate)) {
							if (webProduct.equalsIgnoreCase(product)) {
								i++;
								String xpathCheckBox = "//*[@id='table']/tbody/tr[" + i + "]/td[1]/center/input";
								WebElement checkBox = driver.findElement(By.xpath(xpathCheckBox));
								wait.until(ExpectedConditions.elementToBeClickable(checkBox));
								if (!checkBox.isSelected()) {
									checkBox.click();
									// Thread.sleep(5000L);
									status = true;
								}
								break;
							}
						}
					}
				}
			}

			if (!status) {
				Assert.assertTrue("Contract not found in Saved eContract(s) list.", status);
			}

		} catch (Exception e) {
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(), false);
		}
	}

	// <<<-- Click the Pending eContracts Notice Pop Up
	public void clickPendingeContractsNoticePopUp() {

		try {
			Thread.sleep(300L);
			// driver.switchTo().frame(0);
			// WebDriverWait wait = new WebDriverWait(driver, 20);
			// wait.until(ExpectedConditions.visibilityOf(pendingNoticeOkButton));
			/*
			 * List<WebElement> popUp = driver.findElements(By.xpath(
			 * "//*[@id='pop-remit-old']/center[2]/button"));
			 * 
			 * if(popUp.size()>0){ driver.findElement(By.xpath(
			 * "//*[@id='pop-remit-old']/center[2]/button")).click(); } else {
			 * System.out.println("No Pop Up Displayed"); }
			 */

			WebElement popUp = driver.findElement(By.xpath("//*[@id='pop-remit-old']/center[2]/button"));
			if (popUp.isDisplayed()) {
				popUp.click();
			} else {
				System.out.println("No Pop Up Displayed");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue in Pending Contracts Notice Pop Up.");
		}
	}

	// <<<-- Click the Submit eContract button
	@FindBy(id = "pop_remit")
	public WebElement submitEContract;

	public void clickSubmitEContract() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(submitEContract));
		submitEContract.click();
	}

	// <<<-- Click the Submit eContract Pop Up
	@FindBy(id = "remit-confirm-close")
	public WebElement submitEContractPopUp;

	public void clickSubmitEContractsPopUp() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(submitEContractPopUp));
			submitEContractPopUp.click();

		} catch (Exception e) {
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(), false);
		}
	}

}