package MB;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;
import utility.GetScreenshot;
import utility.Log;
import configurations.Hooks;

public class ProductSelectionPage {
	
	public WebDriver driver;
	
	public ProductSelectionPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="form")
	public WebElement product;
	
	public void selectProduct(String Product)
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("form")));
			Select select=new Select(product);
			select.selectByVisibleText(Product);
						
			Log.log.debug("Select Product as:- "+Product);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
		
	@FindBy(id="coverage_uvp")
	public WebElement coverageAll;
	
	@FindBy(id="coverage_twr")
	public WebElement coverageTW;
	
	@FindBy(id="coverage_ddp")
	public WebElement coveragePDR;
	
	@FindBy(id="coverage_wrp")
	public WebElement coverageWS;
		
	@FindBy(id="coverage_key")
	public WebElement coverageKey;
	
//	@FindBy(id="")
	
	public void clickCoverage(String Coverage)
	{
		try{
			
			if(Coverage.equalsIgnoreCase("Total Coverage"))
			{
				coverageAll.click();
			} else {
				if(Coverage.contains("T"))
				{
					WebDriverWait wait = new WebDriverWait(driver, 30);
					wait.until(ExpectedConditions.elementToBeClickable(By.id("coverage_twr")));
					coverageTW.click();				
				}
				if(Coverage.contains("D"))
				{
					WebDriverWait wait = new WebDriverWait(driver, 30);
					wait.until(ExpectedConditions.elementToBeClickable(By.id("coverage_ddp")));
					coveragePDR.click();
				}
				if(Coverage.contains("WS"))
				{
					WebDriverWait wait = new WebDriverWait(driver, 30);
					wait.until(ExpectedConditions.elementToBeClickable(By.id("coverage_wrp")));
					coverageWS.click();
				}
				if(Coverage.contains("K"))
				{
					WebDriverWait wait = new WebDriverWait(driver, 30);
					wait.until(ExpectedConditions.elementToBeClickable(By.id("coverage_key")));
					coverageKey.click();
				}
			}
			
			Log.log.debug("Selected coverage as:- "+Coverage);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
/*	@FindBy(id="web_con_coverage")
	public WebElement Coverage_All_AK;
	
	@FindBy (id="coverage_t")
	public WebElement Coverage_T_AK;
	
	@FindBy (id="coverage_ws")
	public WebElement Coverage_WS_AK;
	
	@FindBy (id="coverage_d")
	public WebElement Coverage_D_AK;
	
	@FindBy (id="coverage_k")
	public WebElement Coverage_K_AK;*/
	
	//OLD
	@FindBy(id="web_con_coverage")
	public WebElement coverageTotal;
	
	@FindBy(id="coverage_t")
	public WebElement coverageT;
	
	@FindBy(id="coverage_d")
	public WebElement coverageD;
	
	@FindBy(id="coverage_ws")
	public WebElement coverageW;
		
	@FindBy(id="coverage_k")
	public WebElement coverageK;
	
	public void clickCoverageZD(String Coverage)
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);			
			
			if(Coverage.equalsIgnoreCase("Total Coverage")|| Coverage.equalsIgnoreCase("TOTAL COVERAGE"))
			{
				wait.until(ExpectedConditions.elementToBeClickable(coverageTotal));
				coverageTotal.click();
			} else {
				if(Coverage.contains("WHEEL AND TIRE"))
				{
					wait.until(ExpectedConditions.elementToBeClickable(coverageT));
					coverageT.click();				
				}
				if(Coverage.contains("PAINTLESS DENT"))
				{					
					wait.until(ExpectedConditions.elementToBeClickable(coverageD));
					coverageD.click();
				}
				if(Coverage.contains("WINDSHIELD"))
				{					
					wait.until(ExpectedConditions.elementToBeClickable(coverageW));
					coverageW.click();
				}
				if(Coverage.contains("KEY"))
				{					
					wait.until(ExpectedConditions.elementToBeClickable(coverageK));
					coverageK.click();
				}
			}
			
			Log.log.debug("Selected coverage as:- "+Coverage);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}

	/*@FindBy(id="term")
	public WebElement eTrm;
	public void selectTerm(String Term)
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("term")));
			Thread.sleep(10000L);
		
			Select select =new Select(eTrm);
			select.selectByVisibleText(Term);
			
			Log.log.debug("Select Term as:- "+Term);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}*/
	
	@FindBy(id="term")
	public WebElement eTerm;
	
	public void enterTerm(String TM)
	{
		try{
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("term_range")));
			wait.until(ExpectedConditions.elementToBeClickable(By.id("term")));
			//Thread.sleep(4000L);
			eTerm.sendKeys(TM);
			
			Log.log.debug("Enter Term as:- "+TM);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="term")
	public WebElement eTrm;
	
	public void selectTerm(String eTerm)
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(By.id("term")));
			Thread.sleep(5000L);
			Select select =new Select(eTrm);
			select.selectByVisibleText(eTerm);
			
			Log.log.debug("Select Term as:- "+eTerm);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
		
	
	@FindBy(id="submit")
	public WebElement sub;
	
	public void clickSubmit()
	{
		try{
			
			if(Hooks.screenShotStatus.equalsIgnoreCase("Yes"))
			{
				GetScreenshot.captureScreenshot();
			}
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(By.id("submit")));
			Thread.sleep(5000L);
			sub.click();
			//Thread.sleep(10000L);
			
			Log.log.debug("Click on Submit Button");
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
		
	//MBCA
	/*@FindBy(id="coverage_uvp")
	public WebElement coverageUVP;
	
	@FindBy(id="coverage_twr")
	public WebElement coverageTWP;
	
	@FindBy(id="coverage_d")
	public WebElement coverageDDP;
	
	@FindBy(id="coverage_ws")
	public WebElement coverageWSP;
		
	@FindBy(id="coverage_k")
	public WebElement coverageKP;
	
	@FindBy(id="coverage_s")
	public WebElement coverageAP;*/

	
	/*public void clickCoverageMBCA(String Coverage)
	{
		try{
			if(Coverage.equalsIgnoreCase("Total Coverage"))
			{
				WebDriverWait wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.elementToBeClickable(By.id("coverage_uvp")));
				coverageUVP.click();
			} else {
				if(Coverage.contains("P"))
				{
					WebDriverWait wait = new WebDriverWait(driver, 30);
					wait.until(ExpectedConditions.elementToBeClickable(By.id("coverage_twr")));
					coverageTWP.click();				
				}
				if(Coverage.contains("D"))
				{
					WebDriverWait wait = new WebDriverWait(driver, 30);
					wait.until(ExpectedConditions.elementToBeClickable(By.id("coverage_d")));
					coverageDDP.click();
				}
				if(Coverage.contains("X"))
				{
					WebDriverWait wait = new WebDriverWait(driver, 30);
					wait.until(ExpectedConditions.elementToBeClickable(By.id("coverage_ws")));
					coverageWSP.click();
				}
				if(Coverage.contains("K"))
				{
					WebDriverWait wait = new WebDriverWait(driver, 30);
					wait.until(ExpectedConditions.elementToBeClickable(By.id("coverage_k")));
					coverageKP.click();
				}
				if(Coverage.contains("S"))
				{
					WebDriverWait wait = new WebDriverWait(driver, 30);
					wait.until(ExpectedConditions.elementToBeClickable(By.id("coverage_s")));
					coverageAP.click();
				}
			}
		
			Log.log.debug("Selected coverage as:- "+Coverage);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}*/	
	
	  /*P		T			.//*[@id='coverage_twr']						
		S		S			.//*[@id='coverage_s']			
		PXDKS	TXDKS		.//*[@id='coverage_uvp']
		PXDK	TXDK		.//*[@id='coverage_appearanceKey']
		PXD		TXD			.//*[@id='coverage_appearance']
		XDS		XDS			.//*[@id='coverage_ClassA']
		PDK		TDK			.//*[@id='coverage_ClassB']
		XDKS	XDKS		.//*[@id='coverage_ClassC']
		PDKS	TDKS		.//*[@id='coverage_ClassD']
	*/	
		
		//@FindBy(id="coverage_uvp")
		@FindBy(xpath=".//input[@value='PXDKS']")
		public WebElement coveragePXDKS;
		
		//@FindBy(id="coverage_twr")
		@FindBy(id="coverage_t")
		public WebElement coverageP;
		
		@FindBy(id="coverage_s")
		public WebElement coverageS;
		
		//@FindBy(id="coverage_appearanceKey")
		@FindBy(xpath=".//input[@value='PXDK']")
		public WebElement coveragePXDK;
		
		//@FindBy(id="coverage_appearance")
		@FindBy(xpath=".//input[@value='PXD']")
		public WebElement coveragePXD;
	
		//@FindBy(id="coverage_ClassA")
		@FindBy(xpath=".//input[@value='XDS']")
		public WebElement coverageXDS;
		
		//@FindBy(id="coverage_ClassB")
		@FindBy(xpath=".//input[@value='PDK']")
		public WebElement coveragePDK;
		
		//@FindBy(id="coverage_ClassC")
		@FindBy(xpath=".//input[@value='XDKS']")
		public WebElement coverageXDKS;
		
		//@FindBy(id="coverage_ClassD")
		@FindBy(xpath=".//input[@value='PDKS']")
		public WebElement coveragePDKS;
		
		public void clickCoverageMBCA(String Coverage)
		{
			try{				
				WebDriverWait wait = new WebDriverWait(driver, 30);
				//
				wait.until(ExpectedConditions.elementToBeClickable(By.id("coverage_t")));
				if(Coverage.equalsIgnoreCase("Total Coverage") || Coverage.equalsIgnoreCase("PXDKS"))
				{						
					coveragePXDKS.click();
				} else if(Coverage.equalsIgnoreCase("PXDK")) {
					coveragePXDK.click();
				} else if(Coverage.equalsIgnoreCase("PXD")) {
					coveragePXD.click();
				} else if(Coverage.equalsIgnoreCase("XDS")) {
					coverageXDS.click();
				} else if(Coverage.equalsIgnoreCase("PDK")) {
					coveragePDK.click();
				} else if(Coverage.equalsIgnoreCase("XDKS")) {
					coverageXDKS.click();
				} else if(Coverage.equalsIgnoreCase("PDKS")) {
					coveragePDKS.click();
				} else {
					if(Coverage.contains("P"))
					{
						coverageP.click();				
					}
					if(Coverage.contains("S"))
					{
						coverageS.click();				
					}
				}
				
				
				Log.log.debug("Selected coverage as:- "+Coverage);
			}catch(Exception e){
				GetScreenshot.captureScreenshot();
				Assert.assertTrue(e.getMessage(),false);
			}
		}
				
}