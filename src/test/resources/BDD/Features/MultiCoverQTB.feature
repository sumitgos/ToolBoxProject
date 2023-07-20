#
#Feature: MultiCoverDetails page test
#
#
#Background: Step to Launch the URL in Browser
#Given MultiCoverDetails Launch browser
#When MultiCoverDetails Launch URL "https://dev2.qtb.toolboxbyadmiral.com/quote/multicover"
#
#@MultiCoverQTBExcel
#  Scenario Outline: Check the MultiCoverDetails page
#    When MultiCoverDetails Click on close all button in Privacy Policy Popup
#    Then Select Profession value from excel sheet "<SheetName>" and "<RowNumber>"
#    Then Select Employees Option
#    Then Select Certification Option
#    And Select Certification CoverButton
#    Then Select AdditionalCover Option
#    Then Select NextPage Button
#     Then Select Trades value from excel sheet "<SheetName>" and "<RowNumber>"
#    And Select NextPagetest Button
#		#And Close Browser
#    Examples:
#      | SheetName | RowNumber|
#      | MultiCover  	| 0|
#      | MultiCover | 1|


Feature: MultiCoverDetails page test

  #Background: Step to Launch the URL in Browser

  @Multi_CoverExcel
  Scenario: MultiCover Sanity
    Given MultiCover Launch Browser and URL "https://dev2.qtb.toolboxbyadmiral.com/quote/multicover/48fdfb6435e0"
    When MultiCover Click on Accept All button in cookies popup
    And MultiCover Process cj controls

  @MultiCover
  Scenario: Title of your scenario outline
    Given MultiCover Launch Browser and URL "https://dev2.qtb.toolboxbyadmiral.com/quote/multicover/48fdfb6435e0"
    When MultiCover Click on Accept All button in cookies popup
    When MultiCover Execute Userinfo Page
      | GetQuote | What is your main trade or profession? | Does your business have any employees? | How many employees does your business have? | Do you offer certification, advice, or design in your work? | NextPage_Dy1 | Select additional cover | NextPage_Dy2 | What best describes your business? | NextPage_Dy3 | What best describes your business | NextPage_Dy4| What year was your business established | How many years of working experience do you have ? | NextPage_Dy5 | Bankruptcy | Past Insurance | Criminal records | Health & safety records | NextPage_Dy6 | Have you had any claims, losses or incidents in the past 3 years | NextPage_Dy7|First name|Surname|NextPage_Dy8|What’s your home address?|What’s your home FindAddress?|What’s your home SelectAddress?|Select Manual Address|Select Manual AddressLine1|Select Manual houseNameOrNumber|Select Manual addressLine3|Select Manual postcode|NextPage_Dy9|
      | Skip                 | Parcel Delivery                          | No                           | Skip         | No                  | TRUE                       | Skip                           | TRUE                       | Skip                   | TRUE                | Sole Trader         |TRUE      | 2018                                        | 1 - 2 years                                        |TRUE          |No                           |No                                    |No             |No                    |TRUE                                    |No          | TRUE                                                     |joy       |joy    |TRUE        |CF104BZ                  |TRUE                         |TRUE                           |Skip                 |Skip                      |Skip                           |Skip                      |Skip                  |TRUE        |

    And MultiCover Fill Insurance Info and other Info Details
      | What’s your business Mobile Number? | What is your date of birth? | What’s your business email address? | What’s your business confirm email address? |I agree to the T&Cs and Privacy Policy| marketing from Toolbox | NextPage_Dy10 | Do you have a trading or company name | What is your trading name | NextPage_Dy11 | Do you have any parent or subsidiary companies? | Is your parent or subsidiary company covered under this policy? | What is the name of your parent or subsidiary company? | NextPage_Dy12|NextPage_Dy13|Select the level of Public Liability cover you require|Does any of your work take place outside the United Kingdom|NextPage_Dy14|Turnover is your total business income taken in a particular period|NextPage_Dy15|Do you have a separate dedicated business premises|NextPage_Dy16|Do you undertake 3-phase electrical work?|Is any gas fitting or installation work undertaken?|NextPage_Dy17|NexDo you use any form of heat equipment such as an Angle Grinder.|NextPage_Dy18|Do you or any employee in your business ever work at height?|What is the maximum depth? at which work is undertaken?|Do you or any employee in your business ever work below ground level?|What is the maximum height worked at?|NextPage_Dy19|Does your work involve any discharge of fumes, effluent or anything of a noxious nature?|Does your work involve the use of substances which could be harmful to health?|NextPage_Dy20|NextPage_Dy21|
      | 7950438000                                        | 04/02/1991                                        | joe.tester.smb@gmail.com                                   | joe.tester.smb@gmail.com         | TRUE | Skip | TRUE | No | Skip |TRUE                                                                              | No   | Skip                                          | Skip          | TRUE                                                                                                                |TRUE  | £5 million  |No  | TRUE                                                                                                                                                                                                                                                                                         |60000        |TRUE                                                               |No           |TRUE                                              |No           |No                                       |TRUE                                               |No           |TRUE              |No                                                |Skip      |No                                     |Skip                                                       |TRUE                                 |No           |No                                                                                      |True |Skip         |
    And MultiCover Fill Business Info Address Details
      | How many of your company's employees perform administrative tasks or non-manual work? | How many employees perform manual work? | How many employees perform administrative tasks or non-manual work? | NextPage_Dy22 | How many labour-only subcontractors do you have at any given time? | How many bona fide subcontractors do you have at any given time? |NextPage_Dy23|Are all your employees paid below the PAYE threshold|NextPage_Dy24|NextPage_Dy25|Do you currently hold a Professional Indemnity policy, with a retroactive date|What is your retroactive date|NextPage_Dy26|What level of Professional Indemnity cover do you require|NextPage_Dy27|Do you undertake any structural, computer software or computer hardware design work|NextPage_Dy28|Do you undertake any property management?|Do you give any taxation advice?|NextPage_Dy29|Do one or more of the business partners|NextPage_Dy30|NextPage_Dy31|How much will the maximum value of any of your contracts be worth?|What limit of indemnity do you require?|NextPage_Dy32|NextPage_Dy33|What level of cover do you require?|What is your estimated annual cost for hired in plant?|NextPage_Dy34|NextPage_Dy35|What level of cover do you require for Own  plant?|What is your estimated annual cost for Own  plant ?|NextPage_Dy36|You can choose any date within the next 30 days|Renewal|Billing|NextPage_Dy37|How do you want to pay?|NextPage_Dy38|
      | Skip                 | Skip                          |    Skip           | Skip                  | Skip                       | Skip                            |Skip                                                                                                                                                                                                         |Skip                                                  |Skip         |Skip         |Skip                                                                            |Skip                         |Skip         |Skip                                                |Skip         |Skip                                                                                 |Skip         |Skip                                       |Skip                              |Skip         |Skip                                     |Skip         |Skip         |Skip                                                             |Skip                                  |Skip         |Skip         |Skip                              |Skip                                                 |Skip         |Skip         |Skip                                             |Skip                                              |Skip         |Skip                                          |Skip   |Skip   |TRUE         |Monthly              |TRUE         |

    And MultiCover Fill Payment Details Page Info
      | I confirm I have read the above information | Click Continue To Payment | Please Enter Account Holder Name Info | Please Enter Account Sort Code | AccountNumberNameInfo | ConfirmPage | PayCardNumber       | PayCardHolderName | Card ExpiryDateMonth | PayCardExpireSplitYear | CardSecurityCode | CardHolderHouseNumber | PayCardHolder |CardHolderAddressLine1| CardHolderPostcode | ProposerIsCardHolder | CardAutoReuseConsent | nextbtn |
      | TRUE                                        | TRUE                      | Skip                               | Skip                         | Skip              | Skip        | 4444 3333 2222 1111 | Joe Boe           | 05                   | 2025                   | 123              | Joe                   | Boe           | Boe | SA11 2JL           | TRUE                 | TRUE                 | TRUE    |


    #    When I check for the <value> in step
    Then MultiCover Publish reports

  @MultiCoverApi
  Scenario: MultiCover Api testing
    Given MultiCover Testing the Price check Api