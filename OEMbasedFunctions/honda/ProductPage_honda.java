package honda;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import configurations.Step_Definition;
import utility.ErrorMessage;
import utility.GetScreenshot;

public class ProductPage_honda {

	public WebDriver driver;

	public ProductPage_honda(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String productSeleted;
	public String bundleSelection;
	public String plan_product;
	public String termmonth;
	public String termMiles;
	public String de_ductible;
	public String retailPrice;
	public String dlrcost;
	public String actcost;
	public static String taxPopup = "";

	@FindBy(id = "product")
	public WebElement Product;

	public void selectProduct(String product, String plan, String termMonth, String termmiles) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("product")));

			Select select = new Select(driver.findElement(By.id("product")));
			select.selectByVisibleText(product);
			//Thread.sleep(2000);
			selectProduct1(product, plan, termMonth, termmiles);
		} catch (Exception e) {
			GetScreenshot.captureScreenshot();
			ErrorMessage.captureErrorMessage("errorMessage");
			Assert.assertTrue(e.getMessage(), false);
		}
	}

	// Function for selecting a plan or a bundle.
	// it check with the product and select the plan or product.

	public void selectProduct1(String product, String plan, String termMonth, String termmiles) throws InterruptedException {

		try {

			if (product.contains("PRECISION")) {
				selectPlan(plan);
				selectTermMonthDropdown(termMonth);
				if (!termmiles.equals("")) {
					selectTermMilesDropdown(termmiles);
				}
			} else if (product.contains("LEASE")) {
				selectPlan(plan);
				enterTermMonth(termMonth);
			}
		} catch (Exception e) {
			GetScreenshot.captureScreenshot();
			ErrorMessage.captureErrorMessage("errorMessage");
			Assert.assertTrue(e.getMessage(), false);
		}

	}

	
	@FindBy(id = "plan")
	public WebElement Plan;

	public void selectPlan(String plan) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("plan")));
			Select select = new Select(driver.findElement(By.id("plan")));
			select.selectByVisibleText(plan);
		} catch (Exception e) {
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(), false);
		}
	}

	@FindBy(id = "term_months")
	public WebElement term_month;

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

	@FindBy(id = "term_miles")
	public WebElement term_miles;

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

	@FindBy(id = "deductible")
	public WebElement deductible;

	public void selectDeductibleDropdown(String deductible) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("deductible")));
			Select select = new Select(driver.findElement(By.id("deductible")));
			select.selectByVisibleText(deductible);
		} catch (Exception e) {
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(), false);
		}

	}

	@FindBy(id = "term_month_txt")
	public WebElement termMonth;

	// Term Month if it is a text box
	public void enterTermMonth(String Month) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(By.id("term_month_txt")));
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
			System.out.println("Rate:" + actualCost);

			if (DealerCost.equalsIgnoreCase(actualCost)) {
				status = "Pass";
			} else {
				status = "Fail";
			}

			String[] data = { actualCost, status };

			return data;

		} catch (Exception e) {
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(), false);
			String[] data = { actualCost, status };

			return data;
		}

	}

	@FindBy(id = "retail_cost")
	public WebElement Retailcost;

	public void selectRetailCost(String cost) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("retail_cost")));
			if (Retailcost.getAttribute("value").equals("")) {
				Retailcost.sendKeys(cost);
			}
		} catch (Exception e) {
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(), false);
		}
	}

	@FindBy(id = "add_done")
	public WebElement createContract;

	// Continue Button
	public void createContract() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add_done")));
			createContract.click();
		} catch (Exception e) {
			GetScreenshot.captureScreenshot();
			ErrorMessage.captureErrorMessage("errorMessage");
			Assert.assertTrue(e.getMessage(), false);
		}
	}

	@FindBy(id = "cpo_confirm")
	public WebElement cpoConfirm;

	// Continue Button
	public void cpoPopupAlert() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("show_cpo_popup")));
			cpoConfirm.click();
		} catch (Exception e) {
			GetScreenshot.captureScreenshot();
			ErrorMessage.captureErrorMessage("errorMessage");
			Assert.assertTrue(e.getMessage(), false);
		}
	}

	// adding scripts for input tax
	@FindBy(id = "web_con_cc_hst_gst")
	public WebElement customerHST_GST;

	public void enterCustomerHST_GST(String HG) {
		try {

			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(customerHST_GST));

			customerHST_GST.sendKeys(HG);

			// Hooks.log.debug("Enter Customer HST/GST as:- "+HG);
		} catch (Exception e) {
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(), false);
		}
	}

	@FindBy(id = "web_con_cc_pst")
	public WebElement customerPST;

	public void enterCustomerPST(String PST) {
		try {

			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(customerPST));

			customerPST.sendKeys(PST);

			// Hooks.log.debug("Enter Customer PST as:- "+PST);
		} catch (Exception e) {
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(), false);
		}
	}

	@FindBy(id = "web_con_cc_qst")
	public WebElement customerQST;

	public void enterCustomerQST(String QST) {
		try {

			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(customerQST));

			customerQST.sendKeys(QST);

			// Hooks.log.debug("Enter Customer QST as:- "+QST);
		} catch (Exception e) {
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(), false);
		}
	}
}
