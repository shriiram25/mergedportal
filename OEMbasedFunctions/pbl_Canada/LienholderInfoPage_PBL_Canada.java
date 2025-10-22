package pbl_Canada;

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

public class LienholderInfoPage_PBL_Canada {
	public WebDriver driver;
	
	 public LienholderInfoPage_PBL_Canada(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver,this);
		}

	 @FindBy(id="NoLienholderCheckBox")  //To locate the checkbox with id 'NoLienholderCheckBox' in DOM
	 public WebElement NoLienholderCheckBox; //Declaring a WebElement named NoLienholderCheckBox
	 public void lienHolder(String lien, String product) //Function for selecting an check box id NoLienholderCheckBox 
	 {
		 try{	 		
		 		if(product.contains("MULTI-COVERAGE") || product.contains("VEHICLE SERVICE PROTECTION") || product.contains("PREPAID MAINTENANCE") || product.contains("LEP Claim Free Reward")){
		 		WebDriverWait wait = new WebDriverWait(driver,20); //Setting waiting time of web driver
		 		if(lien.equalsIgnoreCase("null") || lien.equalsIgnoreCase(""))
		 		{	 			
		 		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("NoLienholderCheckBox"))); //Instructing web driver to wait until the presence of element by its locator before it throws error
		 		NoLienholderCheckBox.click();  //Clicking an checkbox
		 		}
		 		else
		 		{ 			
		 			lienBtn(); //Function for master lien holder button 
		 			lienFilter(lien); // funtion for selecting required lien holder
		 			}
		 		}
		 		
		 	}catch(Exception e){	 	
		 		GetScreenshot.captureScreenshot();// Get screen shot.
				Assert.assertTrue(e.getMessage(), false);
		 	}
		 }
	 
		@FindBy(id="lien-btn") //To locate the button with id 'lien-btn' in DOM
		public WebElement lienbtn; //Declaring a WebElement named lienbtn
		 public void lienBtn() //Function for selecting the master lienholder button
		{
			try{
				WebDriverWait wait = new WebDriverWait(driver,20);	//Setting waiting time of web driver								
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lien-btn"))); //Instructing web driver to wait until the visibility of element by its locator before it throws error
				lienbtn.click(); // clicking the master lienholder button		
			}
			catch(Exception e){
				GetScreenshot.captureScreenshot(); // Get screen shot.
				Assert.assertTrue(e.getMessage(),false);
			}		
		}
	 
	 @FindBy(id="saveandaddproduct") //To locate the button with id 'saveandaddproduct' in DOM
		public WebElement saveandadd; //Declaring a WebElement named saveandadd
		public void saveAndAddProduct() //Function for selecting the  saveandaddproduct button
		{
			try{				
				WebDriverWait wait = new WebDriverWait(driver,20); //Setting waiting time of web driver
				wait.until(ExpectedConditions.elementToBeClickable(saveandadd)); //Instructing web driver to wait until the visibility of element by its locator before it throws error
				saveandadd.click(); // clicking the master save and add product button
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("go-to-summary")));//Instructing web driver to wait until the visibility of element by its locator before it throws error
			}
			catch(Exception e){
				GetScreenshot.captureScreenshot(); // Get screen shot.
				ErrorMessage.captureErrorMessage("errorMsgLien"); // Getting the error message shown in the browser.
				writeExcel(); // Function calling the write excel.
				Assert.assertTrue(e.getMessage(), false);
			}		
		}
		
		
		
		@FindBy(id="lien-filter") //To locate the button with id 'lien-filter' in DOM
		public WebElement lienFilter; //Declaring a WebElement named lienFilter
		public void lienFilter(String lien) //Function for sending data to lien text box
		{
			try{
				WebDriverWait wait = new WebDriverWait(driver,20); //Setting waiting time of web driver
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lien-filter"))); //Instructing web driver to wait until the visibility of element by its locator before it throws error
				lienFilter.sendKeys(lien); // sending the data to the text field
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr/td[text() = '"+lien+"']/following-sibling::td[2]/button"))); //Instructing web driver to wait until the visibility of element by its locator before it throws error
				driver.findElement(By.xpath("//tr/td[text() = '"+lien+"']/following-sibling::td[2]/button")).click(); //clicking the select button of searched lien holder.
			}
			catch(Exception e)
			{
				GetScreenshot.captureScreenshot(); // Get screen shot.
				Assert.assertTrue(e.getMessage(),false);
			}		
		}
		
		 public void  writeExcel(){
			 
				try{	
					
				String[] valueToWriteNew=null; //Declaring an array of string to store the data
		        valueToWriteNew = new String[2]; //Initializing string with size
		 		valueToWriteNew[0]= ErrorMessage.ErrorMessage; //Assigning data to the string array
		 		valueToWriteNew[1]= GetScreenshot.filename;		
		 		
		 		ExcelReadWrite ERW=new ExcelReadWrite(); //Creating object to the class named ExcelReadWrite
		 		ERW.writeExcelForm(System.getProperty("user.dir"), "result.xlsx", "VehicleInfo",valueToWriteNew); //Calling function to writing data to excel sheet
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}

}
