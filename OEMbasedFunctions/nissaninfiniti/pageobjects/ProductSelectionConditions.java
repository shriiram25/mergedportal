package nissaninfiniti.pageobjects;

import configurations.Hooks;
//import utility.Log;

public class ProductSelectionConditions {
	
	public void productCondation(String Category, String Product, String Coverage, String Term)
	{		
		ProductSelectionPage psp=new ProductSelectionPage(Hooks.driver);
		
		if(Category.equalsIgnoreCase("NILS-CAN")||Category.equalsIgnoreCase("NILS-CAN-FR")||Category.equalsIgnoreCase("NIGP-CAN")||Category.equalsIgnoreCase("NIGP-CAN-FR")||Category.equalsIgnoreCase("NITP-CAN-FR")||Category.equalsIgnoreCase("INLS-CAN")||Category.equalsIgnoreCase("INGP-CAN")||Category.equalsIgnoreCase("INGP-CAN-FR")||Category.equalsIgnoreCase("INTP-CAN-FR")||Category.equalsIgnoreCase("ECNITPCANFR516")||Category.equalsIgnoreCase("ECINTPCANFR516")||Category.equalsIgnoreCase("ECQGTPBC-IN")||Category.equalsIgnoreCase("ECQGTPBC-NI"))
		{		
			psp.selectProduct(Product);
			psp.selectCoverage(Coverage);
			psp.enterTerm(Term);
			psp.clickSubmit();
		}
		else if(Category.equalsIgnoreCase("NITP-CAN")||Category.equalsIgnoreCase("INTP-CAN")||Category.equalsIgnoreCase("ECNITPCAN0516")||Category.equalsIgnoreCase("ECINTPCAN0516")||Category.equalsIgnoreCase("ECNITPBC0516")||Category.equalsIgnoreCase("ECINTPBC0516")||Category.equalsIgnoreCase("ECQGTPCAN-NI")||Category.equalsIgnoreCase("ECQGTPCANFR-NI")||Category.equalsIgnoreCase("ECQGTPCAN-IN")||Category.equalsIgnoreCase("ECQGTPCANFR-IN"))
		{
			psp.selectProduct(Product);
			psp.selectCoverage(Coverage);
			psp.selectTerm(Term);
			psp.clickSubmit();
		}
		else if(Category.equalsIgnoreCase("QVGS-CAN")||Category.equalsIgnoreCase("QVGS-FR")) 			
		{
			psp.selectProduct(Product);						
		}
		else {
			
			psp.selectProduct(Product);
			psp.clickCoverage(Coverage);
			psp.selectTerm(Term);
			psp.clickSubmit();				
		}
	}
	
}
