package commonFunctions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import configurations.Hooks;
import configurations.UrlRepository;
import utility.GetScreenshot;
import utility.Log;

public class UrlMapping {

	public WebDriver driver;
	public String environment = Hooks.activeEnvironment;

	public UrlMapping(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void openUrl(String Portal) {
		if (environment.equalsIgnoreCase("QA")) {
			try {
				if (Portal.contains("Volkswagen")) {
					driver.get(UrlRepository.Volkswagen_VCI_QA);
					Log.log.debug(UrlRepository.Volkswagen_VCI_QA + " is open");
				} else if (Portal.contains("Audi")) {
					driver.get(UrlRepository.Audi_VCI_QA);
					Log.log.debug(UrlRepository.Audi_VCI_QA + " is open");
				}

				else if (Portal.contains("Ducati")) {
					driver.get(UrlRepository.Ducati_VCI_QA);
					Log.log.debug(UrlRepository.Ducati_VCI_QA + " is open");
				} else if (Portal.contains("QualityProtect")) {
					driver.get(UrlRepository.QualityProtect_VCI_QA);
					Log.log.debug(UrlRepository.QualityProtect_VCI_QA + " is open");
				}

				else if (Portal.contains("Vroom")) {
					driver.get(UrlRepository.Vroom_QA);
					Log.log.debug(UrlRepository.Vroom_QA + " is open");
				}

				else if (Portal.contains("Fuccillo")) {
					driver.get(UrlRepository.Fuccillo_QA);
					Log.log.debug(UrlRepository.Fuccillo_QA + " is open");
				}

				else if (Portal.contains("Alphera")) {
					driver.get(UrlRepository.Alphera_QA);
					Log.log.debug(UrlRepository.Alphera_QA + " is open");
				}

				else if (Portal.contains("Harley_us")) {
					driver.get(UrlRepository.Harley_us_QA);
					Log.log.debug(UrlRepository.Harley_us_QA + " is open");
				}

				else if (Portal.contains("Harley_Canada")) {
					driver.get(UrlRepository.Harley_Canada_QA);
					Log.log.debug(UrlRepository.Harley_Canada_QA + " is open");
				}

				else if (Portal.contains("Penske")) {
					driver.get(UrlRepository.Penske_QA);
					Log.log.debug(UrlRepository.Penske_QA + " is open");
				}

				else if (Portal.contains("RollsRoyce")) {
					driver.get(UrlRepository.RollsRoyce_QA);
					Log.log.debug(UrlRepository.RollsRoyce_QA + " is open");
				}

				else if (Portal.contains("Porsche_US")) {
					driver.get(UrlRepository.Porsche_US_QA);
					Log.log.debug(UrlRepository.Porsche_US_QA + " is open");
				}

				else if (Portal.contains("Bentley_US")) {
					driver.get(UrlRepository.Bentley_US_QA);
					Log.log.debug(UrlRepository.Bentley_US_QA + " is open");
				}

				else if (Portal.contains("Lamborghini_US")) {
					driver.get(UrlRepository.Lamborghini_US_QA);
					Log.log.debug(UrlRepository.Lamborghini_US_QA + " is open");
				}

				else if (Portal.contains("Porsche_Canada")) {
					driver.get(UrlRepository.Porsche_Canada_QA);
					Log.log.debug(UrlRepository.Porsche_Canada_QA + " is open");
				}

				else if (Portal.contains("Bentley_Canada")) {
					driver.get(UrlRepository.Bentley_Canada_QA);
					Log.log.debug(UrlRepository.Bentley_Canada_QA + " is open");
				}

				else if (Portal.contains("Lamborghini_Canada")) {
					driver.get(UrlRepository.Lamborghini_Canada_QA);
					Log.log.debug(UrlRepository.Lamborghini_Canada_QA + " is open");
				}

				else if (Portal.contains("BMW_MINI")) {
					driver.get(UrlRepository.BMW_MINI_QA);
					Log.log.debug(UrlRepository.BMW_MINI_QA + " is open");
				}

				else if (Portal.contains("Motorrad")) {
					driver.get(UrlRepository.Motorrad_QA);
					Log.log.debug(UrlRepository.Motorrad_QA + " is open");
				}
				
				else if (Portal.equalsIgnoreCase("Honda")) {
					driver.get(UrlRepository.Honda_QA);
					Log.log.debug(UrlRepository.Honda_QA + " is open");
				}

				else if (Portal.contains("Acura")) {
					driver.get(UrlRepository.Acura_QA);
					Log.log.debug(UrlRepository.Acura_QA + " is open");
				}

			} catch (Exception e) {
				GetScreenshot.captureScreenshot();
				Assert.assertTrue(e.getMessage(), false);
			}
		}

		else if (environment.equalsIgnoreCase("UAT")) {
			try {
				if (Portal.contains("Volkswagen")) {
					driver.get(UrlRepository.Volkswagen_VCI_UAT);
					Log.log.debug(UrlRepository.Volkswagen_VCI_UAT + " is open");
				}

				else if (Portal.contains("Audi")) {
					driver.get(UrlRepository.Audi_VCI_UAT);
					Log.log.debug(UrlRepository.Audi_VCI_UAT + " is open");
				}

				else if (Portal.contains("Ducati")) {
					driver.get(UrlRepository.Ducati_VCI_UAT);
					Log.log.debug(UrlRepository.Ducati_VCI_UAT + " is open");
				} else if (Portal.contains("QualityProtect")) {
					driver.get(UrlRepository.QualityProtect_VCI_UAT);
					Log.log.debug(UrlRepository.QualityProtect_VCI_UAT + " is open");
				}

				else if (Portal.contains("Vroom")) {
					driver.get(UrlRepository.Vroom_UAT);
					Log.log.debug(UrlRepository.Vroom_UAT + " is open");
				}

				else if (Portal.contains("Fuccillo")) {
					driver.get(UrlRepository.Fuccillo_UAT);
					Log.log.debug(UrlRepository.Fuccillo_UAT + " is open");
				}

				else if (Portal.contains("Alphera")) {
					driver.get(UrlRepository.Alphera_UAT);
					Log.log.debug(UrlRepository.Alphera_UAT + " is open");
				}

				else if (Portal.contains("Harley_us")) {
					driver.get(UrlRepository.Harley_us_UAT);
					Log.log.debug(UrlRepository.Harley_us_UAT + " is open");
				} else if (Portal.contains("Harley_Canada")) {
					driver.get(UrlRepository.Harley_Canada_UAT);
					Log.log.debug(UrlRepository.Harley_Canada_UAT + " is open");
				}

				else if (Portal.contains("RollsRoyce")) {
					driver.get(UrlRepository.RollsRoyce_UAT);
					Log.log.debug(UrlRepository.RollsRoyce_UAT + " is open");
				}

				else if (Portal.contains("Penske")) {
					driver.get(UrlRepository.Penske_UAT);
					Log.log.debug(UrlRepository.Penske_UAT + " is open");
				} else if (Portal.contains("Porsche_US")) {
					driver.get(UrlRepository.Porsche_US_UAT);
					Log.log.debug(UrlRepository.Porsche_US_UAT + " is open");
				}

				else if (Portal.contains("Bentley_US")) {
					driver.get(UrlRepository.Bentley_US_UAT);
					Log.log.debug(UrlRepository.Bentley_US_UAT + " is open");
				}

				else if (Portal.contains("Lamborghini_US")) {
					driver.get(UrlRepository.Lamborghini_US_UAT);
					Log.log.debug(UrlRepository.Lamborghini_US_UAT + " is open");
				}

				else if (Portal.contains("Porsche_Canada")) {
					driver.get(UrlRepository.Porsche_Canada_UAT);
					Log.log.debug(UrlRepository.Porsche_Canada_UAT + " is open");
				}

				else if (Portal.contains("Bentley_Canada")) {
					driver.get(UrlRepository.Bentley_Canada_UAT);
					Log.log.debug(UrlRepository.Bentley_Canada_UAT + " is open");
				}

				else if (Portal.contains("Lamborghini_Canada")) {
					driver.get(UrlRepository.Lamborghini_Canada_UAT);
					Log.log.debug(UrlRepository.Lamborghini_Canada_UAT + " is open");
				}

				else if (Portal.contains("BMW_MINI")) {
					driver.get(UrlRepository.BMW_MINI_UAT);
					Log.log.debug(UrlRepository.BMW_MINI_UAT + " is open");
				}

				else if (Portal.contains("Motorrad")) {
					driver.get(UrlRepository.Motorrad_UAT);
					Log.log.debug(UrlRepository.Motorrad_UAT + " is open");
				}

				else if (Portal.equalsIgnoreCase("Honda")) {
					driver.get(UrlRepository.Honda_UAT);
					Log.log.debug(UrlRepository.Honda_UAT + " is open");
				}

				else if (Portal.contains("Acura")) {
					driver.get(UrlRepository.Acura_UAT);
					Log.log.debug(UrlRepository.Acura_UAT + " is open");
				}

				
			} catch (Exception e) {
				GetScreenshot.captureScreenshot();
				Assert.assertTrue(e.getMessage(), false);
			}
		}

		else if (environment.equalsIgnoreCase("PRODUCTION")) {
			try {
				if (Portal.contains("Volkswagen")) {
					driver.get(UrlRepository.Volkswagen_VCI_PROD);
					Log.log.debug(UrlRepository.Volkswagen_VCI_PROD + " is open");
				}

				else if (Portal.contains("Audi")) {
					driver.get(UrlRepository.Audi_VCI_PROD);
					Log.log.debug(UrlRepository.Audi_VCI_PROD + " is open");
				}

				else if (Portal.contains("Ducati")) {
					driver.get(UrlRepository.Ducati_VCI_PROD);
					Log.log.debug(UrlRepository.Ducati_VCI_PROD + " is open");
				}

				else if (Portal.contains("QualityProtect")) {
					driver.get(UrlRepository.QualityProtect_VCI_PROD);
					Log.log.debug(UrlRepository.QualityProtect_VCI_PROD + " is open");
				}

				else if (Portal.contains("Vroom")) {
					driver.get(UrlRepository.Vroom_PROD);
					Log.log.debug(UrlRepository.Vroom_PROD + " is open");
				}

				else if (Portal.contains("Fuccillo")) {
					driver.get(UrlRepository.Fuccillo_PROD);
					Log.log.debug(UrlRepository.Fuccillo_PROD + " is open");
				}

				else if (Portal.contains("Alphera")) {
					driver.get(UrlRepository.Alphera_PROD);
					Log.log.debug(UrlRepository.Alphera_PROD + " is open");
				}

				else if (Portal.contains("Harley_us")) {
					driver.get(UrlRepository.Harley_us_PROD);
					Log.log.debug(UrlRepository.Harley_us_PROD + " is open");
				}

				else if (Portal.contains("Harley_Canada")) {
					driver.get(UrlRepository.Harley_Canada_PROD);
					Log.log.debug(UrlRepository.Harley_Canada_PROD + " is open");
				}

				else if (Portal.contains("RollsRoyce")) {
					driver.get(UrlRepository.RollsRoyce_PROD);
					Log.log.debug(UrlRepository.RollsRoyce_PROD + " is open");
				}

				else if (Portal.contains("Penske")) {
					driver.get(UrlRepository.Penske_PROD);
					Log.log.debug(UrlRepository.Penske_PROD + " is open");
				}

				else if (Portal.contains("Porsche_US")) {
					driver.get(UrlRepository.Porsche_US_PROD);
					Log.log.debug(UrlRepository.Porsche_US_PROD + " is open");
				}

				else if (Portal.contains("Bentley_US")) {
					driver.get(UrlRepository.Bentley_US_PROD);
					Log.log.debug(UrlRepository.Bentley_US_PROD + " is open");
				}

				else if (Portal.contains("Lamborghini_US")) {
					driver.get(UrlRepository.Lamborghini_US_PROD);
					Log.log.debug(UrlRepository.Lamborghini_US_PROD + " is open");
				}

				else if (Portal.contains("Porsche_Canada")) {
					driver.get(UrlRepository.Porsche_Canada_PROD);
					Log.log.debug(UrlRepository.Porsche_Canada_PROD + " is open");
				}

				else if (Portal.contains("Bentley_Canada")) {
					driver.get(UrlRepository.Bentley_Canada_PROD);
					Log.log.debug(UrlRepository.Bentley_Canada_PROD + " is open");
				}

				else if (Portal.contains("Lamborghini_Canada")) {
					driver.get(UrlRepository.Lamborghini_Canada_PROD);
					Log.log.debug(UrlRepository.Lamborghini_Canada_PROD + " is open");
				}

				else if (Portal.contains("BMW_MINI")) {
					driver.get(UrlRepository.BMW_MINI_PROD);
					Log.log.debug(UrlRepository.BMW_MINI_PROD + " is open");
				}

				else if (Portal.contains("Motorrad")) {
					driver.get(UrlRepository.Motorrad_PROD);
					Log.log.debug(UrlRepository.Motorrad_PROD + " is open");
				}
				
				else if (Portal.equalsIgnoreCase("Honda")) {
					driver.get(UrlRepository.Honda_PROD);
					Log.log.debug(UrlRepository.Honda_PROD + " is open");
				}

				else if (Portal.contains("Acura")) {
					driver.get(UrlRepository.Acura_PROD);
					Log.log.debug(UrlRepository.Acura_PROD + " is open");
				}


			} catch (Exception e) {
				GetScreenshot.captureScreenshot();
				Assert.assertTrue(e.getMessage(), false);
			}
		}

	}
}
