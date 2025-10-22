package harley_US;



import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import configurations.Hooks;
import utility.ErrorMessage;
import utility.GetScreenshot;

public class ProductPage_Harley_us {

	public WebDriver driver;	
	

	public String product1 = "GAP";
	public String product2 = "PLANNED";
	public String product3 = "THEFT";
	//public String product4 = "CHPS PLANNED";

	
	public ProductPage_Harley_us(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	//Declaring variables for Excel
	public String productSelected;
	public String bundleSelection;
	public String plan_product;
	public String termmonth;
	public String termMiles;
	public String de_ductible;
	public String retailPrice;
	public String dlrcost;
	public String actcost;
	
	//To Select the Product
	
	@FindBy(id="product")
	public WebElement Product;
	public void selectProduct(String product, String plan, String termMonth, String termmiles, String deductible, String dealerCost, String customerCost, String gst, String firstServiceInterval, String finalServiceInterval){
		try{
			productSelected = product;
			//bundleSelection = bundleselection;
			plan_product = plan;
			termmonth = termMonth;
			termMiles = termmiles; 
			de_ductible = deductible;
			dlrcost = dealerCost;
			
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("product")));
			Select select = new Select(driver.findElement(By.id("product")));
	 		select.selectByVisibleText(product);
	 		selectProduct1(product, plan, termMonth, termmiles, deductible, customerCost, gst, firstServiceInterval, finalServiceInterval);
		}
		catch(Exception e){
			GetScreenshot.captureScreenshot();
			ErrorMessage.captureErrorMessage("errorMessage");
			Assert.assertTrue(e.getMessage(),false);		
		}		
	}
	
	public void selectProductHDUS(String product, String plan, String termMonth, String termmiles, String deductible, String dealerCost, String customerCost, String firstServiceInterval, String finalServiceInterval, String registrationNumber){
		try{
			productSelected = product;
			//bundleSelection = bundleselection;
			plan_product = plan;
			termmonth = termMonth;
			termMiles = termmiles; 
			de_ductible = deductible;
			dlrcost = dealerCost;
			
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("product")));
			Select select = new Select(driver.findElement(By.id("product")));
	 		select.selectByVisibleText(product);
	 		selectProduct2(product, plan, termMonth, termmiles, deductible, customerCost, firstServiceInterval, finalServiceInterval, registrationNumber);
		}
		catch(Exception e){
			GetScreenshot.captureScreenshot();
			ErrorMessage.captureErrorMessage("errorMessage");
			Assert.assertTrue(e.getMessage(),false);		
		}		
	}
	
	//Function for selecting a plan or a bundle.
	// it check with the product and select the plan or product.

	
	public void selectProduct1(String product,String plan, String termMonth, String termmiles, String deductible, String customerCost, String gst, String firstServiceInterval, String finalServiceInterval){
		if(product.contains(product1))
 		{
 			selectTermMonth(termMonth);	
 		}
 		else if(product.contains(product2)) {
 			selectFirstServiceInterval(firstServiceInterval);
 			selectFinalServiceInterval(finalServiceInterval);
 		}
 		else if(product.contains(product3)) {
 			selectTermMonthDropdown(termMonth);
		}

			selectDeductibleDropdown(deductible);
			enterCustomerCost(customerCost);
			enterGST(gst);
	}
	
	public void selectProduct2(String product,String plan, String termMonth, String termmiles, String deductible, String customerCost, String firstServiceInterval, String finalServiceInterval, String registrationNumber){
		if(product.contains("GAP"))
 		{
 			selectTermMonth(termMonth);	
 		}
 		else if(product.contains("PLANNED") || product.contains("MAINTENANCE")) {
 			selectFirstServiceInterval(firstServiceInterval);
 			selectFinalServiceInterval(finalServiceInterval);
 		}
 		else if(product.contains("THEFT")) {
 			selectTermMonthDropdown(termMonth);
		}

		if (!deductible.equalsIgnoreCase("null") && !deductible.equalsIgnoreCase("")) {
			selectDeductibleDropdown(deductible);			
		}
		
		if(product.contains("THEFT")) {
			selectRegNumber(registrationNumber);		
		}
			
			
			
	}
	
	
	// End
	
	@FindBy(id = "interval")
	public WebElement FirstServiceIntervalDrpdn;
	
	public void selectFirstServiceInterval(String firstServiceInterval){
		try{
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(FirstServiceIntervalDrpdn));
			Select sel = new Select(FirstServiceIntervalDrpdn);
			sel.selectByVisibleText(firstServiceInterval);
		}
		catch(Exception e){
			e.printStackTrace();
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id = "finalServiceIntervals_drop")
	public WebElement FinalServiceIntervalDrpdn;
	
	public void selectFinalServiceInterval(String finalServiceInterval){
		try{
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(FinalServiceIntervalDrpdn));
			Select sel = new Select(FinalServiceIntervalDrpdn);
			sel.selectByVisibleText(finalServiceInterval);
		}
		catch(Exception e){
			e.printStackTrace();
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id = "retail_cost")
	public WebElement CustomerCost;
	
	public void enterCustomerCost(String customerCost){
		try{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(CustomerCost));
		CustomerCost.sendKeys(customerCost);
		}
		catch(Exception e){
			e.printStackTrace();
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id = "retail_gst_cost")
	public WebElement GST;
	
	public void enterGST(String gst){
		try{
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(GST));
			GST.sendKeys(gst);
		}
		catch(Exception e){
			e.printStackTrace();
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
		/*
		  Finding the selectPlan element 
		 */
	
	@FindBy(id="plan")
	public WebElement Plan;
	//Plan 
	public void selectPlan(String plan){
		try{			
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("plan")));
			Select select = new Select(driver.findElement(By.id("plan")));
	 		select.selectByVisibleText(plan);						
		}
		catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}		
	}
	
	
	@FindBy(id="registn_number")
	public WebElement regNumber;
	//Plan 
	public void selectRegNumber(String rNumber){
		try{			
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("registn_number")));
			regNumber.sendKeys(rNumber);				
		}
		catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}		
	}

	
	
		/*
		  Finding the selectTermMonthDropdown element id 
		 */
	
	

	 @FindBy(id="term_months")
	 public WebElement term_month;
	 	//Term Months if it is drop down
	 public void selectTermMonthDropdown(String termmonth)
	 {
	 	try{
	 		WebDriverWait wait = new WebDriverWait(driver, 20);
	 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("term_months")));	 		
	 		Select select = new Select(driver.findElement(By.id("term_months")));
	 		select.selectByVisibleText(termmonth);
	 	}catch(Exception e){	 	
	 		GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
	 	}
	 }
		/*
		  Finding the selectTermMilesDropdown element id
		 */

	 @FindBy(id="term_miles")
	 public WebElement term_miles;
	 	 //Term Miles if it is dropdown 
	 public void selectTermMilesDropdown(String termmiles)
	 {
	 	try{	 		 			 		
	 		WebDriverWait wait = new WebDriverWait(driver, 20);
	 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("term_miles")));	 		
	 		Select select = new Select(driver.findElement(By.id("term_miles")));
	 		select.selectByVisibleText(termmiles);
	 	}catch(Exception e){	 	
	 		GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
	 	}
	 }
		/*
		  Finding the selectDeductibleDropdown element 
		 */

	 @FindBy(id="deductible")
	 public WebElement Deductible;
	 	 //Deductible if it is drop down
	 public void selectDeductibleDropdown(String deductible)
	 {
	 	try{	 		 			 		
	 		WebDriverWait wait = new WebDriverWait(driver, 20);
	 		wait.until(ExpectedConditions.visibilityOf(Deductible));	 		
	 		Select select = new Select(Deductible);
	 		select.selectByVisibleText(deductible);
	 	}catch(Exception e){	 	
	 		GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
	 	}
	 }
	 
		/*
		  Finding the selectTermMonth element id
		 */
	 
	
	@FindBy(id="term_month_txt")
	public WebElement termMonth;
	//Term Month if it is a text box
	public void selectTermMonth(String Month){
		try{			
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("term_month_txt")));
			termMonth.sendKeys(Month);	
			termMonth.sendKeys(Keys.TAB);
		}
		catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}		
	}
	
	/*
		  Finding the  selectRetailCost element id 
		 */
	@FindBy(id="dealer_cost")
	public WebElement dealerCost;
	// Retail Price 
	public String[] selectDealerCost(String DealerCost){
		String actualCost = "";
		String status = "";
		try{
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dealer_cost")));
			actualCost = dealerCost.getAttribute("value");	
			System.out.println("Rate:"+actcost);
			if (DealerCost.equalsIgnoreCase(actualCost)) 
			{
				status = "Pass";
			} 
			else
			{
				status = "Fail";
			}

			String[] data = { actualCost, status };

			return data;
		}
		
		catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
			String[] data = { actualCost, status };

			return data;
		}				
	}
	
	
	@FindBy(id="retail_cost")
	public WebElement Retailcost;
	// Retail Price 
	public void selectRetailCost(String cost){
		try{
			retailPrice = cost;
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("retail_cost")));
			if (Retailcost.getAttribute("value").equals(""))
			Retailcost.sendKeys(cost);			
		}
		catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}		
	}
	
	/*
		  Finding the createContract element id 
		 */
	
	
	@FindBy(id="add_done")
	public WebElement createContract;
	//Continue Button
	public void createContract(){
		try{
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(createContract));
			//System.out.println("1");
			createContract.click();
			//System.out.println("2");
			
			//if(productSelected.contains("PLANNED")){
			//	PopupAlert();
			//} 
				
			//createContract.click();
			
			//writeExcel();
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("isBusiness")));
		}
		catch(Exception e){
			GetScreenshot.captureScreenshot();
			ErrorMessage.captureErrorMessage("errorMessage");
			//writeExcel();
			Assert.assertTrue(e.getMessage(),false);
		}		
	}
	
	public void createContractHDUS(String Product){
		
		try{
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(createContract));
			
			if(Product.contains("PLANNED") || Product.contains("MAINTENANCE")){
				createContract.click();
				PopupAlert();
			} else {
				Thread.sleep(1000L);
				createContract.click();				
			}
			//writeExcel();
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("isBusiness")));
		}
		catch(Exception e){
			GetScreenshot.captureScreenshot();
			ErrorMessage.captureErrorMessage("errorMessage");
			//writeExcel();
			Assert.assertTrue(e.getMessage(),false);
		}		
	}
	
	@FindBy(id="ppm_confirm")
	public WebElement ppmConfirm;
	//Continue Button
	public void PopupAlert(){
		try{
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("create_econtract_popup")));				
			ppmConfirm.click();
		}			
		catch(Exception e){
			GetScreenshot.captureScreenshot();
			ErrorMessage.captureErrorMessage("errorMessage");
			//writeExcel();
			Assert.assertTrue(e.getMessage(),false);
		}		
	}
	
	
	
	
	
}
