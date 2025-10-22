package bmm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import configurations.Hooks;
import configurations.Step_Definition;

import org.junit.Assert;
import utility.GetScreenshot;
import utility.Log;

public class DealerTaxPage_bmm {

	public static String webDealerCost = "";
//	public static String webDealerCostTotal = "";
	public static String webDealerGST = "";
	public static String webDealerHST = "";
	public static String webDealerQST = "";
	public static String webDealerPST = "";
	public String DealerProvince = "";
	public static String dealerTaxError = "";
	public static String customerTaxError = "";
	public static String dealerTaxStatus = "";	
	public static String finalStatus = "";
	
	public WebDriver driver;

	public DealerTaxPage_bmm(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "retail_gst_cost")
	public WebElement GST;

	@SuppressWarnings("finally")
	public String enterGST(String gst) {
		String status = "";
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(GST)).clear();
			GST.sendKeys(gst);
			status = "PASS";
		} catch (Exception e) {
			status = "FAIL";
			e.printStackTrace();
			GetScreenshot.captureScreenshot();
			// Assert.assertTrue(e.getMessage(),false);
		} finally {
			return status;
		}
	}

	@FindBy(id = "retail_hst_cost")
	public WebElement HST;

	@SuppressWarnings("finally")
	public String enterHST(String hst) {
		String status = "";
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(HST)).clear();
			HST.sendKeys(hst);
			status = "PASS";
		} catch (Exception e) {
			status = "FAIL";
			e.printStackTrace();
			GetScreenshot.captureScreenshot();
			// Assert.assertTrue(e.getMessage(),false);
		} finally {
			return status;
		}
	}

	@FindBy(id = "retail_qst_cost")
	public WebElement QST;

	@SuppressWarnings("finally")
	public String enterQST(String qst) {
		String status = "";
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(QST)).clear();
			QST.sendKeys(qst);
			status = "PASS";
		} catch (Exception e) {
			status = "FAIL";
			e.printStackTrace();
			GetScreenshot.captureScreenshot();
			// Assert.assertTrue(e.getMessage(),false);
		} finally {
			return status;
		}
	}

	@FindBy(id = "retail_pst_cost")
	public WebElement PST;

	@SuppressWarnings("finally")
	public String enterPST(String pst) {
		String status = "";
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(PST)).clear();
			PST.sendKeys(pst);
			status = "PASS";
		} catch (Exception e) {
			status = "FAIL";
			e.printStackTrace();
			GetScreenshot.captureScreenshot();
			// Assert.assertTrue(e.getMessage(),false);
		} finally {
			return status;
		}
	}
	
	@FindBy(id = "retail_cost")
	public WebElement CustomerCost;

	public void enterCustomerCost(String customercost) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("retail_cost")));
			
			String readonly = CustomerCost.getAttribute("disabled");
			System.out.println("The attribute is: "+ readonly);
			
			//>>>>>>>>>>--- (readonly = true) when disabled attribute is present with empty string and it is null when disabled attribute is not present.
			if(readonly == null){
				System.out.println("Disabled attribute does not exist.");
				if(CustomerCost.getAttribute("value").equals("")){
					CustomerCost.sendKeys(customercost);
		
				}
				else if (!CustomerCost.getAttribute("value").equals("")){
					
					System.out.println("Customer cost was pre-populated.");
					CustomerCost.clear();
					CustomerCost.sendKeys(customercost);
					
				
				}
			}
			
			//else System.out.println("Do nothing");
					
							
		} catch (Exception e) {
			e.printStackTrace();
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(), false);
		}
	}

	@FindBy(id = "dealer_cost")
	public WebElement dealerCost;

	public String getWebDealerCost() {
		webDealerCost = dealerCost.getAttribute("value").trim();
		return webDealerCost;
	}

	@FindBy(id = "total_dealer_cost")
	public WebElement dealerTotal;
	public static String webDealerCostTotal = "";
	
	public String getWebDealerCostTotal() {
		
		webDealerCostTotal = dealerTotal.getAttribute("value").trim();
		return webDealerCostTotal;
	}


	@FindBy(id = "dealer_gst_cost")
	public WebElement dealerGST;

	@SuppressWarnings("finally")
	public String getWebDealerGST() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(dealerGST));
			webDealerGST = dealerGST.getAttribute("value").trim();
		} catch (Exception e) {
			webDealerGST = "FALSE";
			e.printStackTrace();
			GetScreenshot.captureScreenshot();
		} finally {
			return webDealerGST;
		}
	}
	
	@FindBy(id = "dealer_hst_cost")
	public WebElement dealerHST;

	@SuppressWarnings("finally")
	public String getWebDealerHST() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(dealerHST));
			webDealerHST = dealerHST.getAttribute("value").trim();
		} catch (Exception e) {
			webDealerHST = "FALSE";
			e.printStackTrace();
			GetScreenshot.captureScreenshot();
		} finally {
			return webDealerHST;
		}
	}

	@FindBy(id = "dealer_qst_cost")
	public WebElement dealerQST;

	@SuppressWarnings("finally")
	public String getWebDealerQST() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(dealerQST));
			webDealerQST = dealerQST.getAttribute("value").trim();
		} catch (Exception e) {
			webDealerQST = "FALSE";
			e.printStackTrace();
			GetScreenshot.captureScreenshot();
		} finally {
			return webDealerQST;
		}
	}

	@FindBy(id = "dealer_pst_cost")
	public WebElement dealerPST;

	@SuppressWarnings("finally")
	public String getWebDealerPST() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(dealerPST));
			webDealerPST = dealerPST.getAttribute("value").trim();
		} catch (Exception e) {
			webDealerPST = "FALSE";
			e.printStackTrace();
			GetScreenshot.captureScreenshot();
		} finally {
			return webDealerPST;
		}
	}

	@FindBy(id = "web_con_dealer_state")
	public WebElement dealerProvince;

	public String getWebDealerProvince() {
		DealerProvince = dealerProvince.getAttribute("value").trim();
		return DealerProvince;
	}

	public void verifyDealerTax(String ExpectedDealerCost, String ExpectedDealerHST, String ExpectedDealerGST,
			String ExpectedDealerQST, String ExpectedDealerPST, String ExpectedDealerCostTotal) {	
		
		webDealerCost = "";
		//webDealerCostTotal = "";
		webDealerGST = "";
		webDealerHST = "";
		webDealerQST = "";
		webDealerPST = "";
		//DealerProvince = "";
		dealerTaxError = "";
		customerTaxError = "";
		dealerTaxStatus = "";	
		finalStatus = "";
		
			
		Step_Definition.webDealerCost = "";
//		public static String webDealerCostTotal = "";
		Step_Definition.webDealerGST = "";
		Step_Definition.webDealerHST = "";
		Step_Definition.webDealerQST = "";
		Step_Definition.webDealerPST = "";
		//public String DealerProvince = "";
		Step_Definition.dealerTaxError = "";
		Step_Definition.customerTaxError = "";
		Step_Definition.dealerTaxStatus = "";	
		Step_Definition.finalStatus = "";
		Step_Definition.taxPopup = "";

		webDealerCost = getWebDealerCost();
		Step_Definition.webDealerCost = webDealerCost;
		
		webDealerCostTotal = getWebDealerCostTotal();
		//Step_Definition.webDealerCostTotal = getWebDealerCostTotal();
		//this.ExpDealerCost = ExpectedDealerCost;
		

//		formatting UI dealer cost and Expected Dealer Cost 
		webDealerCost = webDealerCost.replace(",", "");
		ExpectedDealerCost = ExpectedDealerCost.replace("$", "");

		if (webDealerCost.equalsIgnoreCase(ExpectedDealerCost.trim())) // && webDealerCostTotal.equalsIgnoreCase(ExpectedDealerCostTotal.trim()))
		{
			//Compare GST tax amount if the value provided in the test cases
			if (ExpectedDealerGST != null && !(ExpectedDealerGST.length()==0)) {				
//				
				//Return FALSE value if GST field is not available on the portal 
				webDealerGST = getWebDealerGST();
				Step_Definition.webDealerGST = webDealerGST;
				
				if (webDealerGST.equalsIgnoreCase("FALSE")) 
				{
					Step_Definition.dealerTaxError = "GST";
				}				

				if (!webDealerGST.equalsIgnoreCase("FALSE")) {
					if (webDealerGST.equalsIgnoreCase(ExpectedDealerGST)) 
					{
						Step_Definition.dealerTaxStatus = "Pass";
					}
					else 
					{ 
						Step_Definition.dealerTaxStatus = "Fail"; 
						
					}
				}
			} 
			
			else if (ExpectedDealerHST != null && !(ExpectedDealerHST.length()==0)) {
				webDealerHST = getWebDealerHST();
				Step_Definition.webDealerHST = webDealerHST;
				
				if (webDealerHST.equalsIgnoreCase("FALSE")) 
				{
					Step_Definition.dealerTaxError = "HST";
				} 

				if (!webDealerHST.equalsIgnoreCase("FALSE")) {
					if (webDealerHST.equalsIgnoreCase(ExpectedDealerHST)) 
					{
						Step_Definition.dealerTaxStatus = "Pass";
					}
					else
					{
						Step_Definition.dealerTaxStatus = "Fail";
					
					}
				}
			} 
			
			
			
			
			
			if (ExpectedDealerPST != null && !(ExpectedDealerPST.length()==0)) {

				webDealerPST = getWebDealerPST();
				Step_Definition.webDealerPST = webDealerPST;
				
				if (webDealerPST.equalsIgnoreCase("FALSE")) {
					
					Step_Definition.dealerTaxError = Step_Definition.dealerTaxError + " PST";
				} 

				if (!webDealerPST.equalsIgnoreCase("FALSE")) {
						if (webDealerPST.equalsIgnoreCase(ExpectedDealerPST)) 
						{
							Step_Definition.dealerTaxStatus = "Pass";
						} 
						
						else 
						{
							Step_Definition.dealerTaxStatus = "Fail";
						
						} 
					}				
			} 
			
			else if (ExpectedDealerQST != null && !(ExpectedDealerQST.length()==0)) {
				webDealerQST = getWebDealerQST();
				Step_Definition.webDealerQST = webDealerQST;
				
				
				if (webDealerQST.equalsIgnoreCase("FALSE")) {
					
					Step_Definition.dealerTaxError = Step_Definition.dealerTaxError + " QST";
				}

				if (!webDealerQST.equalsIgnoreCase("FALSE")) {
					if (webDealerQST.equalsIgnoreCase(ExpectedDealerQST)) 
					{
						Step_Definition.dealerTaxStatus = "Pass";
					} 
					else 
					{ 
						Step_Definition.dealerTaxStatus = "Fail";
						
					}
				}
			}
				
			
			//>>>>>---Log error message if Dealer GST/PST/QST/HST field is not available in UI and terminate execution. 
			if (Step_Definition.dealerTaxError.contains("ST")) {
				
				Step_Definition.dealerTaxError = "Dealer " + Step_Definition.dealerTaxError + " is not found.";
				Step_Definition.finalStatus = "Fail";
				System.out.println("Final status " + Step_Definition.dealerTaxError);
				Assert.assertTrue(Step_Definition.dealerTaxError, false);
			}
			
			else if (Step_Definition.dealerTaxStatus.contains("Fail")) {
				
				//>>>>----Step_Definition.dealerTaxError = "Dealer " + Step_Definition.dealerTaxError + " is not matching.";
				Step_Definition.dealerTaxError = "Tax amount is not matching.";
				Step_Definition.finalStatus = "Fail";
				System.out.println("Final status " + Step_Definition.dealerTaxError);
				Assert.assertTrue(Step_Definition.dealerTaxError, false);
			}
		 
			
			else {
				
				Step_Definition.finalStatus = "Pass";
			}
			
			/*
			if (Step_Definition.dealerTaxStatus != "Pass")
			{
				Step_Definition.dealerTaxStatus = Step_Definition.dealerTaxStatus + " is not matching.";
				System.out.println("Dealer Tax status : " + Step_Definition.dealerTaxStatus);
			}
			*/
		}
		 else
//			Log error message if Dealer cost not matching and terminate execution.  
		 	{
			 Step_Definition.dealerTaxError = "Dealer cost is not matching. ";
		 	 Step_Definition.finalStatus = "Fail";
			 Assert.assertTrue(Step_Definition.dealerTaxError, false);
			 }
		System.out.println("Dealer Tax Status:- " + Step_Definition.dealerTaxStatus);
		System.out.println("ExpectedDealerCost:- " + ExpectedDealerCost + "  webDealerCost:- " + webDealerCost);
		System.out.println("ExpectedTotalDealerCost:- " + ExpectedDealerCostTotal + "  webTotalDealerCost:- " + webDealerCostTotal);
		System.out.println("ExpectedDealerGST:- " + ExpectedDealerGST + "  webDealerGST:- " + webDealerGST);
		System.out.println("ExpectedDealerHST:- " + ExpectedDealerHST + "  webDealerHST:- " + webDealerHST);
		System.out.println("ExpectedDealerQST:- " + ExpectedDealerQST + "  webDealerQST:- " + webDealerQST);
		System.out.println("ExpectedDealerPST:- " + ExpectedDealerPST + "  webDealerPST:- " + webDealerPST);
		
	
	}
	
	

	public void inputCustomerCostAndTax(String CustomerCost, String CustomerHST, String CustomerGST, String CustomerPST,
			String CustomerQST, String ExpTotalCustomerCost, String Product) {
		
		String statusGST = "";
		String statusPST = "";
		String statusQST = "";
		String statusHST = "";

		if (Product.contains("BASE"))
		{
			
			ProductPage_bmm ppbmm = new ProductPage_bmm(Hooks.driver);
			ppbmm.createContract();
			
		} else {
			ProductPage_bmm ppbmm = new ProductPage_bmm(Hooks.driver);
			ppbmm.createContract();
		}
		//<<Removed Customer Tax Validation due to the ECOMJ-2652., Will fix this in future>>//
		/*else{
			
			
		enterCustomerCost(CustomerCost);
				
					
		//		Input customer GST if GST field available in UI and not empty/null in test data
		if (CustomerGST != null && !CustomerGST.length()==0)) {  
			statusGST = enterGST(CustomerGST);
			if (statusGST.equalsIgnoreCase("fail")) {
				customerTaxError = "GST";
			}
		} 
//		Input customer HST if HST field available in UI and not empty/null in test data
		else if (CustomerHST != null && !CustomerHST.length()==0)) {
			statusHST = enterHST(CustomerHST);
			if (statusHST.equalsIgnoreCase("fail")) {
				customerTaxError = customerTaxError + " HST";
			}
		}
//		Input customer PST if PST field available in UI and not empty/null in test data
		if (CustomerPST != null && !CustomerPST.length()==0)) {
			statusPST = enterPST(CustomerPST);
			if (statusPST.equalsIgnoreCase("fail")) {
				customerTaxError = customerTaxError + " PST";
			}
		} 
//		Input customer QST if QST field available in UI and not empty/null in test data
		else if (CustomerQST != null && !CustomerQST.length()==0)) {
			statusQST = enterQST(CustomerQST);
			if (statusQST.equalsIgnoreCase("fail")) {
				customerTaxError = customerTaxError + " QST";
			}
		}
//		Log error message if Customer GST/PST/QST/HST field is not available in UI. 
//		And terminate execution.		
		if (customerTaxError.contains("ST")) {
			customerTaxError = customerTaxError + " is not valid.";
			Step_Definition.finalStatus = "Fail";
			System.out.println("Final status " + customerTaxError);
			Assert.assertTrue(customerTaxError, false);
		}
		else {
			
			Step_Definition.finalStatus = "Pass";
			
		}
		
		
		
		ProductPage_bmm ppbmm = new ProductPage_bmm(Hooks.driver);
		ppbmm.createContract();
		
						
		if (CustomerGST != null && !CustomerGST.length()==0)) {
			if ((CustomerGST!= "") && ((Float.parseFloat(CustomerGST) < (Float.parseFloat(CustomerCost))*(.05)) || (Float.parseFloat(CustomerGST) > (Float.parseFloat(CustomerCost))*(.15)))) 
				{ ppbmm.taxAmtPopupAlert(); }
			}
		
		if (CustomerPST != null && !CustomerPST.length()==0)) {
			if (((Float.parseFloat(CustomerPST) < (Float.parseFloat(CustomerCost))*(.05)) || (Float.parseFloat(CustomerPST) > (Float.parseFloat(CustomerCost))*(.15)))) 
				{ ppbmm.taxAmtPopupAlert(); }
		}
		
		if (CustomerQST != null && !CustomerQST.length()==0)) {
			if (((Float.parseFloat(CustomerQST) < (Float.parseFloat(CustomerCost))*(.05)) || (Float.parseFloat(CustomerQST) > (Float.parseFloat(CustomerCost))*(.15)))) 
				{ ppbmm.taxAmtPopupAlert(); }
		}
		
		if (CustomerHST != null && !CustomerHST.length()==0)) {
			if (((Float.parseFloat(CustomerHST) < (Float.parseFloat(CustomerCost))*(.05)) || (Float.parseFloat(CustomerHST) > (Float.parseFloat(CustomerCost))*(.15)))) 
				{ ppbmm.taxAmtPopupAlert(); }		}
				
	}*/
		
	}
}



/*
 * if (CustomerQST != null && (CustomerGST == null && CustomerHST ==
 * null && CustomerPST == null)) { enterQST(CustomerQST); } if
 * (CustomerPST != null && (CustomerGST == null && CustomerHST == null
 * && CustomerQST == null)) { enterPST(CustomerPST); }
 * 
 * if(province.contains("[ ON ]") || province.contains("[ NL ]") ||
 * province.contains("[ PE ]") || province.contains("[ NB ]") ||
 * province.contains("[ NS ]")) { enterHST(CustomerHST); }
 * if(province.contains("[ YT ]")||province.contains("[ NU ]"
 * )||province.contains("[ AB ]")) { enterGST(CustomerGST); }
 * if(province.contains("[ BC ]")||province.contains("[ SK ]"
 * )||province.contains("[ MB ]")) { enterGST(CustomerGST);
 * enterPST(CustomerPST); } if(province.contains("[ QC ]")) {
 * enterGST(CustomerGST); enterQST(CustomerQST); }
 * if(province.contains("Other")) { // status="Pass"; }
 */


/*
 * if(webDealerCost.equalsIgnoreCase(ExpectedDealerCost.trim()) &&
 * webDealerCostTotal.equalsIgnoreCase(ExpectedDealerCostTotal.trim()))
 * { if(province.contains("[ ON ]") || province.contains("[ NL ]") ||
 * province.contains("[ PE ]") || province.contains("[ NB ]") ||
 * province.contains("[ NS ]")) {
 * if(webDealerHST.equalsIgnoreCase(ExpectedDealerHST)) { status="Pass";
 * } } if(province.contains("[ YT ]")||province.contains("[ NU ]"
 * )||province.contains("[ AB ]")) {
 * if(webDealerGST.equalsIgnoreCase(ExpectedDealerGST)) { status="Pass";
 * } } if(province.contains("[ BC ]")||province.contains("[ SK ]"
 * )||province.contains("[ MB ]")) {
 * if(webDealerGST.contains(ExpectedDealerGST) &&
 * webDealerPST.contains(ExpectedDealerPST)) { status="Pass"; } }
 * if(province.contains("[ QC ]")) {
 * if(webDealerGST.equalsIgnoreCase(ExpectedDealerGST) &&
 * webDealerQST.equalsIgnoreCase(ExpectedDealerQST)) { status="Pass"; }
 * }
 * 
 * if(province.contains("Other")) { status="Pass"; } }
 */

/*
 * @FindBy(id = "retail_total_cost") public WebElement CustomerTotalCost;
 * 
 * public void enterCustomerTotalCost(String customertotalcost){ try{
 * WebDriverWait wait = new WebDriverWait(driver, 20);
 * wait.until(ExpectedConditions.visibilityOf(CustomerTotalCost));
 * CustomerTotalCost.sendKeys(customertotalcost); } catch(Exception e){
 * e.printStackTrace(); GetScreenshot.captureScreenshot();
 * Assert.assertTrue(e.getMessage(),false); } }
 */