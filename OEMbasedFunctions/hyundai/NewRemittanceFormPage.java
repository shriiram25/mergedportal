package hyundai;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import utility.CurrentDateSelection;
import utility.GetScreenshot;

public class NewRemittanceFormPage {

                public WebDriver driver;

                public NewRemittanceFormPage(WebDriver driver) {
                                this.driver = driver;
                                PageFactory.initElements(driver, this);
                }

                @FindBy(id = "vin")
                public WebElement vinNo;

                // Enter VIN Number
                public void vinNumber(String vinNum) {

                                try {
                                                WebDriverWait wait = new WebDriverWait(driver, 60);
                                                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("vin")));
                                               // vinNo.sendKeys(vinNum);
                                                vinNo.sendKeys(vinNum);
                                } catch (Exception e) {
                                                GetScreenshot.captureScreenshot();
                                                Assert.assertTrue(e.getMessage(), false);
                                }
                }

                @FindBy(id = "programType")
                public WebElement pType;

                // Select Program Type
                public void ProgType(String ProType) {
                                try {
                                                WebDriverWait wait = new WebDriverWait(driver, 60);
                                                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("programType")));
                                                Select select = new Select(pType);
                                                select.selectByVisibleText(ProType);
                                                if (ProType.equalsIgnoreCase("Hyundai Circle")) {
                                                                Alert alert = driver.switchTo().alert();
                                                                String alText = alert.getText();
                                                                String acText = "HPP E-Plan pricing is only available when purchasing a new Hyundai via the Hyundai Circle E-Plan Program.";
                                                                alert.accept();
                                                                Assert.assertEquals(acText, alText);
                                                }
                                                if (ProType.equalsIgnoreCase("Livery")) {
                                                                Alert alert = driver.switchTo().alert();
                                                                String alText = alert.getText();
                                                                String acText = "This product is to be sold only on a new Hyundai sold to a Livery business.";
                                                                alert.accept();
                                                                Assert.assertEquals(acText, alText);
                                                }

                                } catch (Exception e) {
                                                GetScreenshot.captureScreenshot();
                                                Assert.assertTrue(e.getMessage(), false);
                                }
                }

                @FindBy(id = "currentOdometer")
                public WebElement odo;

                // Enter Current Odometer
                public void curOdometer(String odometer) {
                                try {
                                                WebDriverWait wait = new WebDriverWait(driver, 60);
                                                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("currentOdometer")));
                                                /*
                                                * int indexdot=odometer.indexOf(".");
                                                * //System.out.println(indexdot); String
                                                * subOdo=odometer.substring(0, indexdot);
                                                * //System.out.println("subOdo"+subOdo);
                                                */
                                                odo.sendKeys(odometer);
                                } catch (Exception e) {
                                                GetScreenshot.captureScreenshot();
                                                Assert.assertTrue(e.getMessage(), false);
                                }
                }

                @FindBy(id = "getOptions")
                public WebElement getOpt;

                // Click on Get Option Button
                public void getOption() {
                                try {
                                                WebDriverWait wait = new WebDriverWait(driver, 60);
                                                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("getOptions")));
                                                getOpt.click();
                                } catch (Exception e) {
                                                GetScreenshot.captureScreenshot();
                                                Assert.assertTrue(e.getMessage(), false);
                                }
                }

                @FindBy(id = "formNumber")
                public WebElement fNumber;

                // Select Product Form
                public void productForm(String pForm) {
                                boolean product = false;
                                try {
                                                WebDriverWait wait = new WebDriverWait(driver, 60);
                                                wait.until(ExpectedConditions.elementToBeClickable(By.id("formNumber")));
                                                // Select select =new Select(fNumber);
                                                // select.selectByVisibleText(pForm);
                                                // select.selectByValue(pForm);
                                                
                                                fNumber.click();

                                                List<WebElement> list = driver.findElements(By.xpath(".//*[@id='formNumber']/option"));
                                                for (int i = 0; i < list.size(); i++) {  
                                                                String text = list.get(i).getText().trim();
                                                                //System.out.println("Form<<<"+pForm+">>>");
                                                                //System.out.println("text<<<"+text+">>>");
                                                                if (pForm.equalsIgnoreCase(text)) {
                                                                                list.get(i).click();
                                                                                product = true;
                                                                                break;
                                                                }                                                                                                              
                                                }
                                                
                                                Assert.assertTrue("Not able to find the product:- "+pForm, product);

                                } catch (Exception e) {
                                                GetScreenshot.captureScreenshot();
                                                Assert.assertTrue(e.getMessage(), false);
                                }
                }

                @FindBy(id = "coverageCode")
                public WebElement coverage;

                // Select Coverage
                public void covCode(String cCode) {
                                try {
                                                WebDriverWait wait = new WebDriverWait(driver, 60);
                                                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("coverageCode")));
                                                /*String optVal = null;
                                                if (cCode.equalsIgnoreCase("PLATINUM")) {
                                                                optVal = "SFlWU1BMQVQ=";
                                                } else if (cCode.equalsIgnoreCase("GOLD")) {
                                                                optVal = "SFlWU0dPTEQ=";
                                                } else if (cCode.equalsIgnoreCase("POWERTRAIN")) {
                                                                optVal = "SFlWU1BUUk4=";
                                                }*/
                                                Select select = new Select(coverage);
                                                // select.selectByValue(optVal);
                                                select.selectByVisibleText(cCode);
                                } catch (Exception e) {
                                                Assert.assertTrue(e.getMessage(), false);
                                }
                }

                @FindBy(xpath = "//*[@id='rateAndRemitOnline']/h3")
                public WebElement clickOut;

                public void clickOutSide() {
                                try {
                                                WebDriverWait wait = new WebDriverWait(driver, 60);
                                                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='rateAndRemitOnline']/h3")));
                                                clickOut.click();
                                } catch (Exception e) {
                                                Assert.assertTrue(e.getMessage(), false);
                                }
                }

                @FindBy(id = "term")
                public WebElement PTerm;

                // Enter Term
                public void ProductTerm(String PT) {
                                try {
                                                WebDriverWait wait = new WebDriverWait(driver, 60);
                                                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("termRangeDisplay")));
                                                /*
                                                * int indexPT=PT.indexOf("."); //System.out.println(indexPT);
                                                * String PTer=PT.substring(0, indexPT); //System.out.println(
                                                * "PTer "+PTer);
                                                */
                                                PTerm.sendKeys(PT);
                                } catch (Exception e) {
                                                GetScreenshot.captureScreenshot();
                                                Assert.assertTrue(e.getMessage(), false);
                                }
                }

                @FindBy(id = "exception_vscTermMileage")
                public WebElement TMilage;

                // Enter Term Mileage
                public void TermMileage(String TM) {
                                try {
                                                WebDriverWait wait = new WebDriverWait(driver, 60);
                                                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("exception_vscTermMileage")));
                                                /*
                                                * int indexTM=TM.indexOf("."); //System.out.println(indexTM);
                                                * String TMil=TM.substring(0, indexTM); //System.out.println(
                                                * "PTer "+TMil);
                                                */
                                                TMilage.sendKeys(TM);
                                } catch (Exception e) {
                                                GetScreenshot.captureScreenshot();
                                                Assert.assertTrue(e.getMessage(), false);
                                }
                }

                @FindBy(id = "exception_vscDeductible")
                public WebElement deductible;

                // Enter deductible
                public void vscDeductible(String VD) {
                                try {
                                                WebDriverWait wait = new WebDriverWait(driver, 60);
                                                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("exception_vscDeductible")));
                                                /*
                                                * int indexTM=VD.indexOf("."); //System.out.println(indexTM);
                                                * String TMil=VD.substring(0, indexTM); //System.out.println(
                                                * "PTer "+TMil);
                                                */
                                                deductible.sendKeys(VD);
                                } catch (Exception e) {
                                                GetScreenshot.captureScreenshot();
                                                Assert.assertTrue(e.getMessage(), false);
                                }
                }

                @FindBy(id = "exception_vscInServiceDate")
                public WebElement currentDate;

                // Select Current Date
                public void cDate() {
                                try {
                                                WebDriverWait wait = new WebDriverWait(driver, 60);
                                                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("exception_vscInServiceDate")));
                                                String cd = CurrentDateSelection.getCurrentDate();
                                                currentDate.sendKeys(cd);
                                } catch (Exception e) {
                                                Assert.assertTrue(e.getMessage(), false);
                                }
                }

                //@FindBy(xpath = "html/body/div[8]/div[11]/button[2]")
                @FindBy(xpath ="//div[8]/div[11]/button[contains(text(),'Save Info')]")
                public WebElement saveInfo;

                // Click on Save Info Button
                public void saveInfoButton() {
                                try {
                                                WebDriverWait wait = new WebDriverWait(driver, 60);
                                               // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[8]/div[11]/button[2]")));
                                                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[8]/div[11]/button[contains(text(),'Save Info')]")));
                                                saveInfo.click();
                                } catch (Exception e) {
                                                GetScreenshot.captureScreenshot();
                                                Assert.assertTrue(e.getMessage(), false);
                                }
                }
                @FindBy(xpath = "/html/body/div[8]/div[11]/button[2]")
                public WebElement saveInfoIn_service;

                // Click on Save Info Button
                public void saveInfo_inserviceButton() {
                                try {
                                                WebDriverWait wait = new WebDriverWait(driver, 60);
                                                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[8]/div[11]/button[2]")));
                                                saveInfoIn_service.click();
                                } catch (Exception e) {
                                                GetScreenshot.captureScreenshot();
                                                Assert.assertTrue(e.getMessage(), false);
                                }
                }

                @FindBy(id = "financeAmount")
                public WebElement finAmount;

                // Enter Finance Amount
                public void financeAmount(String FA) {
                                try {
                                                WebDriverWait wait = new WebDriverWait(driver, 60);
                                                wait.until(ExpectedConditions.elementToBeClickable(finAmount));
                                                /*
                                                * int indexTM=FA.indexOf("."); //System.out.println(indexTM);
                                                * String TMil=FA.substring(0, indexTM); //System.out.println(
                                                * "PTer "+TMil);
                                                */
                                                finAmount.clear();
                                                finAmount.sendKeys(FA);
                                } catch (Exception e) {
                                                Assert.assertTrue(e.getMessage(), false);
                                }
                }

                @FindBy(id = "customerCost")
                public WebElement custCost;

                @FindBy(xpath = "//*[@id='customerCost-label']/label")
                public WebElement rE;

                // Enter Cuctomer Cost
                public void customerCost(String state, String eRate) {
                                try {
                                                WebDriverWait wait = new WebDriverWait(driver, 60);
                                                wait.until(ExpectedConditions.visibilityOf(custCost));
                                                Thread.sleep(4000L);
                                                String reText = rE.getText();
                                                if (!(reText.equalsIgnoreCase("Retail Rate")||reText.equalsIgnoreCase("Maximum Retail Rate"))) {
                                                                wait.until(ExpectedConditions.elementToBeClickable(custCost));
                                                                custCost.clear();
                                                                custCost.sendKeys(eRate);
                                                }                              
                                } catch (Exception e) {
                                                Assert.assertTrue(e.getMessage(), false);
                                }
                }

                @FindBy(id = "rate")
                public WebElement rate;

                public String getProductCost(){
                                String cost = "";
                                try {
                                                WebDriverWait wait = new WebDriverWait(driver, 30);
                                                wait.until(ExpectedConditions.visibilityOf(rate));
                                                Thread.sleep(1000L);
                                                cost = rate.getAttribute("value").trim();                                               
                                } catch (Exception e) {
                                                GetScreenshot.captureScreenshot();
                                                Assert.assertTrue(e.getMessage(), false);                                           
                                }
                                return cost;                        
                }
                
                public String productCostMatch(String expRate, String actualRate){
                                String status = "";
                                try {                                        
                                                if(actualRate.equalsIgnoreCase(expRate)){
                                                                status = "Pass";
                                                                //Assert.assertTrue("Rate didn't match", false);
                                                } else {
                                                                status = "Fail";
                                                }
                                } catch (Exception e) {
                                                GetScreenshot.captureScreenshot();
                                                Assert.assertTrue(e.getMessage(), false);           
                                }
                                return status;
                }
                
                @FindBy(id = "firstName")
                public WebElement fName;

                // Enter First Name
                public void firstName(String FN) {
                                try {
                                                WebDriverWait wait = new WebDriverWait(driver, 60);
                                                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName")));
                                                fName.clear();
                                                fName.sendKeys(FN);
                                } catch (Exception e) {
                                                GetScreenshot.captureScreenshot();
                                                Assert.assertTrue(e.getMessage(), false);
                                }
                }

                @FindBy(id = "lastName")
                public WebElement lName;

                // Enter Last Name
                public void lastName(String LN) {
                                try {
                                                WebDriverWait wait = new WebDriverWait(driver, 60);
                                                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lastName")));
                                                lName.clear();
                                                lName.sendKeys(LN);
                                } catch (Exception e) {
                                                GetScreenshot.captureScreenshot();
                                                Assert.assertTrue(e.getMessage(), false);
                                }
                }

                @FindBy(id = "addContract")
                public WebElement addContrac;

                public void addCon() {
                                try {
                                                WebDriverWait wait = new WebDriverWait(driver, 60);
                                                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("addContract")));
                                                addContrac.click();
                                } catch (Exception e) {
                                                Assert.assertTrue(e.getMessage(), false);
                                }
                }

                @FindBy(id = "add_address")
                public WebElement addAddress;

                // Enter Address
                public void addAdd(String ADD) {
                                try {
                                                WebDriverWait wait = new WebDriverWait(driver, 60);
                                                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add_address")));
                                                addAddress.sendKeys(ADD);
                                } catch (Exception e) {
                                                GetScreenshot.captureScreenshot();
                                                Assert.assertTrue(e.getMessage(), false);
                                }
                }

                @FindBy(id = "add_city")
                public WebElement addCity;

                // Enter City
                public void addCit(String CITY) {
                                try {
                                                WebDriverWait wait = new WebDriverWait(driver, 60);
                                                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add_city")));
                                                addCity.sendKeys(CITY);
                                } catch (Exception e) {
                                                GetScreenshot.captureScreenshot();
                                                Assert.assertTrue(e.getMessage(), false);
                                }
                }

                @FindBy(id = "add_state")
                public WebElement addSt;

                // Enter State
                public void addState(String ST) {
                                try {
                                                WebDriverWait wait = new WebDriverWait(driver, 60);
                                                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add_state")));
                                                addSt.sendKeys(ST);
                                } catch (Exception e) {
                                                GetScreenshot.captureScreenshot();
                                                Assert.assertTrue(e.getMessage(), false);
                                }
                }

                @FindBy(id = "add_zip")
                public WebElement addZ;

                // Enter ZIP
                public void addZip(String ZIP) {
                                try {
                                                WebDriverWait wait = new WebDriverWait(driver, 60);
                                                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add_zip")));
                                                /*
                                                * int indexTM=ZIP.indexOf("."); //System.out.println(indexTM);
                                                * String TMil=ZIP.substring(0, indexTM); //System.out.println(
                                                * "PTer "+TMil);
                                                */
                                                addZ.sendKeys(ZIP);
                                } catch (Exception e) {
                                                GetScreenshot.captureScreenshot();
                                                Assert.assertTrue(e.getMessage(), false);
                                }
                }

                @FindBy(id = "add_homePhone")
                public WebElement addHome;

                // Enter Home Phone
                public void addHomePhome(String HPhone) {
                                try {
                                                WebDriverWait wait = new WebDriverWait(driver, 60);
                                                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add_homePhone")));
                                                // int indexTM=HPhone.indexOf(".");
                                                // System.out.println(indexTM);
                                                // String TMil=HPhone.substring(0, indexTM);
                                                // System.out.println("PTer "+TMil);
                                                addHome.sendKeys(HPhone);
                                } catch (Exception e) {
                                                Assert.assertTrue(e.getMessage(), false);
                                }
                }

                @FindBy(id = "add_vehicleCondition")
                public WebElement vecCon;

                // Select Vechile Condation
                public void vechileCond(String VC) {
                                try {
                                                WebDriverWait wait = new WebDriverWait(driver, 60);
                                                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add_vehicleCondition")));
                                                Select select = new Select(vecCon);
                                                //select.selectByVisibleText(VC);
                                                select.selectByIndex(0);
                                } catch (Exception e) {
                                                Assert.assertTrue(e.getMessage(), false);
                                }
                }

                @FindBy(id = "add_paymentType")
                public WebElement paymentType;

                // Select Payment Type
                public void addPayType(String PT) {
                                try {
                                                WebDriverWait wait = new WebDriverWait(driver, 60);
                                                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add_paymentType")));
                                                Select select = new Select(paymentType);
                                               // select.selectByVisibleText(PT);
                                                select.selectByIndex(1);
                                } catch (Exception e) {
                                                Assert.assertTrue(e.getMessage(), false);
                                }
                }

                @FindBy(xpath = "html/body/div[8]/div[11]/button[2]")
                public WebElement saveI;

                public void saveCon() {
                                try {
                                                WebDriverWait wait = new WebDriverWait(driver, 60);
                                                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[8]/div[11]/button[2]")));
                                                saveI.click();
                                } catch (Exception e) {
                                                Assert.assertTrue(e.getMessage(), false);
                                }
                }
                @FindBy(xpath = "html/body/div[9]/div[11]/button[2]")
                public WebElement saveIn_service;

                public void savein_serviceCon() {
                                try {
                                                WebDriverWait wait = new WebDriverWait(driver, 60);
                                                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[9]/div[11]/button[2]")));
                                                saveIn_service.click();
                                } catch (Exception e) {
                                                Assert.assertTrue(e.getMessage(), false);
                                }
                }

                @FindBy(id = "rateType-ppm")
                public WebElement PPM;

                // Click on PPM Radio Button
                public void PPMProductCategory() {
                                try {
                                                WebDriverWait wait = new WebDriverWait(driver, 60);
                                                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("rateType-ppm")));
                                                PPM.click();
                                } catch (Exception e) {
                                                Assert.assertTrue(e.getMessage(), false);
                                }
                }

                @FindBy(id = "rateType-gen")
                public WebElement gen;

                // Click on CPO Radio Button
                public void genProductCategory() {
                                try {
                                                WebDriverWait wait = new WebDriverWait(driver, 60);
                                                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("rateType-gen")));
                                                gen.click();
                                } catch (Exception e) {
                                                Assert.assertTrue(e.getMessage(), false);
                                }
                }

                @FindBy(id = "exception_msrp")
                public WebElement expMsrp;

                public void exceptionMsrp(String EM) {
                                try {
                                                WebDriverWait wait = new WebDriverWait(driver, 60);
                                                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("exception_msrp")));
                                                expMsrp.sendKeys(EM);
                                } catch (Exception e) {
                                                Assert.assertTrue(e.getMessage(), false);
                                }
                }

                @FindBy(xpath = "html/body/div[9]/div[11]/button[2]")
                public WebElement vehicleSaveInfo;

                public void vechicleSave() {
                                try {
                                                WebDriverWait wait = new WebDriverWait(driver, 60);
                                                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[9]/div[11]/button[2]")));
                                                vehicleSaveInfo.click();
                                                ////Thread.sleep(10000L);
                                } catch (Exception e) {
                                                Assert.assertTrue(e.getMessage(), false);
                                }
                }

                @FindBy(id = "add_lienholder")
                public WebElement lienHolder;

                public void addLienHolder(String ALH) {
                                try {
                                                WebDriverWait wait = new WebDriverWait(driver, 60);
                                                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add_lienholder")));
                                                lienHolder.sendKeys(ALH);
                                } catch (Exception e) {
                                                Assert.assertTrue(e.getMessage(), false);
                                }
                }

                @FindBy(id = "add_msrp")
                public WebElement msrp;

                public void addMSRP(String MSRP) {
                                try {
                                                WebDriverWait wait = new WebDriverWait(driver, 60);
                                                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add_msrp")));
                                                msrp.sendKeys(MSRP);
                                } catch (Exception e) {
                                                Assert.assertTrue(e.getMessage(), false);
                                }
                }

                @FindBy(id = "optionChooser")
                public WebElement optionC;

                public void optionChooser() {
                                try {
                                                WebDriverWait wait = new WebDriverWait(driver, 60);
                                                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("optionChooser")));
                                                optionC.click();
                                } catch (Exception e) {
                                                Assert.assertTrue(e.getMessage(), false);
                                }
                }

                @FindBy(id = "full_coverage")
                public WebElement fullCoverage;

                @FindBy(id = "P")
                public WebElement tire;

                @FindBy(id = "W")
                public WebElement windshield;

                @FindBy(id = "D")
                public WebElement dent;
                
                @FindBy(id = "K")
                public WebElement key;
                
                @FindBy(id = "nonCosmaticId")
                public WebElement nonCosmatic;

                public void fullCoverage(String Coverage) {
                                try {
                                                WebDriverWait wait = new WebDriverWait(driver, 60);
                                                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("full_coverage")));

                                                if (Coverage.equalsIgnoreCase("Full Coverage")) {
                                                                fullCoverage.click();
                                                }

                                                if (Coverage.contains("T")||Coverage.contains("P")) {
                                                                tire.click();
                                                }
                                                if (Coverage.contains("X")) {
                                                                windshield.click();
                                                }
                                                if (Coverage.contains("D")) {
                                                                dent.click();
                                                }
                                                if (Coverage.contains("K")) {
                                                                key.click();
                                                }
                                                if (Coverage.contains("T")) {
                                                                nonCosmatic.click();
                                                }
                                                

                                                //Thread.sleep(2000L);

                                } catch (Exception e) {
                                                Assert.assertTrue(e.getMessage(), false);
                                }
                }

                @FindBy(xpath = "//*[@id='multiCoverageContainer']/a[1]/span")
                public WebElement saveSel;

                public void SaveSelector() {
                                try {
                                                WebDriverWait wait = new WebDriverWait(driver, 60);
                                                wait.until(ExpectedConditions.elementToBeClickable(saveSel));
                                                saveSel.click();
                                } catch (Exception e) {
                                                Assert.assertTrue(e.getMessage(), false);
                                }
                }

}
