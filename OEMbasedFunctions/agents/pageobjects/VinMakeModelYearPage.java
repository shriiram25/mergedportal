package agents.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VinMakeModelYearPage {
	
	public String webMake=null;
	public String webModel=null;
	public String webYear=null;
	
	public WebDriver driver;
	
	public VinMakeModelYearPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="web_con_ncic")
	public WebElement make;
	
	public String getMake()
	{
		webMake=make.getAttribute("value").trim();
		return webMake;
	}
	
	@FindBy(id="web_con_model")
	public WebElement model;
	
	public String getModel()
	{
		webModel=model.getAttribute("value").trim();
		return webModel;
	}
	
	@FindBy(id="web_con_year")
	public WebElement year;
	
	public String getYear()
	{
		webYear=year.getAttribute("value").trim();
		return webYear;
	}
	

}
