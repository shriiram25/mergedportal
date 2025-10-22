package vroom;



import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.junit.Assert;
import utility.ErrorMessage;
import utility.ExcelReadWrite;
import utility.GetScreenshot;

public class CustomerDetailsPage_Vroom {

	public WebDriver driver;

	public CustomerDetailsPage_Vroom(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "isBusiness")  //To locate the select box with id 'isBusiness' in DOM
	public WebElement isBussiness;	//Declaring a WebElement named isBussiness

	public void isBussiness(String isbussiness, String businessname, String fname, String lname)  //Function to select wheather bussiness or not
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);  //Setting waiting time of web driver
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("isBusiness")));  //Instructing web driver to wait until the visibility of element by its locator before it throws error
			Select select = new Select(driver.findElement(By.id("isBusiness")));  //Creating the object for select 
			select.selectByVisibleText(isbussiness);	//Selecting an option that matches the visibility of text given		
			
			if(isbussiness.equalsIgnoreCase("Yes")) {  //Checking if  isBussiness is equal to "Yes"			
				businessName(businessname);            //If true sending bussiness name		
			}
			else {									   //if false Sending firstname and lastname				
				firstName(fname); 
				lastName(lname);
			}			
		} 
		catch (Exception e) {			
			GetScreenshot.captureScreenshot();  //Capturing screenshot
			Assert.assertTrue(e.getMessage(), false);
		}
	}	

	@FindBy(id = "business_name")   //To locate the textbox with id 'business_name' in DOM
	public WebElement business_name;  //Declaring a WebElement named business_name
	
	public void businessName(String businessname)  //Function to type the text in textbox with id business_name
	{
		try {	
			WebDriverWait wait = new WebDriverWait(driver, 20);  //Setting waiting time of web driver
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("business_name")));  //Instructing web driver to wait until the visibility of element by its locator before it throws error
			business_name.sendKeys(businessname);  //Sending the given text to the textbox with id business_name
		} 
		catch (Exception e) {
			GetScreenshot.captureScreenshot();  //Capturing screenshot
			Assert.assertTrue(e.getMessage(), false);
		}
	}
	
	
	@FindBy(id = "first_name")  //To locate the textbox with id 'first_name' in DOM
	public WebElement fname;  //Declaring a WebElement named fname
	
	public void firstName(String firstName)  //Function to type the text in textbox with id first_name
	{
		try {			
			WebDriverWait wait = new WebDriverWait(driver, 20);  //Setting waiting time of web driver
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first_name")));  //Instructing web driver to wait until the visibility of element by its locator before it throws error
			fname.sendKeys(firstName);  //Sending the given text to the textbox with id first_name
		}
		catch (Exception e) { 
			GetScreenshot.captureScreenshot();  //Capturing screenshot
			Assert.assertTrue(e.getMessage(), false);
		}
	}

	
	@FindBy(id = "last_name")  //To locate the textbox with id 'last_name' in DOM
	public WebElement lname;  //Declaring a WebElement named lname

	public void lastName(String lastName)  //Function to type the text in textbox with id last_name
	{
		try {				
			WebDriverWait wait = new WebDriverWait(driver, 20);  //Setting waiting time of web driver
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("last_name")));  //Instructing web driver to wait until the visibility of element by its locator before it throws error
			lname.sendKeys(lastName);  //Sending the given text to the textbox with id lastName
		}
		catch (Exception e) {			
			GetScreenshot.captureScreenshot();  //Capturing screenshot
			Assert.assertTrue(e.getMessage(), false);
		}
	}

	
	@FindBy(id = "address_1")  //To locate the textbox with id 'address_1' in DOM
	public WebElement Address;  //Declaring a WebElement named Address

	public void address(String address)  //Function to type the text in textbox with id address_1
	{
		try {	
			WebDriverWait wait = new WebDriverWait(driver, 20);  //Setting waiting time of web driver
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("address_1")));  //Instructing web driver to wait until the visibility of element by its locator before it throws error
			Address.sendKeys(address);   //Sending the given text to the textbox with id address_1
		} 
		catch (Exception e) {			
			GetScreenshot.captureScreenshot();  //Capturing screenshot
			Assert.assertTrue(e.getMessage(), false);
		}
	}

	@FindBy(id = "zip")  //To locate the textbox with id 'zip' in DOM
	public WebElement zip;  //Declaring a WebElement named zip

	public void zip(String zipCode)  //Function to type the text in textbox with id zip
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);  //Setting waiting time of web driver
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("zip")));  //Instructing web driver to wait until the visibility of element by its locator before it throws error			
			zip.sendKeys(zipCode);  //Sending the given text to the textbox with id zip				
		}
		catch (Exception e) {
			GetScreenshot.captureScreenshot();  //Capturing screenshot
			Assert.assertTrue(e.getMessage(), false);
		}
	}

	@FindBy(id = "city")   
	public WebElement city; 

	public void zip1()  
	{
		try {	
			WebDriverWait wait = new WebDriverWait(driver, 20);			
			wait.until(ExpectedConditions.elementToBeClickable(By.id("city")));
		} 
		catch (Exception e) {			
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(), false);
		}
	}	
	

	@FindBy(id = "country") 
	public WebElement country;

	public void country() {
		try {			
			WebDriverWait wait = new WebDriverWait(driver, 20);			
			wait.until(ExpectedConditions.elementToBeClickable(By.id("country")));
		} catch (Exception e) {
			
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(), false);
		}
	}	
	
	@FindBy(id = "state") 
	public WebElement state;

	public void state() {
		try {			
			WebDriverWait wait = new WebDriverWait(driver, 20);			
			wait.until(ExpectedConditions.elementToBeClickable(By.id("state")));
		}
		catch (Exception e) {			
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(), false);
		}
	}	
	
	
	@FindBy(id = "phone_1")  //To locate the textbox with id 'phone_1' in DOM
	public WebElement phone;  //Declaring a WebElement named phone

	public void phone(String phoneNo)  //Function to type the text in textbox with id phone_1
	{
		try {		
			WebDriverWait wait = new WebDriverWait(driver, 20);  //Setting waiting time of web driver
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("phone_1")));  //Instructing web driver to wait until the visibility of element by its locator before it throws error	 		
			phone.sendKeys(phoneNo);  //Sending the given text to the textbox with id zip
		}
		catch (Exception e) {			
			GetScreenshot.captureScreenshot();  //Capturing screenshot
			Assert.assertTrue(e.getMessage(), false);
		}
	}

	@FindBy(id = "email")  //To locate the textbox with id 'email' in DOM
	public WebElement Email;  //Declaring a WebElement named Email

	public void email(String email)  //Function to type the text in textbox with id email
	{
		try {	
			WebDriverWait wait = new WebDriverWait(driver, 20);  //Setting waiting time of web driver
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));  //Instructing web driver to wait until the visibility of element by its locator before it throws error
			Email.sendKeys(email);   //Sending the given text to the textbox with id email
		}
		catch (Exception e) {			
			GetScreenshot.captureScreenshot();	//Capturing screenshot		
			Assert.assertTrue(e.getMessage(), false);
		}
	}	
	
	public void isCosigner(String coSigner,String cofname,String colname, String coaddress,String cozip, String cophonenumber, String coemail)  //Function for checking isCosigner or not
	{		
		if(coSigner.equalsIgnoreCase("Yes")) //Checking if coSigner equal to "Yes"
		{
			coSigner(coSigner); 
			coFname(cofname);
			coLname(colname);
			coSignerAddress1(coaddress);
			coSignerPostalcode(cozip);
			coSignerPhone1(cophonenumber);
			coSignerEmail(coemail);			
		}
		else{
			//if false send the coSigner to the respected function
			//coSigner(coSigner);
		}
		
	}
	
	@FindBy(id = "isCoSigner")  //To locate the select box with id 'isCoSigner' in DOM
	public WebElement CoSigner; //Declaring a WebElement named CoSigner
	
	public void coSigner(String coSigner) //Function to select if coSigner is available or not
	{
		try {		
			WebDriverWait wait = new WebDriverWait(driver, 20);  //Setting waiting time of web driver
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("isCoSigner")));   //Instructing web driver to wait until the visibility of element by its locator before it throws error
			Select select = new Select(driver.findElement(By.id("isCoSigner")));  //Creating an object for Select
			select.selectByVisibleText(coSigner);  //Selecting an option that matches the visibility of text given
		} 
		catch (Exception e) {			
			GetScreenshot.captureScreenshot();  //Capturing Screenshot
			Assert.assertTrue(e.getMessage(), false);
		}
	}
	
	@FindBy(id = "co_fname")  //To locate the textbox with id 'co_fname' in DOM
	public WebElement co_fname;  //Declaring a WebElement named co_fname
	
	public void coFname(String cofname) //Function to type the text in textbox with id co_fname
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);  //Setting waiting time of web driver
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("co_fname")));  //Instructing web driver to wait until the visibility of element by its locator before it throws error
			co_fname.sendKeys(cofname);  //sending text to the textbox with id co_fname		   
		}
		catch (Exception e) {
			GetScreenshot.captureScreenshot(); //Capturing screenshot
			Assert.assertTrue(e.getMessage(), false);
		}
	}
	
	@FindBy(id = "co_lname")  //To locate the textbox with id 'co_lname' in DOM
	public WebElement co_lname;  //Declaring a WebElement named co_lname
	
	public void coLname(String colname)  //Function to type the text in textbox with id co_lname 
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);  //Setting waiting time of web driver
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("co_lname")));  //Instructing web driver to wait until the visibility of element by its locator before it throws error
			co_lname.sendKeys(colname);   //sending text to the textbox with id co_lname	
		}
		catch (Exception e) {
			GetScreenshot.captureScreenshot(); //Capturing screenshot
			Assert.assertTrue(e.getMessage(), false);
		}
	}
	
	@FindBy(id = "coSigner_Address1")  //To locate the textbox with id 'coSigner_Address1' in DOM
	public WebElement coSigner_Address1;  //Declaring a WebElement named coSigner_Address1
	
	public void coSignerAddress1(String coSignerAddress1)  //Function to type the text in textbox with id coSigner_Address1
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);  //Setting waiting time of web driver
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("coSigner_Address1")));  //Instructing web driver to wait until the visibility of element by its locator before it throws error
			coSigner_Address1.sendKeys(coSignerAddress1);  //sending text to the textbox with id coSigner_Address1
		}
		catch (Exception e) {
			GetScreenshot.captureScreenshot();  //Capturing screenshot
			Assert.assertTrue(e.getMessage(), false);
		}
	}
	
	
	@FindBy(id = "coSigner_postalcode")  //To locate the textbox with id 'coSigner_postalcode' in DOM
	public WebElement coSigner_postalcode;  //Declaring a WebElement named coSigner_postalcode
	
	public void coSignerPostalcode(String coSignerpostalcode)  //Function to type the text in textbox with id coSigner_postalcode
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);  //Setting waiting time of web driver
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("coSigner_postalcode")));  //Instructing web driver to wait until the visibility of element by its locator before it throws error
			coSigner_postalcode.sendKeys(coSignerpostalcode);  //sending text to the textbox with id coSigner_postalcode
		}
		catch (Exception e) {
			GetScreenshot.captureScreenshot();			 
			Assert.assertTrue(e.getMessage(), false);
		}
	}
	
	@FindBy(id = "coSigner_city")
	public WebElement coSigner_city;	
	public void coSignercity() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("coSigner_city")));
		}
		catch (Exception e) {
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(), false);
		}
	}
	
	@FindBy(id = "coSigner_Country")
	public WebElement coSigner_Country;	
	public void coSignercountry() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("coSigner_Country")));	
		}
		catch (Exception e) {
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(), false);
		}
	}
	
	@FindBy(id = "coSigner_state_province")
	public WebElement coSigner_state_province;
	
	public void coSigner_state_province() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("coSigner_state_province")));		
		}
		catch (Exception e) {
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(), false);
		}
	}
	
	@FindBy(id = "coSigner_phone1")  //To locate the textbox with id 'coSigner_phone1' in DOM
	public WebElement coSigner_phone1;  //Declaring a WebElement named coSigner_phone1
	
	public void coSignerPhone1(String coSignerphone1)  //Function to type the text in textbox with id coSigner_phone1
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);  //Setting waiting time of web driver
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("coSigner_phone1")));  //Instructing web driver to wait until the visibility of element by its locator before it throws error
			coSigner_phone1.sendKeys(coSignerphone1);  //sending text to the textbox with id coSigner_phone1
		}
		catch (Exception e) {
			GetScreenshot.captureScreenshot();  //Capture screenshot
			Assert.assertTrue(e.getMessage(), false);
		}
	}
	
	@FindBy(id = "coSigner_email")  //To locate the textbox with id 'coSigner_email' in DOM
	public WebElement coSigner_email;  //Declaring a WebElement named coSigner_email
	 
	public void coSignerEmail(String coSigneremail)  //Function to type the text in textbox with id coSigner_email
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);  //Setting waiting time of web driver
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("coSigner_email")));  //Instructing web driver to wait until the visibility of element by its locator before it throws error
			coSigner_email.sendKeys(coSigneremail);  //sending text to the textbox with id coSigner_email
		} catch (Exception e) {
			GetScreenshot.captureScreenshot();  //Capture screenshot			
			Assert.assertTrue(e.getMessage(), false);
		}
	}	

	@FindBy(id = "cont-btn")  //To locate the button with id 'cont-btn' in DOM
	public WebElement Continue;  //Declaring a WebElement named Continue

	public void continueBtn(String product)  //Function to type the text in textbox with id cont-btn
	{
		try {			
			WebDriverWait wait = new WebDriverWait(driver, 20);  //Setting waiting time of web driver
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cont-btn")));   //Instructing web driver to wait until the visibility of element by its locator before it throws error
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loadingzip")));   //Instructing web driver to wait until the visibility of element by its locator before it throws error
			Continue.click(); //Clicking on button with id cont-btn			
			
			if(product.contains("SERVICE") || product.contains("GAP PROTECTION")) //Checking if the product is equal to the value stored in product1
			{			
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("vehicleMSRP_")));  //if both the conditions were false instructing web driver to wait until the visibility of element by its locator before it throws error
			}				
		}
		catch (Exception e) {
			GetScreenshot.captureScreenshot();  //Capturing Screenshot	
			ErrorMessage.captureErrorMessage("addNewCustomerErrorMsg");  //Capturing error message			
			Assert.assertTrue(e.getMessage(), false);
		}
	}
	
}
