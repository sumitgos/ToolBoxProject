#Feature: GoodsinTransitDetails page test
#  Background: Step to Launch the URL in Browser
#    Given MultiCoverDetails Launch browser
#    When MultiCoverDetails Launch URL "https://uat.toolboxbyadmiral.com/goods-in-transit"
#
#  @GoodsinTransit
#  Scenario Outline: Check the MultiCoverDetails page
#    When MultiCoverDetails Click on close all button in Privacy Policy Popup
#    Then Select "<Profession>" Optiontest
#    Then Select Employees Option
#    Then Select Certification Option
#    And Select Certification CoverButton
#    Then Select AdditionalCover Option
#    Then Select NextPage Button
#    Then Select "<Trades>" Option
#    And Select NextPagetest Button
#		#And Close Browser
#    Examples:
#      | Profession | Trades|
#      |Acting (Performer actor actress) | Civil Engineering|
#      | Acupuncture | Teaching|


Feature: GoodsinTransitDetails page test

  Background: Step to Launch the URL in Browser
    Given GoodsinTransit Launch Browser and URL "https://uat.toolboxbyadmiral.com/goods-in-transit"

  @Goods_in_TransitWithExcel
  Scenario: GoodsinTransit Sanity
    When GoodsinTransit Click on Accept All button in cookies popup
    And GoodsinTransit Process cj controls

  @GoodsinTransit
  Scenario: Title of your scenario outline
    When GoodsinTransit Click on Accept All button in cookies popup
    When GoodsinTransit Execute Userinfo Page
      | GetQuote | What's your current occupation? | How many years of experience do you have? | NextPage_Dy1 | How do you want to pay? | Do you own a car or van? | How much cover do you need? | GetInsured_Dy1 | We just need some details about you.First Name | We just need some details about you.Last Name | NextPage_Dy2 | What’s your home address?| What’s your home FindAddress? | What’s your home SelectAddress? |Select Manual Address|Select Manual AddressLine1|Select Manual houseNameOrNumber|Select Manual Town and city|Select Manual postcode| NextPage_Dy3 | What’s your business Mobile Number? | We just need some details about you.DateBirth | What’s your business email address? | What’s your business confirm email address? | I agree to the T&Cs and Privacy Policy |marketing from Toolbox| NextPage_Dy4 |
      | TRUE                 | Parcel Delivery                          | 2 - 3 years                           | TRUE         | Annually                  | Van                       | £15,000                            | TRUE                       | admiral                   | Indian                | TRUE         |SA112JL      | TRUE                                        | TRUE                                 |Skip                 |Skip                      |Skip                           |Skip                       |Skip                  |TRUE          |7950438000                           |19/06/1983                                     |admiralindian@gmail.com             |admiralindian@gmail.com                     |TRUE                                      |   Skip                 |TRUE          |

    And GoodsinTransit Fill Insurance Info and Claim Info Details
      | Bankruptcy | Past Insurance | Criminal records | Health & safety records |County Court Judgement (CCJ)| NextPage_Dy5 | Does any of your work take place outside of the United Kingdom? | NextPage_Dy6 | Have you had any claims, losses or incidents in the past 3 years relating to this type of insurance, whether you claimed or not?|Is the claim still open?|What was the date of loss?|What type of insurance was the claim connected to?|What was the reason for the claim?|What are the estimated costs?|Add an other Claim | NextPage_Dy7 | What best describes your employment status? | NextPage_Dy8 | Do you have a trading or company name?|Do you have a limited company name? | NextPage_Dy9|
      | No                                        | No                                        | No                                   | No         | No | TRUE | No | TRUE | No                                                                                                                                                                  |Skip                    |Skip                      |Skip                                              |Skip                              |Skip                         |Skip| TRUE   | Working for a company                                           | TRUE          | No                                                                        |Skip                                                                                                     | TRUE         |
    And GoodsinTransit Fill Business Info Address Details
      | What’s the vehicle registration | What’s your vehicles Address? |Add Vehicle| NextPage_Dy10 | NextPage_Dy11 | NextPage_Dy12 | NextPage_Dy13 |
      | CU05GME                  | TRUE                                 |Skip                 |    TRUE         | TRUE                  | TRUE                       | TRUE                            |

    And GoodsinTransit Fill Payment Details Page Info
      | I confirm I have read the above information | Click Continue To Payment | Please Enter Account Holder Name Info | Please Enter Account Sort Code | AccountNumberNameInfo | ConfirmPage | PayCardNumber       | PayCardHolderName | Card ExpiryDateMonth | PayCardExpireSplitYear | CardSecurityCode | CardHolderHouseNumber | PayCardHolder |CardHolderAddressLine1| CardHolderPostcode | ProposerIsCardHolder | CardAutoReuseConsent | nextbtn |
      | TRUE                                        | TRUE                      | Skip                              | Skip                         | Skip              | Skip        | 4444 3333 2222 1111 | Joe Boe           | 05                   | 2025                   | 123              | Joe                   | Boe           | Boe | SA11 2JL           | TRUE                 | TRUE                 | TRUE    |

#    When I check for the <value> in step
    Then GoodsinTransit Publish reports


