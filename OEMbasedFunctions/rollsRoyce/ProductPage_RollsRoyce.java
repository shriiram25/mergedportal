package rollsRoyce;



import org.junit.Assert;
import org.openqa.selenium.By;
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

public class ProductPage_RollsRoyce {

	public WebDriver driver;	
	
	//Declaring bundle Selection for Select Product Page
	public String product1 = "MULTI";
	public String product1sub = "GB";
	public String product2sub = "SB";
	public String product3sub = "PB";
	public String product4sub = "BB";
	public String product5sub = "GBWC";
	public String product6sub = "SBWC";
	public String product7sub = "PBWC";
	public String product8sub = "BBWC";
	public String product2 = "SERVICE";
	public String product3 = "THEFT";
	public String product4 = "TERM";
	
	public ProductPage_RollsRoyce(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	//Declaring variables for Excel
	public String productSeleted;
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
	public void selectProduct(String product, String bundleselection,String plan, String termMonth, String termmiles, String deductible, String dealerCost){
		try{
			productSeleted = product;
			bundleSelection = bundleselection;
			plan_product = plan;
			termmonth = termMonth;
			termMiles = termmiles; 
			de_ductible = deductible;
			dlrcost = dealerCost;
			
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("product")));
			Select select = new Select(driver.findElement(By.id("product")));
	 		select.selectByVisibleText(product);
	 		selectProduct1(product, bundleselection, plan, termMonth, termmiles, deductible);
		}
		catch(Exception e){
			GetScreenshot.captureScreenshot();
			ErrorMessage.captureErrorMessage("errorMessage");
			Assert.assertTrue(e.getMessage(),false);		
		}		
	}
	
	//Function for selecting a plan or a bundle.
	// it check with the product and select the plan or product.

	
	public void selectProduct1(String product, String bundleselection,String plan, String termMonth, String termmiles, String deductible){
		if(product.contains(product1))
 		{
			if(bundleselection.equalsIgnoreCase(product1sub)){	 			
	 			WebDriverWait wait = new WebDriverWait(driver, 20);
	 			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@textvalue = 'GOLD BUNDLE']")));
		 		driver.findElement(By.xpath("//input[@textvalue = 'GOLD BUNDLE']")).click();
		 		}	 		
	 		else if(bundleselection.equalsIgnoreCase(product2sub)){	 			
	 			WebDriverWait wait = new WebDriverWait(driver, 20);
	 			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@textvalue = 'SILVER BUNDLE']")));
		 		driver.findElement(By.xpath("//input[@textvalue = 'SILVER BUNDLE']")).click();
		 		}
		    else if(bundleselection.equalsIgnoreCase(product3sub)){
		    	WebDriverWait wait = new WebDriverWait(driver, 20);
		 		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@textvalue = 'PLATINUM BUNDLE']")));
				driver.findElement(By.xpath("//input[@textvalue = 'PLATINUM BUNDLE']")).click();
				}
		    else if(bundleselection.equalsIgnoreCase(product4sub)){
		    	WebDriverWait wait = new WebDriverWait(driver, 20);
		 		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@textvalue = 'BRONZE BUNDLE']")));
				driver.findElement(By.xpath("//input[@textvalue = 'BRONZE BUNDLE']")).click();
				}
		    else if(bundleselection.equalsIgnoreCase(product5sub)){	 			
	 			WebDriverWait wait = new WebDriverWait(driver, 20);
	 			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@textvalue = 'GOLD BUNDLE WITH COSMETIC']")));
		 		driver.findElement(By.xpath("//input[@textvalue = 'GOLD BUNDLE WITH COSMETIC']")).click();
		 		}	 		
		    else if(bundleselection.equalsIgnoreCase(product6sub)){	 			
	 			WebDriverWait wait = new WebDriverWait(driver, 20);
	 			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@textvalue = 'SILVER BUNDLE WITH COSMETIC']")));
		 		driver.findElement(By.xpath("//input[@textvalue = 'SILVER BUNDLE WITH COSMETIC']")).click();
		 		}
		    else if(bundleselection.equalsIgnoreCase(product7sub)){	 			
	 			WebDriverWait wait = new WebDriverWait(driver, 20);
	 			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@textvalue = 'PLATINUM BUNDLE WITH COSMETIC']")));
		 		driver.findElement(By.xpath("//input[@textvalue = 'PLATINUM BUNDLE WITH COSMETIC']")).click();
		 		}
		    else if(bundleselection.equalsIgnoreCase(product8sub)){	 			
	 			WebDriverWait wait = new WebDriverWait(driver, 20);
	 			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@textvalue = 'BRONZE BUNDLE WITH COSMETIC']")));
		 		driver.findElement(By.xpath("//input[@textvalue = 'BRONZE BUNDLE WITH COSMETIC']")).click();
		 		}
 			else 
 			   { 				
			    String[] temp;
			    String symbol = "-";			  
			    temp = bundleselection.split(symbol);
			    
			    for(int i =0; i < temp.length ; i++)
			    {
			    	//EASHooks.log.debug(temp[i]);
			    	if(temp[i].equalsIgnoreCase("DP")){
			    		WebDriverWait wait = new WebDriverWait(driver, 20);
				 		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@textvalue = 'DENT PROTECTION']")));
						driver.findElement(By.xpath("//input[@textvalue = 'DENT PROTECTION']")).click();
			    	}
			    	else if(temp[i].equalsIgnoreCase("KP")){
			    		WebDriverWait wait = new WebDriverWait(driver, 20);
				 		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@textvalue = 'KEY PROTECTION']")));
						driver.findElement(By.xpath("//input[@textvalue = 'KEY PROTECTION']")).click();
			    	}
			    	else if(temp[i].equalsIgnoreCase("TW")){
			    		WebDriverWait wait = new WebDriverWait(driver, 20);
				 		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@textvalue = 'TIRE & WHEEL PROTECTION']")));
						driver.findElement(By.xpath("//input[@textvalue = 'TIRE & WHEEL PROTECTION']")).click();
			    	}
			    	else if(temp[i].equalsIgnoreCase("WP")){
			    		WebDriverWait wait = new WebDriverWait(driver, 20);
				 		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@textvalue = 'WINDSHIELD PROTECTION']")));
						driver.findElement(By.xpath("//input[@textvalue = 'WINDSHIELD PROTECTION']")).click();	
			    	}
			    	else if(temp[i].equalsIgnoreCase("TWC")){
			    		WebDriverWait wait = new WebDriverWait(driver, 20);
				 		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@textvalue = 'TIRE & WHEEL PROTECTION WITH COSMETIC']")));
						driver.findElement(By.xpath("//input[@textvalue = 'TIRE & WHEEL PROTECTION WITH COSMETIC']")).click();	
			    	}
			    }
		     }
 			selectTermMonth(termMonth);	
 		}
 		
 		else if(product.contains(product2) || product.contains(product4)) {
 				selectPlan(plan);
 				//Dropdown for month
 				selectTermMonthDropdown(termMonth);
 				
 				//Dropdown for miles
 				selectTermMilesDropdown(termmiles);
 				
 				//Dropdown for deductible
 				selectDeductibleDropdown(deductible);
 		}
		
 		else if(product.contains(product3)) {
				selectPlan(plan);
				
 				selectTermMonthDropdown(termMonth);

				//Dropdown for month				
		}
 		
 		else{
 			selectPlan(plan);
 			
 			//if month is text box
 			selectTermMonth(termMonth);
 			
 			if(!termMiles.equals("")){
 				selectTermMilesDropdown(termmiles);
 			}
 		}
	}
	
	
	// End
	
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
	 public WebElement deductible;
	 	 //Deductible if it is drop down
	 public void selectDeductibleDropdown(String deductible)
	 {
	 	try{	 		 			 		
	 		WebDriverWait wait = new WebDriverWait(driver, 20);
	 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("deductible")));	 		
	 		Select select = new Select(driver.findElement(By.id("deductible")));
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
	public void createContract(String Product){
		try{
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add_done")));
			createContract.click();
			if(Product.contains("CPO")){
				cpoPopupAlert();
			}
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("isBusiness")));
		}
		catch(Exception e){
			GetScreenshot.captureScreenshot();
			ErrorMessage.captureErrorMessage("errorMessage");
		
			Assert.assertTrue(e.getMessage(),false);
		}		
	}
	
	@FindBy(id="cpo_confirm")
	public WebElement cpoConfirm;
	//Continue Button
	public void cpoPopupAlert(){
		try{
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("show_cpo_popup")));				
			cpoConfirm.click();
		}			
		catch(Exception e){
			GetScreenshot.captureScreenshot();
			ErrorMessage.captureErrorMessage("errorMessage");
		
			Assert.assertTrue(e.getMessage(),false);
		}		
	}
	
	
	
}
