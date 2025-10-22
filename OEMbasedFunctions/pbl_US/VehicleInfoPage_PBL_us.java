package pbl_US;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import utility.ErrorMessage;
import utility.ExcelReadWrite;
import utility.GetScreenshot;

public class VehicleInfoPage_PBL_us {
	public WebDriver driver;
	
	
	// Declaring variables to write excel
	 public String vehicleMSRP;
	 public String financeAmount;
	 public String APR; 
	 public String grossGapCost;
	 public String vehiclePrice;
	 public VehicleInfoPage_PBL_us(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver,this);
		}
		 
	 // function for entering the value considering the product 
	 // Comparing the product selected we are sending the data to the required field
	 public void entervehicleinfo(String product,String vehiclemsrp, String financeamount, String apr, String grossgapcost, String vehicleprice){
		 
		 vehicleMSRP = vehiclemsrp;
		 financeAmount = financeamount;
		 APR = apr;
		 grossGapCost = grossgapcost;
		 vehiclePrice = vehicleprice;
		  
		 
		 if (!product.contains("PREPAID MAINTENANCE")){
				 
			 
			 	if (product.contains("QUALITYSHIELD GAP PROTECTION") || product.contains("GAP PROTECTION")){
					 	vehicleMSRP(vehiclemsrp);
					 	financeAmount(financeamount);
					 	arp(apr);
					 	vehiclePurchasePrice(vehicleprice);
					 	continueBtn();
				  	}		   
				  
			 	else if (product.contains("GAP PLUS") || product.contains("PORSCHE TERM PROTECTION") || product.contains("PORSCHE TERM PROTECTION PLUS")){
				 	vehicleMSRP(vehiclemsrp);
				 	financeAmount(financeamount);
				 	grossCapCost(grossgapcost);
				 	arp(apr);
				 	vehiclePurchasePrice(vehicleprice);
				 	continueBtn();
			  	}
				 else if(product.contains("MULTI-COVERAGE")){
				 
					  if(!financeamount.equals("") || !vehicleprice.equals("")){
						  
						  if(!financeamount.equals("") && !vehicleprice.equals("")){
							  financeAmount(financeamount);
							  vehiclePurchasePrice(vehicleprice);
							  continueBtn();
						  	}
						  
						  else {
							  if(!financeamount.equals("")){
								  financeAmount(financeamount);
								  continueBtn();
							  	  }
							  else if(!vehicleprice.equals("")){
								  vehiclePurchasePrice(vehicleprice);
								  continueBtn();
								  }
						  	  }
					  }
					  
					  
				  }	
				 
				  else if(product.contains("VEHICLE SERVICE PROTECTION")){
					  
				   vehiclePurchasePrice(vehicleprice);
				   continueBtn();			  
				  }		  
				  
				  else if(product.contains("LEASE-END PROTECTION"))
				  {
				   
					  vehicleMSRP(vehiclemsrp);
				   	
					  if(!grossgapcost.equals("")){
					   		grossCapCost(grossgapcost);
					   		continueBtn();
				   		
					  }
				   
				  }
		 		}
	 }

	 @FindBy(id="vehicleMSRP_") //To locate the button with id 'vehicleMSRP_' in DOM
	 public WebElement vehicleMsrp; //Declaring a WebElement named vehicleMsrp
	 //send values of vehicleMSRP
	 public void vehicleMSRP(String vehicle_msrp)
	 {
	 	try{	 
	 		WebDriverWait wait = new WebDriverWait(driver, 20); //Setting waiting time of web driver
	 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("vehicleMSRP_"))); //Instructing web driver to wait until the visibility of element by its locator before it throws error
	 		vehicleMsrp.sendKeys(vehicle_msrp); // sending the data to the text field
	 	}catch(Exception e){
	 	
	 		GetScreenshot.captureScreenshot(); // Get screen shot.
	 		Assert.assertTrue(e.getMessage(),false);
	 	}
	 }
		/*
		  Finding the financeAmount element id  
		*/
	 @FindBy(id="financeAmount_") //To locate the button with id 'financeAmount_' in DOM
	 public WebElement Financeamount; //Declaring a WebElement named Financeamount
	 //send values of financeAmount
	 public void financeAmount(String financeamount)
	 {
	 	try{	 		
	 		WebDriverWait wait = new WebDriverWait(driver, 20); //Setting waiting time of web driver
	 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("financeAmount_"))); //Instructing web driver to wait until the visibility of element by its locator before it throws error
	 		Financeamount.sendKeys(financeamount); // sending the data to the text field
	 	}catch(Exception e){	 	 
	 		GetScreenshot.captureScreenshot(); // Get screen shot.
	 		Assert.assertTrue(e.getMessage(),false);
	 	}
	 }
		/*
		  Finding the  arp element id 
		 */
	 @FindBy(id="arp_") //To locate the button with id 'arp_' in DOM
	 public WebElement Arp; //Declaring a WebElement named Arp
	 //send values of arp
	 public void arp(String arp_)
	 {
	 	try{	 		
	 		WebDriverWait wait = new WebDriverWait(driver, 20); //Setting waiting time of web driver
	 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("arp_"))); //Instructing web driver to wait until the visibility of element by its locator before it throws error
	 		Arp.sendKeys(arp_); // sending the data to the text field
	 	}catch(Exception e){
	 	    GetScreenshot.captureScreenshot(); // Get screen shot.
	 		Assert.assertTrue(e.getMessage(),false);
	 	}
	 }
		/*
		  Finding the continue Button element id
		 */
	 @FindBy(id="con-continue")//To locate the button with id 'con-continue' in DOM
		public WebElement Continue; //Declaring a WebElement named Continue
		//click continue button
		public void continueBtn(){
			try{
				WebDriverWait wait = new WebDriverWait(driver, 20); //Setting waiting time of web driver
				wait.until(ExpectedConditions.elementToBeClickable(Continue)); //Instructing web driver to wait until the visibility of element by its locator before it throws error
				Continue.click(); // clicking the master continue button
				//writeExcel();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lien-btn"))); //Instructing web driver to wait until the visibility of element by its locator before it throws error
			}
			catch(Exception e){
				GetScreenshot.captureScreenshot(); // Get screen shot.
				ErrorMessage.captureErrorMessageXpath("//div[@id='errorMsgFinanace']/label"); // Getting the error message shown in the browser.
				//writeExcel(); // Function calling the write excel.
				Assert.assertTrue(e.getMessage(),false);
			}		
		}
		/*
		  Finding the  vehiclePurchasePrice element id 
		 */
		 @FindBy(id="vehicle_purchase_price") //To locate the button with id 'vehicle_purchase_price' in DOM
		 public WebElement vehiclePurchasePrice; //Declaring a WebElement named vehiclePurchasePrice
		 //send values of vehicle_purchase_price
		 public void vehiclePurchasePrice(String vPurchacePrice)
		 {
		 	try{
		 		WebDriverWait wait = new WebDriverWait(driver, 20); //Setting waiting time of web driver
		 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("vehicle_purchase_price"))); //Instructing web driver to wait until the visibility of element by its locator before it throws error
		 		 vehiclePurchasePrice.sendKeys(vPurchacePrice); // sending the data to the text field
		 	}catch(Exception e){
		 		GetScreenshot.captureScreenshot(); // Get screen shot.
				Assert.assertTrue(e.getMessage(),false);
		 	}
		 }
		 /*
		  Finding the rossCapCost element id 
		 */
		 @FindBy(id="grossCapCost_") //To locate the button with id 'grossCapcost_' in DOM
		 public WebElement grossCapCost; //Declaring a WebElement named grossCapCost
		 //send values of grossCapCost
		 public void grossCapCost(String grossCapcost)
		 {
		 	try{
		 		WebDriverWait wait = new WebDriverWait(driver, 20); //Setting waiting time of web driver
		 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("grossCapCost_"))); //Instructing web driver to wait until the visibility of element by its locator before it throws error
		 		grossCapCost.sendKeys(grossCapcost); // sending the data to the text field
		 	}catch(Exception e){
		 		GetScreenshot.captureScreenshot(); // Get screen shot.
				Assert.assertTrue(e.getMessage(),false);
		 	}
		 }
		 
	
}

