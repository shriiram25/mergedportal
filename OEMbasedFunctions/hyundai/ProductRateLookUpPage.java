package hyundai;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import Hyundai.Hooks;
import configurations.Hooks;
import utility.Log;
import utility.GetScreenshot;

public class ProductRateLookUpPage {

	public WebDriver driver;

	public ProductRateLookUpPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public static int i = 0;

	@FindBy(id = "vin")
	public WebElement vin;

	public void vin(String Vin) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(vin));
			vin.sendKeys(Vin);
			Log.log.debug("Enter the VIN as:-" + Vin);
		} catch (Exception e) {
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(), false);
		}
	}

	@FindBy(id = "odometer")
	public WebElement odometer;

	public void odometer(String Odometer) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(odometer));
			odometer.sendKeys(Odometer);
			Log.log.debug("Enter the Odometer as:-" + Odometer);
		} catch (Exception e) {
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(), false);
		}
	}

	@FindBy(id = "submit")
	public WebElement getRates;

	public void getRates() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(getRates));
			getRates.click();
			Log.log.debug("Click on the Get Rates button");
		} catch (Exception e) {
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(), false);
		}
	}

	public void clickProduct(String product) {
		String status = "";
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='rateTables']/h3/span[1]")));
			List<WebElement> productList = driver.findElements(By.xpath(".//*[@id='rateTables']/h3/span[1]"));

			i = 2;
			
			if (productList.size() > 0) {
				for (WebElement ProductElement : productList) {
					String productText = ProductElement.getText();
					if (product.equalsIgnoreCase(productText)) {
						ProductElement.click();	
						status = "Pass";
						break;
					} 
					
					i++;
				}
				
				if(status != "Pass"){
					GetScreenshot.captureScreenshot();
					Assert.assertTrue("Product Not Found", false);
				}
			}			
			

		} catch (Exception e) {
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(), false);
		}
		
	}
	
	//@FindBy(xpath=".//*[@id='rateTables']/table[]")
	//public WebElement rateTables = driver.findElement(By.xpath(".//*[@id='rateTables']/table["+i+"]"));
	
	public String verifyRate(String product,String coverage, String term, String deductible, String rate, String maxTerm, String maxAmount){
		String status = "Fail";
		
		String Coverage = "";
		String Term = "";
		String MaxTerm = "";
		String MaxAmount = "";
		String Deductible = "";
		String Rate = "";
		
		try {			
			WebElement rateTables = driver.findElement(By.xpath(".//*[@id='rateTables']/table["+i+"]"));
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(rateTables));
			
			List<WebElement> tagList=driver.findElements(By.xpath(".//*[@id='rateTables']/table["+i+"]/tbody"));
			if(tagList.size()>0)
			{
				//System.out.println("tagListSIZE:- "+tagList.size());
				List<WebElement> trList=tagList.get(0).findElements(By.tagName("tr"));
				if(trList.size()>0)
				{
					//System.out.println("trListSize:- "+trList.size());
					
					if ( product.contains("DENT") || product.contains("KEY") || product.contains("THEFT") || product.contains("TIRE") ) {
						
						
						for (int i = 1; i < trList.size(); i++) {
							List<WebElement> tdList = trList.get(i).findElements(By.tagName("td"));
							//System.out.println("tdListSize:- "+tdList.size());
							Coverage = tdList.get(0).getText().trim();
							Term = tdList.get(1).getText().trim();
							Deductible = tdList.get(2).getText().trim();
							Rate = tdList.get(3).getText().trim();

							if (coverage.equalsIgnoreCase(Coverage) && term.equalsIgnoreCase(Term) && deductible.equalsIgnoreCase(Deductible)) {
								if (rate.equalsIgnoreCase(Rate)) {
									status = "Pass";
									/*System.out.println("Coverage:- " + Coverage);
									System.out.println("Deductible:- " + Deductible);
									System.out.println("Term:- " + Term);
									System.out.println("Rate:- " + Rate);
									System.out.println("Status:- " + status);*/
									break;
								} else {
									status = "Fail";
								}
							} else {
								status = "Fail";
							}	
							
						} 
						
					} else if( product.contains("CPO") || product.contains("PRE-PAID MAINTENANCE") || product.contains("TERM") || product.contains("VEHICLE SERVICE CONTRACT") ){
						
						for (int i = 1; i < trList.size(); i++) {
							
							try {
								
								List<WebElement> tdList = trList.get(i).findElements(By.tagName("td"));								
								//System.out.println("tdListSize:- "+tdList.size());								
								Coverage = tdList.get(0).getText().trim();
								Term = tdList.get(1).getText().trim();
								Deductible = tdList.get(2).getText().trim();
								Rate = tdList.get(3).getText().trim();	
																
								if (coverage.equalsIgnoreCase(Coverage) && term.equalsIgnoreCase(Term) && deductible.equalsIgnoreCase(Deductible)) {
									if (rate.equalsIgnoreCase(Rate)) {
										status = "Pass";
										/*System.out.println("Coverage:- " + Coverage);
										System.out.println("Deductible:- " + Deductible);
										System.out.println("Term:- " + Term);
										System.out.println("Rate:- " + Rate);
										System.out.println("Status:- " + status);*/
										break;
									} else {
										status = "Fail";
									}
								} else {
									status = "Fail";
								}	
								
								
							} catch (Exception e) {								
								//
							}
							
						}
						
						
					
					} else if( product.contains("GAP") ){
						
						for (int i = 1; i < trList.size(); i++) {
							
							try {
								
								List<WebElement> tdList = trList.get(i).findElements(By.tagName("td"));								
								//System.out.println("tdListSize:- "+tdList.size());								
								Coverage = tdList.get(0).getText().trim();
								MaxTerm = tdList.get(2).getText().trim();
								Deductible = tdList.get(3).getText().trim();
								Rate = tdList.get(4).getText().trim();	
																
								if (coverage.equalsIgnoreCase(Coverage) && maxTerm.equalsIgnoreCase(MaxTerm) && deductible.equalsIgnoreCase(Deductible)) {
									if (rate.equalsIgnoreCase(Rate)) {
										status = "Pass";
										/*System.out.println("Coverage:- " + Coverage);
										System.out.println("Deductible:- " + Deductible);
										System.out.println("MaxTerm:- " + MaxTerm);
										System.out.println("Rate:- " + Rate);
										System.out.println("Status:- " + status);*/
										break;
									} else {
										status = "Fail";
									}
								} else {
									status = "Fail";
								}	
								
								
							} catch (Exception e) {								
								//
							}
							
						}
						
					} else if( product.contains("EXCESS WEAR AND USE") ){						

						for (int i = 1; i < trList.size(); i++) {
							
							try {
								
								List<WebElement> tdList = trList.get(i).findElements(By.tagName("td"));								
								//System.out.println("tdListSize:- "+tdList.size());								
								Coverage = tdList.get(0).getText().trim();
								MaxTerm = tdList.get(2).getText().trim();
								MaxAmount = tdList.get(4).getText().trim();
								Deductible = tdList.get(5).getText().trim();
								Rate = tdList.get(6).getText().trim();	
																
								if (coverage.equalsIgnoreCase(Coverage) && maxTerm.equalsIgnoreCase(MaxTerm) && maxAmount.equalsIgnoreCase(MaxAmount) && deductible.equalsIgnoreCase(Deductible)) {
									if (rate.equalsIgnoreCase(Rate)) {
										status = "Pass";
										/*System.out.println("Coverage:- " + Coverage);
										System.out.println("Deductible:- " + Deductible);
										System.out.println("MaxTerm:- " + MaxTerm);
										System.out.println("MaxAmount:- " + MaxAmount);
										System.out.println("Rate:- " + Rate);
										System.out.println("Status:- " + status);*/
										break;
									} else {
										status = "Fail";
									}
								} else {
									status = "Fail";
								}	
								
								
							} catch (Exception e) {								
								//
							}
							
						}
					}
				}
			}
			
			return status;
		
		} catch (Exception e) {
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(), false);
			return status;
		}
	}
	

}
