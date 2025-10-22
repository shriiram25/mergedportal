package commonFunctions;

import java.util.ArrayList;
import java.util.List;

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


import utility.ErrorMessage;
import utility.ExcelReadWrite;
import utility.GetScreenshot;
import utility.Log;

public class AddNewContractPage {
	
	public String trimstatus=null;
	ArrayList<Object> tempList;
	public WebDriver driver;  
	
	public AddNewContractPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}		
		
	@FindBy(xpath=".//*[@id='vindecode']")  //To locate the textbox with xpath './/*[@id='vindecode']' in DOM
	public WebElement vincode;  //Declaring a WebElement named vincode
	public void vinCode(String vinnumber)  //Function to type text in textbox with xpath .//*[@id='vindecode']
	{
		try{
			WebDriverWait wait = new WebDriverWait(driver,20);  //Setting waiting time of web driver
			Thread.sleep(1000L);
			driver.switchTo().frame(0);	 //Instructing web driver to switch to the first frame					
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='vindecode']")));  //Instructing web driver to wait until the visibility of element by its locator before it throws error
			
			vincode.sendKeys(vinnumber);  //sending text to the textbox with xpath .//*[@id='vindecode']
			Log.log.debug("Passed: Enter VIN Number:-" + vinnumber );
			
		}
		catch(Exception e){
			GetScreenshot.captureScreenshot();   //Capturing screenshot
			Log.log.debug("Failed: Unable to Enter VIN Number:-" + vinnumber );
			Assert.assertTrue(e.getMessage(),false);
		}		
	}
	
	
	@FindBy(id="vin-decode-btn")   //To locate the button with id 'vin-decode-btn' in DOM
	public WebElement vinDecodeBtn;  //Declaring a WebElement named vinDecodeBtn
	@SuppressWarnings("finally")
	public boolean vinDecode()   //Function to click on button with id 'vin-decode-btn'
	{
		boolean flag =false;
		try{
			WebDriverWait wait = new WebDriverWait(driver,20);  //Setting waiting time of web driver		 	
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("vin-decode-btn")));  //Instructing web driver to wait until the visibility of element by its locator before it throws error
			vinDecodeBtn.click();  //Clicking on button with id vin-decode-btn			
			 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("vintrim")));  //Instructing web driver to wait until the visibility of element by its locator
			 trimstatus=vinTrim();
			 if (trimstatus.equalsIgnoreCase("Pass"))
			 {
				 Log.log.debug("Passed: Click on VIN Decode" );
				    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("getProduct")));
					flag = true;
			 }
			 else if(trimstatus.equalsIgnoreCase("Fail"))
			 {
				 Log.log.debug("Failed: Unable to VIN Decode" );
				 flag = false; 
			 }
			
			
		}
		catch(Exception e){
			GetScreenshot.captureScreenshot();  //Capturing screenshot
			ErrorMessage.captureErrorMessage("errorMessage_vin");  //Capturing error message
			Log.log.debug("Failed: Unable to Click on VIN Decode" );
			flag = false;
			
		}
		 finally {
			return flag;
		}		
	}	
	
	@FindBy(id="vintrim")  //To locate the selectbox with id 'vintrim' in DOM
	public WebElement vinTrim;  //Declaring a WebElement named vinTrim 	
	public void vinCodeTrim(String vintrim, String vinnumber)  //Function to select the given option in select box with id 'vintrim'
	{
		try{			
			WebDriverWait wait = new WebDriverWait(driver,20);   //Setting waiting time of web driver			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("vintrim")));   //Instructing web driver to wait until the visibility of element by its locator before it throws error
			Select select = new Select(driver.findElement(By.id("vintrim")));  //Creating the object for select 
	 		select.selectByIndex(1);  //Selecting an option that matches the visibility of text given
	 		System.out.println(vinnumber);
	 		//Log.log.debug("Passed: Select Trim from dropdown -" + vintrim );
		}
		catch(Exception e){
			GetScreenshot.captureScreenshot();	//Capturing screenshot	
			Log.log.debug("Failed: Unable to Select Trim from dropdown -" + vintrim );
			Assert.assertTrue(e.getMessage(),false);
		}		
	}	
	
	@FindBy(id="vintrim")
	public WebElement trim;
	public  String vinTrim()
	{
		 WebDriverWait wait = new WebDriverWait(driver, 30);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("vintrim")));
		 Select dropdown = new Select(driver.findElement(By.id("vintrim")));  //Creating the object for select 
			List <WebElement> elementCount = dropdown.getOptions();
	        int itemSize = elementCount.size();
	        System.out.println(itemSize);
	        tempList=new ArrayList<Object>();
	          
	        if (itemSize > 0 )
	        {
	        	trimstatus = "Pass";
	        }
	        else
	        {
	        	trimstatus = "Fail";
	        }
	        tempList.add(trimstatus);
	  	  return trimstatus;
		 
	}
	
	
	
	@FindBy(id="inservicedate")  //To locate the textbox with id 'inservicedate' in DOM
	public WebElement inServiceDate;  //Declaring a WebElement named inServiceDate
	public void inServiceDateVSC(String inServicedate)  //Function to type the given text in textbox with id 'inservicedate'
	{
		try{	
			WebDriverWait wait = new WebDriverWait(driver,20);  //Setting waiting time of web driver
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inservicedate")));   //Instructing web driver to wait until the visibility of element by its locator before it throws error
			if(inServiceDate.getText().equals("") || inServiceDate.getText().equals(null)){
				inServiceDate.sendKeys(inServicedate);  //sending text to the textbox with id inservicedate	
				
				
				//InServicePopupAlert();
				Log.log.debug("Passed: Enter InServiceDate :-" + inServicedate );	
			}
		}
		catch(Exception e){
			GetScreenshot.captureScreenshot();	//Capturing screenshot		
			Log.log.debug("Failed: Unable to Enter InServiceDate :-" + inServicedate );
			Assert.assertTrue(e.getMessage(),false);
		}	
	}	
	
	@FindBy(id="inservicedate")  //To locate the textbox with id 'inservicedate' in DOM
	public WebElement inServiceDate1;  //Declaring a WebElement named inServiceDate
	public void inServiceDateVSCVW(String inServicedate)  //Function to type the given text in textbox with id 'inservicedate'
	{
		try{	
			WebDriverWait wait = new WebDriverWait(driver,20);  //Setting waiting time of web driver
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inservicedate")));   //Instructing web driver to wait until the visibility of element by its locator before it throws error
			if(inServiceDate.getText().equals("") || inServiceDate.getText().equals(null)){
				inServiceDate.sendKeys(inServicedate);  //sending text to the textbox with id inservicedate	
				inServiceDate.sendKeys(Keys.TAB);
				driver.findElement(By.id("site-wrap")).click();
				
				InServicePopupAlert();
				Log.log.debug("Passed: Enter InServiceDate :-" + inServicedate );	
			}
		}
		catch(Exception e){
			GetScreenshot.captureScreenshot();	//Capturing screenshot		
			Log.log.debug("Failed: Unable to Enter InServiceDate :-" + inServicedate );
			Assert.assertTrue(e.getMessage(),false);
		}	
	}	
		
	@FindBy(id="isd_unmatch_ok")
	public WebElement InServiceConfirm;
	//Continue Button
	public void InServicePopupAlert(){
		try{
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='OK']")));				
			InServiceConfirm.click();
		}			
		catch(Exception e){
			GetScreenshot.captureScreenshot();
			ErrorMessage.captureErrorMessage("errorMessage");
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id = "province")
	public WebElement Province;
	public void selectProvince(String province){
		try{
			WebDriverWait wait = new WebDriverWait(driver,20);  //Setting waiting time of web driver
			wait.until(ExpectedConditions.visibilityOf(Province));   //Instructing web driver to wait until the visibility of element by its locator before it throws error
			Select sel = new Select(Province);
			sel.selectByVisibleText(province);
			
		}
		catch(Exception e){
			e.printStackTrace();
			GetScreenshot.captureScreenshot();	//Capturing screenshot		
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="contractdate")   //To locate the textbox with id 'contractdate' in DOM
	public WebElement contractDate;   //Declaring a WebElement named contractDate
	public void contractDate(String contractPurchasedate)   //Function to type the given text in textbox with id 'contractdate'
	{
		try{
			WebDriverWait wait = new WebDriverWait(driver,20);  //Setting waiting time of web driver
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("contractdate")));   //Instructing web driver to wait until the visibility of element by its locator before it throws error
			contractDate.sendKeys(contractPurchasedate);  //sending text to the textbox with id contractdate
			contractDate.sendKeys(Keys.TAB);
			driver.findElement(By.id("site-wrap")).click();
		}
		catch(Exception e){
			GetScreenshot.captureScreenshot();  //Capturing screenshot		
			Assert.assertTrue(e.getMessage(),false);
		}
	}	
	
	@FindBy(id="isvehiclepurchase")   //To locate the selectbox with id 'isvehiclepurchase' in DOM
	public WebElement isVehiclepurchase;   //Declaring a WebElement named isVehiclepurchase
	
	@FindBy(id="vehicledate")   //To locate the textbox with id 'vehicledate' in DOM
	public WebElement vehicledate;   //Declaring a WebElement named vehicledate
	
	public void isVehiclePurchase(String isvehiclepurchase, String vehiclepurchasedate) //Function for selecting an option in Select box with id isvehiclepurchase and type given text in textbox with id vehicledate
	{
		try{	
			WebDriverWait wait = new WebDriverWait(driver,20);  //Setting waiting time of web driver
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("isvehiclepurchase")));  //Instructing web driver to wait until the visibility of element by its locator before it throws error
			Select select = new Select(driver.findElement(By.id("isvehiclepurchase")));  //Creating the object for select
						
			select.selectByVisibleText(isvehiclepurchase);	 //Selecting an option that matches the visibility of text given
	 		if(isvehiclepurchase.equalsIgnoreCase("No"))   //Checking wheather the isvehiclepurchase is "NO" using if condition
	 		{	 			
	 			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("vehicledate")));  //Instructing web driver to wait until the visibility of element by its locator before it throws error
	 			vehicledate.sendKeys(vehiclepurchasedate);	//If true sending text to the textbox with id vehicledate			
	 		} 		
		}
		catch(Exception e){
			GetScreenshot.captureScreenshot();	//Capturing screenshot		
			Assert.assertTrue(e.getMessage(),false);
		}
	}
		
	@FindBy(id="vehicle_condition")   //To locate the selectbox with id 'vehicle_condition' in DOM
	public WebElement vehiclecondition;  //Declaring a WebElement named vehiclecondition
	public void vehicleCondition(String vehicle_condition)  //Function for selecting an option in Select box with id vehicle_condition
	{
		try{	
			WebDriverWait wait = new WebDriverWait(driver,20);  //Setting waiting time of web driver
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("vehicle_condition")));   //Instructing web driver to wait until the visibility of element by its locator before it throws error
			Select select = new Select(driver.findElement(By.id("vehicle_condition")));  //Creating the object for select
	 		select.selectByVisibleText(vehicle_condition);	 //Selecting an option that matches the visibility of text given						
		}
		catch(Exception e){
			GetScreenshot.captureScreenshot();	 //Capturing screenshot		
			Assert.assertTrue(e.getMessage(),false);
		}
	}	
	
	@FindBy(id="financeType")   //To locate the selectbox with id 'financeType' in DOM
	public WebElement financeType;   //Declaring a WebElement named financeType
	public void financeType(String finance_Type)  //Function for selecting an option in Select box with id financeType
	{
		try{					
			WebDriverWait wait = new WebDriverWait(driver,20);  //Setting waiting time of web driver
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("financeType")));  //Instructing web driver to wait until the visibility of element by its locator before it throws error
			Select select = new Select(driver.findElement(By.id("financeType")));  //Creating the object for select
	 		select.selectByVisibleText(finance_Type);  //Selecting an option that matches the visibility of text given									
		}
		catch(Exception e){
			GetScreenshot.captureScreenshot();   //Capturing screenshot	
			Assert.assertTrue(e.getMessage(),false);
		}
	}	
	
	@FindBy(id="odometer")  //To locate the textbox with id 'odometer' in DOM
	public WebElement odo_Meter;  //Declaring a WebElement named odo_Meter
	public void odoMeter(String odometer)  //Function to type the given text in textbox with id 'odometer'
	{
		try{		
			WebDriverWait wait = new WebDriverWait(driver,20);  //Setting waiting time of web driver
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("odometer")));  //Instructing web driver to wait until the visibility of element by its locator before it throws error
			odo_Meter.sendKeys(odometer);	//sending text to the textbox with id odometer					
		}
		catch(Exception e){
			GetScreenshot.captureScreenshot();  //Capturing screenshot			
			Assert.assertTrue(e.getMessage(),false);
		}
	}	
	
	@FindBy(id="getProduct")  //To locate the button with id 'getProduct' in DOM
	public WebElement getProductBtn;  //Declaring a WebElement named getProductBtn
	public void getProduct()  //Function to click on button with id getProduct
	{
		try{			
			WebDriverWait wait = new WebDriverWait(driver,40);  //Setting waiting time of web driver
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("getProduct")));  //Instructing web driver to wait until the visibility of element by its locator before it throws error
			getProductBtn.click();	//Clicking on button with id getProduct			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("product")));  //Instructing web driver to wait until the visibility of element by its locator before it throws error
		}
		catch(Exception e){
			GetScreenshot.captureScreenshot();  //Capturing screenshot
			ErrorMessage.captureErrorMessage("errorMessage");  //Capturing Error message				
			Assert.assertTrue(e.getMessage(),false);
		}		
	}	
	
	public void convertProvinceInFullNameAndSelect(String province)
	{
		try{
			WebDriverWait wait = new WebDriverWait(driver,20); //Setting waiting time for web driver
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("province"))); //Instructing web driver to wait until the visibility of element by its locator before it throws error
			Select sel = new Select(Province);
			
			if(province.equalsIgnoreCase("Other"))// if province = 'Other' is selected
			{
				sel.selectByVisibleText(province);// province 'other' will be selected
			}
			else // selecting province value as in test data 
				{
				List<WebElement> provinceList = sel.getOptions();
				if(provinceList.size()>0)
					{
						for(int i=1;i<provinceList.size()-1; i++)				
						{
							// Extracting short name of province						
							String [] parts = (provinceList.get(i).getText().trim()).split("\\[ ");  
							String provinceShortname = parts[1].replace(" ]", ""); // Extracted province short name in provinceShortname
	//						 Province short name from feature file will be matched with splitted String
							if(provinceShortname.equals(province))  
							{	
								
								sel.selectByVisibleText(provinceList.get(i).getText());
								break;														
							}						
						}
					}
				}
			}
			catch(Exception e){
			e.printStackTrace();
			System.out.println(province +"province not found in list"); // this will print the province in case not available/matched.
			GetScreenshot.captureScreenshot(); //Capturing screenshot           
			Assert.assertTrue(e.getMessage(),false);
			}	
		}
	
}
