package Covers.ToolInsurance;

import Covers.GetElement;
import org.javatuples.*;
import org.openqa.selenium.WebDriver;

import java.util.*;

public class ToolInsuranceDetails {
    public WebDriver _driver;

    public Map<String, Quartet<String, String, String, String>> controlInfo = new HashMap<>(Map.ofEntries(
            Map.entry("GetQuote", new Quartet<>("Button", "XPath", "//*[contains(@Class,'styles__Typography-sc') and @mode and (text()='Get a quote ')]", "5000")),
            Map.entry("Do you own a car or van?", new Quartet<>("Label", "XPath", "//span[text()='<Dy>']", "1000")),
            Map.entry("How much cover do you need?", new Quartet<>("SpecialComboBox", "XPath", "//*[contains(@Class,' css-1l5jahr-container')]", "1000")),
            Map.entry("Do you want pro or classic cover?", new Quartet<>("Label", "XPath", "//span[text()='<Dy>']", "1000")),
            Map.entry("How do you want to pay?", new Quartet<>("Label", "XPath", "//span[text()='<Dy>']", "1000")),
            Map.entry("NextPage_Dy1", new Quartet<>("Button", "XPath", "//span[text()='Next']", "4000")),
            Map.entry("We just need some details about you.First Name", new Quartet<>("TextBox", "XPath", "//input[@placeholder='First name']", "1000")),
            Map.entry("We just need some details about you.Last Name", new Quartet<>("TextBox", "XPath", "//input[@placeholder='Last name']", "2000")),
            Map.entry("We just need some details about you.DateBirth", new Quartet<>("SpecialTextBox", "XPath", "//*[contains(@Class,'styles__Input') and @spellcheck]", "1000")),
            Map.entry("NextPage_Dy2", new Quartet<>("Button", "XPath", "//span[text()='Next']", "6000")),
            Map.entry("What’s your home address?", new Quartet<>("TextBox", "XPath", "//input[@name='postcode']", "1000")),
            Map.entry("What’s your home FindAddress?", new Quartet<>("Button", "XPath", "//span[text()='Find address']", "6000")),
            Map.entry("What’s your home SelectAddress?", new Quartet<>("Button", "XPath", "(//div[text()='Select'])[1]", "3000")),
            Map.entry("Select Manual Address", new Quartet<>("Button", "XPath", "//span[text()='Enter address manually']", "1000")),
            Map.entry("Select Manual AddressLine1", new Quartet<>("TextBox", "XPath", "//input[@name='addressLine1']", "1000")),
            Map.entry("Select Manual houseNameOrNumber", new Quartet<>("TextBox", "XPath", "//input[@name='houseNameOrNumber']", "1000")),
            Map.entry("Select Manual Town and city", new Quartet<>("TextBox", "XPath", "//input[@name='addressLine3']", "1000")),
            Map.entry("Select Manual postcode", new Quartet<>("TextBox", "XPath", "//input[@name='postcode']", "1000")),
            Map.entry("NextPage_Dy3", new Quartet<>("Button", "XPath", "//span[text()='Next']", "3000")),
            Map.entry("NextPage", new Quartet<>("Button", "XPath", "//span[text()='Next']", "6000")),
            Map.entry("What’s your current occupation?", new Quartet<>("TextBox", "XPath", "//input[contains(@id,'react-select')]", "3000")),
            Map.entry("NextPage_Dy4", new Quartet<>("Button", "XPath", "//span[text()='Next']", "4000")),
            Map.entry("What’s your business email address?", new Quartet<>("TextBox", "XPath", "//input[@placeholder='Enter your email address']", "1000")),
            Map.entry("What’s your business confirm email address?", new Quartet<>("SpecialTextBox", "XPath", "//input[@placeholder='Confirm email address']", "1000")),
            Map.entry("What’s your business Mobile Number?", new Quartet<>("TextBox", "XPath", "//input[@placeholder='Enter mobile number' and contains(@class,'styles__Input')]", "1000")),
            Map.entry("I agree to the T&Cs and Privacy Policy", new Quartet<>("CheckBox", "XPath", "(//*[contains(@class,'styles__Input')])[4]", "1000")),
            Map.entry("marketing fromToolbox", new Quartet<>("CheckBox", "XPath", "(//*[contains(@class,'styles__Input')])[5]", "1000")),
            Map.entry("NextPage_Dy5", new Quartet<>("Button", "XPath", "//span[text()='Next']", "10000")),
            Map.entry("What is your employment status?", new Quartet<>("RadioButton", "XPath", "//span[text()='<Dy>']", "1000")),
            Map.entry("NextPage_Dy6", new Quartet<>("Button", "XPath", "//span[text()='Next']", "6000")),
            Map.entry("EmploymentStatus", new Quartet<>("RadioButton", "XPath", "//span[text()='<Dy>']", "1000")),
            Map.entry("NextPage_Dy7", new Quartet<>("Button", "XPath", "//span[text()='Next']", "6000")),
            Map.entry("Do you have a trading or limited company name?", new Quartet<>("RadioButton", "XPath", "//span[text()='<Dy>']", "1000")),
            Map.entry("Do you have a limited company name?", new Quartet<>("TextBox", "XPath", "//input[@placeholder='Your company name']", "1000")),
            Map.entry("NextPage_Dy8", new Quartet<>("Button", "XPath", "//span[text()='Next']", "14000")),
            Map.entry("Do you have a Past Insurance No?", new Quartet<>("RadioButton", "XPath", "(//span[text()='<Dy>'])[1]","1000")),
            Map.entry("County Court Judgement (CCJ)", new Quartet<>("RadioButton", "XPath", "(//span[text()='<Dy>'])[2]","1000")),
            Map.entry("Bankruptcy",  new Quartet<>("RadioButton", "XPath", "(//span[text()='<Dy>'])[3]","1000")),
            Map.entry("Unspent convictions", new Quartet<>("RadioButton", "XPath", "(//span[text()='<Dy>'])[4]","1000")),
            Map.entry("NextPage_Dy9", new Quartet<>("Button", "XPath", "//span[text()='Next']", "6000")),
            Map.entry("What’s the vehicle registration", new Quartet<>("TextBox", "XPath", "//input[@name='vrn']", "1000")),
            Map.entry("What’s the vehicle registration and FindVan", new Quartet<>("Button", "XPath", "//span[text()='Find Van']", "5000")),
            Map.entry("NextPage_Dy10", new Quartet<>("Button", "XPath", "//span[text()='Next']", "6000")),
            Map.entry("When do you want to start the cover?", new Quartet<>("SpecialTextBox", "XPath", "//*[contains(@Class,'styles__Input') and @spellcheck]", "2000")),
            Map.entry("Auto Renew", new Quartet<>("RadioButton", "XPath", "//span[text()='Auto Renew']", "1000")),
            Map.entry("NextPage_Dy11", new Quartet<>("Button", "XPath", "//span[text()='Next']", "9000")),
            Map.entry("NextPage_Dy12", new Quartet<>("Button", "XPath", "//span[text()='Next Step']", "9000")),
            Map.entry("NextPage_Dy13", new Quartet<>("Button", "XPath", "//span[text()='Next Step']", "9000")),
            Map.entry("I confirm I have read the above information", new Quartet<>("CheckBox", "XPath", "(//*[contains(@class,'styles__Input')])[2]", "1000")),
            Map.entry("Click Continue To Payment", new Quartet<>("Button", "XPath", "//span[text()='Continue to payment']", "10000")),
            Map.entry("Please Enter Account Holder Name Info", new Quartet<>("TextBox", "XPath", "//input[@name='accountHoldername']", "1000")),
            Map.entry("Please Enter Account Sort Code", new Quartet<>("TextBox", "XPath", "//input[@name='accountSortcode']", "1000")),
            Map.entry("AccountNumberNameInfo", new Quartet<>("TextBox", "XPath", "//input[@name='accountNumber']", "1000")),
            Map.entry("ConfirmPage", new Quartet<>("Button", "XPath", "//span[text()='Confirm']", "10000")),
            Map.entry("NextPage_14", new Quartet<>("Button", "XPath", "//span[text()='Next']", "7000")),
            Map.entry("PayCardNumber", new Quartet<>("TextBox", "XPath", "//input[@id='PayCardNumber']", "1000")),
            Map.entry("PayCardHolderName", new Quartet<>("TextBox", "XPath", "//input[@id='PayCardHolder']", "1000")),
            Map.entry("Card ExpiryDateMonth", new Quartet<>("ComboBox", "XPath", "//select[@id='PayCardExpireSplitMM']", "1000")),
            Map.entry("PayCardExpireSplitYear", new Quartet<>("ComboBox", "XPath", "//select[@id='PayCardExpireSplitYY']", "1000")),
            Map.entry("CardSecurityCode", new Quartet<>("TextBox", "XPath", "//input[@id='CardSecurityCode']", "1000")),
            Map.entry("CardHolderHouseNumber", new Quartet<>("TextBox", "XPath", "//Input[@id='CardHolderHouseNumber']", "1000")),
            Map.entry("CardHolderAddressLine1",new Quartet<>("TextBox", "XPath", "//Input[@id='CardHolderAddressLine1']", "1000")),
            Map.entry("PayCardHolder",new Quartet<>("TextBox", "XPath", "//input[@id='PayCardHolder']", "1000")),
            Map.entry("CardHolderPostcode",new Quartet<>("TextBox", "XPath", "//Input[@id='CardHolderPostcode']", "1000")),
            Map.entry("PayCardExpire", new Quartet<>("ComboBox", "XPath", "//select[@id='PayCardExpireSplitMM']", "1000")),
            Map.entry("ProposerIsCardHolder", new Quartet<>("RadioButton", "XPath", "//input[@id='ProposerIsCardHolderY']", "1000")),
            Map.entry("CardAutoReuseConsent", new Quartet<>("RadioButton", "XPath", "//input[@id='CardAutoReuseConsentN']", "1000")),
            Map.entry("nextbtn", new Quartet<>("Button", "XPath", "//button[@class='next btn btn-primary']", "10000"))
    ));

    public ToolInsuranceDetails(WebDriver driver) {
        this._driver = driver;
    }

    public String AssignControl(String controlType, String controlIdentification, String controlIdentificationValue, String controlValue) {
        String elementStatus = "";
        try {
            GetElement objGetElement = new GetElement();
            elementStatus = objGetElement.GetActionElement(_driver, controlType, controlIdentification, controlIdentificationValue.replace("<Dy>",controlValue), controlValue);

            objGetElement = null;

            return elementStatus;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return "Fail";
        }
    }

    public void PerformApi()
    {
        try {

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
