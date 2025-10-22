package MB;

import utility.Log;
import configurations.Hooks;

public class ProductSelectionConditions {
	
	public void productCondition(String Category, String Product, String Coverage, String Term)
	{
		ProductSelectionPage psp=new ProductSelectionPage(Hooks.driver);
		

		if(Category.equalsIgnoreCase("MBTSAT1-WA 5/18")||Category.equalsIgnoreCase("MBTSAT1-OK 5/18")||Category.equalsIgnoreCase("MBTAB")||Category.equalsIgnoreCase("MBTSA")||Category.equalsIgnoreCase("MBTSA-AC")
				||Category.equalsIgnoreCase("MBPAB")||Category.equalsIgnoreCase("MBPSA")||Category.equalsIgnoreCase("MBDSA-NY")
				||Category.equalsIgnoreCase("MBPSA-AC")||Category.equalsIgnoreCase("MBPAB-AC")||Category.equalsIgnoreCase("MBTAB-AC")
				||Category.equalsIgnoreCase("MBTSA-AN")||Category.equalsIgnoreCase("MBPSA-AN")||Category.equalsIgnoreCase("MBPAB-AN")||Category.equalsIgnoreCase("MBTAB-AN")
				||Category.equalsIgnoreCase("MBPDWKSA"))
		{			
			psp.selectProduct(Product);
			psp.enterTerm(Term);
			psp.clickSubmit();			
		} 
		else if(Category.equalsIgnoreCase("MBPDWKSAT5 320")	
			||Category.equalsIgnoreCase("MBPDWKSAT1 320")
			||Category.equalsIgnoreCase("MBPDWKSA 320")
			||Category.equalsIgnoreCase("MBPDWKSCSAT1320")
			||Category.equalsIgnoreCase("MBPDWKSCSAT5 3/20")
			||Category.equalsIgnoreCase("MBPDWLKSA-CA320")
			||Category.equalsIgnoreCase("MBPDWLKSAT1-CA 03/20")
			||Category.equalsIgnoreCase("MBPDWSA 320")
			||Category.equalsIgnoreCase("MBPDWSAT1 320")
			||Category.equalsIgnoreCase("MBPDWSAT5 320")
			||Category.equalsIgnoreCase("MBPDWKSCSA320")
			||Category.equalsIgnoreCase("MBPDAB 320")
			||Category.equalsIgnoreCase("MBPDABT1 320")
			||Category.equalsIgnoreCase("MBPDKAB 320")
			||Category.equalsIgnoreCase("MBPDKABT1 320")
			||Category.equalsIgnoreCase("MBPDKSA 320")
			||Category.equalsIgnoreCase("MBPDKSAT1 320")
			||Category.equalsIgnoreCase("MBPDKSAT5 320")
			||Category.equalsIgnoreCase("MBPDKSCSA 320")
			||Category.equalsIgnoreCase("MBPDKSCSAT1 320")
			||Category.equalsIgnoreCase("MBPDKSCSAT5 320")
			||Category.equalsIgnoreCase("MBDENT 320")
			||Category.equalsIgnoreCase("MBKEY 320")
			||Category.equalsIgnoreCase("MBKEYSC 320")
			||Category.equalsIgnoreCase("MBLKEY-CA 320")
			||Category.equalsIgnoreCase("MBPDLKSA-CA 320")
			||Category.equalsIgnoreCase("MBPDLKSAT1CA320")
			||Category.equalsIgnoreCase("MBPDSA 320")
			||Category.equalsIgnoreCase("MBPDSAT1 320")
			||Category.equalsIgnoreCase("MBPDSAT5 320")
			||Category.equalsIgnoreCase("MBPDWAB 320")
			||Category.equalsIgnoreCase("MBPDWABT1 320")
			||Category.equalsIgnoreCase("MBPDWKAB 320")
			||Category.equalsIgnoreCase("MBPDWKABT1 320")
			||Category.equalsIgnoreCase("MBTCVAB 320")
			||Category.equalsIgnoreCase("MBTCVABT1 320")
			||Category.equalsIgnoreCase("ECMBTCVAB")
			||Category.equalsIgnoreCase("ECMBTCVABT1")
			||Category.equalsIgnoreCase("ECMBTCVSA320")
			||Category.equalsIgnoreCase("ECMBTCVSAT1320")
			||Category.equalsIgnoreCase("ECMBTCVAB320")
			||Category.equalsIgnoreCase("ECMBTCVABT1320")
			||Category.equalsIgnoreCase("ECMBTCVSAT5320")
			||Category.equalsIgnoreCase("ECMBTCVABT5320")
			||Category.equalsIgnoreCase("ECMBTSAT1W320")
			||Category.equalsIgnoreCase("ECMBPSAFJ"))
		{
			psp.selectProduct(Product);
			psp.enterTerm(Term);			
			psp.clickSubmit();
		}	
		else if(Category.equalsIgnoreCase("MBPDWKSAT1")
				||Category.equalsIgnoreCase("MBPDWKSCA-CAN 11/19")) {
		//	    
			psp.selectProduct(Product);
			psp.clickCoverageZD(Coverage);
			psp.enterTerm(Term);			
			psp.clickSubmit();
		}
		else if(Category.equalsIgnoreCase("ECMBCDFJ")||Category.equalsIgnoreCase("ECMBDENT320"))
				{
			psp.selectProduct(Product);
			psp.clickCoverage(Coverage);
			psp.enterTerm(Term);			
			psp.clickSubmit();
		}
		else if(Category.equalsIgnoreCase("MBTPVSC 320")||Category.equalsIgnoreCase("ECMBTPVSC1120")){
			psp.selectProduct(Product);
			psp.clickCoverage(Coverage);
			psp.selectTerm(Term);			
			psp.clickSubmit();
		}	
		else if(Category.equalsIgnoreCase("ECMPDWKSCA")){
			psp.selectProduct(Product);
			psp.clickCoverageZD(Coverage);
			psp.selectTerm(Term);			
			psp.clickSubmit();
		}	
		else
		{			
			psp.selectProduct(Product);
			psp.clickCoverage(Coverage);
			psp.enterTerm(Term);			
			psp.clickSubmit();
		}
		
		
	}
	
	public void productConditionMBCA(String Category, String Product, String Coverage, String Term)
	{
		if (Category.equalsIgnoreCase("MBPDWKSCA-CAN 11/19"))
		{
		ProductSelectionPage psp=new ProductSelectionPage(Hooks.driver);
		psp.selectProduct(Product);
		psp.clickCoverageMBCA(Coverage);
		psp.enterTerm(Term);			
		psp.clickSubmit();
		}
	}
}
