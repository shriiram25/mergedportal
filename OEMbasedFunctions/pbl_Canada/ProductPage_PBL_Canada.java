package pbl_Canada;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

//import CucumberPBLAutomation.PBLHooks;
import utility.ErrorMessage;
import utility.GetScreenshot;

public class ProductPage_PBL_Canada {

	public WebDriver driver;

	public ProductPage_PBL_Canada(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String retailPrice;
	public String dlrcost;
	public String actcost;

	// To Select the Product

	@FindBy(id = "product")
	public WebElement Product;

	public void selectProduct(String product, String bundleSelection, String plan, String termMonth, String termMiles,
			String deductible, String firstServiceInterval, String finalServiceInterval, String registrationCode) { // ,
																													// String
																													// dealerCost){
		try {

			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("product")));
			Select select = new Select(driver.findElement(By.id("product")));
			select.selectByVisibleText(product);
			selectProduct1(product, bundleSelection, plan, termMonth, termMiles, deductible, firstServiceInterval,
					finalServiceInterval, registrationCode);
		} catch (Exception e) {
			GetScreenshot.captureScreenshot();
			ErrorMessage.captureErrorMessage("errorMessage");
			Assert.assertTrue(e.getMessage(), false);
		}
	}

	// <<<--Function for selecting a plan or a bundle.it check with the product
	// and select the plan or Product.

	public void selectProduct1(String product, String bundleselection, String plan, String termMonth, String termMiles,
			String deductible, String firstServiceInterval, String finalServiceInterval, String registrationCode)
			throws InterruptedException {

		// <<<--Updated xpath locators for all the Multi-Coverage plans (PBL
		// CANADA)
		if (product.contains("MULTI-COVERAGE")) {
			if (bundleselection.toUpperCase().contains("PLATINUM")) {
				WebDriverWait wait = new WebDriverWait(driver, 30);

				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@textvalue, 'Platinum')]")));
				driver.findElement(By.xpath("//input[contains(@textvalue, 'Platinum')]")).click();
			} else if (bundleselection.toUpperCase().contains("GOLD")) {
				WebDriverWait wait = new WebDriverWait(driver, 20);

				wait.until(
						ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@textvalue, 'Gold')]")));
				driver.findElement(By.xpath("//input[contains(@textvalue, 'Gold')]")).click();
			}
			else if (bundleselection.toUpperCase().contains("BRONZE")) {
				WebDriverWait wait = new WebDriverWait(driver, 20);

				wait.until(
						ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@textvalue, 'Bronze')]")));
				driver.findElement(By.xpath("//input[contains(@textvalue, 'Bronze')]")).click();
			}else if (bundleselection.toUpperCase().contains("SILVER")) {
				WebDriverWait wait = new WebDriverWait(driver, 30);

				wait.until(ExpectedConditions
						.presenceOfElementLocated(By.xpath("//input[contains(@textvalue, 'Silver')]")));
				driver.findElement(By.xpath("//input[contains(@textvalue, 'Silver')]")).click();
			} else {

				if (bundleselection.toUpperCase().contains("P")) {
					WebDriverWait wait = new WebDriverWait(driver, 20);
					wait.until(ExpectedConditions
							.presenceOfElementLocated(By.xpath("//input[contains(@textvalue, 'Wheel')]")));
					driver.findElement(By.xpath("//input[contains(@textvalue, 'Wheel')]")).click();

				}
				if (bundleselection.toUpperCase().contains("R")) {
					WebDriverWait wait = new WebDriverWait(driver, 20);
					wait.until(ExpectedConditions
							.presenceOfElementLocated(By.xpath("//input[contains(@textvalue, 'Rim')]")));
					driver.findElement(By.xpath("//input[contains(@textvalue, 'Rim')]")).click();

				}
				if (bundleselection.toUpperCase().contains("X")) {
					WebDriverWait wait = new WebDriverWait(driver, 20);
					wait.until(ExpectedConditions
							.presenceOfElementLocated(By.xpath("//input[contains(@textvalue, 'Windshield')]")));
					driver.findElement(By.xpath("//input[contains(@textvalue, 'Windshield')]")).click();
				}
				if (bundleselection.toUpperCase().contains("D")) {
					WebDriverWait wait = new WebDriverWait(driver, 20);
					wait.until(ExpectedConditions
							.presenceOfElementLocated(By.xpath("//input[contains(@textvalue, 'Dent')]")));
					driver.findElement(By.xpath("//input[contains(@textvalue, 'Dent')]")).click();
				}

				if (bundleselection.toUpperCase().contains("K")) {
					WebDriverWait wait = new WebDriverWait(driver, 20);
					wait.until(ExpectedConditions
							.presenceOfElementLocated(By.xpath("//input[contains(@textvalue, 'Key')]")));
					driver.findElement(By.xpath("//input[contains(@textvalue, 'Key')]")).click();
				}
			}

			selectTermMonth(termMonth);
			selectDeductibleDropdown(deductible);

		}

		else if (product.contains("VEHICLE SERVICE PROTECTION")) {
			selectPlan(plan);
			selectTermMonthDropdown(termMonth);
			selectTermMilesDropdown(termMiles);
			selectDeductibleDropdown(deductible);
		}

		else if (product.contains("QUALITYSHIELD GAP PROTECTION") || product.contains("GAP PROTECTION")) {
			selectPlan(plan);
			enterTermMonth(termMonth);
			selectDeductibleDropdown(deductible);
		}

		else if (product.contains("PREPAID MAINTENANCE")) {
			selectFirstServiceInterval(firstServiceInterval);
			selectFinalServiceInterval(finalServiceInterval);
		}

		else if (product.contains("LEASE-END PROTECTION")) {

			selectPlan(plan);
			// <<<< If month is text box
			selectTermMonth(termMonth);
			selectDeductibleDropdown(deductible);
		} else if (product.contains("PFS LEP Claim Free Reward")) {

			driver.findElement(By.id("product_popup_accept")).click();
			driver.findElement(By.id("product_popup_accept")).click();
			//acceptLEP();
			selectPlan(plan);
			// <<<< If month is text box
			selectTermMonth(termMonth);
			selectDeductibleDropdown(deductible);
		}
	}

	/*
	 * click on Accept element for PFS LEP pop-up
	 */
	@FindBy(id = "product_popup_accept")
	public WebElement acceptPopup;

	// Plan
	public void acceptLEP() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id = 'overlay_form']/div[@id = 'product_popup']")));
			driver.findElement(By.id("product_popup_accept")).click();
			driver.findElement(By.id("product_popup_accept")).click();

		} catch (Exception e) {
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(), false);
		}
	}

	/*
	 * Finding the selectPlan element
	 */

	@FindBy(id = "plan")
	public WebElement Plan;

	// Plan
	public void selectPlan(String plan) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("plan")));
			Select select = new Select(driver.findElement(By.id("plan")));
			select.selectByVisibleText(plan);

		} catch (Exception e) {
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(), false);
		}
	}

	/*
	 * Finding the selectTermMonthDropdown element id
	 */

	@FindBy(id = "term_months")
	public WebElement term_month;

	// Term Months if it is drop down
	public void selectTermMonthDropdown(String termmonth) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("term_months")));
			Select select = new Select(driver.findElement(By.id("term_months")));
			select.selectByVisibleText(termmonth);
		} catch (Exception e) {
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(), false);
		}
	}

	@FindBy(id = "term_month_txt")
	public WebElement termMonthInput;

	// Term Month if it is a text box
	public void enterTermMonth(String Month) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("term_month_txt")));
			termMonthInput.sendKeys(Month);
			termMonthInput.sendKeys(Keys.TAB);
		} catch (Exception e) {
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(), false);
		}
	}

	/*
	 * Finding the selectTermMilesDropdown element id
	 */

	@FindBy(id = "term_miles")
	public WebElement term_miles;

	// Term Miles if it is dropdown
	public void selectTermMilesDropdown(String termmiles) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("term_miles")));
			Select select = new Select(driver.findElement(By.id("term_miles")));
			select.selectByVisibleText(termmiles);
		} catch (Exception e) {
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(), false);
		}
	}
	/*
	 * Finding the selectDeductibleDropdown element
	 */

	@FindBy(id = "deductible")
	public WebElement deductible;

	// Deductible if it is drop down
	public void selectDeductibleDropdown(String deductible) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("deductible")));	 		
	 		Select select = new Select(driver.findElement(By.id("deductible")));
	 		
	 		driver.findElement(By.id("deductible")).click();
	 		select.selectByVisibleText(deductible);	 	
	 		
	 		//Thread.sleep(1000);
			
//			wait.until(ExpectedConditions.elementToBeClickable(By.id("deductible")));
//			Select select = new Select(driver.findElement(By.id("deductible")));
//
//			//driver.findElement(By.id("deductible")).click();
//			select.selectByVisibleText(deductible);

			// Thread.sleep(1000);

		} catch (Exception e) {
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(), false);
		}
	}

	/*
	 * Finding the selectTermMonth element id
	 */

	@FindBy(id = "term_month_txt")
	public WebElement termMonth;

	// Term Month if it is a text box
	public void selectTermMonth(String Month) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("term_month_txt")));
			termMonth.sendKeys(Month);

		} catch (Exception e) {
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(), false);
		}
	}

	@FindBy(id = "dealer_cost")
	public WebElement dealerCost;

	// Retail Price
	public String[] selectDealerCost(String DealerCost) {
		String actualCost = "";
		String status = "";
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dealer_cost")));
			actualCost = dealerCost.getAttribute("value");
			System.out.println("Rate:" + actcost);
			if (DealerCost.equalsIgnoreCase(actualCost)) {
				status = "Pass";
			} else {
				status = "Fail";
			}

			String[] data = { actualCost, status };

			return data;
		}

		catch (Exception e) {
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(), false);
			String[] data = { actualCost, status };

			return data;
		}
	}
	/*
	 * Finding the selectRetailCost element id
	 */

	@FindBy(id = "retail_cost")
	public WebElement Retailcost;

	// Retail Price
	public void selectRetailCost(String cost) {
		try {
			retailPrice = cost;
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("retail_cost")));
			if (Retailcost.getAttribute("value").equals(""))
				Retailcost.sendKeys(cost);
		} catch (Exception e) {
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(), false);
		}
	}

	/*
	 * Finding the createContract element id
	 */

	@FindBy(id = "add_done")
	public WebElement createContract;
	@FindBy(id = "retail_total_cost")
	public WebElement Retail_total_cost;

	// Continue Button
	public void createContract(String Product) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("retail_total_cost")));
			Retail_total_cost.click();

			wait.until(ExpectedConditions.elementToBeClickable(createContract));

			if (Product.contains("PREPAID MAINTENANCE")) {
				createContract.click();
				PopupAlert();
			}

			else if (Product.contains("MULTI-COVERAGE")) {
				createContract.click();
			}

			else {

				createContract.click();

			}
			// writeExcel();
			// wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("isBusiness")));
		} catch (Exception e) {
			GetScreenshot.captureScreenshot();
			ErrorMessage.captureErrorMessage("errorMessage");
			// writeExcel();
			Assert.assertTrue(e.getMessage(), false);
		}
	}

	@FindBy(id = "interval")
	public WebElement FirstServiceIntervalDrpdn;

	public void selectFirstServiceInterval(String firstServiceInterval) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(FirstServiceIntervalDrpdn));
			Select sel = new Select(FirstServiceIntervalDrpdn);
			sel.selectByVisibleText(firstServiceInterval);
		} catch (Exception e) {
			e.printStackTrace();
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(), false);
		}
	}

	@FindBy(id = "finalServiceIntervals_drop")
	public WebElement FinalServiceIntervalDrpdn;

	public void selectFinalServiceInterval(String finalServiceInterval) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(FinalServiceIntervalDrpdn));
			Select sel = new Select(FinalServiceIntervalDrpdn);
			sel.selectByVisibleText(finalServiceInterval);
		} catch (Exception e) {
			e.printStackTrace();
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(), false);
		}
	}

	@FindBy(id = "ppm_confirm")
	public WebElement ppmConfirm;

	// Continue Button
	public void PopupAlert() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			// wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("create_econtract_popup")));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ppm_confirm")));
			ppmConfirm.click();
		} catch (Exception e) {
			GetScreenshot.captureScreenshot();
			ErrorMessage.captureErrorMessage("errorMessage");
			// writeExcel();
			Assert.assertTrue(e.getMessage(), false);
		}
	}

}
