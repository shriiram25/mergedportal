package harley_Canada;



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

//import CucumberEASAutomation.EASHooks;
import utility.ErrorMessage;
import utility.ExcelReadWrite;
import utility.GetScreenshot;

public class ProductPage_Harley_Canada {

	public WebDriver driver;	
	

	public String product1 = "GAP";
	public String product2 = "PLANNED";
	public String product3 = "THEFT";

	
	public ProductPage_Harley_Canada(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	//Declaring variables for Excel
	public String selectedProduct;
	public String bundleSelection;
	public String plan_product;
	public String termmonth;
	public String termMiles;
	public String de_ductible;
	public String retailPrice;
	public String dlrcost;
	public String actcost;
	public static String taxPopup="";
	
	//To Select the Product
	
	@FindBy(id="product")
	public WebElement Product;
	public void selectProduct(String Product, String BundleSelection, String Plan, String Term, String TermMiles, String Deductible, String firstServiceInterval, String finalServiceInterval, String registrationCode){
		try{
			selectedProduct = Product;
			//bundleSelection = bundleselection;
			//plan_product = Plan;
			//termmonth = Term;
			//termMiles = TermMiles; 
			//de_ductible = Deductible;
			//dlrcost = dealerCost;
			
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("product")));
			Select select = new Select(driver.findElement(By.id("product")));
	 		select.selectByVisibleText(Product);
	 		selectProduct1(Product, BundleSelection, Plan, Term, TermMiles, Deductible, firstServiceInterval, finalServiceInterval, registrationCode);
		}
		catch(Exception e){
			GetScreenshot.captureScreenshot();
			ErrorMessage.captureErrorMessage("errorMessage");
			Assert.assertTrue(e.getMessage(),false);		
		}		
	}
	
	//Function for selecting a plan or a bundle.
	// it check with the product and select the plan or product.

	
	public void selectProduct1(String Product, String BundleSelection, String Plan, String Term, String TermMiles, String Deductible, String firstServiceInterval, String finalServiceInterval, String registrationCode){
		
		if(Product.contains("GAP")){
 			selectTermMonth(Term);	
 		}
 		
		else if(Product.contains("PLANNED")) {
 			selectFirstServiceInterval(firstServiceInterval);
 			selectFinalServiceInterval(finalServiceInterval);
 		}
 		
		else if(Product.contains("THEFT")) {
 			selectTermMonthDropdown(Term);
 			selectRegNumber(registrationCode);
		}

			selectDeductibleDropdown(Deductible);
			//enterCustomerCost(customerCost);
			//enterGST(gst);
	}
	
	
	// End
	
	@FindBy(id = "interval")
	public WebElement FirstServiceIntervalDrpdn;
	
	public void selectFirstServiceInterval(String firstServiceInterval){
		try{
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(FirstServiceIntervalDrpdn));
			Thread.sleep(1000L);
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
			wait.until(ExpectedConditions.elementToBeClickable(FinalServiceIntervalDrpdn));
			Thread.sleep(1000L);
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
			System.out.println("Rate:"+actualCost);
			
			if(DealerCost.equalsIgnoreCase(actualCost)){
				status = "Pass";
			} else {
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
	public void createContract(String product){
		
		
		try{
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add_done")));
			if(product.contains("PLANNED")){
				createContract.click();
				PopupAlert();
			}
			else createContract.click();
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
	
	@FindBy(id = "tax_popup_ok")
	public WebElement taxAmtWarning;

	// Continue Button
	public void taxAmtPopupAlert() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("overlay_form")));
			taxAmtWarning.click();
			taxPopup = "Tax amount warning popup displayed.";
		} catch (Exception e) {
			GetScreenshot.captureScreenshot();
			ErrorMessage.captureErrorMessage("Tax amount warning");
			Assert.assertTrue(e.getMessage(), false);
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
	
}
