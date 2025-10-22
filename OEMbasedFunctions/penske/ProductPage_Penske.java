package penske;



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
import utility.ExcelReadWrite;
import utility.GetScreenshot;

public class ProductPage_Penske {

	public WebDriver driver;	
	
	public ProductPage_Penske(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
		
	@FindBy(id="product")
	public WebElement Product;
	
	public void selectProduct(String product, String bundleselection,String plan, String termMonth, String termmiles, String deductible, String dealerCost){
		
		try{	
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
	
	public void selectProduct1(String product, String bundleselection,String plan, String termMonth, String termmiles, String deductible) throws InterruptedException{
		//Thread.sleep(2000L);
		
		if(product.contains("MULTI-COVERAGE")){
		
			if(bundleselection.equalsIgnoreCase("GOLD BUNDLE WITH COSMETIC")){	 			
	 			WebDriverWait wait = new WebDriverWait(driver,30);
	 			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@textvalue = 'GOLD BUNDLE WITH COSMETIC']")));
		 		driver.findElement(By.xpath("//input[@textvalue = 'GOLD BUNDLE WITH COSMETIC']")).click();
		 		//driver.findElement(By.xpath("//input[@textvalue = 'GOLD BUNDLE WITH COSMETIC']")).click();
		 		}	 		
	 		else if(bundleselection.equalsIgnoreCase("PLATINUM BUNDLE WITH COSMETIC")){	 			
	 			WebDriverWait wait = new WebDriverWait(driver, 20);
	 			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@textvalue = 'PLATINUM BUNDLE WITH COSMETIC']")));
		 		driver.findElement(By.xpath("//input[@textvalue = 'PLATINUM BUNDLE WITH COSMETIC']")).click();
		 		//driver.findElement(By.xpath("//input[@textvalue = 'PLATINUM BUNDLE WITH COSMETIC']")).click();
		 		}
		    else if(bundleselection.equalsIgnoreCase("BRONZE BUNDLE WITH COSMETIC")){
		    	WebDriverWait wait = new WebDriverWait(driver, 30);
		 		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@textvalue = 'BRONZE BUNDLE WITH COSMETIC']")));
				driver.findElement(By.xpath("//input[@textvalue = 'BRONZE BUNDLE WITH COSMETIC']")).click();
				//driver.findElement(By.xpath("//input[@textvalue = 'BRONZE BUNDLE WITH COSMETIC']")).click();
				}
		    else{
		    	
		    	if(bundleselection.contains("P")){
		    		WebDriverWait wait = new WebDriverWait(driver, 20);
			 		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@textvalue = 'PREMIER TIRE AND WHEEL PROTECTION']")));
					driver.findElement(By.xpath("//input[@textvalue = 'PREMIER TIRE AND WHEEL PROTECTION']")).click();
					//driver.findElement(By.xpath("//input[@textvalue = 'PREMIER TIRE AND WHEEL PROTECTION']")).click();
		    	}
		    	
		    	if(bundleselection.contains("X")){
		    		WebDriverWait wait = new WebDriverWait(driver, 20);
			 		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@textvalue = 'WINDSHIELD PROTECTION']")));
					driver.findElement(By.xpath("//input[@textvalue = 'WINDSHIELD PROTECTION']")).click();	
					//driver.findElement(By.xpath("//input[@textvalue = 'WINDSHIELD PROTECTION']")).click();
		    	}
		    	
		    	if(bundleselection.contains("D")){
		    		WebDriverWait wait = new WebDriverWait(driver, 20);
			 		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@textvalue = 'DENT PROTECTION']")));
					driver.findElement(By.xpath("//input[@textvalue = 'DENT PROTECTION']")).click();
					//driver.findElement(By.xpath("//input[@textvalue = 'DENT PROTECTION']")).click();
		    	}			    	
		    	
		    	if(bundleselection.contains("K")){
		    		WebDriverWait wait = new WebDriverWait(driver, 20);
			 		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@textvalue = 'KEY PROTECTION']")));
					driver.findElement(By.xpath("//input[@textvalue = 'KEY PROTECTION']")).click();
					//driver.findElement(By.xpath("//input[@textvalue = 'KEY PROTECTION']")).click();
		    	}
		    	   			    	 	    
		    }
		 			   
		selectTermMonth(termMonth);		
		
	}
}
	
	@FindBy(id="plan")
	public WebElement Plan;

	public void selectPlan(String plan){
		try{			
			WebDriverWait wait = new WebDriverWait(driver, 30);
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

	public void selectRegNumber(String rNumber){
		try{			
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("registn_number")));
			regNumber.sendKeys("0123456789");				
		}
		catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}	
	}

	 @FindBy(id="term_months")
	 public WebElement term_month;
	
	 public void selectTermMonthDropdown(String termmonth){
	 	try{
	 		WebDriverWait wait = new WebDriverWait(driver, 30);
	 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("term_months")));	 		
	 		Select select = new Select(driver.findElement(By.id("term_months")));
	 		select.selectByVisibleText(termmonth);
	 	}catch(Exception e){	 	
	 		GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
	 	}
	 }		

	 @FindBy(id="term_miles")
	 public WebElement term_miles;
	 	
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

	 @FindBy(id="deductible")
	 public WebElement deductible;
	 	
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
	 	
	@FindBy(id="term_month_txt")
	public WebElement termMonth;
	//Term Month if it is a text box
	public void selectTermMonth(String Month){
		try{			
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(By.id("term_month_txt")));
			termMonth.sendKeys(Month);			
		}
		catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}		
	}	
	
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
	
	public void selectRetailCost(String cost){
		try{			
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("retail_cost")));
			if (Retailcost.getAttribute("value").equals("")){
				Retailcost.sendKeys(cost);	
			}					
		}
		catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}		
	}	
	
	@FindBy(id="add_done")
	public WebElement createContract;
	//Continue Button
	public void createContract(){
		try{
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add_done")));
			createContract.click();			
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
