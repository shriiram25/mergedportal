package agents.pageobjects;

import configurations.Hooks;

public class ProductSelectionConditions {
	
	public void productCondation(String Category, String Product, String Coverage, String Term)
	{
		if (Category.equalsIgnoreCase("ECSGGPCV0116")
				||Category.equalsIgnoreCase("SGGP319")
				||Category.equalsIgnoreCase("SGGP-PL1115") 
				||Category.equalsIgnoreCase("SGGP818")
				||Category.equalsIgnoreCase("ECWRMGP") 
				||Category.equalsIgnoreCase("SGMGP150-1115") 
				||Category.equalsIgnoreCase("SGGP-CO")
				||Category.equalsIgnoreCase("SGGPFM")
				||Category.equalsIgnoreCase("AVGPSET 1/16")
				||Category.equalsIgnoreCase("SGLS-CAN")
				||Category.equalsIgnoreCase("SGPKCAN")
				||Category.equalsIgnoreCase("LODWKAI-F")
				||Category.equalsIgnoreCase("SGMTWLX-FL")
				||Category.equalsIgnoreCase("SGTP")
				||Category.equalsIgnoreCase("SGVKEY")
				||Category.equalsIgnoreCase("SGLS")
				||Category.equalsIgnoreCase("SGGP818")
				||Category.equalsIgnoreCase("SGMPGP150-1115")
				||Category.equalsIgnoreCase("SGGP 1/14")
				||Category.equalsIgnoreCase("SGCDRA")
				||Category.equalsIgnoreCase("SGCDWA")
				||Category.equalsIgnoreCase("SGCDW")
				||Category.equalsIgnoreCase("SGCDWAK")
				||Category.equalsIgnoreCase("SGGPUN1219")
				||Category.equalsIgnoreCase("ECAVGPUN")
				||Category.equalsIgnoreCase("ECAVGPUNFMC")
				||Category.equalsIgnoreCase("ECSGGP319")
				||Category.equalsIgnoreCase("ECSGGPCOUN1219")
				||Category.equalsIgnoreCase("ECSGGPUN1219")
				||Category.equalsIgnoreCase("ECSGGP-VC419")
				||Category.equalsIgnoreCase("ECSGGP0818")
				||Category.equalsIgnoreCase("ECSGGPSETTO1207")
				||Category.equalsIgnoreCase("ECSGGPCP0116")
				
				||Category.equalsIgnoreCase("ECAVGPSET0116")
				||Category.equalsIgnoreCase("ECGAP080116")
				||Category.equalsIgnoreCase("ECSGGP150TX717")
				||Category.equalsIgnoreCase("ECSGGP251115")
				||Category.equalsIgnoreCase("ECSGGPPL1115")
				||Category.equalsIgnoreCase("ECSGGPRET0116")
				||Category.equalsIgnoreCase("ECSGGPTO1115")
				||Category.equalsIgnoreCase("ECVEGP0116")
				||Category.equalsIgnoreCase("ECSGGP-CO")
				||Category.equalsIgnoreCase("ECSGGPCP-CO")
				||Category.equalsIgnoreCase("ECSGGPCOUNFMC")
				||Category.equalsIgnoreCase("ECSGGPTXUN1219")
				||Category.equalsIgnoreCase("ECSGGPUNFMC")
				||Category.equalsIgnoreCase("ECSGLS")
				

				
				
				) 
								
				
		{
			ProductSelectionPage psp=new ProductSelectionPage(Hooks.driver);
			psp.selectProduct(Product);
			psp.selectCoverage(Coverage);
			psp.enterTerm(Term);
			psp.clickSubmit();
		}
		
		
		if(Category.equalsIgnoreCase("SGVKEY")
				||Category.equalsIgnoreCase("ECSGVKEY1-5")
				||Category.equalsIgnoreCase("SGVPC")
				||Category.equalsIgnoreCase("SGPWABVSC-GM")
				||Category.equalsIgnoreCase("SGT-CAN")
			  ||Category.equalsIgnoreCase("SGPWSAVSC")
			  )

		{
			ProductSelectionPage psp=new ProductSelectionPage(Hooks.driver);
			psp.selectProduct(Product);
			psp.selectTerm(Term);
			psp.clickSubmit();
		} 
		
		if(Category.equalsIgnoreCase("ECSGPWCAN0121")
				||Category.equalsIgnoreCase("ECSGVPKEY-GA519")
				)

		{
			ProductSelectionPage psp=new ProductSelectionPage(Hooks.driver);
			psp.selectProduct(Product);
			psp.enterTerm(Term);
			psp.clickSubmit();
		} 
 
		
		if(Category.equalsIgnoreCase("SGRTWABVSC")
				||Category.equalsIgnoreCase("SGTP") 
				||Category.equalsIgnoreCase("SGTRABVSC")
				
				)
		{
			ProductSelectionPage psp=new ProductSelectionPage(Hooks.driver);
			psp.selectProduct(Product);
			psp.selectCoverage(Coverage);
			psp.selectTerm(Term);
			psp.clickSubmit();
		}
		
		if(Category.equalsIgnoreCase("SGVPDWRSA")
				|| Category.equalsIgnoreCase("SGVPDSA7-FMC318")
				||Category.equalsIgnoreCase("SGGP25-1115")
				||Category.equalsIgnoreCase("SGPDRK-INILIAMI")
				||Category.equalsIgnoreCase("ECSGPKCAN021")
				||Category.equalsIgnoreCase("ECSGUKCAN21")
				||Category.equalsIgnoreCase("ECSGPDWKSC1220")
				)
			
		{
			ProductSelectionPage psp=new ProductSelectionPage(Hooks.driver);
			psp.selectProduct(Product);
			psp.clickCoverage(Coverage);
			psp.selectTerm(Term);
			psp.clickSubmit();
		}
	}

}
