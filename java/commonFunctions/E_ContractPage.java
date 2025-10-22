package commonFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import configurations.Hooks;

public class E_ContractPage {
	
	/*public WebDriver webDriver;
	
	public E_ContractPage(WebDriver webDriver)
	{
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}*/
	
	public void menu (String Portal)
	{
E_ContractingPage ecp = new E_ContractingPage (Hooks.driver);
		
		// Select Add New Contract
		if(Portal.contains("VCI"))                     
		{
		  ecp.econMenuVCI();                       
		  //Thread.sleep(3000);
			
		}
		
		else if (Portal.contains("ALPHERA"))                                
		{
		  ecp.eSubmissions();                           
		  ecp.addNewEsubmission();                    
		 // Thread.sleep(3000);
		}
		
		else                                
		{
		  ecp.econMenu();                           
		  ecp.addContractbtn();                    
		 // Thread.sleep(3000);
		}
	}

}
