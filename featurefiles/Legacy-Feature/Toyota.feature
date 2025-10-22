Feature: To Test Toyota Functionality

  @LegacyToyotaSaveContract
  Scenario Outline: Save Contract
    Given Go to Toyota Url as "<Portal>" and "<UserName>" and "<Password>" and "<Dealer>" and "<Product>" and "<Coverage>" and "<Term>" and "<FirstName>" and "<LastName>" and "<MailingAddress>" and "<City>" and "<State>" and "<ZIP>" and "<PhoneNo>" and "<VinNo>" and "<Odometer>" and "<VechicleType>" and "<FinanceType>" and "<LineHolderName>" and "<AgreementPurchasePrice>" and "<ExpectedDealerCost>" and "<RowNo>"
    And Click on Toyota Log in Link
    And Login with Toyota UserName and Password
    And Click on Toyota Agreement Entry Tab
    When Fill Toyota Product Selection Form
    And Fill Toyota E-Contract Form
    And Save the Toyota E-Contract
    #And Verify Toyota Dealer Cost From Web
    Then Log Out From Toyota Portal

    Examples: 
      | RowNo | Portal | UserName  | Password | Dealer   | Product                                                 | Coverage                  | Term | FirstName    | LastName     | MailingAddress | City      | State | ZIP   | PhoneNo    | VinNo             | Odometer | VechicleType | FinanceType | LineHolderName | AgreementPurchasePrice | ExpectedDealerCost |
      | TC1  | TOYOTA | TOY060021 | tlc1234 | TOY06002 | TFS T&W Protection with Cosmetic & Motor Club           | Platinum               | 12 | TESTRV01 | TESTRV01 | TEST@TEST.COM | TEST   | CT |  6001 | 9876543210 | 2T1BURHE5GC627522 | 1001 | NEW  | Cash    | TEST1  | 1000 | $260.00   |
      | TC2  | TOYOTA | TOY060151 | tlc1234 | TOY06015 | TFS T&W Protection with Cosmetic & Motor Club           | Platinum With Key      | 24 | TESTRV02 | TESTRV02 | TEST@TEST.COM | TEST   | CT |  6001 | 9876543210 | 3TMLU4EN7CM085661 | 1001 | USED | Finance | TEST2  | 1000 | $570.00   |
      | TC3  | TOYOTA | TOY060221 | tlc1234 | TOY06022 | TFS T&W Protection with Cosmetic & Motor Club           | Platinum Plus          | 36 | TESTRV03 | TESTRV03 | TEST@TEST.COM | TEST   | CT |  6001 | 9876543210 | 2T3BFREV8FW236447 | 1001 | DEMO | Lease   | TEST3  | 1000 | $535.00   |
      | TC4  | TOYOTA | TOY060251 | tlc1234 | TOY06025 | TFS T&W Protection with Cosmetic & Motor Club           | Platinum Plus With Key | 48 | TESTRV04 | TESTRV04 | TEST@TEST.COM | TEST   | CT |  6001 | 9876543210 | 4T1BF1FK3GU570997 | 1001 | NEW  | Cash    | TEST4  | 1000 | $775.00   |
      | TC5  | TOYOTA | TOY060261 | tlc1234 | TOY06026 | TFS T&W Protection with Cosmetic & Motor Club           | Platinum               | 60 | TESTRV05 | TESTRV05 | TEST@TEST.COM | TEST   | CT |  6001 | 9876543210 | 5TDJGRFHXJS051828 | 1001 | USED | Finance | TEST5  | 1000 | $675.00   |
      | TC6  | TOYOTA | TOY060291 | tlc1234 | TOY06029 | TFS T&W Protection with Cosmetic & Motor Club           | Platinum With Key      | 72 | TESTRV06 | TESTRV06 | TEST@TEST.COM | TEST   | CT |  6001 | 9876543210 | 4T1B11HK8JU148579 | 1001 | DEMO | Lease   | TEST6  | 1000 | $235.00   |
      | TC7  | TOYOTA | TOY060321 | tlc1234 | TOY06032 | TFS T&W Protection with Cosmetic & Motor Club           | Platinum Plus          | 12 | TESTRV07 | TESTRV07 | TEST@TEST.COM | TEST   | CT |  6001 | 9876543210 | 4T1B11HK4JU625489 | 1001 | NEW  | Cash    | TEST7  | 1000 | $750.00   |
      | TC8  | TOYOTA | TOY060361 | tlc1234 | TOY06036 | TFS T&W Protection with Cosmetic & Motor Club           | Platinum Plus With Key | 24 | TESTRV08 | TESTRV08 | TEST@TEST.COM | TEST   | CT |  6001 | 9876543210 | JTMDJREV9GD053161 | 1001 | USED | Finance | TEST8  | 1000 | $510.00   |
      | TC9  | TOYOTA | TOY060371 | tlc1234 | TOY06037 | TFS T&W Protection with Cosmetic & Motor Club           | Platinum               | 36 | TESTRV09 | TESTRV09 | TEST@TEST.COM | TEST   | CT |  6001 | 9876543210 | JTDKN3DU0E1765638 | 1001 | DEMO | Lease   | TEST9  | 1000 | $860.00   |
      | TC10 | TOYOTA | TOY060401 | tlc1234 | TOY06040 | TFS T&W Protection with Cosmetic & Motor Club           | Platinum With Key      | 48 | TESTRV10 | TESTRV10 | TEST@TEST.COM | TEST   | CT |  6001 | 9876543210 | 4T1B61HK0KU175021 | 1001 | NEW  | Cash    | TEST10 | 1000 | $1,120.00 |
      | TC11 | TOYOTA | TOY060421 | tlc1234 | TOY06042 | TFS T&W Protection with Cosmetic & Motor Club           | Platinum Plus          | 60 | TESTRV11 | TESTRV11 | TEST@TEST.COM | TEST   | CT |  6001 | 9876543210 | 4T1B11HK9KU213117 | 1001 | USED | Finance | TEST11 | 1000 | $275.00   |
      | TC12 | TOYOTA | TOY060431 | tlc1234 | TOY06043 | TFS T&W Protection with Cosmetic & Motor Club           | Platinum Plus With Key | 72 | TESTRV12 | TESTRV12 | TEST@TEST.COM | TEST   | CT |  6001 | 9876543210 | 4T1BF1FK2HU619690 | 1001 | DEMO | Lease   | TEST12 | 1000 | $330.00   |
      | TC13 | TOYOTA | TOY060451 | tlc1234 | TOY06045 | TFS T&W Protection with Cosmetic & Motor Club           | Platinum               | 12 | TESTRV13 | TESTRV13 | TEST@TEST.COM | TEST   | CT |  6001 | 9876543210 | JTMDFREV4JJ236428 | 1001 | NEW  | Cash    | TEST13 | 1000 | $560.00   |
      | TC14 | TOYOTA | TOY060471 | tlc1234 | TOY06047 | TFS T&W Protection with Cosmetic & Motor Club           | Platinum With Key      | 24 | TESTRV14 | TESTRV14 | TEST@TEST.COM | TEST   | CT |  6001 | 9876543210 | 4T1BF1FK9FU114999 | 1001 | USED | Finance | TEST14 | 1000 | $760.00   |
      | TC15 | TOYOTA | TOY060491 | tlc1234 | TOY06049 | TFS T&W Protection with Cosmetic & Motor Club           | Platinum Plus          | 36 | TESTRV15 | TESTRV15 | TEST@TEST.COM | TEST   | CT |  6001 | 9876543210 | 5TFUX4EN0CX012671 | 1001 | DEMO | Lease   | TEST15 | 1000 | $380.00   |
      | TC16 | TOYOTA | TOY060501 | tlc1234 | TOY06050 | TFS T&W Protection with Cosmetic & Motor Club           | Platinum Plus With Key | 48 | TESTRV16 | TESTRV16 | TEST@TEST.COM | TEST   | CT |  6001 | 9876543210 | 5TDKK3DC2ES520228 | 1001 | NEW  | Cash    | TEST16 | 1000 | $490.00   |
      | TC17 | TOYOTA | TOY060511 | tlc1234 | TOY06051 | TFS T&W Protection with Cosmetic & Motor Club           | Platinum               | 60 | TESTRV17 | TESTRV17 | TEST@TEST.COM | TEST   | CT |  6001 | 9876543210 | 5TDKZ3DCXKS990031 | 1001 | USED | Finance | TEST17 | 1000 | $1,060.00 |
      | TC18 | TOYOTA | TOY060521 | tlc1234 | TOY06052 | TFS T&W Protection with Cosmetic & Motor Club           | Platinum With Key      | 72 | TESTRV18 | TESTRV18 | TEST@TEST.COM | TEST   | CT |  6001 | 9876543210 | 5YFBURHE5EP079003 | 1001 | DEMO | Lease   | TEST18 |  860 | $260.00   |
      | TC19 | TOYOTA | TOY060531 | tlc1234 | TOY06053 | TFS Tire & Wheel protection service & Motor Club        | Platinum Plus          | 12 | TESTRV19 | TESTRV19 | TEST@TEST.COM | TEST   | CT |  6001 | 9876543210 | 2T1BURHE7GC718940 | 1000 | NEW  | Cash    | TEST19 | 1235 | $335.00   |
      | TC20 | TOYOTA | TOY060021 | tlc1234 | TOY06002 | TFS Key Replacement Protection Motor Club               | KEY REPLACEMENT        | 24 | TESTRV20 | TESTRV20 | TEST@TEST.COM | TEST   | CT |  6001 | 9876543210 | 3TMBZ5DN6GM004983 | 1000 | USED | Finance | TEST20 | 1145 | $245.00   |
      | TC21 | TOYOTA | TOY060151 | tlc1234 | TOY06015 | TFS Key Replacement Protection Motor Club               | KEY REPLACEMENT        | 36 | TESTRV21 | TESTRV21 | TEST@TEST.COM | TEST   | CT |  6001 | 9876543210 | JTMDJREV9JD199227 | 1000 | DEMO | Lease   | TEST21 | 1000 | $325.00   |
      | TC22 | TOYOTA | TOY060221 | tlc1234 | TOY06022 | TFS Key Replacement Protection Motor Club               | KEY REPLACEMENT        | 48 | TESTRV22 | TESTRV22 | TEST@TEST.COM | TEST   | CT |  6001 | 9876543210 | JTMJFREV1JJ727946 | 1000 | NEW  | Cash    | TEST22 | 1000 | $245.00   |
      | TC23 | TOYOTA | TOY060291 | tlc1234 | TOY06029 | TFS Key Replacement Protection Motor Club               | KEY REPLACEMENT        | 60 | TESTRV23 | TESTRV23 | TEST@TEST.COM | TEST   | CT |  6001 | 9876543210 | JTEBT17R370067871 | 1000 | USED | Finance | TEST23 | 1000 | $215.00   |
      | TC24 | TOYOTA | TOY060321 | tlc1234 | TOY06032 | TFS Key Replacement Protection Motor Club               | KEY REPLACEMENT        | 72 | TESTRV24 | TESTRV24 | TEST@TEST.COM | TEST   | CT |  6001 | 9876543210 | 5TDJZ3DC2HS182468 | 1000 | DEMO | Lease   | TEST24 | 1200 | $1,120.00 |
      | TC25 | TOYOTA | TOY060371 | tlc1234 | TOY06037 | TFS Key Replacement Protection Motor Club               | KEY REPLACEMENT        | 12 | TESTRV25 | TESTRV25 | TEST@TEST.COM | TEST   | CT |  6001 | 9876543210 | JTDKARFU3K3089519 | 1000 | NEW  | Cash    | TEST25 | 1170 | $570.00   |
      | TC26 | TOYOTA | TOY060401 | tlc1234 | TOY06040 | TFS Key Replacement Protection Motor Club               | KEY REPLACEMENT        | 24 | TESTRV26 | TESTRV26 | TEST@TEST.COM | TEST   | CT |  6001 | 9876543210 | 4T1BF1FK1GU608310 | 1000 | USED | Finance | TEST26 | 1000 | $235.00   |
      | TC27 | TOYOTA | TOY060421 | tlc1234 | TOY06042 | TFS Key Replacement Protection Motor Club               | KEY REPLACEMENT        | 36 | TESTRV27 | TESTRV27 | TEST@TEST.COM | TEST   | CT |  6001 | 9876543210 | JTMZFREV1GJ088303 | 1000 | DEMO | Lease   | TEST27 |  760 | $260.00   |
      | TC28 | TOYOTA | TOY060431 | tlc1234 | TOY06043 | TFS Key Replacement Protection Motor Club               | KEY REPLACEMENT        | 48 | TESTRV28 | TESTRV28 | TEST@TEST.COM | TEST   | CT |  6001 | 9876543210 | 5TDJKRFH8GS295243 | 1000 | NEW  | Cash    | TEST28 | 1170 | $570.00   |
      | TC29 | TOYOTA | TOY060471 | tlc1234 | TOY06047 | TFS Key Replacement Protection Motor Club               | KEY REPLACEMENT        | 60 | TESTRV29 | TESTRV29 | TEST@TEST.COM | TEST   | CT |  6001 | 9876543210 | JTMWFREV1FD068360 | 1000 | USED | Finance | TEST29 |  600 | $535.00   |
      | TC30 | TOYOTA | TOY060491 | tlc1234 | TOY06049 | TFS Key Replacement Protection Motor Club               | KEY REPLACEMENT        | 72 | TESTRV30 | TESTRV30 | TEST@TEST.COM | TEST   | CT |  6001 | 9876543210 | JTDZN3EUXGJ044971 | 1000 | DEMO | Lease   | TEST30 | 1575 | $775.00   |
      | TC31 | TOYOTA | TOY060501 | tlc1234 | TOY06050 | TFS Key Replacement Protection Motor Club               | KEY REPLACEMENT        | 12 | TESTRV31 | TESTRV31 | TEST@TEST.COM | TEST   | CT |  6001 | 9876543210 | 2T3J1RFV2KW006003 | 1000 | NEW  | Cash    | TEST31 |  700 | $675.00   |
      | TC32 | TOYOTA | TOY060511 | tlc1234 | TOY06051 | TFS Key Replacement Protection Motor Club               | KEY REPLACEMENT        | 24 | TESTRV32 | TESTRV32 | TEST@TEST.COM | TEST   | CT |  6001 | 9876543210 | JF1ZNAA11G9709537 | 1000 | USED | Finance | TEST32 | 1000 | $235.00   |
      | TC33 | TOYOTA | TOY060521 | tlc1234 | TOY06052 | TFS Key Replacement Protection Motor Club               | KEY REPLACEMENT        | 36 | TESTRV33 | TESTRV33 | TEST@TEST.COM | TEST   | CT |  6001 | 9876543210 | 2T3RFREV6JW787340 | 1000 | DEMO | Lease   | TEST33 | 1000 | $750.00   |
      | TC34 | LEXUS  | LEX606011 | tlc1234 | LEX60601 | LFS T&W Protection with Cosmetic & Motor Club           | Platinum               | 48 | TESTRV34 | TESTRV34 | TEST@TEST.COM | TEST   | CT |  6001 | 9876543210 | JTJYARBZ8G2037776 | 1000 | NEW  | Cash    | TEST34 |  910 | $510.00   |
      | TC35 | LEXUS  | LEX606021 | tlc1234 | LEX60602 | LFS T&W Protection with Cosmetic & Motor Club           | Platinum With Key      | 60 | TESTRV35 | TESTRV35 | TEST@TEST.COM | TEST   | CT |  6001 | 9876543210 | JTHBE1D26E5009497 | 1000 | USED | Finance | TEST35 | 1000 | $860.00   |
      | TC36 | LEXUS  | LEX606051 | tlc1234 | LEX60605 | LFS T&W Protection with Cosmetic & Motor Club           | Platinum Plus          | 72 | TESTRV36 | TESTRV36 | TEST@TEST.COM | TEST   | CT |  6001 | 9876543210 | JTJYARBZ6F2007660 | 1000 | DEMO | Lease   | TEST36 | 1200 | $1,120.00 |
      | TC37 | LEXUS  | LEX606061 | tlc1234 | LEX60606 | LFS T&W Protection with Cosmetic & Motor Club           | Platinum Plus With Key | 12 | TESTRV37 | TESTRV37 | TEST@TEST.COM | TEST   | CT |  6001 | 9876543210 | JTHCE1BL8E5028083 | 1000 | NEW  | Cash    | TEST37 |  600 | $535.00   |
      | TC38 | LEXUS  | LEX606011 | tlc1234 | LEX60601 | LFS Key Replacement Protection Motor Club               | KEY REPLACEMENT        | 24 | TESTRV38 | TESTRV38 | TEST@TEST.COM | TEST   | CT |  6001 | 9876543210 | 2T2ZK1BA4DC098373 | 1000 | USED | Finance | TEST38 |  760 | $260.00   |
      | TC39 | LEXUS  | LEX606021 | tlc1234 | LEX60602 | LFS Key Replacement Protection Motor Club               | KEY REPLACEMENT        | 36 | TESTRV39 | TESTRV39 | TEST@TEST.COM | TEST   | CT |  6001 | 9876543210 | 2T2BK1BA1FC313650 | 1000 | DEMO | Lease   | TEST39 | 1170 | $570.00   |
      | TC40 | LEXUS  | LEX606051 | tlc1234 | LEX60605 | LFS Key Replacement Protection Motor Club               | KEY REPLACEMENT        | 48 | TESTRV40 | TESTRV40 | TEST@TEST.COM | TEST   | CT |  6001 | 9876543210 | 58ABZ1B10KU032697 | 1000 | NEW  | Cash    | TEST40 |  600 | $535.00   |
      | TC41 | LEXUS  | LEX606061 | tlc1234 | LEX60606 | LFS Key Replacement Protection Motor Club               | KEY REPLACEMENT        | 60 | TESTRV41 | TESTRV41 | TEST@TEST.COM | TEST   | CT |  6001 | 9876543210 | 2T2ZK1BA3FC202970 | 1000 | USED | Finance | TEST41 | 1575 | $775.00   |
      | TC42 | CCC    | CCC068981 | tlc1234 | CCC06898 | CCC T&W Protection with Cosmetic & Motor Club           | Platinum               | 72 | TESTRV42 | TESTRV42 | TEST@TEST.COM | TEST   | CT |  6001 | 9876543210 | JTDKN3DU0E1765638 | 1000 | DEMO | Lease   | TEST42 |  700 | $675.00   |
      | TC42 | CCC    | CCC069541 | tlc1234 | CCC06954 | CCC T&W Protection with Cosmetic & Motor Club           | Platinum With Key      | 12 | TESTRV43 | TESTRV43 | TEST@TEST.COM | TEST   | CT |  6001 | 9876543210 | 4T1B61HK0KU175021 | 1000 | NEW  | Cash    | TEST43 | 1000 | $235.00   |
      | TC43 | CCC    | CCC069011 | tlc1234 | CCC06901 | CCC T&W Protection with Cosmetic & Motor Club           | Platinum Plus          | 24 | TESTRV44 | TESTRV44 | TEST@TEST.COM | TEST   | CT |  6001 | 9876543210 | 4T1B11HK9KU213117 | 1000 | USED | Finance | TEST44 | 1000 | $750.00   |
      | TC44 | TOYOTA | TOY060261 | tlc1234 | TOY06026 | TFS T&W Protection with Cosmetic & Motor Club           | Platinum               | 60 | TEST02   | TEST02   | TEST02        | TEST02 | CT |  6001 | 9876543210 | 5TDJGRFHXJS051528 | 1001 | USED | Finance | TEST02 | 1000 | $255.00   |
      | TC45 | TOYOTA | TOY060521 | tlc1234 | TOY06052 | TFS T&W Protection with Cosmetic & Motor Club           | Platinum With Key      | 72 | TEST04   | TEST04   | TEST04        | TEST04 | CT |  6001 | 9876543210 | 5YFBURHE5EP079503 | 1001 | DEMO | Lease   | TEST04 |  860 | $475.00   |
      | TC46 | CCC    | CCC315021 | tlc1234 | CCC31502 | CCC T&W Protection with Cosmetic KEY                    | Platinum               | 24 | TEST09   | TEST09   | TEST09        | TEST09 | NY | 10001 | 9898989898 | JTHGL1EF7A5047517 | 1000 | USED | Cash    | TEST09 | 1200 | $1,120.00 |
      | TC47 | TOYOTA | TOY040071 | tlc1234 | TOY04007 | TFS Tire Wheel & Key Protection Non-Cosmetic            | Platinum Plus With Key | 12 | TEST10   | TEST10   | TEST10        | TEST10 | MO | 11111 | 9898989898 | 2T3WFREV1GW258512 | 1000 | New  | Cash    | TEST10 | 1000 | $275.00   |
      | TC48 | LEXUS  | LEX604211 | tlc1234 | LEX60421 | LFS T&W & Key Protection Non-Cosmetic                   | Platinum Plus With Key | 24 | TEST11   | TEST11   | TEST11        | TEST11 | CA | 11111 | 9898989898 | YV4612RKXG2783523 | 1000 | NEW  | Finance | TEST11 | 1000 | $330.00   |
      | TC49 | CCC    | CCC308571 | tlc1234 | CCC30857 | CCC T&W Protection with Cosmetic KEY                    | Platinum Plus With Key | 36 | TEST12   | TEST12   | TEST12        | TEST12 | OH | 11111 | 9898989898 | JTJBARBZ1G2069534 | 1000 | NEW  | Cash    | TEST12 | 1000 | $560.00   |
      | TC50 | LEXUS  | LEX646301 | tlc1234 | LEX64630 | Platinum Plus with Key_Cosmetic For WA                  | Platinum Plus          | 12 | TEST20   | TEST20   | TEST20        | TEST20 | WA | 11111 | 9898989898 | JTHBE1D2XE5004541 | 1000 | DEMO | Finance | TEST20 | 1000 | $380.00   |
      | TC51 | TOYOTA | TOY240761 | tlc1234 | TOY24076 | TFS Tire Wheel & Key Protection Non-Cosmetic            | Platinum Plus With Key | 36 | TEST22   | TEST22   | TEST22        | TEST22 | FL | 11111 | 9898989898 | WMWSV3C50DT478516 | 1000 | NEW  | Cash    | TEST22 | 1000 | $1,060.00 |
      | TC52 | LEXUS  | LEX609101 | tlc1234 | LEX60910 | LFS T&W & Key Protection with Cosmetic (TWK Only)       | Platinum               | 48 | TEST23   | TEST23   | TEST23        | TEST23 | FL | 11111 | 9898989898 | KMHHU6KJ2GU135548 | 1000 | DEMO | Finance | TEST23 |  860 | $260.00   |
      | TC53 | CCC    | CCC096591 | tlc1234 | CCC09659 | CCC T&W Protection with Cosmetic KEY (TW with Key only) | Platinum With Key      | 60 | TEST24   | TEST24   | TEST24        | TEST24 | FL | 11111 | 9898989898 | 5FNYF18208B050507 | 1000 | USED | Lease   | TEST24 | 1235 | $335.00   |

  @LegacyToyotaSaveContractAndDecline
  Scenario Outline: Save Contract
    Given Go to Toyota Url as "<Portal>" and "<UserName>" and "<Password>" and "<Dealer>" and "<Product>" and "<Coverage>" and "<Term>" and "<FirstName>" and "<LastName>" and "<MailingAddress>" and "<City>" and "<State>" and "<ZIP>" and "<PhoneNo>" and "<VinNo>" and "<Odometer>" and "<VechicleType>" and "<FinanceType>" and "<LineHolderName>" and "<AgreementPurchasePrice>" and "<ExpectedDealerCost>" and "<RowNo>"
    And Click on Toyota Log in Link
    And Login with Toyota UserName and Password
    And Click on Toyota Agreement Entry Tab
    When Fill Toyota Product Selection Form
    And Fill Toyota E-Contract Form
    And Save the Toyota E-Contract
    And Verify Toyota Dealer Cost From Web
    And Decline Toyota E-Contract From Web
    Then Log Out From Toyota Portal

    Examples: 
      | RowNo | Portal | UserName  | Password | Dealer   | Product                                      | Coverage               | Term | FirstName | LastName | MailingAddress | City     | State | ZIP   | PhoneNo    | VinNo             | Odometer | VechicleType | FinanceType | LineHolderName | AgreementPurchasePrice | ExpectedDealerCost |
      | TC1   | TOYOTA | TOY040071 | tlc1234  | TOY04007 | TFS Tire Wheel & Key Protection Non-Cosmetic | Platinum Plus With Key |   12 | test1     | test1    | testing1       | testing1 | MO    | 11111 | 9898989898 | 2T3WFREV1GW258912 |     1000 | New          | Cash        | Testing1       |                   1000 | $275.00            |
      | TC2   | LEXUS  | LEX604211 | tlc1234  | LEX60421 | LFS T&W & Key Protection Non-Cosmetic        | Platinum Plus With Key |   24 | test2     | test2    | testing2       | testing2 | CA    | 11111 | 9898989898 | YV4612RKXG2783323 |     1000 | NEW          | Finance     | Testing2       |                   1000 | $330.00            |
      | TC3   | CCC    | CCC308571 | tlc1234  | CCC30857 | CCC T&W Protection with Cosmetic KEY         | Platinum Plus With Key |   36 | test3     | test3    | testing3       | testing3 | OH    | 11111 | 9898989898 | JTJBARBZ1G2069534 |     1000 | NEW          | Cash        | Testing3       |                   1000 | $560.00            |

  @LegacyToyotaSaveContractWithDBVerfication
  Scenario Outline: Save Contract
    Given Go to Toyota Url as "<Portal>" and "<UserName>" and "<Password>" and "<Dealer>" and "<Product>" and "<Coverage>" and "<Term>" and "<FirstName>" and "<LastName>" and "<MailingAddress>" and "<City>" and "<State>" and "<ZIP>" and "<PhoneNo>" and "<VinNo>" and "<Odometer>" and "<VechicleType>" and "<FinanceType>" and "<LineHolderName>" and "<AgreementPurchasePrice>" and "<ExpectedDealerCost>" and "<RowNo>"
    And Click on Toyota Log in Link
    And Login with Toyota UserName and Password
    And Click on Toyota Agreement Entry Tab
    When Fill Toyota Product Selection Form
    And Fill Toyota E-Contract Form
    And Save the Toyota E-Contract
   # And Verify Toyota Dealer Cost From Web
    And Verify Toyota Data From Data Base
    Then Log Out From Toyota Portal

    Examples: 
      | RowNo | Portal | UserName  | Password | Dealer   | Product                                       | Coverage               | Term | FirstName   | LastName    | MailingAddress | City | State | ZIP   | PhoneNo    | VinNo             | Odometer | VechicleType | FinanceType | LineHolderName | AgreementPurchasePrice | ExpectedDealerCost |
      | TC1   | TOYOTA | TOY060021 | tlc1234  | TOY06002 | TFS T&W Protection with Cosmetic & Motor Club | Platinum               |   12 | TESTABTFS01 | TESTABTFS01 | TEST@TEST.COM  | TEST | CT    |  6001 | 9876543210 | 2T1BURHE5GC627522 |     1001 | NEW          | Cash        | TEST1          |                   1000 | $175.00            |
      | TC2   | TOYOTA | TOY060261 | tlc1234  | TOY06026 | TFS T&W Protection with Cosmetic & Motor Club | Platinum               |   60 | TESTABTFS02 | TESTABTFS05 | TEST@TEST.COM  | TEST | CT    |  6001 | 9876543210 | 5TDJGRFHXJS051828 |     1001 | USED         | Finance     | TEST5          |                   1000 | $255.00            |
      | TC3   | TOYOTA | TOY060361 | tlc1234  | TOY06036 | TFS T&W Protection with Cosmetic & Motor Club | Platinum Plus With Key |   24 | TESTABTFS03 | TESTABTFS08 | TEST@TEST.COM  | TEST | CT    |  6001 | 9876543210 | JTMDJREV9GD053161 |     1001 | USED         | Finance     | TEST8          |                   1000 | $510.00            |
      | TC4   | TOYOTA | TOY060521 | tlc1234  | TOY06052 | TFS T&W Protection with Cosmetic & Motor Club | Platinum With Key      |   72 | TESTABTFS04 | TESTABTFS18 | TEST@TEST.COM  | TEST | CT    |  6001 | 9876543210 | 5YFBURHE5EP079003 |     1001 | DEMO         | Lease       | TEST18         |                    860 | $475.00            |
      | TC5   | TOYOTA | TOY060221 | tlc1234  | TOY06022 | TFS Key Replacement Protection Motor Club     | KEY REPLACEMENT        |   48 | TESTABTFS05 | TESTABTFS22 | TEST@TEST.COM  | TEST | CT    |  6001 | 9876543210 | JTMJFREV1JJ727946 |     1000 | NEW          | Cash        | TEST22         |                   1000 | $510.00            |
      | TC6   | TOYOTA | TOY060521 | tlc1234  | TOY06052 | TFS Key Replacement Protection Motor Club     | KEY REPLACEMENT        |   36 | TESTABTFS06 | TESTABTFS33 | TEST@TEST.COM  | TEST | CT    |  6001 | 9876543210 | 2T3RFREV6JW787340 |     1000 | DEMO         | Lease       | TEST33         |                   1000 | $475.00            |
      | TC7   | LEXUS  | LEX606011 | tlc1234  | LEX60601 | LFS T&W Protection with Cosmetic & Motor Club | Platinum               |   48 | TESTABTFS07 | TESTABTFS34 | TEST@TEST.COM  | TEST | CT    |  6001 | 9876543210 | JTJYARBZ8G2037776 |     1000 | NEW          | Cash        | TEST34         |                    910 | $160.00            |
      | TC8   | LEXUS  | LEX606011 | tlc1234  | LEX60601 | LFS Key Replacement Protection Motor Club     | KEY REPLACEMENT        |   24 | TESTABTFS08 | TESTABTFS38 | TEST@TEST.COM  | TEST | CT    |  6001 | 9876543210 | 2T2ZK1BA4DC098373 |     1000 | USED         | Finance     | TEST38         |                    760 | $160.00            |
      | TC9   | CCC    | CCC315021 | tlc1234  | CCC31502 | CCC T&W Protection with Cosmetic KEY          | Platinum               |   24 | TESTABTFS09 | TESTABTFS09 | TEST@TEST.COM  | TEST | NY    | 10001 | 9898989898 | JTHGL1EF7A5047717 |     1000 | USED         | Cash        | TEST1          |                   1200 | $1,120.00          |

  @LegacyToyotaSaveContractAndDeclineWithDBVerfication
  Scenario Outline: Save Contract
    Given Go to Toyota Url as "<Portal>" and "<UserName>" and "<Password>" and "<Dealer>" and "<Product>" and "<Coverage>" and "<Term>" and "<FirstName>" and "<LastName>" and "<MailingAddress>" and "<City>" and "<State>" and "<ZIP>" and "<PhoneNo>" and "<VinNo>" and "<Odometer>" and "<VechicleType>" and "<FinanceType>" and "<LineHolderName>" and "<AgreementPurchasePrice>" and "<ExpectedDealerCost>" and "<RowNo>"
    And Click on Toyota Log in Link
    And Login with Toyota UserName and Password
    And Click on Toyota Agreement Entry Tab
    When Fill Toyota Product Selection Form
    And Fill Toyota E-Contract Form
    And Save the Toyota E-Contract
    #And Verify Toyota Dealer Cost From Web
    And Verify Toyota Data From Data Base
    And Decline Toyota E-Contract From Web
    Then Log Out From Toyota Portal

    Examples: 
      | RowNo | Portal | UserName  | Password | Dealer   | Product                                      | Coverage               | Term | FirstName | LastName | MailingAddress | City     | State | ZIP   | PhoneNo    | VinNo             | Odometer | VechicleType | FinanceType | LineHolderName | AgreementPurchasePrice | ExpectedDealerCost |
      | TC1   | TOYOTA | TOY040071 | tlc1234  | TOY04007 | TFS Tire Wheel & Key Protection Non-Cosmetic | Platinum Plus With Key |   12 | test1     | test1    | testing1       | testing1 | MO    | 11111 | 9898989898 | 2T3WFREV1GW258912 |     1000 | New          | Cash        | Testing1       |                   1000 | $275.00            |
      | TC2   | LEXUS  | LEX604211 | tlc1234  | LEX60421 | LFS T&W & Key Protection Non-Cosmetic        | Platinum Plus With Key |   24 | test2     | test2    | testing2       | testing2 | CA    | 11111 | 9898989898 | YV4612RKXG2783323 |     1000 | NEW          | Finance     | Testing2       |                   1000 | $330.00            |
      | TC3   | CCC    | CCC308571 | tlc1234  | CCC30857 | CCC T&W Protection with Cosmetic KEY         | Platinum Plus With Key |   36 | test3     | test3    | testing3       | testing3 | OH    | 11111 | 9898989898 | JTJBARBZ1G2069534 |     1000 | NEW          | Cash        | Testing3       |                   1000 | $560.00            |

  @LegacyToyotaSubmitContract
  Scenario Outline: Submit Contract
    Given Go to Toyota Url as "<Portal>" and "<UserName>" and "<Password>" and "<Dealer>" and "<Product>" and "<Coverage>" and "<Term>" and "<FirstName>" and "<LastName>" and "<MailingAddress>" and "<City>" and "<State>" and "<ZIP>" and "<PhoneNo>" and "<VinNo>" and "<Odometer>" and "<VechicleType>" and "<FinanceType>" and "<LineHolderName>" and "<AgreementPurchasePrice>" and "<ExpectedDealerCost>" and "<RowNo>"
    And Click on Toyota Log in Link
    And Login with Toyota UserName and Password
    And Click on Toyota Agreement Entry Tab
    When Fill Toyota Product Selection Form
    And Fill Toyota E-Contract Form
    And Save the Toyota E-Contract
    #And Verify Toyota Dealer Cost From Web
    And Submit E-Contract From Web
    Then Log Out From Toyota Portal

    Examples: 
      | RowNo | Portal | UserName  | Password | Dealer   | Product                                           | Coverage        | Term | FirstName  | LastName   | MailingAddress | City | State | ZIP  | PhoneNo    | VinNo             | Odometer | VechicleType | FinanceType | LineHolderName | AgreementPurchasePrice | ExpectedDealerCost |
      | TC1   | CCC    | CCC298351 | tlc1234  | CCC29835 | CCC Key Replacement Protection                    | KEY REPLACEMENT |   72 | TESTTFS001 | TESTTFS001 | TEST@TEST.COM  | TEST | CT    | 6001 | 9876543210 | 1C6SRFHT1LN408591 |     1001 | NEW          | Cash        | TEST1          |                   1000 | $260.00            |
      #| TC3   | CCC    | CCC298351 | tlc1234  | CCC29835 | CCC Tire & Wheel Protection Non-Cosmetic with Key | Platinum        |   84 | TESTTFS002 | TESTTFS002 | TEST@TEST.COM  | TEST | CT    | 6001 | 9876543210 | WBA8E3G54GNT26194 |     1001 | DEMO         | Lease       | TEST3          |                   1000 | $535.00            |

  #
  # | 2     | TOYOTA | TOY201221 | tlc1234  | TOY20122 | TYPU 1/15 - TFS T&W Protection with Cosmetic          | Platinum Plus (TW, PDR, WS) | 48   | SGIFTEST2  | SGILTEST2  | Testing2       | Testing2  | MA    | 11111 | 9898989898 | JTHCE1BL0D5003385 | 1000     | Demo         | Cash        | Testing2       | 10000                  | $630.00            |
  # | 3     | TOYOTA | TOY310971 | tlc1234  | TOY31097 | TYPU 1/15 - TFS T&W Protection with Cosmetic          | Platinum (TW)               | 24   | SGIFTEST3  | SGILTEST3  | Testing3       | Testing3  | NY    | 11111 | 9898989898 | WBAUC73578VF24396 | 1000     | Demo         | Cash        | Testing3       | 10000                  | $1,530.00          |
  # | 4     | TOYOTA | TOY360891 | tlc1234  | TOY36089 | TYPU 1/15 - TFS T&W Protection with Cosmetic          | Platinum (TW)               | 60   | SGIFTEST4  | SGILTEST4  | Testing4       | Testing4  | WA    | 11111 | 9898989898 | 1G6DP5EV0A0109965 | 1000     | Demo         | Cash        | Testing4       | 10000                  | $420.00            |
  # | 5     | TOYOTA | TOY240761 | tlc1234  | TOY24076 | TYUV 1/15 - TFS T&W Protection Non-Cosmetic           | Platinum Plus (TW, PDR, WS) | 36   | SGIFTEST5  | SGILTEST5  | Testing5       | Testing5  | FL    | 11111 | 9898989898 | WMWSV3C50DT478116 | 1000     | Demo         | Cash        | Testing5       | 10000                  | $950.00            |
  # | 6     | LEXUS  | LEX604481 | tlc1234  | LEX60448 | LXPU 1/15 - LFS T&W Protection with Cosmetic          | Platinum Plus (TW, PDR, WS) | 24   | SGIFTEST6  | SGILTEST6  | Testing6       | Testing6  | CA    | 11111 | 9898989898 | 2G1FB1ED1B9212946 | 1000     | Demo         | Cash        | Testing6       | 10000                  | $240.00            |
  # | 7     | LEXUS  | LEX638021 | tlc1234  | LEX63802 | LXPU 1/15 - LFS T&W Protection with Cosmetic          | Platinum Plus (TW, PDR, WS) | 60   | SGIFTEST7  | SGILTEST7  | Testing7       | Testing7  | MA    | 11111 | 9898989898 | SALME1D47AA310897 | 1000     | Demo         | Cash        | Testing7       | 10000                  | $1,065.00          |
  # | 8     | LEXUS  | LEX629041 | tlc1234  | LEX62904 | LXPU 1/15 - LFS T&W Protection with Cosmetic          | Platinum (TW)               | 36   | SGIFTEST8  | SGILTEST8  | Testing8       | Testing8  | NJ    | 11111 | 9898989898 | 1C3CDFAA0GD577923 | 1000     | Demo         | Cash        | Testing8       | 10000                  | $175.00            |
  # | 9     | LEXUS  | LEX646301 | tlc1234  | LEX64630 | LXPU 1/15 - LFS T&W Protection with Cosmetic          | Platinum Plus (TW, PDR, WS) | 12   | SGIFTEST9  | SGILTEST9  | Testing9       | Testing9  | WA    | 11111 | 9898989898 | JTHBE1D2XE5004741 | 1000     | Demo         | Cash        | Testing9       | 10000                  | $380.00            |
  # | 10    | LEXUS  | LEX609151 | tlc1234  | LEX60915 | LXTW 1/15 - LFS T&W Protection Non-Cosmetic (TW Only) | Platinum (TW)               | 48   | SGIFTEST10 | SGILTEST10 | Testing10      | Testing10 | FL    | 11111 | 9898989898 | WP0AB2A82EK193004 | 1000     | Demo         | Cash        | Testing10      | 18045                  | $1,345.00          |
  # | 11    | CCC    | CCC199511 | tlc1234  | CCC19951 | CCPU 1/15 - CCC T&W Protection with Cosmetic          | Platinum Plus (TW, PDR, WS) | 36   | SGIFTEST11 | SGILTEST11 | Testing11      | Testing11 | OH    | 11111 | 9898989898 | JTHKD5BH8E2182750 | 1000     | Demo         | Cash        | Testing11      | 10000                  | $440.00            |
  # | 12    | CCC    | CCC209261 | tlc1234  | CCC20926 | CCPU 1/15 - CCC T&W Protection with Cosmetic          | Platinum (TW)               | 12   | SGIFTEST12 | SGILTEST12 | Testing12      | Testing12 | MA    | 11111 | 9898989898 | WDDGF4HB0DA857693 | 1000     | Demo         | Cash        | Testing12      | 10000                  | $520.00            |
  # | 13    | CCC    | CCC319091 | tlc1234  | CCC31909 | CCPU 1/15 - CCC T&W Protection with Cosmetic          | Platinum (TW)               | 48   | SGIFTEST13 | SGILTEST13 | Testing13      | Testing13 | CT    | 11111 | 9898989898 | 5J8TB4H36GL023063 | 1000     | Demo         | Cash        | Testing13      | 10000                  | $275.00            |
  # | 14    | CCC    | CCC319091 | tlc1234  | CCC31909 | CCPU 1/15 - CCC T&W Protection with Cosmetic          | Platinum (TW)               | 24   | SGIFTEST14 | SGILTEST14 | Testing14      | Testing14 | WA    | 11111 | 9898989898 | 1G6DW67V490159317 | 1000     | Demo         | Cash        | Testing14      | 10000                  | $760.00            |
  # | 15    | CCC    | CCC159161 | tlc1234  | CCC15916 | CCUV 1/15 - CCC T&W Protection Non-Cosmetic           | Platinum (TW)               | 60   | SGIFTEST15 | SGILTEST15 | Testing15      | Testing15 | FL    | 11111 | 9898989898 | 5FNYF18208B050407 | 1000     | Demo         | Cash        | Testing15      | 10000                  | $175.00            |
  
  @LegacyToyotaSubmitContractWithDBVerification
  Scenario Outline: Submit Contract
    Given Go to Toyota Url as "<Portal>" and "<UserName>" and "<Password>" and "<Dealer>" and "<Product>" and "<Coverage>" and "<Term>" and "<FirstName>" and "<LastName>" and "<MailingAddress>" and "<City>" and "<State>" and "<ZIP>" and "<PhoneNo>" and "<VinNo>" and "<Odometer>" and "<VechicleType>" and "<FinanceType>" and "<LineHolderName>" and "<AgreementPurchasePrice>" and "<ExpectedDealerCost>" and "<RowNo>"
    And Click on Toyota Log in Link
    And Login with Toyota UserName and Password
    And Click on Toyota Agreement Entry Tab
    When Fill Toyota Product Selection Form
    And Fill Toyota E-Contract Form
    And Save the Toyota E-Contract
    #And Verify Toyota Dealer Cost From Web
    And Verify Toyota Data From Data Base
    And Submit Toyota E-Contract From Web
    And Verify Toyota Data From dms_con_m1 Table
    Then Log Out From Toyota Portal

    Examples: 
      | RowNo | Portal | UserName  | Password | Dealer   | Product                                  | Coverage | Term | FirstName  | LastName   | MailingAddress | City | State | ZIP  | PhoneNo    | VinNo             | Odometer | VechicleType | FinanceType | LineHolderName | AgreementPurchasePrice | ExpectedDealerCost |
      | TC3   | CCC    | CCC298351 | tlc1234  | CCC29835 | CCC T&W Protection Non-Cosmetic with Key | Platinum |   84 | TESTTFS002 | TESTTFS002 | TEST@TEST.COM  | TEST | CT    | 6001 | 9876543210 | WBA8E3G54GNT26194 |     1001 | DEMO         | Lease       | TEST3          |                   1000 | $535.00            |

  # |     1 | TOYOTA | TOY240261 | tlc1234  | TOY24026 | TFS Tire Wheel & Key Protection with Cosmetic     | Platinum With Key |   12 | SGIFTEST1  | SGILTEST1  | Testing1       | Testing1 | MO    | 11111 | 9898989898 | 5GAKRBKD1DJ166645 |     1000 | Demo         | Cash        | Testing1       |                  10000 | $185.00            |
  
  @LegacyToyotaVinDecoder
  Scenario Outline: Vin Decoding
    Given Go to Toyota Url for Vin Decoding as "<RowNo>" and "<Portal>" and "<UserName>" and "<Password>" and "<Dealer>" and "<Product>" and "<Coverage>" and "<Term>" and "<FirstName>" and "<LastName>" and "<MailingAddress>" and "<City>" and "<State>" and "<ZIP>" and "<PhoneNo>" and "<VinNo>" and "<Exp_Make>" and "<Exp_Model>" and "<Exp_Year>"
    And Click on Toyota Log in Link for Vin Decoding
    And Login with Toyota UserName and Password for Vin Decoding
    And Click on Toyota Agreement Entry Tab for Vin Decoding
    When Fill Toyota Product Selection Form for Vin Decoding
    And Fill Toyota E-Contract Form for Vin Decoding
    And Verify Toyota Make Model and Year for Vin Decoding
    Then Log Out From Toyota Portal for Vin Decoding

    Examples: 
      | RowNo | Portal | UserName  | Password | Dealer   | Product                                       | Coverage          | Term | FirstName | LastName  | MailingAddress | City     | State | ZIP   | PhoneNo    | VinNo             | Exp_Make | Exp_Model | Exp_Year |
      |     1 | TOYOTA | TOY240261 | tlc1234  | TOY20143 | TFS Tire Wheel & Key Protection with Cosmetic | Platinum With Key |   12 | SGIFTEST1 | SGILTEST1 | Testing1       | Testing1 | MO    | 11111 | 9898989898 | JTHBZ1BLXGA004491 | BUICK    | ENCLAVE   |     2013 |

  #
  #| 2     | TOYOTA | TOY201221 | tlc1234  | TOY20122 | TYPU 1/15 - TFS T&W Protection with Cosmetic          | Platinum Plus (TW, PDR, WS) | 48   | SGIFTEST2  | SGILTEST2  | Testing2       | Testing2  | MA    | 11111 | 9898989898 | JTHCE1BL0D5003385 | LEXUS         | GS 350      | 2013     |
  #| 3     | TOYOTA | TOY310971 | tlc1234  | TOY31097 | TYPU 1/15 - TFS T&W Protection with Cosmetic          | Platinum (TW)               | 24   | SGIFTEST3  | SGILTEST3  | Testing3       | Testing3  | NY    | 11111 | 9898989898 | WBAUC73578VF24396 | BMW           | 1 SERIES    | 2008     |
  #| 4     | TOYOTA | TOY360891 | tlc1234  | TOY36089 | TYPU 1/15 - TFS T&W Protection with Cosmetic          | Platinum (TW)               | 60   | SGIFTEST4  | SGILTEST4  | Testing4       | Testing4  | WA    | 11111 | 9898989898 | 1G6DP5EV0A0109965 | CADILLAC      | CTS         | 2010     |
  #| 5     | TOYOTA | TOY240761 | tlc1234  | TOY24076 | TYUV 1/15 - TFS T&W Protection Non-Cosmetic           | Platinum Plus (TW, PDR, WS) | 36   | SGIFTEST5  | SGILTEST5  | Testing5       | Testing5  | FL    | 11111 | 9898989898 | WMWSV3C50DT478116 | MNNI          | COOPER      | 2013     |
  #| 6     | LEXUS  | LEX604481 | tlc1234  | LEX60448 | LXPU 1/15 - LFS T&W Protection with Cosmetic          | Platinum Plus (TW, PDR, WS) | 24   | SGIFTEST6  | SGILTEST6  | Testing6       | Testing6  | CA    | 11111 | 9898989898 | 2G1FB1ED1B9212946 | CHEVROLET     | CAMARO      | 2011     |
  #| 7     | LEXUS  | LEX638021 | tlc1234  | LEX63802 | LXPU 1/15 - LFS T&W Protection with Cosmetic          | Platinum Plus (TW, PDR, WS) | 60   | SGIFTEST7  | SGILTEST7  | Testing7       | Testing7  | MA    | 11111 | 9898989898 | SALME1D47AA310897 | LAND ROVER    | RANGE ROVER | 2010     |
  #| 8     | LEXUS  | LEX629041 | tlc1234  | LEX62904 | LXPU 1/15 - LFS T&W Protection with Cosmetic          | Platinum (TW)               | 36   | SGIFTEST8  | SGILTEST8  | Testing8       | Testing8  | NJ    | 11111 | 9898989898 | 1C3CDFAA0GD577923 | DODGE         | DART        | 2016     |
  #| 9     | LEXUS  | LEX646301 | tlc1234  | LEX64630 | LXPU 1/15 - LFS T&W Protection with Cosmetic          | Platinum Plus (TW, PDR, WS) | 12   | SGIFTEST9  | SGILTEST9  | Testing9       | Testing9  | WA    | 11111 | 9898989898 | JTHBE1D2XE5004741 | LEXUS         | IS 350      | 2014     |
  #| 10    | LEXUS  | LEX609151 | tlc1234  | LEX60915 | LXTW 1/15 - LFS T&W Protection Non-Cosmetic (TW Only) | Platinum (TW)               | 48   | SGIFTEST10 | SGILTEST10 | Testing10      | Testing10 | FL    | 11111 | 9898989898 | WP0AB2A82EK193004 | PORSCHE       | CAYMAN      | 2014     |
  #| 11    | CCC    | CCC199511 | tlc1234  | CCC19951 | CCPU 1/15 - CCC T&W Protection with Cosmetic          | Platinum Plus (TW, PDR, WS) | 36   | SGIFTEST11 | SGILTEST11 | Testing11      | Testing11 | OH    | 11111 | 9898989898 | JTHKD5BH8E2182750 | LEXUS         | CT 200H     | 2014     |
  #| 12    | CCC    | CCC209261 | tlc1234  | CCC20926 | CCPU 1/15 - CCC T&W Protection with Cosmetic          | Platinum (TW)               | 12   | SGIFTEST12 | SGILTEST12 | Testing12      | Testing12 | MA    | 11111 | 9898989898 | WDDGF4HB0DA857693 | MERCEDES-BENZ | C250        | 2013     |
  #| 13    | CCC    | CCC319091 | tlc1234  | CCC31909 | CCPU 1/15 - CCC T&W Protection with Cosmetic          | Platinum (TW)               | 48   | SGIFTEST13 | SGILTEST13 | Testing13      | Testing13 | CT    | 11111 | 9898989898 | 5J8TB4H36GL023063 | ACURA         | RDX         | 2016     |
  #| 14    | CCC    | CCC319091 | tlc1234  | CCC31909 | CCPU 1/15 - CCC T&W Protection with Cosmetic          | Platinum (TW)               | 24   | SGIFTEST14 | SGILTEST14 | Testing14      | Testing14 | WA    | 11111 | 9898989898 | 1G6DW67V490159317 | CADILLAC      | STS         | 2009     |
  #| 15    | CCC    | CCC159161 | tlc1234  | CCC15916 | CCUV 1/15 - CCC T&W Protection Non-Cosmetic           | Platinum (TW)               | 60   | SGIFTEST15 | SGILTEST15 | Testing15      | Testing15 | FL    | 11111 | 9898989898 | 5FNYF18208B050407 | HONDA         | PILOT       | 2008     |
  @LegacyToyotaCancellationQuote
  Scenario Outline: Cancellation Quote
    Given Go to Toyota Url for Cancellation Quote as "<RowNo>" and "<Portal>" and "<UserName>" and "<Password>" and "<Dealer>" and "<FirstName>" and "<LastName>" and "<VinNo>" and "<Can_Date>" and "<Cust_Cost>" and "<Exp_Factor>" and "<Exp_CancellationFee>" and "<Exp_CustomerRefund>" and "<AgreementNumber>"
    And Click on Toyota Log in Link for Cancellation Quote
    And Login with Toyota UserName and Password for Cancellation Quote
    And Click on Toyota Cancellation Quote Tab
    And Fill Toyota Customer Search Form
    When Verify Toyota Factor Cancellation Fee and Customer Refund
    Then Log Out From Toyota Portal for Cancellation Quote

    Examples: 
      | RowNo | Portal | UserName  | Password | Dealer   | FirstName | LastName | VinNo             | Can_Date   | Cust_Cost | Exp_Factor | Exp_CancellationFee | Exp_CustomerRefund | AgreementNumber |
      # | 1     | TOYOTA | TOY450421 | tlc1234  | TOY45042 | TEST      | TEST     |                   | 2016-04-15 |           | 0.33942    | $25.00              | $178.31            | 0016424810      |
      # | 2     | TOYOTA | TOY450421 | tlc1234  | TOY45042 |           |          | JTKKUPB44D1038460 | 2016-04-15 |           | 0.33942    | $25.00              | $178.31            | 0016424810      |
      # | 3     | LEXUS  | LEX606011 | tlc1234  | LEX60601 |           |          | JTHCE1BL3D5018950 | 2016-04-15 |           | 0.53067    | $25.00              | $611.27            | 0015279448      |
      |     4 | CCC    | CCC159161 | tlc1234  | CCC15916 |           |          | 2GNALBEK3F6383666 | 2016-04-15 |           |    0.88998 | $25.00              | $664.73            |      0015279448 |
