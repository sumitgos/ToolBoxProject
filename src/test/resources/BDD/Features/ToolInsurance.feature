Feature: ToolInsuranceDetails page test

  @Tool_Insurance_Excel
  Scenario: ToolInsuranceDetails Sanity
    Given Launch Browser and URL "https://uat.toolboxbyadmiral.com/tool-insurance"
    When Click on Accept All button in cookies popup
    And Process cj controls

  @ToolInsurance
  Scenario: Title of your scenario outline
    Given Launch Browser and URL "https://uat.toolboxbyadmiral.com/tool-insurance"
    When Click on Accept All button in cookies popup
    When Execute Info Page
      |GetQuote | Do you own a car or van? | How much cover do you need? | Do you want pro or classic cover? | How do you want to pay? | NextPage_Dy1 |
      |TRUE | Van                     | £15,000                     | Classic                              | Annually                    | TRUE         |
    And Fill Personal Details
      | We just need some details about you.First Name | We just need some details about you.Last Name | We just need some details about you.DateBirth | NextPage_Dy2 |
      | admiral                                        | Indian                                        | 19/06/1983                                    | TRUE         |
    And Fill Home Address Details
      | What’s your home address? | What’s your home FindAddress? | What’s your home SelectAddress? |Select Manual Address |Select Manual AddressLine1|Select Manual houseNameOrNumber|Select Manual Town and city|Select Manual postcode| NextPage_Dy3 |   What’s your current occupation? | NextPage_Dy4 |
      | SA112JL                   | TRUE                          | TRUE                            | Skip         | Skip                  | Skip                       | Skip                            | Skip                       | TRUE                   | Mechanic Mobile                 | TRUE         |
    And Fill Business Address Page Details
      | What’s your business email address? | What’s your business confirm email address? | What’s your business Mobile Number? | I agree to the T&Cs and Privacy Policy | marketing fromToolbox | NextPage_Dy5 | What is your employment status? | NextPage_Dy6 | EmploymentStatus | NextPage_Dy7 |
      | admiralindian@gmail.com             | admiralindian@gmail.com                     | 4474 289007                         | TRUE                                   | Skip                  | TRUE         | I’m employed                            | TRUE         | Skip             | Skip         |
    And Fill Employee Info Page Details
      | Do you have a trading or limited company name?|Do you have a limited company name? | NextPage_Dy8 | Do you have a Past Insurance No? | County Court Judgement (CCJ) | Bankruptcy | Unspent convictions | NextPage_Dy9 | What’s the vehicle registration | What’s the vehicle registration and FindVan | NextPage_Dy10 | When do you want to start the cover? | Auto Renew | NextPage_Dy11 | NextPage_Dy12 | NextPage_Dy13 |
      | No                                            |Skip | TRUE         | No                             | No                         | No       | No                | TRUE         | CU05GME                         | TRUE                                        | TRUE          | TRUE                                 | Skip  | TRUE          | TRUE          | TRUE          |
    And Fill Payment Details Page Info
      | I confirm I have read the above information | Click Continue To Payment | Please Enter Account Holder Name Info | Please Enter Account Sort Code | AccountNumberNameInfo | ConfirmPage | PayCardNumber       | PayCardHolderName | Card ExpiryDateMonth | PayCardExpireSplitYear | CardSecurityCode | CardHolderHouseNumber | PayCardHolder |CardHolderAddressLine1| CardHolderPostcode | ProposerIsCardHolder | CardAutoReuseConsent | nextbtn |
      | TRUE                                        | TRUE                      | Skip                              | Skip                         | Skip              | Skip        | 4444 3333 2222 1111 | Joe Boe           | 05                   | 2025                   | 123              | Joe                   | Boe           | Boe | SA11 2JL           | TRUE                 | TRUE                 | TRUE    |

    Then Publish reports

  @ToolInsuranceApi
  Scenario: Api testing
  Given Testing the Price check Api

  #@tag2
  #Scenario Outline: Title of your scenario outline
    #Given I want to write a step with <name>
    #When I check for the <value> in step
    #Then I verify the <status> in step
#
    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
