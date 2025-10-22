Feature: To Test EAS Portal Functionalities

  @Smoke_LogIn_logOut
  Scenario Outline: EAS Portals Log-in and Log-out
    Given Go to url with data as "<TestCase>" and "<Portal>" and "<Language>"and "<Dealer>"
    And Verifying the funtionality of "<Functionality>"
    And Login as "<UserName>" and "<Password>" and "<Captcha>"
    When Click on add New eContract
    Then Logout out from the portal

    Examples: 
      | TestCase | Portal             | Language       | Dealer   | UserName | Password | Functionality |
      |        1 | Volkswagen_VCI     |                | VW422530 | vwqaauto | ******   | Login         |
      |        2 | Audi_VCI           |                | AU422A03 | auqaauto | ******   | Login         |
      |        3 | Ducati_vci         |                | DU101156 | duqaauto | ******   | Login         |
      |        4 | QualityProtect     |                | QPA00001 | qpqaauto | ******   | Login         |
      |        5 | Vroom              |                | 00AA1000 | vrqaauto | ******   | Login         |
      |        6 | Fuccillo           |                |          | fcqaauto | ******   | Login         |
      |        7 | Alphera            |                | AL124261 | alqaauto | ******   | Login         |
      |        8 | Harley_us          |                | 00HD2116 | harleyus | ******   | Login         |
      |        9 | RollsRoyce         |                |          | rrqaauto | ******   | Login         |
      |       10 | Penske             | English-US     |          | pkqaauto | ******   | Login         |
      |       11 | Porsche_US         |                | PORS0132 | prqaauto | ******   | Login         |
      |       12 | Bentley_US         |                | BENT3226 | bnqaauto | ******   | Login         |
      |       13 | Lamborghini_US     |                | LAMB5303 | lmqaauto | ******   | Login         |
      |       14 | Harley_Canada      | English-Canada | 0HD50020 | hdqaauto | ******   | Login         |
      |       15 | Porsche_Canada     | English-Canada | PORS0132 | pcqaauto | ******   | Login         |
      |       16 | Bentley_Canada     | English-Canada | BENT4013 | bcqaauto | ******   | Login         |
      |       17 | Lamborghini_Canada | English-Canada | LAMB6703 | lcqaauto | ******   | Login         |
      |       18 | BMW_MINI           | English-Canada | BMC06170 | bmqaauto | ******   | Login         |
      |       19 | BMW_MINI           | English-Canada | MNC09130 | miqaauto | ******   | Login         |
      |       20 | Motorrad           | English-Canada | MTC09220 | moqaauto | ******   | Login         |

  @Smoke_VinDecoding
  Scenario Outline: Add a New Contract
    Given Go to url with data as "<TestCase>" and "<Portal>" and "<Language>"and "<Dealer>"
    And Verifying the funtionality of "<Functionality>"
    And Login as "<UserName>" and "<Password>" and "<Captcha>"
    When Click on add New eContract
    And Decode the VIN "<Vin>"
    Then Logout out from the portal

    Examples: 
      | TestCase | Portal             | Language       | Dealer   | UserName | Password | Captcha | Vin               | Make            | Model        | Trim               | Year | Inservicedate | Functionality |
      |        1 | Volkswagen_VCI     |                | VW422530 | vwqaauto | ******   |         | WVWKP7AU1HW114441 | VOLKSWAGEN      | GOLF GTI     | SPORT              | 2017 | 02/28/2017    | VIN_Decoding  |
      |        2 | Audi_VCI           |                | AU422A03 | auqaauto | ******   |         | WAU57LFF4G1024236 | AUDI            | A3           | 1.8T  PREMIUM PLUS | 2016 | 09/05/2017    | VIN_Decoding  |
      |        3 | Ducati_vci         |                | DU101156 | duqaauto | ******   |         | ZDM1YAAN7CB025889 | DUCATI          | HYPERMOTARD  |                796 | 2012 | 09/05/2017    | VIN_Decoding  |
      |        4 | QualityProtect     |                | QPA00001 | qpqaauto | ******   |         | WVWKP7AU1HW894441 | VOLKSWAGEN      | GOLF GTI     | SPORT              | 2017 | 02/28/2017    | VIN_Decoding  |
      |        5 | Vroom              |                | 00AA1000 | vrqaauto | ******   |         | WVWKP7AU1HW111111 |                 |              |                    | 2016 | 2017-06-27    | VIN_Decoding  |
      |        6 | Fuccillo           |                |          | fcqaauto | ******   |         | KMHD84LF5HU066467 |                 |              | SE                 |      | 2017-03-09    | VIN_Decoding  |
      |        7 | Alphera            |                | AL124261 | alqaauto | ******   |         | WAUAFAFL0GN014016 | AUDI            | A3           | 1.8T  PREMIUM PLUS | 2016 | 08-19-2017    | VIN_Decoding  |
      |        8 | Harley_us          |                | 00HD2116 | harleyus | ******   |         | 1HD4CR213GC441034 |                 |              |                    |      | 02/21/2018    | VIN_Decoding  |
      |        9 | RollsRoyce         |                | 07dkrx   | rrqaauto | ******   |         | SCA665C51GUX86012 |                 |              |                    |      | 2018-01-21    | VIN_Decoding  |
      |       10 | Penske             | English-US     |          | pkqaauto | ******   |         | ZFF73SKA6G0215305 |                 |              |                    | 2016 | 2018-02-27    | VIN_Decoding  |
      |       11 | Porsche_US         |                | PORS0132 | prqaauto | ******   |         | WP0AD2A99HS166177 | PORSCHE         |          911 | TURBO S            | 2017 | 2017-01-05    | VIN_Decoding  |
      |       12 | Bentley_US         |                | BENT3226 | bnqaauto | ******   |         | SJAAC2ZV3HC012676 | BENTLEY         | BENTAYGA W12 | BASE               | 2017 | 2016-12-01    | VIN_Decoding  |
      |       13 | Lamborghini_US     |                | LAMB5303 | lmqaauto | ******   |         | ZHWUF3ZD6GLA04855 | LAMBORGHINI     | AVENTADOR    | LP 750-4 SV        | 2016 | 2016-12-01    | VIN_Decoding  |
      |       14 | Harley_Canada      | English-Canada | 0HD50020 | hdqaauto | ******   |         | 1HD1GZM18FC313195 | HARLEY-DAVIDSON | SPORTSTER    | SUPERFLOW          | 2016 | 2017-08-19    | VIN_Decoding  |
      |       15 | Porsche_Canada     | English-Canada | PORS0132 | pcqaauto | ******   |         | WP0AD2A99HS166177 |                 |              | TURBO S            | 2017 | 2017-09-05    | VIN_Decoding  |
      |       16 | Bentley_Canada     | English-Canada | BENT4013 | bcqaauto | ******   |         | SJAAC2ZV3HC012676 | BENTLEY         | BENTAYGA W12 | BASE               | 2017 | 2016-12-01    | VIN_Decoding  |
      |       17 | Lamborghini_Canada | English-Canada | LAMB6703 | lcqaauto | ******   |         | ZHWUF3ZD6GLA04855 | LAMBORGHINI     | AVENTADOR    | LP 750-4 SV        | 2016 | 2016-12-01    | VIN_Decoding  |
      |       18 | BMW_MINI           | English-Canada | BMC06170 | bmqaauto | ******   |         | WBA1F9C56GV509255 |                 |              |                    |      | 2017-12-01    | VIN_Decoding  |
      |       19 | BMW_MINI           | English-Canada | MNC09130 | miqaauto | ******   |         | WBA1F9C56GV509201 |                 |              |                    |      | 2017-03-01    | VIN_Decoding  |
      |       20 | Motorrad           | English-Canada | MTC09220 | moqaauto | ******   |         | WB1013201EZZ88224 |                 |              |                    |      |               | VIN_Decoding  |

  @Smoke_SaveContract_US_Portal
  Scenario Outline: Add a New Contract
    Given Go to url with data as "<TestCase>" and "<Portal>" and "<Language>"and "<Dealer>"
    And Login as "<UserName>" and "<Password>" and "<Captcha>"
    When Click on add New eContract
    And Decode the VIN "<Vin>"
    And Enter contract purchase information "<Vin>" and "<Trim>" and "<Inservicedate>" and "<ContractPurchaseDate>" and "<Vehicle_Purchase>" and "<Vehicle_Purchase_Date>" and "<Vehicle_condtion>" and "<FinanceType>" and "<odometer>" and "<Province>"
    And Select product and get rates "<SelectProduct>" and "<BundleSelection>" and "<Plan>" and "<Term>" and "<TermMiles>" and "<Deductible>" and "<RetailPrice>" and "<DealerCost>" and "<FirstServiceInterval>" and "<FinalServiceInterval>" and "<RegistrationCode>"
    And Verify Dealer Cost and Retail Price "<DealerCost>" and "<RetailPrice>"
    And Enter customer details "<isThisaBussiness>" and "<customerAgreementLanguage>" and "<BussinessName>" and "<FirstName>" and "<LastName>" and "<Address>" and "<PostalCode>" and "<PhoneNumber1>" and "<EmailAddress>" and "<Co-Signer>" and "<cos-First Name>" and "<cos-Last Name>" and "<cos-Address>" and "<cos-Postal Code>" and "<cos-Phone Number 1>" and "<cos-Email Address>" and "<SelectProduct>"
    And Enter vehicle purchase price and finance info "<SelectProduct>" and "<VehicleMSRP>" and "<FinanceAmount>" and  "<APR>" and "<GrossCapCost>" and "<Vehicleprice>"
    And Select Lienholder "<Lienholder>" and "<SelectProduct>"
    #And Save the contract
    #And Go to the summary page
    Then Logout out from the portal

    Examples: 
      | TestCase | Portal         | Language | Dealer   | UserName | Password | Captcha | Vin               | Make       | Model            | Trim              | Year | Inservicedate | ContractPurchaseDate | Vehicle_Purchase | Vehicle_Purchase_Date | Vehicle_condtion | FinanceType | odometer | SelectProduct                 | BundleSelection | Plan                                | Term | TermMiles | Deductible | FirstServiceInterval | FinalServiceInterval | RegistrationCode | DealerCost | RetailPrice | isThisaBussiness | BussinessName | FirstName | LastName     | Address    | PostalCode | PhoneNumber1 | EmailAddress  | Co-Signer | cos-FirstName | cos-LastName | cos-Address | cos-PostalCode | cos-PhoneNumber1 | cos-EmailAddress | VehicleMSRP | FinanceAmount | APR | GrossCapCost | Vehicleprice | Lienholder |  |
      |       10 | Volkswagen_VCI |          | VW422530 | vwqaauto | ******   |         | 3VW4T7AJ2EM309633 | VOLKSWAGEN | JETTA            | GLI AUTOBAHN PZEV | 2014 | 01-01-2020    | 04-10-2020           | Yes              | 06-24-2019            | CPO              | FINANCE     |    40557 | VW DRIVE EASY CPO VSC PROTECT |                 | PLATINUM COVERAGE - OUT OF WARRANTY |   48 |     60000 |         50 |                      |                      |                  |       1650 |         967 | No               |               | TESTQA010 | TESTRASQA010 | 123 STREET |      30328 |   9999999999 | test@test.com | No        |               |              |             |                |                  |                  |       20000 |         15000 | 0.5 |        10000 |        25000 |            |  |
      |       11 | Audi_VCI       |          | AU422A03 | auqaauto | ******   |         | 3VW5DAAT1KM500534 | VOLKSWAGEN | BEETLE UNLIMITED | 2.0T S            | 2019 | 01-01-2020    | 04-10-2020           | Yes              | 06-24-2019            | Pre-Owned        | FINANCE     |    29480 | QP VEHICLE SERVICE PROTECTION |                 | PLATINUM COVERAGE                   |   72 |     85000 |        250 |                      |                      |                  |       1275 |        1351 | No               |               | TESTqa011 | TESTqa011    | 123 STREET |      30328 |   9999999999 | test@test.com | No        |               |              |             |                |                  |                  |       20000 |         15000 | 0.5 |        10000 |        25000 |            |  |
