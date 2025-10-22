package bmw.pageobjects;

import configurations.Hooks;

public class ProductSelectionConditions {
	
	public void productConditions(String Category, String Product, String Coverage, String Term, String RimSize, String Quantity, String DOT1, String DOT2, String DOT3, String DOT4 )
	{
		if(Category.equalsIgnoreCase("BMPDWSA-AC") || Category.equalsIgnoreCase("BMTDWSA-AC") || Category.equalsIgnoreCase("MITDKSA-DD"))
		{
			ProductSelectionPage psp=new ProductSelectionPage(Hooks.driver);
			psp.selectProduct(Product);
			psp.clickCoverage(Coverage);
			psp.selectTerm(Term);
			psp.clickSubmit();
		}
		
		if(Category.equalsIgnoreCase("ECBMTWSAPAC") || Category.equalsIgnoreCase("ECBMPWSAPAC") || Category.equalsIgnoreCase("ECMIPWSAPAC") || Category.equalsIgnoreCase("ECMITWSAPAC"))
		{
			ProductSelectionPage psp=new ProductSelectionPage(Hooks.driver);
			psp.selectProduct(Product);
			psp.selectTerm(Term);
			psp.clickSubmit();
		}
		
		if(Category.equalsIgnoreCase("MIPWSA-DD"))
		{
			ProductSelectionPage psp=new ProductSelectionPage(Hooks.driver);
			psp.selectProduct(Product);
			psp.selectTerm(Term);
			psp.clickSubmit();
		}
		
		if(Category.equalsIgnoreCase("MILS")|| Category.equalsIgnoreCase("BMPDWKSCSA-DD")|| Category.equalsIgnoreCase("BMTDWKSCSA-DD")|| Category.equalsIgnoreCase("MIPDWKSCSA-DD"))
		{
			ProductSelectionPage psp=new ProductSelectionPage(Hooks.driver);
			psp.selectProduct(Product);
			psp.clickCoverage(Coverage);
			psp.enterTerm(Term);
			psp.clickSubmit();
		}
		if(Category.equalsIgnoreCase("BMGP 4/19") || Category.equalsIgnoreCase("MIGPPL") || Category.equalsIgnoreCase("MIGP 4/19") || Category.equalsIgnoreCase("BMGPPL 4/19"))
		{
			ProductSelectionPage psp=new ProductSelectionPage(Hooks.driver);
			psp.selectProduct(Product);
			psp.selectCoverage(Coverage);
			psp.enterTerm(Term);
			psp.clickSubmit();
		}
		
		if(Category.equalsIgnoreCase("ECBMDOTSA") || Category.equalsIgnoreCase("ECBMDOTAB"))
		{
			ProductSelectionPage psp=new ProductSelectionPage(Hooks.driver);
			psp.selectProduct(Product);
			psp.selectDOTTerm(Term);
			psp.selectRimSize(RimSize);
			psp.selectQuantity(Quantity);
		
		
			if(Quantity.equals("1"))
			{
				psp.enterDOT1(DOT1);
				//psp.clickSubmitBtn();
			}
			if(Quantity.equals("2"))
			{
				psp.enterDOT1(DOT1);
				psp.enterDOT2(DOT2);
				//psp.clickSubmitBtn();
			}
			if(Quantity.equals("3"))
			{
				psp.enterDOT1(DOT1);
				psp.enterDOT2(DOT2);
				psp.enterDOT3(DOT3);
				//psp.clickSubmitBtn();
			}
			if(Quantity.equals("4"))
			{
				psp.enterDOT1(DOT1);
				psp.enterDOT2(DOT2);
				psp.enterDOT3(DOT3);
				psp.enterDOT4(DOT4);
				//psp.clickSubmitBtn();
			}
			
			psp.clickSubmitBtn();
		}
		
	}
		
}
