package vci;

import java.util.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.ErrorMessage;
import utility.ExcelReadWrite;
import utility.GetScreenshot;


public class LienholderInfoPage_VCI {
	public WebDriver driver;
	
	 public LienholderInfoPage_VCI(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver,this);
		}

	 @FindBy(id="NoLienholderCheckBox")  //To locate the checkbox with id 'NoLienholderCheckBox' in DOM
	 public WebElement NoLienholderCheckBox; //Declaring a WebElement named NoLienholderCheckBox
	 public void lienHolder(String lien) //Function for selecting an check box id NoLienholderCheckBox 
	 {
	 	try{	 			 		
	 		WebDriverWait wait = new WebDriverWait(driver,20); //Setting waiting time of web driver
	 		if(lien.equalsIgnoreCase("null") || lien.equalsIgnoreCase(""))
	 		{
	 			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("NoLienholderCheckBox"))); //Instructing web driver to wait until the presence of element by its locator before it throws error
	 			driver.findElement(By.id("NoLienholderCheckBox")).click();  //Clicking an checkbox
	 		}
	 		else
	 		{ 			
	 			lienBtn(); //Function for master lien holder button 
	 			lienFilter(lien); // funtion for selecting required lien holder
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
			catch(Exception e)
			{
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
		
		@FindBy(id="product")
		public WebElement Product;
		public void verifyProduct(String savedProduct,String savedPlan) //Function for sending data to lien text box
		{
			String liProduct = null;	
			java.util.List<WebElement> allProduct = driver.findElements(By.xpath("//*[@id='productcart_ul']/li"));
				
				String sProduct1 = "AUDI TERM PROTECTION";
				String sProduct2 = "AUDI VEHICLE SERVICE PROTECTION";
				
				String sPlan1 = "TERM PROTECTION PLUS WITH ROTORS"; //No VSC
				String sPlan2 = "TERM PROTECTION PLUS"; //No VSC
				String sPlan3 = "TERM PROTECTION WITH ROTORS"; // VSC
				String sPlan4 = "TERM PROTECTION"; // VSC
				
				//AUDI MULTICOVERAGE PROTECTION
				
				for( WebElement product : allProduct){
					// get product form UI list
					liProduct = Product.getText();
					// checkpoint to verify no existence of VSC products in SelectProduct dropdown for TPP or TPP+R
					if (liProduct.equalsIgnoreCase(sProduct1) && (savedPlan.contains("PLUS"))) 
					{
						// no VSC
						WebDriverWait wait = new WebDriverWait(driver, 60);
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("product")));
						Select select = new Select(driver.findElement(By.id("product")));
				 		select.selectByVisibleText(sProduct2);						
					}
					// checkpoint to verify VSC products in SelectProduct dropdown for TP or TP+R
					else if (liProduct.equalsIgnoreCase(sProduct1) && (!(savedPlan.contains("PLUS"))))
					{
						// VSC
						WebDriverWait wait = new WebDriverWait(driver, 60);
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("product")));
						Select select = new Select(driver.findElement(By.id("product")));
						///////						
						ArrayList <String> valuesToCheck;
						List<WebElement> boxProducts = select.getOptions();
						int i = 0;
						ArrayList <Boolean> isPresent = new ArrayList <Boolean>();
						 for(WebElement option : boxProducts)
						 {
						    select.selectByIndex(i);
				/* y		    if(select.getFirstSelectedOption().getText().equals(valueToCheck.get(i)))
						    {
						      isPresent.get(0) = true;
						    }
						 }
						 if(isPresent.get(0)!=true)
						 {
						     isPresent.get(0)=false;
						 }*/
						///////////
//				 		select.selectByVisibleText(sProduct2);
						//select.
				 		//select.getFirstSelectedOption().getText().equalsIgnoreCase(sProduct2)				 		
				 		
					}
					
					System.out.println(product.getText());
					
					System.out.println("*********************************************************************");
				}
		
			}		
		
		/*public void  writeExcel(){
			 
				try{	
					
				String[] valueToWriteNew=null; //Declaring an array of string to store the data
		        valueToWriteNew = new String[2]; //Initializing string with size
		 		valueToWriteNew[0]= ErrorMessage.ErrorMessage; //Assigning data to the string array
		 		valueToWriteNew[1]= GetScreenshot.filename;		
		 		
		 		//ExcelReadWrite ERW=new ExcelReadWrite(); //Creating object to the class named ExcelReadWrite
		 		//ERW.writeExcelForm(System.getProperty("user.dir"), "result.xlsx", "VehicleInfo",valueToWriteNew); //Calling function to writing data to excel sheet
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}*/
		 
}}
